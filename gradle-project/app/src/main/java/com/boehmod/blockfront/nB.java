package com.boehmod.blockfront;

import net.minecraft.client.renderer.CubeMap;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nB.class */
public class nB {
    public static final CubeMap b = new CubeMap(C0265jv.d("textures/gui/vehicle/panorama/tank_driver/panorama"));
    public static final CubeMap c = new CubeMap(C0265jv.d("textures/gui/vehicle/panorama/tank_sherman_gunner/panorama"));
    public static final CubeMap d = new CubeMap(C0265jv.d("textures/gui/vehicle/panorama/tank_chiha_gunner/panorama"));
    public static final CubeMap e = new CubeMap(C0265jv.d("textures/gui/vehicle/panorama/tank_panzeriv_gunner/panorama"));

    @Nullable
    public static CubeMap a(String str) {
        switch (str) {
            case "tank_driver":
                return b;
            case "tank_sherman_gunner":
                return c;
            case "tank_chiha_gunner":
                return d;
            case "tank_panzeriv_gunner":
                return e;
            default:
                return null;
        }
    }
}
