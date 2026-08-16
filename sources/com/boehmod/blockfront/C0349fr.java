package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fr.class */
@OnlyIn(Dist.CLIENT)
public class C0349fr extends AbstractC0312fG {

    /* JADX INFO: renamed from: r */
    private final SpriteSet f2471r;

    protected C0349fr(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.gravity = -0.02f;
        this.friction = 0.9f;
        this.f2471r = spriteSet;
        this.xd = d4;
        this.yd = d5;
        this.zd = d6;
        float fNextFloat = (this.random.nextFloat() * 0.2f) + 0.4f;
        this.rCol = fNextFloat;
        this.gCol = fNextFloat;
        this.bCol = fNextFloat;
        this.quadSize = 0.1f * ((this.random.nextFloat() * 2.0f) + 1.5f);
        this.lifetime = 20 + this.random.nextInt(20);
        setSpriteFromAge(spriteSet);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.m1693aD();
        setSpriteFromAge(this.f2471r);
        this.alpha = Math.min(1.0f, 2.0f * (1.0f - (this.age / this.lifetime)));
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2530a;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fr$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fr$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: s */
        private final SpriteSet f2472s;

        public a(SpriteSet spriteSet) {
            this.f2472s = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0349fr(clientLevel, d, d2, d3, d4, d5, d6, this.f2472s);
        }
    }
}
