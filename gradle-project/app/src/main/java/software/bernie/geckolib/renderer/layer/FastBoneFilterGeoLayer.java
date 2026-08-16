package software.bernie.geckolib.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.apache.logging.log4j.util.TriConsumer;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/renderer/layer/FastBoneFilterGeoLayer.class */
public class FastBoneFilterGeoLayer<T extends GeoAnimatable> extends BoneFilterGeoLayer<T> {
    protected final Supplier<List<String>> boneSupplier;

    public FastBoneFilterGeoLayer(GeoRenderer<T> renderer) {
        this(renderer, List::of);
    }

    public FastBoneFilterGeoLayer(GeoRenderer<T> renderer, Supplier<List<String>> boneSupplier) {
        this(renderer, boneSupplier, (bone, animatable, partialTick) -> {
        });
    }

    public FastBoneFilterGeoLayer(GeoRenderer<T> renderer, Supplier<List<String>> boneSupplier, TriConsumer<GeoBone, T, Float> checkAndApply) {
        super(renderer, checkAndApply);
        this.boneSupplier = boneSupplier;
    }

    protected List<String> getAffectedBones() {
        return this.boneSupplier.get();
    }

    @Override // software.bernie.geckolib.renderer.layer.BoneFilterGeoLayer, software.bernie.geckolib.renderer.layer.GeoRenderLayer
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        for (String boneName : getAffectedBones()) {
            this.renderer.getGeoModel().getBone(boneName).ifPresent(bone -> {
                checkAndApply(bone, animatable, partialTick);
            });
        }
    }
}
