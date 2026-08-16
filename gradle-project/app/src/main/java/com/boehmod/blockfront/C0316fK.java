package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fK.class */
@OnlyIn(Dist.CLIENT)
public class C0316fK extends AbstractC0312fG {

    /* JADX INFO: renamed from: F */
    private final SpriteSet f2401F;

    protected C0316fK(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.gravity = -0.1f;
        this.friction = 0.9f;
        this.f2401F = spriteSet;
        this.xd = d4 + (((Math.random() * 2.0d) - 1.0d) * 0.05000000074505806d);
        this.yd = d5 + (((Math.random() * 2.0d) - 1.0d) * 0.05000000074505806d);
        this.zd = d6 + (((Math.random() * 2.0d) - 1.0d) * 0.05000000074505806d);
        float fNextFloat = (this.random.nextFloat() * 0.3f) + 0.7f;
        this.rCol = fNextFloat;
        this.gCol = fNextFloat;
        this.bCol = fNextFloat;
        this.quadSize = 0.1f * ((this.random.nextFloat() * this.random.nextFloat() * 6.0f) + 1.0f);
        this.lifetime = ((int) (16.0d / ((((double) this.random.nextFloat()) * 0.8d) + 0.2d))) + 2;
        setSpriteFromAge(spriteSet);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.m1693aD();
        setSpriteFromAge(this.f2401F);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2530a;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fK$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fK$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: G */
        private final SpriteSet f2402G;

        public a(SpriteSet spriteSet) {
            this.f2402G = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0316fK(clientLevel, d, d2, d3, d4, d5, d6, this.f2402G);
        }
    }
}
