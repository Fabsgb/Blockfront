package com.boehmod.blockfront;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jt.class */
public class C0562jt {

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final Logger f3187b = LogManager.getLogger(C0029a.f246a);

    public static void log(@NotNull String str, @NotNull Object... objArr) {
        f3187b.info("[{}] {}", C0029a.f246a, String.format(str, objArr));
    }

    /* JADX INFO: renamed from: a */
    public static void m2515a(@NotNull String str, @NotNull Object... objArr) {
        f3187b.warn("[{}] {}", C0029a.f246a, String.format(str, objArr));
    }

    public static void logError(@NotNull String str, @NotNull Object... objArr) {
        f3187b.error("[{}] {}", C0029a.f246a, String.format(str, objArr));
    }

    /* JADX INFO: renamed from: a */
    public static void m2516a(@NotNull String str, @NotNull Throwable th, @NotNull Object... objArr) {
        f3187b.error("[{}] {}", C0029a.f246a, String.format(str, objArr), th);
    }
}
