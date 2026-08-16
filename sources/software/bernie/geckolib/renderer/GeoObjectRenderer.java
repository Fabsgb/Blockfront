package software.bernie.geckolib.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.texture.AnimatableTexture;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayersContainer;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/renderer/GeoObjectRenderer.class */
public class GeoObjectRenderer<T extends GeoAnimatable> implements GeoRenderer<T> {
    protected final GeoModel<T> model;
    protected T animatable;
    protected final GeoRenderLayersContainer<T> renderLayers = new GeoRenderLayersContainer<>(this);
    protected float scaleWidth = 1.0f;
    protected float scaleHeight = 1.0f;
    protected Matrix4f objectRenderTranslations = new Matrix4f();
    protected Matrix4f modelRenderTranslations = new Matrix4f();

    public GeoObjectRenderer(GeoModel<T> model) {
        this.model = model;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public GeoModel<T> getGeoModel() {
        return this.model;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: getAnimatable */
    public T mo9710getAnimatable() {
        return this.animatable;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public ResourceLocation getTextureLocation(T animatable) {
        return super.getTextureLocation(animatable);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public List<GeoRenderLayer<T>> getRenderLayers() {
        return this.renderLayers.getRenderLayers();
    }

    public GeoObjectRenderer<T> addRenderLayer(GeoRenderLayer<T> renderLayer) {
        this.renderLayers.addLayer(renderLayer);
        return this;
    }

    public GeoObjectRenderer<T> withScale(float scale) {
        return withScale(scale, scale);
    }

    public GeoObjectRenderer<T> withScale(float scaleWidth, float scaleHeight) {
        this.scaleWidth = scaleWidth;
        this.scaleHeight = scaleHeight;
        return this;
    }

    @ApiStatus.Internal
    public void render(PoseStack poseStack, T animatable, @Nullable MultiBufferSource bufferSource, @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight, float partialTick) {
        this.animatable = animatable;
        if (buffer == null) {
            bufferSource = Minecraft.getInstance().levelRenderer.renderBuffers.bufferSource();
        }
        defaultRender(poseStack, animatable, bufferSource, renderType, buffer, 0.0f, partialTick, packedLight);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        this.objectRenderTranslations = new Matrix4f(poseStack.last().pose());
        scaleModelForRender(this.scaleWidth, this.scaleHeight, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
        poseStack.translate(0.5f, 0.51f, 0.5f);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void actuallyRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        poseStack.pushPose();
        if (!isReRender) {
            AnimationState<T> animationState = new AnimationState<>(animatable, 0.0f, 0.0f, partialTick, false);
            long instanceId = getInstanceId(animatable);
            GeoModel<T> currentModel = getGeoModel();
            Objects.requireNonNull(animationState);
            currentModel.addAdditionalStateData(animatable, instanceId, (v1, v2) -> {
                r3.setData(v1, v2);
            });
            currentModel.handleAnimations(animatable, instanceId, animationState, partialTick);
        }
        this.modelRenderTranslations = new Matrix4f(poseStack.last().pose());
        if (buffer != null) {
            super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        }
        poseStack.popPose();
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void doPostRenderCleanup() {
        this.animatable = null;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void renderRecursively(PoseStack poseStack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        if (bone.isTrackingMatrices()) {
            Matrix4f poseState = new Matrix4f(poseStack.last().pose());
            bone.setModelSpaceMatrix(RenderUtil.invertAndMultiplyMatrices(poseState, this.modelRenderTranslations));
            bone.setLocalSpaceMatrix(RenderUtil.invertAndMultiplyMatrices(poseState, this.objectRenderTranslations));
        }
        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void updateAnimatedTextureFrame(T animatable) {
        AnimatableTexture.setAndUpdate(getTextureLocation(animatable));
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void fireCompileRenderLayersEvent() {
        GeckoLibServices.Client.EVENTS.fireCompileObjectRenderLayers(this);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return GeckoLibServices.Client.EVENTS.fireObjectPreRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void firePostRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        GeckoLibServices.Client.EVENTS.fireObjectPostRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }
}
