package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fh.class */
public class C0339fh extends AbstractC0326fU {
    protected C0339fh(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2530a;
    }

    @Override // com.boehmod.blockfront.AbstractC0326fU
    @NotNull
    /* JADX INFO: renamed from: a */
    DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> mo1676a() {
        return C1309xw.f7854nq;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fh$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fh$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: f */
        @NotNull
        private final SpriteSet f2448f;

        public a(@NotNull SpriteSet spriteSet) {
            this.f2448f = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0339fh(clientLevel, d, d2, d3, d4, d5, d6, this.f2448f);
        }
    }
}
