package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sf.class */
public class C1026sf {

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final Int2ObjectMap<C1024se> f5440e = (Int2ObjectMap) Util.make(new Int2ObjectOpenHashMap(), int2ObjectOpenHashMap -> {
        int2ObjectOpenHashMap.put(0, new C1024se(0, "Herman"));
        int2ObjectOpenHashMap.put(1, new C1024se(1, "Michael"));
        int2ObjectOpenHashMap.put(2, new C1024se(2, "Monty"));
        int2ObjectOpenHashMap.put(3, new C1024se(3, "Tokarev"));
        int2ObjectOpenHashMap.put(4, new C1024se(4, "Emeryk"));
        int2ObjectOpenHashMap.put(5, new C1024se(5, "Hiroko"));
    });

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1024se m5717a(int i) {
        return (C1024se) f5440e.get(i);
    }
}
