package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aA.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0031aA {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m183a(@NotNull AttackEntityEvent attackEntityEvent) {
        if (attackEntityEvent.getEntity().getMainHandItem().getItem() instanceof C1117uP) {
            attackEntityEvent.setCanceled(true);
        }
    }
}
