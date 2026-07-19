package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aj.class */
public class C0012aj extends AbstractC0003aa {
    private static final int aO = 32;

    @Override // com.boehmod.blockfront.AbstractC0003aa
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        if (f > 0.0f && randomSource.nextFloat() < 0.65f * f) {
            int iNextInt = randomSource.nextInt(64) - 32;
            int iNextInt2 = randomSource.nextInt(64) - 32;
            BlockPos blockPos2 = new BlockPos(blockPos.getX() + iNextInt, clientLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, blockPos.getX() + iNextInt, blockPos.getZ() + iNextInt2) - 1, blockPos.getZ() + iNextInt2);
            iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.og.get(), blockPos2.getX() + 0.5f, blockPos2.getY() + 0.1f, blockPos2.getZ() + 0.5f, 0.0d, 0.0d, 0.0d);
        }
    }
}
