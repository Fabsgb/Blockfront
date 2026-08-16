package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fq.class */
@OnlyIn(Dist.CLIENT)
public class C0348fq extends AbstractC0312fG {

    /* JADX INFO: renamed from: p */
    private final SpriteSet f2469p;

    protected C0348fq(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.gravity = -0.1f;
        this.friction = 0.75f;
        this.f2469p = spriteSet;
        this.xd = d4 + (((Math.random() * 2.0d) - 1.0d) * 0.1d);
        this.yd = d5 + (((Math.random() * 2.0d) - 1.0d) * 0.1d);
        this.zd = d6 + (((Math.random() * 2.0d) - 1.0d) * 0.1d);
        float fNextFloat = (this.random.nextFloat() * 0.3f) + 0.7f;
        this.rCol = fNextFloat;
        this.gCol = fNextFloat;
        this.bCol = fNextFloat;
        this.quadSize = 0.1f * ((this.random.nextFloat() * this.random.nextFloat() * 6.0f) + 1.0f);
        this.lifetime = ((int) (12.0d / ((((double) this.random.nextFloat()) * 0.8d) + 0.2d))) + 2;
        setSpriteFromAge(spriteSet);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.m1693aD();
        setSpriteFromAge(this.f2469p);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2530a;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fq$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fq$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: q */
        private final SpriteSet f2470q;

        public a(SpriteSet spriteSet) {
            this.f2470q = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0348fq(clientLevel, d, d2, d3, d4, d5, d6, this.f2470q);
        }
    }
}
