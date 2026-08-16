package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ap */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ap.class */
public class C0072ap extends AbstractC0063ag {

    /* JADX INFO: renamed from: bC */
    private static final int f487bC = 32;

    @Override // com.boehmod.blockfront.AbstractC0063ag
    /* JADX INFO: renamed from: a */
    public void mo278a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        if (f > 0.0f && randomSource.nextFloat() < 0.65f * f) {
            int iNextInt = randomSource.nextInt(64) - 32;
            int iNextInt2 = randomSource.nextInt(64) - 32;
            BlockPos blockPos2 = new BlockPos(blockPos.getX() + iNextInt, clientLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, blockPos.getX() + iNextInt, blockPos.getZ() + iNextInt2) - 1, blockPos.getZ() + iNextInt2);
            C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7898oi.get(), blockPos2.getX() + 0.5f, blockPos2.getY() + 0.1f, blockPos2.getZ() + 0.5f, 0.0d, 0.0d, 0.0d);
        }
    }
}
