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

/* JADX INFO: renamed from: com.boehmod.blockfront.ac, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ac.class */
public class C0005ac extends AbstractC0003aa {
    private static final int ai = 32;
    private static final float r = 4.0E-4f;
    private static final int aj = 64;
    private static final int ak = 262144;

    @Override // com.boehmod.blockfront.AbstractC0003aa
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
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
                iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.nr.get(), center.x, center.y + 0.5d, center.z, 0.0d, 0.0d, 0.0d);
            }
        }
    }
}
