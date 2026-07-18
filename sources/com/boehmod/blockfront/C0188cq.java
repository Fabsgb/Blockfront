package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.List;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cq.class */
public final class C0188cq extends AbstractC0179cn {
    @Override // com.boehmod.blockfront.AbstractC0179cn
    /* JADX INFO: renamed from: a */
    protected void mo1027a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0622l c0622l) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622l.m2688a();
        if (abstractC0787oFM2688a == null) {
            return;
        }
        List<InterfaceC0846pL> listM5599aA = abstractC0787oFM2688a.m3653a().m5599aA();
        if (listM5599aA.isEmpty()) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        Iterator<InterfaceC0846pL> it = listM5599aA.iterator();
        while (it.hasNext()) {
            it.next().mo4279a(minecraft, c0622l, guiGraphics, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        }
    }
}
