package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.yd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yd.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public class C1317yd {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m8269a(@NotNull PlayerEvent.PlayerLoggedInEvent playerLoggedInEvent) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a instanceof C1280xT) {
            ((C1280xT) abstractC0531jNM179a).m7284k((ServerPlayer) playerLoggedInEvent.getEntity());
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m8270a(@NotNull PlayerEvent.PlayerLoggedOutEvent playerLoggedOutEvent) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a instanceof C1280xT) {
            ((C1280xT) abstractC0531jNM179a).m7283j((ServerPlayer) playerLoggedOutEvent.getEntity());
        }
    }
}
