package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jQ.class */
public enum EnumC0534jQ {
    ALPHA(Component.translatable("bf.message.alpha"), true),
    BETA(Component.translatable("bf.message.beta"), true),
    RELEASE(Component.translatable("bf.message.release"), false);

    private final boolean displayDisclaimer;

    @NotNull
    private final Component component;

    EnumC0534jQ(Component component, boolean z) {
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
