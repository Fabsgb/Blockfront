package com.boehmod.blockfront;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wX.class */
public final class C1230wX {

    /* JADX INFO: renamed from: tn */
    private static final int f7033tn = 4;

    /* JADX INFO: renamed from: to */
    private static final int f7034to = 8;

    /* JADX INFO: renamed from: tp */
    private static final int f7039tp = 2;

    /* JADX INFO: renamed from: tq */
    private static final int f7058tq = 2;

    /* JADX INFO: renamed from: tr */
    private static final int f7064tr = 1;

    /* JADX INFO: renamed from: ts */
    private static final int f7065ts = 10;

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final DeferredRegister<EntityType<?>> f6982f = DeferredRegister.create(Registries.ENTITY_TYPE, "bf");

    /* JADX INFO: renamed from: dU */
    public static final String f6994dU = "camera";

    /* JADX INFO: renamed from: kB */
    public static final DeferredHolder<EntityType<?>, EntityType<C0701mZ>> f7029kB = f6982f.register(f6994dU, () -> {
        return EntityType.Builder.of(C0701mZ::new, MobCategory.MISC).sized(0.0f, 0.0f).setTrackingRange(10).setUpdateInterval(20).noSave().noSummon().build(C0564jv.m2555d(f6994dU).toString());
    });

    /* JADX INFO: renamed from: dT */
    public static final String f6993dT = "bomb";

    /* JADX INFO: renamed from: kC */
    public static final DeferredHolder<EntityType<?>, EntityType<C0677mB>> f7030kC = f6982f.register(f6993dT, () -> {
        return EntityType.Builder.of(C0677mB::new, MobCategory.MISC).sized(0.5f, 0.2f).setTrackingRange(10).setUpdateInterval(Integer.MAX_VALUE).build(C0564jv.m2555d(f6993dT).toString());
    });

    /* JADX INFO: renamed from: ef */
    public static final String f7005ef = "gun_dealer";

    /* JADX INFO: renamed from: kD */
    public static final DeferredHolder<EntityType<?>, EntityType<C0700mY>> f7031kD = f6982f.register(f7005ef, () -> {
        return EntityType.Builder.of(C0700mY::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).setUpdateInterval(40).noSave().build(C0564jv.m2555d(f7005ef).toString());
    });

    /* JADX INFO: renamed from: en */
    public static final String f7013en = "flame_thrower_fire";

    /* JADX INFO: renamed from: kE */
    public static final DeferredHolder<EntityType<?>, EntityType<C0766nl>> f7032kE = f6982f.register(f7013en, () -> {
        return EntityType.Builder.of(C0766nl::new, MobCategory.MISC).sized(0.1f, 0.1f).setTrackingRange(10).setUpdateInterval(4).noSave().noSummon().build(C0564jv.m2555d(f7013en).toString());
    });

    /* JADX INFO: renamed from: ed */
    public static final String f7003ed = "bot";

    /* JADX INFO: renamed from: kF */
    public static final DeferredHolder<EntityType<?>, EntityType<C0680mE>> f7035kF = f6982f.register(f7003ed, () -> {
        return EntityType.Builder.of(C0680mE::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).build(C0564jv.m2555d(f7003ed).toString());
    });

    /* JADX INFO: renamed from: ej */
    public static final String f7009ej = "obunga";

