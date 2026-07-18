package com.boehmod.blockfront;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.co */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/co.class */
public final class C0180co extends AbstractC0179cn {
    @Override // com.boehmod.blockfront.AbstractC0179cn
    /* JADX INFO: renamed from: a */
    public void mo1027a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0622l c0622l) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || minecraft.options.hideGui || c0622l.m2688a() != null || !C0424hN.f2741v.m1996T()) {
            return;
        }
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }
        Item item = mainHandItem.getItem();
        if (item instanceof C1144ur) {
            C1144ur c1144ur = (C1144ur) item;
            float fM366g = C0119bk.m366g();
            float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
            C0171cj.m1019a(mainHandItem);
            C0171cj.m1020a(minecraft, minecraft.font, guiGraphics.pose(), guiGraphics, c1144ur, mainHandItem, guiGraphics.guiWidth(), guiGraphics.guiHeight(), fM366g, gameTimeDeltaPartialTick);
        }
    }
}
