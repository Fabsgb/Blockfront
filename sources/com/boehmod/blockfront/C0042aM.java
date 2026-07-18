package com.boehmod.blockfront;

import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.forge.event.ForgeVeilRendererAvailableEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aM.class */
@EventBusSubscriber(modid = "bf", bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public final class C0042aM {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m199a(@NotNull ForgeVeilRendererAvailableEvent forgeVeilRendererAvailableEvent) {
        C0562jt.log("Veil renderer now available, enabling veil buffers.", new Object[0]);
        forgeVeilRendererAvailableEvent.getRenderer().enableBuffers(C0564jv.m2555d("veil_buffers"), DynamicBufferType.NORMAL, DynamicBufferType.ALBEDO);
        C0562jt.log("Enabled veil buffers with BlockFront identity.", new Object[0]);
    }
}
