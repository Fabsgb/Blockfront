package com.boehmod.blockfront;

import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wP.class */
public class wP {
    public static void b(@NotNull RegisterClientReloadListenersEvent registerClientReloadListenersEvent) {
        registerClientReloadListenersEvent.registerReloadListener(resourceManager -> {
            C0297l c0297lB = C0297l.b();
            if (c0297lB != null) {
                c0297lB.m598a().aT();
                ((C0459r) c0297lB.b()).h();
            }
            gW.jf++;
        });
    }
}
