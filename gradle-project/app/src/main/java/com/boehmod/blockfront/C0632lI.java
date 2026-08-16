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

/* JADX INFO: renamed from: com.boehmod.blockfront.lI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lI.class */
public class C0632lI extends BaseEntityBlock implements InterfaceC0596kZ {

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final MapCodec<C0632lI> f3610k = simpleCodec(properties -> {
        return new C0632lI(properties, null);
    });

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final IntegerProperty f3611i = C0649lZ.f3653k;

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final IntegerProperty f3612j = C0649lZ.f3654l;

    /* JADX INFO: renamed from: y */
    @NotNull
    private static final DirectionProperty f3613y = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: i */
    @Nullable
    private final DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> f3614i;

    public C0632lI(@NotNull BlockBehaviour.Properties properties, @Nullable DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> deferredHolder) {
        super(properties);
        this.f3614i = deferredHolder;
        registerDefaultState((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3613y, Direction.NORTH)).setValue(f3611i, 0)).setValue(f3612j, 0));
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> m2906b() {
        return this.f3614i;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.replacingClickedOnBlock()) {
            BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().offset(blockPlaceContext.getClickedFace().getOpposite().getNormal()));
            if (blockState.getBlock() == this && blockState.getValue(f3613y) == blockPlaceContext.getClickedFace()) {
                return null;
            }
        }
        BlockState blockStateDefaultBlockState = defaultBlockState();
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockStateDefaultBlockState = (BlockState) blockStateDefaultBlockState.setValue(f3613y, direction);
            }
        }
        return blockStateDefaultBlockState;
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return f3610k;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return (localPlayer == null || !localPlayer.isCreative()) ? RenderShape.INVISIBLE : RenderShape.MODEL;
    }

    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        if (this.f3614i == null) {
            return null;
        }
        return ((BlockEntityType) this.f3614i.get()).create(blockPos, blockState);
    }

    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(f3613y, rotation.rotate(blockState.getValue(f3613y)));
    }

    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f3613y)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3613y, f3611i, f3612j});
    }
}
