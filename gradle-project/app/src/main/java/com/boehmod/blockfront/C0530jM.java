package com.boehmod.blockfront;

import java.util.IllegalFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jM.class */
public class C0530jM {

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final Logger f3170b = LogManager.getLogger(C0030a.f263a);

    @NotNull
    /* JADX INFO: renamed from: a */
    private static String m2336a(@NotNull String str, @NotNull Object... objArr) {
        if (objArr.length == 0) {
            return str;
        }
        try {
            return String.format(str, objArr);
        } catch (IllegalFormatException e) {
            return str;
        }
    }

    public static void log(@NotNull String str, @NotNull Object... objArr) {
        f3170b.info("[{}] {}", C0030a.f263a, m2336a(str, objArr));
    }

    /* JADX INFO: renamed from: a */
    public static void m2337a(@NotNull String str, @NotNull Object... objArr) {
        f3170b.warn("[{}] {}", C0030a.f263a, m2336a(str, objArr));
    }

    public static void logError(@NotNull String str, @NotNull Object... objArr) {
        f3170b.error("[{}] {}", C0030a.f263a, m2336a(str, objArr));
    }

    /* JADX INFO: renamed from: a */
    public static void m2338a(@NotNull String str, @NotNull Throwable th, @NotNull Object... objArr) {
        f3170b.error("[{}] {}", C0030a.f263a, m2336a(str, objArr), th);
    }
}
