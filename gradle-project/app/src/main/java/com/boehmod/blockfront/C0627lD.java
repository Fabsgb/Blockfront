package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.lD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lD.class */
public class C0627lD extends BaseEntityBlock implements InterfaceC0596kZ {

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final MapCodec<C0627lD> f3594i = simpleCodec(properties -> {
        return new C0627lD(properties, null);
    });

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final IntegerProperty f3595e = C0649lZ.f3655m;

    /* JADX INFO: renamed from: u */
    @NotNull
    private static final DirectionProperty f3596u = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: h */
    @Nullable
    private final DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> f3597h;

    public C0627lD(@NotNull BlockBehaviour.Properties properties, @Nullable DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> deferredHolder) {
        super(properties);
        this.f3597h = deferredHolder;
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3596u, Direction.NORTH)).setValue(f3595e, 0));
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return (localPlayer == null || !localPlayer.isCreative()) ? RenderShape.INVISIBLE : RenderShape.MODEL;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.replacingClickedOnBlock()) {
            BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().offset(blockPlaceContext.getClickedFace().getOpposite().getNormal()));
            if (blockState.getBlock() == this && blockState.getValue(f3596u) == blockPlaceContext.getClickedFace()) {
                return null;
            }
        }
        BlockState blockStateDefaultBlockState = defaultBlockState();
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockStateDefaultBlockState = (BlockState) blockStateDefaultBlockState.setValue(f3596u, direction);
            }
        }
        return blockStateDefaultBlockState;
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return f3594i;
    }

    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) this.f3597h.get()).create(blockPos, blockState);
    }

    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(f3596u, rotation.rotate(blockState.getValue(f3596u)));
    }

    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f3596u)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3596u, f3595e});
    }
}
