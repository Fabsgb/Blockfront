package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pM.class */
public class C0847pM extends AbstractC0851pQ<Void> {

    /* JADX INFO: renamed from: iT */
    @NotNull
    public final Component f4480iT;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Runnable f4481a;

    public C0847pM(@NotNull Component component, @NotNull Runnable runnable) {
        super(Component.empty(), () -> {
            return null;
        }, r1 -> {
        });
        this.f4480iT = component;
        this.f4481a = runnable;
    }
}
