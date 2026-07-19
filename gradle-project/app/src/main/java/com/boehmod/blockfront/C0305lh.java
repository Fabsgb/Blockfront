package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.lh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lh.class */
public class C0305lh extends BaseEntityBlock implements kD {

    @NotNull
    private static final MapCodec<C0305lh> i = simpleCodec(properties -> {
        return new C0305lh(properties, null);
    });

    @NotNull
    private static final IntegerProperty e = lD.m;

    @NotNull
    private static final DirectionProperty u = BlockStateProperties.HORIZONTAL_FACING;

    @Nullable
    private final DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> h;

    public C0305lh(@NotNull BlockBehaviour.Properties properties, @Nullable DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> deferredHolder) {
        super(properties);
        this.h = deferredHolder;
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(u, Direction.NORTH)).setValue(e, 0));
    }

    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.replacingClickedOnBlock()) {
            BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().offset(blockPlaceContext.getClickedFace().getOpposite().getNormal()));
            if (blockState.getBlock() == this && blockState.getValue(u) == blockPlaceContext.getClickedFace()) {
                return null;
            }
        }
        BlockState blockStateDefaultBlockState = defaultBlockState();
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockStateDefaultBlockState = (BlockState) blockStateDefaultBlockState.setValue(u, direction);
            }
        }
        return blockStateDefaultBlockState;
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return i;
    }

    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) this.h.get()).create(blockPos, blockState);
    }

    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(u, rotation.rotate(blockState.getValue(u)));
    }

    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(u)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{u, e});
    }
}
