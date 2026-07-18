package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fs.class */
public class C0349fs extends AbstractC0347fq {
    protected C0349fs(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
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

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public void tick() {
        super.m1455ax();
        if (!this.removed) {
            this.quadSize = C1290xm.m7835d(this.quadSize, 0.1f, 0.01f);
            this.alpha = C1290xm.m7835d(this.alpha, 0.0f, 0.15f);
            if (this.alpha <= 0.0f) {
                remove();
            }
            if (this.onGround) {
                remove();
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo, com.boehmod.blockfront.InterfaceC0318fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0316fL mo1452a() {
        return InterfaceC0316fL.f2336b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fs$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fs$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: z */
        private final SpriteSet f2429z;

        public a(SpriteSet spriteSet) {
            this.f2429z = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0349fs(clientLevel, d, d2, d3, d4, d5, d6, this.f2429z);
        }
    }
}
