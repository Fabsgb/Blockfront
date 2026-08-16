package foundry.veil.mixin.pipeline.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.api.client.render.CullFrustum;
import foundry.veil.api.client.render.VeilLevelPerspectiveRenderer;
import foundry.veil.api.client.render.VeilRenderBridge;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.FramebufferManager;
import foundry.veil.api.client.render.framebuffer.FramebufferStack;
import foundry.veil.api.client.render.framebuffer.VeilFramebuffers;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.compat.SodiumCompat;
import foundry.veil.ext.LevelRendererExtension;
import foundry.veil.impl.client.render.light.VoxelShadowGrid;
import foundry.veil.impl.client.render.shader.VeilVanillaShaders;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.chunk.SectionRenderDispatcher;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/pipeline/client/PipelineLevelRendererMixin.class */
@Mixin(value = {LevelRenderer.class}, priority = 800)
public abstract class PipelineLevelRendererMixin implements LevelRendererExtension {

    @Shadow
    private Frustum cullingFrustum;

    @Shadow
    @Nullable
    private Frustum capturedFrustum;

    @Shadow
    @Nullable
    private PostChain transparencyChain;

    @Shadow
    @Nullable
    private RenderTarget translucentTarget;

    @Shadow
    @Nullable
    private RenderTarget itemEntityTarget;

    @Shadow
    @Nullable
    private RenderTarget particlesTarget;

    @Shadow
    @Nullable
    private RenderTarget weatherTarget;

    @Shadow
    @Nullable
    private RenderTarget cloudsTarget;

    @Shadow
    @Final
    private ObjectArrayList<SectionRenderDispatcher.RenderSection> visibleSections;

    @Shadow
    @Final
    private Minecraft minecraft;

    @Unique
    private final Matrix4f veil$tempFrustum = new Matrix4f();

    @Unique
    private final Matrix4f veil$tempProjection = new Matrix4f();

    @Shadow
    protected abstract void renderSectionLayer(RenderType renderType, double d, double d2, double d3, Matrix4f matrix4f, Matrix4f matrix4f2);

