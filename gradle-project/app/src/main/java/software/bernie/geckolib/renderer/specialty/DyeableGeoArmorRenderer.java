package software.bernie.geckolib.renderer.specialty;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import java.util.Collection;
import java.util.Set;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.Color;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/renderer/specialty/DyeableGeoArmorRenderer.class */
public abstract class DyeableGeoArmorRenderer<T extends Item & GeoItem> extends GeoArmorRenderer<T> {
    protected final Set<GeoBone> dyeableBones;
    protected BakedGeoModel lastModel;

    protected abstract boolean isBoneDyeable(GeoBone geoBone);

    @NotNull
    protected abstract Color getColorForBone(GeoBone geoBone);

    public DyeableGeoArmorRenderer(GeoModel<T> model) {
        super(model);
        this.dyeableBones = new ObjectArraySet();
        this.lastModel = null;
    }

    @Override // software.bernie.geckolib.renderer.GeoArmorRenderer, software.bernie.geckolib.renderer.GeoRenderer
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        if (!isReRender) {
            checkBoneDyeCache(animatable, model, partialTick, packedLight, packedOverlay, colour);
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void renderCubesOfBone(PoseStack poseStack, GeoBone bone, VertexConsumer buffer, int packedLight, int packedOverlay, int colour) {
        if (this.dyeableBones.contains(bone)) {
            Color color = getColorForBone(bone);
            colour = FastColor.ARGB32.multiply(colour, color.argbInt());
        }
        super.renderCubesOfBone(poseStack, bone, buffer, packedLight, packedOverlay, colour);
    }

    protected void checkBoneDyeCache(T animatable, BakedGeoModel model, float partialTick, int packedLight, int packedOverlay, int colour) {
        if (model != this.lastModel) {
            this.dyeableBones.clear();
            this.lastModel = model;
            collectDyeableBones(model.topLevelBones());
        }
    }

    protected void collectDyeableBones(Collection<GeoBone> bones) {
        for (GeoBone bone : bones) {
            if (isBoneDyeable(bone)) {
                this.dyeableBones.add(bone);
            }
            collectDyeableBones(bone.getChildBones());
        }
    }
}
