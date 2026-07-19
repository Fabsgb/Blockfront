package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sf.class */
public class C0492sf {

    @NotNull
    private static final Int2ObjectMap<C0491se> e = (Int2ObjectMap) Util.make(new Int2ObjectOpenHashMap(), int2ObjectOpenHashMap -> {
        int2ObjectOpenHashMap.put(0, new C0491se(0, "Herman"));
        int2ObjectOpenHashMap.put(1, new C0491se(1, "Michael"));
        int2ObjectOpenHashMap.put(2, new C0491se(2, "Monty"));
        int2ObjectOpenHashMap.put(3, new C0491se(3, "Tokarev"));
        int2ObjectOpenHashMap.put(4, new C0491se(4, "Emeryk"));
        int2ObjectOpenHashMap.put(5, new C0491se(5, "Hiroko"));
    });

    @NotNull
    public static C0491se a(int i) {
        return (C0491se) e.get(i);
    }
}
