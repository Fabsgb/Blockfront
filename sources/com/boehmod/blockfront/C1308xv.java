package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import com.boehmod.bflib.cloud.common.player.challenge.GunType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.cloud.connection.ModConnection;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.xv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xv.class */
public class C1308xv {

    /* JADX INFO: renamed from: pm */
    private static final float f7646pm = 0.025f;

    /* JADX INFO: renamed from: pn */
    private static final float f7647pn = 0.05f;

    /* JADX INFO: renamed from: po */
    private static final float f7648po = 0.1f;

    /* JADX INFO: renamed from: pp */
    private static final float f7649pp = 0.15f;

    /* JADX INFO: renamed from: pq */
    private static final float f7650pq = 0.2f;

    /* JADX INFO: renamed from: pr */
    private static final float f7651pr = 0.25f;

    /* JADX INFO: renamed from: ps */
    private static final float f7652ps = 0.3f;

    /* JADX INFO: renamed from: pt */
    private static final float f7653pt = 0.35f;

    /* JADX INFO: renamed from: pu */
    private static final float f7654pu = 0.4f;

    /* JADX INFO: renamed from: pv */
    private static final float f7655pv = 0.5f;

    /* JADX INFO: renamed from: vx */
    private static final int f7656vx = 64;

    /* JADX INFO: renamed from: vy */
    private static final int f7657vy = 14;

    /* JADX INFO: renamed from: vz */
    private static final int f7659vz = 22;

    /* JADX INFO: renamed from: vA */
    private static final int f7660vA = 4;

    /* JADX INFO: renamed from: vB */
    private static final int f7661vB = 30;

    /* JADX INFO: renamed from: vC */
    private static final int f7662vC = 10;

    /* JADX INFO: renamed from: vD */
    private static final int f7663vD = 2;

    /* JADX INFO: renamed from: vE */
    private static final int f7664vE = 4;

    /* JADX INFO: renamed from: vF */
    private static final int f7665vF = 5;

    /* JADX INFO: renamed from: pw */
    private static final float f7666pw = 0.5f;

    /* JADX INFO: renamed from: px */
    private static final float f7667px = 2.5f;