    /* JADX INFO: renamed from: kG */
    public static final DeferredHolder<EntityType<?>, EntityType<C0699mX>> f7036kG = f6982f.register(f7009ej, () -> {
        return EntityType.Builder.of(C0699mX::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(64).clientTrackingRange(8).build(C0564jv.m2555d(f7009ej).toString());
    });

    /* JADX INFO: renamed from: ek */
    public static final String f7010ek = "michael";

    /* JADX INFO: renamed from: kH */
    public static final DeferredHolder<EntityType<?>, EntityType<C0697mV>> f7037kH = f6982f.register(f7010ek, () -> {
        return EntityType.Builder.of(C0697mV::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).build(C0564jv.m2555d(f7010ek).toString());
    });

    /* JADX INFO: renamed from: el */
    public static final String f7011el = "panzerknacker";

    /* JADX INFO: renamed from: kI */
    public static final DeferredHolder<EntityType<?>, EntityType<C0696mU>> f7038kI = f6982f.register(f7011el, () -> {
        return EntityType.Builder.of(C0696mU::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).build(C0564jv.m2555d(f7011el).toString());
    });

    /* JADX INFO: renamed from: dJ */
    public static final String f6983dJ = "grenade_frag";

    /* JADX INFO: renamed from: kJ */
    public static final DeferredHolder<EntityType<?>, EntityType<C0774nt>> f7040kJ = f6982f.register(f6983dJ, () -> {
        return EntityType.Builder.of(C0774nt::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6983dJ).toString());
    });

    /* JADX INFO: renamed from: dK */
    public static final String f6984dK = "grenade_flash";

