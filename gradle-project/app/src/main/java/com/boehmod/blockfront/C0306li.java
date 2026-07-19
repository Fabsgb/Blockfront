package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.li, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/li.class */
public class C0306li extends C0310lm {

    @NotNull
    private static final MapCodec<C0306li> j = simpleCodec(properties -> {
        return new C0306li(properties, null);
    });

    @NotNull
    private static final IntegerProperty f = lD.k;

    @NotNull
    private static final IntegerProperty g = lD.l;

    @NotNull
    private static final IntegerProperty h = lD.m;

    @NotNull
    private static final DirectionProperty v = BlockStateProperties.HORIZONTAL_FACING;

    public C0306li(@NotNull BlockBehaviour.Properties properties, @Nullable DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> deferredHolder) {
        super(properties, deferredHolder);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(v, Direction.NORTH)).setValue(f, 0)).setValue(g, 0)).setValue(h, 0));
    }

    @Override // com.boehmod.blockfront.C0310lm
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.replacingClickedOnBlock()) {
            BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().offset(blockPlaceContext.getClickedFace().getOpposite().getNormal()));
            if (blockState.getBlock() == this && blockState.getValue(v) == blockPlaceContext.getClickedFace()) {
                return null;
            }
        }
        BlockState blockStateDefaultBlockState = defaultBlockState();
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockStateDefaultBlockState = (BlockState) blockStateDefaultBlockState.setValue(v, direction);
            }
        }
        return blockStateDefaultBlockState;
    }

    @Override // com.boehmod.blockfront.C0310lm
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return j;
    }

    @Override // com.boehmod.blockfront.C0310lm
    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(v, rotation.rotate(blockState.getValue(v)));
    }

    @Override // com.boehmod.blockfront.C0310lm
    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(v)));
    }

    @Override // com.boehmod.blockfront.C0310lm
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{v, f, g, h});
    }
}
