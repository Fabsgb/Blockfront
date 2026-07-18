package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kT.class */
public final class C0589kT extends SlabBlock {

    /* JADX INFO: renamed from: q */
    @NotNull
    private static final DirectionProperty f3279q = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final EnumProperty<SlabType> f3280b = BlockStateProperties.SLAB_TYPE;

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final C0641lS f3281j = new C0641lS(0.0f, 0.0f, 2.0f, 16.0f, 8.0f, 14.0f);

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final C0641lS f3282k = new C0641lS(0.0f, 8.0f, 2.0f, 16.0f, 16.0f, 14.0f);

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final C0641lS f3283l = new C0641lS(0.0f, 0.0f, 2.0f, 16.0f, 16.0f, 14.0f);

    public C0589kT(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) getStateDefinition().any().setValue(f3279q, Direction.NORTH));
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (direction.getOpposite() == blockState.getValue(f3279q) && !blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        BlockState stateForPlacement = super.getStateForPlacement(blockPlaceContext);
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                stateForPlacement = (BlockState) stateForPlacement.setValue(f3279q, direction.getOpposite());
            }
        }
        return stateForPlacement;
    }

    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(f3279q, rotation.rotate(blockState.getValue(f3279q)));
    }

    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f3279q)));
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{f3279q});
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.kT$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kT$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: k */
        static final /* synthetic */ int[] f3284k = new int[SlabType.values().length];

        static {
            try {
                f3284k[SlabType.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3284k[SlabType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        Direction value = blockState.getValue(f3279q);
        switch (AnonymousClass1.f3284k[blockState.getValue(f3280b).ordinal()]) {
            case 1:
                return f3282k.m2835a(value);
            case 2:
                return f3283l.m2835a(value);
            default:
                return f3281j.m2835a(value);
        }
    }
}
