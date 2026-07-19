package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/* JADX INFO: renamed from: com.boehmod.blockfront.gs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gs.class */
public abstract class AbstractC0182gs<T extends BlockEntity & GeoAnimatable> extends GeoBlockRenderer<T> {
    public abstract boolean a(@NotNull T t);

    public abstract boolean R();

    public AbstractC0182gs(@NotNull GeoModel<T> geoModel) {
        super(geoModel);
    }

    public AbstractC0182gs() {
        this(new eJ());
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer
    public void render(T t, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i2) {
        if ((t.getBlockState().getBlock() instanceof kD) && a(t)) {
            return;
        }
        GeoModel<T> geoModel = getGeoModel();
        if (geoModel instanceof eJ) {
            synchronized (((eJ) geoModel).a()) {
                super.render(t, f, poseStack, multiBufferSource, i, i2);
            }
            return;
        }
        super.render(t, f, poseStack, multiBufferSource, i, i2);
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    public void updateAnimatedTextureFrame(T t) {
        if ((t instanceof lN) && !((lN) t).am()) {
            return;
        }
        super.updateAnimatedTextureFrame((BlockEntity) t);
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel bakedGeoModel, @NotNull MultiBufferSource multiBufferSource, float f, int i) {
        return true;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull T t) {
        ResourceLocation resourceLocationN;
        if ((t instanceof lN) && (resourceLocationN = ((lN) t).n()) != null) {
            return resourceLocationN;
        }
        return super.getTextureLocation(t);
    }
}
