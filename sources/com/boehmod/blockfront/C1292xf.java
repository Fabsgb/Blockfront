package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xf.class */
public final class C1292xf {
    private C1292xf() {
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1124uW m7328a(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockPos blockPos) {
        C1124uW c1124uW = C1124uW.f6154ak.get(blockState.getBlock());
        if (c1124uW != null) {
            return c1124uW;
        }
        C1124uW c1124uW2 = C1124uW.f6155al.get(blockState.getSoundType(level, blockPos, (Entity) null));
        return c1124uW2 != null ? c1124uW2 : m7329a();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C1124uW m7329a() {
        return new C1124uW(null, C1126uY.m6441a(C0532jO.m2378d("stone")), false, false);
    }
}
