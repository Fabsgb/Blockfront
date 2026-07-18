package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0779ny;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nJ.class */
public abstract class AbstractC0738nJ<V extends AbstractC0779ny> {

    /* JADX INFO: renamed from: r */
    public Vec3 f3976r;

    /* JADX INFO: renamed from: M */
    public Vec3 f3977M = Vec3.ZERO;

    /* JADX INFO: renamed from: a */
    public abstract ParticleOptions mo3375a(@NotNull Level level, @NotNull V v);

    /* JADX INFO: renamed from: b */
    public abstract boolean mo3373b(V v);

    @NotNull
    /* JADX INFO: renamed from: x */
    public abstract ResourceLocation mo3374x();

    public AbstractC0738nJ(Vec3 vec3) {
        this.f3976r = vec3;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0738nJ<V> m3376a(Vec3 vec3) {
        this.f3977M = vec3;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public void m3377c(V v) {
    }

    /* JADX INFO: renamed from: f */
    public void m3378f(V v) {
        if (mo3373b(v)) {
            m3379g(v);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m3379g(V v) {
        Level level = v.level();
        Vec3 vec3Position = v.position();
        Vec3 vec3YRot = this.f3976r.yRot(((-v.getYRot()) * 0.017453292f) - 1.5707964f);
        level.addParticle(mo3375a(level, v), true, vec3Position.x + vec3YRot.x, vec3Position.y + vec3YRot.y, vec3Position.z + vec3YRot.z, this.f3977M.x, this.f3977M.y, this.f3977M.z);
    }
}
