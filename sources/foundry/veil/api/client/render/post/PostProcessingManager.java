package foundry.veil.api.client.render.post;

import com.boehmod.blockfront.InterfaceC1274xN;
import com.google.common.collect.Iterables;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import foundry.veil.Veil;
import foundry.veil.VeilClient;
import foundry.veil.api.CodecReloadListener;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilRenderer;
import foundry.veil.api.client.render.ext.VeilDebug;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.FramebufferStack;
import foundry.veil.api.client.render.framebuffer.VeilFramebuffers;
import foundry.veil.api.client.render.post.stage.CompositePostPipeline;
import foundry.veil.api.client.render.profiler.RenderProfilerCounter;
import foundry.veil.api.client.render.profiler.VeilRenderProfiler;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.event.VeilRenderLevelStageEvent;
import foundry.veil.impl.client.render.pipeline.PostPipelineContext;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionDefinition;
import foundry.veil.platform.VeilClientPlatform;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/post/PostProcessingManager.class */
public class PostProcessingManager extends CodecReloadListener<CompositePostPipeline> implements NativeResource {
    private static final Comparator<ProfileEntry> PIPELINE_SORTER = Comparator.comparingInt((v0) -> {
        return v0.getPriority();
    }).reversed();
    private static final ResourceLocation POST = Veil.veilPath("post");
    private final PostPipelineContext context;
    private final List<ProfileEntry> activePipelines;
    private final List<ProfileEntry> activePipelinesView;
    private final Map<ResourceLocation, CompositePostPipeline> pipelines;
    private boolean pipelinesDirty;
    private int enabledBuffers;

    public PostProcessingManager() {
        super(CompositePostPipeline.CODEC, FileToIdConverter.json("pinwheel/post"));
        this.context = new PostPipelineContext();
        this.activePipelines = new LinkedList();
        this.activePipelinesView = Collections.unmodifiableList(this.activePipelines);
        this.pipelines = new HashMap();
        this.pipelinesDirty = false;
        this.enabledBuffers = 0;
    }

