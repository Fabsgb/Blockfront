package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: renamed from: com.boehmod.blockfront.gk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gk.class */
public class C0394gk<T extends BlockEntity & GeoAnimatable> extends AbstractC0402gs<T> {

    /* JADX INFO: renamed from: iX */
    private static final int f2602iX = 256;

    public C0394gk(@NotNull BlockEntityRendererProvider.Context context) {
        this(new C0261eJ());
    }

    public C0394gk(@NotNull GeoModel<T> geoModel) {
        super(geoModel);
    }

    @Override // com.boehmod.blockfront.AbstractC0402gs
    /* JADX INFO: renamed from: a */
    public boolean mo1889a(@NotNull T t) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0402gs
    /* JADX INFO: renamed from: R */
    public boolean mo1890R() {
        return true;
    }

    public int getViewDistance() {
        return 256;
    }

    @NotNull
    public AABB getRenderBoundingBox(@NotNull T t) {
        return super.getRenderBoundingBox(t).inflate(5.0d);
    }

    public boolean shouldRenderOffScreen(@NotNull T t) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0402gs, software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel bakedGeoModel, @NotNull MultiBufferSource multiBufferSource, float f, int i) {
        return true;
    }
}
