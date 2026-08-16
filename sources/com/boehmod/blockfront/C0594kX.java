package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kX.class */
public class C0594kX extends Block {

    /* JADX INFO: renamed from: f */
    @NotNull
    private final VoxelShape f3392f;

    public C0594kX(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        this.f3392f = Block.box(0.0d, 0.0d, 0.0d, 16.0d, 1.0d, 16.0d);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return this.f3392f;
    }
}
