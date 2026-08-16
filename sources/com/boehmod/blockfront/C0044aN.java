package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aN.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0044aN {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m223a(@NotNull InputEvent.MouseScrollingEvent mouseScrollingEvent) {
        LocalPlayer localPlayer;
        C0623l c0623lM2852b;
        if (C1133uf.b.m6503j() != null || (localPlayer = Minecraft.getInstance().player) == null || (c0623lM2852b = C0623l.m2852b()) == null) {
            return;
        }
        if (c0623lM2852b.m2876e()) {
            mouseScrollingEvent.setCanceled(true);
            return;
        }
        if (C0488iX.m2209d(localPlayer)) {
            mouseScrollingEvent.setCanceled(true);
            return;
        }
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
        if (abstractC0864pcM2878a == null || !abstractC0864pcM2878a.mo4157bu() || C0875pn.m4469h(localPlayer)) {
            return;
        }
        double scrollDeltaY = mouseScrollingEvent.getScrollDeltaY();
        if (scrollDeltaY == 0.0d) {
            return;
        }
        int i = scrollDeltaY > 0.0d ? -1 : 1;
        Inventory inventory = localPlayer.getInventory();
        int iM4470a = C0875pn.m4470a(inventory, inventory.selected, i);
        if (!inventory.getItem(iM4470a).isEmpty()) {
            inventory.selected = iM4470a;
        }
        mouseScrollingEvent.setCanceled(true);
    }
}
