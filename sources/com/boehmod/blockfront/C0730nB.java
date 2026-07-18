package com.boehmod.blockfront;

import net.minecraft.client.renderer.CubeMap;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.nB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nB.class */
public class C0730nB {

    /* JADX INFO: renamed from: b */
    public static final CubeMap f3912b = new CubeMap(C0564jv.m2555d("textures/gui/vehicle/panorama/tank_driver/panorama"));

    /* JADX INFO: renamed from: c */
    public static final CubeMap f3913c = new CubeMap(C0564jv.m2555d("textures/gui/vehicle/panorama/tank_sherman_gunner/panorama"));

    /* JADX INFO: renamed from: d */
    public static final CubeMap f3914d = new CubeMap(C0564jv.m2555d("textures/gui/vehicle/panorama/tank_chiha_gunner/panorama"));

    /* JADX INFO: renamed from: e */
    public static final CubeMap f3915e = new CubeMap(C0564jv.m2555d("textures/gui/vehicle/panorama/tank_panzeriv_gunner/panorama"));

    @Nullable
    /* JADX INFO: renamed from: a */
    public static CubeMap m3301a(String str) {
        switch (str) {
            case "tank_driver":
                return f3912b;
            case "tank_sherman_gunner":
                return f3913c;
            case "tank_chiha_gunner":
                return f3914d;
            case "tank_panzeriv_gunner":
                return f3915e;
            default:
                return null;
        }
    }
}
