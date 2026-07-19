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

/* JADX INFO: renamed from: com.boehmod.blockfront.kx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kx.class */
public class C0294kx extends BaseEntityBlock {

    @NotNull
    private static final MapCodec<C0294kx> g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @NotNull
    private static final DirectionProperty f206g;

    @NotNull
    private static final BooleanProperty e;

    @NotNull
    protected static final VoxelShape d;
    private String bh;
    static final /* synthetic */ boolean dE;

    static {
        dE = !C0294kx.class.desiredAssertionStatus();
        g = simpleCodec(C0294kx::new);
        f206g = BlockStateProperties.HORIZONTAL_FACING;
        e = BlockStateProperties.WATERLOGGED;
        d = Block.box(0.0d, 0.0d, 0.0d, 16.0d, 13.0d, 16.0d);
    }

    public C0294kx(@NotNull String str, @NotNull BlockBehaviour.Properties properties) {
        this(properties);
        this.bh = str;
    }

    public C0294kx(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f206g, Direction.NORTH)).setValue(e, Boolean.FALSE));
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return g;
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return d;
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (direction.getOpposite() == blockState.getValue(f206g) && !blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        if (((Boolean) blockState.getValue(e)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        if (!blockPlaceContext.replacingClickedOnBlock()) {
            BlockState blockState = level.getBlockState(blockPlaceContext.getClickedPos().offset(blockPlaceContext.getClickedFace().getOpposite().getNormal()));
            if (blockState.getBlock() == this && blockState.getValue(f206g) == blockPlaceContext.getClickedFace()) {
                return null;
            }
        }
        BlockState blockStateDefaultBlockState = defaultBlockState();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = level.getFluidState(blockPlaceContext.getClickedPos());
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockStateDefaultBlockState = (BlockState) blockStateDefaultBlockState.setValue(f206g, direction.getOpposite());
                if (blockStateDefaultBlockState.canSurvive(level, clickedPos)) {
                    return (BlockState) blockStateDefaultBlockState.setValue(e, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
                }
            }
        }
        return null;
    }

    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(f206g, rotation.rotate(blockState.getValue(f206g)));
    }

    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f206g)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f206g, e});
    }

    @NotNull
    public FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(e)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
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
        return new lP(this.bh, blockPos, blockState);
    }

    @NotNull
    public InteractionResult useWithoutItem(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!dE && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof lP) {
            lP lPVar = (lP) blockEntity;
            Object objB = lPVar.b();
            if (objB instanceof qP) {
                qP qPVar = (qP) objB;
                if ((player instanceof ServerPlayer) && qPVar.a(abstractC0264juM166a, level, (ServerPlayer) player, lPVar)) {
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }
}
