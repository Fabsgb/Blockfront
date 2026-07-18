package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uT.class */
public enum EnumC1120uT {
    AUTO("AUTO"),
    SEMI("SEMI");


    @NotNull
    private final String name;

    @NotNull
    private final Component displayName;

    EnumC1120uT(@NotNull String str) {
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
