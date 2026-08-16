package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fz.class */
public class C0357fz extends AbstractC0312fG {
    public C0357fz(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.xd = 0.0d;
        this.yd = 0.0d;
        this.zd = 0.0d;
        this.bCol = 0.05f;
        this.gCol = 0.05f;
        this.rCol = 0.05f;
        setSize(1.0f, 1.0f);
        this.quadSize = 1.0f;
        this.alpha = 1.0f;
        this.lifetime = 300;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.tick();
        this.alpha = C1270xJ.m7161d(this.alpha, 0.0f, 0.004f);
        this.xd -= 0.0015999999595806003d;
        this.yd = 0.4000000059604645d;
        this.zd += 0.0015999999595806003d;
        if (this.age <= 5) {
            this.yd = 0.0d;
        }
        if (this.rCol < 1.0f) {
            float f = this.bCol + 0.003f;
            this.bCol = f;
            this.gCol = f;
            this.rCol = f;
        }
        this.quadSize += 0.13f;
        this.x += this.xd;
        this.y += this.yd;
        this.z += this.zd;
        if (this.alpha <= 0.001f) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2531b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fz$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fz$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: a */
        public static SpriteSet f2488a;

        public a(@NotNull SpriteSet spriteSet) {
            f2488a = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0357fz(clientLevel, d, d2, d3, d4, d5, d6, f2488a);
        }
    }
}
