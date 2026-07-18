package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: renamed from: com.boehmod.blockfront.wH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wH.class */
public class C1214wH {
    /* JADX INFO: renamed from: dD */
    public static void m6735dD() {
        m6736dE();
        m6738c("stone_fancy_0", "pumice_stone");
        m6738c("stone_fancy_1", "slate_rough");
        m6738c("stone_fancy_2", "deep_rock_rough");
        m6738c("stone_fancy_3", "ozark_stone");
        m6738c("stone_fancy_4", "fossil_rough");
        m6738c("stone_fancy_5", "scoria_stone");
        m6738c("stone_fancy_6", "chert_stone");
        m6738c("stone_fancy_7", "limestone_stone");
        m6738c("stone_fancy_8", "coquina_stone");
        m6738c("stone_fancy_9", "soapstone_stone");
        m6738c("stone_fancy_10", "quartzite_rough");
        m6738c("stone_fancy_11", "moonrock_windswept");
        m6738c("stone_fancy_12", "shale_smooth");
        m6738c("stone_fancy_13", "breccia_smooth");
        m6738c("stone_fancy_14", "breccia_rough");
        m6738c("stone_powder_0", "breccia_powder");
        m6738c("redsandstone_big_bricks", "breccia_big_bricks");
        m6738c("redsandstone_brick", "breccia_brick");
        m6738c("redsandstone_bricks", "breccia_bricks");
        m6738c("redsandstone_cobbled", "breccia_cobbled");
        m6738c("redsandstone_cobbled_tiles", "breccia_cobbled_tiles");
        m6738c("redsandstone_cracked_brick", "breccia_cracked_brick");
        m6738c("redsandstone_polished", "breccia_polished");
        m6738c("redsandstone_polished_brick", "breccia_polished_brick");
        m6738c("redsandstone_polished_smooth_brick", "breccia_polished_smooth_brick");
        m6738c("redsandstone_powder", "breccia_powder");
        m6738c("redsandstone_rough", "breccia_rough");
        m6738c("redsandstone_smooth", "breccia_smooth");
        m6738c("redsandstone_smooth_brick", "breccia_smooth_brick");
        m6738c("redsandstone_smooth_cracked_brick", "breccia_smooth_cracked_brick");
        m6738c("redsandstone_smooth_windswept", "breccia_smooth_windswept");
        m6738c("redsandstone_stone", "breccia_stone");
        m6738c("redsandstone_tiles", "breccia_tiles");
        m6738c("redsandstone_windswept", "breccia_windswept");
        m6738c("bricks_fancy_0", "chert_bricks");
        m6738c("bricks_fancy_1", "augite_bricks");
        m6738c("bricks_fancy_2", "hematite_bricks");
        m6738c("bricks_fancy_3", "assorted_bricks");
        m6738c("stone_bricks_fancy_0", "pumice_brick");
        m6738c("stone_bricks_fancy_1", "mud_brick");
        m6738c("stone_bricks_fancy_2", "chert_big_bricks");
        m6738c("stone_bricks_fancy_3", "scoria_brick");
        m6738c("stone_bricks_fancy_4", "hematite_big_bricks");
        m6738c("stone_bricks_fancy_5", "half_n_half_bricks");
        m6738c("stone_bricks_fancy_6", "pumice_brick");
        m6738c("stone_bricks_fancy_7", "slate_brick");
        m6738c("stone_bricks_fancy_8", "limestone_smooth_brick");
        m6738c("stone_bricks_fancy_9", "pumice_smooth_brick");
        m6738c("stone_bricks_fancy_10", "limestone_tiles");
        m6738c("stone_bricks_fancy_11", "pumice_tiles");
        m6738c("stone_bricks_fancy_12", "deepslate_tiles");
        m6738c("stone_bricks_fancy_13", "sandstone_tiles");
        m6738c("stone_bricks_fancy_14", "tuff_tiles");
        m6739d("oil_barrel_black", "oil_barrel_gray");
    }

    /* JADX INFO: renamed from: dE */
    public static void m6736dE() {
        ObjectListIterator it = C0629lG.f3416H.iterator();
        while (it.hasNext()) {
            C0629lG c0629lG = (C0629lG) it.next();
            String str = c0629lG.f3417bk + "_big_open";
            String str2 = c0629lG.f3417bk + "_field_open";
            m6739d(str, str2);
            m6737b(str, str2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m6737b(String str, String str2) {
        C1216wJ.f6367a.addAlias(ResourceLocation.fromNamespaceAndPath("bf", str), ResourceLocation.fromNamespaceAndPath("bf", str2));
    }

    /* JADX INFO: renamed from: c */
    public static void m6738c(String str, String str2) {
        m6739d(str, str2);
        m6739d(str + "_slab", str2 + "_slab");
        m6739d(str + "_stair", str2 + "_stair");
        m6739d(str + "_wall", str2 + "_wall");
    }

    /* JADX INFO: renamed from: d */
    public static void m6739d(String str, String str2) {
        C1218wL.f6425b.addAlias(ResourceLocation.fromNamespaceAndPath("bf", str), ResourceLocation.fromNamespaceAndPath("bf", str2));
    }
}
