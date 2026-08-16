package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0750nU;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.of */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/of.class */
public abstract class AbstractC0814of<V extends AbstractC0750nU> {

    /* JADX INFO: renamed from: r */
    public Vec3 f4404r;

    /* JADX INFO: renamed from: N */
    public Vec3 f4405N = Vec3.ZERO;

    /* JADX INFO: renamed from: a */
    public abstract ParticleOptions mo3747a(@NotNull Level level, @NotNull V v);

    /* JADX INFO: renamed from: b */
    public abstract boolean mo3745b(V v);

    @NotNull
    /* JADX INFO: renamed from: y */
    public abstract ResourceLocation mo3746y();

    public AbstractC0814of(Vec3 vec3) {
        this.f4404r = vec3;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0814of<V> m3748a(Vec3 vec3) {
        this.f4405N = vec3;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public void m3749c(V v) {
    }

    /* JADX INFO: renamed from: f */
    public void m3750f(V v) {
        if (mo3745b(v)) {
            m3751g(v);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m3751g(V v) {
        Level level = v.level();
        Vec3 vec3Position = v.position();
        Vec3 vec3YRot = this.f4404r.yRot(((-v.getYRot()) * 0.017453292f) - 1.5707964f);
        level.addParticle(mo3747a(level, v), true, vec3Position.x + vec3YRot.x, vec3Position.y + vec3YRot.y, vec3Position.z + vec3YRot.z, this.f4405N.x, this.f4405N.y, this.f4405N.z);
    }
}
