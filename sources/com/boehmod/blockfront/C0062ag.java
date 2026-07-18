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

/* JADX INFO: renamed from: com.boehmod.blockfront.ag */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ag.class */
public class C0062ag extends AbstractC0056aa {

    /* JADX INFO: renamed from: x */
    private static final float f418x = 0.25f;

    /* JADX INFO: renamed from: y */
    private static final float f419y = 0.75f;

    /* JADX INFO: renamed from: z */
    private static final float f420z = 0.65f;

    /* JADX INFO: renamed from: A */
    private static final float f421A = 512.0f;

    /* JADX INFO: renamed from: B */
    private static final float f422B = 6.0f;

    /* JADX INFO: renamed from: C */
    private static final float f423C = 45.0f;

    /* JADX INFO: renamed from: D */
    private static final float f424D = 256.0f;

    /* JADX INFO: renamed from: E */
    private static final float f425E = 80.0f;

    /* JADX INFO: renamed from: F */
    private static final float f426F = -16.0f;

    /* JADX INFO: renamed from: G */
    private static final float f427G = 0.01f;

    /* JADX INFO: renamed from: aE */
    private static final int f428aE = 6;

    /* JADX INFO: renamed from: aF */
    private static final int f429aF = 12;

    /* JADX INFO: renamed from: aG */
    private static final int f430aG = 1728;

    /* JADX INFO: renamed from: aH */
    private static final int f431aH = 4;

    /* JADX INFO: renamed from: H */
    private float f434H = 0.0f;

    /* JADX INFO: renamed from: N */
    private boolean f435N = true;

    /* JADX INFO: renamed from: a */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0511iv f436a;

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final ResourceLocation f417n = C0564jv.m2555d("textures/misc/overlay_sandstorm.png");

    /* JADX INFO: renamed from: e */
    private static final Vec3 f432e = new Vec3(Math.cos(Math.toRadians(45.0d)), 0.0d, Math.sin(Math.toRadians(45.0d)));

    /* JADX INFO: renamed from: f */
    private static final Vec3 f433f = new Vec3(-f432e.z, 0.0d, f432e.x);

    @Override // com.boehmod.blockfront.AbstractC0056aa
    /* JADX INFO: renamed from: a */
    public void mo225a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        this.f435N = f > this.f434H;
        this.f434H = f;
        float fClamp = Mth.clamp(f / 0.75f, 0.0f, 1.0f);
        float f2 = f421A - (506.0f * fClamp);
        if (!this.f435N) {
            f2 = -f2;
        }
        Vec3 vec3Add = vec3.add(f432e.scale(f2)).add(0.0d, -16.0d, 0.0d);
        float f3 = f425E * fClamp;
        int i = 4;
        if (f > 0.75f) {
            i = (int) (4.0f * (1.0f - ((f - 0.75f) / 0.25f)));
        }
        float fM230d = m230d(f);
        if (this.f436a == null) {
            this.f436a = new C0511iv((SoundEvent) C1280xc.f8380Ff.get());
            minecraft.getSoundManager().play(this.f436a);
        }
        this.f436a.m2253h(fM230d * c0622l.m2683a().m2234O());
        for (int i2 = 0; i2 < i; i2++) {
            Vec3 vec3Add2 = vec3Add.add(f433f.scale((randomSource.nextDouble() - 0.5d) * 256.0d)).add(0.0d, randomSource.nextDouble() * ((double) f3), 0.0d);
            if (clientLevel.getBlockState(BlockPos.containing(vec3Add2)).isAir()) {
                C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7326ob.get(), vec3Add2.x, vec3Add2.y, vec3Add2.z, 0.0d, 0.0d, 0.0d);
            }
        }
        if (fM230d > 0.0f) {
            float f4 = 17.279999f * fM230d;
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
                    C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7327oc.get(), vec3.x + ((double) iNextInt), vec3.y + ((double) iNextInt2), vec3.z + ((double) iNextInt3), 0.0d, 0.0d, 0.0d);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0056aa
    /* JADX INFO: renamed from: a */
    public void mo226a(@NotNull Minecraft minecraft, C0622l c0622l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        float fM230d = m230d(f2);
        if (fM230d <= 0.0f) {
            return;
        }
        C0119bk.m552a(guiGraphics, f417n, fM230d * 0.25f * c0622l.m2683a().m2233n(f));
    }

    /* JADX INFO: renamed from: d */
    private static float m230d(float f) {
        return Math.max(0.0f, (f - f420z) / 0.35000002f);
    }

    @Override // com.boehmod.blockfront.AbstractC0056aa
    /* JADX INFO: renamed from: c */
    public void mo227c(@NotNull Minecraft minecraft, @NotNull C0622l c0622l) {
        if (this.f436a != null) {
            minecraft.getSoundManager().stop(this.f436a);
            this.f436a = null;
        }
    }
}
