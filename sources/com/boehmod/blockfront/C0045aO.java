package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.AddSectionGeometryEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aO.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0045aO {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m224a(@NotNull AddSectionGeometryEvent addSectionGeometryEvent) {
        C0363gE.m1751b(addSectionGeometryEvent);
    }
}
