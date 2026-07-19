package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wI.class */
public final class wI {
    private wI() {
    }

    @NotNull
    public static C0563uw a(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockPos blockPos) {
        C0563uw c0563uw = C0563uw.ak.get(blockState.getBlock());
        if (c0563uw != null) {
            return c0563uw;
        }
        C0563uw c0563uw2 = C0563uw.al.get(blockState.getSoundType(level, blockPos, (Entity) null));
        return c0563uw2 != null ? c0563uw2 : a();
    }

    @NotNull
    private static C0563uw a() {
        return new C0563uw(null, C0565uy.a(C0265jv.d("stone")), false, false);
    }
}
