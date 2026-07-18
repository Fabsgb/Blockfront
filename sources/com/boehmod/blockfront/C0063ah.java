package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ah */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ah.class */
public class C0063ah extends AbstractC0056aa {

    /* JADX INFO: renamed from: aI */
    private static final int f437aI = 32;

    @Override // com.boehmod.blockfront.AbstractC0056aa
    /* JADX INFO: renamed from: a */
    public void mo225a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        if (f > 0.0f && randomSource.nextFloat() < 0.5f * f) {
            int iNextInt = randomSource.nextInt(64) - 32;
            int iNextInt2 = randomSource.nextInt(64) - 32;
            BlockPos blockPos2 = new BlockPos(blockPos.getX() + iNextInt, clientLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, blockPos.getX() + iNextInt, blockPos.getZ() + iNextInt2) - 1, blockPos.getZ() + iNextInt2);
            C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7330of.get(), blockPos2.getX() + 0.5f, blockPos2.getY() + 0.1f, blockPos2.getZ() + 0.5f, 0.0d, 0.0d, 0.0d);
        }
    }
}
