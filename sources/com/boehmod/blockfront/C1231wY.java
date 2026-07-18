package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import com.boehmod.bflib.cloud.common.player.challenge.GunType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C1108uH;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wY.class */
public class C1231wY {

    /* JADX INFO: renamed from: oo */
    private static final float f7081oo = 0.025f;

    /* JADX INFO: renamed from: op */
    private static final float f7082op = 0.05f;

    /* JADX INFO: renamed from: oq */
    private static final float f7083oq = 0.1f;

    /* JADX INFO: renamed from: or */
    private static final float f7084or = 0.15f;

    /* JADX INFO: renamed from: os */
    private static final float f7085os = 0.2f;

    /* JADX INFO: renamed from: ot */
    private static final float f7086ot = 0.25f;

    /* JADX INFO: renamed from: ou */
    private static final float f7087ou = 0.3f;

    /* JADX INFO: renamed from: ov */
    private static final float f7088ov = 0.35f;

    /* JADX INFO: renamed from: ow */
    private static final float f7089ow = 0.4f;

    /* JADX INFO: renamed from: ox */
    private static final float f7090ox = 0.5f;

    /* JADX INFO: renamed from: tt */
    private static final int f7091tt = 64;

    /* JADX INFO: renamed from: tu */
    private static final int f7092tu = 14;

    /* JADX INFO: renamed from: tv */
    private static final int f7094tv = 22;

    /* JADX INFO: renamed from: tw */
    private static final int f7095tw = 4;

    /* JADX INFO: renamed from: tx */
    private static final int f7096tx = 30;

    /* JADX INFO: renamed from: ty */
    private static final int f7097ty = 10;

    /* JADX INFO: renamed from: tz */
    private static final int f7098tz = 2;

    /* JADX INFO: renamed from: tA */
    private static final int f7099tA = 4;

    /* JADX INFO: renamed from: tB */
    private static final int f7100tB = 5;

    /* JADX INFO: renamed from: oy */
    private static final float f7101oy = 0.5f;

    /* JADX INFO: renamed from: oz */
    private static final float f7102oz = 2.5f;

