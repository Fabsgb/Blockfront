package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kO.class */
public class C0585kO extends BaseEntityBlock implements InterfaceC0596kZ {

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final MapCodec<C0585kO> f3368d = simpleCodec(C0585kO::new);

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final DirectionProperty f3369d = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final IntegerProperty f3370c = C0649lZ.f3653k;

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final IntegerProperty f3371d = C0649lZ.f3654l;

    public C0585kO(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3369d, Direction.NORTH)).setValue(f3370c, 0)).setValue(f3371d, 0));
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return f3368d;
    }

    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) C1293xg.f6933bJ.get()).create(blockPos, blockState);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return (localPlayer == null || !localPlayer.isCreative()) ? RenderShape.INVISIBLE : RenderShape.MODEL;
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return Shapes.empty();
    }

    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        return (BlockState) defaultBlockState().setValue(f3369d, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    @NotNull
    public BlockState rotate(@NotNull BlockState blockState, @NotNull Rotation rotation) {
        return (BlockState) blockState.setValue(f3369d, rotation.rotate(blockState.getValue(f3369d)));
    }

    @NotNull
    public BlockState mirror(@NotNull BlockState blockState, @NotNull Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f3369d)));
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3369d, f3370c, f3371d});
    }

    @NotNull
    public InteractionResult useWithoutItem(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        if (!player.isCreative()) {
            return InteractionResult.PASS;
        }
        if (level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof C0713mk) {
                a.m2620a((C0713mk) blockEntity);
            }
        }
        return InteractionResult.SUCCESS;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.kO$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kO$a.class */
    @OnlyIn(Dist.CLIENT)
    private static final class a {
        private a() {
        }

        /* JADX INFO: renamed from: a */
        static void m2620a(@NotNull C0713mk c0713mk) {
            Minecraft.getInstance().setScreen(new C0147cK(c0713mk));
        }
    }
}
