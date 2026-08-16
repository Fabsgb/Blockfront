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

/* JADX INFO: renamed from: com.boehmod.blockfront.am */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/am.class */
public class C0069am extends AbstractC0063ag {

    /* JADX INFO: renamed from: C */
    private static final float f461C = 0.25f;

    /* JADX INFO: renamed from: D */
    private static final float f462D = 0.75f;

    /* JADX INFO: renamed from: E */
    private static final float f463E = 0.65f;

    /* JADX INFO: renamed from: F */
    private static final float f464F = 512.0f;

    /* JADX INFO: renamed from: G */
    private static final float f465G = 6.0f;

    /* JADX INFO: renamed from: H */
    private static final float f466H = 45.0f;

    /* JADX INFO: renamed from: I */
    private static final float f467I = 256.0f;

    /* JADX INFO: renamed from: J */
    private static final float f468J = 80.0f;

    /* JADX INFO: renamed from: K */
    private static final float f469K = -16.0f;

    /* JADX INFO: renamed from: L */
    private static final float f470L = 0.01f;

    /* JADX INFO: renamed from: bs */
    private static final int f471bs = 6;

    /* JADX INFO: renamed from: bt */
    private static final int f472bt = 12;

    /* JADX INFO: renamed from: bu */
    private static final int f473bu = 1728;

    /* JADX INFO: renamed from: bv */
    private static final int f474bv = 4;

    /* JADX INFO: renamed from: M */
    private float f477M = 0.0f;

    /* JADX INFO: renamed from: S */
    private boolean f478S = true;

    /* JADX INFO: renamed from: a */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0477iM f479a;

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final ResourceLocation f460n = C0532jO.m2378d("textures/misc/overlay_sandstorm.png");

    /* JADX INFO: renamed from: e */
    private static final Vec3 f475e = new Vec3(Math.cos(Math.toRadians(45.0d)), 0.0d, Math.sin(Math.toRadians(45.0d)));

    /* JADX INFO: renamed from: f */
    private static final Vec3 f476f = new Vec3(-f475e.z, 0.0d, f475e.x);

    @Override // com.boehmod.blockfront.AbstractC0063ag
    /* JADX INFO: renamed from: a */
    public void mo278a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        this.f478S = f > this.f477M;
        this.f477M = f;
        float fClamp = Mth.clamp(f / 0.75f, 0.0f, 1.0f);
        float f2 = f464F - (506.0f * fClamp);
        if (!this.f478S) {
            f2 = -f2;
        }
        Vec3 vec3Add = vec3.add(f475e.scale(f2)).add(0.0d, -16.0d, 0.0d);
        float f3 = f468J * fClamp;
        int i = 4;
        if (f > 0.75f) {
            i = (int) (4.0f * (1.0f - ((f - 0.75f) / 0.25f)));
        }
        float fM283d = m283d(f);
        if (this.f479a == null) {
            this.f479a = new C0477iM((SoundEvent) C1312xz.f8794Fj.get());
            minecraft.getSoundManager().play(this.f479a);
        }
        this.f479a.m2142f(fM283d * c0623l.m2869a().m2289O());
        for (int i2 = 0; i2 < i; i2++) {
            Vec3 vec3Add2 = vec3Add.add(f476f.scale((randomSource.nextDouble() - 0.5d) * 256.0d)).add(0.0d, randomSource.nextDouble() * ((double) f3), 0.0d);
            if (clientLevel.getBlockState(BlockPos.containing(vec3Add2)).isAir()) {
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7893od.get(), vec3Add2.x, vec3Add2.y, vec3Add2.z, 0.0d, 0.0d, 0.0d);
            }
        }
        if (fM283d > 0.0f) {
            float f4 = 17.279999f * fM283d;
            int i3 = (int) f4;
            if (randomSource.nextFloat() < f4 - i3) {
                i3++;
            }
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            for (int i4 = 0; i4 < i3; i4++) {
                int iNextInt = randomSource.nextInt(12) - 6;
                int iNextInt2 = randomSource.nextInt(12) - 6;
                int iNextInt3 = randomSource.nextInt(12) - 6;
                mutableBlockPos.setWithOffset(blockPos, iNextInt, iNextInt2, iNextInt3);
                if (!clientLevel.getBlockState(mutableBlockPos).canOcclude() && clientLevel.canSeeSky(mutableBlockPos)) {
                    C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7894oe.get(), vec3.x + ((double) iNextInt), vec3.y + ((double) iNextInt2), vec3.z + ((double) iNextInt3), 0.0d, 0.0d, 0.0d);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0063ag
    /* JADX INFO: renamed from: a */
    public void mo279a(@NotNull Minecraft minecraft, C0623l c0623l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        float fM283d = m283d(f2);
        if (fM283d <= 0.0f) {
            return;
        }
        C0129bt.m655a(guiGraphics, f460n, fM283d * 0.25f * c0623l.m2869a().m2288n(f));
    }

    /* JADX INFO: renamed from: d */
    private static float m283d(float f) {
        return Math.max(0.0f, (f - f463E) / 0.35000002f);
    }

    @Override // com.boehmod.blockfront.AbstractC0063ag
    /* JADX INFO: renamed from: c */
    public void mo280c(@NotNull Minecraft minecraft, @NotNull C0623l c0623l) {
        if (this.f479a != null) {
            minecraft.getSoundManager().stop(this.f479a);
            this.f479a = null;
        }
    }
}
