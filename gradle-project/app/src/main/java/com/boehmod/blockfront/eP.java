package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eP.class */
public class eP extends fE {
    protected eP(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
    }

    @Override // com.boehmod.blockfront.fE
    @NotNull
    DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> a() {
        return wZ.nt;
    }

    @Override // com.boehmod.blockfront.eM
    protected int getLightColor(float f) {
        return 15728880;
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public fL mo372a() {
        return fL.a;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eP$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        @NotNull
        private final SpriteSet b;

        public a(@NotNull SpriteSet spriteSet) {
            this.b = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new eP(clientLevel, d, d2, d3, d4, d5, d6, this.b);
        }
    }
}
