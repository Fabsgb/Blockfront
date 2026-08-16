package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fH.class */
public class C0313fH extends C0325fT {
    protected C0313fH(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        setSize(0.1f, 0.1f);
        this.quadSize = 1.5f;
        this.f2440eD = this.quadSize;
        this.alpha = 0.5f;
        this.bCol = 0.5f;
        this.gCol = 0.5f;
        this.rCol = 0.5f;
        this.zd = 0.0d;
        this.yd = 0.0d;
        this.xd = 0.0d;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.tick();
        this.alpha = C1270xJ.m7161d(this.alpha, 0.0f, 0.002f);
        if (this.alpha <= 0.0f) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.C0325fT, com.boehmod.blockfront.AbstractC0332fa
    @NotNull
    public ParticleRenderType getRenderType() {
        return super.getRenderType();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fH$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fH$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: C */
        private final SpriteSet f2398C;

        public a(SpriteSet spriteSet) {
            this.f2398C = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0313fH(clientLevel, d, d2, d3, d4, d5, d6, this.f2398C);
        }
    }
}
