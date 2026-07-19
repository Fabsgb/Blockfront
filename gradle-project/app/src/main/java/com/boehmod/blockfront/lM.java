package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lM.class */
public class lM extends lN {
    public lM(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override // com.boehmod.blockfront.lN
    public boolean am() {
        return true;
    }
}
