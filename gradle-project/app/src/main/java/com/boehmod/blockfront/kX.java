package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kX.class */
public final class kX extends C0292kv implements SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty r = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final BooleanProperty s = BlockStateProperties.WATERLOGGED;

    @NotNull
    private static final lS m = new lS(1.0f, 1.0f, 15.0f, 15.0f, 15.0f, 16.0f);

    public kX(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(r, Direction.NORTH)).setValue(s, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return m.a((Direction) blockState.getValue(r));
    }
}
