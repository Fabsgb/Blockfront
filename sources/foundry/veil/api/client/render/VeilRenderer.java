package foundry.veil.api.client.render;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.Veil;
import foundry.veil.api.client.editor.EditorManager;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.framebuffer.FramebufferManager;
import foundry.veil.api.client.render.light.renderer.LightRenderer;
import foundry.veil.api.client.render.post.PostProcessingManager;
import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.client.render.shader.ShaderModificationManager;
import foundry.veil.api.client.render.shader.ShaderPreDefinitions;
import foundry.veil.api.flare.FlareEffectManager;
import foundry.veil.api.quasar.particle.ParticleSystemManager;
import foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferManager;
import foundry.veil.impl.client.render.dynamicbuffer.VanillaShaderCompiler;
import foundry.veil.impl.client.render.pipeline.VeilBloomRenderer;
import foundry.veil.impl.client.render.pipeline.VeilFirstPersonRenderer;
import foundry.veil.impl.client.render.rendertype.DynamicRenderTypeManager;
import foundry.veil.impl.client.render.shader.injection.ShaderInjectionManager;
import foundry.veil.mixin.pipeline.accessor.PipelineReloadableResourceManagerAccessor;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/VeilRenderer.class */
public class VeilRenderer implements ResourceManagerReloadListener {
    public static final ResourceLocation ALBEDO_BUFFER_TEXTURE = Veil.veilPath("dynamic_buffer/albedo");
    public static final ResourceLocation NORMAL_BUFFER_TEXTURE = Veil.veilPath("dynamic_buffer/normal");
    public static final ResourceLocation LIGHT_UV_BUFFER_TEXTURE = Veil.veilPath("dynamic_buffer/light_uv");
    public static final ResourceLocation LIGHT_COLOR_BUFFER_TEXTURE = Veil.veilPath("dynamic_buffer/light_color");
    public static final ResourceLocation DEBUG_BUFFER_TEXTURE = Veil.veilPath("dynamic_buffer/debug");
    public static final ResourceLocation COMPOSITE = Veil.veilPath("core/composite");
    private final DynamicBufferManager dynamicBufferManager;
    private final ShaderManager shaderManager;
    private final EditorManager editorManager;
    private final VanillaShaderCompiler vanillaShaderCompiler = new VanillaShaderCompiler();
    private final ShaderPreDefinitions shaderPreDefinitions = new ShaderPreDefinitions();
    private final ShaderModificationManager shaderModificationManager = new ShaderModificationManager();
    private final ShaderInjectionManager shaderInjectionManager = new ShaderInjectionManager();
    private final FramebufferManager framebufferManager = new FramebufferManager();
    private final PostProcessingManager postProcessingManager = new PostProcessingManager();
    private final DynamicRenderTypeManager dynamicRenderTypeManager = new DynamicRenderTypeManager();
    private final ParticleSystemManager quasarParticleManager = new ParticleSystemManager();
    private final FlareEffectManager flareEffectManager = new FlareEffectManager();
    private final CameraMatrices cameraMatrices = new CameraMatrices();
    private final LightRenderer lightRenderer = new LightRenderer();
    private final GuiInfo guiInfo = new GuiInfo();

    @ApiStatus.Internal
    public VeilRenderer(ReloadableResourceManager resourceManager, Window window) {
        this.dynamicBufferManager = new DynamicBufferManager(window.getWidth(), window.getHeight());
        this.shaderManager = new ShaderManager(ShaderManager.PROGRAM_SET, this.shaderPreDefinitions, this.dynamicBufferManager);
        this.editorManager = new EditorManager(resourceManager);
        List<PreparableReloadListener> listeners = ((PipelineReloadableResourceManagerAccessor) resourceManager).getListeners();
        listeners.add(0, this.shaderInjectionManager);
        listeners.add(1, this.shaderManager);
        resourceManager.registerReloadListener(this.framebufferManager);
        resourceManager.registerReloadListener(this.postProcessingManager);
        resourceManager.registerReloadListener(this.dynamicRenderTypeManager);
        resourceManager.registerReloadListener(this.flareEffectManager.getShellManager());
        resourceManager.registerReloadListener(this);
    }

