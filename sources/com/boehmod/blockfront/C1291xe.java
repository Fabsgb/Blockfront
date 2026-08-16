package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: renamed from: com.boehmod.blockfront.xe */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xe.class */
public class C1291xe {
    /* JADX INFO: renamed from: dN */
    public static void m7323dN() {
        m7324dO();
        m7326c("stone_fancy_0", "pumice_stone");
        m7326c("stone_fancy_1", "slate_rough");
        m7326c("stone_fancy_2", "deep_rock_rough");
        m7326c("stone_fancy_3", "ozark_stone");
        m7326c("stone_fancy_4", "fossil_rough");
        m7326c("stone_fancy_5", "scoria_stone");
        m7326c("stone_fancy_6", "chert_stone");
        m7326c("stone_fancy_7", "limestone_stone");
        m7326c("stone_fancy_8", "coquina_stone");
        m7326c("stone_fancy_9", "soapstone_stone");
        m7326c("stone_fancy_10", "quartzite_rough");
        m7326c("stone_fancy_11", "moonrock_windswept");
        m7326c("stone_fancy_12", "shale_smooth");
        m7326c("stone_fancy_13", "breccia_smooth");
        m7326c("stone_fancy_14", "breccia_rough");
        m7326c("stone_powder_0", "breccia_powder");
        m7326c("redsandstone_big_bricks", "breccia_big_bricks");
        m7326c("redsandstone_brick", "breccia_brick");
        m7326c("redsandstone_bricks", "breccia_bricks");
        m7326c("redsandstone_cobbled", "breccia_cobbled");
        m7326c("redsandstone_cobbled_tiles", "breccia_cobbled_tiles");
        m7326c("redsandstone_cracked_brick", "breccia_cracked_brick");
        m7326c("redsandstone_polished", "breccia_polished");
        m7326c("redsandstone_polished_brick", "breccia_polished_brick");
        m7326c("redsandstone_polished_smooth_brick", "breccia_polished_smooth_brick");
        m7326c("redsandstone_powder", "breccia_powder");
        m7326c("redsandstone_rough", "breccia_rough");
        m7326c("redsandstone_smooth", "breccia_smooth");
        m7326c("redsandstone_smooth_brick", "breccia_smooth_brick");
        m7326c("redsandstone_smooth_cracked_brick", "breccia_smooth_cracked_brick");
        m7326c("redsandstone_smooth_windswept", "breccia_smooth_windswept");
        m7326c("redsandstone_stone", "breccia_stone");
        m7326c("redsandstone_tiles", "breccia_tiles");
        m7326c("redsandstone_windswept", "breccia_windswept");
        m7326c("bricks_fancy_0", "chert_bricks");
        m7326c("bricks_fancy_1", "augite_bricks");
        m7326c("bricks_fancy_2", "hematite_bricks");
        m7326c("bricks_fancy_3", "assorted_bricks");
        m7326c("stone_bricks_fancy_0", "pumice_brick");
        m7326c("stone_bricks_fancy_1", "mud_brick");
        m7326c("stone_bricks_fancy_2", "chert_big_bricks");
        m7326c("stone_bricks_fancy_3", "scoria_brick");
        m7326c("stone_bricks_fancy_4", "hematite_big_bricks");
        m7326c("stone_bricks_fancy_5", "half_n_half_bricks");
        m7326c("stone_bricks_fancy_6", "pumice_brick");
        m7326c("stone_bricks_fancy_7", "slate_brick");
        m7326c("stone_bricks_fancy_8", "limestone_smooth_brick");
        m7326c("stone_bricks_fancy_9", "pumice_smooth_brick");
        m7326c("stone_bricks_fancy_10", "limestone_tiles");
        m7326c("stone_bricks_fancy_11", "pumice_tiles");
        m7326c("stone_bricks_fancy_12", "deepslate_tiles");
        m7326c("stone_bricks_fancy_13", "sandstone_tiles");
        m7326c("stone_bricks_fancy_14", "tuff_tiles");
        m7327d("oil_barrel_black", "oil_barrel_gray");
    }

    /* JADX INFO: renamed from: dO */
    public static void m7324dO() {
        ObjectListIterator it = C0705mc.f3890Q.iterator();
        while (it.hasNext()) {
            C0705mc c0705mc = (C0705mc) it.next();
            String str = c0705mc.f3891bt + "_big_open";
            String str2 = c0705mc.f3891bt + "_field_open";
            m7327d(str, str2);
            m7325b(str, str2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m7325b(String str, String str2) {
        C1293xg.f6930a.addAlias(ResourceLocation.fromNamespaceAndPath("bf", str), ResourceLocation.fromNamespaceAndPath("bf", str2));
    }

    /* JADX INFO: renamed from: c */
    public static void m7326c(String str, String str2) {
        m7327d(str, str2);
        m7327d(str + "_slab", str2 + "_slab");
        m7327d(str + "_stair", str2 + "_stair");
        m7327d(str + "_wall", str2 + "_wall");
    }

    /* JADX INFO: renamed from: d */
    public static void m7327d(String str, String str2) {
        C1295xi.f6988b.addAlias(ResourceLocation.fromNamespaceAndPath("bf", str), ResourceLocation.fromNamespaceAndPath("bf", str2));
    }
}
