package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fk.class */
public class C0147fk extends AbstractC0153fq {
    protected C0147fk(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.quadSize = 16.0f;
        this.lifetime = 8;
        this.bCol = 1.0f;
        this.gCol = 1.0f;
        this.rCol = 1.0f;
        this.zd = 0.0d;
        this.yd = 0.0d;
        this.xd = 0.0d;
        setSize(0.15f, 0.15f);
    }

    @Override // com.boehmod.blockfront.eM
    protected int getLightColor(float f) {
        return 15728880;
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.tick();
        this.quadSize = Mth.lerp(0.6f, this.quadSize, 0.0f);
        this.alpha = Mth.lerp(0.75f, this.alpha, 0.0f);
        int i = this.age;
        this.age = i + 1;
        if (i >= this.lifetime) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.eM
    @NotNull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.c;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fk$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fk$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet w;

        public a(SpriteSet spriteSet) {
            this.w = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0147fk(clientLevel, d, d2, d3, d4, d5, d6, this.w);
        }
    }
}
