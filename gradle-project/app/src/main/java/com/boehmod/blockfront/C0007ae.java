package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ae, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ae.class */
public class C0007ae extends AbstractC0003aa {
    private static final int aq = 4;
    private static final int ar = 6;
    private static final float u = 0.005f;
    private static final int as = 8;
    private static final int at = 12;
    private static final int au = 768;

    @Override // com.boehmod.blockfront.AbstractC0003aa
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
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
                iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.nS.get(), vec3.x + ((double) iNextInt), vec3.y + ((double) iNextInt2), vec3.z + ((double) iNextInt3), 0.0d, 0.0d, 0.0d);
            }
        }
    }
}
