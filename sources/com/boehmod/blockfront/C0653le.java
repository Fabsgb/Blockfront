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

/* JADX INFO: renamed from: com.boehmod.blockfront.le */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/le.class */
public class C0653le extends C0617kv implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: t */
    @NotNull
    private static final DirectionProperty f3548t = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final BooleanProperty f3549y = BooleanProperty.create("full");

    /* JADX INFO: renamed from: o */
    @NotNull
    private static final C0641lS f3550o = new C0641lS(0.0f, 0.0f, 15.0f, 16.0f, 16.0f, 16.0f);

    public C0653le(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) defaultBlockState().setValue(f3549y, false));
    }

    @Override // com.boehmod.blockfront.C0617kv
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{f3549y});
    }

    @Override // com.boehmod.blockfront.C0617kv
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState stateForPlacement = super.getStateForPlacement(blockPlaceContext);
        if (stateForPlacement != null) {
            Level level = blockPlaceContext.getLevel();
            BlockPos clickedPos = blockPlaceContext.getClickedPos();
            stateForPlacement = (BlockState) stateForPlacement.setValue(f3549y, Boolean.valueOf(m2911a((BlockGetter) level, clickedPos, stateForPlacement)));
            m2912a(level, clickedPos, stateForPlacement);
        }
        return stateForPlacement;
    }

    public void onPlace(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState2, boolean z) {
        super.onPlace(blockState, level, blockPos, blockState2, z);
        if (!level.isClientSide() && !blockState2.is(this)) {
            m2912a(level, blockPos, blockState);
        }
    }

    public void onRemove(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState2, boolean z) {
        super.onRemove(blockState, level, blockPos, blockState2, z);
        if (!level.isClientSide() && !blockState2.is(this)) {
            BlockPos blockPosAbove = blockPos.above();
            BlockState blockState3 = level.getBlockState(blockPosAbove);
            if ((blockState3.getBlock() instanceof C0653le) && ((Boolean) blockState3.getValue(f3549y)).booleanValue()) {
                level.setBlock(blockPosAbove, (BlockState) blockState3.setValue(f3549y, false), 3);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0617kv
    @NotNull
    public BlockState updateShape(BlockState blockState, Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        boolean zM2911a;
        BlockState blockStateUpdateShape = super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        if (direction == Direction.DOWN && ((Boolean) blockState.getValue(f3549y)).booleanValue() != (zM2911a = m2911a((BlockGetter) levelAccessor, blockPos, blockState))) {
            blockStateUpdateShape = (BlockState) blockStateUpdateShape.setValue(f3549y, Boolean.valueOf(zM2911a));
        }
        return blockStateUpdateShape;
    }

    /* JADX INFO: renamed from: a */
    private boolean m2911a(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        BlockState blockState2 = blockGetter.getBlockState(blockPos.below());
        return (blockState2.getBlock() instanceof C0653le) && blockState.getValue(f3548t) == ((Direction) blockState2.getValue(f3548t));
    }

    /* JADX INFO: renamed from: a */
    private void m2912a(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        BlockPos blockPosAbove = blockPos.above();
        BlockState blockState2 = level.getBlockState(blockPosAbove);
        if ((blockState2.getBlock() instanceof C0653le) && blockState.getValue(f3548t) == ((Direction) blockState2.getValue(f3548t)) && !((Boolean) blockState2.getValue(f3549y)).booleanValue()) {
            level.setBlock(blockPosAbove, (BlockState) blockState2.setValue(f3549y, true), 3);
        }
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3550o.m2835a((Direction) blockState.getValue(f3548t));
    }
}
