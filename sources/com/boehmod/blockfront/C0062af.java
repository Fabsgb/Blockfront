package com.boehmod.blockfront;

import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.af */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/af.class */
public class C0062af extends C0060ad {

    /* JADX INFO: renamed from: b */
    private final SimpleParticleType f427b;

    /* JADX INFO: renamed from: v */
    private final float f428v = 1.0f;

    /* JADX INFO: renamed from: d */
    private Vec3 f429d;

    public C0062af(@NotNull Vec3 vec3, @NotNull DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> deferredHolder, int i) {
        super(vec3, i);
        this.f428v = 1.0f;
        this.f429d = Vec3.ZERO;
        this.f427b = (SimpleParticleType) deferredHolder.get();
    }

    public C0062af(@NotNull Vec3 vec3, @NotNull SimpleParticleType simpleParticleType, int i) {
        super(vec3, i);
        this.f428v = 1.0f;
        this.f429d = Vec3.ZERO;
        this.f427b = simpleParticleType;
    }

    /* JADX INFO: renamed from: a */
    public C0062af m277a(@NotNull Vec3 vec3) {
        this.f429d = vec3;
        return this;
    }

    @Override // com.boehmod.blockfront.C0060ad
    /* JADX INFO: renamed from: a */
    public boolean mo276a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel) {
        double dRandom = Math.random();
        Objects.requireNonNull(this);
        if (dRandom <= 1.0d) {
            C0490iZ.m2218a(minecraft, c0623l, clientLevel, this.f427b, this.f425c.x, this.f425c.y, this.f425c.z, this.f429d.x, this.f429d.y, this.f429d.z);
        }
        return super.mo276a(minecraft, c0623l, clientLevel);
    }
}
