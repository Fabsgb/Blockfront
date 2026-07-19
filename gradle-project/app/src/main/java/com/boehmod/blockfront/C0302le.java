package com.boehmod.blockfront;

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
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.le, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/le.class */
public class C0302le extends C0292kv implements SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty t = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    public static final BooleanProperty y = BooleanProperty.create("full");

    @NotNull
    private static final lS o = new lS(0.0f, 0.0f, 15.0f, 16.0f, 16.0f, 16.0f);

    public C0302le(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) defaultBlockState().setValue(y, false));
    }

    @Override // com.boehmod.blockfront.C0292kv
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{y});
    }

    @Override // com.boehmod.blockfront.C0292kv
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState stateForPlacement = super.getStateForPlacement(blockPlaceContext);
        if (stateForPlacement != null) {
            Level level = blockPlaceContext.getLevel();
            BlockPos clickedPos = blockPlaceContext.getClickedPos();
            stateForPlacement = (BlockState) stateForPlacement.setValue(y, Boolean.valueOf(a((BlockGetter) level, clickedPos, stateForPlacement)));
            a(level, clickedPos, stateForPlacement);
        }
        return stateForPlacement;
    }

    public void onPlace(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState2, boolean z) {
        super.onPlace(blockState, level, blockPos, blockState2, z);
        if (!level.isClientSide() && !blockState2.is(this)) {
            a(level, blockPos, blockState);
        }
    }

    public void onRemove(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState2, boolean z) {
        super.onRemove(blockState, level, blockPos, blockState2, z);
        if (!level.isClientSide() && !blockState2.is(this)) {
            BlockPos blockPosAbove = blockPos.above();
            BlockState blockState3 = level.getBlockState(blockPosAbove);
            if ((blockState3.getBlock() instanceof C0302le) && ((Boolean) blockState3.getValue(y)).booleanValue()) {
                level.setBlock(blockPosAbove, (BlockState) blockState3.setValue(y, false), 3);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0292kv
    @NotNull
    public BlockState updateShape(BlockState blockState, Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        boolean zA;
        BlockState blockStateUpdateShape = super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        if (direction == Direction.DOWN && ((Boolean) blockState.getValue(y)).booleanValue() != (zA = a((BlockGetter) levelAccessor, blockPos, blockState))) {
            blockStateUpdateShape = (BlockState) blockStateUpdateShape.setValue(y, Boolean.valueOf(zA));
        }
        return blockStateUpdateShape;
    }

    private boolean a(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        BlockState blockState2 = blockGetter.getBlockState(blockPos.below());
        return (blockState2.getBlock() instanceof C0302le) && blockState.getValue(t) == ((Direction) blockState2.getValue(t));
    }

    private void a(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        BlockPos blockPosAbove = blockPos.above();
        BlockState blockState2 = level.getBlockState(blockPosAbove);
        if ((blockState2.getBlock() instanceof C0302le) && blockState.getValue(t) == ((Direction) blockState2.getValue(t)) && !((Boolean) blockState2.getValue(y)).booleanValue()) {
            level.setBlock(blockPosAbove, (BlockState) blockState2.setValue(y, true), 3);
        }
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return o.a((Direction) blockState.getValue(t));
    }
}
