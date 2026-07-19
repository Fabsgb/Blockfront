package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0376ny;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nJ.class */
public abstract class nJ<V extends AbstractC0376ny> {
    public Vec3 r;
    public Vec3 M = Vec3.ZERO;

    /* JADX INFO: renamed from: a */
    public abstract ParticleOptions mo721a(@NotNull Level level, @NotNull V v);

    public abstract boolean b(V v);

    @NotNull
    public abstract ResourceLocation x();

    public nJ(Vec3 vec3) {
        this.r = vec3;
    }

    public nJ<V> a(Vec3 vec3) {
        this.M = vec3;
        return this;
    }

    public void c(V v) {
    }

    public void f(V v) {
        if (b(v)) {
            g(v);
        }
    }

    private void g(V v) {
        Level level = v.level();
        Vec3 vec3Position = v.position();
        Vec3 vec3YRot = this.r.yRot(((-v.getYRot()) * 0.017453292f) - 1.5707964f);
        level.addParticle(mo721a(level, v), true, vec3Position.x + vec3YRot.x, vec3Position.y + vec3YRot.y, vec3Position.z + vec3YRot.z, this.M.x, this.M.y, this.M.z);
    }
}
