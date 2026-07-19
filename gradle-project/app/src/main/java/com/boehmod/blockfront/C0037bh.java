package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bh.class */
public class C0037bh {
    private static final int br = 10;

    @NotNull
    private static final StringBuilder a = new StringBuilder();

    @NotNull
    public static String a(float f) {
        a.setLength(0);
        a.append(".".repeat(Math.max(0, (int) ((f / 10.0f) % 4.0f))));
        return a.toString();
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Component m224a(float f) {
        return Component.literal(a(f));
    }
}
