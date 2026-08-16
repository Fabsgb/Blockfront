package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sC.class */
public class C0997sC {

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final Int2ObjectMap<C0996sB> f5487f = (Int2ObjectMap) Util.make(new Int2ObjectOpenHashMap(), int2ObjectOpenHashMap -> {
        int2ObjectOpenHashMap.put(0, new C0996sB(0, "Herman"));
        int2ObjectOpenHashMap.put(1, new C0996sB(1, "Michael"));
        int2ObjectOpenHashMap.put(2, new C0996sB(2, "Monty"));
        int2ObjectOpenHashMap.put(3, new C0996sB(3, "Tokarev"));
        int2ObjectOpenHashMap.put(4, new C0996sB(4, "Emeryk"));
        int2ObjectOpenHashMap.put(5, new C0996sB(5, "Hiroko"));
    });

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0996sB m5602a(int i) {
        return (C0996sB) f5487f.get(i);
    }
}
