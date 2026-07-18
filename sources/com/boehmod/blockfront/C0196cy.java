package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cy.class */
public class C0196cy extends Screen {

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final C0326fV f1585a;

    /* JADX INFO: renamed from: e */
    @NotNull
    protected final C0622l f1586e;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final Minecraft f1587b;

    /* JADX INFO: renamed from: aW */
    static final /* synthetic */ boolean f1588aW;

    static {
        f1588aW = !C0196cy.class.desiredAssertionStatus();
    }

    protected C0196cy(@NotNull Component component) {
        super(component);
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f1588aW && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.f1586e = c0622lM2667b;
        this.f1585a = (C0326fV) c0622lM2667b.m2670a();
        this.f1587b = Minecraft.getInstance();
        this.font = this.f1587b.font;
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
    }
}
