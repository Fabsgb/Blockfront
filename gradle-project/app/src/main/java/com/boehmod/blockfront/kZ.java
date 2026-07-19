package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kZ.class */
public final class kZ extends Block {
    private static final BooleanProperty t = BlockStateProperties.UP;
    private static final BooleanProperty u = BlockStateProperties.DOWN;
    private static final BooleanProperty v = BlockStateProperties.WATERLOGGED;
    private static final BooleanProperty w = BlockStateProperties.LIT;
    private static final VoxelShape l = Block.box(6.0d, 0.0d, 6.0d, 10.0d, 12.0d, 10.0d);
    private static final VoxelShape m = Block.box(6.0d, 0.0d, 6.0d, 10.0d, 16.0d, 10.0d);

    public kZ(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(t, Boolean.TRUE)).setValue(u, Boolean.TRUE)).setValue(v, Boolean.FALSE)).setValue(w, Boolean.TRUE));
    }

    private boolean a(@NotNull BlockState blockState) {
        return blockState.getBlock() instanceof kZ;
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return false;
    }

    public boolean propagatesSkylightDown(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return !((Boolean) blockState.getValue(v)).booleanValue();
    }

    @NotNull
    public FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(v)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return (!((Boolean) blockState.getValue(u)).booleanValue() || ((Boolean) blockState.getValue(t)).booleanValue()) ? m : l;
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return (!((Boolean) blockState.getValue(u)).booleanValue() || ((Boolean) blockState.getValue(t)).booleanValue()) ? l : m;
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        BlockPos blockPosAbove = clickedPos.above();
        BlockPos blockPosBelow = clickedPos.below();
        return (BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(t, Boolean.valueOf(a(level.getBlockState(blockPosAbove))))).setValue(u, Boolean.valueOf(a(level.getBlockState(blockPosBelow))))).setValue(v, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(v)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return (BlockState) ((BlockState) blockState.setValue(t, Boolean.valueOf(direction == Direction.UP ? a(blockState2) : ((Boolean) blockState.getValue(t)).booleanValue()))).setValue(u, Boolean.valueOf(direction == Direction.DOWN ? a(blockState2) : ((Boolean) blockState.getValue(u)).booleanValue()));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{t, u, v, w});
    }

    public int getLightEmission(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        if (((Boolean) blockState.getValue(t)).booleanValue() || !((Boolean) blockState.getValue(u)).booleanValue()) {
            return 0;
        }
        return super.getLightEmission(blockState, blockGetter, blockPos);
    }
}
