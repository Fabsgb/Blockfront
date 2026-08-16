package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

/* JADX INFO: renamed from: com.boehmod.blockfront.eZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eZ.class */
public abstract class AbstractC0278eZ extends AbstractC0332fa implements InterfaceC0319fN {

    /* JADX INFO: renamed from: et */
    private static final float f2203et = 360.0f;

    /* JADX INFO: renamed from: eu */
    private static final float f2204eu = -0.07f;

    /* JADX INFO: renamed from: ev */
    private static final float f2205ev = 0.025f;

    /* JADX INFO: renamed from: ew */
    private static final float f2206ew = 0.01f;

    /* JADX INFO: renamed from: ex */
    private static final float f2207ex = 0.01f;

    /* JADX INFO: renamed from: ey */
    private static final float f2208ey = 0.02f;

    /* JADX INFO: renamed from: ez */
    private static final float f2209ez = 0.03f;

    /* JADX INFO: renamed from: cs */
    private boolean f2210cs;

    /* JADX INFO: renamed from: aK */
    private float f2211aK;

    /* JADX INFO: renamed from: eA */
    private float f2212eA;

    /* JADX INFO: renamed from: aL */
    private float f2213aL;

    /* JADX INFO: renamed from: eB */
    private float f2214eB;

    /* JADX INFO: renamed from: aM */
    private float f2215aM;

    /* JADX INFO: renamed from: eC */
    private float f2216eC;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Quaternionf f2217b;

    protected AbstractC0278eZ(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, float f, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.f2210cs = false;
        this.f2217b = new Quaternionf();
        this.alpha = 0.0f;
        this.quadSize = f;
        this.lifetime = 800;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        this.hasPhysics = true;
        float fNextFloat = this.random.nextFloat() * f2203et;
        this.f2212eA = fNextFloat;
        this.f2211aK = fNextFloat;
        float fNextFloat2 = this.random.nextFloat() * f2203et;
        this.f2214eB = fNextFloat2;
        this.f2213aL = fNextFloat2;
        float fNextFloat3 = this.random.nextFloat() * f2203et;
        this.f2216eC = fNextFloat3;
        this.f2215aM = fNextFloat3;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        this.yd = -0.07000000029802322d;
        this.f2212eA = this.f2211aK;
        this.f2214eB = this.f2213aL;
        this.f2216eC = this.f2215aM;
        if (this.onGround) {
            this.xd = 0.0d;
            this.yd = 0.0d;
            this.zd = 0.0d;
        } else {
            this.f2211aK += 0.01f;
            this.f2213aL += f2208ey;
            this.f2215aM += f2209ez;
        }
        super.m1693aD();
        if (this.onGround) {
            m1546aC();
        } else {
            this.alpha = C1270xJ.m7161d(this.alpha, 1.0f, 0.01f);
        }
    }

    /* JADX INFO: renamed from: aC */
    private void m1546aC() {
        if (!this.f2210cs) {
            this.f2210cs = true;
            if (this.random.nextBoolean()) {
                this.level.playLocalSound(this.x, this.y, this.z, (SoundEvent) C1312xz.f7937oK.get(), SoundSource.AMBIENT, 0.15f, 0.8f + (this.random.nextFloat() * 0.4f), false);
            }
        }
        float f = this.alpha - 0.025f;
        this.alpha = f;
        if (f <= 0.0f) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0319fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public Quaternionf mo1547a(float f) {
        return this.f2217b.identity().rotateLocalX(Mth.lerp(f, this.f2212eA, this.f2211aK)).rotateLocalY(Mth.lerp(f, this.f2214eB, this.f2213aL)).rotateLocalZ(Mth.lerp(f, this.f2216eC, this.f2215aM));
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2533d;
    }
}
