package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bp.class */
public class C0125bp {

    /* JADX INFO: renamed from: ch */
    private static final int f832ch = 10;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final StringBuilder f833a = new StringBuilder();

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m439a(float f) {
        f833a.setLength(0);
        f833a.append(".".repeat(Math.max(0, (int) ((f / 10.0f) % 4.0f))));
        return f833a.toString();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Component m440a(float f) {
        return Component.literal(m439a(f));
    }
}