    /* JADX INFO: renamed from: oA */
    private static final float f7228oA = 3.0f;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final C1122uV f7093b = C1122uV.m6230a(C0564jv.m2555d("shotgun_14_pellet"));

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final DeferredRegister.Items f7103a = DeferredRegister.createItems("bf");

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final Object2ObjectMap<String, C1058tK> f7104f = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: b */
    public static final DeferredItem<? extends Item> f7105b = f7103a.registerItem("booster_item_emeralds_x2", properties -> {
        return new C1057tJ("booster_item_emeralds_x2", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: c */
    public static final DeferredItem<? extends Item> f7106c = f7103a.registerItem("booster_item_emeralds_x3", properties -> {
        return new C1057tJ("booster_item_emeralds_x3", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: d */
    public static final DeferredItem<? extends Item> f7107d = f7103a.registerItem("booster_item_emeralds_x4", properties -> {
        return new C1057tJ("booster_item_emeralds_x4", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: e */
    public static final DeferredItem<? extends Item> f7108e = f7103a.registerItem("booster_item_emeralds_x5", properties -> {
        return new C1057tJ("booster_item_emeralds_x5", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: f */
    public static final DeferredItem<? extends Item> f7109f = f7103a.registerItem("booster_item_exp_x2", properties -> {
        return new C1057tJ("booster_item_exp_x2", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: g */
    public static final DeferredItem<? extends Item> f7110g = f7103a.registerItem("booster_item_exp_x3", properties -> {
        return new C1057tJ("booster_item_exp_x3", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: h */
    public static final DeferredItem<? extends Item> f7111h = f7103a.registerItem("booster_item_exp_x4", properties -> {
        return new C1057tJ("booster_item_exp_x4", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: i */
    public static final DeferredItem<? extends Item> f7112i = f7103a.registerItem("booster_item_exp_x5", properties -> {
        return new C1057tJ("booster_item_exp_x5", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: j */
    public static final DeferredItem<? extends Item> f7113j = f7103a.registerItem("case_item_common", properties -> {
        return new C1057tJ("case_item_common", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: k */
    public static final DeferredItem<? extends Item> f7114k = f7103a.registerItem("key_item_common", properties -> {
        return new C1057tJ("key_item_common", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: l */
    public static final DeferredItem<? extends Item> f7115l = f7103a.registerItem("gui_logo", properties -> {
        return new C1095tv("gui_logo", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: m */
    public static final DeferredItem<? extends Item> f7116m = f7103a.registerItem("bomb_defuse_kit", properties -> {
        return new C1067tT("bomb_defuse_kit", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: n */
    public static final DeferredItem<? extends Item> f7117n = f7103a.registerItem(C1230wX.f6993dT, properties -> {
        return new C1068tU(C1230wX.f6993dT, properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: o */
    public static final DeferredItem<? extends Item> f7118o = f7103a.registerItem("radio", properties -> {
        return new C1129uc("radio", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: p */
    public static final DeferredItem<? extends Item> f7119p = f7103a.registerItem("medic_bag", properties -> {
        return new C1073tZ("medic_bag", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: q */
    public static final DeferredItem<? extends Item> f7120q = f7103a.registerItem(C1230wX.f6991dR, properties -> {
        return new C1065tR(C1230wX.f6991dR, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: r */
    public static final DeferredItem<? extends Item> f7121r = f7103a.registerItem("medical_syringe", properties -> {
        return new C1127ua("medical_syringe", properties);
    }, new Item.Properties().stacksTo(8).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: s */
    public static final DeferredItem<? extends Item> f7122s = f7103a.registerItem("adrenaline_syringe", properties -> {
        return new C1064tQ("adrenaline_syringe", properties);
    }, new Item.Properties().stacksTo(8).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: t */
    public static final DeferredItem<? extends Item> f7123t = f7103a.registerItem(C1230wX.f6992dS, properties -> {
        return new C1071tX(C1230wX.f6992dS, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: u */
    public static final DeferredItem<? extends Item> f7124u = f7103a.registerItem(C1230wX.f7012em, properties -> {
        return new C1093tt(C1230wX.f7012em, properties);
    }, new Item.Properties().stacksTo(16).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: v */
    public static final DeferredItem<? extends Item> f7125v = f7103a.registerItem("magnifying_glass", properties -> {
        return new C1072tY("magnifying_glass", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: w */
    public static final DeferredItem<? extends Item> f7126w = f7103a.registerItem("super_happy_fun_bomb", properties -> {
        return new C1131ue("super_happy_fun_bomb", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: x */
    public static final DeferredItem<? extends Item> f7127x = f7103a.registerItem("randomat", properties -> {
        return new C1130ud("randomat", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: y */
    public static final DeferredItem<? extends Item> f7128y = f7103a.registerItem("binoculars", C1094tu::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: z */
    public static final DeferredItem<? extends Item> f7129z = f7103a.registerItem("map_effect_wand", C1055tH::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: A */
    public static final DeferredItem<? extends Item> f7130A = f7103a.registerItem("map_effect_creator_wand", C1053tF::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: B */
    public static final DeferredItem<? extends Item> f7131B = f7103a.registerItem("map_effect_rotation_wand", C1054tG::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: C */
    public static final DeferredItem<? extends Item> f7132C = f7103a.registerItem("region_wand", C1061tN::new, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: D */
    public static final DeferredItem<? extends Item> f7133D = f7103a.registerItem("event_trophy_gold", properties -> {
        return new C1057tJ("event_trophy_gold", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: E */
    public static final DeferredItem<? extends Item> f7134E = f7103a.registerItem("event_trophy_silver", properties -> {
        return new C1057tJ("event_trophy_silver", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: F */
    public static final DeferredItem<? extends Item> f7135F = f7103a.registerItem("event_trophy_bronze", properties -> {
        return new C1057tJ("event_trophy_bronze", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: G */
    public static final DeferredItem<? extends Item> f7136G = f7103a.registerItem("prestige_card_1", properties -> {
        return new C1057tJ("prestige_card_1", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: H */
    public static final DeferredItem<? extends Item> f7137H = f7103a.registerItem("prestige_card_2", properties -> {
        return new C1057tJ("prestige_card_2", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: I */
    public static final DeferredItem<? extends Item> f7138I = f7103a.registerItem("prestige_card_3", properties -> {
        return new C1057tJ("prestige_card_3", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: J */
    public static final DeferredItem<? extends Item> f7139J = f7103a.registerItem("prestige_card_4", properties -> {
        return new C1057tJ("prestige_card_4", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: K */
    public static final DeferredItem<? extends Item> f7140K = f7103a.registerItem("prestige_card_5", properties -> {
        return new C1057tJ("prestige_card_5", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: L */
    public static final DeferredItem<? extends Item> f7141L = f7103a.registerItem("prestige_card_6", properties -> {
        return new C1057tJ("prestige_card_6", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: M */
    public static final DeferredItem<? extends Item> f7142M = f7103a.registerItem("flag_item_japan", properties -> {
        return new C1069tV("flag_item_japan", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: N */
    public static final DeferredItem<? extends Item> f7143N = f7103a.registerItem("flag_item_ussr", properties -> {
        return new C1069tV("flag_item_ussr", properties);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: O */
    public static final DeferredItem<? extends C1146ut> f7144O = f7103a.registerItem("chest_flammenwerfer_34", properties -> {
        return new C1146ut("chest_flammenwerfer_34", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, true).m6426a(C1280xc.f7777tA, true);
    });

    /* JADX INFO: renamed from: P */
    public static final DeferredItem<? extends C1146ut> f7145P = f7103a.registerItem("chest_m2_flamethrower", properties -> {
        return new C1146ut("chest_m2_flamethrower", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, true).m6426a(C1280xc.f7777tA, true);
    });

    /* JADX INFO: renamed from: Q */
    public static final DeferredItem<? extends C1146ut> f7146Q = f7103a.registerItem("chest_us_commander", properties -> {
        return new C1146ut("chest_us_commander", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, false).m6426a(C1280xc.f7779tC, false);
    });

    /* JADX INFO: renamed from: R */
    public static final DeferredItem<? extends C1146ut> f7147R = f7103a.registerItem("chest_us_support", properties -> {
        return new C1146ut("chest_us_support", ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, properties, false);
    });

    /* JADX INFO: renamed from: S */
    public static final DeferredItem<? extends Item> f7148S = f7103a.registerItem("grenade_flashbang", properties -> {
        return new C1135ui("grenade_flashbang", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: T */
    public static final DeferredItem<? extends Item> f7149T = f7103a.registerItem(C1230wX.f6988dO, properties -> {
        return new C1133ug(C1230wX.f6988dO, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: U */
    public static final DeferredItem<? extends Item> f7150U = f7103a.registerItem(C1230wX.f6985dL, properties -> {
        return new C1139um(C1230wX.f6985dL, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: V */
    public static final DeferredItem<? extends Item> f7151V = f7103a.registerItem("grenade_smoke_stielhandgranate", properties -> {
        return new C1139um("grenade_smoke_stielhandgranate", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: W */
    public static final DeferredItem<? extends Item> f7152W = f7103a.registerItem(C1230wX.f6986dM, properties -> {
        return new C1134uh(C1230wX.f6986dM, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: X */
    public static final DeferredItem<? extends Item> f7153X = f7103a.registerItem("grenade_frag_mk2", properties -> {
        return new C1136uj("grenade_frag_mk2", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: Y */
    public static final DeferredItem<? extends Item> f7154Y = f7103a.registerItem("grenade_frag_rgd33", properties -> {
        return new C1136uj("grenade_frag_rgd33", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: Z */
    public static final DeferredItem<? extends Item> f7155Z = f7103a.registerItem("grenade_smoke_rgd2", properties -> {
        return new C1139um("grenade_smoke_rgd2", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: aa */
    public static final DeferredItem<? extends Item> f7156aa = f7103a.registerItem("grenade_frag_wz24", properties -> {
        return new C1136uj("grenade_frag_wz24", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ab */
    public static final DeferredItem<? extends Item> f7157ab = f7103a.registerItem("grenade_frag_type97", properties -> {
        return new C1136uj("grenade_frag_type97", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ac */
    public static final DeferredItem<? extends Item> f7158ac = f7103a.registerItem("grenade_smoke_type94", properties -> {
        return new C1139um("grenade_smoke_type94", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ad */
    public static final DeferredItem<? extends Item> f7159ad = f7103a.registerItem("grenade_frag_stielhandgranate", properties -> {
        return new C1136uj("grenade_frag_stielhandgranate", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ae */
    public static final DeferredItem<? extends Item> f7160ae = f7103a.registerItem(C1230wX.f6989dP, properties -> {
        return new C1137uk(C1230wX.f6989dP, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: af */
    public static final DeferredItem<? extends Item> f7161af = f7103a.registerItem("grenade_frag_srcm_mod_35", properties -> {
        return new C1136uj("grenade_frag_srcm_mod_35", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ag */
    public static final DeferredItem<? extends Item> f7162ag = f7103a.registerItem("grenade_smoke_breda_mod_42", properties -> {
        return new C1139um("grenade_smoke_breda_mod_42", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ah */
    public static final DeferredItem<? extends Item> f7163ah = f7103a.registerItem("grenade_frag_f1", properties -> {
        return new C1136uj("grenade_frag_f1", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ai */
    public static final DeferredItem<? extends Item> f7164ai = f7103a.registerItem("grenade_smoke_fumigene_mle_1916", properties -> {
        return new C1139um("grenade_smoke_fumigene_mle_1916", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: aj */
    public static final DeferredItem<? extends Item> f7165aj = f7103a.registerItem("grenade_frag_millsbomb", properties -> {
        return new C1136uj("grenade_frag_millsbomb", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ak */
    public static final DeferredItem<? extends Item> f7166ak = f7103a.registerItem(C1230wX.f6987dN, properties -> {
        return new C1138ul(C1230wX.f6987dN, properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: al */
    public static final DeferredItem<? extends Item> f7167al = f7103a.registerItem("grenade_smoke_no77", properties -> {
        return new C1139um("grenade_smoke_no77", properties);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: am */
    public static final DeferredItem<? extends Item> f7168am = f7103a.registerItem("grenade_at_et_wz_38", properties -> {
        return new C1136uj("grenade_at_et_wz_38", properties).m6255a(1.0f).m6257b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: an */
    public static final DeferredItem<? extends Item> f7169an = f7103a.registerItem("grenade_at_hafthohlladung", properties -> {
        return new C1136uj("grenade_at_hafthohlladung", properties).m6255a(1.0f).m6257b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ao */
    public static final DeferredItem<? extends Item> f7170ao = f7103a.registerItem("grenade_at_no82_gammon_bomb", properties -> {
        return new C1136uj("grenade_at_no82_gammon_bomb", properties).m6255a(1.0f).m6257b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ap */
    public static final DeferredItem<? extends Item> f7171ap = f7103a.registerItem("grenade_at_rpg_43", properties -> {
        return new C1136uj("grenade_at_rpg_43", properties).m6255a(1.0f).m6257b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: aq */
    public static final DeferredItem<? extends Item> f7172aq = f7103a.registerItem("grenade_at_type_3", properties -> {
        return new C1136uj("grenade_at_type_3", properties).m6255a(1.0f).m6257b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ar */
    public static final DeferredItem<? extends Item> f7173ar = f7103a.registerItem("grenade_at_type_l", properties -> {
        return new C1136uj("grenade_at_type_l", properties).m6255a(1.0f).m6257b(4.0f);
    }, new Item.Properties().stacksTo(4).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: as */
    public static final DeferredItem<? extends Item> f7174as = f7103a.registerItem("melee_item_knife_m1905", properties -> {
        return new C1056tI("melee_item_knife_m1905", properties).m5888a(1);
    });

    /* JADX INFO: renamed from: at */
    public static final DeferredItem<? extends Item> f7175at = f7103a.registerItem("melee_item_klappspaten", properties -> {
        return new C1056tI("melee_item_klappspaten", properties).m5889a(C1280xc.f8243Cy).m5890a(C0418hH.f2688E).mo5947a(0.05f);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: au */
    public static final DeferredItem<? extends Item> f7176au = f7103a.registerItem("melee_item_sword_shin_gunto", properties -> {
        return new C1056tI("melee_item_sword_shin_gunto", properties).m5889a(C1280xc.f8244Cz).m5890a(C0418hH.f2689F);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: av */
    public static final DeferredItem<? extends Item> f7177av = f7103a.registerItem("melee_item_knife_m1938", properties -> {
        return new C1056tI("melee_item_knife_m1938", properties).m5888a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: aw */
    public static final DeferredItem<? extends Item> f7178aw = f7103a.registerItem("melee_item_knife_wz_27", properties -> {
        return new C1056tI("melee_item_knife_wz_27", properties).m5888a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ax */
    public static final DeferredItem<? extends Item> f7179ax = f7103a.registerItem("melee_item_knife_m1940", properties -> {
        return new C1056tI("melee_item_knife_m1940", properties).m5888a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ay */
    public static final DeferredItem<? extends Item> f7180ay = f7103a.registerItem("melee_item_knife_m1886", properties -> {
        return new C1056tI("melee_item_knife_m1886", properties).m5888a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: az */
    public static final DeferredItem<? extends Item> f7181az = f7103a.registerItem("melee_item_knife_fairbairn_sykes", properties -> {
        return new C1056tI("melee_item_knife_fairbairn_sykes", properties).m5888a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: aA */
    public static final DeferredItem<? extends Item> f7182aA = f7103a.registerItem("melee_item_knife_type30", properties -> {
        return new C1056tI("melee_item_knife_type30", properties).m5888a(1);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: aB */
    public static final DeferredItem<? extends Item> f7183aB = f7103a.registerItem("melee_item_wrench", properties -> {
        return new C1056tI("melee_item_wrench", properties).m5889a(C1280xc.f8245CA).m5890a(C0418hH.f2690G).mo5947a(0.05f);
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lv */
    public static final DeferredHolder<Item, ? extends C1144ur> f7184lv = f7103a.registerItem("gun_tokarev_avt40", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_tokarev_avt40", properties).m6352a(20, 60).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8103zO).m6156b(C1280xc.f8104zP).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7928wv, C1280xc.f7929ww).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6160d(C1280xc.f8254CJ)).m6330a(C0418hH.f2662e).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.6f, "scope_tokarev_avt40", false).m6110a(0.5f)).mo5934a(C1052tE.f5561fU)).m6325a(new C1117uQ(2.75f, 2.75f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lw */
    public static final DeferredHolder<Item, ? extends C1144ur> f7185lw = f7103a.registerItem("gun_tokarev_svt40", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_tokarev_svt40", properties).m6352a(10, 30).mo5934a(C1110uJ.f5838gu).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8103zO).m6156b(C1280xc.f8104zP).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7928wv, C1280xc.f7929ww).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6160d(C1280xc.f8254CJ)).m6330a(C0418hH.f2661d).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.6f, "scope_tokarev_avt40", false).m6110a(0.5f)).mo5934a(C1052tE.f5561fU)).m6325a(new C1117uQ(2.75f, 2.75f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lx */
    public static final DeferredHolder<Item, ? extends C1144ur> f7186lx = f7103a.registerItem("gun_type92", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_type92", properties).m6352a(16, 192).mo5934a(C1110uJ.f5846gC).m6395a(C1112uL.f5852c).m6397a(C1114uN.f5861c).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8124Aj).m6171b(C1280xc.f7930wx, C1280xc.f7931wy).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6169h(C1280xc.f7862vh).m6156b(C1280xc.f8125Ak).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8089zA, true).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8256CL).m6217a(0.95f)).m6385d(0.5f).mo5948b(0.35f).m6419a(GunType.MG).mo5948b(0.15f)).m6418a(C1097tx.f5773e).mo5947a(2.5f).m6324a(EnumC1147uu.NO_BIPOD_ONLY).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5564fX)).m6388b("mg").m6409a(C1280xc.f8126Al).m6403a(new Vector3f(0.4f, 0.0f, 0.0f)).m6325a(new C1117uQ(6.0f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 5), new C1119uS(EnumC1120uT.SEMI, 5)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ly */
    public static final DeferredHolder<Item, ? extends C1144ur> f7187ly = f7103a.registerItem("gun_welrod", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_welrod", properties).m6352a(8, 24).mo5934a(C1110uJ.f5836gs).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8215BW).m6156b(C1280xc.f8217BY).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6150a(C1280xc.f8216BX, true).m6217a(1.2f)).m6385d(0.5f).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6409a(C1280xc.f8218BZ).m6337c(false).m6325a(new C1117uQ(3.75f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 32)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lz */
    public static final DeferredHolder<Item, ? extends C1144ur> f7188lz = f7103a.registerItem("gun_brownbess", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_brownbess", properties).m6352a(1, 16).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8222Cd).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7938wF, C1280xc.f7939wG).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6156b(null).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw).m6150a(C1280xc.f8223Ce, true)).m6330a(C0418hH.f2660c).m6341a(ColorReferences.COLOR_WHITE_SOLID, -1.0f).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5559fS)).m6325a(new C1117uQ(8.4f, 8.4f)).m6355f().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 40)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lA */
    public static final DeferredHolder<Item, ? extends C1144ur> f7189lA = f7103a.registerItem("gun_browning30", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_browning30", properties).m6352a(150, 600).mo5934a(C1110uJ.f5845gB).m6395a(C1112uL.f5852c).m6397a(C1114uN.f5861c).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8024yn).m6171b(C1280xc.f7930wx, C1280xc.f7931wy).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6156b(C1280xc.f8025yo).m6167g(C1280xc.f7848uT).m6169h(C1280xc.f7862vh).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8089zA, true).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8256CL).m6192o(C1280xc.f7871vq).m6217a(0.95f)).m6385d(1.0f).mo5948b(0.35f).m6419a(GunType.MG).mo5948b(0.15f)).m6418a(C1097tx.f5773e).mo5947a(2.5f).m6324a(EnumC1147uu.NO_BIPOD_ONLY).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5564fX)).m6388b("mg").m6325a(new C1117uQ(10.0f)).mo5947a(0.35f)).m6382a(new Vector3f(), true).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lB */
    public static final DeferredHolder<Item, ? extends C1144ur> f7190lB = f7103a.registerItem("gun_mg42", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_mg42", properties).m6352a(250, 250).mo5934a(C1110uJ.f5845gB).m6395a(C1112uL.f5852c).m6397a(C1114uN.f5861c).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8066zd).m6171b(C1280xc.f7916wj, C1280xc.f7917wk).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6156b(C1280xc.f8067ze).m6167g(C1280xc.f7850uV).m6169h(C1280xc.f7862vh).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8068zf, true).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8256CL).m6192o(C1280xc.f7874vt).m6210a(C1280xc.f7815um, C1280xc.f7816un, 0.4f)).m6385d(0.75f).mo5948b(0.35f).m6419a(GunType.MG).mo5948b(0.15f)).m6418a(C1097tx.f5774f).mo5947a(2.5f).m6324a(EnumC1147uu.NO_BIPOD_ONLY).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5565fY)).m6388b("mg").mo5947a(0.7f)).m6325a(new C1117uQ(7.7f)).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lC */
    public static final DeferredHolder<Item, ? extends C1144ur> f7191lC = f7103a.registerItem("gun_vickers_k", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_vickers_k", properties).m6352a(100, 300).mo5934a(C1110uJ.f5845gB).m6395a(C1112uL.f5852c).m6397a(C1114uN.f5861c).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8158AR).m6171b(C1280xc.f7930wx, C1280xc.f7931wy).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6169h(C1280xc.f7862vh).m6156b(C1280xc.f8159AS).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8068zf, true).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8256CL).m6192o(C1280xc.f7871vq).m6217a(0.95f)).mo5948b(0.35f).m6419a(GunType.MG).mo5948b(0.15f)).m6418a(C1097tx.f5773e).mo5947a(2.5f).m6324a(EnumC1147uu.NO_BIPOD_ONLY).mo5947a(0.4f)).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5564fX)).m6388b("mg").m6325a(new C1117uQ(4.1667f)).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lD */
    public static final DeferredHolder<Item, ? extends C1144ur> f7192lD = f7103a.registerItem("gun_fiat_revelli", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_fiat_revelli", properties).m6352a(150, 300).mo5934a(C1110uJ.f5845gB).m6395a(C1112uL.f5852c).m6397a(C1114uN.f5861c).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8170Bd).m6171b(C1280xc.f7930wx, C1280xc.f7931wy).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6169h(C1280xc.f7862vh).m6156b(C1280xc.f8025yo).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8089zA, true).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8256CL).m6192o(C1280xc.f7871vq).m6217a(0.95f)).mo5948b(0.35f).m6419a(GunType.MG).mo5948b(0.15f)).m6418a(C1097tx.f5773e).mo5947a(2.5f).m6324a(EnumC1147uu.NO_BIPOD_ONLY).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5564fX)).m6388b("smg").m6325a(new C1117uQ(3.9f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lE */
    public static final DeferredHolder<Item, ? extends C1144ur> f7193lE = f7103a.registerItem("gun_mac_mle_1931", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_mac_mle_1931", properties).m6352a(150, 300).mo5934a(C1110uJ.f5845gB).m6395a(C1112uL.f5852c).m6397a(C1114uN.f5861c).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8179Bm).m6171b(C1280xc.f7930wx, C1280xc.f7931wy).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6169h(C1280xc.f7862vh).m6156b(C1280xc.f8180Bn).m6150a(C1280xc.f8181Bo, true).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8256CL).m6192o(C1280xc.f7871vq).m6217a(0.95f)).mo5948b(0.35f).m6419a(GunType.MG).mo5948b(0.15f)).m6418a(C1097tx.f5773e).mo5947a(2.5f).m6324a(EnumC1147uu.NO_BIPOD_ONLY).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5564fX)).m6325a(new C1117uQ(6.3f)).m6388b("mg").m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lF */
    public static final DeferredHolder<Item, ? extends C1144ur> f7194lF = f7103a.registerItem("gun_lewisgun", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_lewisgun", properties).m6352a(97, Token.SQSTRING).mo5934a(C1110uJ.f5845gB).m6395a(C1112uL.f5852c).m6397a(C1114uN.f5861c).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8213BU).m6171b(C1280xc.f7951wS, C1280xc.f7952wT).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6169h(C1280xc.f7862vh).m6156b(C1280xc.f8214BV).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8068zf, true).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8256CL).m6192o(C1280xc.f7871vq).m6217a(0.95f)).mo5948b(0.35f).m6419a(GunType.MG).mo5948b(0.15f)).m6418a(C1097tx.f5773e).mo5947a(2.5f).m6324a(EnumC1147uu.NO_BIPOD_ONLY).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5564fX)).m6388b("mg").m6358g().m6325a(new C1117uQ(7.0f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lG */
    public static final DeferredHolder<Item, ? extends C1144ur> f7195lG = f7103a.registerItem("gun_bar", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_bar", properties).m6352a(20, 60).mo5934a(C1110uJ.f5843gz).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8019yi).m6150a(C1280xc.f8022yl, true).m6152a(C1280xc.f8020yj, C1280xc.f8021yk).m6167g(C1280xc.f7847uS).m6169h(C1280xc.f7857vc).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8255CK).m6192o(C1280xc.f7873vs).m6217a(0.95f)).m6385d(0.75f).mo5947a(0.5f)).mo5948b(0.25f).m6419a(GunType.LMG).mo5948b(0.2f)).m6418a(C1097tx.f5775g).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5563fW)).m6388b("mg").m6325a(new C1117uQ(3.5f, 5.25f)).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lH */
    public static final DeferredHolder<Item, ? extends C1144ur> f7196lH = f7103a.registerItem("gun_dp28", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_dp28", properties).m6352a(47, 141).mo5934a(C1110uJ.f5843gz).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8079zq).m6156b(C1280xc.f8080zr).m6167g(C1280xc.f7847uS).m6169h(C1280xc.f7857vc).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8057yU, true).m6192o(C1280xc.f7873vs).m6217a(0.95f)).m6385d(1.0f).m6325a(new C1117uQ(4.0f)).mo5948b(0.25f).m6419a(GunType.LMG).mo5948b(0.2f)).m6418a(C1097tx.f5775g).mo5947a(0.5f)).m6358g().m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5563fW)).m6388b("mg").m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lI */
    public static final DeferredHolder<Item, ? extends C1144ur> f7197lI = f7103a.registerItem("gun_mg34", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_mg34", properties).m6352a(150, 300).mo5934a(C1110uJ.f5843gz).m6395a(C1112uL.f5852c).m6397a(C1114uN.f5861c).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8087zy).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6156b(C1280xc.f8088zz).m6167g(C1280xc.f7849uU).m6169h(C1280xc.f7862vh).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8089zA, true).m6160d(C1280xc.f8256CL).m6192o(C1280xc.f7873vs).m6217a(0.9f)).m6409a(C1280xc.f8090zB).mo5947a(2.5f).m6324a(EnumC1147uu.NO_BIPOD_ONLY).mo5948b(0.25f).m6419a(GunType.LMG).mo5948b(0.2f)).m6418a(C1097tx.f5775g).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5563fW)).m6388b("mg").m6325a(new C1117uQ(7.7f)).mo5947a(0.5f)).m6382a(new Vector3f(), true).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lJ */
    public static final DeferredHolder<Item, ? extends C1144ur> f7198lJ = f7103a.registerItem("gun_zb26", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_zb26", properties).m6352a(20, 60).m6385d(0.5f).mo5934a(C1110uJ.f5843gz).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8108zT).m6156b(C1280xc.f8109zU).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8133As, true).m6160d(C1280xc.f8255CK).m6192o(C1280xc.f7873vs).m6217a(0.95f)).mo5948b(0.25f).m6419a(GunType.LMG).mo5948b(0.2f)).m6418a(C1097tx.f5775g).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5563fW)).m6388b("mg").m6325a(new C1117uQ(5.75f)).mo5947a(0.4f)).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lK */
    public static final DeferredHolder<Item, ? extends C1144ur> f7199lK = f7103a.registerItem("gun_type11", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_type11", properties).m6352a(30, 90).mo5934a(C1110uJ.f5843gz).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8127Am).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6156b(C1280xc.f8128An).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8255CK).m6150a(C1280xc.f8133As, true).m6192o(C1280xc.f7873vs).m6217a(0.95f)).m6385d(0.75f).mo5947a(0.2f)).mo5948b(0.25f).m6419a(GunType.LMG).mo5948b(0.2f)).m6418a(C1097tx.f5775g).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5563fW)).m6388b("mg").m6325a(new C1117uQ(4.83f)).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lL */
    public static final DeferredHolder<Item, ? extends C1144ur> f7200lL = f7103a.registerItem("gun_bren_mk2", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_bren_mk2", properties).m6352a(30, 90).m6353a("pan", new C1145us(Component.translatable("bf.item.gun.mag.type.pan"), 100, 100)).mo5934a(C1110uJ.f5843gz).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8132Ar).m6156b(C1280xc.f8134At).m6167g(C1280xc.f7847uS).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8133As, false).m6192o(C1280xc.f7873vs).m6184k(C1280xc.f7867vm).m6217a(0.95f)).m6330a(C0418hH.f2662e).mo5948b(0.25f).m6419a(GunType.LMG).mo5948b(0.2f)).m6418a(C1097tx.f5775g).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5563fW)).mo5947a(0.35f)).m6388b("mg").m6325a(new C1117uQ(4.5f)).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 1), new C1119uS(EnumC1120uT.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lM */
    public static final DeferredHolder<Item, ? extends C1144ur> f7201lM = f7103a.registerItem("gun_model_1930", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_model_1930", properties).m6352a(20, 60).mo5934a(C1110uJ.f5843gz).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8167Ba).m6152a(C1280xc.f8168Bb, C1280xc.f8169Bc).m6167g(C1280xc.f7848uT).m6169h(C1280xc.f7857vc).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8256CL).m6192o(C1280xc.f7873vs).m6217a(0.95f)).m6385d(0.5f).mo5948b(0.25f).m6419a(GunType.LMG).mo5948b(0.2f)).m6418a(C1097tx.f5775g).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5563fW)).m6325a(new C1117uQ(4.7f)).mo5947a(0.4f)).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lN */
    public static final DeferredHolder<Item, ? extends C1144ur> f7202lN = f7103a.registerItem("gun_breda_safat", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_breda_safat", properties).m6352a(150, 300).mo5934a(C1110uJ.f5845gB).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8024yn).m6171b(C1280xc.f7930wx, C1280xc.f7931wy).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6156b(C1280xc.f8025yo).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8089zA, true).m6190n(C1280xc.f7875vu).m6192o(C1280xc.f7873vs).m6217a(0.95f)).mo5948b(0.25f).m6419a(GunType.LMG).mo5948b(0.2f)).m6418a(C1097tx.f5775g).mo5947a(0.35f)).m6385d(1.0f).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5563fW)).m6325a(new C1117uQ(6.0f)).m6388b("mg").m6382a(new Vector3f(), true).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lO */
    public static final DeferredHolder<Item, ? extends C1144ur> f7203lO = f7103a.registerItem("gun_type96", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_type96", properties).m6352a(30, 90).mo5934a(C1110uJ.f5843gz).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8135Au).m6156b(C1280xc.f8137Aw).m6167g(C1280xc.f7847uS).m6169h(C1280xc.f7862vh).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6160d(C1280xc.f8255CK).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8136Av, true).m6192o(C1280xc.f7873vs).m6217a(0.95f)).mo5948b(0.25f).m6419a(GunType.LMG).mo5948b(0.2f)).m6418a(C1097tx.f5775g).m6328a(C1108uH.a.DEFAULT, new C1108uH(true, 0.2f, "scope_kar98k", false)).mo5934a(C1052tE.f5563fW)).m6388b("mg").m6409a(C1280xc.f8138Ax).m6325a(new C1117uQ(5.5f)).mo5947a(0.3f)).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lP */
    public static final DeferredHolder<Item, ? extends C1144ur> f7204lP = f7103a.registerItem("gun_type98", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_type98", properties).m6352a(75, 150).mo5934a(C1110uJ.f5843gz).m6395a(C1112uL.f5852c).m6397a(C1114uN.f5861c).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8139Ay).m6156b(C1280xc.f8140Az).m6167g(C1280xc.f7847uS).m6169h(C1280xc.f7862vh).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6160d(C1280xc.f8255CK).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6150a(C1280xc.f8136Av, true).m6192o(C1280xc.f7873vs).m6217a(0.95f)).mo5948b(0.25f).m6419a(GunType.MG).mo5948b(0.15f)).m6418a(C1097tx.f5775g).mo5934a(C1052tE.f5563fW)).m6388b("mg").m6409a(C1280xc.f8138Ax).m6325a(new C1117uQ(4.8f)).mo5947a(0.3f)).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lQ */
    public static final DeferredHolder<Item, ? extends C1144ur> f7205lQ = f7103a.registerItem("gun_m1928a1_thompson", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_m1928a1_thompson", properties).m6352a(20, 100).m6353a("drum", new C1145us(Component.translatable("bf.item.gun.mag.type.drum"), 100, 100)).mo5934a(C1110uJ.f5841gx).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8011ya).m6150a(C1280xc.f8014yd, true).m6171b(C1280xc.f7918wl, C1280xc.f7919wm).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7987xC).m6156b(C1280xc.f8012yb).m6167g(C1280xc.f7847uS).m6169h(C1280xc.f7860vf).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5770b).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5562fV)).m6388b("smg").m6325a(new C1117uQ(2.5f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 1), new C1119uS(EnumC1120uT.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lR */
    public static final DeferredHolder<Item, ? extends C1144ur> f7206lR = f7103a.registerItem("gun_m1a1_thompson", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_m1a1_thompson", properties).m6352a(30, C0357g.f2439g).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8011ya).m6150a(C1280xc.f8014yd, true).m6167g(C1280xc.f7855va).m6171b(C1280xc.f7918wl, C1280xc.f7919wm).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7987xC).m6156b(C1280xc.f8012yb).m6167g(C1280xc.f7847uS).m6169h(C1280xc.f7860vf).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6325a(new C1117uQ(2.5f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: c */
    private static final C1118uR f7207c = C1118uR.f5872b.clone().m6154a(C1280xc.f8015ye).m6167g(C1280xc.f7855va).m6171b(C1280xc.f7910wd, C1280xc.f7911we).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7987xC).m6156b(C1280xc.f8017yg).m6167g(C1280xc.f7847uS).m6169h(C1280xc.f7860vf).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB);

    /* JADX INFO: renamed from: d */
    private static final C1118uR f7208d = C1118uR.f5872b.clone().m6217a(1.5f).m6154a(C1280xc.f8016yf).m6150a(C1280xc.f8018yh, true).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7987xC).m6156b(C1280xc.f8017yg).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(null).m6174i(null).m6178d(null, null).m6186l(null).m6167g(null).m6169h(null);

    /* JADX INFO: renamed from: lS */
    public static final DeferredHolder<Item, ? extends C1144ur> f7209lS = f7103a.registerItem("gun_greasegun", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_greasegun", properties).m6352a(30, 90).mo5934a(C1110uJ.f5840gw).m6344a(f7207c).m6354a("suppressor", new C1140un(Component.translatable("bf.item.gun.barrel.type.suppressor")).m6273a(false).m6275a(f7208d)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6325a(new C1117uQ(3.0f)).mo5947a(0.75f)).m6385d(0.65f).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lT */
    public static final DeferredHolder<Item, ? extends C1144ur> f7210lT = f7103a.registerItem("gun_mp40", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_mp40", properties).m6352a(32, 96).m6353a("double", new C1145us(Component.translatable("bf.item.gun.mag.type.doppel"), 64, 128)).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8054yR).m6171b(C1280xc.f7953wU, C1280xc.f7954wV).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7987xC).m6152a(C1280xc.f8055yS, C1280xc.f8056yT).m6167g(C1280xc.f7851uW).m6169h(C1280xc.f7860vf).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6150a(C1280xc.f8057yU, true).m6194p(C1280xc.f7882vB).m6184k(C1280xc.f7865vk)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6409a(C1280xc.f8058yV).m6325a(new C1117uQ(2.75f, 5.0f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lU */
    public static final DeferredHolder<Item, ? extends C1144ur> f7211lU = f7103a.registerItem("gun_stg44", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_stg44", properties).m6352a(30, 90).mo5934a(C1110uJ.f5842gy).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8060yX).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6152a(C1280xc.f8061yY, C1280xc.f8062yZ).m6167g(C1280xc.f7854uZ).m6169h(C1280xc.f7857vc).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6150a(C1280xc.f8057yU, true).m6184k(C1280xc.f7866vl).m6217a(0.95f)).m6409a(C1280xc.f8063za).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6325a(new C1117uQ(2.0f, 3.25f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lV */
    public static final DeferredHolder<Item, ? extends C1144ur> f7212lV = f7103a.registerItem("gun_blyskawica", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_blyskawica", properties).m6352a(20, 60).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8076zn).m6171b(C1280xc.f7918wl, C1280xc.f7919wm).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7860vf).m6188m(C1280xc.f7987xC).m6152a(C1280xc.f8077zo, C1280xc.f8078zp).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6325a(new C1117uQ(2.75f, 3.75f)).m6388b("smg").m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lW */
    public static final DeferredHolder<Item, ? extends C1144ur> f7213lW = f7103a.registerItem("gun_kop_pal", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_kop_pal", properties).m6352a(32, 96).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8083zu).m6171b(C1280xc.f7918wl, C1280xc.f7919wm).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7860vf).m6188m(C1280xc.f7987xC).m6156b(C1280xc.f8084zv).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6325a(new C1117uQ(2.5f, 4.3f)).m6388b("smg").m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    });

    /* JADX INFO: renamed from: lX */
    public static final DeferredHolder<Item, ? extends C1144ur> f7214lX = f7103a.registerItem("gun_pps43", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_pps43", properties).m6352a(35, 105).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8095zG).m6171b(C1280xc.f7914wh, C1280xc.f7915wi).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7860vf).m6188m(C1280xc.f7987xC).m6156b(C1280xc.f8096zH).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB)).m6409a(C1280xc.f8097zI).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6325a(new C1117uQ(3.0f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lY */
    public static final DeferredHolder<Item, ? extends C1144ur> f7215lY = f7103a.registerItem("gun_ppsh", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_ppsh", properties).m6352a(35, 105).m6353a("drum", new C1145us(Component.translatable("bf.item.gun.mag.type.drum"), 71, 142)).mo5934a(C1110uJ.f5841gx).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8098zJ).m6171b(C1280xc.f7914wh, C1280xc.f7915wi).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6169h(C1280xc.f7860vf).m6188m(C1280xc.f7987xC).m6156b(C1280xc.f8099zK).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5770b).m6325a(new C1117uQ(3.0f)).m6385d(0.8f).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5562fV)).m6409a(C1280xc.f8100zL).m6388b("smg").m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 1), new C1119uS(EnumC1120uT.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: lZ */
    public static final DeferredHolder<Item, ? extends C1144ur> f7216lZ = f7103a.registerItem("gun_type100", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_type100", properties).m6352a(30, 90).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8129Ao).m6171b(C1280xc.f7918wl, C1280xc.f7919wm).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7860vf).m6188m(C1280xc.f7987xC).m6152a(C1280xc.f8130Ap, C1280xc.f8131Aq).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6325a(new C1117uQ(4.0f, 5.5f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: e */
    private static final C1118uR f7217e = C1118uR.f5872b.clone().m6151a(C1280xc.f8151AK, true, 1).m6154a(C1280xc.f8149AI).m6171b(C1280xc.f7912wf, C1280xc.f7913wg).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7860vf).m6188m(C1280xc.f7987xC).m6152a(C1280xc.f8150AJ, C1280xc.f8152AL).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB);

    /* JADX INFO: renamed from: f */
    private static final C1118uR f7218f = C1118uR.f5872b.clone().m6217a(1.5f).m6154a(C1280xc.f8153AM).m6150a(C1280xc.f8154AN, true).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7987xC).m6152a(C1280xc.f8150AJ, C1280xc.f8152AL).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(null).m6174i(null).m6178d(null, null).m6186l(null).m6167g(null).m6169h(null);

    /* JADX INFO: renamed from: ma */
    public static final DeferredHolder<Item, ? extends C1144ur> f7219ma = f7103a.registerItem("gun_sten_mk2", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_sten_mk2", properties).m6352a(32, 96).m6353a("lanchester", new C1145us(Component.translatable("bf.item.gun.mag.type.lanchester"), 50, 100)).m6354a("suppressor", new C1140un(Component.translatable("bf.item.gun.barrel.type.suppressor")).m6273a(false).m6275a(f7218f)).mo5934a(C1110uJ.f5840gw).m6344a(f7217e).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6325a(new C1117uQ(2.5f, 4.375f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mb */
    public static final DeferredHolder<Item, ? extends C1144ur> f7220mb = f7103a.registerItem("gun_model_38", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_model_38", properties).m6352a(30, 90).m6353a("extended", new C1145us(Component.translatable("bf.item.gun.mag.type.extended"), 40, 80)).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6151a(C1280xc.f8164AX, true, 1).m6154a(C1280xc.f8163AW).m6171b(C1280xc.f7918wl, C1280xc.f7919wm).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7860vf).m6188m(C1280xc.f7987xC).m6156b(C1280xc.f8165AY).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB)).m6409a(C1280xc.f8166AZ).m6385d(0.7f).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6325a(new C1117uQ(3.7f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mc */
    public static final DeferredHolder<Item, ? extends C1144ur> f7221mc = f7103a.registerItem("gun_mas_38", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_mas_38", properties).m6352a(32, 96).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8184Br).m6171b(C1280xc.f7918wl, C1280xc.f7919wm).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7860vf).m6188m(C1280xc.f7985xA).m6156b(C1280xc.f8185Bs).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6150a(C1280xc.f8186Bt, true).m6194p(C1280xc.f7879vy).m6217a(1.2f)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6325a(new C1117uQ(3.75f)).m6388b("smg").m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: md */
    public static final DeferredHolder<Item, ? extends C1144ur> f7222md = f7103a.registerItem("gun_ak74", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_ak74", properties).m6352a(30, 90).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8206BN).m6150a(C1280xc.f8207BO, true).m6171b(C1280xc.f7918wl, C1280xc.f7919wm).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7987xC).m6152a(C1280xc.f8208BP, C1280xc.f8209BQ).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7860vf).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6325a(new C1117uQ(3.0f, 4.3f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: me */
    public static final DeferredHolder<Item, ? extends C1144ur> f7223me = f7103a.registerItem("gun_m4a4", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_m4a4", properties).m6352a(30, 90).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8210BR).m6150a(C1280xc.f8212BT, true).m6171b(C1280xc.f7918wl, C1280xc.f7919wm).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7987xC).m6156b(C1280xc.f8211BS).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7860vf).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6325a(new C1117uQ(3.4167f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mf */
    public static final DeferredHolder<Item, ? extends C1144ur> f7224mf = f7103a.registerItem("gun_fg42", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_fg42", properties).m6352a(20, 60).mo5934a(C1110uJ.f5842gy).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8064zb).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6156b(C1280xc.f8065zc).m6167g(C1280xc.f7854uZ).m6169h(C1280xc.f7857vc).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6150a(C1280xc.f8057yU, true).m6217a(0.95f)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.6f, "scope_fg42", false).m6110a(0.5f)).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6385d(2.0f).m6358g().m6325a(new C1117uQ(3.79f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 3), new C1119uS(EnumC1120uT.SEMI, 3)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mg */
    public static final DeferredHolder<Item, ? extends C1144ur> f7225mg = f7103a.registerItem("gun_trenchgun", properties -> {
        return ((C1144ur) new C1144ur("gun_trenchgun", properties).m6352a(6, 18).mo5934a(C1110uJ.f5847gD).m6356e(64).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8050yN).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7920wn, C1280xc.f7921wo).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8258CN).m6217a(0.95f)).m6330a(C0418hH.f2660c).mo5948b(0.2f).m6419a(GunType.SHOTGUN).m6418a(C1097tx.f5778j).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5568gb)).m6388b("shell").m6409a((DeferredHolder<SoundEvent, SoundEvent>) null).m6325a(new C1116uP(0.83f, 0.75f, 1.25f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 18, f7092tu).m6227a(f7093b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mh */
    public static final DeferredHolder<Item, ? extends C1144ur> f7226mh = f7103a.registerItem("gun_m30", properties -> {
        return ((C1144ur) new C1144ur("gun_m30", properties).m6352a(2, 20).mo5934a(C1110uJ.f5847gD).m6356e(64).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8204BL).m6152a(C1280xc.f8205BM, C1280xc.f8205BM).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7920wn, C1280xc.f7921wo).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8258CN).m6217a(0.95f)).m6330a(C0418hH.f2660c).mo5948b(0.2f).m6419a(GunType.SHOTGUN).m6418a(C1097tx.f5778j).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5568gb)).m6388b("shell").m6325a(new C1117uQ(3.8f, 3.8f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 5, f7092tu).m6227a(f7093b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mi */
    public static final DeferredHolder<Item, ? extends C1144ur> f7227mi = f7103a.registerItem("gun_becker", properties -> {
        return ((C1144ur) new C1144ur("gun_becker", properties).m6352a(5, 15).mo5934a(C1110uJ.f5847gD).m6356e(64).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8204BL).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7920wn, C1280xc.f7921wo).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8258CN).m6217a(0.95f)).m6330a(C0418hH.f2660c).mo5948b(0.2f).m6419a(GunType.SHOTGUN).m6418a(C1097tx.f5778j).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5568gb)).m6388b("shell").m6325a(new C1116uP(1.5f, 1.65f, 0.5f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 6, f7092tu).m6227a(f7093b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mj */
    public static final DeferredHolder<Item, ? extends C1144ur> f7229mj = f7103a.registerItem("gun_mauser_m712", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_mauser_m712", properties).m6352a(20, 60).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6150a(C1280xc.f8044yH, true).m6154a(C1280xc.f8043yG).m6152a(C1280xc.f8045yI, C1280xc.f8046yJ).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2666i).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5780l).m6345d().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(2.4f, 3.12f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 1), new C1119uS(EnumC1120uT.SEMI, 1)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mk */
    public static final DeferredHolder<Item, ? extends C1144ur> f7230mk = f7103a.registerItem("gun_springfield", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_springfield", properties).m6352a(5, 15).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8023ym).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7949wQ, C1280xc.f7950wR).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw)).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_springfield", false).m6110a(0.5f)).m6409a((DeferredHolder<SoundEvent, SoundEvent>) null).mo5934a(C1052tE.f5559fS)).m6325a(new C1116uP(1.875f, 0.58f, 1.25f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ml */
    public static final DeferredHolder<Item, ? extends C1144ur> f7231ml = f7103a.registerItem("gun_kar98k", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_kar98k", properties).m6352a(5, 15).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8047yK).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7959xa, C1280xc.f7960xb).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw)).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_kar98k", false).m6110a(0.5f)).mo5934a(C1052tE.f5559fS)).m6325a(new C1116uP(1.875f, 0.4583f, 1.0f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mm */
    public static final DeferredHolder<Item, ? extends C1144ur> f7232mm = f7103a.registerItem("gun_kbk_wz_29", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_kbk_wz_29", properties).m6352a(5, 15).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8081zs).m6156b(C1280xc.f8082zt).m6196q(C1280xc.f7975xq).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7959xa, C1280xc.f7960xb).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw)).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_kar98k", false).m6110a(0.5f)).mo5934a(C1052tE.f5559fS)).m6325a(new C1116uP(2.0f, 0.58f, 1.25f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mn */
    public static final DeferredHolder<Item, ? extends C1144ur> f7233mn = f7103a.registerItem("gun_mosin_nagant", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_mosin_nagant", properties).m6352a(5, 15).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8091zC).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7961xc, C1280xc.f7962xd).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw).m6184k(C1280xc.f7870vp)).m6409a((DeferredHolder<SoundEvent, SoundEvent>) null).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_kar98k", false).m6110a(0.5f)).mo5934a(C1052tE.f5559fS)).m6325a(new C1116uP(1.875f, 0.4583f, 1.0f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mo */
    public static final DeferredHolder<Item, ? extends C1144ur> f7234mo = f7103a.registerItem("gun_type38", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_type38", properties).m6352a(5, 15).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8118Ad).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7922wp, C1280xc.f7923wq).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw)).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_type38", false).m6110a(0.5f)).mo5934a(C1052tE.f5559fS)).m6325a(new C1116uP(1.875f, 0.4583f, 1.0f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mp */
    public static final DeferredHolder<Item, ? extends C1144ur> f7235mp = f7103a.registerItem("gun_type99", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_type99", properties).m6352a(5, 15).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8120Af).m6156b(C1280xc.f8121Ag).m6196q(C1280xc.f7975xq).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz)).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_type99", false)).mo5934a(C1052tE.f5559fS)).m6325a(new C1116uP(2.0f, 0.58f, 1.25f)).m6388b("mg").m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mq */
    public static final DeferredHolder<Item, ? extends C1144ur> f7236mq = f7103a.registerItem("gun_lee_enfield_mk1", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_lee_enfield_mk1", properties).m6352a(10, 30).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8141AA).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7947wO, C1280xc.f7948wP).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw)).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_kar98k", false).m6110a(0.5f)).mo5934a(C1052tE.f5559fS)).m6325a(new C1116uP(2.0f, 0.58f, 1.25f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mr */
    public static final DeferredHolder<Item, ? extends C1144ur> f7237mr = f7103a.registerItem("gun_carcano_m91ts_carbine", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_carcano_m91ts_carbine", properties).m6352a(6, 18).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8160AT).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7922wp, C1280xc.f7923wq).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw)).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_carcano", false).m6110a(0.5f)).mo5934a(C1052tE.f5559fS)).m6409a((DeferredHolder<SoundEvent, SoundEvent>) null).m6325a(new C1116uP(2.0f, 0.58f, 1.25f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ms */
    public static final DeferredHolder<Item, ? extends C1144ur> f7238ms = f7103a.registerItem("gun_carcano_m38", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_carcano_m38", properties).m6352a(6, 18).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8160AT).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7922wp, C1280xc.f7923wq).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw)).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_carcano", false).m6110a(0.5f)).mo5934a(C1052tE.f5559fS)).m6409a((DeferredHolder<SoundEvent, SoundEvent>) null).m6325a(new C1116uP(2.0f, 0.58f, 1.25f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mt */
    public static final DeferredHolder<Item, ? extends C1144ur> f7239mt = f7103a.registerItem("gun_lebel_1886", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_lebel_1886", properties).m6352a(10, 30).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8175Bi).m6196q(C1280xc.f7975xq).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7922wp, C1280xc.f7923wq).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw)).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_lebel_1886", false).m6110a(0.5f)).mo5934a(C1052tE.f5559fS)).m6325a(new C1116uP(2.0f, 0.58f, 1.25f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mu */
    public static final DeferredHolder<Item, ? extends C1144ur> f7240mu = f7103a.registerItem("gun_m1_garand", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_m1_garand", properties).m6352a(8, 24).mo5934a(C1110uJ.f5838gu).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8004xT).m6152a(C1280xc.f8005xU, C1280xc.f8006xV).m6160d(C1280xc.f8007xW).m6167g(C1280xc.f7856vb).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7957wY, C1280xc.f7958wZ).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw).m6184k(C1280xc.f7869vo)).m6330a(C0418hH.f2661d).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5772d).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_m1_garand", false).m6110a(0.5f)).mo5934a(C1052tE.f5560fT)).m6325a(new C1117uQ(5.0f, 3.75f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mv */
    public static final DeferredHolder<Item, ? extends C1144ur> f7241mv = f7103a.registerItem("gun_m1_carbine", properties -> {
        return ((C1144ur) new C1144ur("gun_m1_carbine", properties).m6352a(15, 60).mo5934a(C1110uJ.f5839gv).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8026yp).m6156b(C1280xc.f8027yq).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7971xm).m6194p(C1280xc.f7879vy).m6160d(C1280xc.f8254CJ).m6171b(C1280xc.f7955wW, C1280xc.f7956wX).m6188m(C1280xc.f7986xB).m6184k(C1280xc.f7868vn)).mo5948b(0.1f).m6419a(GunType.CARBINE).m6418a(C1097tx.f5772d).m6345d().m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5560fT)).m6325a(new C1117uQ(4.75f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mw */
    public static final DeferredHolder<Item, ? extends C1144ur> f7242mw = f7103a.registerItem("gun_m2_carbine", properties -> {
        return ((C1144ur) new C1144ur("gun_m2_carbine", properties).m6352a(30, 90).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8026yp).m6150a(C1280xc.f8028yr, true).m6156b(C1280xc.f8027yq).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7971xm).m6194p(C1280xc.f7879vy).m6160d(C1280xc.f8254CJ).m6171b(C1280xc.f7955wW, C1280xc.f7956wX).m6188m(C1280xc.f7986xB).m6184k(C1280xc.f7868vn)).mo5948b(0.05f).m6419a(GunType.CARBINE).m6418a(C1097tx.f5769a).m6345d().m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_m1_garand", false).m6110a(0.5f)).mo5934a(C1052tE.f5561fU)).m6325a(new C1117uQ(4.75f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mx */
    public static final DeferredHolder<Item, ? extends C1144ur> f7243mx = f7103a.registerItem("gun_gewehr_43", properties -> {
        return ((C1144ur) new C1144ur("gun_gewehr_43", properties).m6352a(10, 30).mo5934a(C1110uJ.f5838gu).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8070zh).m6152a(C1280xc.f8071zi, C1280xc.f8072zj).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7928wv, C1280xc.f7929ww).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7881vA).m6190n(C1280xc.f7877vw).m6160d(C1280xc.f8254CJ)).m6330a(C0418hH.f2661d).mo5948b(0.1f).m6419a(GunType.CARBINE).m6418a(C1097tx.f5772d).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_gewehr_43", false).m6110a(0.5f)).mo5934a(C1052tE.f5560fT)).m6325a(new C1117uQ(2.45f, 3.3f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: my */
    public static final DeferredHolder<Item, ? extends C1144ur> f7244my = f7103a.registerItem("gun_type4", properties -> {
        return ((C1144ur) new C1144ur("gun_type4", properties).m6352a(10, 30).mo5934a(C1110uJ.f5838gu).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8122Ah).m6156b(C1280xc.f8123Ai).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7922wp, C1280xc.f7923wq).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw)).m6330a(C0418hH.f2661d).mo5948b(0.1f).m6419a(GunType.CARBINE).m6418a(C1097tx.f5772d).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_m1_garand", false).m6110a(0.5f)).mo5934a(C1052tE.f5560fT)).m6325a(new C1117uQ(3.7f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mz */
    public static final DeferredHolder<Item, ? extends C1144ur> f7245mz = f7103a.registerItem("gun_lee_enfield_turner", properties -> {
        return ((C1144ur) new C1144ur("gun_lee_enfield_turner", properties).m6352a(10, 30).mo5934a(C1110uJ.f5838gu).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8141AA).m6171b(C1280xc.f7947wO, C1280xc.f7948wP).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7881vA).m6190n(C1280xc.f7877vw).m6160d(C1280xc.f8254CJ)).m6330a(C0418hH.f2661d).mo5948b(0.1f).m6419a(GunType.CARBINE).m6418a(C1097tx.f5772d).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5560fT)).m6325a(new C1116uP(1.125f, 0.63f, 1.3333f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mA */
    public static final DeferredHolder<Item, ? extends C1144ur> f7246mA = f7103a.registerItem("gun_model_1935", properties -> {
        return ((C1144ur) new C1144ur("gun_model_1935", properties).m6352a(20, 60).mo5934a(C1110uJ.f5838gu).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8161AU).m6171b(C1280xc.f7928wv, C1280xc.f7929ww).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6169h(C1280xc.f7862vh).m6188m(C1280xc.f7986xB).m6156b(C1280xc.f8162AV).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8254CJ).m6192o(C1280xc.f7871vq).m6217a(1.2f)).mo5948b(0.35f).m6419a(GunType.CARBINE).m6418a(C1097tx.f5773e).mo5947a(2.5f).m6324a(EnumC1147uu.NO_BIPOD_ONLY).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5564fX)).m6388b("pistol").m6325a(new C1117uQ(4.3f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mB */
    public static final DeferredHolder<Item, ? extends C1144ur> f7247mB = f7103a.registerItem("gun_fusil_1917", properties -> {
        return ((C1144ur) new C1144ur("gun_fusil_1917", properties).m6352a(5, 30).mo5934a(C1110uJ.f5838gu).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8182Bp).m6156b(C1280xc.f8183Bq).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7922wp, C1280xc.f7923wq).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw)).m6330a(C0418hH.f2661d).mo5948b(0.1f).m6419a(GunType.CARBINE).m6418a(C1097tx.f5772d).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5560fT)).m6325a(new C1117uQ(5.0f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mC */
    public static final DeferredHolder<Item, ? extends C1144ur> f7248mC = f7103a.registerItem("gun_howell", properties -> {
        return ((C1144ur) new C1144ur("gun_howell", properties).m6352a(10, 30).mo5934a(C1110uJ.f5838gu).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8224Cf).m6156b(C1280xc.f8225Cg).m6171b(C1280xc.f7947wO, C1280xc.f7948wP).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7881vA).m6190n(C1280xc.f7877vw).m6160d(C1280xc.f8254CJ)).m6330a(C0418hH.f2661d).mo5948b(0.1f).m6419a(GunType.CARBINE).m6418a(C1097tx.f5772d).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_kar98k", false).m6110a(0.5f)).mo5934a(C1052tE.f5560fT)).m6325a(new C1117uQ(7.8f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mD */
    public static final DeferredHolder<Item, ? extends C1144ur> f7249mD = f7103a.registerItem("gun_ptrs", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_ptrs", properties).m6352a(5, 5).mo5934a(C1110uJ.f5844gA).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8101zM).m6150a(C1280xc.f8189Bw, true).m6156b(C1280xc.f8102zN).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7924wr, C1280xc.f7925ws).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8256CL).m6214x(C1280xc.f7835uG).m6217a(0.95f)).m6335b(false).m6330a(C0418hH.f2665h).mo5948b(0.4f).m6419a(GunType.AT).mo5948b(0.1f)).m6418a(C1097tx.f5777i).m6385d(2.5f).mo5947a(0.3f)).m6325a(new C1117uQ(6.0f)).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5567ga)).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mE */
    public static final DeferredHolder<Item, ? extends C1144ur> f7250mE = f7103a.registerItem("gun_batr", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_batr", properties).m6352a(5, 5).mo5947a(0.3f)).m6358g().mo5934a(C1110uJ.f5844gA).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8187Bu).m6150a(C1280xc.f8189Bw, true).m6156b(C1280xc.f8188Bv).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7924wr, C1280xc.f7925ws).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7875vu).m6214x(C1280xc.f7835uG).m6217a(0.95f)).m6335b(false).m6330a(C0418hH.f2665h).mo5948b(0.4f).m6419a(GunType.AT).mo5948b(0.1f)).m6418a(C1097tx.f5777i).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5567ga)).m6325a(new C1117uQ(5.25f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mF */
    public static final DeferredHolder<Item, ? extends C1144ur> f7251mF = f7103a.registerItem("gun_panzerbuchse39", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_panzerbuchse39", properties).m6352a(1, 10).mo5947a(0.2f)).m6385d(2.0f).mo5934a(C1110uJ.f5844gA).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8190Bx).m6150a(C1280xc.f8192Bz, true).m6156b(C1280xc.f8191By).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7924wr, C1280xc.f7925ws).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7875vu).m6214x(C1280xc.f7835uG).m6217a(0.95f)).m6335b(false).m6330a(C0418hH.f2665h).m6358g().mo5948b(0.4f).m6419a(GunType.AT).mo5948b(0.1f)).m6418a(C1097tx.f5777i).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5567ga)).m6325a(new C1117uQ(4.25f)).m6409a(C1280xc.f8193BA).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mG */
    public static final DeferredHolder<Item, ? extends C1144ur> f7252mG = f7103a.registerItem("gun_type26", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_type26", properties).m6352a(6, 18).mo5934a(C1110uJ.f5835gr).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8116Ab).m6162e(C1280xc.f7884vD).m6150a(C1280xc.f8144AD, true).m6156b(C1280xc.f8117Ac).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7945wM, C1280xc.f7946wN).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6212w(C1280xc.f7992xH).m6217a(1.2f)).m6330a(C0418hH.f2659b).m6332a(true).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.35f)).m6418a(C1097tx.f5781m).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5558fR)).m6388b("pistol").m6325a(new C1117uQ(4.45f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mH */
    public static final DeferredHolder<Item, ? extends C1144ur> f7253mH = f7103a.registerItem("gun_webley_mk6", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_webley_mk6", properties).m6352a(6, 18).mo5934a(C1110uJ.f5835gr).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8143AC).m6162e(C1280xc.f7884vD).m6151a(C1280xc.f8144AD, true, 1).m6156b(C1280xc.f8145AE).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7945wM, C1280xc.f7946wN).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6212w(C1280xc.f7992xH).m6217a(1.2f)).m6330a(C0418hH.f2659b).m6332a(true).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.35f)).m6418a(C1097tx.f5781m).m6330a(C0418hH.f2664g).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5558fR)).m6388b("pistol").m6325a(new C1117uQ(4.45f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mI */
    public static final DeferredHolder<Item, ? extends C1144ur> f7254mI = f7103a.registerItem("gun_modele_1892_revolver", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_modele_1892_revolver", properties).m6352a(6, 18).mo5934a(C1110uJ.f5835gr).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8194BB).m6162e(C1280xc.f7884vD).m6150a(C1280xc.f8195BC, true).m6156b(C1280xc.f8196BD).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7945wM, C1280xc.f7946wN).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6212w(C1280xc.f7992xH).m6217a(1.2f)).m6330a(C0418hH.f2659b).m6332a(true).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.35f)).m6418a(C1097tx.f5781m).m6345d().m6342c().m6325a(new C1117uQ(6.5f)).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5558fR)).m6388b("pistol").m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mJ */
    public static final DeferredHolder<Item, ? extends C1144ur> f7255mJ = f7103a.registerItem("gun_m2_flamethrower", properties -> {
        C1144ur c1144urM6325a = ((C1144ur) new C1144ur("gun_m2_flamethrower", properties).m6352a(15200, 30400).m6377g(AbstractC0211dM.f1737gZ).mo5934a(C1110uJ.f5833gp).m6344a(C1118uR.f5872b.clone().m6147a(false).m6154a(C1280xc.f8197BE).m6171b(C1280xc.f7930wx, C1280xc.f7931wy).m6156b(C1280xc.f8198BF).m6150a(C1280xc.f8199BG, true).m6165f(C1280xc.f8200BH).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8256CL).m6160d(C1280xc.f8201BI)).m6326a(f7145P).m6335b(false).mo5948b(0.3f).m6419a(GunType.FLAMETHROWER).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5569gc)).m6357f(4).m6338d(false).m6339e(false).m6330a(C0418hH.f2663f).m6325a(new C1117uQ(3.5f));
        EnumC1120uT enumC1120uT = EnumC1120uT.AUTO;
        DeferredHolder<EntityType<?>, EntityType<C0766nl>> deferredHolder = C1230wX.f7032kE;
        Objects.requireNonNull(deferredHolder);
        return c1144urM6325a.m6349a(new C1119uS[]{new C1119uS(enumC1120uT, 2, (Supplier<EntityType<? extends InterfaceC0724mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mK */
    public static final DeferredHolder<Item, ? extends C1144ur> f7256mK = f7103a.registerItem("gun_flammenwerfer_34", properties -> {
        C1144ur c1144urM6325a = ((C1144ur) new C1144ur("gun_flammenwerfer_34", properties).m6352a(15200, 30400).m6377g(118).mo5934a(C1110uJ.f5833gp).m6344a(C1118uR.f5872b.clone().m6147a(false).m6154a(C1280xc.f8197BE).m6171b(C1280xc.f7930wx, C1280xc.f7931wy).m6156b(C1280xc.f8198BF).m6150a(C1280xc.f8199BG, true).m6165f(C1280xc.f8200BH).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8256CL).m6160d(C1280xc.f8201BI)).m6326a(f7144O).m6335b(false).mo5948b(0.3f).m6419a(GunType.FLAMETHROWER).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5569gc)).m6357f(4).m6338d(false).m6339e(false).m6330a(C0418hH.f2663f).m6325a(new C1117uQ(3.5f));
        EnumC1120uT enumC1120uT = EnumC1120uT.AUTO;
        DeferredHolder<EntityType<?>, EntityType<C0766nl>> deferredHolder = C1230wX.f7032kE;
        Objects.requireNonNull(deferredHolder);
        return c1144urM6325a.m6349a(new C1119uS[]{new C1119uS(enumC1120uT, 2, (Supplier<EntityType<? extends InterfaceC0724mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mL */
    public static final DeferredHolder<Item, ? extends C1144ur> f7257mL = f7103a.registerItem("gun_colt", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_colt", properties).m6352a(7, 21).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f7995xK).m6152a(C1280xc.f7996xL, C1280xc.f7997xM).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6385d(0.5f).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(2.33f, 3.12f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mM */
    public static final DeferredHolder<Item, ? extends C1144ur> f7258mM = f7103a.registerItem("gun_beretta_m1934", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_beretta_m1934", properties).m6352a(7, 21).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f7998xN).m6152a(C1280xc.f7999xO, C1280xc.f8000xP).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(2.33f, 3.12f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mN */
    public static final DeferredHolder<Item, ? extends C1144ur> f7259mN = f7103a.registerItem("gun_fn_model_1910", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_fn_model_1910", properties).m6352a(8, 24).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8001xQ).m6152a(C1280xc.f8002xR, C1280xc.f8003xS).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(2.33f, 3.12f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mO */
    public static final DeferredHolder<Item, ? extends C1144ur> f7260mO = f7103a.registerItem("gun_walther_p38", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_walther_p38", properties).m6352a(8, 24).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8034yx).m6152a(C1280xc.f8035yy, C1280xc.f8036yz).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(2.33f, 3.12f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mP */
    public static final DeferredHolder<Item, ? extends C1144ur> f7261mP = f7103a.registerItem("gun_luger", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_luger", properties).m6352a(8, 24).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8037yA).m6152a(C1280xc.f8038yB, C1280xc.f8039yC).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(4.0f, 3.5f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mQ */
    public static final DeferredHolder<Item, ? extends C1144ur> f7262mQ = f7103a.registerItem("gun_mauser_c96", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_mauser_c96", properties).m6352a(10, 30).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8040yD).m6152a(C1280xc.f8041yE, C1280xc.f8042yF).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(5.0f, 4.7f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mR */
    public static final DeferredHolder<Item, ? extends C1144ur> f7263mR = f7103a.registerItem("gun_tokarev_tt33", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_tokarev_tt33", properties).m6352a(8, 24).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8073zk).m6152a(C1280xc.f8074zl, C1280xc.f8075zm).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(2.33f, 3.12f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mS */
    public static final DeferredHolder<Item, ? extends C1144ur> f7264mS = f7103a.registerItem("gun_fb_vis", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_fb_vis", properties).m6352a(8, 24).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8105zQ).m6152a(C1280xc.f8106zR, C1280xc.f8107zS).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(2.33f, 3.12f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mT */
    public static final DeferredHolder<Item, ? extends C1144ur> f7265mT = f7103a.registerItem("gun_type14", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_type14", properties).m6352a(6, 18).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8110zV).m6152a(C1280xc.f8111zW, C1280xc.f8112zX).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(2.33f, 3.12f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mU */
    public static final DeferredHolder<Item, ? extends C1144ur> f7266mU = f7103a.registerItem("gun_type94", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_type94", properties).m6352a(6, 18).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8113zY).m6152a(C1280xc.f8114zZ, C1280xc.f8115Aa).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(2.33f, 3.12f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mV */
    public static final DeferredHolder<Item, ? extends C1144ur> f7267mV = f7103a.registerItem("gun_glisenti_model_1910", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_glisenti_model_1910", properties).m6352a(7, 21).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8172Bf).m6152a(C1280xc.f8173Bg, C1280xc.f8174Bh).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6325a(new C1117uQ(2.33f, 3.12f)).m6388b("pistol").m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mW */
    public static final DeferredHolder<Item, ? extends C1144ur> f7268mW = f7103a.registerItem("gun_pistolet_automatique_modele_1935a", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_pistolet_automatique_modele_1935a", properties).m6352a(8, 24).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8176Bj).m6152a(C1280xc.f8177Bk, C1280xc.f8178Bl).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(2.33f, 3.12f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mX */
    public static final DeferredHolder<Item, ? extends C1144ur> f7269mX = f7103a.registerItem("gun_browning_hipower", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_browning_hipower", properties).m6352a(13, 39).mo5934a(C1110uJ.f5834gq).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7988xD).m6154a(C1280xc.f8219Ca).m6152a(C1280xc.f8220Cb, C1280xc.f8221Cc).m6174i(C1280xc.f7942wJ).m6178d(C1280xc.f7896vP, C1280xc.f7903vW).m6181j(C1280xc.f7904vX).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6217a(1.2f)).m6330a(C0418hH.f2659b).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.4f)).m6418a(C1097tx.f5779k).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH(0.3f, 0.4f)).mo5934a(C1052tE.f5557fQ)).m6388b("pistol").m6325a(new C1117uQ(2.5f, 3.1f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: mY */
    public static final DeferredHolder<Item, ? extends C1144ur> f7270mY = f7103a.registerItem("gun_bazooka", properties -> {
        C1144ur c1144ur = (C1144ur) new C1144ur("gun_bazooka", properties).m6352a(1, 4).mo5934a(C1110uJ.f5833gp).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7990xF).m6154a(C1280xc.f8031yu).m6171b(C1280xc.f7934wB, C1280xc.f7935wC).m6169h(C1280xc.f7861vg).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7973xo)).m6335b(false).mo5948b(0.5f).m6419a(GunType.ROCKET).m6418a(C1097tx.f5776h).m6346e().m6340b().m6330a(C0418hH.f2663f).m6328a(C1108uH.a.DEFAULT, new C1108uH(true, 0.3f, 0.1f, false)).mo5934a(C1052tE.f5566fZ);
        EnumC1120uT enumC1120uT = EnumC1120uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0760nf>> deferredHolder = C1230wX.f7051kU;
        Objects.requireNonNull(deferredHolder);
        return c1144ur.m6349a(new C1119uS[]{new C1119uS(enumC1120uT, 5, (Supplier<EntityType<? extends InterfaceC0724mw>>) deferredHolder::get)}).m6325a(new C1117uQ(3.5f));
    });

    /* JADX INFO: renamed from: mZ */
    public static final DeferredHolder<Item, ? extends C1144ur> f7271mZ = f7103a.registerItem("gun_panzerschreck", properties -> {
        C1144ur c1144urM6325a = ((C1144ur) new C1144ur("gun_panzerschreck", properties).m6352a(1, 4).mo5934a(C1110uJ.f5833gp).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7990xF).m6154a(C1280xc.f8069zg).m6171b(C1280xc.f7934wB, C1280xc.f7935wC).m6169h(C1280xc.f7861vg).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7973xo)).m6335b(false).mo5948b(0.5f).m6419a(GunType.ROCKET).m6418a(C1097tx.f5776h).m6346e().m6340b().m6330a(C0418hH.f2663f).m6328a(C1108uH.a.DEFAULT, new C1108uH(true, 0.3f, 0.1f, false)).mo5934a(C1052tE.f5566fZ)).m6325a(new C1117uQ(3.5f));
        EnumC1120uT enumC1120uT = EnumC1120uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0760nf>> deferredHolder = C1230wX.f7051kU;
        Objects.requireNonNull(deferredHolder);
        return c1144urM6325a.m6349a(new C1119uS[]{new C1119uS(enumC1120uT, 5, (Supplier<EntityType<? extends InterfaceC0724mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: na */
    public static final DeferredHolder<Item, ? extends C1144ur> f7272na = f7103a.registerItem("gun_panzerfaust", properties -> {
        C1144ur c1144urM6328a = ((C1144ur) new C1144ur("gun_panzerfaust", properties).m6352a(1, 4).mo5934a(C1110uJ.f5833gp).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7990xF).m6154a(C1280xc.f8093zE).m6156b(C1280xc.f8094zF).m6171b(C1280xc.f7934wB, C1280xc.f7935wC).m6169h(C1280xc.f7861vg).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7973xo)).m6335b(false).mo5948b(0.5f).m6419a(GunType.ROCKET).m6418a(C1097tx.f5776h).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5566fZ)).m6346e().m6340b().m6330a(C0418hH.f2663f).m6382a(new Vector3f(), true).m6325a(new C1117uQ(2.75f)).m6328a(C1108uH.a.DEFAULT, new C1108uH(true, 0.3f, 0.1f, false));
        EnumC1120uT enumC1120uT = EnumC1120uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0760nf>> deferredHolder = C1230wX.f7051kU;
        Objects.requireNonNull(deferredHolder);
        return c1144urM6328a.m6349a(new C1119uS[]{new C1119uS(enumC1120uT, 5, (Supplier<EntityType<? extends InterfaceC0724mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: nb */
    public static final DeferredHolder<Item, ? extends C1144ur> f7273nb = f7103a.registerItem("gun_piat", properties -> {
        C1144ur c1144urM6325a = ((C1144ur) new C1144ur("gun_piat", properties).m6352a(1, 4).mo5934a(C1110uJ.f5833gp).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8009xY).m6150a(C1280xc.f8010xZ, true).m6212w(C1280xc.f7990xF).m6171b(C1280xc.f7934wB, C1280xc.f7935wC).m6169h(C1280xc.f7861vg).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7973xo)).m6335b(false).mo5948b(0.5f).m6419a(GunType.ROCKET).m6418a(C1097tx.f5776h).m6346e().m6340b().m6330a(C0418hH.f2663f).m6328a(C1108uH.a.DEFAULT, new C1108uH(true, 0.3f, 0.1f, false)).mo5934a(C1052tE.f5566fZ)).m6382a(new Vector3f(), true).m6325a(new C1117uQ(3.5f));
        EnumC1120uT enumC1120uT = EnumC1120uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0760nf>> deferredHolder = C1230wX.f7051kU;
        Objects.requireNonNull(deferredHolder);
        return c1144urM6325a.m6349a(new C1119uS[]{new C1119uS(enumC1120uT, 5, (Supplier<EntityType<? extends InterfaceC0724mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: nc */
    public static final DeferredHolder<Item, ? extends C1144ur> f7274nc = f7103a.registerItem("gun_melon_cannon", properties -> {
        C1144ur c1144urM6325a = ((C1144ur) new C1144ur("gun_melon_cannon", properties).m6352a(1, 32).mo5934a(C1110uJ.f5833gp).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7990xF).m6154a(C1280xc.f8033yw).m6156b(C1280xc.f8032yv).m6171b(C1280xc.f7926wt, C1280xc.f7927wu).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7973xo)).m6335b(false).mo5948b(0.5f).m6419a(GunType.ROCKET).m6418a(C1097tx.f5776h).m6346e().m6337c(false).m6338d(false).m6339e(false).m6330a(C0418hH.f2663f).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5566fZ)).m6325a(new C1117uQ(1.8333f));
        EnumC1120uT enumC1120uT = EnumC1120uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0758nd>> deferredHolder = C1230wX.f7053kW;
        Objects.requireNonNull(deferredHolder);
        return c1144urM6325a.m6349a(new C1119uS[]{new C1119uS(enumC1120uT, 5, (Supplier<EntityType<? extends InterfaceC0724mw>>) deferredHolder::get)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: nd */
    public static final DeferredHolder<Item, ? extends C1144ur> f7275nd = f7103a.registerItem("gun_kis", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_kis", properties).m6352a(32, 96).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8227Ci).m6171b(C1280xc.f7918wl, C1280xc.f7919wm).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7860vf).m6188m(C1280xc.f7987xC).m6152a(C1280xc.f8228Cj, C1280xc.f8229Ck).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6325a(new C1117uQ(2.5f, 4.375f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ne */
    public static final DeferredHolder<Item, ? extends C1144ur> f7276ne = f7103a.registerItem("gun_mp_3008", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_mp_3008", properties).m6352a(32, 96).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8230Cl).m6171b(C1280xc.f7918wl, C1280xc.f7919wm).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6167g(C1280xc.f7855va).m6169h(C1280xc.f7860vf).m6188m(C1280xc.f7987xC).m6152a(C1280xc.f8231Cm, C1280xc.f8232Cn).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6194p(C1280xc.f7882vB).m6184k(C1280xc.f7865vk)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6325a(new C1117uQ(2.5f, 4.375f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: nf */
    public static final DeferredHolder<Item, ? extends C1144ur> f7277nf = f7103a.registerItem("gun_winchester_1895", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_winchester_1895", properties).m6352a(5, 20).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8233Co).m6156b(C1280xc.f8234Cp).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7922wp, C1280xc.f7923wq).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw)).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5559fS)).m6325a(new C1117uQ(4.8f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ng */
    public static final DeferredHolder<Item, ? extends C1144ur> f7278ng = f7103a.registerItem("gun_mp41", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_mp41", properties).m6352a(32, 96).mo5934a(C1110uJ.f5840gw).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8059yW).m6171b(C1280xc.f7953wU, C1280xc.f7954wV).m6174i(C1280xc.f7944wL).m6178d(C1280xc.f7898vR, C1280xc.f7907wa).m6188m(C1280xc.f7987xC).m6152a(C1280xc.f8055yS, C1280xc.f8056yT).m6167g(C1280xc.f7851uW).m6169h(C1280xc.f7860vf).m6205u(C1280xc.f8252CH).m6207v(C1280xc.f8253CI).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6150a(C1280xc.f8057yU, true).m6194p(C1280xc.f7882vB).m6184k(C1280xc.f7865vk)).mo5948b(0.05f).m6419a(GunType.SMG).mo5948b(0.3f)).m6418a(C1097tx.f5769a).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5561fU)).m6388b("smg").m6409a(C1280xc.f8058yV).m6325a(new C1117uQ(2.75f, 5.0f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 2), new C1119uS(EnumC1120uT.SEMI, 2)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: nh */
    public static final DeferredHolder<Item, ? extends C1144ur> f7279nh = f7103a.registerItem("gun_type18_shotgun", properties -> {
        return ((C1144ur) new C1144ur("gun_type18_shotgun", properties).m6352a(1, 18).mo5934a(C1110uJ.f5847gD).m6356e(64).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7989xE).m6154a(C1280xc.f8141AA).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7920wn, C1280xc.f7921wo).m6188m(C1280xc.f7986xB).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7877vw).m6150a(C1280xc.f8142AB, true)).m6330a(C0418hH.f2660c).mo5948b(0.2f).m6419a(GunType.SHOTGUN).m6418a(C1097tx.f5778j).m6388b("shell").m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5568gb)).m6325a(new C1116uP(2.0f, 0.58f, 1.25f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv, f7092tu).m6227a(f7093b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: ni */
    public static final DeferredHolder<Item, ? extends C1144ur> f7280ni = f7103a.registerItem("gun_de_lisle_carbine", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_de_lisle_carbine", properties).m6352a(11, 33).mo5934a(C1110uJ.f5837gt).m6344a(C1118uR.f5872b.clone().m6217a(1.5f).m6154a(C1280xc.f8155AO).m6171b(C1280xc.f7936wD, C1280xc.f7937wE).m6174i(C1280xc.f7943wK).m6178d(C1280xc.f7897vQ, C1280xc.f7905vY).m6181j(C1280xc.f7906vZ).m6188m(C1280xc.f7986xB).m6156b(C1280xc.f8157AQ).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8254CJ).m6174i(null).m6178d(null, null).m6186l(null).m6167g(null).m6169h(null)).m6337c(false).m6330a(C0418hH.f2660c).mo5948b(0.15f).m6419a(GunType.RIFLE).mo5948b(0.25f)).m6418a(C1097tx.f5771c).m6328a(C1108uH.a.DEFAULT, new C1108uH()).m6328a(C1108uH.a.SCOPE, new C1108uH(true, 0.8f, "scope_kar98k", false).m6110a(0.5f)).mo5934a(C1052tE.f5559fS)).m6325a(new C1117uQ(3.75f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, f7094tv)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: nj */
    public static final DeferredHolder<Item, ? extends C1144ur> f7281nj = f7103a.registerItem("gun_browning_a5", properties -> {
        return ((C1144ur) new C1144ur("gun_browning_a5", properties).m6352a(5, 15).mo5934a(C1110uJ.f5847gD).m6356e(64).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8050yN).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7920wn, C1280xc.f7921wo).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7968xj, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7875vu).m6160d(C1280xc.f8258CN).m6217a(0.95f)).m6330a(C0418hH.f2660c).mo5948b(0.2f).m6419a(GunType.SHOTGUN).m6418a(C1097tx.f5778j).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5568gb)).m6388b("shell").m6325a(new C1116uP(0.83f, 0.75f, 1.5f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 6, f7092tu).m6227a(f7093b)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: nk */
    public static final DeferredHolder<Item, ? extends C1144ur> f7282nk = f7103a.registerItem("gun_type4_70mm", properties -> {
        C1144ur c1144ur = (C1144ur) new C1144ur("gun_type4_70mm", properties).m6352a(1, 4).mo5934a(C1110uJ.f5833gp).m6344a(C1118uR.f5872b.clone().m6212w(C1280xc.f7990xF).m6154a(C1280xc.f8031yu).m6171b(C1280xc.f7934wB, C1280xc.f7935wC).m6169h(C1280xc.f7861vg).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7973xo)).m6358g().m6335b(false).mo5948b(0.5f).m6419a(GunType.ROCKET).m6418a(C1097tx.f5776h).m6346e().m6340b().m6330a(C0418hH.f2663f).m6328a(C1108uH.a.DEFAULT, new C1108uH(true, 0.3f, 0.1f, false)).mo5934a(C1052tE.f5566fZ);
        EnumC1120uT enumC1120uT = EnumC1120uT.SEMI;
        DeferredHolder<EntityType<?>, EntityType<C0760nf>> deferredHolder = C1230wX.f7051kU;
        Objects.requireNonNull(deferredHolder);
        return c1144ur.m6349a(new C1119uS[]{new C1119uS(enumC1120uT, 5, (Supplier<EntityType<? extends InterfaceC0724mw>>) deferredHolder::get)}).m6325a(new C1117uQ(3.5f));
    });

    /* JADX INFO: renamed from: nl */
    public static final DeferredHolder<Item, ? extends C1144ur> f7283nl = f7103a.registerItem("gun_wz_35", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_wz_35", properties).m6352a(4, 4).mo5947a(0.2f)).m6385d(2.0f).mo5934a(C1110uJ.f5844gA).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8235Cq).m6150a(C1280xc.f8237Cs, true).m6156b(C1280xc.f8236Cr).m6167g(C1280xc.f7853uY).m6169h(C1280xc.f7859ve).m6171b(C1280xc.f7924wr, C1280xc.f7925ws).m6205u(C1280xc.f8250CF).m6207v(C1280xc.f8251CG).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6186l(C1280xc.f7972xn).m6194p(C1280xc.f7880vz).m6190n(C1280xc.f7875vu).m6214x(C1280xc.f7835uG).m6217a(0.95f)).m6335b(false).m6330a(C0418hH.f2665h).m6358g().mo5948b(0.4f).m6419a(GunType.AT).mo5948b(0.1f)).m6418a(C1097tx.f5777i).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5567ga)).m6325a(new C1117uQ(4.25f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 30)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: nm */
    public static final DeferredHolder<Item, ? extends C1144ur> f7284nm = f7103a.registerItem("gun_flak38", properties -> {
        return ((C1144ur) ((C1144ur) ((C1144ur) new C1144ur("gun_flak38", properties).m6352a(20, 60).mo5934a(C1110uJ.f5844gA).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8238Ct).m6151a(C1280xc.f8239Cu, false, 1).m6152a(C1280xc.f8020yj, C1280xc.f8021yk).m6167g(C1280xc.f7847uS).m6169h(C1280xc.f7857vc).m6171b(C1280xc.f7932wz, C1280xc.f7933wA).m6174i(C1280xc.f7941wI).m6178d(C1280xc.f7895vO, C1280xc.f7901vU).m6181j(C1280xc.f7902vV).m6205u(C1280xc.f8248CD).m6207v(C1280xc.f8249CE).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6160d(C1280xc.f8255CK).m6192o(C1280xc.f7873vs).m6217a(0.95f)).m6320a(new Vec3(1.0d, -0.30000001192092896d, -0.30000001192092896d), new Vec3(0.0d, -0.25d, 0.0d)).m6385d(0.75f).mo5947a(0.5f)).mo5948b(0.25f).m6419a(GunType.LMG).mo5948b(0.2f)).m6418a(C1097tx.f5775g).m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5563fW)).m6388b("mg").m6325a(new C1117uQ(3.5f, 5.25f)).m6358g().m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.AUTO, 4), new C1119uS(EnumC1120uT.SEMI, 4)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    /* JADX INFO: renamed from: nn */
    public static final DeferredHolder<Item, ? extends C1144ur> f7285nn = f7103a.registerItem("gun_nagant_m1895", properties -> {
        return ((C1144ur) ((C1144ur) new C1144ur("gun_nagant_m1895", properties).m6352a(7, 21).mo5934a(C1110uJ.f5835gr).m6344a(C1118uR.f5872b.clone().m6154a(C1280xc.f8146AF).m6162e(C1280xc.f7884vD).m6151a(C1280xc.f8147AG, true, 1).m6156b(C1280xc.f8148AH).m6167g(C1280xc.f7852uX).m6169h(C1280xc.f7858vd).m6205u(C1280xc.f8246CB).m6207v(C1280xc.f8247CC).m6149a(C1280xc.f7963xe, C1280xc.f7965xg, C1280xc.f7966xh, C1280xc.f7964xf, C1280xc.f7967xi).m6171b(C1280xc.f7945wM, C1280xc.f7946wN).m6188m(C1280xc.f7985xA).m6186l(C1280xc.f7971xm).m6190n(C1280xc.f7876vv).m6160d(C1280xc.f8257CM).m6212w(C1280xc.f7992xH).m6217a(1.2f)).m6330a(C0418hH.f2659b).m6332a(true).mo5948b(0.025f).m6419a(GunType.PISTOL).mo5948b(0.35f)).m6418a(C1097tx.f5781m).m6330a(C0418hH.f2664g).m6345d().m6342c().m6328a(C1108uH.a.DEFAULT, new C1108uH()).mo5934a(C1052tE.f5558fR)).m6388b("pistol").m6325a(new C1117uQ(11.1f)).m6349a(new C1119uS[]{new C1119uS(EnumC1120uT.SEMI, 10)});
    }, new Item.Properties().stacksTo(1).component(DataComponents.TOOL, C1058tK.m5895a()));

    static {
        for (DeferredHolder deferredHolder : C1218wL.f6425b.getEntries()) {
            f7103a.register(deferredHolder.getId().getPath(), () -> {
                return new BlockItem((Block) deferredHolder.get(), new Item.Properties());
            });
        }
        for (DeferredHolder deferredHolder2 : C1218wL.f6426c.getEntries()) {
            f7103a.register(deferredHolder2.getId().getPath(), () -> {
                return new BlockItem((Block) deferredHolder2.get(), new Item.Properties());
            });
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Optional<Item> m7409a(@NotNull CloudResourceLocation cloudResourceLocation) {
        return m7410a(ResourceLocation.fromNamespaceAndPath(cloudResourceLocation.namespace(), cloudResourceLocation.path()));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Optional<Item> m7410a(@NotNull ResourceLocation resourceLocation) {
        return BuiltInRegistries.ITEM.getOptional(resourceLocation);
    }
}
