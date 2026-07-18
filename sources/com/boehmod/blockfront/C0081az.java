package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;

/* JADX INFO: renamed from: com.boehmod.blockfront.az */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/az.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0081az {

    /* JADX INFO: renamed from: X */
    static final /* synthetic */ boolean f535X;

    static {
        f535X = !C0081az.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m285a(RenderHighlightEvent.Block block) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f535X && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        block.setCanceled(c0622lM2667b.m2688a() != null);
    }
}
