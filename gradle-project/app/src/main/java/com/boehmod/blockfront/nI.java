package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0376ny;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nI.class */
public class nI<V extends AbstractC0376ny> extends nJ<V> {
    public static final ResourceLocation dC = C0265jv.d("textures/misc/debug/vehicle_engine_particle.png");
    public final SimpleParticleType c;

    public nI(SimpleParticleType simpleParticleType, Vec3 vec3) {
        super(vec3);
        this.c = simpleParticleType;
    }

    @Override // com.boehmod.blockfront.nJ
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SimpleParticleType mo721a(@NotNull Level level, @NotNull V v) {
        return this.c;
    }

    @Override // com.boehmod.blockfront.nJ
    public boolean b(V v) {
        return v.aS() || v.aT();
    }

    @Override // com.boehmod.blockfront.nJ
    @NotNull
    public ResourceLocation x() {
        return dC;
    }
}
