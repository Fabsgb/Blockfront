package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.at */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/at.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0075at {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m256a(@NotNull AttackEntityEvent attackEntityEvent) {
        if (attackEntityEvent.getEntity().getMainHandItem().getItem() instanceof C1144ur) {
            attackEntityEvent.setCanceled(true);
        }
    }
}
