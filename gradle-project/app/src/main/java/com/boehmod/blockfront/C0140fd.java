package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fd.class */
@OnlyIn(Dist.CLIENT)
public class C0140fd extends AbstractC0153fq {
    private static final float eJ = 0.025f;
    private boolean ck;

    protected C0140fd(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.ck = false;
        setPower(1.0f);
        this.gravity = 0.5f;
        this.quadSize = Math.random() < 0.5d ? 0.02f : 0.01f;
        this.lifetime = 300;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        setSize(0.01f, 0.01f);
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.ax();
        if (!this.ck && this.onGround) {
            this.ck = true;
            this.hasPhysics = false;
            this.gravity = 0.0f;
            this.zd = 0.0d;
            this.yd = 0.0d;
            this.xd = 0.0d;
        }
        if (this.ck) {
            this.alpha = C0634xm.d(this.alpha, 0.0f, 0.025f);
            if (this.alpha == 0.0f) {
                remove();
            }
        }
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo
    public int b(float f) {
        return 15728880;
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fd$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fd$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet q;

        public a(SpriteSet spriteSet) {
            this.q = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0140fd(clientLevel, d, d2, d3, d4, d5, d6, this.q);
        }
    }
}
