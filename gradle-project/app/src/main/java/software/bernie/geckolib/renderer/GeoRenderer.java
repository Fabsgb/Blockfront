package software.bernie.geckolib.renderer;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexMultiConsumer;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.OutlineBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.object.GeoCube;
import software.bernie.geckolib.cache.object.GeoQuad;
import software.bernie.geckolib.cache.object.GeoVertex;
import software.bernie.geckolib.loading.math.MolangQueries;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.util.Color;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/renderer/GeoRenderer.class */
public interface GeoRenderer<T extends GeoAnimatable> {
    GeoModel<T> getGeoModel();

    /* JADX INFO: renamed from: getAnimatable */
    T mo2142getAnimatable();

    void fireCompileRenderLayersEvent();

    boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void firePostRenderEvent(PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void updateAnimatedTextureFrame(T t);

    default ResourceLocation getTextureLocation(T animatable) {
        return getGeoModel().getTextureResource(animatable, this);
    }

    default List<GeoRenderLayer<T>> getRenderLayers() {
        return List.of();
    }

    @Nullable
    default RenderType getRenderType(T animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return getGeoModel().getRenderType(animatable, texture);
    }

    default Color getRenderColor(T animatable, float partialTick, int packedLight) {
        return Color.WHITE;
    }

    default int getPackedOverlay(T animatable, float u, float partialTick) {
        return OverlayTexture.NO_OVERLAY;
    }

    default long getInstanceId(T animatable) {
        return animatable.hashCode();
    }

    default float getMotionAnimThreshold(T animatable) {
        return 0.015f;
    }

    default void defaultRender(PoseStack poseStack, T animatable, MultiBufferSource bufferSource, @Nullable RenderType renderType, @Nullable VertexConsumer buffer, float yaw, float partialTick, int packedLight) {
        poseStack.pushPose();
        int renderColor = getRenderColor(animatable, partialTick, packedLight).argbInt();
        int packedOverlay = getPackedOverlay(animatable, 0.0f, partialTick);
        BakedGeoModel model = getGeoModel().getBakedModel(getGeoModel().getModelResource(animatable, this));
        if (renderType == null) {
            renderType = getRenderType(animatable, getTextureLocation(animatable), bufferSource, partialTick);
        }
        if (buffer == null && renderType != null) {
            buffer = bufferSource.getBuffer(renderType);
        }
        preRender(poseStack, animatable, model, bufferSource, buffer, false, partialTick, packedLight, packedOverlay, renderColor);
        if (firePreRenderEvent(poseStack, model, bufferSource, partialTick, packedLight)) {
            preApplyRenderLayers(poseStack, animatable, model, renderType, bufferSource, buffer, packedLight, packedLight, packedOverlay);
            actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, false, partialTick, packedLight, packedOverlay, renderColor);
            applyRenderLayers(poseStack, animatable, model, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
            postRender(poseStack, animatable, model, bufferSource, buffer, false, partialTick, packedLight, packedOverlay, renderColor);
            firePostRenderEvent(poseStack, model, bufferSource, partialTick, packedLight);
        }
        poseStack.popPose();
        renderFinal(poseStack, animatable, model, bufferSource, buffer, partialTick, packedLight, packedOverlay, renderColor);
        doPostRenderCleanup();
        MolangQueries.clearActor();
    }

    default void reRender(BakedGeoModel model, PoseStack poseStack, MultiBufferSource bufferSource, T animatable, RenderType renderType, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay, int colour) {
        poseStack.pushPose();
        preRender(poseStack, animatable, model, bufferSource, buffer, true, partialTick, packedLight, packedOverlay, colour);
        actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, true, partialTick, packedLight, packedOverlay, colour);
        postRender(poseStack, animatable, model, bufferSource, buffer, true, partialTick, packedLight, packedOverlay, colour);
        poseStack.popPose();
    }

    default void actuallyRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        if (buffer == null) {
            if (renderType == null) {
                return;
            } else {
                buffer = bufferSource.getBuffer(renderType);
            }
        }
        updateAnimatedTextureFrame(animatable);
        for (GeoBone group : model.topLevelBones()) {
            renderRecursively(poseStack, animatable, group, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        }
    }

