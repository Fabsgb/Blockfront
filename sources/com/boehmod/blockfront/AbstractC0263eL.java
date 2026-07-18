package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

/* JADX INFO: renamed from: com.boehmod.blockfront.eL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eL.class */
public abstract class AbstractC0263eL extends AbstractC0264eM implements InterfaceC0354fx {

    /* JADX INFO: renamed from: eq */
    private static final float f2071eq = 360.0f;

    /* JADX INFO: renamed from: er */
    private static final float f2072er = -0.07f;

    /* JADX INFO: renamed from: es */
    private static final float f2073es = 0.025f;

    /* JADX INFO: renamed from: et */
    private static final float f2074et = 0.01f;

    /* JADX INFO: renamed from: eu */
    private static final float f2075eu = 0.01f;

    /* JADX INFO: renamed from: ev */
    private static final float f2076ev = 0.02f;

    /* JADX INFO: renamed from: ew */
    private static final float f2077ew = 0.03f;

    /* JADX INFO: renamed from: cj */
    private boolean f2078cj;

    /* JADX INFO: renamed from: aF */
    private float f2079aF;

    /* JADX INFO: renamed from: ex */
    private float f2080ex;

    /* JADX INFO: renamed from: aG */
    private float f2081aG;

    /* JADX INFO: renamed from: ey */
    private float f2082ey;

    /* JADX INFO: renamed from: aH */
    private float f2083aH;

    /* JADX INFO: renamed from: ez */
    private float f2084ez;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Quaternionf f2085b;

    protected AbstractC0263eL(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, float f, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.f2078cj = false;
        this.f2085b = new Quaternionf();
        this.alpha = 0.0f;
        this.quadSize = f;
        this.lifetime = 800;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        this.hasPhysics = true;
        float fNextFloat = this.random.nextFloat() * f2071eq;
        this.f2080ex = fNextFloat;
        this.f2079aF = fNextFloat;
        float fNextFloat2 = this.random.nextFloat() * f2071eq;
        this.f2082ey = fNextFloat2;
        this.f2081aG = fNextFloat2;
        float fNextFloat3 = this.random.nextFloat() * f2071eq;
        this.f2084ez = fNextFloat3;
        this.f2083aH = fNextFloat3;
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public void tick() {
        this.yd = -0.07000000029802322d;
        this.f2080ex = this.f2079aF;
        this.f2082ey = this.f2081aG;
        this.f2084ez = this.f2083aH;
        if (this.onGround) {
            this.xd = 0.0d;
            this.yd = 0.0d;
            this.zd = 0.0d;
        } else {
            this.f2079aF += 0.01f;
            this.f2081aG += f2076ev;
            this.f2083aH += f2077ew;
        }
        super.m1455ax();
        if (this.onGround) {
            m1453aw();
        } else {
            this.alpha = C1290xm.m7835d(this.alpha, 1.0f, 0.01f);
        }
    }

    /* JADX INFO: renamed from: aw */
    private void m1453aw() {
        if (!this.f2078cj) {
            this.f2078cj = true;
            if (this.random.nextBoolean()) {
                this.level.playLocalSound(this.x, this.y, this.z, (SoundEvent) C1280xc.f7525oI.get(), SoundSource.AMBIENT, 0.15f, 0.8f + (this.random.nextFloat() * 0.4f), false);
            }
        }
        float f = this.alpha - 0.025f;
        this.alpha = f;
        if (f <= 0.0f) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0354fx
    @NotNull
    /* JADX INFO: renamed from: a */
    public Quaternionf mo1454a(float f) {
        return this.f2085b.identity().rotateLocalX(Mth.lerp(f, this.f2080ex, this.f2079aF)).rotateLocalY(Mth.lerp(f, this.f2082ey, this.f2081aG)).rotateLocalZ(Mth.lerp(f, this.f2084ez, this.f2083aH));
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo, com.boehmod.blockfront.InterfaceC0318fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0316fL mo1452a() {
        return InterfaceC0316fL.f2338d;
    }
}
