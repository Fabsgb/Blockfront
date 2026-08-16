package foundry.veil.api.client.render.framebuffer;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import foundry.veil.Veil;
import foundry.veil.api.CodecReloadListener;
import foundry.veil.api.client.render.ext.VeilDebug;
import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangRuntime;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.ResourceLocationException;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/framebuffer/FramebufferManager.class */
public class FramebufferManager extends CodecReloadListener<FramebufferDefinition> implements NativeResource {
    private static final ResourceLocation MAIN = ResourceLocation.withDefaultNamespace("main");
    public static final Codec<ResourceLocation> FRAMEBUFFER_CODEC = Codec.STRING.comapFlatMap(name -> {
        try {
            if (!name.contains(":")) {
                ResourceLocation id = ResourceLocation.tryBuild("temp", name);
                return id != null ? DataResult.success(id) : DataResult.error(() -> {
                    return "Invalid path: " + name;
                });
            }
            ResourceLocation id2 = ResourceLocation.tryParse(name);
            return id2 != null ? DataResult.success(id2) : DataResult.error(() -> {
                return "Invalid path: " + name;
            });
        } catch (ResourceLocationException e) {
            return DataResult.error(() -> {
                return "Not a valid resource location: " + name + ". " + e.getMessage();
            });
        }
    }, location -> {
        return "temp".equals(location.getNamespace()) ? location.getPath() : location.toString();
    }).stable();
    public static final FileToIdConverter FRAMEBUFFER_LISTER = FileToIdConverter.json("pinwheel/framebuffers");
    private final Map<ResourceLocation, FramebufferDefinition> framebufferDefinitions;
    private final Map<ResourceLocation, AdvancedFbo> framebuffers;
    private final Map<ResourceLocation, AdvancedFbo> framebuffersView;
    private final Set<ResourceLocation> screenFramebuffers;
    private final Set<ResourceLocation> manualFramebuffers;

    public FramebufferManager() {
        super(FramebufferDefinition.CODEC, FRAMEBUFFER_LISTER);
        this.framebufferDefinitions = new HashMap();
        this.framebuffers = new Object2ObjectArrayMap();
        this.framebuffersView = Collections.unmodifiableMap(this.framebuffers);
        this.screenFramebuffers = new ObjectArraySet();
        this.manualFramebuffers = new ObjectArraySet();
    }

    private void initFramebuffer(ResourceLocation name, FramebufferDefinition definition, MolangEnvironment runtime) {
        try {
            AdvancedFbo fbo = definition.createBuilder(runtime).setDebugLabel(name.toString()).build(true);
            fbo.clear();
            AdvancedFbo old = this.framebuffers.put(name, fbo);
            VeilDebug.get().objectLabel(36160, fbo.getId(), "Framebuffer " + String.valueOf(name));
            if (old != null) {
                old.free();
            }
            if (!definition.autoClear()) {
                this.manualFramebuffers.add(name);
            } else {
                this.manualFramebuffers.remove(name);
            }
        } catch (Exception e) {
            Veil.LOGGER.error("Failed to initialize framebuffer: {}", name, e);
        }
    }

    @ApiStatus.Internal
    public void resizeFramebuffers(int width, int height) {
        MolangRuntime runtime = (MolangRuntime) MolangRuntime.runtime().setQuery("screen_width", width).setQuery("screen_height", height).create();
        for (ResourceLocation name : this.screenFramebuffers) {
            FramebufferDefinition definition = this.framebufferDefinitions.get(name);
            if (definition != null) {
                initFramebuffer(name, definition, runtime);
            }
        }
    }

    @ApiStatus.Internal
    public void clear() {
        if (this.framebuffers.size() == this.manualFramebuffers.size()) {
            return;
        }
        VeilDebug debug = VeilDebug.get();
        debug.pushDebugGroup("Veil Clear Framebuffers");
        this.framebuffers.forEach((name, fbo) -> {
            if (!this.manualFramebuffers.contains(name)) {
                fbo.clear();
            }
        });
        debug.popDebugGroup();
    }

    public void setDefinition(ResourceLocation name, FramebufferDefinition definition) {
        Window window = Minecraft.getInstance().getWindow();
        MolangRuntime runtime = (MolangRuntime) MolangRuntime.runtime().setQuery("screen_width", window.getWidth()).setQuery("screen_height", window.getHeight()).create();
        RenderSystem.clearColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.framebufferDefinitions.put(name, definition);
        initFramebuffer(name, definition, runtime);
        if (!definition.width().isConstant() || !definition.height().isConstant()) {
            this.screenFramebuffers.add(name);
        } else {
            this.screenFramebuffers.remove(name);
        }
        AdvancedFbo.unbind();
    }

    public void setFramebuffer(ResourceLocation name, AdvancedFbo fbo) {
        AdvancedFbo oldBuffer;
        if (this.manualFramebuffers.add(name) && (oldBuffer = this.framebuffers.remove(name)) != null) {
            oldBuffer.free();
            Veil.LOGGER.warn("Replaced defined framebuffer {} with manual buffer", name);
        }
        this.framebuffers.put(name, fbo);
        VeilDebug.get().objectLabel(36160, fbo.getId(), "Framebuffer " + String.valueOf(name));
    }

    @Nullable
    public AdvancedFbo removeFramebuffer(ResourceLocation name) {
        if (this.manualFramebuffers.remove(name)) {
            return this.framebuffers.remove(name);
        }
        return null;
    }

    @Nullable
    public AdvancedFbo getFramebuffer(ResourceLocation name) {
        return this.framebuffers.get(name);
    }

    @Nullable
    public FramebufferDefinition getFramebufferDefinition(ResourceLocation name) {
        return this.framebufferDefinitions.get(name);
    }

    public Map<ResourceLocation, AdvancedFbo> getFramebuffers() {
        return this.framebuffersView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apply(@NotNull Map<ResourceLocation, FramebufferDefinition> data, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.framebufferDefinitions.clear();
        this.framebufferDefinitions.putAll(data);
        Veil.LOGGER.info("Loaded {} framebuffers", Integer.valueOf(this.framebufferDefinitions.size()));
        free();
        Window window = Minecraft.getInstance().getWindow();
        MolangRuntime runtime = (MolangRuntime) MolangRuntime.runtime().setQuery("screen_width", window.getWidth()).setQuery("screen_height", window.getHeight()).create();
        this.framebufferDefinitions.forEach((name, definition) -> {
            initFramebuffer(name, definition, runtime);
            if (!definition.width().isConstant() || !definition.height().isConstant()) {
                this.screenFramebuffers.add(name);
            }
        });
        setFramebuffer(MAIN, AdvancedFbo.getMainFramebuffer());
    }

    public void free() {
        this.framebuffers.keySet().removeAll(this.manualFramebuffers);
        this.framebuffers.values().forEach((v0) -> {
            v0.free();
        });
        this.framebuffers.clear();
        this.manualFramebuffers.clear();
        this.screenFramebuffers.clear();
    }
}
