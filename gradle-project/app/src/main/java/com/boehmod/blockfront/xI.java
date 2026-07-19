package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xI.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public class xI {
    @SubscribeEvent
    public static void a(@NotNull ServerStoppingEvent serverStoppingEvent) {
        C0263jt.log("Shutting down cloud manager for the dedicated server...", new Object[0]);
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a instanceof xw) {
            ((xw) abstractC0264juM166a).dH();
        }
    }
}
