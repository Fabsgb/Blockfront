package com.boehmod.blockfront;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cn.class */
public abstract class AbstractC0179cn implements LayeredDraw.Layer {
    /* JADX INFO: renamed from: a */
    protected abstract void mo1027a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0622l c0622l);

    public void render(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null) {
            mo1027a(guiGraphics, deltaTracker, c0622lM2667b);
        }
    }
}
