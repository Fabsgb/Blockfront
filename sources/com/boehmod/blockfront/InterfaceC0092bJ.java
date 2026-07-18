package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bJ.class */
public interface InterfaceC0092bJ {

    /* JADX INFO: renamed from: com.boehmod.blockfront.bJ$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bJ$a.class */
    public enum a {
        MAIN,
        BACKGROUND
    }

    /* JADX INFO: renamed from: m */
    void mo289m(@NotNull Minecraft minecraft);

    /* JADX INFO: renamed from: a */
    boolean mo290a(float f);

    /* JADX INFO: renamed from: a */
    void mo291a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2);

    /* JADX INFO: renamed from: b */
    void mo292b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2);

    @NotNull
    /* JADX INFO: renamed from: a */
    a mo293a();
}
