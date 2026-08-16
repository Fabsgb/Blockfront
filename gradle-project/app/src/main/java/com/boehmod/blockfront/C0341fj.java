package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fj.class */
public class C0341fj extends AbstractC0277eY {
    protected C0341fj(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
    }

    @Override // com.boehmod.blockfront.AbstractC0277eY
    /* JADX INFO: renamed from: b */
    protected float mo1542b() {
        return 0.6f;
    }

    @Override // com.boehmod.blockfront.AbstractC0277eY
    /* JADX INFO: renamed from: v */
    protected float mo1543v() {
        return 5.0f;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fj$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fj$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: h */
        private final SpriteSet f2450h;

        public a(SpriteSet spriteSet) {
            this.f2450h = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0341fj(clientLevel, d, d2, d3, d4, d5, d6, this.f2450h);
        }
    }
}
