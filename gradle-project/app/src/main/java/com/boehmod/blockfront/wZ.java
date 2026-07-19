package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wZ.class */
public class wZ {

    @NotNull
    public static final DeferredRegister<ParticleType<?>> g = DeferredRegister.create(Registries.PARTICLE_TYPE, "bf");
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> no = g.register("far_smoke_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> np = g.register("blood_splat_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nq = g.register("blood_ground_splat_particle", () -> {
        return new SimpleParticleType(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nr = g.register("falling_leaf_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> ns = g.register("acid_splat_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nt = g.register("acid_ground_splat_particle", () -> {
        return new SimpleParticleType(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nu = g.register(wX.dK, () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nv = g.register("long_grenade_smoke", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nw = g.register("bullet_particle", () -> {
        return new SimpleParticleType(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nx = g.register("surrender_paper", () -> {
        return new SimpleParticleType(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> ny = g.register("paper", () -> {
        return new SimpleParticleType(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nz = g.register("powerful_blood_splat_particle", () -> {
        return new SimpleParticleType(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nA = g.register("electric_spark_particle", () -> {
        return new SimpleParticleType(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nB = g.register("bullet_spark_particle", () -> {
        return new SimpleParticleType(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nC = g.register("bullet_impact_smoke", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nD = g.register("bullet_impact_smoke_snow", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nE = g.register("bullet_impact_smoke_spice_gold", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nF = g.register("bullet_impact_smoke_spice_red", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nG = g.register("bullet_impact_smoke_spice_white", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nH = g.register("bullet_impact_large_smoke", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nI = g.register("bullet_impact_snow", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nJ = g.register("bullet_impact_spice_gold", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nK = g.register("bullet_impact_spice_red", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nL = g.register("bullet_impact_spice_white", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nM = g.register("shrapnel_smoke", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nN = g.register("blood_impact_smoke", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nO = g.register("alert", () -> {
        return new SimpleParticleType(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nP = g.register("heal", () -> {
        return new SimpleParticleType(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nQ = g.register("bullet_impact_flash_basic", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nR = g.register("bullet_impact_flash_strong", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nS = g.register("falling_snow_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nT = g.register("falling_snow_fast_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nU = g.register("falling_snow_heavy_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nV = g.register("blizzard_smoke_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nW = g.register("poof_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nX = g.register("smoke_grenade_smoke", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nY = g.register("cloud_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> nZ = g.register("raindrop", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> oa = g.register("oil_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> ob = g.register("sandstorm_nose_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> oc = g.register("sandstorm_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> od = g.register("falling_sand_heavy_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> oe = g.register("sand_cloud_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> of = g.register("sand_cloud_small_particle", () -> {
        return new C0152fp(true);
    });
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> og = g.register("snow_cloud_small_particle", () -> {
        return new C0152fp(true);
    });
}
