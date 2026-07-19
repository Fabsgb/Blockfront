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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kR.class */
public final class kR extends C0292kv implements SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty p = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final BooleanProperty r = BlockStateProperties.WATERLOGGED;

    @NotNull
    private final lS i;

    public kR(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        this.i = new lS(1.0f, 3.0f, 15.0f, 15.0f, 14.0f, 16.0f);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(p, Direction.NORTH)).setValue(r, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return this.i.a((Direction) blockState.getValue(p));
    }
}
