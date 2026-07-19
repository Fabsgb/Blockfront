package com.boehmod.blockfront;

import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kv.class */
public class C0292kv extends Block implements SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty e = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final BooleanProperty d = BlockStateProperties.WATERLOGGED;

    public C0292kv(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(e, Direction.NORTH)).setValue(d, Boolean.FALSE));
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (direction.getOpposite() == blockState.getValue(e) && !blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        if (((Boolean) blockState.getValue(d)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        if (!blockPlaceContext.replacingClickedOnBlock()) {
            BlockState blockState = level.getBlockState(blockPlaceContext.getClickedPos().offset(blockPlaceContext.getClickedFace().getOpposite().getNormal()));
            if (blockState.getBlock() == this && blockState.getValue(e) == blockPlaceContext.getClickedFace()) {
                return null;
            }
        }
        BlockState blockStateDefaultBlockState = defaultBlockState();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = level.getFluidState(blockPlaceContext.getClickedPos());
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockStateDefaultBlockState = (BlockState) blockStateDefaultBlockState.setValue(e, direction.getOpposite());
                if (blockStateDefaultBlockState.canSurvive(level, clickedPos)) {
                    return (BlockState) blockStateDefaultBlockState.setValue(d, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
                }
            }
        }
        return null;
    }

    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(e, rotation.rotate(blockState.getValue(e)));
    }

    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(e)));
    }

    @OverridingMethodsMustInvokeSuper
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{e, d});
    }

    @NotNull
    public FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(d)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }
}
