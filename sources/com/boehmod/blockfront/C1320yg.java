package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.yg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yg.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public class C1320yg {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m8274a(@NotNull ServerStoppingEvent serverStoppingEvent) {
        C0530jM.log("Shutting down cloud manager for the dedicated server...", new Object[0]);
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a instanceof C1280xT) {
            ((C1280xT) abstractC0531jNM179a).m7286dR();
        }
    }
}
