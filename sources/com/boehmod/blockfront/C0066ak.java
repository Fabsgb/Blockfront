package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientChatReceivedEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ak */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ak.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0066ak {

    /* JADX INFO: renamed from: O */
    static final /* synthetic */ boolean f445O;

    static {
        f445O = !C0066ak.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m231a(@NotNull ClientChatReceivedEvent.Player player) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f445O && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0622lM2667b.m2688a() != null) {
            player.setCanceled(true);
        }
    }
}
