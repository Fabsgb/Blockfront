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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kQ.class */
public final class kQ extends C0292kv implements SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty o = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final BooleanProperty q = BlockStateProperties.WATERLOGGED;

    @NotNull
    private final lS h;

    public kQ(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        this.h = new lS(5.0f, 5.0f, 12.0f, 11.0f, 11.0f, 16.0f);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(o, Direction.NORTH)).setValue(q, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return this.h.a((Direction) blockState.getValue(o));
    }
}
