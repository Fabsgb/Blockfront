package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cp.class */
public abstract class AbstractC0188cp<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> {

    /* JADX INFO: renamed from: ed */
    public static final int f1454ed = 15;

    /* JADX INFO: renamed from: ee */
    public static final int f1455ee = 4;

    /* JADX INFO: renamed from: ef */
    private final int f1456ef;

    /* JADX INFO: renamed from: a */
    public abstract void mo1042a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0864pc<G, P> abstractC0864pc, @NotNull LocalPlayer localPlayer);

    public AbstractC0188cp(int i) {
        this.f1456ef = i;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo1044a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        C0129bt.m518b(guiGraphics, i, i2, mo1045a(font), 15, C0129bt.m465t());
    }

    /* JADX INFO: renamed from: a */
    public int mo1045a(@NotNull Font font) {
        return this.f1456ef;
    }

    /* JADX INFO: renamed from: t */
    public boolean mo1059t() {
        return true;
    }
}
