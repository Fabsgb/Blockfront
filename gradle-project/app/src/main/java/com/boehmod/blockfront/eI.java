package com.boehmod.blockfront;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eI.class */
public class eI<T extends BlockEntity & GeoAnimatable> extends eJ<T> {
    private static final int iq = 8;

    public static int a(@NotNull BlockPos blockPos) {
        return new Random(((((long) blockPos.getX()) * 73856093) ^ (((long) blockPos.getY()) * 19349663)) ^ (((long) blockPos.getZ()) * 83492791)).nextInt(8);
    }

    @Override // com.boehmod.blockfront.eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: d */
    public ResourceLocation getAnimationResource(@NotNull T t) {
        return C0265jv.d("animations/block/decoration_" + iM.aw + "_" + a(t.getBlockPos()) + ".animation.json");
    }

    @Override // com.boehmod.blockfront.eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: c */
    public ResourceLocation getModelResource(@NotNull T t) {
        return C0265jv.d("geo/block/decoration_" + iM.aw + "_" + a(t.getBlockPos()) + ".geo.json");
    }

    @Override // com.boehmod.blockfront.eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b */
    public ResourceLocation getTextureResource(@NotNull T t) {
        return C0265jv.d("textures/block/entity/decoration_" + iM.aw + "_" + a(t.getBlockPos()) + ".png");
    }

    @Override // com.boehmod.blockfront.eJ
    @NotNull
    public ResourceLocation a(@NotNull T t) {
        return C0265jv.d("block/entity/decoration_" + iM.aw + "_" + a(t.getBlockPos()));
    }
}
