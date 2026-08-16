package com.boehmod.blockfront;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xu.class */
public final class C1307xu {

    /* JADX INFO: renamed from: vr */
    private static final int f7598vr = 4;

    /* JADX INFO: renamed from: vs */
    private static final int f7599vs = 8;

    /* JADX INFO: renamed from: vt */
    private static final int f7604vt = 2;

    /* JADX INFO: renamed from: vu */
    private static final int f7623vu = 2;

    /* JADX INFO: renamed from: vv */
    private static final int f7629vv = 1;

    /* JADX INFO: renamed from: vw */
    private static final int f7630vw = 10;

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final DeferredRegister<EntityType<?>> f7547f = DeferredRegister.create(Registries.ENTITY_TYPE, "bf");

    /* JADX INFO: renamed from: ef */
    public static final String f7559ef = "camera";

    /* JADX INFO: renamed from: kB */
    public static final DeferredHolder<EntityType<?>, EntityType<C0777nv>> f7594kB = f7547f.register(f7559ef, () -> {
        return EntityType.Builder.of(C0777nv::new, MobCategory.MISC).sized(0.0f, 0.0f).setTrackingRange(10).setUpdateInterval(20).noSave().noSummon().build(C0532jO.m2378d(f7559ef).toString());
    });

    /* JADX INFO: renamed from: ee */
    public static final String f7558ee = "bomb";

    /* JADX INFO: renamed from: kC */
    public static final DeferredHolder<EntityType<?>, EntityType<C0700mX>> f7595kC = f7547f.register(f7558ee, () -> {
        return EntityType.Builder.of(C0700mX::new, MobCategory.MISC).sized(0.5f, 0.2f).setTrackingRange(10).setUpdateInterval(Integer.MAX_VALUE).build(C0532jO.m2378d(f7558ee).toString());
    });

    /* JADX INFO: renamed from: eq */
    public static final String f7570eq = "gun_dealer";

    /* JADX INFO: renamed from: kD */
    public static final DeferredHolder<EntityType<?>, EntityType<C0776nu>> f7596kD = f7547f.register(f7570eq, () -> {
        return EntityType.Builder.of(C0776nu::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).setUpdateInterval(40).noSave().build(C0532jO.m2378d(f7570eq).toString());
    });

    /* JADX INFO: renamed from: ey */
    public static final String f7578ey = "flame_thrower_fire";

    /* JADX INFO: renamed from: kE */
    public static final DeferredHolder<EntityType<?>, EntityType<C0737nH>> f7597kE = f7547f.register(f7578ey, () -> {
        return EntityType.Builder.of(C0737nH::new, MobCategory.MISC).sized(0.1f, 0.1f).setTrackingRange(10).setUpdateInterval(4).noSave().noSummon().build(C0532jO.m2378d(f7578ey).toString());
    });

    /* JADX INFO: renamed from: eo */
    public static final String f7568eo = "bot";

    /* JADX INFO: renamed from: kF */
    public static final DeferredHolder<EntityType<?>, EntityType<C0756na>> f7600kF = f7547f.register(f7568eo, () -> {
        return EntityType.Builder.of(C0756na::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).build(C0532jO.m2378d(f7568eo).toString());
    });

    /* JADX INFO: renamed from: eu */
    public static final String f7574eu = "obunga";

    /* JADX INFO: renamed from: kG */
    public static final DeferredHolder<EntityType<?>, EntityType<C0775nt>> f7601kG = f7547f.register(f7574eu, () -> {
        return EntityType.Builder.of(C0775nt::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(64).clientTrackingRange(8).build(C0532jO.m2378d(f7574eu).toString());
    });

    /* JADX INFO: renamed from: ev */
    public static final String f7575ev = "michael";

    /* JADX INFO: renamed from: kH */
    public static final DeferredHolder<EntityType<?>, EntityType<C0773nr>> f7602kH = f7547f.register(f7575ev, () -> {
        return EntityType.Builder.of(C0773nr::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).build(C0532jO.m2378d(f7575ev).toString());
    });

    /* JADX INFO: renamed from: ew */
    public static final String f7576ew = "panzerknacker";

    /* JADX INFO: renamed from: kI */
    public static final DeferredHolder<EntityType<?>, EntityType<C0772nq>> f7603kI = f7547f.register(f7576ew, () -> {
        return EntityType.Builder.of(C0772nq::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).build(C0532jO.m2378d(f7576ew).toString());
    });

    /* JADX INFO: renamed from: dU */
    public static final String f7548dU = "grenade_frag";

    /* JADX INFO: renamed from: kJ */
    public static final DeferredHolder<EntityType<?>, EntityType<C0745nP>> f7605kJ = f7547f.register(f7548dU, () -> {
        return EntityType.Builder.of(C0745nP::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7548dU).toString());
    });

