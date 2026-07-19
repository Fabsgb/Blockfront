package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lu.class */
public class C0318lu extends C0292kv implements kE {

    @NotNull
    private static final VoxelShape r = Block.box(5.0d, 3.0d, 5.0d, 11.0d, 16.0d, 11.0d);

    public C0318lu(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    private static void a(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        level.playLocalSound(blockPos, (SoundEvent) C0624xc.tp.get(), SoundSource.BLOCKS, 0.3f, 0.98f + (randomSource.nextFloat() * 0.02f), false);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return r;
    }

    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        super.animateTick(blockState, level, blockPos, randomSource);
        if (randomSource.nextInt(40) == 0) {
            a(level, blockPos, randomSource);
        }
    }

    @Override // com.boehmod.blockfront.kE
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        a(clientLevel, blockPos, clientLevel.getRandom());
    }

    @Override // com.boehmod.blockfront.kE
    public boolean ak() {
        return false;
    }
}
