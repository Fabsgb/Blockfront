package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0750nU;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oe */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oe.class */
public class C0813oe<V extends AbstractC0750nU> extends AbstractC0814of<V> {

    /* JADX INFO: renamed from: dA */
    public static final ResourceLocation f4402dA = C0532jO.m2378d("textures/misc/debug/vehicle_engine_particle.png");

    /* JADX INFO: renamed from: c */
    public final SimpleParticleType f4403c;

    public C0813oe(SimpleParticleType simpleParticleType, Vec3 vec3) {
        super(vec3);
        this.f4403c = simpleParticleType;
    }

    @Override // com.boehmod.blockfront.AbstractC0814of
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SimpleParticleType mo3747a(@NotNull Level level, @NotNull V v) {
        return this.f4403c;
    }

    @Override // com.boehmod.blockfront.AbstractC0814of
    /* JADX INFO: renamed from: b */
    public boolean mo3745b(V v) {
        return v.m3458bc() || v.m3460bd();
    }

    @Override // com.boehmod.blockfront.AbstractC0814of
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3746y() {
        return f4402dA;
    }
}
