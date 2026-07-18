package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uK.class */
public class C1111uK {

    /* JADX INFO: renamed from: aX */
    @NotNull
    private DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f5848aX = C1232wZ.f7315nQ;

    /* JADX INFO: renamed from: aY */
    @NotNull
    private DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f5849aY = C1232wZ.f7295nw;

    /* JADX INFO: renamed from: ny */
    private float f5850ny = 0.0f;

    @NotNull
    /* JADX INFO: renamed from: p */
    public DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> m6124p() {
        return this.f5848aX;
    }

    /* JADX INFO: renamed from: a */
    public C1111uK m6125a(@NotNull DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> deferredHolder) {
        this.f5848aX = deferredHolder;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: q */
    public DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> m6126q() {
        return this.f5849aY;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1111uK m6127b(@NotNull DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> deferredHolder) {
        this.f5849aY = deferredHolder;
        return this;
    }

    /* JADX INFO: renamed from: bC */
    public float m6128bC() {
        return this.f5850ny;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1111uK m6129a(float f) {
        this.f5850ny = f;
        return this;
    }
}
