package software.bernie.geckolib.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.apache.logging.log4j.util.TriConsumer;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/renderer/layer/BoneFilterGeoLayer.class */
public class BoneFilterGeoLayer<T extends GeoAnimatable> extends GeoRenderLayer<T> {
    protected final TriConsumer<GeoBone, T, Float> checkAndApply;

    public BoneFilterGeoLayer(GeoRenderer<T> renderer) {
        this(renderer, (bone, animatable, partialTick) -> {
        });
    }

    public BoneFilterGeoLayer(GeoRenderer<T> renderer, TriConsumer<GeoBone, T, Float> checkAndApply) {
        super(renderer);
        this.checkAndApply = checkAndApply;
    }

    protected void checkAndApply(GeoBone bone, T animatable, float partialTick) {
        this.checkAndApply.accept(bone, animatable, Float.valueOf(partialTick));
    }

    @Override // software.bernie.geckolib.renderer.layer.GeoRenderLayer
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        for (GeoBone bone : bakedModel.topLevelBones()) {
            checkChildBones(bone, animatable, partialTick);
        }
    }

    private void checkChildBones(GeoBone parentBone, T animatable, float partialTick) {
        checkAndApply(parentBone, animatable, partialTick);
        for (GeoBone bone : parentBone.getChildBones()) {
            checkChildBones(bone, animatable, partialTick);
        }
    }
}
