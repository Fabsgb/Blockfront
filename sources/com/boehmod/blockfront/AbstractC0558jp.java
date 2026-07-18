package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.reward.RewardType;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jp.class */
public abstract class AbstractC0558jp<T extends RewardType> {
    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract Component mo2506a(@NotNull T t);

    /* JADX INFO: renamed from: a */
    public void mo2505a(@NotNull T t, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        C0119bk.m415a(guiGraphics, i, i2, i3, i4, ColorReferences.COLOR_THEME_RED_SOLID);
    }

    /* JADX INFO: renamed from: b */
    public static void m2509b(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5) {
        PoseStack poseStackPose = guiGraphics.pose();
        C0119bk.m417a(guiGraphics, i, i2 + 1, i3, i4 - 2, i5, 0.4f);
        C0119bk.m417a(guiGraphics, i + 1, i2 + 1, i3 - 2, i4 - 1, i5, 0.4f);
        C0119bk.m417a(guiGraphics, i, i2, i3, 1, i5, 0.3f);
        C0119bk.m415a(guiGraphics, i, i2, i3, i4, i5);
        C0119bk.m431a(poseStackPose, guiGraphics, C0195cx.f1577aU, i + 1, i2 + 1, i3 - 2, i4 - 2);
    }
}
