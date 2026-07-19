package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.Minecraft;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ks, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ks.class */
public class C0289ks extends BaseEntityBlock implements kD {

    @NotNull
    private static final MapCodec<C0289ks> d = simpleCodec(C0289ks::new);

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NotNull
    private static final DirectionProperty f203d = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final IntegerProperty c = lD.k;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NotNull
    private static final IntegerProperty f204d = lD.l;

    public C0289ks(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f203d, Direction.NORTH)).setValue(c, 0)).setValue(f204d, 0));
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return d;
    }

    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) wJ.bJ.get()).create(blockPos, blockState);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return Shapes.empty();
    }

    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        return (BlockState) defaultBlockState().setValue(f203d, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    @NotNull
    public BlockState rotate(@NotNull BlockState blockState, @NotNull Rotation rotation) {
        return (BlockState) blockState.setValue(f203d, rotation.rotate(blockState.getValue(f203d)));
    }

    @NotNull
    public BlockState mirror(@NotNull BlockState blockState, @NotNull Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f203d)));
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f203d, c, f204d});
    }

    @NotNull
    public InteractionResult useWithoutItem(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        if (!player.isCreative()) {
            return InteractionResult.PASS;
        }
        if (level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof lO) {
                a.a((lO) blockEntity);
            }
        }
        return InteractionResult.SUCCESS;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ks$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ks$a.class */
    @OnlyIn(Dist.CLIENT)
    private static final class a {
        private a() {
        }

        static void a(@NotNull lO lOVar) {
            Minecraft.getInstance().setScreen(new cB(lOVar));
        }
    }
}
