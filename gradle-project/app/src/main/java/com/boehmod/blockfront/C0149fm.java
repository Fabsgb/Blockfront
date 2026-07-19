package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fm.class */
public class C0149fm extends AbstractC0153fq {
    protected C0149fm(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.quadSize = 0.1f;
        this.eA = 0.1f;
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

    @Override // com.boehmod.blockfront.eM
    protected int getLightColor(float f) {
        return 15728880;
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo
    /* JADX INFO: renamed from: a */
    public int mo370a(float f) {
        return super.a(f);
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.tick();
        this.quadSize += 4.0f;
        int i = this.age;
        this.age = i + 1;
        if (i >= this.lifetime) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.c;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fm$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fm$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet x;

        public a(SpriteSet spriteSet) {
            this.x = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0149fm(clientLevel, d, d2, d3, d4, d5, d6, this.x);
        }
    }
}
