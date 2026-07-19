package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import com.boehmod.bflib.cloud.common.player.challenge.GunType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.uH;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wY.class */
public class wY {
    private static final float oo = 0.025f;
    private static final float op = 0.05f;
    private static final float oq = 0.1f;
    private static final float or = 0.15f;
    private static final float os = 0.2f;
    private static final float ot = 0.25f;
    private static final float ou = 0.3f;
    private static final float ov = 0.35f;
    private static final float ow = 0.4f;
    private static final float ox = 0.5f;
    private static final int tt = 64;
    private static final int tu = 14;
    private static final int tv = 22;
    private static final int tw = 4;
    private static final int tx = 30;
    private static final int ty = 10;
    private static final int tz = 2;
    private static final int tA = 4;
    private static final int tB = 5;
    private static final float oy = 0.5f;
    private static final float oz = 2.5f;
    private static final float oA = 3.0f;

    @NotNull
    private static final uV b = uV.a(C0265jv.d("shotgun_14_pellet"));

    @NotNull
    public static final DeferredRegister.Items a = DeferredRegister.createItems("bf");

    @NotNull
    public static final Object2ObjectMap<String, tK> f = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final DeferredItem<? extends Item> f393b = a.registerItem("booster_item_emeralds_x2", properties -> {
        return new tJ("booster_item_emeralds_x2", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> c = a.registerItem("booster_item_emeralds_x3", properties -> {
        return new tJ("booster_item_emeralds_x3", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> d = a.registerItem("booster_item_emeralds_x4", properties -> {
        return new tJ("booster_item_emeralds_x4", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> e = a.registerItem("booster_item_emeralds_x5", properties -> {
        return new tJ("booster_item_emeralds_x5", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final DeferredItem<? extends Item> f394f = a.registerItem("booster_item_exp_x2", properties -> {
        return new tJ("booster_item_exp_x2", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> g = a.registerItem("booster_item_exp_x3", properties -> {
        return new tJ("booster_item_exp_x3", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> h = a.registerItem("booster_item_exp_x4", properties -> {
        return new tJ("booster_item_exp_x4", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> i = a.registerItem("booster_item_exp_x5", properties -> {
        return new tJ("booster_item_exp_x5", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> j = a.registerItem("case_item_common", properties -> {
        return new tJ("case_item_common", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> k = a.registerItem("key_item_common", properties -> {
        return new tJ("key_item_common", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> l = a.registerItem("gui_logo", properties -> {
        return new C0535tv("gui_logo", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> m = a.registerItem("bomb_defuse_kit", properties -> {
        return new tT("bomb_defuse_kit", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> n = a.registerItem(wX.dT, properties -> {
        return new tU(wX.dT, properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> o = a.registerItem("radio", properties -> {
        return new C0543uc("radio", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> p = a.registerItem("medic_bag", properties -> {
        return new tZ("medic_bag", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> q = a.registerItem(wX.dR, properties -> {
        return new tR(wX.dR, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> r = a.registerItem("medical_syringe", properties -> {
        return new C0541ua("medical_syringe", properties);
    }, new Item.Properties().stacksTo(8).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> s = a.registerItem("adrenaline_syringe", properties -> {
        return new tQ("adrenaline_syringe", properties);
    }, new Item.Properties().stacksTo(8).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> t = a.registerItem(wX.dS, properties -> {
        return new tX(wX.dS, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> u = a.registerItem(wX.em, properties -> {
        return new C0533tt(wX.em, properties);
    }, new Item.Properties().stacksTo(16).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> v = a.registerItem("magnifying_glass", properties -> {
        return new tY("magnifying_glass", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> w = a.registerItem("super_happy_fun_bomb", properties -> {
        return new C0545ue("super_happy_fun_bomb", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> x = a.registerItem("randomat", properties -> {
        return new C0544ud("randomat", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> y = a.registerItem("binoculars", C0534tu::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> z = a.registerItem("map_effect_wand", tH::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> A = a.registerItem("map_effect_creator_wand", tF::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> B = a.registerItem("map_effect_rotation_wand", tG::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> C = a.registerItem("region_wand", tN::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> D = a.registerItem("event_trophy_gold", properties -> {
        return new tJ("event_trophy_gold", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> E = a.registerItem("event_trophy_silver", properties -> {
        return new tJ("event_trophy_silver", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> F = a.registerItem("event_trophy_bronze", properties -> {
        return new tJ("event_trophy_bronze", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> G = a.registerItem("prestige_card_1", properties -> {
        return new tJ("prestige_card_1", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> H = a.registerItem("prestige_card_2", properties -> {
        return new tJ("prestige_card_2", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> I = a.registerItem("prestige_card_3", properties -> {
        return new tJ("prestige_card_3", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> J = a.registerItem("prestige_card_4", properties -> {
        return new tJ("prestige_card_4", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> K = a.registerItem("prestige_card_5", properties -> {
        return new tJ("prestige_card_5", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> L = a.registerItem("prestige_card_6", properties -> {
        return new tJ("prestige_card_6", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> M = a.registerItem("flag_item_japan", properties -> {
        return new tV("flag_item_japan", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> N = a.registerItem("flag_item_ussr", properties -> {
        return new tV("flag_item_ussr", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends C0560ut> O = a.registerItem("chest_flammenwerfer_34", properties -> {
        return new C0560ut("chest_flammenwerfer_34", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, true).a(C0624xc.tA, true);
    });
    public static final DeferredItem<? extends C0560ut> P = a.registerItem("chest_m2_flamethrower", properties -> {
        return new C0560ut("chest_m2_flamethrower", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, true).a(C0624xc.tA, true);
    });
    public static final DeferredItem<? extends C0560ut> Q = a.registerItem("chest_us_commander", properties -> {
        return new C0560ut("chest_us_commander", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, false).a(C0624xc.tC, false);
    });
    public static final DeferredItem<? extends C0560ut> R = a.registerItem("chest_us_support", properties -> {
        return new C0560ut("chest_us_support", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, false);
    });
    public static final DeferredItem<? extends Item> S = a.registerItem("grenade_flashbang", properties -> {
        return new C0549ui("grenade_flashbang", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> T = a.registerItem(wX.dO, properties -> {
        return new C0547ug(wX.dO, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> U = a.registerItem(wX.dL, properties -> {
        return new C0553um(wX.dL, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> V = a.registerItem("grenade_smoke_stielhandgranate", properties -> {
        return new C0553um("grenade_smoke_stielhandgranate", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> W = a.registerItem(wX.dM, properties -> {
        return new C0548uh(wX.dM, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> X = a.registerItem("grenade_frag_mk2", properties -> {
        return new C0550uj("grenade_frag_mk2", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> Y = a.registerItem("grenade_frag_rgd33", properties -> {
        return new C0550uj("grenade_frag_rgd33", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> Z = a.registerItem("grenade_smoke_rgd2", properties -> {
        return new C0553um("grenade_smoke_rgd2", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> aa = a.registerItem("grenade_frag_wz24", properties -> {
        return new C0550uj("grenade_frag_wz24", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ab = a.registerItem("grenade_frag_type97", properties -> {
        return new C0550uj("grenade_frag_type97", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ac = a.registerItem("grenade_smoke_type94", properties -> {
        return new C0553um("grenade_smoke_type94", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ad = a.registerItem("grenade_frag_stielhandgranate", properties -> {
        return new C0550uj("grenade_frag_stielhandgranate", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ae = a.registerItem(wX.dP, properties -> {
        return new C0551uk(wX.dP, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> af = a.registerItem("grenade_frag_srcm_mod_35", properties -> {
        return new C0550uj("grenade_frag_srcm_mod_35", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ag = a.registerItem("grenade_smoke_breda_mod_42", properties -> {
        return new C0553um("grenade_smoke_breda_mod_42", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ah = a.registerItem("grenade_frag_f1", properties -> {
        return new C0550uj("grenade_frag_f1", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ai = a.registerItem("grenade_smoke_fumigene_mle_1916", properties -> {
        return new C0553um("grenade_smoke_fumigene_mle_1916", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> aj = a.registerItem("grenade_frag_millsbomb", properties -> {
        return new C0550uj("grenade_frag_millsbomb", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ak = a.registerItem(wX.dN, properties -> {
        return new C0552ul(wX.dN, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> al = a.registerItem("grenade_smoke_no77", properties -> {
        return new C0553um("grenade_smoke_no77", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> am = a.registerItem("grenade_at_et_wz_38", properties -> {
        return new C0550uj("grenade_at_et_wz_38", properties).a(1.0f).b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> an = a.registerItem("grenade_at_hafthohlladung", properties -> {
        return new C0550uj("grenade_at_hafthohlladung", properties).a(1.0f).b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ao = a.registerItem("grenade_at_no82_gammon_bomb", properties -> {
        return new C0550uj("grenade_at_no82_gammon_bomb", properties).a(1.0f).b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ap = a.registerItem("grenade_at_rpg_43", properties -> {
        return new C0550uj("grenade_at_rpg_43", properties).a(1.0f).b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> aq = a.registerItem("grenade_at_type_3", properties -> {
        return new C0550uj("grenade_at_type_3", properties).a(1.0f).b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ar = a.registerItem("grenade_at_type_l", properties -> {
        return new C0550uj("grenade_at_type_l", properties).a(1.0f).b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> as = a.registerItem("melee_item_knife_m1905", properties -> {
        return new tI("melee_item_knife_m1905", properties).a(1);
    });
    public static final DeferredItem<? extends Item> at = a.registerItem("melee_item_klappspaten", properties -> {
        return new tI("melee_item_klappspaten", properties).a(C0624xc.Cy).a(hH.E).a(0.05f);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> au = a.registerItem("melee_item_sword_shin_gunto", properties -> {
        return new tI("melee_item_sword_shin_gunto", properties).a(C0624xc.Cz).a(hH.F);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> av = a.registerItem("melee_item_knife_m1938", properties -> {
        return new tI("melee_item_knife_m1938", properties).a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> aw = a.registerItem("melee_item_knife_wz_27", properties -> {
        return new tI("melee_item_knife_wz_27", properties).a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ax = a.registerItem("melee_item_knife_m1940", properties -> {
        return new tI("melee_item_knife_m1940", properties).a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> ay = a.registerItem("melee_item_knife_m1886", properties -> {
        return new tI("melee_item_knife_m1886", properties).a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> az = a.registerItem("melee_item_knife_fairbairn_sykes", properties -> {
        return new tI("melee_item_knife_fairbairn_sykes", properties).a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> aA = a.registerItem("melee_item_knife_type30", properties -> {
        return new tI("melee_item_knife_type30", properties).a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredItem<? extends Item> aB = a.registerItem("melee_item_wrench", properties -> {
        return new tI("melee_item_wrench", properties).a(C0624xc.CA).a(hH.G).a(0.05f);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lv = a.registerItem("gun_tokarev_avt40", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_tokarev_avt40", properties).a(20, 60).a(uJ.gw).a(uR.b.clone().a(C0624xc.zO).b(C0624xc.zP).g(C0624xc.va).h(C0624xc.ve).b(C0624xc.wv, C0624xc.ww).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).d(C0624xc.CJ)).a(hH.e).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.6f, "scope_tokarev_avt40", false).a(0.5f)).a(tE.fU)).a(new uQ(2.75f, 2.75f)).a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lw = a.registerItem("gun_tokarev_svt40", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_tokarev_svt40", properties).a(10, 30).a(uJ.gu).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.zO).b(C0624xc.zP).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wv, C0624xc.ww).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).d(C0624xc.CJ)).a(hH.d).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.6f, "scope_tokarev_avt40", false).a(0.5f)).a(tE.fU)).a(new uQ(2.75f, 2.75f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lx = a.registerItem("gun_type92", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_type92", properties).a(16, 192).a(uJ.gC).a(uL.c).a(uN.c).a(uR.b.clone().a(C0624xc.Aj).b(C0624xc.wx, C0624xc.wy).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).h(C0624xc.vh).b(C0624xc.Ak).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.zA, true).n(C0624xc.vu).d(C0624xc.CL).a(0.95f)).d(0.5f).b(0.35f).m1225a(GunType.MG).b(0.15f)).a(C0537tx.e).a(2.5f).a(EnumC0561uu.NO_BIPOD_ONLY).a(uH.a.DEFAULT, new uH()).a(tE.fX)).b("mg").a(C0624xc.Al).a(new Vector3f(0.4f, 0.0f, 0.0f)).a(new uQ(6.0f)).a(new uS[]{new uS(uT.AUTO, 5), new uS(uT.SEMI, 5)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> ly = a.registerItem("gun_welrod", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_welrod", properties).a(8, 24).a(uJ.gs).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.BW).b(C0624xc.BY).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(C0624xc.BX, true).a(1.2f)).d(0.5f).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(C0624xc.BZ).c(false).a(new uQ(3.75f)).a(new uS[]{new uS(uT.SEMI, 32)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lz = a.registerItem("gun_brownbess", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_brownbess", properties).a(1, 16).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.Cd).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wF, C0624xc.wG).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).b(null).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw).a(C0624xc.Ce, true)).a(hH.c).a(ColorReferences.COLOR_WHITE_SOLID, -1.0f).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(tE.fS)).a(new uQ(8.4f, 8.4f)).f().a(new uS[]{new uS(uT.SEMI, 40)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lA = a.registerItem("gun_browning30", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_browning30", properties).a(150, 600).a(uJ.gB).a(uL.c).a(uN.c).a(uR.b.clone().a(C0624xc.yn).b(C0624xc.wx, C0624xc.wy).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).b(C0624xc.yo).g(C0624xc.uT).h(C0624xc.vh).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.zA, true).n(C0624xc.vu).d(C0624xc.CL).o(C0624xc.vq).a(0.95f)).d(1.0f).b(0.35f).m1225a(GunType.MG).b(0.15f)).a(C0537tx.e).a(2.5f).a(EnumC0561uu.NO_BIPOD_ONLY).a(uH.a.DEFAULT, new uH()).a(tE.fX)).b("mg").a(new uQ(10.0f)).a(0.35f)).a(new Vector3f(), true).g().a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lB = a.registerItem("gun_mg42", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_mg42", properties).a(250, 250).a(uJ.gB).a(uL.c).a(uN.c).a(uR.b.clone().a(C0624xc.zd).b(C0624xc.wj, C0624xc.wk).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).b(C0624xc.ze).g(C0624xc.uV).h(C0624xc.vh).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.zf, true).n(C0624xc.vu).d(C0624xc.CL).o(C0624xc.vt).a(C0624xc.um, C0624xc.un, 0.4f)).d(0.75f).b(0.35f).m1225a(GunType.MG).b(0.15f)).a(C0537tx.f).a(2.5f).a(EnumC0561uu.NO_BIPOD_ONLY).a(uH.a.DEFAULT, new uH()).a(tE.fY)).b("mg").a(0.7f)).a(new uQ(7.7f)).g().a(new uS[]{new uS(uT.AUTO, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lC = a.registerItem("gun_vickers_k", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_vickers_k", properties).a(100, 300).a(uJ.gB).a(uL.c).a(uN.c).a(uR.b.clone().a(C0624xc.AR).b(C0624xc.wx, C0624xc.wy).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).h(C0624xc.vh).b(C0624xc.AS).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.zf, true).n(C0624xc.vu).d(C0624xc.CL).o(C0624xc.vq).a(0.95f)).b(0.35f).m1225a(GunType.MG).b(0.15f)).a(C0537tx.e).a(2.5f).a(EnumC0561uu.NO_BIPOD_ONLY).a(0.4f)).a(uH.a.DEFAULT, new uH()).a(tE.fX)).b("mg").a(new uQ(4.1667f)).g().a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lD = a.registerItem("gun_fiat_revelli", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_fiat_revelli", properties).a(150, 300).a(uJ.gB).a(uL.c).a(uN.c).a(uR.b.clone().a(C0624xc.Bd).b(C0624xc.wx, C0624xc.wy).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).h(C0624xc.vh).b(C0624xc.yo).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.zA, true).n(C0624xc.vu).d(C0624xc.CL).o(C0624xc.vq).a(0.95f)).b(0.35f).m1225a(GunType.MG).b(0.15f)).a(C0537tx.e).a(2.5f).a(EnumC0561uu.NO_BIPOD_ONLY).a(uH.a.DEFAULT, new uH()).a(tE.fX)).b("smg").a(new uQ(3.9f)).a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lE = a.registerItem("gun_mac_mle_1931", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_mac_mle_1931", properties).a(150, 300).a(uJ.gB).a(uL.c).a(uN.c).a(uR.b.clone().a(C0624xc.Bm).b(C0624xc.wx, C0624xc.wy).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).h(C0624xc.vh).b(C0624xc.Bn).a(C0624xc.Bo, true).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).n(C0624xc.vu).d(C0624xc.CL).o(C0624xc.vq).a(0.95f)).b(0.35f).m1225a(GunType.MG).b(0.15f)).a(C0537tx.e).a(2.5f).a(EnumC0561uu.NO_BIPOD_ONLY).a(uH.a.DEFAULT, new uH()).a(tE.fX)).a(new uQ(6.3f)).b("mg").a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lF = a.registerItem("gun_lewisgun", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_lewisgun", properties).a(97, Token.SQSTRING).a(uJ.gB).a(uL.c).a(uN.c).a(uR.b.clone().a(C0624xc.BU).b(C0624xc.wS, C0624xc.wT).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).h(C0624xc.vh).b(C0624xc.BV).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.zf, true).n(C0624xc.vu).d(C0624xc.CL).o(C0624xc.vq).a(0.95f)).b(0.35f).m1225a(GunType.MG).b(0.15f)).a(C0537tx.e).a(2.5f).a(EnumC0561uu.NO_BIPOD_ONLY).a(uH.a.DEFAULT, new uH()).a(tE.fX)).b("mg").g().a(new uQ(7.0f)).a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lG = a.registerItem("gun_bar", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_bar", properties).a(20, 60).a(uJ.gz).a(uR.b.clone().a(C0624xc.yi).a(C0624xc.yl, true).a(C0624xc.yj, C0624xc.yk).g(C0624xc.uS).h(C0624xc.vc).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CK).o(C0624xc.vs).a(0.95f)).d(0.75f).a(0.5f)).b(0.25f).m1225a(GunType.LMG).b(0.2f)).a(C0537tx.g).a(uH.a.DEFAULT, new uH()).a(tE.fW)).b("mg").a(new uQ(3.5f, 5.25f)).g().a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lH = a.registerItem("gun_dp28", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_dp28", properties).a(47, 141).a(uJ.gz).a(uR.b.clone().a(C0624xc.zq).b(C0624xc.zr).g(C0624xc.uS).h(C0624xc.vc).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.yU, true).o(C0624xc.vs).a(0.95f)).d(1.0f).a(new uQ(4.0f)).b(0.25f).m1225a(GunType.LMG).b(0.2f)).a(C0537tx.g).a(0.5f)).g().a(uH.a.DEFAULT, new uH()).a(tE.fW)).b("mg").a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lI = a.registerItem("gun_mg34", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_mg34", properties).a(150, 300).a(uJ.gz).a(uL.c).a(uN.c).a(uR.b.clone().a(C0624xc.zy).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).b(C0624xc.zz).g(C0624xc.uU).h(C0624xc.vh).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.zA, true).d(C0624xc.CL).o(C0624xc.vs).a(0.9f)).a(C0624xc.zB).a(2.5f).a(EnumC0561uu.NO_BIPOD_ONLY).b(0.25f).m1225a(GunType.LMG).b(0.2f)).a(C0537tx.g).a(uH.a.DEFAULT, new uH()).a(tE.fW)).b("mg").a(new uQ(7.7f)).a(0.5f)).a(new Vector3f(), true).g().a(new uS[]{new uS(uT.AUTO, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lJ = a.registerItem("gun_zb26", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_zb26", properties).a(20, 60).d(0.5f).a(uJ.gz).a(uR.b.clone().a(C0624xc.zT).b(C0624xc.zU).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.As, true).d(C0624xc.CK).o(C0624xc.vs).a(0.95f)).b(0.25f).m1225a(GunType.LMG).b(0.2f)).a(C0537tx.g).a(uH.a.DEFAULT, new uH()).a(tE.fW)).b("mg").a(new uQ(5.75f)).a(0.4f)).g().a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lK = a.registerItem("gun_type11", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_type11", properties).a(30, 90).a(uJ.gz).a(uR.b.clone().a(C0624xc.Am).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).b(C0624xc.An).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CK).a(C0624xc.As, true).o(C0624xc.vs).a(0.95f)).d(0.75f).a(0.2f)).b(0.25f).m1225a(GunType.LMG).b(0.2f)).a(C0537tx.g).a(uH.a.DEFAULT, new uH()).a(tE.fW)).b("mg").a(new uQ(4.83f)).g().a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lL = a.registerItem("gun_bren_mk2", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_bren_mk2", properties).a(30, 90).a("pan", new C0559us(Component.translatable("bf.item.gun.mag.type.pan"), 100, 100)).a(uJ.gz).a(uR.b.clone().a(C0624xc.Ar).b(C0624xc.At).g(C0624xc.uS).h(C0624xc.ve).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.As, false).o(C0624xc.vs).k(C0624xc.vm).a(0.95f)).a(hH.e).b(0.25f).m1225a(GunType.LMG).b(0.2f)).a(C0537tx.g).a(uH.a.DEFAULT, new uH()).a(tE.fW)).a(0.35f)).b("mg").a(new uQ(4.5f)).g().a(new uS[]{new uS(uT.AUTO, 1), new uS(uT.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lM = a.registerItem("gun_model_1930", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_model_1930", properties).a(20, 60).a(uJ.gz).a(uR.b.clone().a(C0624xc.Ba).a(C0624xc.Bb, C0624xc.Bc).g(C0624xc.uT).h(C0624xc.vc).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CL).o(C0624xc.vs).a(0.95f)).d(0.5f).b(0.25f).m1225a(GunType.LMG).b(0.2f)).a(C0537tx.g).a(uH.a.DEFAULT, new uH()).a(tE.fW)).a(new uQ(4.7f)).a(0.4f)).g().a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lN = a.registerItem("gun_breda_safat", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_breda_safat", properties).a(150, 300).a(uJ.gB).a(uR.b.clone().a(C0624xc.yn).b(C0624xc.wx, C0624xc.wy).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).b(C0624xc.yo).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.zA, true).n(C0624xc.vu).o(C0624xc.vs).a(0.95f)).b(0.25f).m1225a(GunType.LMG).b(0.2f)).a(C0537tx.g).a(0.35f)).d(1.0f).a(uH.a.DEFAULT, new uH()).a(tE.fW)).a(new uQ(6.0f)).b("mg").a(new Vector3f(), true).g().a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lO = a.registerItem("gun_type96", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_type96", properties).a(30, 90).a(uJ.gz).a(uR.b.clone().a(C0624xc.Au).b(C0624xc.Aw).g(C0624xc.uS).h(C0624xc.vh).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).u(C0624xc.CD).v(C0624xc.CE).d(C0624xc.CK).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.Av, true).o(C0624xc.vs).a(0.95f)).b(0.25f).m1225a(GunType.LMG).b(0.2f)).a(C0537tx.g).a(uH.a.DEFAULT, new uH(true, 0.2f, "scope_kar98k", false)).a(tE.fW)).b("mg").a(C0624xc.Ax).a(new uQ(5.5f)).a(0.3f)).g().a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lP = a.registerItem("gun_type98", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_type98", properties).a(75, 150).a(uJ.gz).a(uL.c).a(uN.c).a(uR.b.clone().a(C0624xc.Ay).b(C0624xc.Az).g(C0624xc.uS).h(C0624xc.vh).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).u(C0624xc.CD).v(C0624xc.CE).d(C0624xc.CK).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).a(C0624xc.Av, true).o(C0624xc.vs).a(0.95f)).b(0.25f).m1225a(GunType.MG).b(0.15f)).a(C0537tx.g).a(tE.fW)).b("mg").a(C0624xc.Ax).a(new uQ(4.8f)).a(0.3f)).g().a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lQ = a.registerItem("gun_m1928a1_thompson", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_m1928a1_thompson", properties).a(20, 100).a("drum", new C0559us(Component.translatable("bf.item.gun.mag.type.drum"), 100, 100)).a(uJ.gx).a(uR.b.clone().a(C0624xc.ya).a(C0624xc.yd, true).b(C0624xc.wl, C0624xc.wm).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xC).b(C0624xc.yb).g(C0624xc.uS).h(C0624xc.vf).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.b).a(uH.a.DEFAULT, new uH()).a(tE.fV)).b("smg").a(new uQ(2.5f)).a(new uS[]{new uS(uT.AUTO, 1), new uS(uT.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lR = a.registerItem("gun_m1a1_thompson", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_m1a1_thompson", properties).a(30, C0163g.g).a(uJ.gw).a(uR.b.clone().a(C0624xc.ya).a(C0624xc.yd, true).g(C0624xc.va).b(C0624xc.wl, C0624xc.wm).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xC).b(C0624xc.yb).g(C0624xc.uS).h(C0624xc.vf).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(new uQ(2.5f)).a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static final uR f395c = uR.b.clone().a(C0624xc.ye).g(C0624xc.va).b(C0624xc.wd, C0624xc.we).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xC).b(C0624xc.yg).g(C0624xc.uS).h(C0624xc.vf).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB);

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private static final uR f396d = uR.b.clone().a(1.5f).a(C0624xc.yf).a(C0624xc.yh, true).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xC).b(C0624xc.yg).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(null).i(null).d(null, null).l(null).g(null).h(null);
    public static final DeferredHolder<Item, ? extends C0558ur> lS = a.registerItem("gun_greasegun", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_greasegun", properties).a(30, 90).a(uJ.gw).a(f395c).a("suppressor", new C0554un(Component.translatable("bf.item.gun.barrel.type.suppressor")).a(false).a(f396d)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(new uQ(3.0f)).a(0.75f)).d(0.65f).a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lT = a.registerItem("gun_mp40", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_mp40", properties).a(32, 96).a("double", new C0559us(Component.translatable("bf.item.gun.mag.type.doppel"), 64, 128)).a(uJ.gw).a(uR.b.clone().a(C0624xc.yR).b(C0624xc.wU, C0624xc.wV).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xC).a(C0624xc.yS, C0624xc.yT).g(C0624xc.uW).h(C0624xc.vf).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).a(C0624xc.yU, true).p(C0624xc.vB).k(C0624xc.vk)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(C0624xc.yV).a(new uQ(2.75f, 5.0f)).a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lU = a.registerItem("gun_stg44", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_stg44", properties).a(30, 90).a(uJ.gy).a(uR.b.clone().a(C0624xc.yX).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).a(C0624xc.yY, C0624xc.yZ).g(C0624xc.uZ).h(C0624xc.vc).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).a(C0624xc.yU, true).k(C0624xc.vl).a(0.95f)).a(C0624xc.za).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(new uQ(2.0f, 3.25f)).a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lV = a.registerItem("gun_blyskawica", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_blyskawica", properties).a(20, 60).a(uJ.gw).a(uR.b.clone().a(C0624xc.zn).b(C0624xc.wl, C0624xc.wm).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).g(C0624xc.va).h(C0624xc.vf).m(C0624xc.xC).a(C0624xc.zo, C0624xc.zp).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).a(new uQ(2.75f, 3.75f)).b("smg").a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lW = a.registerItem("gun_kop_pal", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_kop_pal", properties).a(32, 96).a(uJ.gw).a(uR.b.clone().a(C0624xc.zu).b(C0624xc.wl, C0624xc.wm).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).g(C0624xc.va).h(C0624xc.vf).m(C0624xc.xC).b(C0624xc.zv).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).a(new uQ(2.5f, 4.3f)).b("smg").a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    });
    public static final DeferredHolder<Item, ? extends C0558ur> lX = a.registerItem("gun_pps43", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_pps43", properties).a(35, 105).a(uJ.gw).a(uR.b.clone().a(C0624xc.zG).b(C0624xc.wh, C0624xc.wi).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).g(C0624xc.va).h(C0624xc.vf).m(C0624xc.xC).b(C0624xc.zH).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB)).a(C0624xc.zI).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(new uQ(3.0f)).a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lY = a.registerItem("gun_ppsh", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_ppsh", properties).a(35, 105).a("drum", new C0559us(Component.translatable("bf.item.gun.mag.type.drum"), 71, 142)).a(uJ.gx).a(uR.b.clone().a(C0624xc.zJ).b(C0624xc.wh, C0624xc.wi).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).h(C0624xc.vf).m(C0624xc.xC).b(C0624xc.zK).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.b).a(new uQ(3.0f)).d(0.8f).a(uH.a.DEFAULT, new uH()).a(tE.fV)).a(C0624xc.zL).b("smg").a(new uS[]{new uS(uT.AUTO, 1), new uS(uT.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> lZ = a.registerItem("gun_type100", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_type100", properties).a(30, 90).a(uJ.gw).a(uR.b.clone().a(C0624xc.Ao).b(C0624xc.wl, C0624xc.wm).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).g(C0624xc.va).h(C0624xc.vf).m(C0624xc.xC).a(C0624xc.Ap, C0624xc.Aq).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(new uQ(4.0f, 5.5f)).a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private static final uR f397e = uR.b.clone().a(C0624xc.AK, true, 1).a(C0624xc.AI).b(C0624xc.wf, C0624xc.wg).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).g(C0624xc.va).h(C0624xc.vf).m(C0624xc.xC).a(C0624xc.AJ, C0624xc.AL).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB);

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private static final uR f398f = uR.b.clone().a(1.5f).a(C0624xc.AM).a(C0624xc.AN, true).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xC).a(C0624xc.AJ, C0624xc.AL).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(null).i(null).d(null, null).l(null).g(null).h(null);
    public static final DeferredHolder<Item, ? extends C0558ur> ma = a.registerItem("gun_sten_mk2", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_sten_mk2", properties).a(32, 96).a("lanchester", new C0559us(Component.translatable("bf.item.gun.mag.type.lanchester"), 50, 100)).a("suppressor", new C0554un(Component.translatable("bf.item.gun.barrel.type.suppressor")).a(false).a(f398f)).a(uJ.gw).a(f397e).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(new uQ(2.5f, 4.375f)).a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mb = a.registerItem("gun_model_38", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_model_38", properties).a(30, 90).a("extended", new C0559us(Component.translatable("bf.item.gun.mag.type.extended"), 40, 80)).a(uJ.gw).a(uR.b.clone().a(C0624xc.AX, true, 1).a(C0624xc.AW).b(C0624xc.wl, C0624xc.wm).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).g(C0624xc.va).h(C0624xc.vf).m(C0624xc.xC).b(C0624xc.AY).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB)).a(C0624xc.AZ).d(0.7f).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(new uQ(3.7f)).a(new uS[]{new uS(uT.AUTO, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mc = a.registerItem("gun_mas_38", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_mas_38", properties).a(32, 96).a(uJ.gw).a(uR.b.clone().a(C0624xc.Br).b(C0624xc.wl, C0624xc.wm).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).g(C0624xc.va).h(C0624xc.vf).m(C0624xc.xA).b(C0624xc.Bs).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).a(C0624xc.Bt, true).p(C0624xc.vy).a(1.2f)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).a(new uQ(3.75f)).b("smg").a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> md = a.registerItem("gun_ak74", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_ak74", properties).a(30, 90).a(uJ.gw).a(uR.b.clone().a(C0624xc.BN).a(C0624xc.BO, true).b(C0624xc.wl, C0624xc.wm).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xC).a(C0624xc.BP, C0624xc.BQ).g(C0624xc.va).h(C0624xc.vf).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(new uQ(3.0f, 4.3f)).a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> me = a.registerItem("gun_m4a4", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_m4a4", properties).a(30, 90).a(uJ.gw).a(uR.b.clone().a(C0624xc.BR).a(C0624xc.BT, true).b(C0624xc.wl, C0624xc.wm).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xC).b(C0624xc.BS).g(C0624xc.va).h(C0624xc.vf).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(new uQ(3.4167f)).a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mf = a.registerItem("gun_fg42", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_fg42", properties).a(20, 60).a(uJ.gy).a(uR.b.clone().a(C0624xc.zb).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).b(C0624xc.zc).g(C0624xc.uZ).h(C0624xc.vc).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).a(C0624xc.yU, true).a(0.95f)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.6f, "scope_fg42", false).a(0.5f)).a(tE.fU)).b("smg").d(2.0f).g().a(new uQ(3.79f)).a(new uS[]{new uS(uT.AUTO, 3), new uS(uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mg = a.registerItem("gun_trenchgun", properties -> {
        return ((C0558ur) new C0558ur("gun_trenchgun", properties).a(6, 18).a(uJ.gD).e(64).a(uR.b.clone().a(C0624xc.yN).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wn, C0624xc.wo).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xj, C0624xc.xj, C0624xc.xj, C0624xc.xj, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vu).d(C0624xc.CN).a(0.95f)).a(hH.c).b(0.2f).m1225a(GunType.SHOTGUN).a(C0537tx.j).a(uH.a.DEFAULT, new uH()).a(tE.gb)).b("shell").a((DeferredHolder<SoundEvent, SoundEvent>) null).a(new uP(0.83f, 0.75f, 1.25f)).a(new uS[]{new uS(uT.SEMI, 18, tu).a(b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mh = a.registerItem("gun_m30", properties -> {
        return ((C0558ur) new C0558ur("gun_m30", properties).a(2, 20).a(uJ.gD).e(64).a(uR.b.clone().a(C0624xc.BL).a(C0624xc.BM, C0624xc.BM).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wn, C0624xc.wo).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xj, C0624xc.xj, C0624xc.xj, C0624xc.xj, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vu).d(C0624xc.CN).a(0.95f)).a(hH.c).b(0.2f).m1225a(GunType.SHOTGUN).a(C0537tx.j).a(uH.a.DEFAULT, new uH()).a(tE.gb)).b("shell").a(new uQ(3.8f, 3.8f)).a(new uS[]{new uS(uT.SEMI, 5, tu).a(b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mi = a.registerItem("gun_becker", properties -> {
        return ((C0558ur) new C0558ur("gun_becker", properties).a(5, 15).a(uJ.gD).e(64).a(uR.b.clone().a(C0624xc.BL).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wn, C0624xc.wo).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xj, C0624xc.xj, C0624xc.xj, C0624xc.xj, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vu).d(C0624xc.CN).a(0.95f)).a(hH.c).b(0.2f).m1225a(GunType.SHOTGUN).a(C0537tx.j).a(uH.a.DEFAULT, new uH()).a(tE.gb)).b("shell").a(new uP(1.5f, 1.65f, 0.5f)).a(new uS[]{new uS(uT.SEMI, 6, tu).a(b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mj = a.registerItem("gun_mauser_m712", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_mauser_m712", properties).a(20, 60).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.yH, true).a(C0624xc.yG).a(C0624xc.yI, C0624xc.yJ).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.i).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.l).d().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(2.4f, 3.12f)).a(new uS[]{new uS(uT.AUTO, 1), new uS(uT.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mk = a.registerItem("gun_springfield", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_springfield", properties).a(5, 15).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.ym).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wQ, C0624xc.wR).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw)).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_springfield", false).a(0.5f)).a((DeferredHolder<SoundEvent, SoundEvent>) null).a(tE.fS)).a(new uP(1.875f, 0.58f, 1.25f)).a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> ml = a.registerItem("gun_kar98k", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_kar98k", properties).a(5, 15).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.yK).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.xa, C0624xc.xb).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw)).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_kar98k", false).a(0.5f)).a(tE.fS)).a(new uP(1.875f, 0.4583f, 1.0f)).a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mm = a.registerItem("gun_kbk_wz_29", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_kbk_wz_29", properties).a(5, 15).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.zs).b(C0624xc.zt).q(C0624xc.xq).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.xa, C0624xc.xb).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw)).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_kar98k", false).a(0.5f)).a(tE.fS)).a(new uP(2.0f, 0.58f, 1.25f)).a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mn = a.registerItem("gun_mosin_nagant", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_mosin_nagant", properties).a(5, 15).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.zC).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.xc, C0624xc.xd).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw).k(C0624xc.vp)).a((DeferredHolder<SoundEvent, SoundEvent>) null).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_kar98k", false).a(0.5f)).a(tE.fS)).a(new uP(1.875f, 0.4583f, 1.0f)).a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mo = a.registerItem("gun_type38", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_type38", properties).a(5, 15).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.Ad).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wp, C0624xc.wq).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw)).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_type38", false).a(0.5f)).a(tE.fS)).a(new uP(1.875f, 0.4583f, 1.0f)).a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mp = a.registerItem("gun_type99", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_type99", properties).a(5, 15).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.Af).b(C0624xc.Ag).q(C0624xc.xq).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz)).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_type99", false)).a(tE.fS)).a(new uP(2.0f, 0.58f, 1.25f)).b("mg").a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mq = a.registerItem("gun_lee_enfield_mk1", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_lee_enfield_mk1", properties).a(10, 30).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.AA).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wO, C0624xc.wP).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw)).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_kar98k", false).a(0.5f)).a(tE.fS)).a(new uP(2.0f, 0.58f, 1.25f)).a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mr = a.registerItem("gun_carcano_m91ts_carbine", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_carcano_m91ts_carbine", properties).a(6, 18).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.AT).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wp, C0624xc.wq).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw)).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_carcano", false).a(0.5f)).a(tE.fS)).a((DeferredHolder<SoundEvent, SoundEvent>) null).a(new uP(2.0f, 0.58f, 1.25f)).a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> ms = a.registerItem("gun_carcano_m38", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_carcano_m38", properties).a(6, 18).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.AT).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wp, C0624xc.wq).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw)).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_carcano", false).a(0.5f)).a(tE.fS)).a((DeferredHolder<SoundEvent, SoundEvent>) null).a(new uP(2.0f, 0.58f, 1.25f)).a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mt = a.registerItem("gun_lebel_1886", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_lebel_1886", properties).a(10, 30).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.Bi).q(C0624xc.xq).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wp, C0624xc.wq).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw)).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_lebel_1886", false).a(0.5f)).a(tE.fS)).a(new uP(2.0f, 0.58f, 1.25f)).a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mu = a.registerItem("gun_m1_garand", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_m1_garand", properties).a(8, 24).a(uJ.gu).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.xT).a(C0624xc.xU, C0624xc.xV).d(C0624xc.xW).g(C0624xc.vb).h(C0624xc.ve).b(C0624xc.wY, C0624xc.wZ).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw).k(C0624xc.vo)).a(hH.d).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.d).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_m1_garand", false).a(0.5f)).a(tE.fT)).a(new uQ(5.0f, 3.75f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mv = a.registerItem("gun_m1_carbine", properties -> {
        return ((C0558ur) new C0558ur("gun_m1_carbine", properties).a(15, 60).a(uJ.gv).a(uR.b.clone().a(C0624xc.yp).b(C0624xc.yq).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xm).p(C0624xc.vy).d(C0624xc.CJ).b(C0624xc.wW, C0624xc.wX).m(C0624xc.xB).k(C0624xc.vn)).b(0.1f).m1225a(GunType.CARBINE).a(C0537tx.d).d().a(uH.a.DEFAULT, new uH()).a(tE.fT)).a(new uQ(4.75f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mw = a.registerItem("gun_m2_carbine", properties -> {
        return ((C0558ur) new C0558ur("gun_m2_carbine", properties).a(30, 90).a(uJ.gw).a(uR.b.clone().a(C0624xc.yp).a(C0624xc.yr, true).b(C0624xc.yq).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xm).p(C0624xc.vy).d(C0624xc.CJ).b(C0624xc.wW, C0624xc.wX).m(C0624xc.xB).k(C0624xc.vn)).b(0.05f).m1225a(GunType.CARBINE).a(C0537tx.a).d().a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_m1_garand", false).a(0.5f)).a(tE.fU)).a(new uQ(4.75f)).a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mx = a.registerItem("gun_gewehr_43", properties -> {
        return ((C0558ur) new C0558ur("gun_gewehr_43", properties).a(10, 30).a(uJ.gu).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.zh).a(C0624xc.zi, C0624xc.zj).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wv, C0624xc.ww).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vA).n(C0624xc.vw).d(C0624xc.CJ)).a(hH.d).b(0.1f).m1225a(GunType.CARBINE).a(C0537tx.d).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_gewehr_43", false).a(0.5f)).a(tE.fT)).a(new uQ(2.45f, 3.3f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> my = a.registerItem("gun_type4", properties -> {
        return ((C0558ur) new C0558ur("gun_type4", properties).a(10, 30).a(uJ.gu).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.Ah).b(C0624xc.Ai).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wp, C0624xc.wq).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw)).a(hH.d).b(0.1f).m1225a(GunType.CARBINE).a(C0537tx.d).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_m1_garand", false).a(0.5f)).a(tE.fT)).a(new uQ(3.7f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mz = a.registerItem("gun_lee_enfield_turner", properties -> {
        return ((C0558ur) new C0558ur("gun_lee_enfield_turner", properties).a(10, 30).a(uJ.gu).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.AA).b(C0624xc.wO, C0624xc.wP).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vA).n(C0624xc.vw).d(C0624xc.CJ)).a(hH.d).b(0.1f).m1225a(GunType.CARBINE).a(C0537tx.d).a(uH.a.DEFAULT, new uH()).a(tE.fT)).a(new uP(1.125f, 0.63f, 1.3333f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mA = a.registerItem("gun_model_1935", properties -> {
        return ((C0558ur) new C0558ur("gun_model_1935", properties).a(20, 60).a(uJ.gu).a(uR.b.clone().a(C0624xc.AU).b(C0624xc.wv, C0624xc.ww).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).h(C0624xc.vh).m(C0624xc.xB).b(C0624xc.AV).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).n(C0624xc.vv).d(C0624xc.CJ).o(C0624xc.vq).a(1.2f)).b(0.35f).m1225a(GunType.CARBINE).a(C0537tx.e).a(2.5f).a(EnumC0561uu.NO_BIPOD_ONLY).a(uH.a.DEFAULT, new uH()).a(tE.fX)).b("pistol").a(new uQ(4.3f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mB = a.registerItem("gun_fusil_1917", properties -> {
        return ((C0558ur) new C0558ur("gun_fusil_1917", properties).a(5, 30).a(uJ.gu).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.Bp).b(C0624xc.Bq).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wp, C0624xc.wq).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw)).a(hH.d).b(0.1f).m1225a(GunType.CARBINE).a(C0537tx.d).a(uH.a.DEFAULT, new uH()).a(tE.fT)).a(new uQ(5.0f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mC = a.registerItem("gun_howell", properties -> {
        return ((C0558ur) new C0558ur("gun_howell", properties).a(10, 30).a(uJ.gu).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.Cf).b(C0624xc.Cg).b(C0624xc.wO, C0624xc.wP).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vA).n(C0624xc.vw).d(C0624xc.CJ)).a(hH.d).b(0.1f).m1225a(GunType.CARBINE).a(C0537tx.d).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_kar98k", false).a(0.5f)).a(tE.fT)).a(new uQ(7.8f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mD = a.registerItem("gun_ptrs", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_ptrs", properties).a(5, 5).a(uJ.gA).a(uR.b.clone().a(C0624xc.zM).a(C0624xc.Bw, true).b(C0624xc.zN).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wr, C0624xc.ws).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vu).d(C0624xc.CL).x(C0624xc.uG).a(0.95f)).b(false).a(hH.h).b(0.4f).m1225a(GunType.AT).b(0.1f)).a(C0537tx.i).d(2.5f).a(0.3f)).a(new uQ(6.0f)).a(uH.a.DEFAULT, new uH()).a(tE.ga)).g().a(new uS[]{new uS(uT.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mE = a.registerItem("gun_batr", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_batr", properties).a(5, 5).a(0.3f)).g().a(uJ.gA).a(uR.b.clone().a(C0624xc.Bu).a(C0624xc.Bw, true).b(C0624xc.Bv).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wr, C0624xc.ws).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vu).x(C0624xc.uG).a(0.95f)).b(false).a(hH.h).b(0.4f).m1225a(GunType.AT).b(0.1f)).a(C0537tx.i).a(uH.a.DEFAULT, new uH()).a(tE.ga)).a(new uQ(5.25f)).a(new uS[]{new uS(uT.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mF = a.registerItem("gun_panzerbuchse39", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_panzerbuchse39", properties).a(1, 10).a(0.2f)).d(2.0f).a(uJ.gA).a(uR.b.clone().a(C0624xc.Bx).a(C0624xc.Bz, true).b(C0624xc.By).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wr, C0624xc.ws).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vu).x(C0624xc.uG).a(0.95f)).b(false).a(hH.h).g().b(0.4f).m1225a(GunType.AT).b(0.1f)).a(C0537tx.i).a(uH.a.DEFAULT, new uH()).a(tE.ga)).a(new uQ(4.25f)).a(C0624xc.BA).a(new uS[]{new uS(uT.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mG = a.registerItem("gun_type26", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_type26", properties).a(6, 18).a(uJ.gr).a(uR.b.clone().a(C0624xc.Ab).e(C0624xc.vD).a(C0624xc.AD, true).b(C0624xc.Ac).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wM, C0624xc.wN).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).w(C0624xc.xH).a(1.2f)).a(hH.b).a(true).b(0.025f).m1225a(GunType.PISTOL).b(0.35f)).a(C0537tx.m).d().c().a(uH.a.DEFAULT, new uH()).a(tE.fR)).b("pistol").a(new uQ(4.45f)).a(new uS[]{new uS(uT.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mH = a.registerItem("gun_webley_mk6", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_webley_mk6", properties).a(6, 18).a(uJ.gr).a(uR.b.clone().a(C0624xc.AC).e(C0624xc.vD).a(C0624xc.AD, true, 1).b(C0624xc.AE).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wM, C0624xc.wN).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).w(C0624xc.xH).a(1.2f)).a(hH.b).a(true).b(0.025f).m1225a(GunType.PISTOL).b(0.35f)).a(C0537tx.m).a(hH.g).d().c().a(uH.a.DEFAULT, new uH()).a(tE.fR)).b("pistol").a(new uQ(4.45f)).a(new uS[]{new uS(uT.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mI = a.registerItem("gun_modele_1892_revolver", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_modele_1892_revolver", properties).a(6, 18).a(uJ.gr).a(uR.b.clone().a(C0624xc.BB).e(C0624xc.vD).a(C0624xc.BC, true).b(C0624xc.BD).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wM, C0624xc.wN).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).w(C0624xc.xH).a(1.2f)).a(hH.b).a(true).b(0.025f).m1225a(GunType.PISTOL).b(0.35f)).a(C0537tx.m).d().c().a(new uQ(6.5f)).a(uH.a.DEFAULT, new uH()).a(tE.fR)).b("pistol").a(new uS[]{new uS(uT.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mJ = a.registerItem("gun_m2_flamethrower", properties -> {
        C0558ur c0558urA = ((C0558ur) new C0558ur("gun_m2_flamethrower", properties).a(15200, 30400).g(dM.gZ).a(uJ.gp).a(uR.b.clone().a(false).a(C0624xc.BE).b(C0624xc.wx, C0624xc.wy).b(C0624xc.BF).a(C0624xc.BG, true).f(C0624xc.BH).u(C0624xc.CD).v(C0624xc.CE).n(C0624xc.vu).d(C0624xc.CL).d(C0624xc.BI)).a(P).b(false).b(0.3f).m1225a(GunType.FLAMETHROWER).a(uH.a.DEFAULT, new uH()).a(tE.gc)).f(4).d(false).e(false).a(hH.f).a(new uQ(3.5f));
        uT uTVar = uT.AUTO;
        DeferredHolder<EntityType<?>, EntityType<C0363nl>> deferredHolder = wX.kE;
        Objects.requireNonNull(deferredHolder);
        return c0558urA.a(new uS[]{new uS(uTVar, 2, (Supplier<EntityType<? extends InterfaceC0347mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mK = a.registerItem("gun_flammenwerfer_34", properties -> {
        C0558ur c0558urA = ((C0558ur) new C0558ur("gun_flammenwerfer_34", properties).a(15200, 30400).g(118).a(uJ.gp).a(uR.b.clone().a(false).a(C0624xc.BE).b(C0624xc.wx, C0624xc.wy).b(C0624xc.BF).a(C0624xc.BG, true).f(C0624xc.BH).u(C0624xc.CD).v(C0624xc.CE).n(C0624xc.vu).d(C0624xc.CL).d(C0624xc.BI)).a(O).b(false).b(0.3f).m1225a(GunType.FLAMETHROWER).a(uH.a.DEFAULT, new uH()).a(tE.gc)).f(4).d(false).e(false).a(hH.f).a(new uQ(3.5f));
        uT uTVar = uT.AUTO;
        DeferredHolder<EntityType<?>, EntityType<C0363nl>> deferredHolder = wX.kE;
        Objects.requireNonNull(deferredHolder);
        return c0558urA.a(new uS[]{new uS(uTVar, 2, (Supplier<EntityType<? extends InterfaceC0347mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mL = a.registerItem("gun_colt", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_colt", properties).a(7, 21).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.xK).a(C0624xc.xL, C0624xc.xM).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).d(0.5f).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(2.33f, 3.12f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mM = a.registerItem("gun_beretta_m1934", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_beretta_m1934", properties).a(7, 21).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.xN).a(C0624xc.xO, C0624xc.xP).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(2.33f, 3.12f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mN = a.registerItem("gun_fn_model_1910", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_fn_model_1910", properties).a(8, 24).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.xQ).a(C0624xc.xR, C0624xc.xS).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(2.33f, 3.12f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mO = a.registerItem("gun_walther_p38", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_walther_p38", properties).a(8, 24).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.yx).a(C0624xc.yy, C0624xc.yz).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(2.33f, 3.12f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mP = a.registerItem("gun_luger", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_luger", properties).a(8, 24).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.yA).a(C0624xc.yB, C0624xc.yC).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(4.0f, 3.5f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mQ = a.registerItem("gun_mauser_c96", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_mauser_c96", properties).a(10, 30).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.yD).a(C0624xc.yE, C0624xc.yF).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(5.0f, 4.7f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mR = a.registerItem("gun_tokarev_tt33", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_tokarev_tt33", properties).a(8, 24).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.zk).a(C0624xc.zl, C0624xc.zm).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(2.33f, 3.12f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mS = a.registerItem("gun_fb_vis", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_fb_vis", properties).a(8, 24).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.zQ).a(C0624xc.zR, C0624xc.zS).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(2.33f, 3.12f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mT = a.registerItem("gun_type14", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_type14", properties).a(6, 18).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.zV).a(C0624xc.zW, C0624xc.zX).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(2.33f, 3.12f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mU = a.registerItem("gun_type94", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_type94", properties).a(6, 18).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.zY).a(C0624xc.zZ, C0624xc.Aa).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(2.33f, 3.12f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mV = a.registerItem("gun_glisenti_model_1910", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_glisenti_model_1910", properties).a(7, 21).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.Bf).a(C0624xc.Bg, C0624xc.Bh).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).a(new uQ(2.33f, 3.12f)).b("pistol").a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mW = a.registerItem("gun_pistolet_automatique_modele_1935a", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_pistolet_automatique_modele_1935a", properties).a(8, 24).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.Bj).a(C0624xc.Bk, C0624xc.Bl).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(2.33f, 3.12f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mX = a.registerItem("gun_browning_hipower", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_browning_hipower", properties).a(13, 39).a(uJ.gq).a(uR.b.clone().w(C0624xc.xD).a(C0624xc.Ca).a(C0624xc.Cb, C0624xc.Cc).i(C0624xc.wJ).d(C0624xc.vP, C0624xc.vW).j(C0624xc.vX).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wD, C0624xc.wE).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).a(1.2f)).a(hH.b).b(0.025f).m1225a(GunType.PISTOL).b(0.4f)).a(C0537tx.k).d().c().a(uH.a.DEFAULT, new uH(0.3f, 0.4f)).a(tE.fQ)).b("pistol").a(new uQ(2.5f, 3.1f)).a(new uS[]{new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> mY = a.registerItem("gun_bazooka", properties -> {
        C0558ur c0558ur = (C0558ur) new C0558ur("gun_bazooka", properties).a(1, 4).a(uJ.gp).a(uR.b.clone().w(C0624xc.xF).a(C0624xc.yu).b(C0624xc.wB, C0624xc.wC).h(C0624xc.vg).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xo)).b(false).b(0.5f).m1225a(GunType.ROCKET).a(C0537tx.h).e().b().a(hH.f).a(uH.a.DEFAULT, new uH(true, 0.3f, 0.1f, false)).a(tE.fZ);
        uT uTVar = uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0357nf>> deferredHolder = wX.kU;
        Objects.requireNonNull(deferredHolder);
        return c0558ur.a(new uS[]{new uS(uTVar, 5, (Supplier<EntityType<? extends InterfaceC0347mw>>) deferredHolder::get)}).a(new uQ(3.5f));
    });
    public static final DeferredHolder<Item, ? extends C0558ur> mZ = a.registerItem("gun_panzerschreck", properties -> {
        C0558ur c0558urA = ((C0558ur) new C0558ur("gun_panzerschreck", properties).a(1, 4).a(uJ.gp).a(uR.b.clone().w(C0624xc.xF).a(C0624xc.zg).b(C0624xc.wB, C0624xc.wC).h(C0624xc.vg).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xo)).b(false).b(0.5f).m1225a(GunType.ROCKET).a(C0537tx.h).e().b().a(hH.f).a(uH.a.DEFAULT, new uH(true, 0.3f, 0.1f, false)).a(tE.fZ)).a(new uQ(3.5f));
        uT uTVar = uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0357nf>> deferredHolder = wX.kU;
        Objects.requireNonNull(deferredHolder);
        return c0558urA.a(new uS[]{new uS(uTVar, 5, (Supplier<EntityType<? extends InterfaceC0347mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> na = a.registerItem("gun_panzerfaust", properties -> {
        C0558ur c0558urA = ((C0558ur) new C0558ur("gun_panzerfaust", properties).a(1, 4).a(uJ.gp).a(uR.b.clone().w(C0624xc.xF).a(C0624xc.zE).b(C0624xc.zF).b(C0624xc.wB, C0624xc.wC).h(C0624xc.vg).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xo)).b(false).b(0.5f).m1225a(GunType.ROCKET).a(C0537tx.h).a(uH.a.DEFAULT, new uH()).a(tE.fZ)).e().b().a(hH.f).a(new Vector3f(), true).a(new uQ(2.75f)).a(uH.a.DEFAULT, new uH(true, 0.3f, 0.1f, false));
        uT uTVar = uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0357nf>> deferredHolder = wX.kU;
        Objects.requireNonNull(deferredHolder);
        return c0558urA.a(new uS[]{new uS(uTVar, 5, (Supplier<EntityType<? extends InterfaceC0347mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> nb = a.registerItem("gun_piat", properties -> {
        C0558ur c0558urA = ((C0558ur) new C0558ur("gun_piat", properties).a(1, 4).a(uJ.gp).a(uR.b.clone().a(C0624xc.xY).a(C0624xc.xZ, true).w(C0624xc.xF).b(C0624xc.wB, C0624xc.wC).h(C0624xc.vg).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xo)).b(false).b(0.5f).m1225a(GunType.ROCKET).a(C0537tx.h).e().b().a(hH.f).a(uH.a.DEFAULT, new uH(true, 0.3f, 0.1f, false)).a(tE.fZ)).a(new Vector3f(), true).a(new uQ(3.5f));
        uT uTVar = uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0357nf>> deferredHolder = wX.kU;
        Objects.requireNonNull(deferredHolder);
        return c0558urA.a(new uS[]{new uS(uTVar, 5, (Supplier<EntityType<? extends InterfaceC0347mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> nc = a.registerItem("gun_melon_cannon", properties -> {
        C0558ur c0558urA = ((C0558ur) new C0558ur("gun_melon_cannon", properties).a(1, 32).a(uJ.gp).a(uR.b.clone().w(C0624xc.xF).a(C0624xc.yw).b(C0624xc.yv).b(C0624xc.wt, C0624xc.wu).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xo)).b(false).b(0.5f).m1225a(GunType.ROCKET).a(C0537tx.h).e().c(false).d(false).e(false).a(hH.f).a(uH.a.DEFAULT, new uH()).a(tE.fZ)).a(new uQ(1.8333f));
        uT uTVar = uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0355nd>> deferredHolder = wX.kW;
        Objects.requireNonNull(deferredHolder);
        return c0558urA.a(new uS[]{new uS(uTVar, 5, (Supplier<EntityType<? extends InterfaceC0347mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> nd = a.registerItem("gun_kis", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_kis", properties).a(32, 96).a(uJ.gw).a(uR.b.clone().a(C0624xc.Ci).b(C0624xc.wl, C0624xc.wm).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).g(C0624xc.va).h(C0624xc.vf).m(C0624xc.xC).a(C0624xc.Cj, C0624xc.Ck).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(new uQ(2.5f, 4.375f)).a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> ne = a.registerItem("gun_mp_3008", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_mp_3008", properties).a(32, 96).a(uJ.gw).a(uR.b.clone().a(C0624xc.Cl).b(C0624xc.wl, C0624xc.wm).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).g(C0624xc.va).h(C0624xc.vf).m(C0624xc.xC).a(C0624xc.Cm, C0624xc.Cn).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).p(C0624xc.vB).k(C0624xc.vk)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(new uQ(2.5f, 4.375f)).a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> nf = a.registerItem("gun_winchester_1895", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_winchester_1895", properties).a(5, 20).a(uJ.gt).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.Co).b(C0624xc.Cp).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wp, C0624xc.wq).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw)).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(tE.fS)).a(new uQ(4.8f)).a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> ng = a.registerItem("gun_mp41", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_mp41", properties).a(32, 96).a(uJ.gw).a(uR.b.clone().a(C0624xc.yW).b(C0624xc.wU, C0624xc.wV).i(C0624xc.wL).d(C0624xc.vR, C0624xc.wa).m(C0624xc.xC).a(C0624xc.yS, C0624xc.yT).g(C0624xc.uW).h(C0624xc.vf).u(C0624xc.CH).v(C0624xc.CI).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).a(C0624xc.yU, true).p(C0624xc.vB).k(C0624xc.vk)).b(0.05f).m1225a(GunType.SMG).b(0.3f)).a(C0537tx.a).a(uH.a.DEFAULT, new uH()).a(tE.fU)).b("smg").a(C0624xc.yV).a(new uQ(2.75f, 5.0f)).a(new uS[]{new uS(uT.AUTO, 2), new uS(uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> nh = a.registerItem("gun_type18_shotgun", properties -> {
        return ((C0558ur) new C0558ur("gun_type18_shotgun", properties).a(1, 18).a(uJ.gD).e(64).a(uR.b.clone().w(C0624xc.xE).a(C0624xc.AA).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wn, C0624xc.wo).m(C0624xc.xB).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vw).a(C0624xc.AB, true)).a(hH.c).b(0.2f).m1225a(GunType.SHOTGUN).a(C0537tx.j).b("shell").a(uH.a.DEFAULT, new uH()).a(tE.gb)).a(new uP(2.0f, 0.58f, 1.25f)).a(new uS[]{new uS(uT.SEMI, tv, tu).a(b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> ni = a.registerItem("gun_de_lisle_carbine", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_de_lisle_carbine", properties).a(11, 33).a(uJ.gt).a(uR.b.clone().a(1.5f).a(C0624xc.AO).b(C0624xc.wD, C0624xc.wE).i(C0624xc.wK).d(C0624xc.vQ, C0624xc.vY).j(C0624xc.vZ).m(C0624xc.xB).b(C0624xc.AQ).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CJ).i(null).d(null, null).l(null).g(null).h(null)).c(false).a(hH.c).b(0.15f).m1225a(GunType.RIFLE).b(0.25f)).a(C0537tx.c).a(uH.a.DEFAULT, new uH()).a(uH.a.SCOPE, new uH(true, 0.8f, "scope_kar98k", false).a(0.5f)).a(tE.fS)).a(new uQ(3.75f)).a(new uS[]{new uS(uT.SEMI, tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> nj = a.registerItem("gun_browning_a5", properties -> {
        return ((C0558ur) new C0558ur("gun_browning_a5", properties).a(5, 15).a(uJ.gD).e(64).a(uR.b.clone().a(C0624xc.yN).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wn, C0624xc.wo).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xj, C0624xc.xj, C0624xc.xj, C0624xc.xj, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vu).d(C0624xc.CN).a(0.95f)).a(hH.c).b(0.2f).m1225a(GunType.SHOTGUN).a(C0537tx.j).a(uH.a.DEFAULT, new uH()).a(tE.gb)).b("shell").a(new uP(0.83f, 0.75f, 1.5f)).a(new uS[]{new uS(uT.SEMI, 6, tu).a(b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> nk = a.registerItem("gun_type4_70mm", properties -> {
        C0558ur c0558ur = (C0558ur) new C0558ur("gun_type4_70mm", properties).a(1, 4).a(uJ.gp).a(uR.b.clone().w(C0624xc.xF).a(C0624xc.yu).b(C0624xc.wB, C0624xc.wC).h(C0624xc.vg).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xo)).g().b(false).b(0.5f).m1225a(GunType.ROCKET).a(C0537tx.h).e().b().a(hH.f).a(uH.a.DEFAULT, new uH(true, 0.3f, 0.1f, false)).a(tE.fZ);
        uT uTVar = uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0357nf>> deferredHolder = wX.kU;
        Objects.requireNonNull(deferredHolder);
        return c0558ur.a(new uS[]{new uS(uTVar, 5, (Supplier<EntityType<? extends InterfaceC0347mw>>) deferredHolder::get)}).a(new uQ(3.5f));
    });
    public static final DeferredHolder<Item, ? extends C0558ur> nl = a.registerItem("gun_wz_35", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_wz_35", properties).a(4, 4).a(0.2f)).d(2.0f).a(uJ.gA).a(uR.b.clone().a(C0624xc.Cq).a(C0624xc.Cs, true).b(C0624xc.Cr).g(C0624xc.uY).h(C0624xc.ve).b(C0624xc.wr, C0624xc.ws).u(C0624xc.CF).v(C0624xc.CG).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).l(C0624xc.xn).p(C0624xc.vz).n(C0624xc.vu).x(C0624xc.uG).a(0.95f)).b(false).a(hH.h).g().b(0.4f).m1225a(GunType.AT).b(0.1f)).a(C0537tx.i).a(uH.a.DEFAULT, new uH()).a(tE.ga)).a(new uQ(4.25f)).a(new uS[]{new uS(uT.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> nm = a.registerItem("gun_flak38", properties -> {
        return ((C0558ur) ((C0558ur) ((C0558ur) new C0558ur("gun_flak38", properties).a(20, 60).a(uJ.gA).a(uR.b.clone().a(C0624xc.Ct).a(C0624xc.Cu, false, 1).a(C0624xc.yj, C0624xc.yk).g(C0624xc.uS).h(C0624xc.vc).b(C0624xc.wz, C0624xc.wA).i(C0624xc.wI).d(C0624xc.vO, C0624xc.vU).j(C0624xc.vV).u(C0624xc.CD).v(C0624xc.CE).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).d(C0624xc.CK).o(C0624xc.vs).a(0.95f)).a(new Vec3(1.0d, -0.30000001192092896d, -0.30000001192092896d), new Vec3(0.0d, -0.25d, 0.0d)).d(0.75f).a(0.5f)).b(0.25f).m1225a(GunType.LMG).b(0.2f)).a(C0537tx.g).a(uH.a.DEFAULT, new uH()).a(tE.fW)).b("mg").a(new uQ(3.5f, 5.25f)).g().a(new uS[]{new uS(uT.AUTO, 4), new uS(uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));
    public static final DeferredHolder<Item, ? extends C0558ur> nn = a.registerItem("gun_nagant_m1895", properties -> {
        return ((C0558ur) ((C0558ur) new C0558ur("gun_nagant_m1895", properties).a(7, 21).a(uJ.gr).a(uR.b.clone().a(C0624xc.AF).e(C0624xc.vD).a(C0624xc.AG, true, 1).b(C0624xc.AH).g(C0624xc.uX).h(C0624xc.vd).u(C0624xc.CB).v(C0624xc.CC).a(C0624xc.xe, C0624xc.xg, C0624xc.xh, C0624xc.xf, C0624xc.xi).b(C0624xc.wM, C0624xc.wN).m(C0624xc.xA).l(C0624xc.xm).n(C0624xc.vv).d(C0624xc.CM).w(C0624xc.xH).a(1.2f)).a(hH.b).a(true).b(0.025f).m1225a(GunType.PISTOL).b(0.35f)).a(C0537tx.m).a(hH.g).d().c().a(uH.a.DEFAULT, new uH()).a(tE.fR)).b("pistol").a(new uQ(11.1f)).a(new uS[]{new uS(uT.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, tK.a()));

    static {
        for (DeferredHolder deferredHolder : wL.b.getEntries()) {
            a.register(deferredHolder.getId().getPath(), () -> {
                return new BlockItem((Block) deferredHolder.get(), new Item.Properties());
            });
        }
        for (DeferredHolder deferredHolder2 : wL.c.getEntries()) {
            a.register(deferredHolder2.getId().getPath(), () -> {
                return new BlockItem((Block) deferredHolder2.get(), new Item.Properties());
            });
        }
    }

    @NotNull
    public static Optional<Item> a(@NotNull CloudResourceLocation cloudResourceLocation) {
        return a(ResourceLocation.fromNamespaceAndPath(cloudResourceLocation.namespace(), cloudResourceLocation.path()));
    }

    @NotNull
    public static Optional<Item> a(@NotNull ResourceLocation resourceLocation) {
        return BuiltInRegistries.ITEM.getOptional(resourceLocation);
    }
}
