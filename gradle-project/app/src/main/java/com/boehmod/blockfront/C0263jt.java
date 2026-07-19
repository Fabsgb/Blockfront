package com.boehmod.blockfront;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jt.class */
public class C0263jt {

    @NotNull
    private static final Logger b = LogManager.getLogger(C0002a.a);

    public static void log(@NotNull String str, @NotNull Object... objArr) {
        b.info("[{}] {}", C0002a.a, String.format(str, objArr));
    }

    public static void a(@NotNull String str, @NotNull Object... objArr) {
        b.warn("[{}] {}", C0002a.a, String.format(str, objArr));
    }

    public static void logError(@NotNull String str, @NotNull Object... objArr) {
        b.error("[{}] {}", C0002a.a, String.format(str, objArr));
    }

    public static void a(@NotNull String str, @NotNull Throwable th, @NotNull Object... objArr) {
        b.error("[{}] {}", C0002a.a, String.format(str, objArr), th);
    }
}
