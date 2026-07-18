package com.boehmod.blockfront;

import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wP.class */
public class C1222wP {
    /* JADX INFO: renamed from: b */
    public static void m7286b(@NotNull RegisterClientReloadListenersEvent registerClientReloadListenersEvent) {
        registerClientReloadListenersEvent.registerReloadListener(resourceManager -> {
            C0622l c0622lM2667b = C0622l.m2667b();
            if (c0622lM2667b != null) {
                c0622lM2667b.m2701a().m2119aT();
                ((C0940r) c0622lM2667b.m2667b()).m5135h();
            }
            C0380gW.f2483jf++;
        });
    }
}
