package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.List;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cq.class */
public final class C0073cq extends AbstractC0070cn {
    @Override // com.boehmod.blockfront.AbstractC0070cn
    protected void a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0297l c0297l) {
        oF<?, ?, ?> oFVarM591a = c0297l.m591a();
        if (oFVarM591a == null) {
            return;
        }
        List<pL> listAA = oFVarM591a.m767a().aA();
        if (listAA.isEmpty()) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        Iterator<pL> it = listAA.iterator();
        while (it.hasNext()) {
            it.next().a(minecraft, c0297l, guiGraphics, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        }
    }
}
