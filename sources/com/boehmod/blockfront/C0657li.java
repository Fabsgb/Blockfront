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

/* JADX INFO: renamed from: com.boehmod.blockfront.li */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/li.class */
public class C0657li extends C0661lm {

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final MapCodec<C0657li> f3557j = simpleCodec(properties -> {
        return new C0657li(properties, null);
    });

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final IntegerProperty f3558f = C0626lD.f3399k;

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final IntegerProperty f3559g = C0626lD.f3400l;

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final IntegerProperty f3560h = C0626lD.f3401m;

    /* JADX INFO: renamed from: v */
    @NotNull
    private static final DirectionProperty f3561v = BlockStateProperties.HORIZONTAL_FACING;

    public C0657li(@NotNull BlockBehaviour.Properties properties, @Nullable DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> deferredHolder) {
        super(properties, deferredHolder);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3561v, Direction.NORTH)).setValue(f3558f, 0)).setValue(f3559g, 0)).setValue(f3560h, 0));
    }

    @Override // com.boehmod.blockfront.C0661lm
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.replacingClickedOnBlock()) {
            BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().offset(blockPlaceContext.getClickedFace().getOpposite().getNormal()));
            if (blockState.getBlock() == this && blockState.getValue(f3561v) == blockPlaceContext.getClickedFace()) {
                return null;
            }
        }
        BlockState blockStateDefaultBlockState = defaultBlockState();
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockStateDefaultBlockState = (BlockState) blockStateDefaultBlockState.setValue(f3561v, direction);
            }
        }
        return blockStateDefaultBlockState;
    }

    @Override // com.boehmod.blockfront.C0661lm
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return f3557j;
    }

    @Override // com.boehmod.blockfront.C0661lm
    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState) blockState.setValue(f3561v, rotation.rotate(blockState.getValue(f3561v)));
    }

    @Override // com.boehmod.blockfront.C0661lm
    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(f3561v)));
    }

    @Override // com.boehmod.blockfront.C0661lm
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3561v, f3558f, f3559g, f3560h});
    }
}
