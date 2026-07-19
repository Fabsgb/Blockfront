package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kY.class */
public class kY extends Block implements SimpleWaterloggedBlock {

    @NotNull
    protected static final VoxelShape k = Block.box(0.0d, 0.0d, 0.0d, 16.0d, 0.25d, 16.0d);

    public kY(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) getStateDefinition().any().setValue(BlockStateProperties.WATERLOGGED, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return k;
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(BlockStateProperties.WATERLOGGED)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockState blockStateDefaultBlockState = defaultBlockState();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = level.getFluidState(blockPlaceContext.getClickedPos());
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal() && blockStateDefaultBlockState.canSurvive(level, clickedPos)) {
                return (BlockState) blockStateDefaultBlockState.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
            }
        }
        return null;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BlockStateProperties.WATERLOGGED});
    }

    @NotNull
    public FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(BlockStateProperties.WATERLOGGED)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    protected boolean propagatesSkylightDown(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return blockState.getFluidState().isEmpty();
    }
}
