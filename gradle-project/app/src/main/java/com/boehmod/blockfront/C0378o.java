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

/* JADX INFO: renamed from: com.boehmod.blockfront.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/o.class */
@OnlyIn(Dist.CLIENT)
public final class C0378o {

    @NotNull
    private static final Map<String, pA> a = new Object2ObjectOpenHashMap();

    @NotNull
    private static final Map<UUID, String> b = new Object2ObjectOpenHashMap();

    private C0378o() {
    }

    public static void a(@NotNull Map<String, pA> map, @NotNull Map<UUID, String> map2) {
        a.clear();
        a.putAll(map);
        b.clear();
        b.putAll(map2);
    }

    public static void e() {
        a.clear();
        b.clear();
    }

    public static boolean b(@NotNull UUID uuid) {
        return b.containsKey(uuid);
    }

    @Nullable
    public static String a(@NotNull UUID uuid) {
        return b.get(uuid);
    }

    @Nullable
    public static pA a(@NotNull String str) {
        return a.get(str);
    }

    @NotNull
    public static List<String> a() {
        return new ObjectArrayList(a.keySet());
    }
}
