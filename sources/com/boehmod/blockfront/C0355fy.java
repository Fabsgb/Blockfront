package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fy.class */
public class C0355fy extends C0308fD {
    protected C0355fy(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        setSize(0.1f, 0.1f);
        this.quadSize = 10.0f + (8.0f * clientLevel.random.nextFloat());
        this.f2089eA = this.quadSize;
        this.alpha = 0.0f;
        float fNextFloat = 0.5f + (0.4f * clientLevel.random.nextFloat());
        this.bCol = fNextFloat;
        this.gCol = fNextFloat;
        this.rCol = fNextFloat;
        this.lifetime = 400;
        this.xd *= d4;
        this.zd *= d6;
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public void tick() {
        super.tick();
        this.x -= this.xd;
        this.z -= this.zd;
        this.alpha = C1290xm.m7835d(this.alpha, this.age >= this.lifetime / 2 ? 0.0f : 0.25f, 0.025f);
        if (this.alpha <= 0.0f) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public int getLightColor(float f) {
        return 15728880;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fy$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fy$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: F */
        private final SpriteSet f2436F;

        public a(SpriteSet spriteSet) {
            this.f2436F = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0355fy(clientLevel, d, d2, d3, -1.5d, 0.0d, -1.5d, this.f2436F);
        }
    }
}
