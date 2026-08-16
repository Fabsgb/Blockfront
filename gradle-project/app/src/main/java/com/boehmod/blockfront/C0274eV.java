package com.boehmod.blockfront;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: renamed from: com.boehmod.blockfront.eV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eV.class */
public class C0274eV<T extends BlockEntity & GeoAnimatable> extends C0275eW<T> {

    /* JADX INFO: renamed from: jG */
    private static final int f2186jG = 8;

    /* JADX INFO: renamed from: a */
    public static int m1525a(@NotNull BlockPos blockPos) {
        return new Random(((((long) blockPos.getX()) * 73856093) ^ (((long) blockPos.getY()) * 19349663)) ^ (((long) blockPos.getZ()) * 83492791)).nextInt(8);
    }

    @Override // com.boehmod.blockfront.C0275eW, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: d */
    public ResourceLocation getAnimationResource(@NotNull T t) {
        return C0532jO.m2378d("animations/block/decoration_" + C0549jf.f3265aC + "_" + m1525a(t.getBlockPos()) + ".animation.json");
    }

    @Override // com.boehmod.blockfront.C0275eW, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: c */
    public ResourceLocation getModelResource(@NotNull T t) {
        return C0532jO.m2378d("geo/block/decoration_" + C0549jf.f3265aC + "_" + m1525a(t.getBlockPos()) + ".geo.json");
    }

    @Override // com.boehmod.blockfront.C0275eW, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b */
    public ResourceLocation getTextureResource(@NotNull T t) {
        return C0532jO.m2378d("textures/block/entity/decoration_" + C0549jf.f3265aC + "_" + m1525a(t.getBlockPos()) + ".png");
    }

    @Override // com.boehmod.blockfront.C0275eW
    @NotNull
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo1521a(@NotNull T t) {
        return C0532jO.m2378d("block/entity/decoration_" + C0549jf.f3265aC + "_" + m1525a(t.getBlockPos()));
    }
}
