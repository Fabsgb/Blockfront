package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lt.class */
public class C0317lt extends kO implements SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty F = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final lS x = new lS(0.0f, 0.0f, 14.0f, 16.0f, 16.0f, 16.0f);

    public C0317lt(@NotNull BlockBehaviour.Properties properties, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        super(properties, deferredHolder, deferredHolder2);
    }

    @Override // com.boehmod.blockfront.kO
    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return x.a((Direction) blockState.getValue(F));
    }
}
