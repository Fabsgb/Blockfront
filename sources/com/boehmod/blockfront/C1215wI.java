package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wI.class */
public final class C1215wI {
    private C1215wI() {
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1149uw m6740a(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockPos blockPos) {
        C1149uw c1149uw = C1149uw.f6085ak.get(blockState.getBlock());
        if (c1149uw != null) {
            return c1149uw;
        }
        C1149uw c1149uw2 = C1149uw.f6086al.get(blockState.getSoundType(level, blockPos, (Entity) null));
        return c1149uw2 != null ? c1149uw2 : m6741a();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C1149uw m6741a() {
        return new C1149uw(null, C1151uy.m6455a(C0564jv.m2555d("stone")), false, false);
    }
}
