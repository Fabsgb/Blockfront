package com.boehmod.blockfront;

import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aB.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0031aB {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m175a(@NotNull RenderLivingEvent.Pre<?, ?> pre) {
        Entity entity = pre.getEntity();
        Entity vehicle = entity.getVehicle();
        if ((vehicle instanceof AbstractC0779ny) && ((AbstractC0779ny) vehicle).m3514l(entity)) {
            pre.setCanceled(true);
        }
    }
}
