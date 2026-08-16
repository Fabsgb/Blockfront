package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kT.class */
public class C0590kT extends BaseEntityBlock {

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final MapCodec<C0590kT> f3378g;

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final DirectionProperty f3379g;

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final BooleanProperty f3380e;

    /* JADX INFO: renamed from: d */
    @NotNull
    protected static final VoxelShape f3381d;

    /* JADX INFO: renamed from: bq */
    private String f3382bq;

    /* JADX INFO: renamed from: dX */
    static final /* synthetic */ boolean f3383dX;

    static {
        f3383dX = !C0590kT.class.desiredAssertionStatus();
        f3378g = simpleCodec(C0590kT::new);
        f3379g = BlockStateProperties.HORIZONTAL_FACING;
        f3380e = BlockStateProperties.WATERLOGGED;
        f3381d = Block.box(0.0d, 0.0d, 0.0d, 16.0d, 13.0d, 16.0d);
    }

    public C0590kT(@NotNull String str, @NotNull BlockBehaviour.Properties properties) {
        this(properties);
        this.f3382bq = str;
    }

    public C0590kT(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3379g, Direction.NORTH)).setValue(f3380e, Boolean.FALSE));
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return f3378g;
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3381d;
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (direction.getOpposite() == blockState.getValue(f3379g) && !blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        if (((Boolean) blockState.getValue(f3380e)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        if (!blockPlaceContext.replacingClickedOnBlock()) {
            BlockState blockState = level.getBlockState(blockPlaceContext.getClickedPos().offset(blockPlaceContext.getClickedFace().getOpposite().getNormal()));
            if (blockState.getBlock() == this && blockState.getValue(f3379g) == blockPlaceContext.getClickedFace()) {
                return null;
            }
        }
        BlockState blockStateDefaultBlockState = defaultBlockState();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = level.getFluidState(blockPlaceContext.getClickedPos());
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockStateDefaultBlockState = (BlockState) blockStateDefaultBlockState.setValue(f3379g, direction.getOpposite());
                if (blockStateDefaultBlockState.canSurvive(level, clickedPos)) {
                    return (BlockState) blockStateDefaultBlockState.setValue(f3380e, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
                }
            }
        }
        return null;
    }

    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(f3379g, rotation.rotate(blockState.getValue(f3379g)));
    }

    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f3379g)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3379g, f3380e});
    }

    @NotNull
    public FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(f3380e)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return null;
    }

    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new C0714ml(this.f3382bq, blockPos, blockState);
    }

    @NotNull
    public InteractionResult useWithoutItem(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f3383dX && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof C0714ml) {
            C0714ml c0714ml = (C0714ml) blockEntity;
            Object objM3262b = c0714ml.m3262b();
            if (objM3262b instanceof InterfaceC0980rm) {
                InterfaceC0980rm interfaceC0980rm = (InterfaceC0980rm) objM3262b;
                if ((player instanceof ServerPlayer) && interfaceC0980rm.mo5340a(abstractC0531jNM179a, level, (ServerPlayer) player, c0714ml)) {
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }
}
