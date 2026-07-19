package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eY.class */
public class eY extends eN {
    private static final float eB = 2.4f;
    private static final int iu = 40;
    private static final float eC = 0.5f;
    private static final float eD = 0.03f;

    protected eY(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, float f, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, ThreadLocalRandom.current().nextFloat(-2.4f, eB), 2.0f, ThreadLocalRandom.current().nextFloat(-2.4f, eB), d4, d5, d6, f, spriteSet, 40, 0.5f, true);
        this.quadSize = eD;
        setAlpha(1.0f);
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.b;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eY$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet k;

        public a(SpriteSet spriteSet) {
            this.k = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            RandomSource randomSource = clientLevel.random;
            return new eY(clientLevel, d, d2, d3, ((double) randomSource.nextFloat()) * (-1.9d) * ((double) randomSource.nextFloat()) * 0.1d, ((double) randomSource.nextFloat()) * (-0.5d) * ((double) randomSource.nextFloat()) * 0.1d * 5.0d, ((double) randomSource.nextFloat()) * (-1.9d) * ((double) randomSource.nextFloat()) * 0.1d, 1.0f, this.k);
        }
    }
}
