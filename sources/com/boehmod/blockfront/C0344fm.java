package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fm.class */
public class C0344fm extends AbstractC0333fb {

    /* JADX INFO: renamed from: eE */
    private static final float f2453eE = 2.4f;

    /* JADX INFO: renamed from: jO */
    private static final int f2454jO = 40;

    /* JADX INFO: renamed from: eF */
    private static final float f2455eF = 0.5f;

    /* JADX INFO: renamed from: eG */
    private static final float f2456eG = 0.03f;

    protected C0344fm(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, float f, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, ThreadLocalRandom.current().nextFloat(-2.4f, f2453eE), 2.0f, ThreadLocalRandom.current().nextFloat(-2.4f, f2453eE), d4, d5, d6, f, spriteSet, 40, 0.5f, true);
        this.quadSize = f2456eG;
        setAlpha(1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2531b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fm$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fm$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: k */
        private final SpriteSet f2457k;

        public a(SpriteSet spriteSet) {
            this.f2457k = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            RandomSource randomSource = clientLevel.random;
            return new C0344fm(clientLevel, d, d2, d3, ((double) randomSource.nextFloat()) * (-1.9d) * ((double) randomSource.nextFloat()) * 0.1d, ((double) randomSource.nextFloat()) * (-0.5d) * ((double) randomSource.nextFloat()) * 0.1d * 5.0d, ((double) randomSource.nextFloat()) * (-1.9d) * ((double) randomSource.nextFloat()) * 0.1d, 1.0f, this.f2457k);
        }
    }
}
