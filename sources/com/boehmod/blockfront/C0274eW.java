package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eW.class */
public class C0274eW extends AbstractC0344fn {
    protected C0274eW(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.alpha = (float) (0.15000000596046448d * Math.random());
        this.quadSize = (float) (1.0d + (5.0d * Math.random()) + ((double) this.f2427eT));
        this.f2089eA = this.quadSize;
    }

    @Override // com.boehmod.blockfront.AbstractC0344fn
    /* JADX INFO: renamed from: w */
    public float mo1470w() {
        return 2.5E-4f;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.eW$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eW$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: i */
        private final SpriteSet f2100i;

        public a(SpriteSet spriteSet) {
            this.f2100i = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0274eW(clientLevel, d, d2, d3, d4, d5, d6, this.f2100i);
        }
    }
}
