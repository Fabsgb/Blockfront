package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;

/* JADX INFO: renamed from: com.boehmod.blockfront.az, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/az.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0028az {
    static final /* synthetic */ boolean X;

    static {
        X = !C0028az.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    public static void a(RenderHighlightEvent.Block block) {
        C0297l c0297lB = C0297l.b();
        if (!X && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        block.setCanceled(c0297lB.m591a() != null);
    }
}
