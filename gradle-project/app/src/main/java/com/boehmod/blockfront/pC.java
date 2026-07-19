package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pC.class */
public class pC {

    @NotNull
    private static final Map<String, Class<? extends pA>> N = new Object2ObjectOpenHashMap();

    @NotNull
    private static final Map<Class<? extends pA>, String> O = new Object2ObjectOpenHashMap();

    static {
        a("fly_by", C0434qb.class);
        a("fly_by_entities", C0435qc.class);
        a("mist", C0438qf.class);
        a("pathed_vehicle_entities", C0440qh.class);
        a("positioned_bombing_flash", C0443qk.class);
        a("positioned_bullet_tracer", C0444ql.class);
        a("positioned_timed_sound", C0451qs.class);
        a("positioned_particle", C0448qp.class);
        a("positioned_rocket_barrage", C0449qq.class);
        a("positioned_rocket", C0450qr.class);
        a("sky_planes", C0455qw.class);
        a("surrender_paper", C0457qy.class);
        a("watchlight", qC.class);
        a("positioned_artillery_gun", C0442qj.class);
        a("falling_artillery", C0433qa.class);
        a("random_explosion", C0453qu.class);
        a("lightning", C0436qd.class);
        a("positioned_looping_sound", C0447qo.class);
        a("positioned_entity", C0445qm.class);
        a("water_color", qD.class);
        a("shader", C0454qv.class);
        a("time", qA.class);
        a("sky_settings", C0456qx.class);
        a("weather", qE.class);
        a("map_name", C0437qe.class);
        a("author", pZ.class);
        a("teams", C0458qz.class);
        a("music_set", C0439qg.class);
        a("positioned_light_source", C0446qn.class);
        a("positioned_area_light_source", C0441qi.class);
        a("positioned_vehicle", C0452qt.class);
        a("trigger_condition", qB.class);
    }

    public static void a(@NotNull String str, @NotNull Class<? extends pA> cls) {
        N.put(str, cls);
        O.put(cls, str);
    }

    public static Class<?> a(@NotNull String str) {
        if (!N.containsKey(str)) {
            throw new IllegalArgumentException("Invalid map-effect section type key: " + str);
        }
        return N.get(str);
    }

    @NotNull
    public static String a(@NotNull Class<?> cls) {
        String str = O.get(cls);
        if (str == null) {
            throw new IllegalArgumentException("Invalid map-effect section type class: " + String.valueOf(cls));
        }
        return str;
    }

    @NotNull
    public static Set<String> l() {
        return N.keySet();
    }
}
