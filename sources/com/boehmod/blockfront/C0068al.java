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

/* JADX INFO: renamed from: com.boehmod.blockfront.al */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/al.class */
public class C0068al extends AbstractC0063ag {

    /* JADX INFO: renamed from: bj */
    private static final int f449bj = 600;

    /* JADX INFO: renamed from: bk */
    private static final int f450bk = 1;

    /* JADX INFO: renamed from: bl */
    private static final int f451bl = 8;

    /* JADX INFO: renamed from: bm */
    private static final int f452bm = 6;

    /* JADX INFO: renamed from: bn */
    private static final int f453bn = 12;

    /* JADX INFO: renamed from: bo */
    private static final int f454bo = 144;

    /* JADX INFO: renamed from: bp */
    private int f455bp = 20;

    /* JADX INFO: renamed from: bq */
    private int f456bq = 2;

    /* JADX INFO: renamed from: br */
    private int f457br = 3;

    /* JADX INFO: renamed from: A */
    private static final float f458A = 0.04f;

    /* JADX INFO: renamed from: B */
    private static final float f459B = 0.6f;

    @Override // com.boehmod.blockfront.AbstractC0063ag
    /* JADX INFO: renamed from: a */
    public void mo278a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        if (f <= 0.0f) {
            return;
        }
        if (this.f457br > 0) {
            int i = this.f456bq;
            this.f456bq = i - 1;
            if (i <= 0) {
                this.f457br--;
                this.f456bq = 2;
                if (this.f457br <= 0) {
                    float fNextFloat = randomSource.nextFloat() * 360.0f;
                    Vec3 vec3Add = vec3.add(Mth.cos(fNextFloat) * 32.0f, 0.0d, Mth.sin(fNextFloat) * 32.0f);
                    clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1312xz.f8765EG.get(), SoundSource.WEATHER, 15.0f, 0.9f + (0.2f * randomSource.nextFloat()), false);
                }
                clientLevel.setSkyFlashTime(1);
            }
        }
        int i2 = this.f455bp;
        this.f455bp = i2 - 1;
        if (i2 <= 0) {
            this.f455bp = 600;
            if (randomSource.nextFloat() < 0.6f * f) {
                this.f457br = 3;
            }
        }
        SimpleParticleType simpleParticleType = (SimpleParticleType) C1309xw.f7891ob.get();
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
                    C0490iZ.m2218a(minecraft, c0623l, clientLevel, simpleParticleType, vec3Add2.x, vec3Add2.y, vec3Add2.z, 0.0d, 0.0d, 0.0d);
                }
            }
        }
    }
}
