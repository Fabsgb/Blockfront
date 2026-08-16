package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xw.class */
public class C1309xw {

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final DeferredRegister<ParticleType<?>> f7851g = DeferredRegister.create(Registries.PARTICLE_TYPE, "bf");

    /* JADX INFO: renamed from: no */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7852no = f7851g.register("far_smoke_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: np */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7853np = f7851g.register("blood_splat_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nq */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7854nq = f7851g.register("blood_ground_splat_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nr */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7855nr = f7851g.register("falling_leaf_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: ns */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7856ns = f7851g.register("acid_splat_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nt */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7857nt = f7851g.register("acid_ground_splat_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nu */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7858nu = f7851g.register(C1307xu.f7549dV, () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nv */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7859nv = f7851g.register("long_grenade_smoke", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nw */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7860nw = f7851g.register("bullet_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nx */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7861nx = f7851g.register("surrender_paper", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: ny */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7862ny = f7851g.register("paper", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nz */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7863nz = f7851g.register("powerful_blood_splat_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nA */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7864nA = f7851g.register("electric_spark_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nB */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7865nB = f7851g.register("bullet_spark_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nC */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7866nC = f7851g.register("bullet_impact_smoke", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nD */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7867nD = f7851g.register("bullet_impact_smoke_snow", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nE */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7868nE = f7851g.register("bullet_impact_smoke_spice_gold", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nF */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7869nF = f7851g.register("bullet_impact_smoke_spice_red", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nG */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7870nG = f7851g.register("bullet_impact_smoke_spice_white", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nH */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7871nH = f7851g.register("bullet_impact_large_smoke", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nI */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7872nI = f7851g.register("bullet_impact_snow", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nJ */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7873nJ = f7851g.register("bullet_impact_spice_gold", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nK */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7874nK = f7851g.register("bullet_impact_spice_red", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nL */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7875nL = f7851g.register("bullet_impact_spice_white", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nM */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7876nM = f7851g.register("shrapnel_smoke", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nN */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7877nN = f7851g.register("blood_impact_smoke", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nO */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7878nO = f7851g.register("alert", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nP */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7879nP = f7851g.register("heal", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nQ */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7880nQ = f7851g.register("bullet_impact_flash_basic", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nR */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7881nR = f7851g.register("bullet_impact_flash_strong", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nS */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7882nS = f7851g.register("falling_snow_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nT */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7883nT = f7851g.register("falling_snow_fast_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nU */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7884nU = f7851g.register("falling_snow_heavy_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nV */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7885nV = f7851g.register("blizzard_smoke_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nW */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7886nW = f7851g.register("poof_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nX */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7887nX = f7851g.register("debris_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nY */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7888nY = f7851g.register("debris_smoke_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: nZ */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7889nZ = f7851g.register("smoke_grenade_smoke", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: oa */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7890oa = f7851g.register("cloud_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: ob */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7891ob = f7851g.register("raindrop", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: oc */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7892oc = f7851g.register("oil_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: od */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7893od = f7851g.register("sandstorm_nose_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: oe */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7894oe = f7851g.register("sandstorm_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: of */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7895of = f7851g.register("falling_sand_heavy_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: og */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7896og = f7851g.register("sand_cloud_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: oh */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7897oh = f7851g.register("sand_cloud_small_particle", () -> {
        return new C0311fF(true);
    });

    /* JADX INFO: renamed from: oi */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7898oi = f7851g.register("snow_cloud_small_particle", () -> {
        return new C0311fF(true);
    });
}
