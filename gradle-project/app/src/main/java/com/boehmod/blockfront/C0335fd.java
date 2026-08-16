package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fd.class */
public class C0335fd extends AbstractC0326fU {
    protected C0335fd(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
    }

    @Override // com.boehmod.blockfront.AbstractC0326fU
    @NotNull
    /* JADX INFO: renamed from: a */
    DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> mo1676a() {
        return C1309xw.f7857nt;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    protected int getLightColor(float f) {
        return 15728880;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2530a;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fd$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fd$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: b */
        @NotNull
        private final SpriteSet f2444b;

        public a(@NotNull SpriteSet spriteSet) {
            this.f2444b = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0335fd(clientLevel, d, d2, d3, d4, d5, d6, this.f2444b);
        }
    }
}
