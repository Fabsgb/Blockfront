package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ar */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ar.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0074ar {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    /* JADX INFO: renamed from: a */
    public static void m285a(@NotNull InputEvent.MouseButton.Pre pre) {
        C0623l c0623lM2852b;
        if (pre.getButton() == 0 && pre.getAction() == 1 && (c0623lM2852b = C0623l.m2852b()) != null && c0623lM2852b.m2895a().m3073g(Minecraft.getInstance())) {
            pre.setCanceled(true);
        }
    }
}
