package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ag, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ag.class */
public class C0009ag extends AbstractC0003aa {
    private static final float x = 0.25f;
    private static final float y = 0.75f;
    private static final float z = 0.65f;
    private static final float A = 512.0f;
    private static final float B = 6.0f;
    private static final float C = 45.0f;
    private static final float D = 256.0f;
    private static final float E = 80.0f;
    private static final float F = -16.0f;
    private static final float G = 0.01f;
    private static final int aE = 6;
    private static final int aF = 12;
    private static final int aG = 1728;
    private static final int aH = 4;
    private float H = 0.0f;
    private boolean N = true;

    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0238iv a;

    @NotNull
    private static final ResourceLocation n = C0265jv.d("textures/misc/overlay_sandstorm.png");
    private static final Vec3 e = new Vec3(Math.cos(Math.toRadians(45.0d)), 0.0d, Math.sin(Math.toRadians(45.0d)));
    private static final Vec3 f = new Vec3(-e.z, 0.0d, e.x);

    @Override // com.boehmod.blockfront.AbstractC0003aa
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f2) {
        this.N = f2 > this.H;
        this.H = f2;
        float fClamp = Mth.clamp(f2 / 0.75f, 0.0f, 1.0f);
        float f3 = A - (506.0f * fClamp);
        if (!this.N) {
            f3 = -f3;
        }
        Vec3 vec3Add = vec3.add(e.scale(f3)).add(0.0d, -16.0d, 0.0d);
        float f4 = E * fClamp;
        int i = 4;
        if (f2 > 0.75f) {
            i = (int) (4.0f * (1.0f - ((f2 - 0.75f) / 0.25f)));
        }
        float fD = d(f2);
        if (this.a == null) {
            this.a = new C0238iv((SoundEvent) C0624xc.Ff.get());
            minecraft.getSoundManager().play(this.a);
        }
        this.a.h(fD * c0297l.m587a().O());
        for (int i2 = 0; i2 < i; i2++) {
            Vec3 vec3Add2 = vec3Add.add(f.scale((randomSource.nextDouble() - 0.5d) * 256.0d)).add(0.0d, randomSource.nextDouble() * ((double) f4), 0.0d);
            if (clientLevel.getBlockState(BlockPos.containing(vec3Add2)).isAir()) {
                iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.ob.get(), vec3Add2.x, vec3Add2.y, vec3Add2.z, 0.0d, 0.0d, 0.0d);
            }
        }
        if (fD > 0.0f) {
            float f5 = 17.279999f * fD;
            int i3 = (int) f5;
            if (randomSource.nextFloat() < f5 - i3) {
                i3++;
            }
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            for (int i4 = 0; i4 < i3; i4++) {
                int iNextInt = randomSource.nextInt(12) - 6;
                int iNextInt2 = randomSource.nextInt(12) - 6;
                int iNextInt3 = randomSource.nextInt(12) - 6;
                mutableBlockPos.setWithOffset(blockPos, iNextInt, iNextInt2, iNextInt3);
                if (!clientLevel.getBlockState(mutableBlockPos).canOcclude() && clientLevel.canSeeSky(mutableBlockPos)) {
                    iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.oc.get(), vec3.x + ((double) iNextInt), vec3.y + ((double) iNextInt2), vec3.z + ((double) iNextInt3), 0.0d, 0.0d, 0.0d);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0003aa
    public void a(@NotNull Minecraft minecraft, C0297l c0297l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f2, float f3) {
        float fD = d(f3);
        if (fD <= 0.0f) {
            return;
        }
        C0040bk.a(guiGraphics, n, fD * 0.25f * c0297l.m587a().n(f2));
    }

    private static float d(float f2) {
        return Math.max(0.0f, (f2 - z) / 0.35000002f);
    }

    @Override // com.boehmod.blockfront.AbstractC0003aa
    public void c(@NotNull Minecraft minecraft, @NotNull C0297l c0297l) {
        if (this.a != null) {
            minecraft.getSoundManager().stop(this.a);
            this.a = null;
        }
    }
}
