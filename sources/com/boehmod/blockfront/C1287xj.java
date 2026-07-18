package com.boehmod.blockfront;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xj.class */
public class C1287xj {
    @NotNull
    /* JADX INFO: renamed from: a */
    public static <T> T m7827a(@NotNull Set<T> set) {
        if (set.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        return (T) set.toArray()[ThreadLocalRandom.current().nextInt(set.size())];
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static <T> T m7828a(@NotNull List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static <T> T m7829a(@NotNull List<T> list, long j) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        threadLocalRandomCurrent.setSeed(j);
        return list.get(threadLocalRandomCurrent.nextInt(list.size()));
    }
}
