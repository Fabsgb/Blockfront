package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cg.class */
public abstract class AbstractC0168cg<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> {

    /* JADX INFO: renamed from: dg */
    public static final int f1338dg = 15;

    /* JADX INFO: renamed from: dh */
    public static final int f1339dh = 4;

    /* JADX INFO: renamed from: di */
    private final int f1340di;

    /* JADX INFO: renamed from: a */
    public abstract void mo319a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0788oG<G, P> abstractC0788oG, @NotNull LocalPlayer localPlayer);

    public AbstractC0168cg(int i) {
        this.f1340di = i;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo321a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        C0119bk.m418b(guiGraphics, i, i2, mo322a(font), 15, C0119bk.m365p());
    }

    /* JADX INFO: renamed from: a */
    public int mo322a(@NotNull Font font) {
        return this.f1340di;
    }

    /* JADX INFO: renamed from: s */
    public boolean mo334s() {
        return true;
    }
}
