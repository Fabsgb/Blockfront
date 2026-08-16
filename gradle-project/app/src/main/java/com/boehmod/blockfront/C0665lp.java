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

/* JADX INFO: renamed from: com.boehmod.blockfront.lp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lp.class */
public final class C0665lp extends SlabBlock {

    /* JADX INFO: renamed from: q */
    @NotNull
    private static final DirectionProperty f3691q = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final EnumProperty<SlabType> f3692b = BlockStateProperties.SLAB_TYPE;

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final C0717mo f3693j = new C0717mo(0.0f, 0.0f, 2.0f, 16.0f, 8.0f, 14.0f);

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final C0717mo f3694k = new C0717mo(0.0f, 8.0f, 2.0f, 16.0f, 16.0f, 14.0f);

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final C0717mo f3695l = new C0717mo(0.0f, 0.0f, 2.0f, 16.0f, 16.0f, 14.0f);

    public C0665lp(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) getStateDefinition().any().setValue(f3691q, Direction.NORTH));
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (direction.getOpposite() == blockState.getValue(f3691q) && !blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        BlockState stateForPlacement = super.getStateForPlacement(blockPlaceContext);
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                stateForPlacement = (BlockState) stateForPlacement.setValue(f3691q, direction.getOpposite());
            }
        }
        return stateForPlacement;
    }

    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(f3691q, rotation.rotate(blockState.getValue(f3691q)));
    }

    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f3691q)));
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{f3691q});
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.lp$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lp$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: m */
        static final /* synthetic */ int[] f3696m = new int[SlabType.values().length];

        static {
            try {
                f3696m[SlabType.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3696m[SlabType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        Direction value = blockState.getValue(f3691q);
        switch (AnonymousClass1.f3696m[blockState.getValue(f3692b).ordinal()]) {
            case 1:
                return f3694k.m3266a(value);
            case 2:
                return f3695l.m3266a(value);
            default:
                return f3693j.m3266a(value);
        }
    }
}