    @Inject(method = {"renderLevel"}, at = {@At(value = "INVOKE_STRING", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/lang/String;)V", args = {"ldc=entities"})})
    public void saveFramebuffer(CallbackInfo ci) {
        FramebufferStack.push(null);
    }

    @Inject(method = {"renderLevel"}, at = {@At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;getModelViewStack()Lorg/joml/Matrix4fStack;")}, remap = false)
    public void loadFramebuffer(CallbackInfo ci) {
        FramebufferStack.pop(null);
    }

    @Inject(method = {"prepareCullFrustum"}, at = {@At("HEAD")})
    public void veil$setupLevelCamera(Vec3 pos, Matrix4f frustumMatrix, Matrix4f projectionMatrix, CallbackInfo ci) {
        VeilRenderSystem.renderer().getCameraMatrices().update(projectionMatrix, frustumMatrix, pos.x(), pos.y(), pos.z());
    }

    @Inject(method = {"renderLevel"}, at = {@At("TAIL")})
    public void blit(CallbackInfo ci, @Local ProfilerFiller profiler) {
        if (!VeilLevelPerspectiveRenderer.isRenderingPerspective()) {
            if (VeilRenderSystem.drawLights(profiler, VeilRenderSystem.getCullingFrustum(), true)) {
                VeilRenderSystem.compositeLights(profiler);
            } else {
                AdvancedFbo.unbind();
            }
        }
    }

    @Inject(method = {"renderLevel"}, at = {@At(value = "INVOKE_STRING", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/lang/String;)V", args = {"ldc=weather"})})
    public void setRainBlend(CallbackInfo ci) {
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    }

    @ModifyArg(method = {"renderWorldBorder"}, at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShader(Ljava/util/function/Supplier;)V", remap = false))
    public Supplier<ShaderInstance> setWorldBorderShader(Supplier<ShaderInstance> supplier) {
        return VeilVanillaShaders::getWorldborder;
    }

    @Inject(method = {"deinitTransparency"}, at = {@At("RETURN")})
    public void deinitTransparency(CallbackInfo ci) {
        FramebufferManager framebufferManager = VeilRenderSystem.renderer().getFramebufferManager();
        framebufferManager.removeFramebuffer(VeilFramebuffers.TRANSLUCENT_TARGET);
        framebufferManager.removeFramebuffer(VeilFramebuffers.ITEM_ENTITY_TARGET);
        framebufferManager.removeFramebuffer(VeilFramebuffers.PARTICLES_TARGET);
        framebufferManager.removeFramebuffer(VeilFramebuffers.WEATHER_TARGET);
        framebufferManager.removeFramebuffer(VeilFramebuffers.CLOUDS_TARGET);
    }

    @Inject(method = {"initTransparency"}, at = {@At("RETURN")})
    public void initTransparency(CallbackInfo ci) {
        if (this.transparencyChain == null) {
            return;
        }
        FramebufferManager framebufferManager = VeilRenderSystem.renderer().getFramebufferManager();
        framebufferManager.setFramebuffer(VeilFramebuffers.TRANSLUCENT_TARGET, VeilRenderBridge.wrap(this.translucentTarget));
        framebufferManager.setFramebuffer(VeilFramebuffers.ITEM_ENTITY_TARGET, VeilRenderBridge.wrap(this.itemEntityTarget));
        framebufferManager.setFramebuffer(VeilFramebuffers.PARTICLES_TARGET, VeilRenderBridge.wrap(this.particlesTarget));
        framebufferManager.setFramebuffer(VeilFramebuffers.WEATHER_TARGET, VeilRenderBridge.wrap(this.weatherTarget));
        framebufferManager.setFramebuffer(VeilFramebuffers.CLOUDS_TARGET, VeilRenderBridge.wrap(this.cloudsTarget));
    }

    @Inject(method = {"blockChanged"}, at = {@At("TAIL")})
    public void veil$onBlockChanged(BlockGetter level, BlockPos pos, BlockState oldState, BlockState newState, int flags, CallbackInfo ci) {
        VoxelShadowGrid.markBlockDirty(pos);
    }

    @Inject(method = {"setLevel"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/SectionOcclusionGraph;waitAndReset(Lnet/minecraft/client/renderer/ViewArea;)V")})
    public void free(ClientLevel level, CallbackInfo ci) {
        VeilRenderSystem.clearLevel();
    }

    @Override // foundry.veil.ext.LevelRendererExtension
    public CullFrustum veil$getCullFrustum() {
        return VeilRenderBridge.create(this.capturedFrustum != null ? this.capturedFrustum : this.cullingFrustum);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:36:0x0106  */
    /* JADX WARN: Code duplicated, block: B:38:0x0114  */
    /* JADX WARN: Code duplicated, block: B:42:0x013a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x00b8 A[SYNTHETIC] */
    @Override // foundry.veil.ext.LevelRendererBlockLayerExtension
    public void veil$drawBlockLayer(RenderType renderType, double x, double y, double z, Matrix4fc frustum, Matrix4fc projection) {
        SectionRenderDispatcher.RenderSection renderSection;
        SectionRenderDispatcher.RenderSection section;
        RenderSystem.assertOnRenderThread();
        while (renderType instanceof VeilRenderType.RenderTypeWrapper) {
            VeilRenderType.RenderTypeWrapper wrapper = (VeilRenderType.RenderTypeWrapper) renderType;
            renderType = wrapper.get();
        }
        if (renderType == null) {
            return;
        }
        if (renderType instanceof VeilRenderType.LayeredRenderType) {
            VeilRenderType.LayeredRenderType layeredRenderType = (VeilRenderType.LayeredRenderType) renderType;
            ProfilerFiller profiler = this.minecraft.getProfiler();
            this.veil$tempFrustum.set(frustum);
            this.veil$tempProjection.set(projection);
            Window window = this.minecraft.getWindow();
            RenderType[] layers = layeredRenderType.getLayers();
            boolean rendered = false;
            profiler.push("render_" + VeilRenderType.getName(renderType));
            boolean forward = !renderType.sortOnUpload();
            ObjectListIterator<SectionRenderDispatcher.RenderSection> objectlistiterator = this.visibleSections.listIterator(forward ? 0 : this.visibleSections.size());
            ShaderInstance shaderInstance = null;
            Uniform chunkOffset = null;
            ObjectArrayList objectArrayList = new ObjectArrayList(this.visibleSections.size());
            ObjectArrayList objectArrayList2 = new ObjectArrayList(this.visibleSections.size());
            while (true) {
                if (forward) {
                    if (!objectlistiterator.hasNext()) {
                        break;
                    }
                    if (forward) {
                        renderSection = (SectionRenderDispatcher.RenderSection) objectlistiterator.next();
                    } else {
                        renderSection = (SectionRenderDispatcher.RenderSection) objectlistiterator.previous();
                    }
                    section = renderSection;
                    if (section.getCompiled().isEmpty(renderType)) {
                        if (!rendered) {
                            renderType.setupRenderState();
                            shaderInstance = RenderSystem.getShader();
                            if (shaderInstance != null) {
                                shaderInstance.setDefaultUniforms(VertexFormat.Mode.QUADS, this.veil$tempFrustum, this.veil$tempProjection, window);
                                shaderInstance.apply();
                                chunkOffset = shaderInstance.CHUNK_OFFSET;
                            }
                            rendered = true;
                        }
                        if (chunkOffset != null) {
                            BlockPos origin = section.getOrigin();
                            chunkOffset.set((float) (((double) origin.getX()) - x), (float) (((double) origin.getY()) - y), (float) (((double) origin.getZ()) - z));
                            chunkOffset.upload();
                        }
                        VertexBuffer vertexbuffer = section.getBuffer(renderType);
                        vertexbuffer.bind();
                        vertexbuffer.draw();
                        objectArrayList.add(section);
                        objectArrayList2.add(vertexbuffer);
                    }
                } else {
                    if (!objectlistiterator.hasPrevious()) {
                        break;
                    }
                    if (forward) {
                        renderSection = (SectionRenderDispatcher.RenderSection) objectlistiterator.next();
                    } else {
                        renderSection = (SectionRenderDispatcher.RenderSection) objectlistiterator.previous();
                    }
                    section = renderSection;
                    if (section.getCompiled().isEmpty(renderType)) {
                        if (!rendered) {
                            renderType.setupRenderState();
                            shaderInstance = RenderSystem.getShader();
                            if (shaderInstance != null) {
                                shaderInstance.setDefaultUniforms(VertexFormat.Mode.QUADS, this.veil$tempFrustum, this.veil$tempProjection, window);
                                shaderInstance.apply();
                                chunkOffset = shaderInstance.CHUNK_OFFSET;
                            }
                            rendered = true;
                        }
                        if (chunkOffset != null) {
                            BlockPos origin2 = section.getOrigin();
                            chunkOffset.set((float) (((double) origin2.getX()) - x), (float) (((double) origin2.getY()) - y), (float) (((double) origin2.getZ()) - z));
                            chunkOffset.upload();
                        }
                        VertexBuffer vertexbuffer2 = section.getBuffer(renderType);
                        vertexbuffer2.bind();
                        vertexbuffer2.draw();
                        objectArrayList.add(section);
                        objectArrayList2.add(vertexbuffer2);
                    }
                }
            }
            if (!rendered) {
                profiler.pop();
                return;
            }
            if (chunkOffset != null) {
                chunkOffset.set(0.0f, 0.0f, 0.0f);
            }
            if (shaderInstance != null) {
                shaderInstance.clear();
            }
            renderType.clearRenderState();
            profiler.pop();
            if (!objectArrayList.isEmpty()) {
                String name = "render_" + VeilRenderType.getName(layers[0]);
                for (RenderType layer : layers) {
                    layer.setupRenderState();
                    profiler.push(name);
                    ShaderInstance shaderInstance2 = RenderSystem.getShader();
                    if (shaderInstance2 != null) {
                        shaderInstance2.setDefaultUniforms(VertexFormat.Mode.QUADS, this.veil$tempFrustum, this.veil$tempProjection, window);
                        shaderInstance2.apply();
                        chunkOffset = shaderInstance2.CHUNK_OFFSET;
                    }
                    for (int j = 0; j < objectArrayList.size(); j++) {
                        SectionRenderDispatcher.RenderSection section2 = (SectionRenderDispatcher.RenderSection) objectArrayList.get(j);
                        VertexBuffer vertexbuffer3 = (VertexBuffer) objectArrayList2.get(j);
                        if (chunkOffset != null) {
                            BlockPos origin3 = section2.getOrigin();
                            chunkOffset.set((float) (((double) origin3.getX()) - x), (float) (((double) origin3.getY()) - y), (float) (((double) origin3.getZ()) - z));
                            chunkOffset.upload();
                        }
                        vertexbuffer3.bind();
                        vertexbuffer3.draw();
                    }
                    if (chunkOffset != null) {
                        chunkOffset.set(0.0f, 0.0f, 0.0f);
                    }
                    if (shaderInstance2 != null) {
                        shaderInstance2.clear();
                    }
                    profiler.pop();
                    layer.clearRenderState();
                }
            }
            VertexBuffer.unbind();
            return;
        }
        renderSectionLayer(renderType, x, y, z, this.veil$tempFrustum.set(frustum), this.veil$tempProjection.set(projection));
    }

    @Inject(method = {"renderSectionLayer"}, at = {@At("TAIL")})
    public void renderExtraSectionLayers(RenderType renderType, double x, double y, double z, Matrix4f frustrumMatrix, Matrix4f projectionMatrix, CallbackInfo ci) {
        while (renderType instanceof VeilRenderType.RenderTypeWrapper) {
            VeilRenderType.RenderTypeWrapper wrapper = (VeilRenderType.RenderTypeWrapper) renderType;
            renderType = wrapper.get();
        }
        if (!(renderType instanceof VeilRenderType.LayeredRenderType)) {
            return;
        }
        VeilRenderType.LayeredRenderType layeredRenderType = (VeilRenderType.LayeredRenderType) renderType;
        for (RenderType layer : layeredRenderType.getLayers()) {
            renderSectionLayer(layer, x, y, z, frustrumMatrix, projectionMatrix);
        }
    }

    @Override // foundry.veil.ext.LevelRendererExtension
    public void veil$markChunksDirty() {
        SodiumCompat sodiumCompat = SodiumCompat.INSTANCE;
        if (sodiumCompat != null) {
            sodiumCompat.markChunksDirty();
            return;
        }
        ObjectListIterator it = this.visibleSections.iterator();
        while (it.hasNext()) {
            SectionRenderDispatcher.RenderSection section = (SectionRenderDispatcher.RenderSection) it.next();
            section.setDirty(false);
        }
    }
}
