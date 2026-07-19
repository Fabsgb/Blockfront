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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kT.class */
public final class kT extends SlabBlock {

    @NotNull
    private static final DirectionProperty q = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final EnumProperty<SlabType> b = BlockStateProperties.SLAB_TYPE;

    @NotNull
    private static final lS j = new lS(0.0f, 0.0f, 2.0f, 16.0f, 8.0f, 14.0f);

    @NotNull
    private static final lS k = new lS(0.0f, 8.0f, 2.0f, 16.0f, 16.0f, 14.0f);

    @NotNull
    private static final lS l = new lS(0.0f, 0.0f, 2.0f, 16.0f, 16.0f, 14.0f);

    public kT(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) getStateDefinition().any().setValue(q, Direction.NORTH));
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (direction.getOpposite() == blockState.getValue(q) && !blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        BlockState stateForPlacement = super.getStateForPlacement(blockPlaceContext);
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                stateForPlacement = (BlockState) stateForPlacement.setValue(q, direction.getOpposite());
            }
        }
        return stateForPlacement;
    }

    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(q, rotation.rotate(blockState.getValue(q)));
    }

    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(q)));
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{q});
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.kT$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kT$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] k = new int[SlabType.values().length];

        static {
            try {
                k[SlabType.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                k[SlabType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        Direction value = blockState.getValue(q);
        switch (AnonymousClass1.k[blockState.getValue(b).ordinal()]) {
            case 1:
                return k.a(value);
            case 2:
                return l.a(value);
            default:
                return j.a(value);
        }
    }
}
