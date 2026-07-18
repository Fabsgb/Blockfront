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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/o.class */
@OnlyIn(Dist.CLIENT)
public final class C0781o {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Map<String, AbstractC0835pA> f4194a = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final Map<UUID, String> f4195b = new Object2ObjectOpenHashMap();

    private C0781o() {
    }

    /* JADX INFO: renamed from: a */
    public static void m3542a(@NotNull Map<String, AbstractC0835pA> map, @NotNull Map<UUID, String> map2) {
        f4194a.clear();
        f4194a.putAll(map);
        f4195b.clear();
        f4195b.putAll(map2);
    }

    /* JADX INFO: renamed from: e */
    public static void m3543e() {
        f4194a.clear();
        f4195b.clear();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3544b(@NotNull UUID uuid) {
        return f4195b.containsKey(uuid);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static String m3545a(@NotNull UUID uuid) {
        return f4195b.get(uuid);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static AbstractC0835pA m3546a(@NotNull String str) {
        return f4194a.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static List<String> m3547a() {
        return new ObjectArrayList(f4194a.keySet());
    }
}
