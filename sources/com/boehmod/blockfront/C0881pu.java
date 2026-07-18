package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.bytes.Byte2ObjectMap;
import it.unimi.dsi.fastutil.bytes.Byte2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ByteMap;
import it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pu.class */
public class C0881pu {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Byte2ObjectMap<Class<?>> f4608a = new Byte2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Object2ByteMap<Class<?>> f4609a = new Object2ByteOpenHashMap();

    static {
        m4442a((byte) 1, C0882pv.class);
        m4442a((byte) 2, C0879ps.class);
        m4442a((byte) 3, C0878pr.class);
        m4442a((byte) 4, C0880pt.class);
    }

    /* JADX INFO: renamed from: a */
    public static void m4442a(byte b, @NotNull Class<?> cls) {
        f4608a.put(b, cls);
        f4609a.put(cls, b);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static Class<?> m4443a(byte b) {
        if (!f4608a.containsKey(b)) {
            throw new IllegalArgumentException("Invalid kill-feed section type byte: " + b);
        }
        return (Class) f4608a.get(b);
    }

    /* JADX INFO: renamed from: a */
    public static byte m4444a(@NotNull Class<?> cls) {
        if (!f4609a.containsKey(cls)) {
            throw new IllegalArgumentException("Invalid kill-feed section type class: " + String.valueOf(cls));
        }
        return f4609a.getByte(cls);
    }
}
