package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.List;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cz.class */
public final class C0198cz extends AbstractC0195cw {
    @Override // com.boehmod.blockfront.AbstractC0195cw
    /* JADX INFO: renamed from: a */
    protected void mo1214a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0623l c0623l) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623l.m2874a();
        if (abstractC0863pbM2874a == null) {
            return;
        }
        List<InterfaceC0922qh> listM6087aC = abstractC0863pbM2874a.m4089a().m6087aC();
        if (listM6087aC.isEmpty()) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        Iterator<InterfaceC0922qh> it = listM6087aC.iterator();
        while (it.hasNext()) {
            it.next().mo5073a(minecraft, c0623l, guiGraphics, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        }
    }
}
