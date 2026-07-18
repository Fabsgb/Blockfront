package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pC.class */
public class C0837pC {

    /* JADX INFO: renamed from: N */
    @NotNull
    private static final Map<String, Class<? extends AbstractC0835pA>> f4478N = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: O */
    @NotNull
    private static final Map<Class<? extends AbstractC0835pA>, String> f4479O = new Object2ObjectOpenHashMap();

    static {
        m4260a("fly_by", C0915qb.class);
        m4260a("fly_by_entities", C0916qc.class);
        m4260a("mist", C0919qf.class);
        m4260a("pathed_vehicle_entities", C0921qh.class);
        m4260a("positioned_bombing_flash", C0924qk.class);
        m4260a("positioned_bullet_tracer", C0925ql.class);
        m4260a("positioned_timed_sound", C0932qs.class);
        m4260a("positioned_particle", C0929qp.class);
        m4260a("positioned_rocket_barrage", C0930qq.class);
        m4260a("positioned_rocket", C0931qr.class);
        m4260a("sky_planes", C0936qw.class);
        m4260a("surrender_paper", C0938qy.class);
        m4260a("watchlight", C0890qC.class);
        m4260a("positioned_artillery_gun", C0923qj.class);
        m4260a("falling_artillery", C0914qa.class);
        m4260a("random_explosion", C0934qu.class);
        m4260a("lightning", C0917qd.class);
        m4260a("positioned_looping_sound", C0928qo.class);
        m4260a("positioned_entity", C0926qm.class);
        m4260a("water_color", C0891qD.class);
        m4260a("shader", C0935qv.class);
        m4260a("time", C0888qA.class);
        m4260a("sky_settings", C0937qx.class);
        m4260a("weather", C0892qE.class);
        m4260a("map_name", C0918qe.class);
        m4260a("author", C0860pZ.class);
        m4260a("teams", C0939qz.class);
        m4260a("music_set", C0920qg.class);
        m4260a("positioned_light_source", C0927qn.class);
        m4260a("positioned_area_light_source", C0922qi.class);
        m4260a("positioned_vehicle", C0933qt.class);
        m4260a("trigger_condition", C0889qB.class);
    }

    /* JADX INFO: renamed from: a */
    public static void m4260a(@NotNull String str, @NotNull Class<? extends AbstractC0835pA> cls) {
        f4478N.put(str, cls);
        f4479O.put(cls, str);
    }

    /* JADX INFO: renamed from: a */
    public static Class<?> m4261a(@NotNull String str) {
        if (!f4478N.containsKey(str)) {
            throw new IllegalArgumentException("Invalid map-effect section type key: " + str);
        }
        return f4478N.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m4262a(@NotNull Class<?> cls) {
        String str = f4479O.get(cls);
        if (str == null) {
            throw new IllegalArgumentException("Invalid map-effect section type class: " + String.valueOf(cls));
        }
        return str;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public static Set<String> m4263l() {
        return f4478N.keySet();
    }
}
