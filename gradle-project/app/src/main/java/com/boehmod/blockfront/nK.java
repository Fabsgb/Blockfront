package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0376ny;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nK.class */
public class nK<V extends AbstractC0376ny> extends nJ<V> {
    public static final ResourceLocation dD = C0265jv.d("textures/misc/debug/vehicle_wheel_particle.png");

    public nK(Vec3 vec3) {
        super(vec3);
    }

    @Override // com.boehmod.blockfront.nJ
    /* JADX INFO: renamed from: a */
    public ParticleOptions mo721a(@NotNull Level level, @NotNull V v) {
        Vec3 vec3Position = v.position();
        Vec3 vec3YRot = this.r.yRot(((-v.getYRot()) * 0.017453292f) - 1.5707964f);
        return new BlockParticleOption(ParticleTypes.BLOCK, level.getBlockState(BlockPos.containing(new Vec3(vec3Position.x + vec3YRot.x, vec3Position.y + vec3YRot.y, vec3Position.z + vec3YRot.z)).offset(0, -1, 0)));
    }

    @Override // com.boehmod.blockfront.nJ
    public boolean b(V v) {
        return v.aS() || v.aT() || v.aU() || v.aV();
    }

    @Override // com.boehmod.blockfront.nJ
    @NotNull
    public ResourceLocation x() {
        return dD;
    }
}
