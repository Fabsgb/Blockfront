package foundry.veil.mixin.pipeline.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
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
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/pipeline/client/PipelineLevelRendererMixin.class */
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
            if (VeilRenderSystem.drawLights(profiler, VeilRenderSystem.getCullingFrustum())) {
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

    /* JADX WARN: Removed duplicated region for block: B:30:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00b8 A[SYNTHETIC] */
    @Override // foundry.veil.ext.LevelRendererBlockLayerExtension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void veil$drawBlockLayer(net.minecraft.client.renderer.RenderType r13, double r14, double r16, double r18, org.joml.Matrix4fc r20, org.joml.Matrix4fc r21) {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: foundry.veil.mixin.pipeline.client.PipelineLevelRendererMixin.veil$drawBlockLayer(net.minecraft.client.renderer.RenderType, double, double, double, org.joml.Matrix4fc, org.joml.Matrix4fc):void");
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
