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

/* JADX INFO: renamed from: com.boehmod.blockfront.kZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kZ.class */
public final class C0595kZ extends Block {

    /* JADX INFO: renamed from: t */
    private static final BooleanProperty f3291t = BlockStateProperties.UP;

    /* JADX INFO: renamed from: u */
    private static final BooleanProperty f3292u = BlockStateProperties.DOWN;

    /* JADX INFO: renamed from: v */
    private static final BooleanProperty f3293v = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: w */
    private static final BooleanProperty f3294w = BlockStateProperties.LIT;

    /* JADX INFO: renamed from: l */
    private static final VoxelShape f3295l = Block.box(6.0d, 0.0d, 6.0d, 10.0d, 12.0d, 10.0d);

    /* JADX INFO: renamed from: m */
    private static final VoxelShape f3296m = Block.box(6.0d, 0.0d, 6.0d, 10.0d, 16.0d, 10.0d);

    public C0595kZ(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3291t, Boolean.TRUE)).setValue(f3292u, Boolean.TRUE)).setValue(f3293v, Boolean.FALSE)).setValue(f3294w, Boolean.TRUE));
    }

    /* JADX INFO: renamed from: a */
    private boolean m2611a(@NotNull BlockState blockState) {
        return blockState.getBlock() instanceof C0595kZ;
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return false;
    }

    public boolean propagatesSkylightDown(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return !((Boolean) blockState.getValue(f3293v)).booleanValue();
    }

    @NotNull
    public FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(f3293v)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return (!((Boolean) blockState.getValue(f3292u)).booleanValue() || ((Boolean) blockState.getValue(f3291t)).booleanValue()) ? f3296m : f3295l;
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return (!((Boolean) blockState.getValue(f3292u)).booleanValue() || ((Boolean) blockState.getValue(f3291t)).booleanValue()) ? f3295l : f3296m;
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        BlockPos blockPosAbove = clickedPos.above();
        BlockPos blockPosBelow = clickedPos.below();
        return (BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(f3291t, Boolean.valueOf(m2611a(level.getBlockState(blockPosAbove))))).setValue(f3292u, Boolean.valueOf(m2611a(level.getBlockState(blockPosBelow))))).setValue(f3293v, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(f3293v)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return (BlockState) ((BlockState) blockState.setValue(f3291t, Boolean.valueOf(direction == Direction.UP ? m2611a(blockState2) : ((Boolean) blockState.getValue(f3291t)).booleanValue()))).setValue(f3292u, Boolean.valueOf(direction == Direction.DOWN ? m2611a(blockState2) : ((Boolean) blockState.getValue(f3292u)).booleanValue()));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3291t, f3292u, f3293v, f3294w});
    }

    public int getLightEmission(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        if (((Boolean) blockState.getValue(f3291t)).booleanValue() || !((Boolean) blockState.getValue(f3292u)).booleanValue()) {
            return 0;
        }
        return super.getLightEmission(blockState, blockGetter, blockPos);
    }
}
