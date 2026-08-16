package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0750nU;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.og */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/og.class */
public class C0815og<V extends AbstractC0750nU> extends AbstractC0814of<V> {

    /* JADX INFO: renamed from: dB */
    public static final ResourceLocation f4406dB = C0532jO.m2378d("textures/misc/debug/vehicle_wheel_particle.png");

    public C0815og(Vec3 vec3) {
        super(vec3);
    }

    @Override // com.boehmod.blockfront.AbstractC0814of
    /* JADX INFO: renamed from: a */
    public ParticleOptions mo3747a(@NotNull Level level, @NotNull V v) {
        Vec3 vec3Position = v.position();
        Vec3 vec3YRot = this.f4404r.yRot(((-v.getYRot()) * 0.017453292f) - 1.5707964f);
        return new BlockParticleOption(ParticleTypes.BLOCK, level.getBlockState(BlockPos.containing(new Vec3(vec3Position.x + vec3YRot.x, vec3Position.y + vec3YRot.y, vec3Position.z + vec3YRot.z)).offset(0, -1, 0)));
    }

    @Override // com.boehmod.blockfront.AbstractC0814of
    /* JADX INFO: renamed from: b */
    public boolean mo3745b(V v) {
        return v.m3458bc() || v.m3460bd() || v.m3462be() || v.m3464bf();
    }

    @Override // com.boehmod.blockfront.AbstractC0814of
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3746y() {
        return f4406dB;
    }
}
