package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eW.class */
public class eW extends AbstractC0150fn {
    protected eW(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.alpha = (float) (0.15000000596046448d * Math.random());
        this.quadSize = (float) (1.0d + (5.0d * Math.random()) + ((double) this.eT));
        this.eA = this.quadSize;
    }

    @Override // com.boehmod.blockfront.AbstractC0150fn
    public float w() {
        return 2.5E-4f;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eW$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet i;

        public a(SpriteSet spriteSet) {
            this.i = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new eW(clientLevel, d, d2, d3, d4, d5, d6, this.i);
        }
    }
}