    default void preApplyRenderLayers(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        for (GeoRenderLayer<T> renderLayer : getRenderLayers()) {
            renderLayer.preRender(poseStack, animatable, model, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }

    default void applyRenderLayersForBone(PoseStack poseStack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        for (GeoRenderLayer<T> renderLayer : getRenderLayers()) {
            renderLayer.renderForBone(poseStack, animatable, bone, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }

    default void applyRenderLayers(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        for (GeoRenderLayer<T> renderLayer : getRenderLayers()) {
            renderLayer.render(poseStack, animatable, model, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }

    default void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
    }

    default void postRender(PoseStack poseStack, T animatable, BakedGeoModel model, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
    }

    default void renderFinal(PoseStack poseStack, T animatable, BakedGeoModel model, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay, int colour) {
    }

    default void doPostRenderCleanup() {
    }

    default void renderRecursively(PoseStack poseStack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        poseStack.pushPose();
        RenderUtil.prepMatrixForBone(poseStack, bone);
        VertexConsumer buffer2 = checkAndRefreshBuffer(isReRender, buffer, bufferSource, renderType);
        renderCubesOfBone(poseStack, bone, buffer2, packedLight, packedOverlay, colour);
        if (!isReRender) {
            applyRenderLayersForBone(poseStack, mo2142getAnimatable(), bone, renderType, bufferSource, buffer2, partialTick, packedLight, packedOverlay);
        }
        renderChildBones(poseStack, animatable, bone, renderType, bufferSource, buffer2, isReRender, partialTick, packedLight, packedOverlay, colour);
        poseStack.popPose();
    }

    default void renderCubesOfBone(PoseStack poseStack, GeoBone bone, VertexConsumer buffer, int packedLight, int packedOverlay, int colour) {
        if (bone.isHidden()) {
            return;
        }
        for (GeoCube cube : bone.getCubes()) {
            poseStack.pushPose();
            renderCube(poseStack, cube, buffer, packedLight, packedOverlay, colour);
            poseStack.popPose();
        }
    }

    default void renderChildBones(PoseStack poseStack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        if (bone.isHidingChildren()) {
            return;
        }
        for (GeoBone childBone : bone.getChildBones()) {
            renderRecursively(poseStack, animatable, childBone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        }
    }

    default void renderCube(PoseStack poseStack, GeoCube cube, VertexConsumer buffer, int packedLight, int packedOverlay, int colour) {
        RenderUtil.translateToPivotPoint(poseStack, cube);
        RenderUtil.rotateMatrixAroundCube(poseStack, cube);
        RenderUtil.translateAwayFromPivotPoint(poseStack, cube);
        Matrix3f normalisedPoseState = poseStack.last().normal();
        Matrix4f poseState = new Matrix4f(poseStack.last().pose());
        for (GeoQuad quad : cube.quads()) {
            if (quad != null) {
                Vector3f normal = normalisedPoseState.transform(new Vector3f(quad.normal()));
                RenderUtil.fixInvertedFlatCube(cube, normal);
                createVerticesOfQuad(quad, poseState, normal, buffer, packedLight, packedOverlay, colour);
            }
        }
    }

    default void createVerticesOfQuad(GeoQuad quad, Matrix4f poseState, Vector3f normal, VertexConsumer buffer, int packedLight, int packedOverlay, int colour) {
        for (GeoVertex vertex : quad.vertices()) {
            Vector3f position = vertex.position();
            Vector4f vector4f = poseState.transform(new Vector4f(position.x(), position.y(), position.z(), 1.0f));
            buffer.addVertex(vector4f.x(), vector4f.y(), vector4f.z(), colour, vertex.texU(), vertex.texV(), packedOverlay, packedLight, normal.x(), normal.y(), normal.z());
        }
    }

    default void scaleModelForRender(float widthScale, float heightScale, PoseStack poseStack, T animatable, BakedGeoModel model, boolean isReRender, float partialTick, int packedLight, int packedOverlay) {
        if (isReRender) {
            return;
        }
        if (widthScale != 1.0f || heightScale != 1.0f) {
            poseStack.scale(widthScale, heightScale, widthScale);
        }
    }

    @ApiStatus.Internal
    @Deprecated(forRemoval = true)
    default VertexConsumer checkAndRefreshBuffer(boolean isReRender, VertexConsumer buffer, MultiBufferSource bufferSource, RenderType renderType) {
        VertexMultiConsumer.Double pair;
        if (isReRender) {
            return buffer;
        }
        Objects.requireNonNull(buffer);
        int i = 0;
        while (true) {
            switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), BufferBuilder.class, OutlineBufferSource.EntityOutlineGenerator.class, VertexMultiConsumer.Double.class).dynamicInvoker().invoke(buffer, i) /* invoke-custom */) {
                case 0:
                    BufferBuilder builder = (BufferBuilder) buffer;
                    if (!builder.building) {
                        return bufferSource.getBuffer(renderType);
                    }
                    i = 1;
                    break;
                    break;
                case 1:
                    OutlineBufferSource.EntityOutlineGenerator outlines = (OutlineBufferSource.EntityOutlineGenerator) buffer;
                    if (bufferNeedsRefresh(outlines.delegate())) {
                        return new OutlineBufferSource.EntityOutlineGenerator(bufferSource.getBuffer(renderType), outlines.color());
                    }
                    i = 2;
                    break;
                case 2:
                    pair = (VertexMultiConsumer.Double) buffer;
                    if (!bufferNeedsRefresh(pair.first) && !bufferNeedsRefresh(pair.second)) {
                        i = 3;
                    }
                    break;
                default:
                    return buffer;
            }
        }
        return new VertexMultiConsumer.Double(bufferNeedsRefresh(pair.first) ? bufferSource.getBuffer(renderType) : pair.first, bufferNeedsRefresh(pair.second) ? bufferSource.getBuffer(renderType) : pair.second);
    }

    @ApiStatus.Internal
    @Deprecated(forRemoval = true)
    private default boolean bufferNeedsRefresh(VertexConsumer buffer) {
        Objects.requireNonNull(buffer);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), BufferBuilder.class, OutlineBufferSource.EntityOutlineGenerator.class, VertexMultiConsumer.Double.class).dynamicInvoker().invoke(buffer, 0) /* invoke-custom */) {
            case 0:
                BufferBuilder builder = (BufferBuilder) buffer;
                return !builder.building;
            case 1:
                OutlineBufferSource.EntityOutlineGenerator outlines = (OutlineBufferSource.EntityOutlineGenerator) buffer;
                return bufferNeedsRefresh(outlines.delegate());
            case 2:
                VertexMultiConsumer.Double pair = (VertexMultiConsumer.Double) buffer;
                return bufferNeedsRefresh(pair.first) || bufferNeedsRefresh(pair.second);
            default:
                return false;
        }
    }
}