    @ApiStatus.Internal
    public void addDebugInfo(Consumer<String> consumer) {
        consumer.accept("");
        consumer.accept(String.valueOf(ChatFormatting.UNDERLINE) + "Veil");
        this.lightRenderer.addDebugInfo(consumer);
        int mask = this.dynamicBufferManager.getActiveBuffers();
        if (mask != 0) {
            String buffers = (String) Arrays.stream(DynamicBufferType.decode(mask)).map((v0) -> {
                return v0.getName();
            }).collect(Collectors.joining(", "));
            consumer.accept("Active Buffers: " + buffers);
        }
    }

    public boolean enableBuffers(ResourceLocation name, DynamicBufferType... buffers) {
        RenderSystem.assertOnRenderThreadOrInit();
        if (buffers.length == 0) {
            return false;
        }
        int active = this.dynamicBufferManager.getActiveBuffers(name) | DynamicBufferType.encode(buffers);
        return this.dynamicBufferManager.setActiveBuffers(name, active);
    }

    public boolean disableBuffers(ResourceLocation name, DynamicBufferType... buffers) {
        RenderSystem.assertOnRenderThreadOrInit();
        if (buffers.length == 0) {
            return false;
        }
        int active = this.dynamicBufferManager.getActiveBuffers(name) & (DynamicBufferType.encode(buffers) ^ (-1));
        return this.dynamicBufferManager.setActiveBuffers(name, active);
    }

    public boolean disableBuffers(ResourceLocation name) {
        RenderSystem.assertOnRenderThreadOrInit();
        return this.dynamicBufferManager.setActiveBuffers(name, 0);
    }

    public int getActiveBuffers() {
        return this.dynamicBufferManager.getActiveBuffers();
    }

    public VanillaShaderCompiler getVanillaShaderCompiler() {
        return this.vanillaShaderCompiler;
    }

    @ApiStatus.Internal
    public DynamicBufferManager getDynamicBufferManger() {
        return this.dynamicBufferManager;
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated(forRemoval = true)
    public ShaderModificationManager getShaderModificationManager() {
        return this.shaderModificationManager;
    }

    @ApiStatus.Internal
    public ShaderInjectionManager getShaderInjectionManager() {
        return this.shaderInjectionManager;
    }

    public ShaderPreDefinitions getShaderDefinitions() {
        return this.shaderPreDefinitions;
    }

    public ShaderManager getShaderManager() {
        return this.shaderManager;
    }

    public FramebufferManager getFramebufferManager() {
        return this.framebufferManager;
    }

    public PostProcessingManager getPostProcessingManager() {
        return this.postProcessingManager;
    }

    @ApiStatus.Internal
    public DynamicRenderTypeManager getDynamicRenderTypeManager() {
        return this.dynamicRenderTypeManager;
    }

    public ParticleSystemManager getParticleManager() {
        return this.quasarParticleManager;
    }

    public FlareEffectManager getEffectManager() {
        return this.flareEffectManager;
    }

    public EditorManager getEditorManager() {
        return this.editorManager;
    }

    public CameraMatrices getCameraMatrices() {
        return this.cameraMatrices;
    }

    public LightRenderer getLightRenderer() {
        return this.lightRenderer;
    }

    public GuiInfo getGuiInfo() {
        return this.guiInfo;
    }

    @ApiStatus.Internal
    public void resize(int width, int height) {
        this.framebufferManager.resizeFramebuffers(width, height);
        this.dynamicBufferManager.resizeFramebuffers(width, height);
        VeilFirstPersonRenderer.free();
        VeilBloomRenderer.free();
    }

    @ApiStatus.Internal
    public void endFrame() {
        this.framebufferManager.clear();
        this.dynamicBufferManager.endFrame();
        this.postProcessingManager.endFrame();
    }

    @ApiStatus.Internal
    public void free() {
        this.dynamicBufferManager.free();
        this.shaderManager.close();
        this.framebufferManager.free();
        this.postProcessingManager.free();
        this.quasarParticleManager.clear();
        this.flareEffectManager.getShellManager().free();
        this.lightRenderer.free();
    }

    public void onResourceManagerReload(@NotNull ResourceManager resourceManager) {
        VeilBloomRenderer.tryEnable();
    }
}
