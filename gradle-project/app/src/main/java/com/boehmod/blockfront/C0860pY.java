package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pY.class */
public class C0860pY {

    /* JADX INFO: renamed from: N */
    @NotNull
    private static final Map<String, Class<? extends AbstractC0858pW>> f4607N = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: O */
    @NotNull
    private static final Map<Class<? extends AbstractC0858pW>, String> f4608O = new Object2ObjectOpenHashMap();

    static {
        m3990a("fly_by", C0938qx.class);
        m3990a("fly_by_entities", C0939qy.class);
        m3990a("mist", C0890qB.class);
        m3990a("pathed_vehicle_entities", C0892qD.class);
        m3990a("positioned_bombing_flash", C0895qG.class);
        m3990a("positioned_bullet_tracer", C0896qH.class);
        m3990a("positioned_timed_sound", C0904qP.class);
        m3990a("positioned_particle", C0900qL.class);
        m3990a("positioned_rocket_barrage", C0901qM.class);
        m3990a("positioned_rocket", C0902qN.class);
        m3990a("sky_planes", C0908qT.class);
        m3990a("surrender_paper", C0910qV.class);
        m3990a("watchlight", C0914qZ.class);
        m3990a("positioned_artillery_gun", C0894qF.class);
        m3990a("falling_artillery", C0937qw.class);
        m3990a("random_explosion", C0906qR.class);
        m3990a("lightning", C0940qz.class);
        m3990a("positioned_looping_sound", C0899qK.class);
        m3990a("positioned_entity", C0897qI.class);
        m3990a("water_color", C0968ra.class);
        m3990a("shader", C0907qS.class);
        m3990a("time", C0912qX.class);
        m3990a("sky_settings", C0909qU.class);
        m3990a("weather", C0969rb.class);
        m3990a("map_name", C0889qA.class);
        m3990a("author", C0936qv.class);
        m3990a("teams", C0911qW.class);
        m3990a("music_set", C0891qC.class);
        m3990a("positioned_light_source", C0898qJ.class);
        m3990a("positioned_area_light_source", C0893qE.class);
        m3990a("positioned_spot_light_source", C0903qO.class);
        m3990a("positioned_vehicle", C0905qQ.class);
        m3990a("trigger_condition", C0913qY.class);
    }

    /* JADX INFO: renamed from: a */
    public static void m3990a(@NotNull String str, @NotNull Class<? extends AbstractC0858pW> cls) {
        f4607N.put(str, cls);
        f4608O.put(cls, str);
    }

    /* JADX INFO: renamed from: a */
    public static Class<?> m3991a(@NotNull String str) {
        if (!f4607N.containsKey(str)) {
            throw new IllegalArgumentException("Invalid map-effect section type key: " + str);
        }
        return f4607N.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m3992a(@NotNull Class<?> cls) {
        String str = f4608O.get(cls);
        if (str == null) {
            throw new IllegalArgumentException("Invalid map-effect section type class: " + String.valueOf(cls));
        }
        return str;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public static Set<String> m3993l() {
        return f4607N.keySet();
    }
}
