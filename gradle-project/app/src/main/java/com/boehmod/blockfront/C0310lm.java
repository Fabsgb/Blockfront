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

/* JADX INFO: renamed from: com.boehmod.blockfront.lm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lm.class */
public class C0310lm extends BaseEntityBlock implements kD {

    @NotNull
    private static final MapCodec<C0310lm> k = simpleCodec(properties -> {
        return new C0310lm(properties, null);
    });

    @NotNull
    private static final IntegerProperty i = lD.k;

    @NotNull
    private static final IntegerProperty j = lD.l;

    @NotNull
    private static final DirectionProperty y = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    @Nullable
    private final DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> f234i;

    public C0310lm(@NotNull BlockBehaviour.Properties properties, @Nullable DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> deferredHolder) {
        super(properties);
        this.f234i = deferredHolder;
        registerDefaultState((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(y, Direction.NORTH)).setValue(i, 0)).setValue(j, 0));
    }

    @Nullable
    public DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> b() {
        return this.f234i;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.replacingClickedOnBlock()) {
            BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().offset(blockPlaceContext.getClickedFace().getOpposite().getNormal()));
            if (blockState.getBlock() == this && blockState.getValue(y) == blockPlaceContext.getClickedFace()) {
                return null;
            }
        }
        BlockState blockStateDefaultBlockState = defaultBlockState();
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockStateDefaultBlockState = (BlockState) blockStateDefaultBlockState.setValue(y, direction);
            }
        }
        return blockStateDefaultBlockState;
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return k;
    }

    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        if (this.f234i == null) {
            return null;
        }
        return ((BlockEntityType) this.f234i.get()).create(blockPos, blockState);
    }

    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(y, rotation.rotate(blockState.getValue(y)));
    }

    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(y)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{y, i, j});
    }
}