    /* JADX INFO: renamed from: py */
    private static final float f7793py = 3.0f;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final C1202vv f7658b = C1202vv.m6883a(C0532jO.m2378d("shotgun_14_pellet"));

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final DeferredRegister.Items f7668a = DeferredRegister.createItems("bf");

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final Object2ObjectMap<String, C1136ui> f7669f = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: b */
    public static final DeferredItem<? extends Item> f7670b = f7668a.registerItem("booster_item_emeralds_x2", properties -> {
        return new C1135uh("booster_item_emeralds_x2", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: c */
    public static final DeferredItem<? extends Item> f7671c = f7668a.registerItem("booster_item_emeralds_x3", properties -> {
        return new C1135uh("booster_item_emeralds_x3", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: d */
    public static final DeferredItem<? extends Item> f7672d = f7668a.registerItem("booster_item_emeralds_x4", properties -> {
        return new C1135uh("booster_item_emeralds_x4", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: e */
    public static final DeferredItem<? extends Item> f7673e = f7668a.registerItem("booster_item_emeralds_x5", properties -> {
        return new C1135uh("booster_item_emeralds_x5", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: f */
    public static final DeferredItem<? extends Item> f7674f = f7668a.registerItem("booster_item_exp_x2", properties -> {
        return new C1135uh("booster_item_exp_x2", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: g */
    public static final DeferredItem<? extends Item> f7675g = f7668a.registerItem("booster_item_exp_x3", properties -> {
        return new C1135uh("booster_item_exp_x3", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: h */
    public static final DeferredItem<? extends Item> f7676h = f7668a.registerItem("booster_item_exp_x4", properties -> {
        return new C1135uh("booster_item_exp_x4", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: i */
    public static final DeferredItem<? extends Item> f7677i = f7668a.registerItem("booster_item_exp_x5", properties -> {
        return new C1135uh("booster_item_exp_x5", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: j */
    public static final DeferredItem<? extends Item> f7678j = f7668a.registerItem("case_item_common", properties -> {
        return new C1135uh("case_item_common", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: k */
    public static final DeferredItem<? extends Item> f7679k = f7668a.registerItem("key_item_common", properties -> {
        return new C1135uh("key_item_common", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: l */
    public static final DeferredItem<? extends Item> f7680l = f7668a.registerItem("gui_logo", properties -> {
        return new C1068tT("gui_logo", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: m */
    public static final DeferredItem<? extends Item> f7681m = f7668a.registerItem("bomb_defuse_kit", properties -> {
        return new C1145ur("bomb_defuse_kit", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: n */
    public static final DeferredItem<? extends Item> f7682n = f7668a.registerItem(C1307xu.f7558ee, properties -> {
        return new C1146us(C1307xu.f7558ee, properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: o */
    public static final DeferredItem<? extends Item> f7683o = f7668a.registerItem("radio", properties -> {
        return new C1102uA("radio", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: p */
    public static final DeferredItem<? extends Item> f7684p = f7668a.registerItem("medic_bag", properties -> {
        return new C1151ux("medic_bag", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: q */
    public static final DeferredItem<? extends Item> f7685q = f7668a.registerItem(C1307xu.f7556ec, properties -> {
        return new C1143up(C1307xu.f7556ec, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: r */
    public static final DeferredItem<? extends Item> f7686r = f7668a.registerItem("medical_syringe", properties -> {
        return new C1152uy("medical_syringe", properties);
    }, new Item.Properties().stacksTo(8).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: s */
    public static final DeferredItem<? extends Item> f7687s = f7668a.registerItem("adrenaline_syringe", properties -> {
        return new C1142uo("adrenaline_syringe", properties);
    }, new Item.Properties().stacksTo(8).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: t */
    public static final DeferredItem<? extends Item> f7688t = f7668a.registerItem(C1307xu.f7557ed, properties -> {
        return new C1149uv(C1307xu.f7557ed, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: u */
    public static final DeferredItem<? extends Item> f7689u = f7668a.registerItem(C1307xu.f7577ex, properties -> {
        return new C1066tR(C1307xu.f7577ex, properties);
    }, new Item.Properties().stacksTo(16).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: v */
    public static final DeferredItem<? extends Item> f7690v = f7668a.registerItem("magnifying_glass", properties -> {
        return new C1150uw("magnifying_glass", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: w */
    public static final DeferredItem<? extends Item> f7691w = f7668a.registerItem("super_happy_fun_bomb", properties -> {
        return new C1104uC("super_happy_fun_bomb", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: x */
    public static final DeferredItem<? extends Item> f7692x = f7668a.registerItem("randomat", properties -> {
        return new C1103uB("randomat", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: y */
    public static final DeferredItem<? extends Item> f7693y = f7668a.registerItem("binoculars", C1067tS::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: z */
    public static final DeferredItem<? extends Item> f7694z = f7668a.registerItem("map_effect_wand", C1133uf::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: A */
    public static final DeferredItem<? extends Item> f7695A = f7668a.registerItem("map_effect_creator_wand", C1131ud::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: B */
    public static final DeferredItem<? extends Item> f7696B = f7668a.registerItem("map_effect_rotation_wand", C1132ue::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: C */
    public static final DeferredItem<? extends Item> f7697C = f7668a.registerItem("region_wand", C1139ul::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: D */
    public static final DeferredItem<? extends Item> f7698D = f7668a.registerItem("event_trophy_gold", properties -> {
        return new C1135uh("event_trophy_gold", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: E */
    public static final DeferredItem<? extends Item> f7699E = f7668a.registerItem("event_trophy_silver", properties -> {
        return new C1135uh("event_trophy_silver", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: F */
    public static final DeferredItem<? extends Item> f7700F = f7668a.registerItem("event_trophy_bronze", properties -> {
        return new C1135uh("event_trophy_bronze", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: G */
    public static final DeferredItem<? extends Item> f7701G = f7668a.registerItem("prestige_card_1", properties -> {
        return new C1135uh("prestige_card_1", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: H */
    public static final DeferredItem<? extends Item> f7702H = f7668a.registerItem("prestige_card_2", properties -> {
        return new C1135uh("prestige_card_2", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: I */
    public static final DeferredItem<? extends Item> f7703I = f7668a.registerItem("prestige_card_3", properties -> {
        return new C1135uh("prestige_card_3", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: J */
    public static final DeferredItem<? extends Item> f7704J = f7668a.registerItem("prestige_card_4", properties -> {
        return new C1135uh("prestige_card_4", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: K */
    public static final DeferredItem<? extends Item> f7705K = f7668a.registerItem("prestige_card_5", properties -> {
        return new C1135uh("prestige_card_5", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: L */
    public static final DeferredItem<? extends Item> f7706L = f7668a.registerItem("prestige_card_6", properties -> {
        return new C1135uh("prestige_card_6", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: M */
    public static final DeferredItem<? extends Item> f7707M = f7668a.registerItem("flag_item_japan", properties -> {
        return new C1147ut("flag_item_japan", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: N */
    public static final DeferredItem<? extends Item> f7708N = f7668a.registerItem("flag_item_ussr", properties -> {
        return new C1147ut("flag_item_ussr", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: O */
    public static final DeferredItem<? extends C1119uR> f7709O = f7668a.registerItem("chest_flammenwerfer_34", properties -> {
        return new C1119uR("chest_flammenwerfer_34", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, true).m6404a(C1312xz.f8188tB, true);
    });

    /* JADX INFO: renamed from: P */
    public static final DeferredItem<? extends C1119uR> f7710P = f7668a.registerItem("chest_m2_flamethrower", properties -> {
        return new C1119uR("chest_m2_flamethrower", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, true).m6404a(C1312xz.f8188tB, true);
    });

    /* JADX INFO: renamed from: Q */
    public static final DeferredItem<? extends C1119uR> f7711Q = f7668a.registerItem("chest_us_commander", properties -> {
        return new C1119uR("chest_us_commander", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, false).m6404a(C1312xz.f8190tD, false);
    });

    /* JADX INFO: renamed from: R */
    public static final DeferredItem<? extends C1119uR> f7712R = f7668a.registerItem("chest_us_support", properties -> {
        return new C1119uR("chest_us_support", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, false);
    });

    /* JADX INFO: renamed from: S */
    public static final DeferredItem<? extends Item> f7713S = f7668a.registerItem("grenade_flashbang", properties -> {
        return new C1108uG("grenade_flashbang", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: T */
    public static final DeferredItem<? extends Item> f7714T = f7668a.registerItem(C1307xu.f7553dZ, properties -> {
        return new C1106uE(C1307xu.f7553dZ, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: U */
    public static final DeferredItem<? extends Item> f7715U = f7668a.registerItem(C1307xu.f7550dW, properties -> {
        return new C1112uK(C1307xu.f7550dW, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: V */
    public static final DeferredItem<? extends Item> f7716V = f7668a.registerItem("grenade_smoke_stielhandgranate", properties -> {
        return new C1112uK("grenade_smoke_stielhandgranate", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: W */
    public static final DeferredItem<? extends Item> f7717W = f7668a.registerItem(C1307xu.f7551dX, properties -> {
        return new C1107uF(C1307xu.f7551dX, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: X */
    public static final DeferredItem<? extends Item> f7718X = f7668a.registerItem("grenade_frag_mk2", properties -> {
        return new C1109uH("grenade_frag_mk2", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: Y */
    public static final DeferredItem<? extends Item> f7719Y = f7668a.registerItem("grenade_frag_rgd33", properties -> {
        return new C1109uH("grenade_frag_rgd33", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: Z */
    public static final DeferredItem<? extends Item> f7720Z = f7668a.registerItem("grenade_smoke_rgd2", properties -> {
        return new C1112uK("grenade_smoke_rgd2", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: aa */
    public static final DeferredItem<? extends Item> f7721aa = f7668a.registerItem("grenade_frag_wz24", properties -> {
        return new C1109uH("grenade_frag_wz24", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ab */
    public static final DeferredItem<? extends Item> f7722ab = f7668a.registerItem("grenade_frag_type97", properties -> {
        return new C1109uH("grenade_frag_type97", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ac */
    public static final DeferredItem<? extends Item> f7723ac = f7668a.registerItem("grenade_smoke_type94", properties -> {
        return new C1112uK("grenade_smoke_type94", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ad */
    public static final DeferredItem<? extends Item> f7724ad = f7668a.registerItem("grenade_frag_stielhandgranate", properties -> {
        return new C1109uH("grenade_frag_stielhandgranate", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ae */
    public static final DeferredItem<? extends Item> f7725ae = f7668a.registerItem(C1307xu.f7554ea, properties -> {
        return new C1110uI(C1307xu.f7554ea, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: af */
    public static final DeferredItem<? extends Item> f7726af = f7668a.registerItem("grenade_frag_srcm_mod_35", properties -> {
        return new C1109uH("grenade_frag_srcm_mod_35", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ag */
    public static final DeferredItem<? extends Item> f7727ag = f7668a.registerItem("grenade_smoke_breda_mod_42", properties -> {
        return new C1112uK("grenade_smoke_breda_mod_42", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ah */
    public static final DeferredItem<? extends Item> f7728ah = f7668a.registerItem("grenade_frag_f1", properties -> {
        return new C1109uH("grenade_frag_f1", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ai */
    public static final DeferredItem<? extends Item> f7729ai = f7668a.registerItem("grenade_smoke_fumigene_mle_1916", properties -> {
        return new C1112uK("grenade_smoke_fumigene_mle_1916", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: aj */
    public static final DeferredItem<? extends Item> f7730aj = f7668a.registerItem("grenade_frag_millsbomb", properties -> {
        return new C1109uH("grenade_frag_millsbomb", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ak */
    public static final DeferredItem<? extends Item> f7731ak = f7668a.registerItem(C1307xu.f7552dY, properties -> {
        return new C1111uJ(C1307xu.f7552dY, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: al */
    public static final DeferredItem<? extends Item> f7732al = f7668a.registerItem("grenade_smoke_no77", properties -> {
        return new C1112uK("grenade_smoke_no77", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: am */
    public static final DeferredItem<? extends Item> f7733am = f7668a.registerItem("grenade_at_et_wz_38", properties -> {
        return new C1109uH("grenade_at_et_wz_38", properties).m6216a(1.0f).m6218b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: an */
    public static final DeferredItem<? extends Item> f7734an = f7668a.registerItem("grenade_at_hafthohlladung", properties -> {
        return new C1109uH("grenade_at_hafthohlladung", properties).m6216a(1.0f).m6218b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ao */
    public static final DeferredItem<? extends Item> f7735ao = f7668a.registerItem("grenade_at_no82_gammon_bomb", properties -> {
        return new C1109uH("grenade_at_no82_gammon_bomb", properties).m6216a(1.0f).m6218b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ap */
    public static final DeferredItem<? extends Item> f7736ap = f7668a.registerItem("grenade_at_rpg_43", properties -> {
        return new C1109uH("grenade_at_rpg_43", properties).m6216a(1.0f).m6218b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: aq */
    public static final DeferredItem<? extends Item> f7737aq = f7668a.registerItem("grenade_at_type_3", properties -> {
        return new C1109uH("grenade_at_type_3", properties).m6216a(1.0f).m6218b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ar */
    public static final DeferredItem<? extends Item> f7738ar = f7668a.registerItem("grenade_at_type_l", properties -> {
        return new C1109uH("grenade_at_type_l", properties).m6216a(1.0f).m6218b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: as */
    public static final DeferredItem<? extends Item> f7739as = f7668a.registerItem("melee_item_knife_m1905", properties -> {
        return new C1134ug("melee_item_knife_m1905", properties).m6524a(1);
    });

    /* JADX INFO: renamed from: at */
    public static final DeferredItem<? extends Item> f7740at = f7668a.registerItem("melee_item_klappspaten", properties -> {
        return new C1134ug("melee_item_klappspaten", properties).m6525a(C1312xz.f8656CB).m6526a(C0435hX.f2781E).mo6290a(0.05f);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: au */
    public static final DeferredItem<? extends Item> f7741au = f7668a.registerItem("melee_item_sword_shin_gunto", properties -> {
        return new C1134ug("melee_item_sword_shin_gunto", properties).m6525a(C1312xz.f8657CC).m6526a(C0435hX.f2782F);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: av */
    public static final DeferredItem<? extends Item> f7742av = f7668a.registerItem("melee_item_knife_m1938", properties -> {
        return new C1134ug("melee_item_knife_m1938", properties).m6524a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: aw */
    public static final DeferredItem<? extends Item> f7743aw = f7668a.registerItem("melee_item_knife_wz_27", properties -> {
        return new C1134ug("melee_item_knife_wz_27", properties).m6524a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ax */
    public static final DeferredItem<? extends Item> f7744ax = f7668a.registerItem("melee_item_knife_m1940", properties -> {
        return new C1134ug("melee_item_knife_m1940", properties).m6524a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ay */
    public static final DeferredItem<? extends Item> f7745ay = f7668a.registerItem("melee_item_knife_m1886", properties -> {
        return new C1134ug("melee_item_knife_m1886", properties).m6524a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: az */
    public static final DeferredItem<? extends Item> f7746az = f7668a.registerItem("melee_item_knife_fairbairn_sykes", properties -> {
        return new C1134ug("melee_item_knife_fairbairn_sykes", properties).m6524a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: aA */
    public static final DeferredItem<? extends Item> f7747aA = f7668a.registerItem("melee_item_knife_type30", properties -> {
        return new C1134ug("melee_item_knife_type30", properties).m6524a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: aB */
    public static final DeferredItem<? extends Item> f7748aB = f7668a.registerItem("melee_item_wrench", properties -> {
        return new C1134ug("melee_item_wrench", properties).m6525a(C1312xz.f8658CD).m6526a(C0435hX.f2783G).mo6290a(0.05f);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lv */
    public static final DeferredHolder<Item, ? extends C1117uP> f7749lv = f7668a.registerItem("gun_tokarev_avt40", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_tokarev_avt40", properties).m6325a(20, 60).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8516zR).m6809b(C1312xz.f8517zS).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8341wy, C1312xz.f8342wz).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6813d(C1312xz.f8667CM)).m6297a(C0435hX.f2755e).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.6f, "scope_tokarev_avt40", false).m6763a(0.5f)).mo6311a(C1130uc.f6200fT)).m6292a(new C1197vq(2.75f, 2.75f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lw */
    public static final DeferredHolder<Item, ? extends C1117uP> f7750lw = f7668a.registerItem("gun_tokarev_svt40", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_tokarev_svt40", properties).m6325a(10, 30).mo6311a(C1190vj.f6477gu).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8516zR).m6809b(C1312xz.f8517zS).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8341wy, C1312xz.f8342wz).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6813d(C1312xz.f8667CM)).m6297a(C0435hX.f2754d).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.6f, "scope_tokarev_avt40", false).m6763a(0.5f)).mo6311a(C1130uc.f6200fT)).m6292a(new C1197vq(2.75f, 2.75f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lx */
    public static final DeferredHolder<Item, ? extends C1117uP> f7751lx = f7668a.registerItem("gun_type92", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_type92", properties).m6325a(16, 192).mo6311a(C1190vj.f6485gC).m6370a(C1192vl.f6491c).m6372a(C1194vn.f6500c).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8537Am).m6824b(C1312xz.f8343wA, C1312xz.f8344wB).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6822h(C1312xz.f8275vk).m6809b(C1312xz.f8538An).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8502zD, true).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8669CO).m6870a(0.95f)).m6360d(0.5f).mo6331b(0.35f).m6397a(GunType.MG).mo6331b(0.15f)).m6396a(C1070tV.f5826e).mo6290a(2.5f).m6291a(EnumC1122uU.NO_BIPOD_ONLY).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6203fW)).m6363b("mg").m6385a(C1312xz.f8539Ao).m6378a(new Vector3f(0.4f, 0.0f, 0.0f)).m6292a(new C1197vq(6.0f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 5), new C1199vs(EnumC1200vt.SEMI, 5)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ly */
    public static final DeferredHolder<Item, ? extends C1117uP> f7752ly = f7668a.registerItem("gun_welrod", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_welrod", properties).m6325a(8, 24).mo6311a(C1190vj.f6475gs).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8628BZ).m6809b(C1312xz.f8630Cb).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6803a(C1312xz.f8629Ca, true).m6870a(1.2f)).m6360d(0.5f).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6385a(C1312xz.f8631Cc).m6304c(false).m6292a(new C1197vq(3.75f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 32)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lz */
    public static final DeferredHolder<Item, ? extends C1117uP> f7753lz = f7668a.registerItem("gun_brownbess", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_brownbess", properties).m6325a(1, 16).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8635Cg).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8351wI, C1312xz.f8352wJ).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6809b(null).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz).m6803a(C1312xz.f8636Ch, true)).m6297a(C0435hX.f2753c).m6308a(ColorReferences.COLOR_WHITE_SOLID, -1.0f).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6198fR)).m6292a(new C1197vq(8.4f, 8.4f)).m6328g().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 40)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lA */
    public static final DeferredHolder<Item, ? extends C1117uP> f7754lA = f7668a.registerItem("gun_browning30", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_browning30", properties).m6325a(150, ModConnection.CONNECT_TIME_MAX_TICKS).mo6311a(C1190vj.f6484gB).m6370a(C1192vl.f6491c).m6372a(C1194vn.f6500c).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8437yq).m6824b(C1312xz.f8343wA, C1312xz.f8344wB).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6809b(C1312xz.f8438yr).m6820g(C1312xz.f8261uW).m6822h(C1312xz.f8275vk).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8502zD, true).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8669CO).m6845o(C1312xz.f8284vt).m6870a(0.95f)).m6360d(1.0f).mo6331b(0.35f).m6397a(GunType.MG).mo6331b(0.15f)).m6396a(C1070tV.f5826e).mo6290a(2.5f).m6291a(EnumC1122uU.NO_BIPOD_ONLY).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6203fW)).m6363b("mg").m6292a(new C1197vq(10.0f)).mo6290a(0.35f)).m6356a(new Vector3f(), true).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lB */
    public static final DeferredHolder<Item, ? extends C1117uP> f7755lB = f7668a.registerItem("gun_mg42", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_mg42", properties).m6325a(250, 250).mo6311a(C1190vj.f6484gB).m6370a(C1192vl.f6491c).m6372a(C1194vn.f6500c).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8479zg).m6824b(C1312xz.f8329wm, C1312xz.f8330wn).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6809b(C1312xz.f8480zh).m6820g(C1312xz.f8263uY).m6822h(C1312xz.f8275vk).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8481zi, true).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8669CO).m6845o(C1312xz.f8287vw).m6863a(C1312xz.f8226un, C1312xz.f8227uo, 0.4f)).m6360d(0.75f).mo6331b(0.35f).m6397a(GunType.MG).mo6331b(0.15f)).m6396a(C1070tV.f5827f).mo6290a(2.5f).m6291a(EnumC1122uU.NO_BIPOD_ONLY).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6204fX)).m6363b("mg").mo6290a(0.7f)).m6292a(new C1197vq(7.7f)).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lC */
    public static final DeferredHolder<Item, ? extends C1117uP> f7756lC = f7668a.registerItem("gun_vickers_k", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_vickers_k", properties).m6325a(100, 300).mo6311a(C1190vj.f6484gB).m6370a(C1192vl.f6491c).m6372a(C1194vn.f6500c).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8571AU).m6824b(C1312xz.f8343wA, C1312xz.f8344wB).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6822h(C1312xz.f8275vk).m6809b(C1312xz.f8572AV).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8481zi, true).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8669CO).m6845o(C1312xz.f8284vt).m6870a(0.95f)).mo6331b(0.35f).m6397a(GunType.MG).mo6331b(0.15f)).m6396a(C1070tV.f5826e).mo6290a(2.5f).m6291a(EnumC1122uU.NO_BIPOD_ONLY).mo6290a(0.4f)).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6203fW)).m6363b("mg").m6292a(new C1197vq(4.1667f)).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lD */
    public static final DeferredHolder<Item, ? extends C1117uP> f7757lD = f7668a.registerItem("gun_fiat_revelli", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_fiat_revelli", properties).m6325a(150, 300).mo6311a(C1190vj.f6484gB).m6370a(C1192vl.f6491c).m6372a(C1194vn.f6500c).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8583Bg).m6824b(C1312xz.f8343wA, C1312xz.f8344wB).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6822h(C1312xz.f8275vk).m6809b(C1312xz.f8438yr).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8502zD, true).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8669CO).m6845o(C1312xz.f8284vt).m6870a(0.95f)).mo6331b(0.35f).m6397a(GunType.MG).mo6331b(0.15f)).m6396a(C1070tV.f5826e).mo6290a(2.5f).m6291a(EnumC1122uU.NO_BIPOD_ONLY).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6203fW)).m6363b("smg").m6292a(new C1197vq(3.9f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lE */
    public static final DeferredHolder<Item, ? extends C1117uP> f7758lE = f7668a.registerItem("gun_mac_mle_1931", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_mac_mle_1931", properties).m6325a(150, 300).mo6311a(C1190vj.f6484gB).m6370a(C1192vl.f6491c).m6372a(C1194vn.f6500c).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8592Bp).m6824b(C1312xz.f8343wA, C1312xz.f8344wB).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6822h(C1312xz.f8275vk).m6809b(C1312xz.f8593Bq).m6803a(C1312xz.f8594Br, true).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8669CO).m6845o(C1312xz.f8284vt).m6870a(0.95f)).mo6331b(0.35f).m6397a(GunType.MG).mo6331b(0.15f)).m6396a(C1070tV.f5826e).mo6290a(2.5f).m6291a(EnumC1122uU.NO_BIPOD_ONLY).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6203fW)).m6292a(new C1197vq(6.3f)).m6363b("mg").m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lF */
    public static final DeferredHolder<Item, ? extends C1117uP> f7759lF = f7668a.registerItem("gun_lewisgun", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_lewisgun", properties).m6325a(97, Token.SQSTRING).mo6311a(C1190vj.f6484gB).m6370a(C1192vl.f6491c).m6372a(C1194vn.f6500c).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8626BX).m6824b(C1312xz.f8364wV, C1312xz.f8365wW).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6822h(C1312xz.f8275vk).m6809b(C1312xz.f8627BY).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8481zi, true).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8669CO).m6845o(C1312xz.f8284vt).m6870a(0.95f)).mo6331b(0.35f).m6397a(GunType.MG).mo6331b(0.15f)).m6396a(C1070tV.f5826e).mo6290a(2.5f).m6291a(EnumC1122uU.NO_BIPOD_ONLY).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6203fW)).m6363b("mg").m6332h().m6292a(new C1197vq(7.0f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lG */
    public static final DeferredHolder<Item, ? extends C1117uP> f7760lG = f7668a.registerItem("gun_bar", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_bar", properties).m6325a(20, 60).mo6311a(C1190vj.f6482gz).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8432yl).m6803a(C1312xz.f8435yo, true).m6805a(C1312xz.f8433ym, C1312xz.f8434yn).m6820g(C1312xz.f8260uV).m6822h(C1312xz.f8270vf).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8668CN).m6845o(C1312xz.f8286vv).m6870a(0.95f)).m6360d(0.75f).mo6290a(0.5f)).mo6331b(0.25f).m6397a(GunType.LMG).mo6331b(0.2f)).m6396a(C1070tV.f5828g).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6202fV)).m6363b("mg").m6292a(new C1197vq(3.5f, 5.25f)).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lH */
    public static final DeferredHolder<Item, ? extends C1117uP> f7761lH = f7668a.registerItem("gun_dp28", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_dp28", properties).m6325a(47, 141).mo6311a(C1190vj.f6482gz).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8492zt).m6809b(C1312xz.f8493zu).m6820g(C1312xz.f8260uV).m6822h(C1312xz.f8270vf).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8470yX, true).m6845o(C1312xz.f8286vv).m6870a(0.95f)).m6360d(1.0f).m6292a(new C1197vq(4.0f)).mo6331b(0.25f).m6397a(GunType.LMG).mo6331b(0.2f)).m6396a(C1070tV.f5828g).mo6290a(0.5f)).m6332h().m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6202fV)).m6363b("mg").m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lI */
    public static final DeferredHolder<Item, ? extends C1117uP> f7762lI = f7668a.registerItem("gun_mg34", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_mg34", properties).m6325a(150, 300).mo6311a(C1190vj.f6482gz).m6370a(C1192vl.f6491c).m6372a(C1194vn.f6500c).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8500zB).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6809b(C1312xz.f8501zC).m6820g(C1312xz.f8262uX).m6822h(C1312xz.f8275vk).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8502zD, true).m6813d(C1312xz.f8669CO).m6845o(C1312xz.f8286vv).m6870a(0.9f)).m6385a(C1312xz.f8503zE).mo6290a(2.5f).m6291a(EnumC1122uU.NO_BIPOD_ONLY).mo6331b(0.25f).m6397a(GunType.LMG).mo6331b(0.2f)).m6396a(C1070tV.f5828g).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6202fV)).m6363b("mg").m6292a(new C1197vq(7.7f)).mo6290a(0.5f)).m6356a(new Vector3f(), true).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lJ */
    public static final DeferredHolder<Item, ? extends C1117uP> f7763lJ = f7668a.registerItem("gun_zb26", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_zb26", properties).m6325a(20, 60).m6360d(0.5f).mo6311a(C1190vj.f6482gz).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8521zW).m6809b(C1312xz.f8522zX).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8546Av, true).m6813d(C1312xz.f8668CN).m6845o(C1312xz.f8286vv).m6870a(0.95f)).mo6331b(0.25f).m6397a(GunType.LMG).mo6331b(0.2f)).m6396a(C1070tV.f5828g).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6202fV)).m6363b("mg").m6292a(new C1197vq(5.75f)).mo6290a(0.4f)).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lK */
    public static final DeferredHolder<Item, ? extends C1117uP> f7764lK = f7668a.registerItem("gun_type11", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_type11", properties).m6325a(30, 90).mo6311a(C1190vj.f6482gz).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8540Ap).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6809b(C1312xz.f8541Aq).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8668CN).m6803a(C1312xz.f8546Av, true).m6845o(C1312xz.f8286vv).m6870a(0.95f)).m6360d(0.75f).mo6290a(0.2f)).mo6331b(0.25f).m6397a(GunType.LMG).mo6331b(0.2f)).m6396a(C1070tV.f5828g).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6202fV)).m6363b("mg").m6292a(new C1197vq(4.83f)).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lL */
    public static final DeferredHolder<Item, ? extends C1117uP> f7765lL = f7668a.registerItem("gun_bren_mk2", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_bren_mk2", properties).m6325a(30, 90).m6326a("pan", new C1118uQ(Component.translatable("bf.item.gun.mag.type.pan"), 100, 100)).mo6311a(C1190vj.f6482gz).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8545Au).m6809b(C1312xz.f8547Aw).m6820g(C1312xz.f8260uV).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8546Av, false).m6845o(C1312xz.f8286vv).m6837k(C1312xz.f8280vp).m6870a(0.95f)).m6297a(C0435hX.f2755e).mo6331b(0.25f).m6397a(GunType.LMG).mo6331b(0.2f)).m6396a(C1070tV.f5828g).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6202fV)).mo6290a(0.35f)).m6363b("mg").m6292a(new C1197vq(4.5f)).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 1), new C1199vs(EnumC1200vt.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lM */
    public static final DeferredHolder<Item, ? extends C1117uP> f7766lM = f7668a.registerItem("gun_model_1930", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_model_1930", properties).m6325a(20, 60).mo6311a(C1190vj.f6482gz).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8580Bd).m6805a(C1312xz.f8581Be, C1312xz.f8582Bf).m6820g(C1312xz.f8261uW).m6822h(C1312xz.f8270vf).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8669CO).m6845o(C1312xz.f8286vv).m6870a(0.95f)).m6360d(0.5f).mo6331b(0.25f).m6397a(GunType.LMG).mo6331b(0.2f)).m6396a(C1070tV.f5828g).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6202fV)).m6292a(new C1197vq(4.7f)).mo6290a(0.4f)).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lN */
    public static final DeferredHolder<Item, ? extends C1117uP> f7767lN = f7668a.registerItem("gun_breda_safat", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_breda_safat", properties).m6325a(150, 300).mo6311a(C1190vj.f6484gB).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8437yq).m6824b(C1312xz.f8343wA, C1312xz.f8344wB).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6809b(C1312xz.f8438yr).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8502zD, true).m6843n(C1312xz.f8288vx).m6845o(C1312xz.f8286vv).m6870a(0.95f)).mo6331b(0.25f).m6397a(GunType.LMG).mo6331b(0.2f)).m6396a(C1070tV.f5828g).mo6290a(0.35f)).m6360d(1.0f).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6202fV)).m6292a(new C1197vq(6.0f)).m6363b("mg").m6356a(new Vector3f(), true).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lO */
    public static final DeferredHolder<Item, ? extends C1117uP> f7768lO = f7668a.registerItem("gun_type96", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_type96", properties).m6325a(30, 90).mo6311a(C1190vj.f6482gz).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8548Ax).m6809b(C1312xz.f8550Az).m6820g(C1312xz.f8260uV).m6822h(C1312xz.f8275vk).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6813d(C1312xz.f8668CN).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8549Ay, true).m6845o(C1312xz.f8286vv).m6870a(0.95f)).mo6331b(0.25f).m6397a(GunType.LMG).mo6331b(0.2f)).m6396a(C1070tV.f5828g).m6295a(C1188vh.a.DEFAULT, new C1188vh(true, 0.2f, "scope_kar98k", false)).mo6311a(C1130uc.f6202fV)).m6363b("mg").m6385a(C1312xz.f8551AA).m6292a(new C1197vq(5.5f)).mo6290a(0.3f)).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lP */
    public static final DeferredHolder<Item, ? extends C1117uP> f7769lP = f7668a.registerItem("gun_type98", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_type98", properties).m6325a(75, 150).mo6311a(C1190vj.f6482gz).m6370a(C1192vl.f6491c).m6372a(C1194vn.f6500c).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8552AB).m6809b(C1312xz.f8553AC).m6820g(C1312xz.f8260uV).m6822h(C1312xz.f8275vk).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6813d(C1312xz.f8668CN).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6803a(C1312xz.f8549Ay, true).m6845o(C1312xz.f8286vv).m6870a(0.95f)).mo6331b(0.25f).m6397a(GunType.MG).mo6331b(0.15f)).m6396a(C1070tV.f5828g).mo6311a(C1130uc.f6202fV)).m6363b("mg").m6385a(C1312xz.f8551AA).m6292a(new C1197vq(4.8f)).mo6290a(0.3f)).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lQ */
    public static final DeferredHolder<Item, ? extends C1117uP> f7770lQ = f7668a.registerItem("gun_m1928a1_thompson", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_m1928a1_thompson", properties).m6325a(20, 100).m6326a("drum", new C1118uQ(Component.translatable("bf.item.gun.mag.type.drum"), 100, 100)).mo6311a(C1190vj.f6480gx).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8424yd).m6803a(C1312xz.f8427yg, true).m6824b(C1312xz.f8331wo, C1312xz.f8332wp).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8400xF).m6809b(C1312xz.f8425ye).m6820g(C1312xz.f8260uV).m6822h(C1312xz.f8273vi).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5823b).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6201fU)).m6363b("smg").m6292a(new C1197vq(2.5f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 1), new C1199vs(EnumC1200vt.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lR */
    public static final DeferredHolder<Item, ? extends C1117uP> f7771lR = f7668a.registerItem("gun_m1a1_thompson", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_m1a1_thompson", properties).m6325a(30, C0358g.f2490g).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8424yd).m6803a(C1312xz.f8427yg, true).m6820g(C1312xz.f8268vd).m6824b(C1312xz.f8331wo, C1312xz.f8332wp).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8400xF).m6809b(C1312xz.f8425ye).m6820g(C1312xz.f8260uV).m6822h(C1312xz.f8273vi).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6292a(new C1197vq(2.5f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: c */
    private static final C1198vr f7772c = C1198vr.f6511b.clone().m6807a(C1312xz.f8428yh).m6820g(C1312xz.f8268vd).m6824b(C1312xz.f8323wg, C1312xz.f8324wh).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8400xF).m6809b(C1312xz.f8430yj).m6820g(C1312xz.f8260uV).m6822h(C1312xz.f8273vi).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE);

    /* JADX INFO: renamed from: d */
    private static final C1198vr f7773d = C1198vr.f6511b.clone().m6870a(1.5f).m6807a(C1312xz.f8429yi).m6803a(C1312xz.f8431yk, true).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8400xF).m6809b(C1312xz.f8430yj).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(null).m6827i(null).m6831d(null, null).m6839l(null).m6820g(null).m6822h(null);

    /* JADX INFO: renamed from: lS */
    public static final DeferredHolder<Item, ? extends C1117uP> f7774lS = f7668a.registerItem("gun_greasegun", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_greasegun", properties).m6325a(30, 90).mo6311a(C1190vj.f6479gw).m6312a(f7772c).m6327a("suppressor", new C1113uL(Component.translatable("bf.item.gun.barrel.type.suppressor")).m6237a(false).m6239a(f7773d)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6292a(new C1197vq(3.0f)).mo6290a(0.75f)).m6360d(0.65f).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lT */
    public static final DeferredHolder<Item, ? extends C1117uP> f7775lT = f7668a.registerItem("gun_mp40", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_mp40", properties).m6325a(32, 96).m6326a("double", new C1118uQ(Component.translatable("bf.item.gun.mag.type.doppel"), 64, 128)).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8467yU).m6824b(C1312xz.f8366wX, C1312xz.f8367wY).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8400xF).m6805a(C1312xz.f8468yV, C1312xz.f8469yW).m6820g(C1312xz.f8264uZ).m6822h(C1312xz.f8273vi).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6803a(C1312xz.f8470yX, true).m6847p(C1312xz.f8295vE).m6837k(C1312xz.f8278vn)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6385a(C1312xz.f8471yY).m6292a(new C1197vq(2.75f, 5.0f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lU */
    public static final DeferredHolder<Item, ? extends C1117uP> f7776lU = f7668a.registerItem("gun_stg44", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_stg44", properties).m6325a(30, 90).mo6311a(C1190vj.f6481gy).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8473za).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6805a(C1312xz.f8474zb, C1312xz.f8475zc).m6820g(C1312xz.f8267vc).m6822h(C1312xz.f8270vf).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6803a(C1312xz.f8470yX, true).m6837k(C1312xz.f8279vo).m6870a(0.95f)).m6385a(C1312xz.f8476zd).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6292a(new C1197vq(2.0f, 3.25f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lV */
    public static final DeferredHolder<Item, ? extends C1117uP> f7777lV = f7668a.registerItem("gun_blyskawica", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_blyskawica", properties).m6325a(20, 60).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8489zq).m6824b(C1312xz.f8331wo, C1312xz.f8332wp).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8273vi).m6841m(C1312xz.f8400xF).m6805a(C1312xz.f8490zr, C1312xz.f8491zs).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6292a(new C1197vq(2.75f, 3.75f)).m6363b("smg").m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lW */
    public static final DeferredHolder<Item, ? extends C1117uP> f7778lW = f7668a.registerItem("gun_kop_pal", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_kop_pal", properties).m6325a(32, 96).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8496zx).m6824b(C1312xz.f8331wo, C1312xz.f8332wp).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8273vi).m6841m(C1312xz.f8400xF).m6809b(C1312xz.f8497zy).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6292a(new C1197vq(2.5f, 4.3f)).m6363b("smg").m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    });

    /* JADX INFO: renamed from: lX */
    public static final DeferredHolder<Item, ? extends C1117uP> f7779lX = f7668a.registerItem("gun_pps43", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_pps43", properties).m6325a(35, 105).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8508zJ).m6824b(C1312xz.f8327wk, C1312xz.f8328wl).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8273vi).m6841m(C1312xz.f8400xF).m6809b(C1312xz.f8509zK).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE)).m6385a(C1312xz.f8510zL).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6292a(new C1197vq(3.0f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lY */
    public static final DeferredHolder<Item, ? extends C1117uP> f7780lY = f7668a.registerItem("gun_ppsh", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_ppsh", properties).m6325a(35, 105).m6326a("drum", new C1118uQ(Component.translatable("bf.item.gun.mag.type.drum"), 71, 142)).mo6311a(C1190vj.f6480gx).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8511zM).m6824b(C1312xz.f8327wk, C1312xz.f8328wl).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6822h(C1312xz.f8273vi).m6841m(C1312xz.f8400xF).m6809b(C1312xz.f8512zN).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5823b).m6292a(new C1197vq(3.0f)).m6360d(0.8f).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6201fU)).m6385a(C1312xz.f8513zO).m6363b("smg").m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 1), new C1199vs(EnumC1200vt.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: lZ */
    public static final DeferredHolder<Item, ? extends C1117uP> f7781lZ = f7668a.registerItem("gun_type100", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_type100", properties).m6325a(30, 90).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8542Ar).m6824b(C1312xz.f8331wo, C1312xz.f8332wp).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8273vi).m6841m(C1312xz.f8400xF).m6805a(C1312xz.f8543As, C1312xz.f8544At).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6292a(new C1197vq(4.0f, 5.5f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: e */
    private static final C1198vr f7782e = C1198vr.f6511b.clone().m6804a(C1312xz.f8564AN, true, 1).m6807a(C1312xz.f8562AL).m6824b(C1312xz.f8325wi, C1312xz.f8326wj).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8273vi).m6841m(C1312xz.f8400xF).m6805a(C1312xz.f8563AM, C1312xz.f8565AO).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE);

    /* JADX INFO: renamed from: f */
    private static final C1198vr f7783f = C1198vr.f6511b.clone().m6870a(1.5f).m6807a(C1312xz.f8566AP).m6803a(C1312xz.f8567AQ, true).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8400xF).m6805a(C1312xz.f8563AM, C1312xz.f8565AO).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(null).m6827i(null).m6831d(null, null).m6839l(null).m6820g(null).m6822h(null);

    /* JADX INFO: renamed from: ma */
    public static final DeferredHolder<Item, ? extends C1117uP> f7784ma = f7668a.registerItem("gun_sten_mk2", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_sten_mk2", properties).m6325a(32, 96).m6326a("lanchester", new C1118uQ(Component.translatable("bf.item.gun.mag.type.lanchester"), 50, 100)).m6327a("suppressor", new C1113uL(Component.translatable("bf.item.gun.barrel.type.suppressor")).m6237a(false).m6239a(f7783f)).mo6311a(C1190vj.f6479gw).m6312a(f7782e).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6292a(new C1197vq(2.5f, 4.375f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mb */
    public static final DeferredHolder<Item, ? extends C1117uP> f7785mb = f7668a.registerItem("gun_model_38", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_model_38", properties).m6325a(30, 90).m6326a("extended", new C1118uQ(Component.translatable("bf.item.gun.mag.type.extended"), 40, 80)).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6804a(C1312xz.f8577Ba, true, 1).m6807a(C1312xz.f8576AZ).m6824b(C1312xz.f8331wo, C1312xz.f8332wp).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8273vi).m6841m(C1312xz.f8400xF).m6809b(C1312xz.f8578Bb).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE)).m6385a(C1312xz.f8579Bc).m6360d(0.7f).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6292a(new C1197vq(3.7f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mc */
    public static final DeferredHolder<Item, ? extends C1117uP> f7786mc = f7668a.registerItem("gun_mas_38", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_mas_38", properties).m6325a(32, 96).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8597Bu).m6824b(C1312xz.f8331wo, C1312xz.f8332wp).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8273vi).m6841m(C1312xz.f8398xD).m6809b(C1312xz.f8598Bv).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6803a(C1312xz.f8599Bw, true).m6847p(C1312xz.f8292vB).m6870a(1.2f)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6292a(new C1197vq(3.75f)).m6363b("smg").m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: md */
    public static final DeferredHolder<Item, ? extends C1117uP> f7787md = f7668a.registerItem("gun_ak74", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_ak74", properties).m6325a(30, 90).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8619BQ).m6803a(C1312xz.f8620BR, true).m6824b(C1312xz.f8331wo, C1312xz.f8332wp).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8400xF).m6805a(C1312xz.f8621BS, C1312xz.f8622BT).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8273vi).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6292a(new C1197vq(3.0f, 4.3f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: me */
    public static final DeferredHolder<Item, ? extends C1117uP> f7788me = f7668a.registerItem("gun_m4a4", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_m4a4", properties).m6325a(30, 90).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8623BU).m6803a(C1312xz.f8625BW, true).m6824b(C1312xz.f8331wo, C1312xz.f8332wp).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8400xF).m6809b(C1312xz.f8624BV).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8273vi).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6292a(new C1197vq(3.4167f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mf */
    public static final DeferredHolder<Item, ? extends C1117uP> f7789mf = f7668a.registerItem("gun_fg42", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_fg42", properties).m6325a(20, 60).mo6311a(C1190vj.f6481gy).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8477ze).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6809b(C1312xz.f8478zf).m6820g(C1312xz.f8267vc).m6822h(C1312xz.f8270vf).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6803a(C1312xz.f8470yX, true).m6870a(0.95f)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.6f, "scope_fg42", false).m6763a(0.5f)).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6360d(2.0f).m6332h().m6292a(new C1197vq(3.79f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 3), new C1199vs(EnumC1200vt.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mg */
    public static final DeferredHolder<Item, ? extends C1117uP> f7790mg = f7668a.registerItem("gun_trenchgun", properties -> {
        return ((C1117uP) new C1117uP("gun_trenchgun", properties).m6325a(6, 18).mo6311a(C1190vj.f6486gD).m6329e(64).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8463yQ).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8333wq, C1312xz.f8334wr).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8671CQ).m6870a(0.95f)).m6297a(C0435hX.f2753c).mo6331b(0.2f).m6397a(GunType.SHOTGUN).m6396a(C1070tV.f5831j).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6207ga)).m6363b("shell").m6385a((DeferredHolder<SoundEvent, SoundEvent>) null).m6292a(new C1196vp(0.83f, 0.75f, 1.25f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 18, f7657vy).m6880a(f7658b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mh */
    public static final DeferredHolder<Item, ? extends C1117uP> f7791mh = f7668a.registerItem("gun_m30", properties -> {
        return ((C1117uP) new C1117uP("gun_m30", properties).m6325a(2, 20).mo6311a(C1190vj.f6486gD).m6329e(64).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8617BO).m6805a(C1312xz.f8618BP, C1312xz.f8618BP).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8333wq, C1312xz.f8334wr).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8671CQ).m6870a(0.95f)).m6297a(C0435hX.f2753c).mo6331b(0.2f).m6397a(GunType.SHOTGUN).m6396a(C1070tV.f5831j).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6207ga)).m6363b("shell").m6292a(new C1197vq(3.8f, 3.8f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 5, f7657vy).m6880a(f7658b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mi */
    public static final DeferredHolder<Item, ? extends C1117uP> f7792mi = f7668a.registerItem("gun_becker", properties -> {
        return ((C1117uP) new C1117uP("gun_becker", properties).m6325a(5, 15).mo6311a(C1190vj.f6486gD).m6329e(64).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8617BO).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8333wq, C1312xz.f8334wr).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8671CQ).m6870a(0.95f)).m6297a(C0435hX.f2753c).mo6331b(0.2f).m6397a(GunType.SHOTGUN).m6396a(C1070tV.f5831j).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6207ga)).m6363b("shell").m6292a(new C1196vp(1.5f, 1.65f, 0.5f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 6, f7657vy).m6880a(f7658b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mj */
    public static final DeferredHolder<Item, ? extends C1117uP> f7794mj = f7668a.registerItem("gun_mauser_m712", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_mauser_m712", properties).m6325a(20, 60).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6803a(C1312xz.f8457yK, true).m6807a(C1312xz.f8456yJ).m6805a(C1312xz.f8458yL, C1312xz.f8459yM).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2759i).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5833l).m6313e().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(2.4f, 3.12f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 1), new C1199vs(EnumC1200vt.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mk */
    public static final DeferredHolder<Item, ? extends C1117uP> f7795mk = f7668a.registerItem("gun_springfield", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_springfield", properties).m6325a(5, 15).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8436yp).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8362wT, C1312xz.f8363wU).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz)).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_springfield", false).m6763a(0.5f)).m6385a((DeferredHolder<SoundEvent, SoundEvent>) null).mo6311a(C1130uc.f6198fR)).m6292a(new C1196vp(1.875f, 0.58f, 1.25f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ml */
    public static final DeferredHolder<Item, ? extends C1117uP> f7796ml = f7668a.registerItem("gun_kar98k", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_kar98k", properties).m6325a(5, 15).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8460yN).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8372xd, C1312xz.f8373xe).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz)).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_kar98k", false).m6763a(0.5f)).mo6311a(C1130uc.f6198fR)).m6292a(new C1196vp(1.875f, 0.4583f, 1.0f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mm */
    public static final DeferredHolder<Item, ? extends C1117uP> f7797mm = f7668a.registerItem("gun_kbk_wz_29", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_kbk_wz_29", properties).m6325a(5, 15).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8494zv).m6809b(C1312xz.f8495zw).m6849q(C1312xz.f8388xt).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8372xd, C1312xz.f8373xe).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz)).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_kar98k", false).m6763a(0.5f)).mo6311a(C1130uc.f6198fR)).m6292a(new C1196vp(2.0f, 0.58f, 1.25f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mn */
    public static final DeferredHolder<Item, ? extends C1117uP> f7798mn = f7668a.registerItem("gun_mosin_nagant", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_mosin_nagant", properties).m6325a(5, 15).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8504zF).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8374xf, C1312xz.f8375xg).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz).m6837k(C1312xz.f8283vs)).m6385a((DeferredHolder<SoundEvent, SoundEvent>) null).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_kar98k", false).m6763a(0.5f)).mo6311a(C1130uc.f6198fR)).m6292a(new C1196vp(1.875f, 0.4583f, 1.0f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mo */
    public static final DeferredHolder<Item, ? extends C1117uP> f7799mo = f7668a.registerItem("gun_type38", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_type38", properties).m6325a(5, 15).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8531Ag).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8335ws, C1312xz.f8336wt).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz)).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_type38", false).m6763a(0.5f)).mo6311a(C1130uc.f6198fR)).m6292a(new C1196vp(1.875f, 0.4583f, 1.0f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mp */
    public static final DeferredHolder<Item, ? extends C1117uP> f7800mp = f7668a.registerItem("gun_type99", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_type99", properties).m6325a(5, 15).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8533Ai).m6809b(C1312xz.f8534Aj).m6849q(C1312xz.f8388xt).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC)).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_type99", false)).mo6311a(C1130uc.f6198fR)).m6292a(new C1196vp(2.0f, 0.58f, 1.25f)).m6363b("mg").m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mq */
    public static final DeferredHolder<Item, ? extends C1117uP> f7801mq = f7668a.registerItem("gun_lee_enfield_mk1", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_lee_enfield_mk1", properties).m6325a(10, 30).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8554AD).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8360wR, C1312xz.f8361wS).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz)).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_kar98k", false).m6763a(0.5f)).mo6311a(C1130uc.f6198fR)).m6292a(new C1196vp(2.0f, 0.58f, 1.25f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mr */
    public static final DeferredHolder<Item, ? extends C1117uP> f7802mr = f7668a.registerItem("gun_carcano_m91ts_carbine", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_carcano_m91ts_carbine", properties).m6325a(6, 18).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8573AW).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8335ws, C1312xz.f8336wt).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz)).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_carcano", false).m6763a(0.5f)).mo6311a(C1130uc.f6198fR)).m6385a((DeferredHolder<SoundEvent, SoundEvent>) null).m6292a(new C1196vp(2.0f, 0.58f, 1.25f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ms */
    public static final DeferredHolder<Item, ? extends C1117uP> f7803ms = f7668a.registerItem("gun_carcano_m38", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_carcano_m38", properties).m6325a(6, 18).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8573AW).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8335ws, C1312xz.f8336wt).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz)).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_carcano", false).m6763a(0.5f)).mo6311a(C1130uc.f6198fR)).m6385a((DeferredHolder<SoundEvent, SoundEvent>) null).m6292a(new C1196vp(2.0f, 0.58f, 1.25f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mt */
    public static final DeferredHolder<Item, ? extends C1117uP> f7804mt = f7668a.registerItem("gun_lebel_1886", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_lebel_1886", properties).m6325a(10, 30).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8588Bl).m6849q(C1312xz.f8388xt).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8335ws, C1312xz.f8336wt).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz)).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_lebel_1886", false).m6763a(0.5f)).mo6311a(C1130uc.f6198fR)).m6292a(new C1196vp(2.0f, 0.58f, 1.25f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mu */
    public static final DeferredHolder<Item, ? extends C1117uP> f7805mu = f7668a.registerItem("gun_m1_garand", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_m1_garand", properties).m6325a(8, 24).mo6311a(C1190vj.f6477gu).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8417xW).m6805a(C1312xz.f8418xX, C1312xz.f8419xY).m6813d(C1312xz.f8420xZ).m6820g(C1312xz.f8269ve).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8370xb, C1312xz.f8371xc).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz).m6837k(C1312xz.f8282vr)).m6297a(C0435hX.f2754d).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5825d).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_m1_garand", false).m6763a(0.5f)).mo6311a(C1130uc.f6199fS)).m6292a(new C1197vq(5.0f, 3.75f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mv */
    public static final DeferredHolder<Item, ? extends C1117uP> f7806mv = f7668a.registerItem("gun_m1_carbine", properties -> {
        return ((C1117uP) new C1117uP("gun_m1_carbine", properties).m6325a(15, 60).mo6311a(C1190vj.f6478gv).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8439ys).m6809b(C1312xz.f8440yt).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8384xp).m6847p(C1312xz.f8292vB).m6813d(C1312xz.f8667CM).m6824b(C1312xz.f8368wZ, C1312xz.f8369xa).m6841m(C1312xz.f8399xE).m6837k(C1312xz.f8281vq)).mo6331b(0.1f).m6397a(GunType.CARBINE).m6396a(C1070tV.f5825d).m6313e().m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6199fS)).m6292a(new C1197vq(4.75f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mw */
    public static final DeferredHolder<Item, ? extends C1117uP> f7807mw = f7668a.registerItem("gun_m2_carbine", properties -> {
        return ((C1117uP) new C1117uP("gun_m2_carbine", properties).m6325a(30, 90).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8439ys).m6803a(C1312xz.f8441yu, true).m6809b(C1312xz.f8440yt).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8384xp).m6847p(C1312xz.f8292vB).m6813d(C1312xz.f8667CM).m6824b(C1312xz.f8368wZ, C1312xz.f8369xa).m6841m(C1312xz.f8399xE).m6837k(C1312xz.f8281vq)).mo6331b(0.05f).m6397a(GunType.CARBINE).m6396a(C1070tV.f5822a).m6313e().m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_m1_garand", false).m6763a(0.5f)).mo6311a(C1130uc.f6200fT)).m6292a(new C1197vq(4.75f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mx */
    public static final DeferredHolder<Item, ? extends C1117uP> f7808mx = f7668a.registerItem("gun_gewehr_43", properties -> {
        return ((C1117uP) new C1117uP("gun_gewehr_43", properties).m6325a(10, 30).mo6311a(C1190vj.f6477gu).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8483zk).m6805a(C1312xz.f8484zl, C1312xz.f8485zm).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8341wy, C1312xz.f8342wz).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8294vD).m6843n(C1312xz.f8290vz).m6813d(C1312xz.f8667CM)).m6297a(C0435hX.f2754d).mo6331b(0.1f).m6397a(GunType.CARBINE).m6396a(C1070tV.f5825d).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_gewehr_43", false).m6763a(0.5f)).mo6311a(C1130uc.f6199fS)).m6292a(new C1197vq(2.45f, 3.3f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: my */
    public static final DeferredHolder<Item, ? extends C1117uP> f7809my = f7668a.registerItem("gun_type4", properties -> {
        return ((C1117uP) new C1117uP("gun_type4", properties).m6325a(10, 30).mo6311a(C1190vj.f6477gu).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8535Ak).m6809b(C1312xz.f8536Al).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8335ws, C1312xz.f8336wt).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz)).m6297a(C0435hX.f2754d).mo6331b(0.1f).m6397a(GunType.CARBINE).m6396a(C1070tV.f5825d).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_m1_garand", false).m6763a(0.5f)).mo6311a(C1130uc.f6199fS)).m6292a(new C1197vq(3.7f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mz */
    public static final DeferredHolder<Item, ? extends C1117uP> f7810mz = f7668a.registerItem("gun_lee_enfield_turner", properties -> {
        return ((C1117uP) new C1117uP("gun_lee_enfield_turner", properties).m6325a(10, 30).mo6311a(C1190vj.f6477gu).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8554AD).m6824b(C1312xz.f8360wR, C1312xz.f8361wS).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8294vD).m6843n(C1312xz.f8290vz).m6813d(C1312xz.f8667CM)).m6297a(C0435hX.f2754d).mo6331b(0.1f).m6397a(GunType.CARBINE).m6396a(C1070tV.f5825d).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6199fS)).m6292a(new C1196vp(1.125f, 0.63f, 1.3333f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mA */
    public static final DeferredHolder<Item, ? extends C1117uP> f7811mA = f7668a.registerItem("gun_model_1935", properties -> {
        return ((C1117uP) new C1117uP("gun_model_1935", properties).m6325a(20, 60).mo6311a(C1190vj.f6477gu).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8574AX).m6824b(C1312xz.f8341wy, C1312xz.f8342wz).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6822h(C1312xz.f8275vk).m6841m(C1312xz.f8399xE).m6809b(C1312xz.f8575AY).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8667CM).m6845o(C1312xz.f8284vt).m6870a(1.2f)).mo6331b(0.35f).m6397a(GunType.CARBINE).m6396a(C1070tV.f5826e).mo6290a(2.5f).m6291a(EnumC1122uU.NO_BIPOD_ONLY).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6203fW)).m6363b("pistol").m6292a(new C1197vq(4.3f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mB */
    public static final DeferredHolder<Item, ? extends C1117uP> f7812mB = f7668a.registerItem("gun_fusil_1917", properties -> {
        return ((C1117uP) new C1117uP("gun_fusil_1917", properties).m6325a(5, 30).mo6311a(C1190vj.f6477gu).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8595Bs).m6809b(C1312xz.f8596Bt).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8335ws, C1312xz.f8336wt).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz)).m6297a(C0435hX.f2754d).mo6331b(0.1f).m6397a(GunType.CARBINE).m6396a(C1070tV.f5825d).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6199fS)).m6292a(new C1197vq(5.0f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mC */
    public static final DeferredHolder<Item, ? extends C1117uP> f7813mC = f7668a.registerItem("gun_howell", properties -> {
        return ((C1117uP) new C1117uP("gun_howell", properties).m6325a(10, 30).mo6311a(C1190vj.f6477gu).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8637Ci).m6809b(C1312xz.f8638Cj).m6824b(C1312xz.f8360wR, C1312xz.f8361wS).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8294vD).m6843n(C1312xz.f8290vz).m6813d(C1312xz.f8667CM)).m6297a(C0435hX.f2754d).mo6331b(0.1f).m6397a(GunType.CARBINE).m6396a(C1070tV.f5825d).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_kar98k", false).m6763a(0.5f)).mo6311a(C1130uc.f6199fS)).m6292a(new C1197vq(7.8f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mD */
    public static final DeferredHolder<Item, ? extends C1117uP> f7814mD = f7668a.registerItem("gun_ptrs", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_ptrs", properties).m6325a(5, 5).mo6311a(C1190vj.f6483gA).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8514zP).m6803a(C1312xz.f8602Bz, true).m6809b(C1312xz.f8515zQ).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8337wu, C1312xz.f8338wv).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8669CO).m6867x(C1312xz.f8248uJ).m6870a(0.95f)).m6302b(false).m6297a(C0435hX.f2758h).mo6331b(0.4f).m6397a(GunType.AT).mo6331b(0.1f)).m6396a(C1070tV.f5830i).m6360d(2.5f).mo6290a(0.3f)).m6292a(new C1197vq(6.0f)).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6206fZ)).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mE */
    public static final DeferredHolder<Item, ? extends C1117uP> f7815mE = f7668a.registerItem("gun_batr", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_batr", properties).m6325a(5, 5).mo6290a(0.3f)).m6332h().mo6311a(C1190vj.f6483gA).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8600Bx).m6803a(C1312xz.f8602Bz, true).m6809b(C1312xz.f8601By).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8337wu, C1312xz.f8338wv).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8288vx).m6867x(C1312xz.f8248uJ).m6870a(0.95f)).m6302b(false).m6297a(C0435hX.f2758h).mo6331b(0.4f).m6397a(GunType.AT).mo6331b(0.1f)).m6396a(C1070tV.f5830i).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6206fZ)).m6292a(new C1197vq(5.25f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mF */
    public static final DeferredHolder<Item, ? extends C1117uP> f7816mF = f7668a.registerItem("gun_panzerbuchse39", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_panzerbuchse39", properties).m6325a(1, 10).mo6290a(0.2f)).m6360d(2.0f).mo6311a(C1190vj.f6483gA).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8603BA).m6803a(C1312xz.f8605BC, true).m6809b(C1312xz.f8604BB).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8337wu, C1312xz.f8338wv).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8288vx).m6867x(C1312xz.f8248uJ).m6870a(0.95f)).m6302b(false).m6297a(C0435hX.f2758h).m6332h().mo6331b(0.4f).m6397a(GunType.AT).mo6331b(0.1f)).m6396a(C1070tV.f5830i).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6206fZ)).m6292a(new C1197vq(4.25f)).m6385a(C1312xz.f8606BD).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mG */
    public static final DeferredHolder<Item, ? extends C1117uP> f7817mG = f7668a.registerItem("gun_type26", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_type26", properties).m6325a(6, 18).mo6311a(C1190vj.f6474gr).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8529Ae).m6815e(C1312xz.f8297vG).m6803a(C1312xz.f8557AG, true).m6809b(C1312xz.f8530Af).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8358wP, C1312xz.f8359wQ).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6865w(C1312xz.f8405xK).m6870a(1.2f)).m6297a(C0435hX.f2752b).m6299a(true).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.35f)).m6396a(C1070tV.f5834m).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6197fQ)).m6363b("pistol").m6292a(new C1197vq(4.45f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mH */
    public static final DeferredHolder<Item, ? extends C1117uP> f7818mH = f7668a.registerItem("gun_webley_mk6", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_webley_mk6", properties).m6325a(6, 18).mo6311a(C1190vj.f6474gr).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8556AF).m6815e(C1312xz.f8297vG).m6804a(C1312xz.f8557AG, true, 1).m6809b(C1312xz.f8558AH).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8358wP, C1312xz.f8359wQ).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6865w(C1312xz.f8405xK).m6870a(1.2f)).m6297a(C0435hX.f2752b).m6299a(true).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.35f)).m6396a(C1070tV.f5834m).m6297a(C0435hX.f2757g).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6197fQ)).m6363b("pistol").m6292a(new C1197vq(4.45f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mI */
    public static final DeferredHolder<Item, ? extends C1117uP> f7819mI = f7668a.registerItem("gun_modele_1892_revolver", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_modele_1892_revolver", properties).m6325a(6, 18).mo6311a(C1190vj.f6474gr).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8607BE).m6815e(C1312xz.f8297vG).m6803a(C1312xz.f8608BF, true).m6809b(C1312xz.f8609BG).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8358wP, C1312xz.f8359wQ).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6865w(C1312xz.f8405xK).m6870a(1.2f)).m6297a(C0435hX.f2752b).m6299a(true).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.35f)).m6396a(C1070tV.f5834m).m6313e().m6309d().m6292a(new C1197vq(6.5f)).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6197fQ)).m6363b("pistol").m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mJ */
    public static final DeferredHolder<Item, ? extends C1117uP> f7820mJ = f7668a.registerItem("gun_m2_flamethrower", properties -> {
        C1117uP c1117uPM6292a = ((C1117uP) new C1117uP("gun_m2_flamethrower", properties).m6325a(15200, 30400).m6351g(AbstractC0223dX.f1766ij).mo6311a(C1190vj.f6472gp).m6312a(C1198vr.f6511b.clone().m6800a(false).m6807a(C1312xz.f8610BH).m6824b(C1312xz.f8343wA, C1312xz.f8344wB).m6809b(C1312xz.f8611BI).m6803a(C1312xz.f8612BJ, true).m6818f(C1312xz.f8613BK).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8669CO).m6813d(C1312xz.f8614BL)).m6293a(f7710P).m6302b(false).mo6331b(0.3f).m6397a(GunType.FLAMETHROWER).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6208gb)).m6330f(4).m6305d(false).m6306e(false).m6297a(C0435hX.f2756f).m6292a(new C1197vq(3.5f));
        EnumC1200vt enumC1200vt = EnumC1200vt.AUTO;
        DeferredHolder<EntityType<?>, EntityType<C0737nH>> deferredHolder = C1307xu.f7597kE;
        Objects.requireNonNull(deferredHolder);
        return c1117uPM6292a.m6323a(new C1199vs[]{new C1199vs(enumC1200vt, 2, (Supplier<EntityType<? extends InterfaceC0695mS>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mK */
    public static final DeferredHolder<Item, ? extends C1117uP> f7821mK = f7668a.registerItem("gun_flammenwerfer_34", properties -> {
        C1117uP c1117uPM6292a = ((C1117uP) new C1117uP("gun_flammenwerfer_34", properties).m6325a(15200, 30400).m6351g(118).mo6311a(C1190vj.f6472gp).m6312a(C1198vr.f6511b.clone().m6800a(false).m6807a(C1312xz.f8610BH).m6824b(C1312xz.f8343wA, C1312xz.f8344wB).m6809b(C1312xz.f8611BI).m6803a(C1312xz.f8612BJ, true).m6818f(C1312xz.f8613BK).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8669CO).m6813d(C1312xz.f8614BL)).m6293a(f7709O).m6302b(false).mo6331b(0.3f).m6397a(GunType.FLAMETHROWER).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6208gb)).m6330f(4).m6305d(false).m6306e(false).m6297a(C0435hX.f2756f).m6292a(new C1197vq(3.5f));
        EnumC1200vt enumC1200vt = EnumC1200vt.AUTO;
        DeferredHolder<EntityType<?>, EntityType<C0737nH>> deferredHolder = C1307xu.f7597kE;
        Objects.requireNonNull(deferredHolder);
        return c1117uPM6292a.m6323a(new C1199vs[]{new C1199vs(enumC1200vt, 2, (Supplier<EntityType<? extends InterfaceC0695mS>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mL */
    public static final DeferredHolder<Item, ? extends C1117uP> f7822mL = f7668a.registerItem("gun_colt", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_colt", properties).m6325a(7, 21).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8408xN).m6805a(C1312xz.f8409xO, C1312xz.f8410xP).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6360d(0.5f).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(2.33f, 3.12f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mM */
    public static final DeferredHolder<Item, ? extends C1117uP> f7823mM = f7668a.registerItem("gun_beretta_m1934", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_beretta_m1934", properties).m6325a(7, 21).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8411xQ).m6805a(C1312xz.f8412xR, C1312xz.f8413xS).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(2.33f, 3.12f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mN */
    public static final DeferredHolder<Item, ? extends C1117uP> f7824mN = f7668a.registerItem("gun_fn_model_1910", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_fn_model_1910", properties).m6325a(8, 24).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8414xT).m6805a(C1312xz.f8415xU, C1312xz.f8416xV).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(2.33f, 3.12f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mO */
    public static final DeferredHolder<Item, ? extends C1117uP> f7825mO = f7668a.registerItem("gun_walther_p38", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_walther_p38", properties).m6325a(8, 24).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8447yA).m6805a(C1312xz.f8448yB, C1312xz.f8449yC).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(2.33f, 3.12f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mP */
    public static final DeferredHolder<Item, ? extends C1117uP> f7826mP = f7668a.registerItem("gun_luger", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_luger", properties).m6325a(8, 24).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8450yD).m6805a(C1312xz.f8451yE, C1312xz.f8452yF).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(4.0f, 3.5f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mQ */
    public static final DeferredHolder<Item, ? extends C1117uP> f7827mQ = f7668a.registerItem("gun_mauser_c96", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_mauser_c96", properties).m6325a(10, 30).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8453yG).m6805a(C1312xz.f8454yH, C1312xz.f8455yI).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(5.0f, 4.7f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mR */
    public static final DeferredHolder<Item, ? extends C1117uP> f7828mR = f7668a.registerItem("gun_tokarev_tt33", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_tokarev_tt33", properties).m6325a(8, 24).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8486zn).m6805a(C1312xz.f8487zo, C1312xz.f8488zp).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(2.33f, 3.12f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mS */
    public static final DeferredHolder<Item, ? extends C1117uP> f7829mS = f7668a.registerItem("gun_fb_vis", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_fb_vis", properties).m6325a(8, 24).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8518zT).m6805a(C1312xz.f8519zU, C1312xz.f8520zV).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(2.33f, 3.12f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mT */
    public static final DeferredHolder<Item, ? extends C1117uP> f7830mT = f7668a.registerItem("gun_type14", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_type14", properties).m6325a(6, 18).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8523zY).m6805a(C1312xz.f8524zZ, C1312xz.f8525Aa).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(2.33f, 3.12f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mU */
    public static final DeferredHolder<Item, ? extends C1117uP> f7831mU = f7668a.registerItem("gun_type94", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_type94", properties).m6325a(6, 18).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8526Ab).m6805a(C1312xz.f8527Ac, C1312xz.f8528Ad).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(2.33f, 3.12f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mV */
    public static final DeferredHolder<Item, ? extends C1117uP> f7832mV = f7668a.registerItem("gun_glisenti_model_1910", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_glisenti_model_1910", properties).m6325a(7, 21).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8585Bi).m6805a(C1312xz.f8586Bj, C1312xz.f8587Bk).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6292a(new C1197vq(2.33f, 3.12f)).m6363b("pistol").m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mW */
    public static final DeferredHolder<Item, ? extends C1117uP> f7833mW = f7668a.registerItem("gun_pistolet_automatique_modele_1935a", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_pistolet_automatique_modele_1935a", properties).m6325a(8, 24).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8589Bm).m6805a(C1312xz.f8590Bn, C1312xz.f8591Bo).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(2.33f, 3.12f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mX */
    public static final DeferredHolder<Item, ? extends C1117uP> f7834mX = f7668a.registerItem("gun_browning_hipower", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_browning_hipower", properties).m6325a(13, 39).mo6311a(C1190vj.f6473gq).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8401xG).m6807a(C1312xz.f8632Cd).m6805a(C1312xz.f8633Ce, C1312xz.f8634Cf).m6827i(C1312xz.f8355wM).m6831d(C1312xz.f8309vS, C1312xz.f8316vZ).m6834j(C1312xz.f8317wa).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6870a(1.2f)).m6297a(C0435hX.f2752b).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.4f)).m6396a(C1070tV.f5832k).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh(0.3f, 0.4f)).mo6311a(C1130uc.f6196fP)).m6363b("pistol").m6292a(new C1197vq(2.5f, 3.1f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: mY */
    public static final DeferredHolder<Item, ? extends C1117uP> f7835mY = f7668a.registerItem("gun_bazooka", properties -> {
        C1117uP c1117uP = (C1117uP) new C1117uP("gun_bazooka", properties).m6325a(1, 4).mo6311a(C1190vj.f6472gp).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8403xI).m6807a(C1312xz.f8444yx).m6824b(C1312xz.f8347wE, C1312xz.f8348wF).m6822h(C1312xz.f8274vj).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8386xr)).m6302b(false).mo6331b(0.5f).m6397a(GunType.ROCKET).m6396a(C1070tV.f5829h).m6314f().m6307c().m6297a(C0435hX.f2756f).m6295a(C1188vh.a.DEFAULT, new C1188vh(true, 0.3f, 0.1f, false)).mo6311a(C1130uc.f6205fY);
        EnumC1200vt enumC1200vt = EnumC1200vt.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0731nB>> deferredHolder = C1307xu.f7616kU;
        Objects.requireNonNull(deferredHolder);
        return c1117uP.m6323a(new C1199vs[]{new C1199vs(enumC1200vt, 5, (Supplier<EntityType<? extends InterfaceC0695mS>>) deferredHolder::get)}).m6292a(new C1197vq(3.5f));
    });

    /* JADX INFO: renamed from: mZ */
    public static final DeferredHolder<Item, ? extends C1117uP> f7836mZ = f7668a.registerItem("gun_panzerschreck", properties -> {
        C1117uP c1117uPM6292a = ((C1117uP) new C1117uP("gun_panzerschreck", properties).m6325a(1, 4).mo6311a(C1190vj.f6472gp).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8403xI).m6807a(C1312xz.f8482zj).m6824b(C1312xz.f8347wE, C1312xz.f8348wF).m6822h(C1312xz.f8274vj).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8386xr)).m6302b(false).mo6331b(0.5f).m6397a(GunType.ROCKET).m6396a(C1070tV.f5829h).m6314f().m6307c().m6297a(C0435hX.f2756f).m6295a(C1188vh.a.DEFAULT, new C1188vh(true, 0.3f, 0.1f, false)).mo6311a(C1130uc.f6205fY)).m6292a(new C1197vq(3.5f));
        EnumC1200vt enumC1200vt = EnumC1200vt.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0731nB>> deferredHolder = C1307xu.f7616kU;
        Objects.requireNonNull(deferredHolder);
        return c1117uPM6292a.m6323a(new C1199vs[]{new C1199vs(enumC1200vt, 5, (Supplier<EntityType<? extends InterfaceC0695mS>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: na */
    public static final DeferredHolder<Item, ? extends C1117uP> f7837na = f7668a.registerItem("gun_panzerfaust", properties -> {
        C1117uP c1117uPM6295a = ((C1117uP) new C1117uP("gun_panzerfaust", properties).m6325a(1, 4).mo6311a(C1190vj.f6472gp).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8403xI).m6807a(C1312xz.f8506zH).m6809b(C1312xz.f8507zI).m6824b(C1312xz.f8347wE, C1312xz.f8348wF).m6822h(C1312xz.f8274vj).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8386xr)).m6302b(false).mo6331b(0.5f).m6397a(GunType.ROCKET).m6396a(C1070tV.f5829h).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6205fY)).m6314f().m6307c().m6297a(C0435hX.f2756f).m6356a(new Vector3f(), true).m6292a(new C1197vq(2.75f)).m6295a(C1188vh.a.DEFAULT, new C1188vh(true, 0.3f, 0.1f, false));
        EnumC1200vt enumC1200vt = EnumC1200vt.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0731nB>> deferredHolder = C1307xu.f7616kU;
        Objects.requireNonNull(deferredHolder);
        return c1117uPM6295a.m6323a(new C1199vs[]{new C1199vs(enumC1200vt, 5, (Supplier<EntityType<? extends InterfaceC0695mS>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: nb */
    public static final DeferredHolder<Item, ? extends C1117uP> f7838nb = f7668a.registerItem("gun_piat", properties -> {
        C1117uP c1117uPM6292a = ((C1117uP) new C1117uP("gun_piat", properties).m6325a(1, 4).mo6311a(C1190vj.f6472gp).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8422yb).m6803a(C1312xz.f8423yc, true).m6865w(C1312xz.f8403xI).m6824b(C1312xz.f8347wE, C1312xz.f8348wF).m6822h(C1312xz.f8274vj).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8386xr)).m6302b(false).mo6331b(0.5f).m6397a(GunType.ROCKET).m6396a(C1070tV.f5829h).m6314f().m6307c().m6297a(C0435hX.f2756f).m6295a(C1188vh.a.DEFAULT, new C1188vh(true, 0.3f, 0.1f, false)).mo6311a(C1130uc.f6205fY)).m6356a(new Vector3f(), true).m6292a(new C1197vq(3.5f));
        EnumC1200vt enumC1200vt = EnumC1200vt.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0731nB>> deferredHolder = C1307xu.f7616kU;
        Objects.requireNonNull(deferredHolder);
        return c1117uPM6292a.m6323a(new C1199vs[]{new C1199vs(enumC1200vt, 5, (Supplier<EntityType<? extends InterfaceC0695mS>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: nc */
    public static final DeferredHolder<Item, ? extends C1117uP> f7839nc = f7668a.registerItem("gun_melon_cannon", properties -> {
        C1117uP c1117uPM6292a = ((C1117uP) new C1117uP("gun_melon_cannon", properties).m6325a(1, 32).mo6311a(C1190vj.f6472gp).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8403xI).m6807a(C1312xz.f8446yz).m6809b(C1312xz.f8445yy).m6824b(C1312xz.f8339ww, C1312xz.f8340wx).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8386xr)).m6302b(false).mo6331b(0.5f).m6397a(GunType.ROCKET).m6396a(C1070tV.f5829h).m6314f().m6304c(false).m6305d(false).m6306e(false).m6297a(C0435hX.f2756f).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6205fY)).m6292a(new C1197vq(1.8333f));
        EnumC1200vt enumC1200vt = EnumC1200vt.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0781nz>> deferredHolder = C1307xu.f7618kW;
        Objects.requireNonNull(deferredHolder);
        return c1117uPM6292a.m6323a(new C1199vs[]{new C1199vs(enumC1200vt, 5, (Supplier<EntityType<? extends InterfaceC0695mS>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: nd */
    public static final DeferredHolder<Item, ? extends C1117uP> f7840nd = f7668a.registerItem("gun_kis", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_kis", properties).m6325a(32, 96).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8640Cl).m6824b(C1312xz.f8331wo, C1312xz.f8332wp).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8273vi).m6841m(C1312xz.f8400xF).m6805a(C1312xz.f8641Cm, C1312xz.f8642Cn).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6292a(new C1197vq(2.5f, 4.375f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ne */
    public static final DeferredHolder<Item, ? extends C1117uP> f7841ne = f7668a.registerItem("gun_mp_3008", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_mp_3008", properties).m6325a(32, 96).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8643Co).m6824b(C1312xz.f8331wo, C1312xz.f8332wp).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6820g(C1312xz.f8268vd).m6822h(C1312xz.f8273vi).m6841m(C1312xz.f8400xF).m6805a(C1312xz.f8644Cp, C1312xz.f8645Cq).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6847p(C1312xz.f8295vE).m6837k(C1312xz.f8278vn)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6292a(new C1197vq(2.5f, 4.375f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: nf */
    public static final DeferredHolder<Item, ? extends C1117uP> f7842nf = f7668a.registerItem("gun_winchester_1895", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_winchester_1895", properties).m6325a(5, 20).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8646Cr).m6809b(C1312xz.f8647Cs).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8335ws, C1312xz.f8336wt).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz)).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6198fR)).m6292a(new C1197vq(4.8f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ng */
    public static final DeferredHolder<Item, ? extends C1117uP> f7843ng = f7668a.registerItem("gun_mp41", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_mp41", properties).m6325a(32, 96).mo6311a(C1190vj.f6479gw).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8472yZ).m6824b(C1312xz.f8366wX, C1312xz.f8367wY).m6827i(C1312xz.f8357wO).m6831d(C1312xz.f8311vU, C1312xz.f8320wd).m6841m(C1312xz.f8400xF).m6805a(C1312xz.f8468yV, C1312xz.f8469yW).m6820g(C1312xz.f8264uZ).m6822h(C1312xz.f8273vi).m6858u(C1312xz.f8665CK).m6860v(C1312xz.f8666CL).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6803a(C1312xz.f8470yX, true).m6847p(C1312xz.f8295vE).m6837k(C1312xz.f8278vn)).mo6331b(0.05f).m6397a(GunType.SMG).mo6331b(0.3f)).m6396a(C1070tV.f5822a).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6200fT)).m6363b("smg").m6385a(C1312xz.f8471yY).m6292a(new C1197vq(2.75f, 5.0f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 2), new C1199vs(EnumC1200vt.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: nh */
    public static final DeferredHolder<Item, ? extends C1117uP> f7844nh = f7668a.registerItem("gun_type18_shotgun", properties -> {
        return ((C1117uP) new C1117uP("gun_type18_shotgun", properties).m6325a(1, 18).mo6311a(C1190vj.f6486gD).m6329e(64).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8402xH).m6807a(C1312xz.f8554AD).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8333wq, C1312xz.f8334wr).m6841m(C1312xz.f8399xE).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8290vz).m6803a(C1312xz.f8555AE, true)).m6297a(C0435hX.f2753c).mo6331b(0.2f).m6397a(GunType.SHOTGUN).m6396a(C1070tV.f5831j).m6363b("shell").m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6207ga)).m6292a(new C1196vp(2.0f, 0.58f, 1.25f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz, f7657vy).m6880a(f7658b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: ni */
    public static final DeferredHolder<Item, ? extends C1117uP> f7845ni = f7668a.registerItem("gun_de_lisle_carbine", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_de_lisle_carbine", properties).m6325a(11, 33).mo6311a(C1190vj.f6476gt).m6312a(C1198vr.f6511b.clone().m6870a(1.5f).m6807a(C1312xz.f8568AR).m6824b(C1312xz.f8349wG, C1312xz.f8350wH).m6827i(C1312xz.f8356wN).m6831d(C1312xz.f8310vT, C1312xz.f8318wb).m6834j(C1312xz.f8319wc).m6841m(C1312xz.f8399xE).m6809b(C1312xz.f8570AT).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8667CM).m6827i(null).m6831d(null, null).m6839l(null).m6820g(null).m6822h(null)).m6304c(false).m6297a(C0435hX.f2753c).mo6331b(0.15f).m6397a(GunType.RIFLE).mo6331b(0.25f)).m6396a(C1070tV.f5824c).m6295a(C1188vh.a.DEFAULT, new C1188vh()).m6295a(C1188vh.a.SCOPE, new C1188vh(true, 0.8f, "scope_kar98k", false).m6763a(0.5f)).mo6311a(C1130uc.f6198fR)).m6292a(new C1197vq(3.75f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, f7659vz)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: nj */
    public static final DeferredHolder<Item, ? extends C1117uP> f7846nj = f7668a.registerItem("gun_browning_a5", properties -> {
        return ((C1117uP) new C1117uP("gun_browning_a5", properties).m6325a(5, 15).mo6311a(C1190vj.f6486gD).m6329e(64).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8463yQ).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8333wq, C1312xz.f8334wr).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8381xm, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8288vx).m6813d(C1312xz.f8671CQ).m6870a(0.95f)).m6297a(C0435hX.f2753c).mo6331b(0.2f).m6397a(GunType.SHOTGUN).m6396a(C1070tV.f5831j).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6207ga)).m6363b("shell").m6292a(new C1196vp(0.83f, 0.75f, 1.5f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 6, f7657vy).m6880a(f7658b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: nk */
    public static final DeferredHolder<Item, ? extends C1117uP> f7847nk = f7668a.registerItem("gun_type4_70mm", properties -> {
        C1117uP c1117uP = (C1117uP) new C1117uP("gun_type4_70mm", properties).m6325a(1, 4).mo6311a(C1190vj.f6472gp).m6312a(C1198vr.f6511b.clone().m6865w(C1312xz.f8403xI).m6807a(C1312xz.f8444yx).m6824b(C1312xz.f8347wE, C1312xz.f8348wF).m6822h(C1312xz.f8274vj).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8386xr)).m6332h().m6302b(false).mo6331b(0.5f).m6397a(GunType.ROCKET).m6396a(C1070tV.f5829h).m6314f().m6307c().m6297a(C0435hX.f2756f).m6295a(C1188vh.a.DEFAULT, new C1188vh(true, 0.3f, 0.1f, false)).mo6311a(C1130uc.f6205fY);
        EnumC1200vt enumC1200vt = EnumC1200vt.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0731nB>> deferredHolder = C1307xu.f7616kU;
        Objects.requireNonNull(deferredHolder);
        return c1117uP.m6323a(new C1199vs[]{new C1199vs(enumC1200vt, 5, (Supplier<EntityType<? extends InterfaceC0695mS>>) deferredHolder::get)}).m6292a(new C1197vq(3.5f));
    });

    /* JADX INFO: renamed from: nl */
    public static final DeferredHolder<Item, ? extends C1117uP> f7848nl = f7668a.registerItem("gun_wz_35", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_wz_35", properties).m6325a(4, 4).mo6290a(0.2f)).m6360d(2.0f).mo6311a(C1190vj.f6483gA).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8648Ct).m6803a(C1312xz.f8650Cv, true).m6809b(C1312xz.f8649Cu).m6820g(C1312xz.f8266vb).m6822h(C1312xz.f8272vh).m6824b(C1312xz.f8337wu, C1312xz.f8338wv).m6858u(C1312xz.f8663CI).m6860v(C1312xz.f8664CJ).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6839l(C1312xz.f8385xq).m6847p(C1312xz.f8293vC).m6843n(C1312xz.f8288vx).m6867x(C1312xz.f8248uJ).m6870a(0.95f)).m6302b(false).m6297a(C0435hX.f2758h).m6332h().mo6331b(0.4f).m6397a(GunType.AT).mo6331b(0.1f)).m6396a(C1070tV.f5830i).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6206fZ)).m6292a(new C1197vq(4.25f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: nm */
    public static final DeferredHolder<Item, ? extends C1117uP> f7849nm = f7668a.registerItem("gun_flak38", properties -> {
        return ((C1117uP) ((C1117uP) ((C1117uP) new C1117uP("gun_flak38", properties).m6325a(20, 60).mo6311a(C1190vj.f6483gA).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8651Cw).m6804a(C1312xz.f8652Cx, false, 1).m6805a(C1312xz.f8433ym, C1312xz.f8434yn).m6820g(C1312xz.f8260uV).m6822h(C1312xz.f8270vf).m6824b(C1312xz.f8345wC, C1312xz.f8346wD).m6827i(C1312xz.f8354wL).m6831d(C1312xz.f8308vR, C1312xz.f8314vX).m6834j(C1312xz.f8315vY).m6858u(C1312xz.f8661CG).m6860v(C1312xz.f8662CH).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6813d(C1312xz.f8668CN).m6845o(C1312xz.f8286vv).m6870a(0.95f)).m6286a(new Vec3(1.0d, -0.30000001192092896d, -0.30000001192092896d), new Vec3(0.0d, -0.25d, 0.0d)).m6360d(0.75f).mo6290a(0.5f)).mo6331b(0.25f).m6397a(GunType.LMG).mo6331b(0.2f)).m6396a(C1070tV.f5828g).m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6202fV)).m6363b("mg").m6292a(new C1197vq(3.5f, 5.25f)).m6332h().m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.AUTO, 4), new C1199vs(EnumC1200vt.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    /* JADX INFO: renamed from: nn */
    public static final DeferredHolder<Item, ? extends C1117uP> f7850nn = f7668a.registerItem("gun_nagant_m1895", properties -> {
        return ((C1117uP) ((C1117uP) new C1117uP("gun_nagant_m1895", properties).m6325a(7, 21).mo6311a(C1190vj.f6474gr).m6312a(C1198vr.f6511b.clone().m6807a(C1312xz.f8559AI).m6815e(C1312xz.f8297vG).m6804a(C1312xz.f8560AJ, true, 1).m6809b(C1312xz.f8561AK).m6820g(C1312xz.f8265va).m6822h(C1312xz.f8271vg).m6858u(C1312xz.f8659CE).m6860v(C1312xz.f8660CF).m6802a(C1312xz.f8376xh, C1312xz.f8378xj, C1312xz.f8379xk, C1312xz.f8377xi, C1312xz.f8380xl).m6824b(C1312xz.f8358wP, C1312xz.f8359wQ).m6841m(C1312xz.f8398xD).m6839l(C1312xz.f8384xp).m6843n(C1312xz.f8289vy).m6813d(C1312xz.f8670CP).m6865w(C1312xz.f8405xK).m6870a(1.2f)).m6297a(C0435hX.f2752b).m6299a(true).mo6331b(0.025f).m6397a(GunType.PISTOL).mo6331b(0.35f)).m6396a(C1070tV.f5834m).m6297a(C0435hX.f2757g).m6313e().m6309d().m6295a(C1188vh.a.DEFAULT, new C1188vh()).mo6311a(C1130uc.f6197fQ)).m6363b("pistol").m6292a(new C1197vq(11.1f)).m6323a(new C1199vs[]{new C1199vs(EnumC1200vt.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1136ui.m6530a()));

    static {
        for (DeferredHolder deferredHolder : C1295xi.f6988b.getEntries()) {
            f7668a.register(deferredHolder.getId().getPath(), () -> {
                return new BlockItem((Block) deferredHolder.get(), new Item.Properties());
            });
        }
        for (DeferredHolder deferredHolder2 : C1295xi.f6989c.getEntries()) {
            f7668a.register(deferredHolder2.getId().getPath(), () -> {
                return new BlockItem((Block) deferredHolder2.get(), new Item.Properties());
            });
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Optional<Item> m8000a(@NotNull CloudResourceLocation cloudResourceLocation) {
        return m8001a(ResourceLocation.fromNamespaceAndPath(cloudResourceLocation.namespace(), cloudResourceLocation.path()));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Optional<Item> m8001a(@NotNull ResourceLocation resourceLocation) {
        return BuiltInRegistries.ITEM.getOptional(resourceLocation);
    }
}
