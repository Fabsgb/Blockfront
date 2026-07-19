package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lk.class */
public final class C0308lk extends C0292kv implements kE, SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty x = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final BooleanProperty z = BlockStateProperties.WATERLOGGED;

    @NotNull
    private static final lS q = new lS(3.0f, 1.0f, 3.0f, 13.0f, 3.0f, 13.0f);
    private static final float hs = 0.1f;

    public C0308lk(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(x, Direction.NORTH)).setValue(z, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return q.a((Direction) blockState.getValue(x));
    }

    @NotNull
    public InteractionResult useWithoutItem(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        SoundEvent soundEvent;
        if (!level.isClientSide) {
            if (level.random.nextFloat() < 0.1f) {
                soundEvent = (SoundEvent) C0624xc.tt.get();
            } else {
                soundEvent = (SoundEvent) C0624xc.ts.get();
            }
            level.playSound((Player) null, blockPos, soundEvent, SoundSource.BLOCKS, 1.0f, 0.95f + (0.01f * level.random.nextInt(4)));
        }
        return InteractionResult.SUCCESS;
    }

    @Override // com.boehmod.blockfront.kE
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        clientLevel.playLocalSound(blockPos.getX() + 0.5f, blockPos.getY() + 0.5f, blockPos.getZ() + 0.5f, (SoundEvent) C0624xc.tr.get(), SoundSource.BLOCKS, 1.0f, 0.8f + (0.1f * clientLevel.random.nextInt(4)), false);
    }

    @Override // com.boehmod.blockfront.kE
    public boolean ak() {
        return false;
    }
}
