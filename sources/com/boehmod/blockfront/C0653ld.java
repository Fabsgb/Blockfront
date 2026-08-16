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

/* JADX INFO: renamed from: com.boehmod.blockfront.ld */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ld.class */
public class C0653ld extends Block implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final DirectionProperty f3662k = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final EnumProperty<Half> f3663a = BlockStateProperties.HALF;

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final BooleanProperty f3664k = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final VoxelShape f3665g = Block.box(0.0d, 0.0d, 0.0d, 16.0d, 3.0d, 16.0d);

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final VoxelShape f3666h = Block.box(0.0d, 13.0d, 0.0d, 16.0d, 16.0d, 16.0d);

    public C0653ld(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3662k, Direction.NORTH)).setValue(f3663a, Half.BOTTOM)).setValue(f3664k, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return blockState.getValue(f3663a) == Half.TOP ? f3666h : f3665g;
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
        return (BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(f3662k, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(f3663a, half)).setValue(f3664k, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }

    @NotNull
    public BlockState updateShape(@NotNull BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(f3664k)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @NotNull
    public FluidState getFluidState(@NotNull BlockState blockState) {
        return ((Boolean) blockState.getValue(f3664k)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @NotNull
    public BlockState rotate(@NotNull BlockState blockState, @NotNull Rotation rotation) {
        return (BlockState) blockState.setValue(f3662k, rotation.rotate(blockState.getValue(f3662k)));
    }

    @NotNull
    public BlockState mirror(@NotNull BlockState blockState, @NotNull Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f3662k)));
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3662k, f3663a, f3664k});
    }
}