    public boolean isActive(ResourceLocation pipeline) {
        for (ProfileEntry entry : this.activePipelines) {
            if (entry.pipeline.equals(pipeline)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(ResourceLocation pipeline) {
        return add(ShaderInjectionDefinition.DEFAULT_PRIORITY, pipeline);
    }

    public boolean add(int priority, ResourceLocation pipeline) {
        ListIterator<ProfileEntry> iterator = this.activePipelines.listIterator();
        while (iterator.hasNext()) {
            ProfileEntry entry = iterator.next();
            if (entry.pipeline.equals(pipeline)) {
                if (entry.priority == priority) {
                    return false;
                }
                iterator.set(new ProfileEntry(pipeline, priority));
                this.pipelinesDirty = true;
                return true;
            }
        }
        this.activePipelines.add(new ProfileEntry(pipeline, priority));
        this.pipelinesDirty = true;
        return true;
    }

    public boolean remove(ResourceLocation pipeline) {
        Iterator<ProfileEntry> iterator = this.activePipelines.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().pipeline.equals(pipeline)) {
                iterator.remove();
                this.pipelinesDirty = true;
                return true;
            }
        }
        return false;
    }

    @Nullable
    public PostPipeline getPipeline(ResourceLocation pipeline) {
        return this.pipelines.get(pipeline);
    }

    @ApiStatus.Internal
    public void endFrame() {
        VeilRenderSystem.renderer().getDynamicBufferManger().setActiveBuffers(POST, this.enabledBuffers);
    }

    private void setup() {
        VeilRenderProfiler.get().push("veil_post", RenderProfilerCounter.FRAGMENT_SHADER_INVOCATIONS);
        RenderSystem.enableDepthTest();
        RenderSystem.depthFunc(519);
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        FramebufferStack.push(POST);
    }

    private void clear() {
        ShaderProgram.unbind();
        RenderSystem.depthFunc(515);
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
        FramebufferStack.pop(POST);
        VeilRenderProfiler.get().pop();
    }

    private void clearPipeline() {
        RenderSystem.colorMask(true, true, true, true);
        RenderSystem.depthFunc(519);
        RenderSystem.depthMask(false);
    }

    @ApiStatus.Internal
    public void runDefaultPipeline(@Nullable VeilRenderLevelStageEvent.Stage stage) {
        if (this.activePipelines.isEmpty()) {
            return;
        }
        VeilDebug debug = VeilDebug.get();
        if (stage != null) {
            debug.pushDebugGroup("Veil Post Processing (" + stage.getName() + ")");
        } else {
            debug.pushDebugGroup("Veil Post Processing");
        }
        VeilRenderer renderer = VeilRenderSystem.renderer();
        AdvancedFbo postFramebuffer = renderer.getFramebufferManager().getFramebuffer(VeilFramebuffers.POST);
        VeilClientPlatform platform = VeilClient.clientPlatform();
        this.context.begin();
        setup();
        int activeTexture = GlStateManager._getActiveTexture();
        if (this.pipelinesDirty) {
            this.pipelinesDirty = false;
            this.activePipelines.sort(PIPELINE_SORTER);
        }
        for (ProfileEntry entry : this.activePipelines) {
            ResourceLocation id = entry.getPipeline();
            CompositePostPipeline pipeline = this.pipelines.get(id);
            if (pipeline != null) {
                this.enabledBuffers |= pipeline.getDynamicBuffersMask();
                if ((renderer.getDynamicBufferManger().getActiveBuffers() & this.enabledBuffers) == this.enabledBuffers && pipeline.getRenderStage() == stage) {
                    platform.preVeilPostProcessing(id, pipeline, this.context);
                    try {
                        pipeline.apply(this.context);
                        clearPipeline();
                        if (postFramebuffer != null) {
                            postFramebuffer.resolveToRenderTarget(Minecraft.getInstance().getMainRenderTarget(), InterfaceC1274xN.f6857vZ, 9728);
                        }
                    } catch (Exception e) {
                        Veil.LOGGER.error("Error running pipeline {}", id, e);
                    }
                    platform.postVeilPostProcessing(id, pipeline, this.context);
                }
            }
        }
        RenderSystem.activeTexture(activeTexture);
        clear();
        this.context.end();
        debug.popDebugGroup();
    }

    public void runPipeline(PostPipeline pipeline) {
        runPipeline(pipeline, true);
    }

    public void runPipeline(PostPipeline pipeline, boolean resolvePost) {
        VeilRenderer renderer = VeilRenderSystem.renderer();
        if (pipeline instanceof CompositePostPipeline) {
            CompositePostPipeline compositePostPipeline = (CompositePostPipeline) pipeline;
            this.enabledBuffers |= compositePostPipeline.getDynamicBuffersMask();
            if ((renderer.getDynamicBufferManger().getActiveBuffers() & this.enabledBuffers) != this.enabledBuffers) {
                return;
            }
        }
        this.context.begin();
        setup();
        int activeTexture = GlStateManager._getActiveTexture();
        try {
            pipeline.apply(this.context);
            clearPipeline();
        } catch (Exception e) {
            Veil.LOGGER.error("Error running pipeline {}", pipeline, e);
        }
        RenderSystem.activeTexture(activeTexture);
        clear();
        this.context.end();
        AdvancedFbo postFramebuffer = resolvePost ? renderer.getFramebufferManager().getFramebuffer(VeilFramebuffers.POST) : null;
        if (postFramebuffer != null) {
            postFramebuffer.resolveToRenderTarget(Minecraft.getInstance().getMainRenderTarget(), InterfaceC1274xN.f6857vZ, 9728);
        }
    }

    public static void resolvePost(@Nullable AdvancedFbo framebuffer) {
        resolvePost(framebuffer, InterfaceC1274xN.f6857vZ);
    }

    public static void resolvePost(@Nullable AdvancedFbo framebuffer, int mask) {
        AdvancedFbo postFramebuffer;
        if (framebuffer != null && (postFramebuffer = VeilRenderSystem.renderer().getFramebufferManager().getFramebuffer(VeilFramebuffers.POST)) != null) {
            postFramebuffer.resolveToAdvancedFbo(framebuffer, mask, 9728);
        }
    }

    private CompositePostPipeline loadPipeline(Resource resource) throws IOException {
        Reader reader = resource.openAsReader();
        try {
            JsonElement element = JsonParser.parseReader(reader);
            DataResult<CompositePostPipeline> result = this.codec.parse(JsonOps.INSTANCE, element);
            if (result.error().isPresent()) {
                throw new JsonSyntaxException(((DataResult.Error) result.error().get()).message());
            }
            CompositePostPipeline compositePostPipeline = (CompositePostPipeline) result.result().orElseThrow();
            if (reader != null) {
                reader.close();
            }
            return compositePostPipeline;
        } catch (Throwable th) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.CodecReloadListener
    @NotNull
    /* JADX INFO: renamed from: prepare */
    public Map<ResourceLocation, CompositePostPipeline> mo9291prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Map<ResourceLocation, CompositePostPipeline> data = new HashMap<>();
        Map<ResourceLocation, List<Resource>> resources = this.converter.listMatchingResourceStacks(resourceManager);
        for (Map.Entry<ResourceLocation, List<Resource>> entry : resources.entrySet()) {
            ResourceLocation location = entry.getKey();
            ResourceLocation id = this.converter.fileToId(location);
            if (entry.getValue().size() == 1) {
                try {
                    data.put(id, loadPipeline((Resource) Iterables.getOnlyElement(entry.getValue())));
                } catch (Exception e) {
                    Veil.LOGGER.error("Couldn't parse data file {} from {}", new Object[]{id, location, e});
                }
            } else {
                List<CompositePostPipeline> pipelines = new ArrayList<>(entry.getValue().size());
                for (Resource resource : entry.getValue()) {
                    try {
                        pipelines.add(loadPipeline(resource));
                    } catch (Exception e2) {
                        Veil.LOGGER.error("Couldn't parse data file {} from {}", new Object[]{id, location, e2});
                    }
                }
                if (!pipelines.isEmpty()) {
                    if (pipelines.size() == 1) {
                        data.put(id, (CompositePostPipeline) Iterables.getOnlyElement(pipelines));
                    } else {
                        int dynamicBuffers = 0;
                        pipelines.sort(Comparator.comparingInt((v0) -> {
                            return v0.getPriority();
                        }));
                        for (int i = 0; i < pipelines.size(); i++) {
                            CompositePostPipeline pipeline = pipelines.get(i);
                            dynamicBuffers |= pipeline.getDynamicBuffersMask();
                            if (pipeline.isReplace()) {
                                pipelines = pipelines.subList(0, i + 1);
                                break;
                            }
                        }
                        data.put(id, new CompositePostPipeline((PostPipeline[]) pipelines.toArray(x$0 -> {
                            return new CompositePostPipeline[x$0];
                        }), Collections.emptyMap(), Collections.emptyMap(), ((CompositePostPipeline) pipelines.getFirst()).getRenderStage(), dynamicBuffers));
                    }
                }
            }
        }
        return data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apply(@NotNull Map<ResourceLocation, CompositePostPipeline> data, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        free();
        this.pipelines.putAll(data);
        Veil.LOGGER.info("Loaded {} post pipelines", Integer.valueOf(this.pipelines.size()));
    }

    public void free() {
        this.pipelines.values().forEach((v0) -> {
            v0.free();
        });
        this.pipelines.clear();
    }

    public PostPipeline.Context getPostPipelineContext() {
        return this.context;
    }

    @NotNull
    public Set<ResourceLocation> getPipelines() {
        return this.pipelines.keySet();
    }

    public List<ProfileEntry> getActivePipelines() {
        if (this.pipelinesDirty) {
            this.pipelinesDirty = false;
            this.activePipelines.sort(PIPELINE_SORTER);
        }
        return this.activePipelinesView;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/post/PostProcessingManager$ProfileEntry.class */
    public static class ProfileEntry {
        private final ResourceLocation pipeline;
        private int priority;

        public ProfileEntry(ResourceLocation pipeline, int priority) {
            this.pipeline = pipeline;
            this.priority = priority;
        }

        public ResourceLocation getPipeline() {
            return this.pipeline;
        }

        public int getPriority() {
            return this.priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ProfileEntry that = (ProfileEntry) o;
            return this.priority == that.priority && Objects.equals(this.pipeline, that.pipeline);
        }

        public int hashCode() {
            int result = this.pipeline.hashCode();
            return (31 * result) + this.priority;
        }
    }
}
