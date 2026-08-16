package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cH.class */
public class C0144cH extends Screen {

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final C0396gl f1056a;

    /* JADX INFO: renamed from: f */
    @NotNull
    protected final C0623l f1057f;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final Minecraft f1058a;

    /* JADX INFO: renamed from: ba */
    static final /* synthetic */ boolean f1059ba;

    static {
        f1059ba = !C0144cH.class.desiredAssertionStatus();
    }

    protected C0144cH(@NotNull Component component) {
        super(component);
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f1059ba && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.f1057f = c0623lM2852b;
        this.f1056a = (C0396gl) c0623lM2852b.m2855a();
        this.f1058a = Minecraft.getInstance();
        this.font = this.f1058a.font;
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
    }
}
