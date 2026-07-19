package com.boehmod.blockfront;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ko, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ko.class */
public final class C0285ko extends C0292kv implements SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty a = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final BooleanProperty f198a = BooleanProperty.create("back");

    @NotNull
    public static final BooleanProperty b = BooleanProperty.create("left");

    @NotNull
    public static final BooleanProperty c = BooleanProperty.create("right");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private static final lS f199a = new lS(0.0f, 4.0f, 15.0f, 16.0f, 12.0f, 16.0f);

    @NotNull
    private static final Map<Direction, VoxelShape[]> G = Maps.newEnumMap(Direction.class);

    static {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            VoxelShape[] voxelShapeArr = new VoxelShape[8];
            for (int i = 0; i < voxelShapeArr.length; i++) {
                VoxelShape voxelShapeA = f199a.a(direction);
                if ((i & 1) != 0) {
                    voxelShapeA = Shapes.or(voxelShapeA, f199a.a(direction.getOpposite()));
                }
                if ((i & 2) != 0) {
                    voxelShapeA = Shapes.or(voxelShapeA, f199a.a(direction.getCounterClockWise()));
                }
                if ((i & 4) != 0) {
                    voxelShapeA = Shapes.or(voxelShapeA, f199a.a(direction.getClockWise()));
                }
                voxelShapeArr[i] = voxelShapeA;
            }
            G.put(direction, voxelShapeArr);
        }
    }

    public C0285ko(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(f198a, Boolean.FALSE)).setValue(b, Boolean.FALSE)).setValue(c, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return G.get(blockState.getValue(a))[(((Boolean) blockState.getValue(f198a)).booleanValue() ? (char) 1 : (char) 0) | (((Boolean) blockState.getValue(b)).booleanValue() ? (char) 2 : (char) 0) | (((Boolean) blockState.getValue(c)).booleanValue() ? 4 : 0)];
    }

    protected boolean canBeReplaced(@NotNull BlockState blockState, @NotNull BlockPlaceContext blockPlaceContext) {
        Direction directionA;
        BooleanProperty booleanPropertyA;
        return (!blockPlaceContext.getItemInHand().is(asItem()) || (directionA = a(blockPlaceContext)) == null || (booleanPropertyA = a(blockState.getValue(a), directionA)) == null || ((Boolean) blockState.getValue(booleanPropertyA)).booleanValue()) ? false : true;
    }

    @Override // com.boehmod.blockfront.C0292kv
    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        BooleanProperty booleanPropertyA;
        BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos());
        if (blockState.is(this)) {
            Direction directionA = a(blockPlaceContext);
            if (directionA != null && (booleanPropertyA = a(blockState.getValue(a), directionA)) != null && !((Boolean) blockState.getValue(booleanPropertyA)).booleanValue()) {
                return (BlockState) blockState.setValue(booleanPropertyA, Boolean.TRUE);
            }
            return blockState;
        }
        return super.getStateForPlacement(blockPlaceContext);
    }

    @NotNull
    public List<ItemStack> getDrops(@NotNull BlockState blockState, @NotNull LootParams.Builder builder) {
        return List.of(new ItemStack(this, 1 + (((Boolean) blockState.getValue(f198a)).booleanValue() ? 1 : 0) + (((Boolean) blockState.getValue(b)).booleanValue() ? 1 : 0) + (((Boolean) blockState.getValue(c)).booleanValue() ? 1 : 0)));
    }

    @Override // com.boehmod.blockfront.C0292kv
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{f198a, b, c});
    }

    @Nullable
    private static BooleanProperty a(@NotNull Direction direction, @NotNull Direction direction2) {
        if (direction2 == direction.getOpposite()) {
            return f198a;
        }
        if (direction2 == direction.getCounterClockWise()) {
            return b;
        }
        if (direction2 == direction.getClockWise()) {
            return c;
        }
        return null;
    }

    @Nullable
    private static Direction a(@NotNull BlockPlaceContext blockPlaceContext) {
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                return direction.getOpposite();
            }
        }
        return null;
    }
}
