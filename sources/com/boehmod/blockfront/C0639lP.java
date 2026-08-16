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

/* JADX INFO: renamed from: com.boehmod.blockfront.lP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lP.class */
public class C0639lP extends C0660lk implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: F */
    @NotNull
    private static final DirectionProperty f3629F = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: x */
    @NotNull
    private static final C0717mo f3630x = new C0717mo(0.0f, 0.0f, 14.0f, 16.0f, 16.0f, 16.0f);

    public C0639lP(@NotNull BlockBehaviour.Properties properties, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        super(properties, deferredHolder, deferredHolder2);
    }

    @Override // com.boehmod.blockfront.C0660lk
    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3630x.m3266a((Direction) blockState.getValue(f3629F));
    }
}
