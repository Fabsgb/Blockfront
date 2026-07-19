package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cy.class */
public class C0081cy extends Screen {

    @NotNull
    protected final fV a;

    @NotNull
    protected final C0297l e;

    @NotNull
    protected final Minecraft b;
    static final /* synthetic */ boolean aW;

    static {
        aW = !C0081cy.class.desiredAssertionStatus();
    }

    protected C0081cy(@NotNull Component component) {
        super(component);
        C0297l c0297lB = C0297l.b();
        if (!aW && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.e = c0297lB;
        this.a = (fV) c0297lB.a();
        this.b = Minecraft.getInstance();
        this.font = this.b.font;
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
    }
}
