package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.lE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lE.class */
public class C0628lE extends C0632lI {

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final MapCodec<C0628lE> f3598j = simpleCodec(properties -> {
        return new C0628lE(properties, null);
    });

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final IntegerProperty f3599f = C0649lZ.f3653k;

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final IntegerProperty f3600g = C0649lZ.f3654l;

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final IntegerProperty f3601h = C0649lZ.f3655m;

    /* JADX INFO: renamed from: v */
    @NotNull
    private static final DirectionProperty f3602v = BlockStateProperties.HORIZONTAL_FACING;

    public C0628lE(@NotNull BlockBehaviour.Properties properties, @Nullable DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> deferredHolder) {
        super(properties, deferredHolder);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3602v, Direction.NORTH)).setValue(f3599f, 0)).setValue(f3600g, 0)).setValue(f3601h, 0));
    }

    @Override // com.boehmod.blockfront.C0632lI
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.replacingClickedOnBlock()) {
            BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().offset(blockPlaceContext.getClickedFace().getOpposite().getNormal()));
            if (blockState.getBlock() == this && blockState.getValue(f3602v) == blockPlaceContext.getClickedFace()) {
                return null;
            }
        }
        BlockState blockStateDefaultBlockState = defaultBlockState();
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockStateDefaultBlockState = (BlockState) blockStateDefaultBlockState.setValue(f3602v, direction);
            }
        }
        return blockStateDefaultBlockState;
    }

    @Override // com.boehmod.blockfront.C0632lI
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return f3598j;
    }

    @Override // com.boehmod.blockfront.C0632lI
    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(f3602v, rotation.rotate(blockState.getValue(f3602v)));
    }

    @Override // com.boehmod.blockfront.C0632lI
    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f3602v)));
    }

    @Override // com.boehmod.blockfront.C0632lI
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3602v, f3599f, f3600g, f3601h});
    }
}
