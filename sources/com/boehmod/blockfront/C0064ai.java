package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ai */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ai.class */
public class C0064ai extends AbstractC0056aa {

    /* JADX INFO: renamed from: aJ */
    private static final int f438aJ = 3;

    /* JADX INFO: renamed from: aK */
    private static final int f439aK = 5;

    /* JADX INFO: renamed from: I */
    private static final float f440I = 0.02f;

    /* JADX INFO: renamed from: aL */
    private static final int f441aL = 6;

    /* JADX INFO: renamed from: aM */
    private static final int f442aM = 10;

    /* JADX INFO: renamed from: aN */
    private static final int f443aN = 360;

    @Override // com.boehmod.blockfront.AbstractC0056aa
    /* JADX INFO: renamed from: a */
    public void mo225a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        if (f <= 0.0f) {
            return;
        }
        float f2 = 7.2f * f;
        int i = (int) f2;
        if (randomSource.nextFloat() < f2 - i) {
            i++;
        }
        if (i <= 0) {
            return;
        }
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = randomSource.nextInt(6) - 3;
            int iNextInt2 = randomSource.nextInt(10) - 5;
            int iNextInt3 = randomSource.nextInt(6) - 3;
            mutableBlockPos.setWithOffset(blockPos, iNextInt, iNextInt2, iNextInt3);
            if (!clientLevel.getBlockState(mutableBlockPos).canOcclude() && clientLevel.canSeeSky(mutableBlockPos)) {
                C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7317nS.get(), vec3.x + ((double) iNextInt), vec3.y + ((double) iNextInt2), vec3.z + ((double) iNextInt3), 0.0d, 0.0d, 0.0d);
            }
        }
    }
}
