package com.boehmod.blockfront;

import com.boehmod.blockfront.C1055tH;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aG.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0036aG {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m182a(@NotNull InputEvent.MouseScrollingEvent mouseScrollingEvent) {
        LocalPlayer localPlayer;
        C0622l c0622lM2667b;
        if (C1055tH.b.m5867j() != null || (localPlayer = Minecraft.getInstance().player) == null || (c0622lM2667b = C0622l.m2667b()) == null) {
            return;
        }
        if (c0622lM2667b.m2690e()) {
            mouseScrollingEvent.setCanceled(true);
            return;
        }
        if (C0468iE.m2117d(localPlayer)) {
            mouseScrollingEvent.setCanceled(true);
            return;
        }
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
        if (abstractC0788oGM2692a == null || !abstractC0788oGM2692a.mo3721bk() || C0799oR.m4033h(localPlayer)) {
            return;
        }
        double scrollDeltaY = mouseScrollingEvent.getScrollDeltaY();
        if (scrollDeltaY == 0.0d) {
            return;
        }
        int i = scrollDeltaY > 0.0d ? -1 : 1;
        Inventory inventory = localPlayer.getInventory();
        int iM4034a = C0799oR.m4034a(inventory, inventory.selected, i);
        if (!inventory.getItem(iM4034a).isEmpty()) {
            inventory.selected = iM4034a;
        }
        mouseScrollingEvent.setCanceled(true);
    }
}
