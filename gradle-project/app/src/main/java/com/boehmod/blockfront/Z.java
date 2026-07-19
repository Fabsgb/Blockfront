package com.boehmod.blockfront;

import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/Z.class */
public class Z extends X {
    private final SimpleParticleType b;
    private final float q = 1.0f;
    private Vec3 d;

    public Z(@NotNull Vec3 vec3, @NotNull DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> deferredHolder, int i) {
        super(vec3, i);
        this.q = 1.0f;
        this.d = Vec3.ZERO;
        this.b = (SimpleParticleType) deferredHolder.get();
    }

    public Z(@NotNull Vec3 vec3, @NotNull SimpleParticleType simpleParticleType, int i) {
        super(vec3, i);
        this.q = 1.0f;
        this.d = Vec3.ZERO;
        this.b = simpleParticleType;
    }

    public Z a(@NotNull Vec3 vec3) {
        this.d = vec3;
        return this;
    }

    @Override // com.boehmod.blockfront.X
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel) {
        double dRandom = Math.random();
        Objects.requireNonNull(this);
        if (dRandom <= 1.0d) {
            iG.a(minecraft, c0297l, clientLevel, this.b, this.c.x, this.c.y, this.c.z, this.d.x, this.d.y, this.d.z);
        }
        return super.a(minecraft, c0297l, clientLevel);
    }
}
