package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fA.class */
public class fA extends fD {
    protected fA(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        setSize(0.1f, 0.1f);
        this.quadSize = 5.0f;
        this.eA = this.quadSize;
        this.alpha = 0.0f;
        float fNextFloat = 0.1f + (0.35f * clientLevel.random.nextFloat());
        this.bCol = fNextFloat;
        this.gCol = fNextFloat;
        this.rCol = fNextFloat;
        this.lifetime = 40;
        this.xd *= d4;
        this.yd *= d5;
        this.zd *= d6;
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.tick();
        this.x -= this.xd;
        this.y += this.yd;
        this.z -= this.zd;
        this.alpha = C0634xm.d(this.alpha, this.age < 6 ? 1.0f : 0.0f, this.age < 4 ? 0.03f : 0.02f);
        if (this.alpha <= 0.0f) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.fD, com.boehmod.blockfront.eM
    @NotNull
    public ParticleRenderType getRenderType() {
        return super.getRenderType();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fA$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet H;

        public a(SpriteSet spriteSet) {
            this.H = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            RandomSource randomSource = clientLevel.random;
            double dNextFloat = (-4.0d) * ((double) randomSource.nextFloat());
            return new fA(clientLevel, d, d2, d3, dNextFloat, ((double) randomSource.nextFloat()) * (-12.5d) * ((double) randomSource.nextFloat()) * 0.2d * 5.0d, dNextFloat, this.H);
        }
    }
}
