package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cg.class */
public abstract class AbstractC0063cg<G extends oF<G, P, ?>, P extends oI<G>> {
    public static final int dg = 15;
    public static final int dh = 4;
    private final int di;

    public abstract void a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull oG<G, P> oGVar, @NotNull LocalPlayer localPlayer);

    public AbstractC0063cg(int i) {
        this.di = i;
    }

    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        C0040bk.b(guiGraphics, i, i2, a(font), 15, C0040bk.p());
    }

    public int a(@NotNull Font font) {
        return this.di;
    }

    public boolean s() {
        return true;
    }
}
