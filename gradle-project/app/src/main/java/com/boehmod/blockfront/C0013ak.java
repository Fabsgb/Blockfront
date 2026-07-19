package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientChatReceivedEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ak, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ak.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0013ak {
    static final /* synthetic */ boolean O;

    static {
        O = !C0013ak.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    public static void a(@NotNull ClientChatReceivedEvent.Player player) {
        C0297l c0297lB = C0297l.b();
        if (!O && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0297lB.m591a() != null) {
            player.setCanceled(true);
        }
    }
}
