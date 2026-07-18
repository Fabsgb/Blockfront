package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0779ny;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nI.class */
public class C0737nI<V extends AbstractC0779ny> extends AbstractC0738nJ<V> {

    /* JADX INFO: renamed from: dC */
    public static final ResourceLocation f3974dC = C0564jv.m2555d("textures/misc/debug/vehicle_engine_particle.png");

    /* JADX INFO: renamed from: c */
    public final SimpleParticleType f3975c;

    public C0737nI(SimpleParticleType simpleParticleType, Vec3 vec3) {
        super(vec3);
        this.f3975c = simpleParticleType;
    }

    @Override // com.boehmod.blockfront.AbstractC0738nJ
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SimpleParticleType mo3375a(@NotNull Level level, @NotNull V v) {
        return this.f3975c;
    }

    @Override // com.boehmod.blockfront.AbstractC0738nJ
    /* JADX INFO: renamed from: b */
    public boolean mo3373b(V v) {
        return v.m3521aS() || v.m3523aT();
    }

    @Override // com.boehmod.blockfront.AbstractC0738nJ
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo3374x() {
        return f3974dC;
    }
}
