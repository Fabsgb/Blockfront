package com.boehmod.blockfront;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.co, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/co.class */
public final class C0071co extends AbstractC0070cn {
    @Override // com.boehmod.blockfront.AbstractC0070cn
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0297l c0297l) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || minecraft.options.hideGui || c0297l.m591a() != null || !hN.v.T()) {
            return;
        }
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }
        Item item = mainHandItem.getItem();
        if (item instanceof C0558ur) {
            C0558ur c0558ur = (C0558ur) item;
            float fG = C0040bk.g();
            float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
            C0066cj.a(mainHandItem);
            C0066cj.a(minecraft, minecraft.font, guiGraphics.pose(), guiGraphics, c0558ur, mainHandItem, guiGraphics.guiWidth(), guiGraphics.guiHeight(), fG, gameTimeDeltaPartialTick);
        }
    }
}
