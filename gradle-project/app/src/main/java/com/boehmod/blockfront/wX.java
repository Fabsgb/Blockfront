package com.boehmod.blockfront;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wX.class */
public final class wX {
    private static final int tn = 4;
    private static final int to = 8;
    private static final int tp = 2;
    private static final int tq = 2;
    private static final int tr = 1;
    private static final int ts = 10;

    @NotNull
    public static final DeferredRegister<EntityType<?>> f = DeferredRegister.create(Registries.ENTITY_TYPE, "bf");
    public static final String dU = "camera";
    public static final DeferredHolder<EntityType<?>, EntityType<mZ>> kB = f.register(dU, () -> {
        return EntityType.Builder.of(mZ::new, MobCategory.MISC).sized(0.0f, 0.0f).setTrackingRange(10).setUpdateInterval(20).noSave().noSummon().build(C0265jv.d(dU).toString());
    });
    public static final String dT = "bomb";
    public static final DeferredHolder<EntityType<?>, EntityType<mB>> kC = f.register(dT, () -> {
        return EntityType.Builder.of(mB::new, MobCategory.MISC).sized(0.5f, 0.2f).setTrackingRange(10).setUpdateInterval(Integer.MAX_VALUE).build(C0265jv.d(dT).toString());
    });
    public static final String ef = "gun_dealer";
    public static final DeferredHolder<EntityType<?>, EntityType<mY>> kD = f.register(ef, () -> {
        return EntityType.Builder.of(mY::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).setUpdateInterval(40).noSave().build(C0265jv.d(ef).toString());
    });
    public static final String en = "flame_thrower_fire";
    public static final DeferredHolder<EntityType<?>, EntityType<C0363nl>> kE = f.register(en, () -> {
        return EntityType.Builder.of(C0363nl::new, MobCategory.MISC).sized(0.1f, 0.1f).setTrackingRange(10).setUpdateInterval(4).noSave().noSummon().build(C0265jv.d(en).toString());
    });
    public static final String ed = "bot";
    public static final DeferredHolder<EntityType<?>, EntityType<mE>> kF = f.register(ed, () -> {
        return EntityType.Builder.of(mE::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).build(C0265jv.d(ed).toString());
    });
    public static final String ej = "obunga";
    public static final DeferredHolder<EntityType<?>, EntityType<mX>> kG = f.register(ej, () -> {
        return EntityType.Builder.of(mX::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(64).clientTrackingRange(8).build(C0265jv.d(ej).toString());
    });
    public static final String ek = "michael";
    public static final DeferredHolder<EntityType<?>, EntityType<mV>> kH = f.register(ek, () -> {
        return EntityType.Builder.of(mV::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).build(C0265jv.d(ek).toString());
    });
    public static final String el = "panzerknacker";
    public static final DeferredHolder<EntityType<?>, EntityType<mU>> kI = f.register(el, () -> {
        return EntityType.Builder.of(mU::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).build(C0265jv.d(el).toString());
    });
    public static final String dJ = "grenade_frag";
    public static final DeferredHolder<EntityType<?>, EntityType<C0371nt>> kJ = f.register(dJ, () -> {
        return EntityType.Builder.of(C0371nt::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dJ).toString());
    });
    public static final String dK = "grenade_flash";
    public static final DeferredHolder<EntityType<?>, EntityType<C0370ns>> kK = f.register(dK, () -> {
        return EntityType.Builder.of(C0370ns::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dK).toString());
    });
    public static final String dL = "grenade_smoke";
    public static final DeferredHolder<EntityType<?>, EntityType<C0374nw>> kL = f.register(dL, () -> {
        return EntityType.Builder.of(C0374nw::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dL).toString());
    });
    public static final String dM = "grenade_fire";
    public static final DeferredHolder<EntityType<?>, EntityType<C0369nr>> kM = f.register(dM, () -> {
        return EntityType.Builder.of(C0369nr::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dM).toString());
    });
    public static final String dN = "grenade_molotov";
    public static final DeferredHolder<EntityType<?>, EntityType<C0373nv>> kN = f.register(dN, () -> {
        return EntityType.Builder.of(C0373nv::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dN).toString());
    });
    public static final String dO = "grenade_decoy";
    public static final DeferredHolder<EntityType<?>, EntityType<C0368nq>> kO = f.register(dO, () -> {
        return EntityType.Builder.of(C0368nq::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dO).toString());
    });
    public static final String dP = "grenade_holy";
    public static final DeferredHolder<EntityType<?>, EntityType<C0372nu>> kP = f.register(dP, () -> {
        return EntityType.Builder.of(C0372nu::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dP).toString());
    });
    public static final String dQ = "medical_bag";
    public static final DeferredHolder<EntityType<?>, EntityType<C0366no>> kQ = f.register(dQ, () -> {
        return EntityType.Builder.of(C0366no::new, MobCategory.MISC).sized(0.65f, 0.65f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dQ).toString());
    });
    public static final String dR = "ammo_box";
    public static final DeferredHolder<EntityType<?>, EntityType<C0361nj>> kR = f.register(dR, () -> {
        return EntityType.Builder.of(C0361nj::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dR).toString());
    });
    public static final String dS = "landmine";
    public static final DeferredHolder<EntityType<?>, EntityType<C0365nn>> kS = f.register(dS, () -> {
        return EntityType.Builder.of(C0365nn::new, MobCategory.MISC).sized(0.5f, 0.3f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dS).toString());
    });
    public static final String em = "acid_ball";
    public static final DeferredHolder<EntityType<?>, EntityType<C0360ni>> kT = f.register(em, () -> {
        return EntityType.Builder.of(C0360ni::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(10).clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(em).toString());
    });
    public static final String dV = "rocket";
    public static final DeferredHolder<EntityType<?>, EntityType<C0357nf>> kU = f.register(dV, () -> {
        return EntityType.Builder.of(C0357nf::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dV).toString());
    });
    public static final String dW = "tank_rocket";
    public static final DeferredHolder<EntityType<?>, EntityType<C0359nh>> kV = f.register(dW, () -> {
        return EntityType.Builder.of(C0359nh::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dW).toString());
    });
    public static final String eb = "melon_rocket";
    public static final DeferredHolder<EntityType<?>, EntityType<C0355nd>> kW = f.register(eb, () -> {
        return EntityType.Builder.of(C0355nd::new, MobCategory.MISC).sized(0.2f, 0.2f).clientTrackingRange(4).updateInterval(20).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(eb).toString());
    });
    public static final String dX = "airstrike_rocket";
    public static final DeferredHolder<EntityType<?>, EntityType<C0353nb>> kX = f.register(dX, () -> {
        return EntityType.Builder.of(C0353nb::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dX).toString());
    });
    public static final String dY = "precision_airstrike_rocket";
    public static final DeferredHolder<EntityType<?>, EntityType<C0356ne>> kY = f.register(dY, () -> {
        return EntityType.Builder.of(C0356ne::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dY).toString());
    });
    public static final String dZ = "smoke_strike_rocket";
    public static final DeferredHolder<EntityType<?>, EntityType<C0358ng>> kZ = f.register(dZ, () -> {
        return EntityType.Builder.of(C0358ng::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(dZ).toString());
    });
    public static final String ea = "anti_air_rocket";
    public static final DeferredHolder<EntityType<?>, EntityType<C0354nc>> la = f.register(ea, () -> {
        return EntityType.Builder.of(C0354nc::new, MobCategory.MISC).sized(0.4f, 0.4f).setTrackingRange(10).noSave().noSummon().clientTrackingRange(4).setUpdateInterval(2).build(C0265jv.d(ea).toString());
    });
    public static final String ec = "human";
    public static final DeferredHolder<EntityType<?>, EntityType<mC>> lb = f.register(ec, () -> {
        return EntityType.Builder.of(mC::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0265jv.d(ec).toString());
    });
    public static final String ee = "infected";
    public static final DeferredHolder<EntityType<?>, EntityType<mQ>> lc = f.register(ee, () -> {
        return EntityType.Builder.of(mQ::new, MobCategory.MISC).sized(0.6f, 1.8f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0265jv.d(ee).toString());
    });
    public static final String eg = "infected_dog";
    public static final DeferredHolder<EntityType<?>, EntityType<mR>> ld = f.register(eg, () -> {
        return EntityType.Builder.of(mR::new, MobCategory.MISC).sized(0.6f, 1.5f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0265jv.d(eg).toString());
    });
    public static final String eh = "infected_spitter";
    public static final DeferredHolder<EntityType<?>, EntityType<mS>> le = f.register(eh, () -> {
        return EntityType.Builder.of(mS::new, MobCategory.MISC).sized(0.6f, 1.5f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0265jv.d(eh).toString());
    });
    public static final String ei = "infected_stalker";
    public static final DeferredHolder<EntityType<?>, EntityType<mT>> lf = f.register(ei, () -> {
        return EntityType.Builder.of(mT::new, MobCategory.MISC).sized(0.6f, 1.5f).setTrackingRange(64).clientTrackingRange(8).setUpdateInterval(2).build(C0265jv.d(ei).toString());
    });
    public static final String eo = "sherman_tank";
    public static final DeferredHolder<EntityType<?>, EntityType<C0379oa>> lg = f.register(eo, () -> {
        return EntityType.Builder.of(C0379oa::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(eo).toString());
    });
    public static final String eC = "renault_ft_tank";
    public static final DeferredHolder<EntityType<?>, EntityType<nZ>> lh = f.register(eC, () -> {
        return EntityType.Builder.of(nZ::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(eC).toString());
    });
    public static final String ep = "renault_ahn";
    public static final DeferredHolder<EntityType<?>, EntityType<nY>> li = f.register(ep, () -> {
        return EntityType.Builder.of(nY::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(ep).toString());
    });
    public static final String eq = "citroen_11cv_traction_avant";
    public static final DeferredHolder<EntityType<?>, EntityType<nR>> lj = f.register(eq, () -> {
        return EntityType.Builder.of(nR::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(eq).toString());
    });
    public static final String er = "tiger_ausf_h_tank";
    public static final DeferredHolder<EntityType<?>, EntityType<C0381oc>> lk = f.register(er, () -> {
        return EntityType.Builder.of(C0381oc::new, MobCategory.MISC).sized(2.75f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(eo).toString());
    });
    public static final String es = "t34_tank";
    public static final DeferredHolder<EntityType<?>, EntityType<C0380ob>> ll = f.register(es, () -> {
        return EntityType.Builder.of(C0380ob::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(es).toString());
    });
    public static final String et = "chiha_tank";
    public static final DeferredHolder<EntityType<?>, EntityType<nQ>> lm = f.register(et, () -> {
        return EntityType.Builder.of(nQ::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(et).toString());
    });
    public static final String eu = "lancia_1zm_car";
    public static final DeferredHolder<EntityType<?>, EntityType<nV>> ln = f.register(eu, () -> {
        return EntityType.Builder.of(nV::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(eu).toString());
    });
    public static final String ev = "flak88_gun";
    public static final DeferredHolder<EntityType<?>, EntityType<nT>> lo = f.register(ev, () -> {
        return EntityType.Builder.of(nT::new, MobCategory.MISC).sized(1.25f, 1.0f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(ev).toString());
    });
    public static final String ew = "flak38_gun";
    public static final DeferredHolder<EntityType<?>, EntityType<nS>> lp = f.register(ew, () -> {
        return EntityType.Builder.of(nS::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(ew).toString());
    });
    public static final String ex = "type96_gun";
    public static final DeferredHolder<EntityType<?>, EntityType<C0382od>> lq = f.register(ex, () -> {
        return EntityType.Builder.of(C0382od::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(ex).toString());
    });
    public static final String ey = "panzeriv_tank";
    public static final DeferredHolder<EntityType<?>, EntityType<nW>> lr = f.register(ey, () -> {
        return EntityType.Builder.of(nW::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(ey).toString());
    });
    public static final String ez = "7tp_pelican_tank";
    public static final DeferredHolder<EntityType<?>, EntityType<nX>> ls = f.register(ez, () -> {
        return EntityType.Builder.of(nX::new, MobCategory.MISC).sized(2.5f, 2.5f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(eo).toString());
    });
    public static final String eA = "willys_jeep_car";
    public static final DeferredHolder<EntityType<?>, EntityType<C0383oe>> lt = f.register(eA, () -> {
        return EntityType.Builder.of(C0383oe::new, MobCategory.MISC).sized(2.0f, 1.25f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(eA).toString());
    });
    public static final String eB = "kubelwagen_car";
    public static final DeferredHolder<EntityType<?>, EntityType<nU>> lu = f.register(eB, () -> {
        return EntityType.Builder.of(nU::new, MobCategory.MISC).sized(2.0f, 1.25f).setUpdateInterval(1).clientTrackingRange(10).build(C0265jv.d(eB).toString());
    });
}
