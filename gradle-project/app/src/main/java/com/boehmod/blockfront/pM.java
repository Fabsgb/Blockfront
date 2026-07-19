package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pM.class */
public class pM extends pQ<Void> {

    @NotNull
    public final Component iT;

    @NotNull
    public final Runnable a;

    public pM(@NotNull Component component, @NotNull Runnable runnable) {
        super(Component.empty(), () -> {
            return null;
        }, r1 -> {
        });
        this.iT = component;
        this.a = runnable;
    }
}
