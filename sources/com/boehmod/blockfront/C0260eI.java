package com.boehmod.blockfront;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: renamed from: com.boehmod.blockfront.eI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eI.class */
public class C0260eI<T extends BlockEntity & GeoAnimatable> extends C0261eJ<T> {

    /* JADX INFO: renamed from: iq */
    private static final int f2067iq = 8;

    /* JADX INFO: renamed from: a */
    public static int m1446a(@NotNull BlockPos blockPos) {
        return new Random(((((long) blockPos.getX()) * 73856093) ^ (((long) blockPos.getY()) * 19349663)) ^ (((long) blockPos.getZ()) * 83492791)).nextInt(8);
    }

    @Override // com.boehmod.blockfront.C0261eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: d */
    public ResourceLocation getAnimationResource(@NotNull T t) {
        return C0564jv.m2555d("animations/block/decoration_" + C0476iM.f2916aw + "_" + m1446a(t.getBlockPos()) + ".animation.json");
    }

    @Override // com.boehmod.blockfront.C0261eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: c */
    public ResourceLocation getModelResource(@NotNull T t) {
        return C0564jv.m2555d("geo/block/decoration_" + C0476iM.f2916aw + "_" + m1446a(t.getBlockPos()) + ".geo.json");
    }

    @Override // com.boehmod.blockfront.C0261eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b */
    public ResourceLocation getTextureResource(@NotNull T t) {
        return C0564jv.m2555d("textures/block/entity/decoration_" + C0476iM.f2916aw + "_" + m1446a(t.getBlockPos()) + ".png");
    }

    @Override // com.boehmod.blockfront.C0261eJ
    @NotNull
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo1442a(@NotNull T t) {
        return C0564jv.m2555d("block/entity/decoration_" + C0476iM.f2916aw + "_" + m1446a(t.getBlockPos()));
    }
}
