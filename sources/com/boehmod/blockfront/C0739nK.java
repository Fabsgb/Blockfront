package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0779ny;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nK.class */
public class C0739nK<V extends AbstractC0779ny> extends AbstractC0738nJ<V> {

    /* JADX INFO: renamed from: dD */
    public static final ResourceLocation f3978dD = C0564jv.m2555d("textures/misc/debug/vehicle_wheel_particle.png");

    public C0739nK(Vec3 vec3) {
        super(vec3);
    }

    @Override // com.boehmod.blockfront.AbstractC0738nJ
    /* JADX INFO: renamed from: a */
    public ParticleOptions mo3375a(@NotNull Level level, @NotNull V v) {
        Vec3 vec3Position = v.position();
        Vec3 vec3YRot = this.f3976r.yRot(((-v.getYRot()) * 0.017453292f) - 1.5707964f);
        return new BlockParticleOption(ParticleTypes.BLOCK, level.getBlockState(BlockPos.containing(new Vec3(vec3Position.x + vec3YRot.x, vec3Position.y + vec3YRot.y, vec3Position.z + vec3YRot.z)).offset(0, -1, 0)));
    }

    @Override // com.boehmod.blockfront.AbstractC0738nJ
    /* JADX INFO: renamed from: b */
    public boolean mo3373b(V v) {
        return v.m3521aS() || v.m3523aT() || v.m3525aU() || v.m3527aV();
    }

    @Override // com.boehmod.blockfront.AbstractC0738nJ
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo3374x() {
        return f3978dD;
    }
}
