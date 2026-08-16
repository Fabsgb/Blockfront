package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fw.class */
public class C0354fw extends AbstractC0333fb {

    /* JADX INFO: renamed from: eO */
    private static final float f2482eO = 2.0f;

    protected C0354fw(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, float f, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, 2.0f, -2.0f, 2.0f, d4, d5, d6, f, spriteSet, 10, 0.3f, true);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2531b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fw$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fw$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: x */
        private final SpriteSet f2483x;

        public a(SpriteSet spriteSet) {
            this.f2483x = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            RandomSource randomSource = clientLevel.random;
            return new C0354fw(clientLevel, d, d2, d3, ((double) randomSource.nextFloat()) * (-1.9d) * ((double) randomSource.nextFloat()) * 0.1d, ((double) randomSource.nextFloat()) * (-0.5d) * ((double) randomSource.nextFloat()) * 0.1d * 5.0d, ((double) randomSource.nextFloat()) * (-1.9d) * ((double) randomSource.nextFloat()) * 0.1d, 1.0f + (randomSource.nextFloat() * 0.5f), this.f2483x);
        }
    }
}
