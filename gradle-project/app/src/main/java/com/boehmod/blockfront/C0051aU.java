package com.boehmod.blockfront;

import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.forge.event.ForgeVeilRendererAvailableEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aU.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0051aU {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m241a(@NotNull ForgeVeilRendererAvailableEvent forgeVeilRendererAvailableEvent) {
        C0530jM.log("Veil renderer now available, enabling veil buffers.", new Object[0]);
        forgeVeilRendererAvailableEvent.getRenderer().enableBuffers(C0532jO.m2378d("veil_buffers"), DynamicBufferType.NORMAL, DynamicBufferType.ALBEDO);
        C0530jM.log("Enabled veil buffers with BlockFront identity.", new Object[0]);
    }
}
