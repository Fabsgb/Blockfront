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

/* JADX INFO: renamed from: com.boehmod.blockfront.gs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gs.class */
public abstract class AbstractC0402gs<T extends BlockEntity & GeoAnimatable> extends GeoBlockRenderer<T> {
    /* JADX INFO: renamed from: a */
    public abstract boolean mo1889a(@NotNull T t);

    /* JADX INFO: renamed from: R */
    public abstract boolean mo1890R();

    public AbstractC0402gs(@NotNull GeoModel<T> geoModel) {
        super(geoModel);
    }

    public AbstractC0402gs() {
        this(new C0261eJ());
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer
    public void render(T t, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i2) {
        if ((t.getBlockState().getBlock() instanceof InterfaceC0573kD) && mo1889a(t)) {
            return;
        }
        GeoModel<T> geoModel = getGeoModel();
        if (geoModel instanceof C0261eJ) {
            synchronized (((C0261eJ) geoModel).m1448a()) {
                super.render(t, f, poseStack, multiBufferSource, i, i2);
            }
            return;
        }
        super.render(t, f, poseStack, multiBufferSource, i, i2);
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    public void updateAnimatedTextureFrame(T t) {
        if ((t instanceof C0636lN) && !((C0636lN) t).mo2804am()) {
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
        ResourceLocation resourceLocationM2816n;
        if ((t instanceof C0636lN) && (resourceLocationM2816n = ((C0636lN) t).m2816n()) != null) {
            return resourceLocationM2816n;
        }
        return super.getTextureLocation(t);
    }
}
