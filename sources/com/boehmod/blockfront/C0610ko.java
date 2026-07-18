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

/* JADX INFO: renamed from: com.boehmod.blockfront.ko */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ko.class */
public final class C0610ko extends C0617kv implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final DirectionProperty f3324a = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final BooleanProperty f3325a = BooleanProperty.create("back");

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final BooleanProperty f3326b = BooleanProperty.create("left");

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final BooleanProperty f3327c = BooleanProperty.create("right");

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final C0641lS f3328a = new C0641lS(0.0f, 4.0f, 15.0f, 16.0f, 12.0f, 16.0f);

    /* JADX INFO: renamed from: G */
    @NotNull
    private static final Map<Direction, VoxelShape[]> f3329G = Maps.newEnumMap(Direction.class);

    static {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            VoxelShape[] voxelShapeArr = new VoxelShape[8];
            for (int i = 0; i < voxelShapeArr.length; i++) {
                VoxelShape voxelShapeM2835a = f3328a.m2835a(direction);
                if ((i & 1) != 0) {
                    voxelShapeM2835a = Shapes.or(voxelShapeM2835a, f3328a.m2835a(direction.getOpposite()));
                }
                if ((i & 2) != 0) {
                    voxelShapeM2835a = Shapes.or(voxelShapeM2835a, f3328a.m2835a(direction.getCounterClockWise()));
                }
                if ((i & 4) != 0) {
                    voxelShapeM2835a = Shapes.or(voxelShapeM2835a, f3328a.m2835a(direction.getClockWise()));
                }
                voxelShapeArr[i] = voxelShapeM2835a;
            }
            f3329G.put(direction, voxelShapeArr);
        }
    }

    public C0610ko(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(f3325a, Boolean.FALSE)).setValue(f3326b, Boolean.FALSE)).setValue(f3327c, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3329G.get(blockState.getValue(f3324a))[(((Boolean) blockState.getValue(f3325a)).booleanValue() ? (char) 1 : (char) 0) | (((Boolean) blockState.getValue(f3326b)).booleanValue() ? (char) 2 : (char) 0) | (((Boolean) blockState.getValue(f3327c)).booleanValue() ? 4 : 0)];
    }

    protected boolean canBeReplaced(@NotNull BlockState blockState, @NotNull BlockPlaceContext blockPlaceContext) {
        Direction directionM2663a;
        BooleanProperty booleanPropertyM2662a;
        return (!blockPlaceContext.getItemInHand().is(asItem()) || (directionM2663a = m2663a(blockPlaceContext)) == null || (booleanPropertyM2662a = m2662a(blockState.getValue(f3324a), directionM2663a)) == null || ((Boolean) blockState.getValue(booleanPropertyM2662a)).booleanValue()) ? false : true;
    }

    @Override // com.boehmod.blockfront.C0617kv
    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        BooleanProperty booleanPropertyM2662a;
        BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos());
        if (blockState.is(this)) {
            Direction directionM2663a = m2663a(blockPlaceContext);
            if (directionM2663a != null && (booleanPropertyM2662a = m2662a(blockState.getValue(f3324a), directionM2663a)) != null && !((Boolean) blockState.getValue(booleanPropertyM2662a)).booleanValue()) {
                return (BlockState) blockState.setValue(booleanPropertyM2662a, Boolean.TRUE);
            }
            return blockState;
        }
        return super.getStateForPlacement(blockPlaceContext);
    }

    @NotNull
    public List<ItemStack> getDrops(@NotNull BlockState blockState, @NotNull LootParams.Builder builder) {
        return List.of(new ItemStack(this, 1 + (((Boolean) blockState.getValue(f3325a)).booleanValue() ? 1 : 0) + (((Boolean) blockState.getValue(f3326b)).booleanValue() ? 1 : 0) + (((Boolean) blockState.getValue(f3327c)).booleanValue() ? 1 : 0)));
    }

    @Override // com.boehmod.blockfront.C0617kv
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{f3325a, f3326b, f3327c});
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static BooleanProperty m2662a(@NotNull Direction direction, @NotNull Direction direction2) {
        if (direction2 == direction.getOpposite()) {
            return f3325a;
        }
        if (direction2 == direction.getCounterClockWise()) {
            return f3326b;
        }
        if (direction2 == direction.getClockWise()) {
            return f3327c;
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static Direction m2663a(@NotNull BlockPlaceContext blockPlaceContext) {
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                return direction.getOpposite();
            }
        }
        return null;
    }
}
