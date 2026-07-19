package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lj.class */
public class C0307lj extends C0305lh implements SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty w = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final lS p = new lS(0.0f, 0.0f, 14.0f, 16.0f, 16.0f, 16.0f);

    public C0307lj(@NotNull BlockBehaviour.Properties properties, DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> deferredHolder) {
        super(properties, deferredHolder);
    }

    @NotNull
    public VoxelShape getShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return p.a((Direction) blockState.getValue(w));
    }
}
