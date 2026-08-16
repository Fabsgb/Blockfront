package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fv.class */
public class C0353fv extends AbstractC0333fb {

    /* JADX INFO: renamed from: eN */
    private static final float f2480eN = 2.0f;

    protected C0353fv(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, float f, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, 2.0f, -2.0f, 2.0f, d4, d5, d6, f, spriteSet, 10, 0.3f, true);
        float fNextFloat = 0.1f + (0.25f * clientLevel.random.nextFloat());
        this.bCol = fNextFloat;
        this.gCol = fNextFloat;
        this.rCol = fNextFloat;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2531b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fv$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fv$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: w */
        private final SpriteSet f2481w;

        public a(SpriteSet spriteSet) {
            this.f2481w = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            RandomSource randomSource = clientLevel.random;
            return new C0353fv(clientLevel, d, d2, d3, ((double) randomSource.nextFloat()) * (-8.9d) * ((double) randomSource.nextFloat()) * 0.2d, ((double) randomSource.nextFloat()) * (-2.5d) * ((double) randomSource.nextFloat()) * 0.2d * 5.0d, ((double) randomSource.nextFloat()) * (-8.9d) * ((double) randomSource.nextFloat()) * 0.2d, 1.0f + (randomSource.nextFloat() * 0.5f), this.f2481w);
        }
    }
}
