package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jx.class */
public enum EnumC0566jx {
    ALPHA(Component.translatable("bf.message.alpha"), true),
    BETA(Component.translatable("bf.message.beta"), true),
    RELEASE(Component.translatable("bf.message.release"), false);

    private final boolean displayDisclaimer;

    @NotNull
    private final Component component;

    EnumC0566jx(@NotNull Component component, boolean z) {
        this.component = component;
        this.displayDisclaimer = z;
    }

    @NotNull
    public Component getComponent() {
        return this.component;
    }

    public boolean shouldDisplayDisclaimer() {
        return this.displayDisclaimer;
    }
}
