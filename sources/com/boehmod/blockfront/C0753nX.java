package com.boehmod.blockfront;

import net.minecraft.client.renderer.CubeMap;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.nX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nX.class */
public class C0753nX {

    /* JADX INFO: renamed from: b */
    public static final CubeMap f4160b = new CubeMap(C0532jO.m2378d("textures/gui/vehicle/panorama/tank_driver/panorama"));

    /* JADX INFO: renamed from: c */
    public static final CubeMap f4161c = new CubeMap(C0532jO.m2378d("textures/gui/vehicle/panorama/tank_sherman_gunner/panorama"));

    /* JADX INFO: renamed from: d */
    public static final CubeMap f4162d = new CubeMap(C0532jO.m2378d("textures/gui/vehicle/panorama/tank_chiha_gunner/panorama"));

    /* JADX INFO: renamed from: e */
    public static final CubeMap f4163e = new CubeMap(C0532jO.m2378d("textures/gui/vehicle/panorama/tank_panzeriv_gunner/panorama"));

    @Nullable
    /* JADX INFO: renamed from: a */
    public static CubeMap m3488a(String str) {
        switch (str) {
            case "tank_driver":
                return f4160b;
            case "tank_sherman_gunner":
                return f4161c;
            case "tank_chiha_gunner":
                return f4162d;
            case "tank_panzeriv_gunner":
                return f4163e;
            default:
                return null;
        }
    }
}
