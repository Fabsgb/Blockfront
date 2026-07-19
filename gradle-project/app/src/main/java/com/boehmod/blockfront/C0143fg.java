package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fg.class */
public class C0143fg extends eN {
    private static final float eL = 2.0f;

    protected C0143fg(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, float f, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, 2.0f, -2.0f, 2.0f, d4, d5, d6, f, spriteSet, 10, 0.3f, true);
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fg$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fg$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet t;

        public a(SpriteSet spriteSet) {
            this.t = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            RandomSource randomSource = clientLevel.random;
            return new C0143fg(clientLevel, d, d2, d3, ((double) randomSource.nextFloat()) * (-1.9d) * ((double) randomSource.nextFloat()) * 0.1d, ((double) randomSource.nextFloat()) * (-0.5d) * ((double) randomSource.nextFloat()) * 0.1d * 5.0d, ((double) randomSource.nextFloat()) * (-1.9d) * ((double) randomSource.nextFloat()) * 0.1d, 1.0f + (randomSource.nextFloat() * 0.5f), this.t);
        }
    }
}
