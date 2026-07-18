package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fd.class */
@OnlyIn(Dist.CLIENT)
public class C0334fd extends AbstractC0347fq {

    /* JADX INFO: renamed from: eJ */
    private static final float f2405eJ = 0.025f;

    /* JADX INFO: renamed from: ck */
    private boolean f2406ck;

    protected C0334fd(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.f2406ck = false;
        setPower(1.0f);
        this.gravity = 0.5f;
        this.quadSize = Math.random() < 0.5d ? 0.02f : 0.01f;
        this.lifetime = 300;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        setSize(0.01f, 0.01f);
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public void tick() {
        super.m1455ax();
        if (!this.f2406ck && this.onGround) {
            this.f2406ck = true;
            this.hasPhysics = false;
            this.gravity = 0.0f;
            this.zd = 0.0d;
            this.yd = 0.0d;
            this.xd = 0.0d;
        }
        if (this.f2406ck) {
            this.alpha = C1290xm.m7835d(this.alpha, 0.0f, 0.025f);
            if (this.alpha == 0.0f) {
                remove();
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo
    /* JADX INFO: renamed from: b */
    public int mo1461b(float f) {
        return 15728880;
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo, com.boehmod.blockfront.InterfaceC0318fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0316fL mo1452a() {
        return InterfaceC0316fL.f2336b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fd$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fd$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: q */
        private final SpriteSet f2407q;

        public a(SpriteSet spriteSet) {
            this.f2407q = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0334fd(clientLevel, d, d2, d3, d4, d5, d6, this.f2407q);
        }
    }
}
