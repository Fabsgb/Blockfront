package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vk.class */
public class C1191vk {

    /* JADX INFO: renamed from: aX */
    @NotNull
    private DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f6487aX = C1309xw.f7880nQ;

    /* JADX INFO: renamed from: aY */
    @NotNull
    private DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f6488aY = C1309xw.f7860nw;

    /* JADX INFO: renamed from: ow */
    private float f6489ow = 0.0f;

    @NotNull
    /* JADX INFO: renamed from: p */
    public DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> m6777p() {
        return this.f6487aX;
    }

    /* JADX INFO: renamed from: a */
    public C1191vk m6778a(@NotNull DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> deferredHolder) {
        this.f6487aX = deferredHolder;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: q */
    public DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> m6779q() {
        return this.f6488aY;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1191vk m6780b(@NotNull DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> deferredHolder) {
        this.f6488aY = deferredHolder;
        return this;
    }

    /* JADX INFO: renamed from: bI */
    public float m6781bI() {
        return this.f6489ow;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1191vk m6782a(float f) {
        this.f6489ow = f;
        return this;
    }
}
