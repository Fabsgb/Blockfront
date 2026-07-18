package com.boehmod.blockfront;

import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.Z */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/Z.class */
public class C0028Z extends C0026X {

    /* JADX INFO: renamed from: b */
    private final SimpleParticleType f243b;

    /* JADX INFO: renamed from: q */
    private final float f244q = 1.0f;

    /* JADX INFO: renamed from: d */
    private Vec3 f245d;

    public C0028Z(@NotNull Vec3 vec3, @NotNull DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> deferredHolder, int i) {
        super(vec3, i);
        this.f244q = 1.0f;
        this.f245d = Vec3.ZERO;
        this.f243b = (SimpleParticleType) deferredHolder.get();
    }

    public C0028Z(@NotNull Vec3 vec3, @NotNull SimpleParticleType simpleParticleType, int i) {
        super(vec3, i);
        this.f244q = 1.0f;
        this.f245d = Vec3.ZERO;
        this.f243b = simpleParticleType;
    }

    /* JADX INFO: renamed from: a */
    public C0028Z m163a(@NotNull Vec3 vec3) {
        this.f245d = vec3;
        return this;
    }

    @Override // com.boehmod.blockfront.C0026X
    /* JADX INFO: renamed from: a */
    public boolean mo162a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel) {
        double dRandom = Math.random();
        Objects.requireNonNull(this);
        if (dRandom <= 1.0d) {
            C0470iG.m2126a(minecraft, c0622l, clientLevel, this.f243b, this.f241c.x, this.f241c.y, this.f241c.z, this.f245d.x, this.f245d.y, this.f245d.z);
        }
        return super.mo162a(minecraft, c0622l, clientLevel);
    }
}
