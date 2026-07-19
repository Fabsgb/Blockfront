package com.boehmod.blockfront;

import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.forge.event.ForgeVeilRendererAvailableEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aM.class */
@EventBusSubscriber(modid = "bf", bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public final class aM {
    @SubscribeEvent
    public static void a(@NotNull ForgeVeilRendererAvailableEvent forgeVeilRendererAvailableEvent) {
        C0263jt.log("Veil renderer now available, enabling veil buffers.", new Object[0]);
        forgeVeilRendererAvailableEvent.getRenderer().enableBuffers(C0265jv.d("veil_buffers"), DynamicBufferType.NORMAL, DynamicBufferType.ALBEDO);
        C0263jt.log("Enabled veil buffers with BlockFront identity.", new Object[0]);
    }
}
