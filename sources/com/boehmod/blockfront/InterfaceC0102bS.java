package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bS.class */
public interface InterfaceC0102bS {

    /* JADX INFO: renamed from: com.boehmod.blockfront.bS$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bS$a.class */
    public enum a {
        MAIN,
        BACKGROUND
    }

    /* JADX INFO: renamed from: n */
    void mo394n(@NotNull Minecraft minecraft);

    /* JADX INFO: renamed from: a */
    boolean mo395a(float f);

    /* JADX INFO: renamed from: a */
    void mo396a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2);

    /* JADX INFO: renamed from: b */
    void mo397b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2);

    @NotNull
    /* JADX INFO: renamed from: a */
    a mo398a();
}