    /* JADX INFO: renamed from: dV */
    public static final String f7549dV = "grenade_flash";

    /* JADX INFO: renamed from: kK */
    public static final DeferredHolder<EntityType<?>, EntityType<C0744nO>> f7606kK = f7547f.register(f7549dV, () -> {
        return EntityType.Builder.of(C0744nO::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7549dV).toString());
    });

    /* JADX INFO: renamed from: dW */
    public static final String f7550dW = "grenade_smoke";

    /* JADX INFO: renamed from: kL */
    public static final DeferredHolder<EntityType<?>, EntityType<C0748nS>> f7607kL = f7547f.register(f7550dW, () -> {
        return EntityType.Builder.of(C0748nS::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7550dW).toString());
    });

    /* JADX INFO: renamed from: dX */
    public static final String f7551dX = "grenade_fire";

    /* JADX INFO: renamed from: kM */
    public static final DeferredHolder<EntityType<?>, EntityType<C0743nN>> f7608kM = f7547f.register(f7551dX, () -> {
        return EntityType.Builder.of(C0743nN::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7551dX).toString());
    });

    /* JADX INFO: renamed from: dY */
    public static final String f7552dY = "grenade_molotov";

    /* JADX INFO: renamed from: kN */
    public static final DeferredHolder<EntityType<?>, EntityType<C0747nR>> f7609kN = f7547f.register(f7552dY, () -> {
        return EntityType.Builder.of(C0747nR::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7552dY).toString());
    });

    /* JADX INFO: renamed from: dZ */
    public static final String f7553dZ = "grenade_decoy";

    /* JADX INFO: renamed from: kO */
    public static final DeferredHolder<EntityType<?>, EntityType<C0742nM>> f7610kO = f7547f.register(f7553dZ, () -> {
        return EntityType.Builder.of(C0742nM::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7553dZ).toString());
    });

    /* JADX INFO: renamed from: ea */
    public static final String f7554ea = "grenade_holy";

    /* JADX INFO: renamed from: kP */
    public static final DeferredHolder<EntityType<?>, EntityType<C0746nQ>> f7611kP = f7547f.register(f7554ea, () -> {
        return EntityType.Builder.of(C0746nQ::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7554ea).toString());
    });

    /* JADX INFO: renamed from: eb */
    public static final String f7555eb = "medical_bag";

    /* JADX INFO: renamed from: kQ */
    public static final DeferredHolder<EntityType<?>, EntityType<C0740nK>> f7612kQ = f7547f.register(f7555eb, () -> {
        return EntityType.Builder.of(C0740nK::new, MobCategory.MISC).sized(0.65f, 0.65f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7555eb).toString());
    });

    /* JADX INFO: renamed from: ec */
    public static final String f7556ec = "ammo_box";

    /* JADX INFO: renamed from: kR */
    public static final DeferredHolder<EntityType<?>, EntityType<C0735nF>> f7613kR = f7547f.register(f7556ec, () -> {
        return EntityType.Builder.of(C0735nF::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7556ec).toString());
    });

    /* JADX INFO: renamed from: ed */
    public static final String f7557ed = "landmine";

    /* JADX INFO: renamed from: kS */
    public static final DeferredHolder<EntityType<?>, EntityType<C0739nJ>> f7614kS = f7547f.register(f7557ed, () -> {
        return EntityType.Builder.of(C0739nJ::new, MobCategory.MISC).sized(0.5f, 0.3f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7557ed).toString());
    });

    /* JADX INFO: renamed from: ex */
    public static final String f7577ex = "acid_ball";

    /* JADX INFO: renamed from: kT */
    public static final DeferredHolder<EntityType<?>, EntityType<C0734nE>> f7615kT = f7547f.register(f7577ex, () -> {
        return EntityType.Builder.of(C0734nE::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7577ex).toString());
    });

    /* JADX INFO: renamed from: eg */
    public static final String f7560eg = "rocket";

    /* JADX INFO: renamed from: kU */
    public static final DeferredHolder<EntityType<?>, EntityType<C0731nB>> f7616kU = f7547f.register(f7560eg, () -> {
        return EntityType.Builder.of(C0731nB::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7560eg).toString());
    });

    /* JADX INFO: renamed from: eh */
    public static final String f7561eh = "tank_rocket";

    /* JADX INFO: renamed from: kV */
    public static final DeferredHolder<EntityType<?>, EntityType<C0733nD>> f7617kV = f7547f.register(f7561eh, () -> {
        return EntityType.Builder.of(C0733nD::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7561eh).toString());
    });

    /* JADX INFO: renamed from: em */
    public static final String f7566em = "melon_rocket";

    /* JADX INFO: renamed from: kW */
    public static final DeferredHolder<EntityType<?>, EntityType<C0781nz>> f7618kW = f7547f.register(f7566em, () -> {
        return EntityType.Builder.of(C0781nz::new, MobCategory.MISC).sized(0.2f, 0.2f).clientTrackingRange(4).updateInterval(20).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7566em).toString());
    });

    /* JADX INFO: renamed from: ei */
    public static final String f7562ei = "airstrike_rocket";

    /* JADX INFO: renamed from: kX */
    public static final DeferredHolder<EntityType<?>, EntityType<C0779nx>> f7619kX = f7547f.register(f7562ei, () -> {
        return EntityType.Builder.of(C0779nx::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7562ei).toString());
    });

    /* JADX INFO: renamed from: ej */
    public static final String f7563ej = "precision_airstrike_rocket";

    /* JADX INFO: renamed from: kY */
    public static final DeferredHolder<EntityType<?>, EntityType<C0730nA>> f7620kY = f7547f.register(f7563ej, () -> {
        return EntityType.Builder.of(C0730nA::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7563ej).toString());
    });

    /* JADX INFO: renamed from: ek */
    public static final String f7564ek = "smoke_strike_rocket";

    /* JADX INFO: renamed from: kZ */
    public static final DeferredHolder<EntityType<?>, EntityType<C0732nC>> f7621kZ = f7547f.register(f7564ek, () -> {
        return EntityType.Builder.of(C0732nC::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7564ek).toString());
    });

    /* JADX INFO: renamed from: el */
    public static final String f7565el = "anti_air_rocket";

    /* JADX INFO: renamed from: la */
    public static final DeferredHolder<EntityType<?>, EntityType<C0780ny>> f7622la = f7547f.register(f7565el, () -> {
        return EntityType.Builder.of(C0780ny::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0532jO.m2378d(f7565el).toString());
    });

    /* JADX INFO: renamed from: en */
    public static final String f7567en = "human";

    /* JADX INFO: renamed from: lb */
    public static final DeferredHolder<EntityType<?>, EntityType<C0701mY>> f7624lb = f7547f.register(f7567en, () -> {
        return EntityType.Builder.of(C0701mY::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0532jO.m2378d(f7567en).toString());
    });

    /* JADX INFO: renamed from: ep */
    public static final String f7569ep = "infected";

    /* JADX INFO: renamed from: lc */
    public static final DeferredHolder<EntityType<?>, EntityType<C0768nm>> f7625lc = f7547f.register(f7569ep, () -> {
        return EntityType.Builder.of(C0768nm::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0532jO.m2378d(f7569ep).toString());
    });

    /* JADX INFO: renamed from: er */
    public static final String f7571er = "infected_dog";

    /* JADX INFO: renamed from: ld */
    public static final DeferredHolder<EntityType<?>, EntityType<C0769nn>> f7626ld = f7547f.register(f7571er, () -> {
        return EntityType.Builder.of(C0769nn::new, MobCategory.MISC).sized(0.6f, 1.5f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0532jO.m2378d(f7571er).toString());
    });

    /* JADX INFO: renamed from: es */
    public static final String f7572es = "infected_spitter";

    /* JADX INFO: renamed from: le */
    public static final DeferredHolder<EntityType<?>, EntityType<C0770no>> f7627le = f7547f.register(f7572es, () -> {
        return EntityType.Builder.of(C0770no::new, MobCategory.MISC).sized(0.6f, 1.5f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0532jO.m2378d(f7572es).toString());
    });

    /* JADX INFO: renamed from: et */
    public static final String f7573et = "infected_stalker";

    /* JADX INFO: renamed from: lf */
    public static final DeferredHolder<EntityType<?>, EntityType<C0771np>> f7628lf = f7547f.register(f7573et, () -> {
        return EntityType.Builder.of(C0771np::new, MobCategory.MISC).sized(0.6f, 1.5f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0532jO.m2378d(f7573et).toString());
    });

    /* JADX INFO: renamed from: ez */
    public static final String f7579ez = "sherman_tank";

    /* JADX INFO: renamed from: lg */
    public static final DeferredHolder<EntityType<?>, EntityType<C0831ow>> f7631lg = f7547f.register(f7579ez, () -> {
        return EntityType.Builder.of(C0831ow::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7579ez).toString());
    });

    /* JADX INFO: renamed from: eN */
    public static final String f7593eN = "renault_ft_tank";

    /* JADX INFO: renamed from: lh */
    public static final DeferredHolder<EntityType<?>, EntityType<C0830ov>> f7632lh = f7547f.register(f7593eN, () -> {
        return EntityType.Builder.of(C0830ov::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7593eN).toString());
    });

    /* JADX INFO: renamed from: eA */
    public static final String f7580eA = "renault_ahn";

    /* JADX INFO: renamed from: li */
    public static final DeferredHolder<EntityType<?>, EntityType<C0829ou>> f7633li = f7547f.register(f7580eA, () -> {
        return EntityType.Builder.of(C0829ou::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7580eA).toString());
    });

    /* JADX INFO: renamed from: eB */
    public static final String f7581eB = "citroen_11cv_traction_avant";

    /* JADX INFO: renamed from: lj */
    public static final DeferredHolder<EntityType<?>, EntityType<C0822on>> f7634lj = f7547f.register(f7581eB, () -> {
        return EntityType.Builder.of(C0822on::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7581eB).toString());
    });

    /* JADX INFO: renamed from: eC */
    public static final String f7582eC = "tiger_ausf_h_tank";

    /* JADX INFO: renamed from: lk */
    public static final DeferredHolder<EntityType<?>, EntityType<C0833oy>> f7635lk = f7547f.register(f7582eC, () -> {
        return EntityType.Builder.of(C0833oy::new, MobCategory.MISC).sized(2.75f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7579ez).toString());
    });

    /* JADX INFO: renamed from: eD */
    public static final String f7583eD = "t34_tank";

    /* JADX INFO: renamed from: ll */
    public static final DeferredHolder<EntityType<?>, EntityType<C0832ox>> f7636ll = f7547f.register(f7583eD, () -> {
        return EntityType.Builder.of(C0832ox::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7583eD).toString());
    });

    /* JADX INFO: renamed from: eE */
    public static final String f7584eE = "chiha_tank";

    /* JADX INFO: renamed from: lm */
    public static final DeferredHolder<EntityType<?>, EntityType<C0821om>> f7637lm = f7547f.register(f7584eE, () -> {
        return EntityType.Builder.of(C0821om::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7584eE).toString());
    });

    /* JADX INFO: renamed from: eF */
    public static final String f7585eF = "lancia_1zm_car";

    /* JADX INFO: renamed from: ln */
    public static final DeferredHolder<EntityType<?>, EntityType<C0826or>> f7638ln = f7547f.register(f7585eF, () -> {
        return EntityType.Builder.of(C0826or::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7585eF).toString());
    });

    /* JADX INFO: renamed from: eG */
    public static final String f7586eG = "flak88_gun";

    /* JADX INFO: renamed from: lo */
    public static final DeferredHolder<EntityType<?>, EntityType<C0824op>> f7639lo = f7547f.register(f7586eG, () -> {
        return EntityType.Builder.of(C0824op::new, MobCategory.MISC).sized(1.25f, 1.0f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7586eG).toString());
    });

    /* JADX INFO: renamed from: eH */
    public static final String f7587eH = "flak38_gun";

    /* JADX INFO: renamed from: lp */
    public static final DeferredHolder<EntityType<?>, EntityType<C0823oo>> f7640lp = f7547f.register(f7587eH, () -> {
        return EntityType.Builder.of(C0823oo::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7587eH).toString());
    });

    /* JADX INFO: renamed from: eI */
    public static final String f7588eI = "type96_gun";

    /* JADX INFO: renamed from: lq */
    public static final DeferredHolder<EntityType<?>, EntityType<C0834oz>> f7641lq = f7547f.register(f7588eI, () -> {
        return EntityType.Builder.of(C0834oz::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7588eI).toString());
    });

    /* JADX INFO: renamed from: eJ */
    public static final String f7589eJ = "panzeriv_tank";

    /* JADX INFO: renamed from: lr */
    public static final DeferredHolder<EntityType<?>, EntityType<C0827os>> f7642lr = f7547f.register(f7589eJ, () -> {
        return EntityType.Builder.of(C0827os::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7589eJ).toString());
    });

    /* JADX INFO: renamed from: eK */
    public static final String f7590eK = "7tp_pelican_tank";

    /* JADX INFO: renamed from: ls */
    public static final DeferredHolder<EntityType<?>, EntityType<C0828ot>> f7643ls = f7547f.register(f7590eK, () -> {
        return EntityType.Builder.of(C0828ot::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7579ez).toString());
    });

    /* JADX INFO: renamed from: eL */
    public static final String f7591eL = "willys_jeep_car";

    /* JADX INFO: renamed from: lt */
    public static final DeferredHolder<EntityType<?>, EntityType<C0783oA>> f7644lt = f7547f.register(f7591eL, () -> {
        return EntityType.Builder.of(C0783oA::new, MobCategory.MISC).sized(2.0f, 1.25f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7591eL).toString());
    });

    /* JADX INFO: renamed from: eM */
    public static final String f7592eM = "kubelwagen_car";

    /* JADX INFO: renamed from: lu */
    public static final DeferredHolder<EntityType<?>, EntityType<C0825oq>> f7645lu = f7547f.register(f7592eM, () -> {
        return EntityType.Builder.of(C0825oq::new, MobCategory.MISC).sized(2.0f, 1.25f).setUpdateInterval(1).clientTrackingRange(10).build(C0532jO.m2378d(f7592eM).toString());
    });
}
