package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bh.class */
public class C0116bh {

    /* JADX INFO: renamed from: br */
    private static final int f701br = 10;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final StringBuilder f702a = new StringBuilder();

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m346a(float f) {
        f702a.setLength(0);
        f702a.append(".".repeat(Math.max(0, (int) ((f / 10.0f) % 4.0f))));
        return f702a.toString();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Component m347a(float f) {
        return Component.literal(m346a(f));
    }
}
