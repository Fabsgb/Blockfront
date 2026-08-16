package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vt.class */
public enum EnumC1200vt {
    AUTO("AUTO"),
    SEMI("SEMI");


    @NotNull
    private final String name;

    @NotNull
    private final Component displayName;

    EnumC1200vt(String str) {
        this.name = str;
        this.displayName = Component.literal(str);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public Component getDisplayName() {
        return this.displayName;
    }
}
