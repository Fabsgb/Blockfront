package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;

/* JADX INFO: renamed from: com.boehmod.blockfront.aG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aG.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0037aG {

    /* JADX INFO: renamed from: ac */
    static final /* synthetic */ boolean f357ac;

    static {
        f357ac = !C0037aG.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m212a(RenderHighlightEvent.Block block) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f357ac && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        block.setCanceled(c0623lM2852b.m2874a() != null);
    }
}
