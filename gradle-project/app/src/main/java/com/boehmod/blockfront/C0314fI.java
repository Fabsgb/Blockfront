package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fI.class */
public class C0314fI extends AbstractC0312fG {
    protected C0314fI(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.gravity = 1.0f;
        this.quadSize = 0.02f;
        this.lifetime = 80;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        this.xd = d4;
        this.yd = d5;
        this.zd = d6;
        this.xd += (Math.random() - 0.5d) * 0.05d;
        this.yd += (Math.random() - 0.5d) * 0.05d;
        this.zd += (Math.random() - 0.5d) * 0.05d;
        setSize(0.01f, 0.01f);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.m1693aD();
        if (!this.removed) {
            this.quadSize = C1270xJ.m7161d(this.quadSize, 0.1f, 0.01f);
            this.alpha = C1270xJ.m7161d(this.alpha, 0.0f, 0.15f);
            if (this.alpha <= 0.0f) {
                remove();
            }
            if (this.onGround) {
                remove();
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2531b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fI$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fI$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: D */
        private final SpriteSet f2399D;

        public a(SpriteSet spriteSet) {
            this.f2399D = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0314fI(clientLevel, d, d2, d3, d4, d5, d6, this.f2399D);
        }
    }
}
