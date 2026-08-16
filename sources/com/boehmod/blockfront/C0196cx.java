package com.boehmod.blockfront;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cx.class */
public final class C0196cx extends AbstractC0195cw {
    @Override // com.boehmod.blockfront.AbstractC0195cw
    /* JADX INFO: renamed from: a */
    public void mo1214a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0623l c0623l) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || minecraft.options.hideGui || c0623l.m2874a() != null || !C0495ie.f3042v.m2230U()) {
            return;
        }
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }
        Item item = mainHandItem.getItem();
        if (item instanceof C1117uP) {
            C1117uP c1117uP = (C1117uP) item;
            float fM466g = C0129bt.m466g();
            float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
            C0191cs.m1206J();
            C0191cs.m1207a(minecraft, minecraft.font, guiGraphics.pose(), guiGraphics, c1117uP, mainHandItem, guiGraphics.guiWidth(), guiGraphics.guiHeight(), fM466g, gameTimeDeltaPartialTick);
        }
    }
}
