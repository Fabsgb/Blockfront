package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eL.class */
public abstract class eL extends eM implements InterfaceC0160fx {
    private static final float eq = 360.0f;
    private static final float er = -0.07f;
    private static final float es = 0.025f;
    private static final float et = 0.01f;
    private static final float eu = 0.01f;
    private static final float ev = 0.02f;
    private static final float ew = 0.03f;
    private boolean cj;
    private float aF;
    private float ex;
    private float aG;
    private float ey;
    private float aH;
    private float ez;

    @NotNull
    private final Quaternionf b;

    protected eL(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, float f, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.cj = false;
        this.b = new Quaternionf();
        this.alpha = 0.0f;
        this.quadSize = f;
        this.lifetime = 800;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        this.hasPhysics = true;
        float fNextFloat = this.random.nextFloat() * eq;
        this.ex = fNextFloat;
        this.aF = fNextFloat;
        float fNextFloat2 = this.random.nextFloat() * eq;
        this.ey = fNextFloat2;
        this.aG = fNextFloat2;
        float fNextFloat3 = this.random.nextFloat() * eq;
        this.ez = fNextFloat3;
        this.aH = fNextFloat3;
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        this.yd = -0.07000000029802322d;
        this.ex = this.aF;
        this.ey = this.aG;
        this.ez = this.aH;
        if (this.onGround) {
            this.xd = 0.0d;
            this.yd = 0.0d;
            this.zd = 0.0d;
        } else {
            this.aF += 0.01f;
            this.aG += ev;
            this.aH += ew;
        }
        super.ax();
        if (this.onGround) {
            aw();
        } else {
            this.alpha = C0634xm.d(this.alpha, 1.0f, 0.01f);
        }
    }

    private void aw() {
        if (!this.cj) {
            this.cj = true;
            if (this.random.nextBoolean()) {
                this.level.playLocalSound(this.x, this.y, this.z, (SoundEvent) C0624xc.oI.get(), SoundSource.AMBIENT, 0.15f, 0.8f + (this.random.nextFloat() * 0.4f), false);
            }
        }
        float f = this.alpha - 0.025f;
        this.alpha = f;
        if (f <= 0.0f) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0160fx
    @NotNull
    /* JADX INFO: renamed from: a */
    public Quaternionf mo373a(float f) {
        return this.b.identity().rotateLocalX(Mth.lerp(f, this.ex, this.aF)).rotateLocalY(Mth.lerp(f, this.ey, this.aG)).rotateLocalZ(Mth.lerp(f, this.ez, this.aH));
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.d;
    }
}
