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

/* JADX INFO: renamed from: com.boehmod.blockfront.lF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lF.class */
public class C0629lF extends C0627lD implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: w */
    @NotNull
    private static final DirectionProperty f3603w = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: p */
    @NotNull
    private static final C0717mo f3604p = new C0717mo(0.0f, 0.0f, 14.0f, 16.0f, 16.0f, 16.0f);

    public C0629lF(@NotNull BlockBehaviour.Properties properties, DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> deferredHolder) {
        super(properties, deferredHolder);
    }

    @NotNull
    public VoxelShape getShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3604p.m3266a((Direction) blockState.getValue(f3603w));
    }
}
