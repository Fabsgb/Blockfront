package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wZ.class */
public class C1232wZ {

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final DeferredRegister<ParticleType<?>> f7286g = DeferredRegister.create(Registries.PARTICLE_TYPE, "bf");

    /* JADX INFO: renamed from: no */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7287no = f7286g.register("far_smoke_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: np */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7288np = f7286g.register("blood_splat_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nq */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7289nq = f7286g.register("blood_ground_splat_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nr */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7290nr = f7286g.register("falling_leaf_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: ns */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7291ns = f7286g.register("acid_splat_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nt */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7292nt = f7286g.register("acid_ground_splat_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nu */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7293nu = f7286g.register(C1230wX.f6984dK, () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nv */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7294nv = f7286g.register("long_grenade_smoke", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nw */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7295nw = f7286g.register("bullet_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nx */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7296nx = f7286g.register("surrender_paper", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: ny */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7297ny = f7286g.register("paper", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nz */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7298nz = f7286g.register("powerful_blood_splat_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nA */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7299nA = f7286g.register("electric_spark_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nB */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7300nB = f7286g.register("bullet_spark_particle", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nC */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7301nC = f7286g.register("bullet_impact_smoke", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nD */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7302nD = f7286g.register("bullet_impact_smoke_snow", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nE */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7303nE = f7286g.register("bullet_impact_smoke_spice_gold", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nF */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7304nF = f7286g.register("bullet_impact_smoke_spice_red", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nG */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7305nG = f7286g.register("bullet_impact_smoke_spice_white", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nH */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7306nH = f7286g.register("bullet_impact_large_smoke", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nI */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7307nI = f7286g.register("bullet_impact_snow", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nJ */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7308nJ = f7286g.register("bullet_impact_spice_gold", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nK */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7309nK = f7286g.register("bullet_impact_spice_red", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nL */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7310nL = f7286g.register("bullet_impact_spice_white", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nM */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7311nM = f7286g.register("shrapnel_smoke", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nN */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7312nN = f7286g.register("blood_impact_smoke", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nO */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7313nO = f7286g.register("alert", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nP */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7314nP = f7286g.register("heal", () -> {
        return new SimpleParticleType(true);
    });

    /* JADX INFO: renamed from: nQ */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7315nQ = f7286g.register("bullet_impact_flash_basic", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nR */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7316nR = f7286g.register("bullet_impact_flash_strong", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nS */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7317nS = f7286g.register("falling_snow_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nT */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7318nT = f7286g.register("falling_snow_fast_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nU */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7319nU = f7286g.register("falling_snow_heavy_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nV */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7320nV = f7286g.register("blizzard_smoke_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nW */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7321nW = f7286g.register("poof_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nX */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7322nX = f7286g.register("smoke_grenade_smoke", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nY */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7323nY = f7286g.register("cloud_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: nZ */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7324nZ = f7286g.register("raindrop", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: oa */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7325oa = f7286g.register("oil_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: ob */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7326ob = f7286g.register("sandstorm_nose_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: oc */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7327oc = f7286g.register("sandstorm_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: od */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7328od = f7286g.register("falling_sand_heavy_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: oe */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7329oe = f7286g.register("sand_cloud_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: of */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7330of = f7286g.register("sand_cloud_small_particle", () -> {
        return new C0346fp(true);
    });

    /* JADX INFO: renamed from: og */
    public static final DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> f7331og = f7286g.register("snow_cloud_small_particle", () -> {
        return new C0346fp(true);
    });
}
