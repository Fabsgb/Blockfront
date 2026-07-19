package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.at, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/at.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0022at {
    @SubscribeEvent
    public static void a(@NotNull AttackEntityEvent attackEntityEvent) {
        if (attackEntityEvent.getEntity().getMainHandItem().getItem() instanceof C0558ur) {
            attackEntityEvent.setCanceled(true);
        }
    }
}
