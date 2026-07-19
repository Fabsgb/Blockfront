package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fs.class */
public class C0155fs extends AbstractC0153fq {
    protected C0155fs(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
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

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.ax();
        if (!this.removed) {
            this.quadSize = C0634xm.d(this.quadSize, 0.1f, 0.01f);
            this.alpha = C0634xm.d(this.alpha, 0.0f, 0.15f);
            if (this.alpha <= 0.0f) {
                remove();
            }
            if (this.onGround) {
                remove();
            }
        }
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fs$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fs$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet z;

        public a(SpriteSet spriteSet) {
            this.z = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0155fs(clientLevel, d, d2, d3, d4, d5, d6, this.z);
        }
    }
}
