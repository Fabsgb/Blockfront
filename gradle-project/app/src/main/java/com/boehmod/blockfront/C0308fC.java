package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fC.class */
public class C0308fC extends AbstractC0312fG {
    protected C0308fC(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.quadSize = 0.1f;
        this.f2440eD = 0.1f;
        this.lifetime = 2;
        this.alpha = 0.45f;
        this.bCol = 1.0f;
        this.gCol = 1.0f;
        this.rCol = 1.0f;
        this.zd = 0.0d;
        this.yd = 0.0d;
        this.xd = 0.0d;
        setSize(0.15f, 0.15f);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    protected int getLightColor(float f) {
        return 15728880;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE
    /* JADX INFO: renamed from: b */
    public int mo1544b(float f) {
        return super.mo1544b(f);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.tick();
        this.quadSize += 4.0f;
        int i = this.age;
        this.age = i + 1;
        if (i >= this.lifetime) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2532c;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fC$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fC$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: B */
        private final SpriteSet f2396B;

        public a(SpriteSet spriteSet) {
            this.f2396B = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0308fC(clientLevel, d, d2, d3, d4, d5, d6, this.f2396B);
        }
    }
}
