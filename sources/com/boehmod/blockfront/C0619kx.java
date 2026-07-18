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

/* JADX INFO: renamed from: com.boehmod.blockfront.kx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kx.class */
public class C0619kx extends BaseEntityBlock {

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final MapCodec<C0619kx> f3346g;

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final DirectionProperty f3347g;

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final BooleanProperty f3348e;

    /* JADX INFO: renamed from: d */
    @NotNull
    protected static final VoxelShape f3349d;

    /* JADX INFO: renamed from: bh */
    private String f3350bh;

    /* JADX INFO: renamed from: dE */
    static final /* synthetic */ boolean f3351dE;

    static {
        f3351dE = !C0619kx.class.desiredAssertionStatus();
        f3346g = simpleCodec(C0619kx::new);
        f3347g = BlockStateProperties.HORIZONTAL_FACING;
        f3348e = BlockStateProperties.WATERLOGGED;
        f3349d = Block.box(0.0d, 0.0d, 0.0d, 16.0d, 13.0d, 16.0d);
    }

    public C0619kx(@NotNull String str, @NotNull BlockBehaviour.Properties properties) {
        this(properties);
        this.f3350bh = str;
    }

    public C0619kx(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3347g, Direction.NORTH)).setValue(f3348e, Boolean.FALSE));
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return f3346g;
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3349d;
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (direction.getOpposite() == blockState.getValue(f3347g) && !blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        if (((Boolean) blockState.getValue(f3348e)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        if (!blockPlaceContext.replacingClickedOnBlock()) {
            BlockState blockState = level.getBlockState(blockPlaceContext.getClickedPos().offset(blockPlaceContext.getClickedFace().getOpposite().getNormal()));
            if (blockState.getBlock() == this && blockState.getValue(f3347g) == blockPlaceContext.getClickedFace()) {
                return null;
            }
        }
        BlockState blockStateDefaultBlockState = defaultBlockState();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = level.getFluidState(blockPlaceContext.getClickedPos());
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockStateDefaultBlockState = (BlockState) blockStateDefaultBlockState.setValue(f3347g, direction.getOpposite());
                if (blockStateDefaultBlockState.canSurvive(level, clickedPos)) {
                    return (BlockState) blockStateDefaultBlockState.setValue(f3348e, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
                }
            }
        }
        return null;
    }

    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(f3347g, rotation.rotate(blockState.getValue(f3347g)));
    }

    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f3347g)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3347g, f3348e});
    }

    @NotNull
    public FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(f3348e)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
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
        return new C0638lP(this.f3350bh, blockPos, blockState);
    }

    @NotNull
    public InteractionResult useWithoutItem(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3351dE && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof C0638lP) {
            C0638lP c0638lP = (C0638lP) blockEntity;
            Object objM2831b = c0638lP.m2831b();
            if (objM2831b instanceof InterfaceC0903qP) {
                InterfaceC0903qP interfaceC0903qP = (InterfaceC0903qP) objM2831b;
                if ((player instanceof ServerPlayer) && interfaceC0903qP.mo4674a(abstractC0563juM168a, level, (ServerPlayer) player, c0638lP)) {
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }
}
