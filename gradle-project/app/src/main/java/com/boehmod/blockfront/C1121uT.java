package com.boehmod.blockfront;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uT.class */
public final class C1121uT {
    private C1121uT() {
    }

    /* JADX INFO: renamed from: a */
    public static long m6413a(@NotNull UUID uuid, long j) {
        return m6415b(m6415b(m6415b(uuid.getMostSignificantBits()) ^ uuid.getLeastSignificantBits()) ^ j);
    }

    /* JADX INFO: renamed from: a */
    public static long m6414a(@NotNull UUID uuid, long j, int i) {
        return m6413a(uuid, j) + ((long) i);
    }

    /* JADX INFO: renamed from: b */
    private static long m6415b(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }
}
