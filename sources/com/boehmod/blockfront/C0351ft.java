package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ft */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ft.class */
@OnlyIn(Dist.CLIENT)
public class C0351ft extends AbstractC0312fG {

    /* JADX INFO: renamed from: eM */
    private static final float f2476eM = 0.025f;

    /* JADX INFO: renamed from: ct */
    private boolean f2477ct;

    protected C0351ft(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.f2477ct = false;
        setPower(1.0f);
        this.gravity = 0.5f;
        this.quadSize = Math.random() < 0.5d ? 0.02f : 0.01f;
        this.lifetime = 300;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        setSize(0.01f, 0.01f);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.m1693aD();
        if (!this.f2477ct && this.onGround) {
            this.f2477ct = true;
            this.hasPhysics = false;
            this.gravity = 0.0f;
            this.zd = 0.0d;
            this.yd = 0.0d;
            this.xd = 0.0d;
        }
        if (this.f2477ct) {
            this.alpha = C1270xJ.m7161d(this.alpha, 0.0f, 0.025f);
            if (this.alpha == 0.0f) {
                remove();
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE
    /* JADX INFO: renamed from: c */
    public int mo1663c(float f) {
        return 15728880;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2531b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ft$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ft$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: u */
        private final SpriteSet f2478u;

        public a(SpriteSet spriteSet) {
            this.f2478u = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0351ft(clientLevel, d, d2, d3, d4, d5, d6, this.f2478u);
        }
    }
}
