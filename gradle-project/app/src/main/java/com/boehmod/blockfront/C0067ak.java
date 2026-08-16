package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ak */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ak.class */
public class C0067ak extends AbstractC0063ag {

    /* JADX INFO: renamed from: be */
    private static final int f443be = 4;

    /* JADX INFO: renamed from: bf */
    private static final int f444bf = 6;

    /* JADX INFO: renamed from: z */
    private static final float f445z = 0.005f;

    /* JADX INFO: renamed from: bg */
    private static final int f446bg = 8;

    /* JADX INFO: renamed from: bh */
    private static final int f447bh = 12;

    /* JADX INFO: renamed from: bi */
    private static final int f448bi = 768;

    @Override // com.boehmod.blockfront.AbstractC0063ag
    /* JADX INFO: renamed from: a */
    public void mo278a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        if (f <= 0.0f) {
            return;
        }
        float f2 = 3.84f * f;
        int i = (int) f2;
        if (randomSource.nextFloat() < f2 - i) {
            i++;
        }
        if (i <= 0) {
            return;
        }
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = randomSource.nextInt(8) - 4;
            int iNextInt2 = randomSource.nextInt(12) - 6;
            int iNextInt3 = randomSource.nextInt(8) - 4;
            mutableBlockPos.setWithOffset(blockPos, iNextInt, iNextInt2, iNextInt3);
            if (!clientLevel.getBlockState(mutableBlockPos).canOcclude() && clientLevel.canSeeSky(mutableBlockPos)) {
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7882nS.get(), vec3.x + ((double) iNextInt), vec3.y + ((double) iNextInt2), vec3.z + ((double) iNextInt3), 0.0d, 0.0d, 0.0d);
            }
        }
    }
}
