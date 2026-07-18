package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xI.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public class C1268xI {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m7758a(@NotNull ServerStoppingEvent serverStoppingEvent) {
        C0562jt.log("Shutting down cloud manager for the dedicated server...", new Object[0]);
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a instanceof C1300xw) {
            ((C1300xw) abstractC0563juM168a).m7958dH();
        }
    }
}
