package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.o */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/o.class */
@OnlyIn(Dist.CLIENT)
public final class C0782o {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Map<String, AbstractC0858pW> f4326a = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final Map<UUID, String> f4327b = new Object2ObjectOpenHashMap();

    private C0782o() {
    }

    /* JADX INFO: renamed from: a */
    public static void m3658a(@NotNull Map<String, AbstractC0858pW> map, @NotNull Map<UUID, String> map2) {
        f4326a.clear();
        f4326a.putAll(map);
        f4327b.clear();
        f4327b.putAll(map2);
    }

    /* JADX INFO: renamed from: e */
    public static void m3659e() {
        f4326a.clear();
        f4327b.clear();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3660b(@NotNull UUID uuid) {
        return f4327b.containsKey(uuid);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static String m3661a(@NotNull UUID uuid) {
        return f4327b.get(uuid);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static AbstractC0858pW m3662a(@NotNull String str) {
        return f4326a.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static List<String> m3663a() {
        return new ObjectArrayList(f4326a.keySet());
    }
}
