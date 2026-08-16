package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.bytes.Byte2ObjectMap;
import it.unimi.dsi.fastutil.bytes.Byte2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ByteMap;
import it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pQ.class */
public class C0852pQ {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Byte2ObjectMap<Class<?>> f4577a = new Byte2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Object2ByteMap<Class<?>> f4578a = new Object2ByteOpenHashMap();

    static {
        m3930a((byte) 1, C0853pR.class);
        m3930a((byte) 2, C0850pO.class);
        m3930a((byte) 3, C0849pN.class);
        m3930a((byte) 4, C0851pP.class);
    }

    /* JADX INFO: renamed from: a */
    public static void m3930a(byte b, @NotNull Class<?> cls) {
        f4577a.put(b, cls);
        f4578a.put(cls, b);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static Class<?> m3931a(byte b) {
        if (!f4577a.containsKey(b)) {
            throw new IllegalArgumentException("Invalid kill-feed section type byte: " + b);
        }
        return (Class) f4577a.get(b);
    }

    /* JADX INFO: renamed from: a */
    public static byte m3932a(@NotNull Class<?> cls) {
        if (!f4578a.containsKey(cls)) {
            throw new IllegalArgumentException("Invalid kill-feed section type class: " + String.valueOf(cls));
        }
        return f4578a.getByte(cls);
    }
}
