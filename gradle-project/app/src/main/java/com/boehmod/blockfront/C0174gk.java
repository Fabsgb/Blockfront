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

/* JADX INFO: renamed from: com.boehmod.blockfront.gk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gk.class */
public class C0174gk<T extends BlockEntity & GeoAnimatable> extends AbstractC0182gs<T> {
    private static final int iX = 256;

    public C0174gk(@NotNull BlockEntityRendererProvider.Context context) {
        this(new eJ());
    }

    public C0174gk(@NotNull GeoModel<T> geoModel) {
        super(geoModel);
    }

    @Override // com.boehmod.blockfront.AbstractC0182gs
    public boolean a(@NotNull T t) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0182gs
    public boolean R() {
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

    @Override // com.boehmod.blockfront.AbstractC0182gs, software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel bakedGeoModel, @NotNull MultiBufferSource multiBufferSource, float f, int i) {
        return true;
    }
}
