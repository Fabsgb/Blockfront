package com.boehmod.blockfront;

import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xm.class */
public class C1299xm {
    /* JADX INFO: renamed from: b */
    public static void m7873b(@NotNull RegisterClientReloadListenersEvent registerClientReloadListenersEvent) {
        registerClientReloadListenersEvent.registerReloadListener(resourceManager -> {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (c0623lM2852b != null) {
                c0623lM2852b.m2887a().m2211bf();
                ((C0994s) c0623lM2852b.m2852b()).m5572j();
            }
            C0450hm.f2821kA++;
        });
        registerClientReloadListenersEvent.registerReloadListener(resourceManager2 -> {
            C0479iO.m2144a().m2146bb();
        });
        registerClientReloadListenersEvent.registerReloadListener(resourceManager3 -> {
            C0126bq.m447e();
        });
    }
}
