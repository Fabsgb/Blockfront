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

/* JADX INFO: renamed from: com.boehmod.blockfront.kJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kJ.class */
public class C0580kJ extends C0588kR implements InterfaceC0650la {

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final VoxelShape f3353b = Block.box(2.0d, 2.0d, 2.0d, 14.0d, 15.0d, 14.0d);

    /* JADX INFO: renamed from: mg */
    private static final int f3354mg = 15000;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Object2LongMap<BlockPos> f3355b;

    public C0580kJ(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        this.f3355b = new Object2LongOpenHashMap();
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3353b;
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f3355b.getOrDefault(blockPos, 0L) < 15000) {
            return;
        }
        this.f3355b.put(blockPos, jCurrentTimeMillis);
        float fNextFloat = 0.9f + (0.2f * clientLevel.random.nextFloat());
        clientLevel.playLocalSound(blockPos, (SoundEvent) C1312xz.f8173tm.get(), SoundSource.BLOCKS, 5.0f, fNextFloat, false);
        clientLevel.playLocalSound(blockPos, (SoundEvent) C1312xz.f8174tn.get(), SoundSource.BLOCKS, 40.0f, fNextFloat, false);
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: au */
    public boolean mo2616au() {
        return false;
    }
}
