package com.boehmod.blockfront;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ChatScreen;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cW.class */
public class cW extends ChatScreen {

    @NotNull
    private final cU a;
    private boolean bm;

    public cW(@NotNull cU cUVar) {
        super("");
        this.bm = true;
        this.a = cUVar;
    }

    public void tick() {
        super.tick();
        this.a.tick();
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        this.a.render(guiGraphics, i, i2, f);
        if (this.bm && this.input.getValue().equalsIgnoreCase("t")) {
            this.bm = false;
            this.input.setValue("");
        }
        super.render(guiGraphics, i, i2, f);
    }

    public boolean keyPressed(int i, int i2, int i3) {
        boolean zKeyPressed = super.keyPressed(i, i2, i3);
        if (this.minecraft != null && this.minecraft.screen != this) {
            this.minecraft.setScreen(this.a);
        }
        return zKeyPressed;
    }
}
