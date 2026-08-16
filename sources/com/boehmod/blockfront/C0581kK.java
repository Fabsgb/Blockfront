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

/* JADX INFO: renamed from: com.boehmod.blockfront.kK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kK.class */
public final class C0581kK extends C0588kR implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final DirectionProperty f3356a = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final BooleanProperty f3357a = BooleanProperty.create("back");

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final BooleanProperty f3358b = BooleanProperty.create("left");

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final BooleanProperty f3359c = BooleanProperty.create("right");

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final C0717mo f3360a = new C0717mo(0.0f, 4.0f, 15.0f, 16.0f, 12.0f, 16.0f);

    /* JADX INFO: renamed from: G */
    @NotNull
    private static final Map<Direction, VoxelShape[]> f3361G = Maps.newEnumMap(Direction.class);

    static {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            VoxelShape[] voxelShapeArr = new VoxelShape[8];
            for (int i = 0; i < voxelShapeArr.length; i++) {
                VoxelShape voxelShapeM3266a = f3360a.m3266a(direction);
                if ((i & 1) != 0) {
                    voxelShapeM3266a = Shapes.or(voxelShapeM3266a, f3360a.m3266a(direction.getOpposite()));
                }
                if ((i & 2) != 0) {
                    voxelShapeM3266a = Shapes.or(voxelShapeM3266a, f3360a.m3266a(direction.getCounterClockWise()));
                }
                if ((i & 4) != 0) {
                    voxelShapeM3266a = Shapes.or(voxelShapeM3266a, f3360a.m3266a(direction.getClockWise()));
                }
                voxelShapeArr[i] = voxelShapeM3266a;
            }
            f3361G.put(direction, voxelShapeArr);
        }
    }

    public C0581kK(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(f3357a, Boolean.FALSE)).setValue(f3358b, Boolean.FALSE)).setValue(f3359c, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3361G.get(blockState.getValue(f3356a))[(((Boolean) blockState.getValue(f3357a)).booleanValue() ? (char) 1 : (char) 0) | (((Boolean) blockState.getValue(f3358b)).booleanValue() ? (char) 2 : (char) 0) | (((Boolean) blockState.getValue(f3359c)).booleanValue() ? 4 : 0)];
    }

    protected boolean canBeReplaced(@NotNull BlockState blockState, @NotNull BlockPlaceContext blockPlaceContext) {
        Direction directionM2618a;
        BooleanProperty booleanPropertyM2617a;
        return (!blockPlaceContext.getItemInHand().is(asItem()) || (directionM2618a = m2618a(blockPlaceContext)) == null || (booleanPropertyM2617a = m2617a(blockState.getValue(f3356a), directionM2618a)) == null || ((Boolean) blockState.getValue(booleanPropertyM2617a)).booleanValue()) ? false : true;
    }

    @Override // com.boehmod.blockfront.C0588kR
    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        BooleanProperty booleanPropertyM2617a;
        BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos());
        if (blockState.is(this)) {
            Direction directionM2618a = m2618a(blockPlaceContext);
            if (directionM2618a != null && (booleanPropertyM2617a = m2617a(blockState.getValue(f3356a), directionM2618a)) != null && !((Boolean) blockState.getValue(booleanPropertyM2617a)).booleanValue()) {
                return (BlockState) blockState.setValue(booleanPropertyM2617a, Boolean.TRUE);
            }
            return blockState;
        }
        return super.getStateForPlacement(blockPlaceContext);
    }

    @NotNull
    public List<ItemStack> getDrops(@NotNull BlockState blockState, @NotNull LootParams.Builder builder) {
        return List.of(new ItemStack(this, 1 + (((Boolean) blockState.getValue(f3357a)).booleanValue() ? 1 : 0) + (((Boolean) blockState.getValue(f3358b)).booleanValue() ? 1 : 0) + (((Boolean) blockState.getValue(f3359c)).booleanValue() ? 1 : 0)));
    }

    @Override // com.boehmod.blockfront.C0588kR
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{f3357a, f3358b, f3359c});
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static BooleanProperty m2617a(@NotNull Direction direction, @NotNull Direction direction2) {
        if (direction2 == direction.getOpposite()) {
            return f3357a;
        }
        if (direction2 == direction.getCounterClockWise()) {
            return f3358b;
        }
        if (direction2 == direction.getClockWise()) {
            return f3359c;
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static Direction m2618a(@NotNull BlockPlaceContext blockPlaceContext) {
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                return direction.getOpposite();
            }
        }
        return null;
    }
}
