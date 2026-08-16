package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientChatReceivedEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aq.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0073aq {

    /* JADX INFO: renamed from: T */
    static final /* synthetic */ boolean f488T;

    static {
        f488T = !C0073aq.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m284a(@NotNull ClientChatReceivedEvent.Player player) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f488T && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0623lM2852b.m2874a() != null) {
            player.setCanceled(true);
        }
    }
}
