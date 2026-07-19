package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uK.class */
public class uK {

    @NotNull
    private DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> aX = wZ.nQ;

    @NotNull
    private DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> aY = wZ.nw;
    private float ny = 0.0f;

    @NotNull
    public DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> p() {
        return this.aX;
    }

    public uK a(@NotNull DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> deferredHolder) {
        this.aX = deferredHolder;
        return this;
    }

    @NotNull
    public DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> q() {
        return this.aY;
    }

    @NotNull
    public uK b(@NotNull DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> deferredHolder) {
        this.aY = deferredHolder;
        return this;
    }

    public float bC() {
        return this.ny;
    }

    @NotNull
    public uK a(float f) {
        this.ny = f;
        return this;
    }
}
