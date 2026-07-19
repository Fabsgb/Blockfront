package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2LongMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kn.class */
public class C0284kn extends C0292kv implements kE {

    @NotNull
    private static final VoxelShape b = Block.box(2.0d, 2.0d, 2.0d, 14.0d, 15.0d, 14.0d);
    private static final int kj = 15000;

    @NotNull
    private final Object2LongMap<BlockPos> a;

    public C0284kn(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        this.a = new Object2LongOpenHashMap();
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return b;
    }

    @Override // com.boehmod.blockfront.kE
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.a.getOrDefault(blockPos, 0L) < 15000) {
            return;
        }
        this.a.put(blockPos, jCurrentTimeMillis);
        float fNextFloat = 0.9f + (0.2f * clientLevel.random.nextFloat());
        clientLevel.playLocalSound(blockPos, (SoundEvent) C0624xc.tl.get(), SoundSource.BLOCKS, 5.0f, fNextFloat, false);
        clientLevel.playLocalSound(blockPos, (SoundEvent) C0624xc.tm.get(), SoundSource.BLOCKS, 40.0f, fNextFloat, false);
    }

    @Override // com.boehmod.blockfront.kE
    public boolean ak() {
        return false;
    }
}
