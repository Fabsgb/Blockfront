package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.bytes.Byte2ObjectMap;
import it.unimi.dsi.fastutil.bytes.Byte2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ByteMap;
import it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pu.class */
public class C0426pu {

    @NotNull
    private static final Byte2ObjectMap<Class<?>> a = new Byte2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private static final Object2ByteMap<Class<?>> f280a = new Object2ByteOpenHashMap();

    static {
        a((byte) 1, C0427pv.class);
        a((byte) 2, C0424ps.class);
        a((byte) 3, C0423pr.class);
        a((byte) 4, C0425pt.class);
    }

    public static void a(byte b, @NotNull Class<?> cls) {
        a.put(b, cls);
        f280a.put(cls, b);
    }

    @Nullable
    public static Class<?> a(byte b) {
        if (!a.containsKey(b)) {
            throw new IllegalArgumentException("Invalid kill-feed section type byte: " + b);
        }
        return (Class) a.get(b);
    }

    public static byte a(@NotNull Class<?> cls) {
        if (!f280a.containsKey(cls)) {
            throw new IllegalArgumentException("Invalid kill-feed section type class: " + String.valueOf(cls));
        }
        return f280a.getByte(cls);
    }
}
