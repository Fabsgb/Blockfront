package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.lo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lo.class */
public class C0312lo extends C0293kw {

    @NotNull
    private static final DirectionProperty A = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final lS s = new lS(0.0f, 0.0f, 14.0f, 16.0f, 16.0f, 16.0f);

    public C0312lo(@NotNull BlockBehaviour.Properties properties, @Nullable DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<?>> deferredHolder) {
        super(properties, deferredHolder);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return s.a((Direction) blockState.getValue(A));
    }
}
