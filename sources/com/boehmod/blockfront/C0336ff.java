package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ff */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ff.class */
public class C0336ff extends AbstractC0265eN {

    /* JADX INFO: renamed from: eK */
    private static final float f2409eK = 2.0f;

    protected C0336ff(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, float f, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, 2.0f, -2.0f, 2.0f, d4, d5, d6, f, spriteSet, 10, 0.3f, true);
        float fNextFloat = 0.1f + (0.25f * clientLevel.random.nextFloat());
        this.bCol = fNextFloat;
        this.gCol = fNextFloat;
        this.rCol = fNextFloat;
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo, com.boehmod.blockfront.InterfaceC0318fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0316fL mo1452a() {
        return InterfaceC0316fL.f2336b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ff$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ff$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: s */
        private final SpriteSet f2410s;

        public a(SpriteSet spriteSet) {
            this.f2410s = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            RandomSource randomSource = clientLevel.random;
            return new C0336ff(clientLevel, d, d2, d3, ((double) randomSource.nextFloat()) * (-8.9d) * ((double) randomSource.nextFloat()) * 0.2d, ((double) randomSource.nextFloat()) * (-2.5d) * ((double) randomSource.nextFloat()) * 0.2d * 5.0d, ((double) randomSource.nextFloat()) * (-8.9d) * ((double) randomSource.nextFloat()) * 0.2d, 1.0f + (randomSource.nextFloat() * 0.5f), this.f2410s);
        }
    }
}
