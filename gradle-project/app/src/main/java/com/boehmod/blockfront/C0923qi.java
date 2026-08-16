package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qi.class */
public class C0923qi extends AbstractC0927qm<Void> {

    /* JADX INFO: renamed from: jg */
    @NotNull
    public final Component f5119jg;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Runnable f5120a;

    public C0923qi(@NotNull Component component, @NotNull Runnable runnable) {
        super(Component.empty(), () -> {
            return null;
        }, r1 -> {
        });
        this.f5119jg = component;
        this.f5120a = runnable;
    }
}
