package com.boehmod.blockfront;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ChatScreen;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.df */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/df.class */
public class C0231df extends ChatScreen {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0229dd f1864a;

    /* JADX INFO: renamed from: bq */
    private boolean f1865bq;

    public C0231df(@NotNull AbstractC0229dd abstractC0229dd) {
        super("");
        this.f1865bq = true;
        this.f1864a = abstractC0229dd;
    }

    public void tick() {
        super.tick();
        this.f1864a.tick();
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        this.f1864a.render(guiGraphics, i, i2, f);
        if (this.f1865bq && this.input.getValue().equalsIgnoreCase("t")) {
            this.f1865bq = false;
            this.input.setValue("");
        }
        super.render(guiGraphics, i, i2, f);
    }

    public boolean keyPressed(int i, int i2, int i3) {
        boolean zKeyPressed = super.keyPressed(i, i2, i3);
        if (this.minecraft != null && this.minecraft.screen != this) {
            this.minecraft.setScreen(this.f1864a);
        }
        return zKeyPressed;
    }
}
