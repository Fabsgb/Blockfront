package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xF.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public class xF {
    @SubscribeEvent
    public static void a(@NotNull PlayerEvent.PlayerLoggedInEvent playerLoggedInEvent) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a instanceof xw) {
            ((xw) abstractC0264juM166a).k((ServerPlayer) playerLoggedInEvent.getEntity());
        }
    }

    @SubscribeEvent
    public static void a(@NotNull PlayerEvent.PlayerLoggedOutEvent playerLoggedOutEvent) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a instanceof xw) {
            ((xw) abstractC0264juM166a).j((ServerPlayer) playerLoggedOutEvent.getEntity());
        }
    }
}
