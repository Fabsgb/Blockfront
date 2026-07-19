package com.boehmod.blockfront;

import com.boehmod.blockfront.tH;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aG.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class aG {
    @SubscribeEvent
    public static void a(@NotNull InputEvent.MouseScrollingEvent mouseScrollingEvent) {
        LocalPlayer localPlayer;
        C0297l c0297lB;
        if (tH.b.j() != null || (localPlayer = Minecraft.getInstance().player) == null || (c0297lB = C0297l.b()) == null) {
            return;
        }
        if (c0297lB.e()) {
            mouseScrollingEvent.setCanceled(true);
            return;
        }
        if (iE.d(localPlayer)) {
            mouseScrollingEvent.setCanceled(true);
            return;
        }
        oG<?, ?> oGVarM593a = c0297lB.m593a();
        if (oGVarM593a == null || !oGVarM593a.bk() || oR.h(localPlayer)) {
            return;
        }
        double scrollDeltaY = mouseScrollingEvent.getScrollDeltaY();
        if (scrollDeltaY == 0.0d) {
            return;
        }
        int i = scrollDeltaY > 0.0d ? -1 : 1;
        Inventory inventory = localPlayer.getInventory();
        int iA = oR.a(inventory, inventory.selected, i);
        if (!inventory.getItem(iA).isEmpty()) {
            inventory.selected = iA;
        }
        mouseScrollingEvent.setCanceled(true);
    }
}
