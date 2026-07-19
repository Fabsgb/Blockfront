package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kH.class */
public class kH extends Block implements SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty k = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final EnumProperty<Half> a = BlockStateProperties.HALF;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    @NotNull
    private static final BooleanProperty f195k = BlockStateProperties.WATERLOGGED;

    @NotNull
    private static final VoxelShape g = Block.box(0.0d, 0.0d, 0.0d, 16.0d, 3.0d, 16.0d);

    @NotNull
    private static final VoxelShape h = Block.box(0.0d, 13.0d, 0.0d, 16.0d, 16.0d, 16.0d);

    public kH(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(k, Direction.NORTH)).setValue(a, Half.BOTTOM)).setValue(f195k, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return blockState.getValue(a) == Half.TOP ? h : g;
    }

    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        Half half;
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        Direction clickedFace = blockPlaceContext.getClickedFace();
        if (clickedFace != Direction.DOWN && (clickedFace == Direction.UP || blockPlaceContext.getClickLocation().y - ((double) blockPlaceContext.getClickedPos().getY()) <= 0.5d)) {
            half = Half.BOTTOM;
        } else {
            half = Half.TOP;
        }
        return (BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(k, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(a, half)).setValue(f195k, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }

    @NotNull
    public BlockState updateShape(@NotNull BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(f195k)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @NotNull
    public FluidState getFluidState(@NotNull BlockState blockState) {
        return ((Boolean) blockState.getValue(f195k)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @NotNull
    public BlockState rotate(@NotNull BlockState blockState, @NotNull Rotation rotation) {
        return (BlockState) blockState.setValue(k, rotation.rotate(blockState.getValue(k)));
    }

    @NotNull
    public BlockState mirror(@NotNull BlockState blockState, @NotNull Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(k)));
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{k, a, f195k});
    }
}