    /* JADX INFO: renamed from: kK */
    public static final DeferredHolder<EntityType<?>, EntityType<C0773ns>> f7041kK = f6982f.register(f6984dK, () -> {
        return EntityType.Builder.of(C0773ns::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6984dK).toString());
    });

    /* JADX INFO: renamed from: dL */
    public static final String f6985dL = "grenade_smoke";

    /* JADX INFO: renamed from: kL */
    public static final DeferredHolder<EntityType<?>, EntityType<C0777nw>> f7042kL = f6982f.register(f6985dL, () -> {
        return EntityType.Builder.of(C0777nw::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6985dL).toString());
    });

    /* JADX INFO: renamed from: dM */
    public static final String f6986dM = "grenade_fire";

    /* JADX INFO: renamed from: kM */
    public static final DeferredHolder<EntityType<?>, EntityType<C0772nr>> f7043kM = f6982f.register(f6986dM, () -> {
        return EntityType.Builder.of(C0772nr::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6986dM).toString());
    });

    /* JADX INFO: renamed from: dN */
    public static final String f6987dN = "grenade_molotov";

    /* JADX INFO: renamed from: kN */
    public static final DeferredHolder<EntityType<?>, EntityType<C0776nv>> f7044kN = f6982f.register(f6987dN, () -> {
        return EntityType.Builder.of(C0776nv::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6987dN).toString());
    });

    /* JADX INFO: renamed from: dO */
    public static final String f6988dO = "grenade_decoy";

    /* JADX INFO: renamed from: kO */
    public static final DeferredHolder<EntityType<?>, EntityType<C0771nq>> f7045kO = f6982f.register(f6988dO, () -> {
        return EntityType.Builder.of(C0771nq::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6988dO).toString());
    });

    /* JADX INFO: renamed from: dP */
    public static final String f6989dP = "grenade_holy";

    /* JADX INFO: renamed from: kP */
    public static final DeferredHolder<EntityType<?>, EntityType<C0775nu>> f7046kP = f6982f.register(f6989dP, () -> {
        return EntityType.Builder.of(C0775nu::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6989dP).toString());
    });

    /* JADX INFO: renamed from: dQ */
    public static final String f6990dQ = "medical_bag";

    /* JADX INFO: renamed from: kQ */
    public static final DeferredHolder<EntityType<?>, EntityType<C0769no>> f7047kQ = f6982f.register(f6990dQ, () -> {
        return EntityType.Builder.of(C0769no::new, MobCategory.MISC).sized(0.65f, 0.65f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6990dQ).toString());
    });

    /* JADX INFO: renamed from: dR */
    public static final String f6991dR = "ammo_box";

    /* JADX INFO: renamed from: kR */
    public static final DeferredHolder<EntityType<?>, EntityType<C0764nj>> f7048kR = f6982f.register(f6991dR, () -> {
        return EntityType.Builder.of(C0764nj::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6991dR).toString());
    });

    /* JADX INFO: renamed from: dS */
    public static final String f6992dS = "landmine";

    /* JADX INFO: renamed from: kS */
    public static final DeferredHolder<EntityType<?>, EntityType<C0768nn>> f7049kS = f6982f.register(f6992dS, () -> {
        return EntityType.Builder.of(C0768nn::new, MobCategory.MISC).sized(0.5f, 0.3f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6992dS).toString());
    });

    /* JADX INFO: renamed from: em */
    public static final String f7012em = "acid_ball";

    /* JADX INFO: renamed from: kT */
    public static final DeferredHolder<EntityType<?>, EntityType<C0763ni>> f7050kT = f6982f.register(f7012em, () -> {
        return EntityType.Builder.of(C0763ni::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f7012em).toString());
    });

    /* JADX INFO: renamed from: dV */
    public static final String f6995dV = "rocket";

    /* JADX INFO: renamed from: kU */
    public static final DeferredHolder<EntityType<?>, EntityType<C0760nf>> f7051kU = f6982f.register(f6995dV, () -> {
        return EntityType.Builder.of(C0760nf::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6995dV).toString());
    });

    /* JADX INFO: renamed from: dW */
    public static final String f6996dW = "tank_rocket";

    /* JADX INFO: renamed from: kV */
    public static final DeferredHolder<EntityType<?>, EntityType<C0762nh>> f7052kV = f6982f.register(f6996dW, () -> {
        return EntityType.Builder.of(C0762nh::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6996dW).toString());
    });

    /* JADX INFO: renamed from: eb */
    public static final String f7001eb = "melon_rocket";

    /* JADX INFO: renamed from: kW */
    public static final DeferredHolder<EntityType<?>, EntityType<C0758nd>> f7053kW = f6982f.register(f7001eb, () -> {
        return EntityType.Builder.of(C0758nd::new, MobCategory.MISC).sized(0.2f, 0.2f).clientTrackingRange(4).updateInterval(20).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f7001eb).toString());
    });

    /* JADX INFO: renamed from: dX */
    public static final String f6997dX = "airstrike_rocket";

    /* JADX INFO: renamed from: kX */
    public static final DeferredHolder<EntityType<?>, EntityType<C0756nb>> f7054kX = f6982f.register(f6997dX, () -> {
        return EntityType.Builder.of(C0756nb::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6997dX).toString());
    });

    /* JADX INFO: renamed from: dY */
    public static final String f6998dY = "precision_airstrike_rocket";

    /* JADX INFO: renamed from: kY */
    public static final DeferredHolder<EntityType<?>, EntityType<C0759ne>> f7055kY = f6982f.register(f6998dY, () -> {
        return EntityType.Builder.of(C0759ne::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6998dY).toString());
    });

    /* JADX INFO: renamed from: dZ */
    public static final String f6999dZ = "smoke_strike_rocket";

    /* JADX INFO: renamed from: kZ */
    public static final DeferredHolder<EntityType<?>, EntityType<C0761ng>> f7056kZ = f6982f.register(f6999dZ, () -> {
        return EntityType.Builder.of(C0761ng::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f6999dZ).toString());
    });

    /* JADX INFO: renamed from: ea */
    public static final String f7000ea = "anti_air_rocket";

    /* JADX INFO: renamed from: la */
    public static final DeferredHolder<EntityType<?>, EntityType<C0757nc>> f7057la = f6982f.register(f7000ea, () -> {
        return EntityType.Builder.of(C0757nc::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0564jv.m2555d(f7000ea).toString());
    });

    /* JADX INFO: renamed from: ec */
    public static final String f7002ec = "human";

    /* JADX INFO: renamed from: lb */
    public static final DeferredHolder<EntityType<?>, EntityType<C0678mC>> f7059lb = f6982f.register(f7002ec, () -> {
        return EntityType.Builder.of(C0678mC::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0564jv.m2555d(f7002ec).toString());
    });

    /* JADX INFO: renamed from: ee */
    public static final String f7004ee = "infected";

    /* JADX INFO: renamed from: lc */
    public static final DeferredHolder<EntityType<?>, EntityType<C0692mQ>> f7060lc = f6982f.register(f7004ee, () -> {
        return EntityType.Builder.of(C0692mQ::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0564jv.m2555d(f7004ee).toString());
    });

    /* JADX INFO: renamed from: eg */
    public static final String f7006eg = "infected_dog";

    /* JADX INFO: renamed from: ld */
    public static final DeferredHolder<EntityType<?>, EntityType<C0693mR>> f7061ld = f6982f.register(f7006eg, () -> {
        return EntityType.Builder.of(C0693mR::new, MobCategory.MISC).sized(0.6f, 1.5f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0564jv.m2555d(f7006eg).toString());
    });

    /* JADX INFO: renamed from: eh */
    public static final String f7007eh = "infected_spitter";

    /* JADX INFO: renamed from: le */
    public static final DeferredHolder<EntityType<?>, EntityType<C0694mS>> f7062le = f6982f.register(f7007eh, () -> {
        return EntityType.Builder.of(C0694mS::new, MobCategory.MISC).sized(0.6f, 1.5f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0564jv.m2555d(f7007eh).toString());
    });

    /* JADX INFO: renamed from: ei */
    public static final String f7008ei = "infected_stalker";

    /* JADX INFO: renamed from: lf */
    public static final DeferredHolder<EntityType<?>, EntityType<C0695mT>> f7063lf = f6982f.register(f7008ei, () -> {
        return EntityType.Builder.of(C0695mT::new, MobCategory.MISC).sized(0.6f, 1.5f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0564jv.m2555d(f7008ei).toString());
    });

    /* JADX INFO: renamed from: eo */
    public static final String f7014eo = "sherman_tank";

    /* JADX INFO: renamed from: lg */
    public static final DeferredHolder<EntityType<?>, EntityType<C0808oa>> f7066lg = f6982f.register(f7014eo, () -> {
        return EntityType.Builder.of(C0808oa::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7014eo).toString());
    });

    /* JADX INFO: renamed from: eC */
    public static final String f7028eC = "renault_ft_tank";

    /* JADX INFO: renamed from: lh */
    public static final DeferredHolder<EntityType<?>, EntityType<C0754nZ>> f7067lh = f6982f.register(f7028eC, () -> {
        return EntityType.Builder.of(C0754nZ::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7028eC).toString());
    });

    /* JADX INFO: renamed from: ep */
    public static final String f7015ep = "renault_ahn";

    /* JADX INFO: renamed from: li */
    public static final DeferredHolder<EntityType<?>, EntityType<C0753nY>> f7068li = f6982f.register(f7015ep, () -> {
        return EntityType.Builder.of(C0753nY::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7015ep).toString());
    });

    /* JADX INFO: renamed from: eq */
    public static final String f7016eq = "citroen_11cv_traction_avant";

    /* JADX INFO: renamed from: lj */
    public static final DeferredHolder<EntityType<?>, EntityType<C0746nR>> f7069lj = f6982f.register(f7016eq, () -> {
        return EntityType.Builder.of(C0746nR::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7016eq).toString());
    });

    /* JADX INFO: renamed from: er */
    public static final String f7017er = "tiger_ausf_h_tank";

    /* JADX INFO: renamed from: lk */
    public static final DeferredHolder<EntityType<?>, EntityType<C0810oc>> f7070lk = f6982f.register(f7017er, () -> {
        return EntityType.Builder.of(C0810oc::new, MobCategory.MISC).sized(2.75f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7014eo).toString());
    });

    /* JADX INFO: renamed from: es */
    public static final String f7018es = "t34_tank";

    /* JADX INFO: renamed from: ll */
    public static final DeferredHolder<EntityType<?>, EntityType<C0809ob>> f7071ll = f6982f.register(f7018es, () -> {
        return EntityType.Builder.of(C0809ob::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7018es).toString());
    });

    /* JADX INFO: renamed from: et */
    public static final String f7019et = "chiha_tank";

    /* JADX INFO: renamed from: lm */
    public static final DeferredHolder<EntityType<?>, EntityType<C0745nQ>> f7072lm = f6982f.register(f7019et, () -> {
        return EntityType.Builder.of(C0745nQ::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7019et).toString());
    });

    /* JADX INFO: renamed from: eu */
    public static final String f7020eu = "lancia_1zm_car";

    /* JADX INFO: renamed from: ln */
    public static final DeferredHolder<EntityType<?>, EntityType<C0750nV>> f7073ln = f6982f.register(f7020eu, () -> {
        return EntityType.Builder.of(C0750nV::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7020eu).toString());
    });

    /* JADX INFO: renamed from: ev */
    public static final String f7021ev = "flak88_gun";

    /* JADX INFO: renamed from: lo */
    public static final DeferredHolder<EntityType<?>, EntityType<C0748nT>> f7074lo = f6982f.register(f7021ev, () -> {
        return EntityType.Builder.of(C0748nT::new, MobCategory.MISC).sized(1.25f, 1.0f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7021ev).toString());
    });

    /* JADX INFO: renamed from: ew */
    public static final String f7022ew = "flak38_gun";

    /* JADX INFO: renamed from: lp */
    public static final DeferredHolder<EntityType<?>, EntityType<C0747nS>> f7075lp = f6982f.register(f7022ew, () -> {
        return EntityType.Builder.of(C0747nS::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7022ew).toString());
    });

    /* JADX INFO: renamed from: ex */
    public static final String f7023ex = "type96_gun";

    /* JADX INFO: renamed from: lq */
    public static final DeferredHolder<EntityType<?>, EntityType<C0811od>> f7076lq = f6982f.register(f7023ex, () -> {
        return EntityType.Builder.of(C0811od::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7023ex).toString());
    });

    /* JADX INFO: renamed from: ey */
    public static final String f7024ey = "panzeriv_tank";

    /* JADX INFO: renamed from: lr */
    public static final DeferredHolder<EntityType<?>, EntityType<C0751nW>> f7077lr = f6982f.register(f7024ey, () -> {
        return EntityType.Builder.of(C0751nW::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7024ey).toString());
    });

    /* JADX INFO: renamed from: ez */
    public static final String f7025ez = "7tp_pelican_tank";

    /* JADX INFO: renamed from: ls */
    public static final DeferredHolder<EntityType<?>, EntityType<C0752nX>> f7078ls = f6982f.register(f7025ez, () -> {
        return EntityType.Builder.of(C0752nX::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7014eo).toString());
    });

    /* JADX INFO: renamed from: eA */
    public static final String f7026eA = "willys_jeep_car";

    /* JADX INFO: renamed from: lt */
    public static final DeferredHolder<EntityType<?>, EntityType<C0812oe>> f7079lt = f6982f.register(f7026eA, () -> {
        return EntityType.Builder.of(C0812oe::new, MobCategory.MISC).sized(2.0f, 1.25f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7026eA).toString());
    });

    /* JADX INFO: renamed from: eB */
    public static final String f7027eB = "kubelwagen_car";

    /* JADX INFO: renamed from: lu */
    public static final DeferredHolder<EntityType<?>, EntityType<C0749nU>> f7080lu = f6982f.register(f7027eB, () -> {
        return EntityType.Builder.of(C0749nU::new, MobCategory.MISC).sized(2.0f, 1.25f).setUpdateInterval(1).clientTrackingRange(10).build(C0564jv.m2555d(f7027eB).toString());
    });
}
