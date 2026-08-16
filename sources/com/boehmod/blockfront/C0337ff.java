package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ff */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ff.class */
public class C0337ff extends AbstractC0307fB {
    protected C0337ff(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ff$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ff$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: d */
        @NotNull
        private final SpriteSet f2446d;

        public a(@NotNull SpriteSet spriteSet) {
            this.f2446d = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0337ff(clientLevel, d, d2, d3, d4, d5, d6, this.f2446d);
        }
    }
}
