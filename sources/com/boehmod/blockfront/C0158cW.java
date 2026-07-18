package com.boehmod.blockfront;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ChatScreen;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cW.class */
public class C0158cW extends ChatScreen {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0156cU f1293a;

    /* JADX INFO: renamed from: bm */
    private boolean f1294bm;

    public C0158cW(@NotNull AbstractC0156cU abstractC0156cU) {
        super("");
        this.f1294bm = true;
        this.f1293a = abstractC0156cU;
    }

    public void tick() {
        super.tick();
        this.f1293a.tick();
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        this.f1293a.render(guiGraphics, i, i2, f);
        if (this.f1294bm && this.input.getValue().equalsIgnoreCase("t")) {
            this.f1294bm = false;
            this.input.setValue("");
        }
        super.render(guiGraphics, i, i2, f);
    }

    public boolean keyPressed(int i, int i2, int i3) {
        boolean zKeyPressed = super.keyPressed(i, i2, i3);
        if (this.minecraft != null && this.minecraft.screen != this) {
            this.minecraft.setScreen(this.f1293a);
        }
        return zKeyPressed;
    }
}
