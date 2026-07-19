package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eN.class */
@OnlyIn(Dist.CLIENT)
public abstract class eN extends AbstractC0153fq {
    protected eN(ClientLevel clientLevel, double d, double d2, double d3, float f, float f2, float f3, double d4, double d5, double d6, float f4, SpriteSet spriteSet, int i, float f5, boolean z) {
        super(clientLevel, d, d2, d3, 0.0d, 0.0d, 0.0d, spriteSet);
        this.friction = 0.96f;
        this.gravity = f5;
        this.speedUpWhenYMotionIsBlocked = true;
        this.xd *= (double) f;
        this.yd *= (double) f2;
        this.zd *= (double) f3;
        this.xd += d4;
        this.yd += d5;
        this.zd += d6;
        this.rCol = 1.0f;
        this.gCol = 1.0f;
        this.bCol = 1.0f;
        this.quadSize *= 0.1f * f4;
        this.lifetime = (int) ((((double) i) / ((((double) clientLevel.random.nextFloat()) * 0.8d) + 0.2d)) * ((double) f4));
        this.lifetime = Math.max(this.lifetime, 1);
        setSpriteFromAge(spriteSet);
        this.hasPhysics = z;
        this.alpha = 0.0f;
    }

    @Override // com.boehmod.blockfront.eM
    public float getQuadSize(float f) {
        return this.quadSize * Mth.clamp(((this.age + f) / this.lifetime) * 32.0f, 0.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.tick();
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        aB();
        boolean z = this.age > this.lifetime || this.onGround;
        this.alpha = C0634xm.d(this.alpha, z ? 0.0f : 0.25f, z ? 0.02f : 0.6f);
        if (z && this.alpha <= 0.0f) {
            remove();
        }
    }

    protected void aB() {
        this.yd -= 0.03d * ((double) this.gravity);
        move(this.xd, this.yd, this.zd);
        if (this.speedUpWhenYMotionIsBlocked && this.y == this.yo) {
            this.xd *= 1.1d;
            this.zd *= 1.1d;
        }
        this.xd *= (double) this.friction;
        this.yd *= (double) this.friction;
        this.zd *= (double) this.friction;
        if (this.onGround) {
            this.xd *= 0.699999988079071d;
            this.zd *= 0.699999988079071d;
        }
    }
}
