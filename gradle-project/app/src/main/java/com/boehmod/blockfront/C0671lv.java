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

/* JADX INFO: renamed from: com.boehmod.blockfront.lv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lv.class */
public final class C0671lv extends Block {

    /* JADX INFO: renamed from: t */
    private static final BooleanProperty f3703t = BlockStateProperties.UP;

    /* JADX INFO: renamed from: u */
    private static final BooleanProperty f3704u = BlockStateProperties.DOWN;

    /* JADX INFO: renamed from: v */
    private static final BooleanProperty f3705v = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: w */
    private static final BooleanProperty f3706w = BlockStateProperties.LIT;

    /* JADX INFO: renamed from: l */
    private static final VoxelShape f3707l = Block.box(6.0d, 0.0d, 6.0d, 10.0d, 12.0d, 10.0d);

    /* JADX INFO: renamed from: m */
    private static final VoxelShape f3708m = Block.box(6.0d, 0.0d, 6.0d, 10.0d, 16.0d, 10.0d);

    public C0671lv(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3703t, Boolean.TRUE)).setValue(f3704u, Boolean.TRUE)).setValue(f3705v, Boolean.FALSE)).setValue(f3706w, Boolean.TRUE));
    }

    /* JADX INFO: renamed from: a */
    private boolean m2937a(@NotNull BlockState blockState) {
        return blockState.getBlock() instanceof C0671lv;
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return false;
    }

    public boolean propagatesSkylightDown(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return !((Boolean) blockState.getValue(f3705v)).booleanValue();
    }

    @NotNull
    public FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(f3705v)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return (!((Boolean) blockState.getValue(f3704u)).booleanValue() || ((Boolean) blockState.getValue(f3703t)).booleanValue()) ? f3708m : f3707l;
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return (!((Boolean) blockState.getValue(f3704u)).booleanValue() || ((Boolean) blockState.getValue(f3703t)).booleanValue()) ? f3707l : f3708m;
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        BlockPos blockPosAbove = clickedPos.above();
        BlockPos blockPosBelow = clickedPos.below();
        return (BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(f3703t, Boolean.valueOf(m2937a(level.getBlockState(blockPosAbove))))).setValue(f3704u, Boolean.valueOf(m2937a(level.getBlockState(blockPosBelow))))).setValue(f3705v, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(f3705v)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return (BlockState) ((BlockState) blockState.setValue(f3703t, Boolean.valueOf(direction == Direction.UP ? m2937a(blockState2) : ((Boolean) blockState.getValue(f3703t)).booleanValue()))).setValue(f3704u, Boolean.valueOf(direction == Direction.DOWN ? m2937a(blockState2) : ((Boolean) blockState.getValue(f3704u)).booleanValue()));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3703t, f3704u, f3705v, f3706w});
    }

    public int getLightEmission(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        if (((Boolean) blockState.getValue(f3703t)).booleanValue() || !((Boolean) blockState.getValue(f3704u)).booleanValue()) {
            return 0;
        }
        return super.getLightEmission(blockState, blockGetter, blockPos);
    }
}
