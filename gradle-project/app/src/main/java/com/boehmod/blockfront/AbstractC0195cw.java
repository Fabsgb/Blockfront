package com.boehmod.blockfront;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cw.class */
public abstract class AbstractC0195cw implements LayeredDraw.Layer {
    /* JADX INFO: renamed from: a */
    protected abstract void mo1214a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0623l c0623l);

    public void render(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null) {
            mo1214a(guiGraphics, deltaTracker, c0623lM2852b);
        }
    }
}
