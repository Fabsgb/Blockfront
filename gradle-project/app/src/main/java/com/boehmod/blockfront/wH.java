package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wH.class */
public class wH {
    public static void dD() {
        dE();
        c("stone_fancy_0", "pumice_stone");
        c("stone_fancy_1", "slate_rough");
        c("stone_fancy_2", "deep_rock_rough");
        c("stone_fancy_3", "ozark_stone");
        c("stone_fancy_4", "fossil_rough");
        c("stone_fancy_5", "scoria_stone");
        c("stone_fancy_6", "chert_stone");
        c("stone_fancy_7", "limestone_stone");
        c("stone_fancy_8", "coquina_stone");
        c("stone_fancy_9", "soapstone_stone");
        c("stone_fancy_10", "quartzite_rough");
        c("stone_fancy_11", "moonrock_windswept");
        c("stone_fancy_12", "shale_smooth");
        c("stone_fancy_13", "breccia_smooth");
        c("stone_fancy_14", "breccia_rough");
        c("stone_powder_0", "breccia_powder");
        c("redsandstone_big_bricks", "breccia_big_bricks");
        c("redsandstone_brick", "breccia_brick");
        c("redsandstone_bricks", "breccia_bricks");
        c("redsandstone_cobbled", "breccia_cobbled");
        c("redsandstone_cobbled_tiles", "breccia_cobbled_tiles");
        c("redsandstone_cracked_brick", "breccia_cracked_brick");
        c("redsandstone_polished", "breccia_polished");
        c("redsandstone_polished_brick", "breccia_polished_brick");
        c("redsandstone_polished_smooth_brick", "breccia_polished_smooth_brick");
        c("redsandstone_powder", "breccia_powder");
        c("redsandstone_rough", "breccia_rough");
        c("redsandstone_smooth", "breccia_smooth");
        c("redsandstone_smooth_brick", "breccia_smooth_brick");
        c("redsandstone_smooth_cracked_brick", "breccia_smooth_cracked_brick");
        c("redsandstone_smooth_windswept", "breccia_smooth_windswept");
        c("redsandstone_stone", "breccia_stone");
        c("redsandstone_tiles", "breccia_tiles");
        c("redsandstone_windswept", "breccia_windswept");
        c("bricks_fancy_0", "chert_bricks");
        c("bricks_fancy_1", "augite_bricks");
        c("bricks_fancy_2", "hematite_bricks");
        c("bricks_fancy_3", "assorted_bricks");
        c("stone_bricks_fancy_0", "pumice_brick");
        c("stone_bricks_fancy_1", "mud_brick");
        c("stone_bricks_fancy_2", "chert_big_bricks");
        c("stone_bricks_fancy_3", "scoria_brick");
        c("stone_bricks_fancy_4", "hematite_big_bricks");
        c("stone_bricks_fancy_5", "half_n_half_bricks");
        c("stone_bricks_fancy_6", "pumice_brick");
        c("stone_bricks_fancy_7", "slate_brick");
        c("stone_bricks_fancy_8", "limestone_smooth_brick");
        c("stone_bricks_fancy_9", "pumice_smooth_brick");
        c("stone_bricks_fancy_10", "limestone_tiles");
        c("stone_bricks_fancy_11", "pumice_tiles");
        c("stone_bricks_fancy_12", "deepslate_tiles");
        c("stone_bricks_fancy_13", "sandstone_tiles");
        c("stone_bricks_fancy_14", "tuff_tiles");
        d("oil_barrel_black", "oil_barrel_gray");
    }

    public static void dE() {
        ObjectListIterator it = lG.H.iterator();
        while (it.hasNext()) {
            lG lGVar = (lG) it.next();
            String str = lGVar.bk + "_big_open";
            String str2 = lGVar.bk + "_field_open";
            d(str, str2);
            b(str, str2);
        }
    }

    public static void b(String str, String str2) {
        wJ.a.addAlias(ResourceLocation.fromNamespaceAndPath("bf", str), ResourceLocation.fromNamespaceAndPath("bf", str2));
    }

    public static void c(String str, String str2) {
        d(str, str2);
        d(str + "_slab", str2 + "_slab");
        d(str + "_stair", str2 + "_stair");
        d(str + "_wall", str2 + "_wall");
    }

    public static void d(String str, String str2) {
        wL.b.addAlias(ResourceLocation.fromNamespaceAndPath("bf", str), ResourceLocation.fromNamespaceAndPath("bf", str2));
    }
}
