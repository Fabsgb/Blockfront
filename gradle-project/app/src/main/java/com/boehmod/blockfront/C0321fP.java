package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fP.class */
public class C0321fP extends C0325fT {
    protected C0321fP(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        setSize(0.1f, 0.1f);
        this.quadSize = 16.0f;
        this.f2440eD = this.quadSize;
        this.alpha = 0.0f;
        float fNextFloat = 0.15f + (0.25f * clientLevel.random.nextFloat());
        this.bCol = fNextFloat;
        this.gCol = fNextFloat;
        this.rCol = fNextFloat;
        this.lifetime = 60;
        this.xd *= d4;
        this.yd *= d5;
        this.zd *= d6;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.tick();
        this.x -= this.xd;
        this.y += this.yd;
        this.z -= this.zd;
        this.quadSize = C1270xJ.m7161d(this.quadSize, 32.0f, 0.25f);
        if (this.age < 20) {
            this.alpha = this.age / 20.0f;
        } else {
            this.alpha = C1270xJ.m7161d(this.alpha, 0.0f, 0.02f);
        }
        if (this.alpha <= 0.0f) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.C0325fT, com.boehmod.blockfront.AbstractC0332fa
    @NotNull
    public ParticleRenderType getRenderType() {
        return super.getRenderType();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fP$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fP$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: K */
        private final SpriteSet f2411K;

        public a(SpriteSet spriteSet) {
            this.f2411K = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            RandomSource randomSource = clientLevel.random;
            double dNextFloat = (-2.0d) + ((-5.0d) * ((double) randomSource.nextFloat()));
            return new C0321fP(clientLevel, d, d2, d3, dNextFloat, ((double) randomSource.nextFloat()) * (-5.0d) * ((double) randomSource.nextFloat()) * 0.2d * 5.0d, dNextFloat, this.f2411K);
        }
    }
}
