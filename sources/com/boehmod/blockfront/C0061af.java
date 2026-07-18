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

/* JADX INFO: renamed from: com.boehmod.blockfront.af */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/af.class */
public class C0061af extends AbstractC0056aa {

    /* JADX INFO: renamed from: av */
    private static final int f406av = 600;

    /* JADX INFO: renamed from: aw */
    private static final int f407aw = 1;

    /* JADX INFO: renamed from: ax */
    private static final int f408ax = 8;

    /* JADX INFO: renamed from: ay */
    private static final int f409ay = 6;

    /* JADX INFO: renamed from: az */
    private static final int f410az = 12;

    /* JADX INFO: renamed from: aA */
    private static final int f411aA = 144;

    /* JADX INFO: renamed from: aB */
    private int f412aB = 20;

    /* JADX INFO: renamed from: aC */
    private int f413aC = 2;

    /* JADX INFO: renamed from: aD */
    private int f414aD = 3;

    /* JADX INFO: renamed from: v */
    private static final float f415v = 0.04f;

    /* JADX INFO: renamed from: w */
    private static final float f416w = 0.6f;

    @Override // com.boehmod.blockfront.AbstractC0056aa
    /* JADX INFO: renamed from: a */
    public void mo225a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        if (f <= 0.0f) {
            return;
        }
        if (this.f414aD > 0) {
            int i = this.f413aC;
            this.f413aC = i - 1;
            if (i <= 0) {
                this.f414aD--;
                this.f413aC = 2;
                if (this.f414aD <= 0) {
                    float fNextFloat = randomSource.nextFloat() * 360.0f;
                    Vec3 vec3Add = vec3.add(Mth.cos(fNextFloat) * 32.0f, 0.0d, Mth.sin(fNextFloat) * 32.0f);
                    clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1280xc.f8352ED.get(), SoundSource.WEATHER, 15.0f, 0.9f + (0.2f * randomSource.nextFloat()), false);
                }
                clientLevel.setSkyFlashTime(1);
            }
        }
        int i2 = this.f412aB;
        this.f412aB = i2 - 1;
        if (i2 <= 0) {
            this.f412aB = 600;
            if (randomSource.nextFloat() < 0.6f * f) {
                this.f414aD = 3;
            }
        }
        SimpleParticleType simpleParticleType = (SimpleParticleType) C1232wZ.f7324nZ.get();
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
                    C0470iG.m2126a(minecraft, c0622l, clientLevel, simpleParticleType, vec3Add2.x, vec3Add2.y, vec3Add2.z, 0.0d, 0.0d, 0.0d);
                }
            }
        }
    }
}
