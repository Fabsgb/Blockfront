package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.af, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/af.class */
public class C0008af extends AbstractC0003aa {
    private static final int av = 600;
    private static final int aw = 1;
    private static final int ax = 8;
    private static final int ay = 6;
    private static final int az = 12;
    private static final int aA = 144;
    private int aB = 20;
    private int aC = 2;
    private int aD = 3;
    private static final float v = 0.04f;
    private static final float w = 0.6f;

    @Override // com.boehmod.blockfront.AbstractC0003aa
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        if (f <= 0.0f) {
            return;
        }
        if (this.aD > 0) {
            int i = this.aC;
            this.aC = i - 1;
            if (i <= 0) {
                this.aD--;
                this.aC = 2;
                if (this.aD <= 0) {
                    float fNextFloat = randomSource.nextFloat() * 360.0f;
                    Vec3 vec3Add = vec3.add(Mth.cos(fNextFloat) * 32.0f, 0.0d, Mth.sin(fNextFloat) * 32.0f);
                    clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C0624xc.ED.get(), SoundSource.WEATHER, 15.0f, 0.9f + (0.2f * randomSource.nextFloat()), false);
                }
                clientLevel.setSkyFlashTime(1);
            }
        }
        int i2 = this.aB;
        this.aB = i2 - 1;
        if (i2 <= 0) {
            this.aB = 600;
            if (randomSource.nextFloat() < 0.6f * f) {
                this.aD = 3;
            }
        }
        SimpleParticleType simpleParticleType = (SimpleParticleType) wZ.nZ.get();
        float f2 = 5.7599998f * f;
        int i3 = (int) f2;
        if (randomSource.nextFloat() < f2 - i3) {
            i3++;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int iNextInt = randomSource.nextInt(12) - 6;
            int iNextInt2 = randomSource.nextInt(12) - 6;
            BlockPos blockPosOffset = blockPos.offset(iNextInt, 8, iNextInt2);
            if (!clientLevel.getBlockState(blockPosOffset).canOcclude()) {
                Vec3 vec3Add2 = vec3.add(iNextInt, 8.0d, iNextInt2);
                if (!(clientLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, blockPosOffset.getX(), blockPosOffset.getZ()) > Mth.floor(vec3Add2.y))) {
                    iG.a(minecraft, c0297l, clientLevel, simpleParticleType, vec3Add2.x, vec3Add2.y, vec3Add2.z, 0.0d, 0.0d, 0.0d);
                }
            }
        }
    }
}
