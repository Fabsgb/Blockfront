package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ai */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ai.class */
public class C0065ai extends AbstractC0063ag {

    /* JADX INFO: renamed from: aW */
    private static final int f431aW = 32;

    /* JADX INFO: renamed from: w */
    private static final float f432w = 4.0E-4f;

    /* JADX INFO: renamed from: aX */
    private static final int f433aX = 64;

    /* JADX INFO: renamed from: aY */
    private static final int f434aY = 262144;

    @Override // com.boehmod.blockfront.AbstractC0063ag
    /* JADX INFO: renamed from: a */
    public void mo278a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        if (f <= 0.0f) {
            return;
        }
        float f2 = 104.8576f * f;
        int i = (int) f2;
        if (randomSource.nextFloat() < f2 - i) {
            i++;
        }
        for (int i2 = 0; i2 < i; i2++) {
            BlockPos blockPosOffset = blockPos.offset(randomSource.nextInt(64) - 32, randomSource.nextInt(64) - 32, randomSource.nextInt(64) - 32);
            if (!clientLevel.getBlockState(blockPosOffset).canOcclude() && clientLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, blockPosOffset.getX(), blockPosOffset.getZ()) > blockPosOffset.getY() && (clientLevel.getBlockState(blockPosOffset.above()).getBlock() instanceof LeavesBlock)) {
                Vec3 center = blockPosOffset.getCenter();
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7855nr.get(), center.x, center.y + 0.5d, center.z, 0.0d, 0.0d, 0.0d);
            }
        }
    }
}
