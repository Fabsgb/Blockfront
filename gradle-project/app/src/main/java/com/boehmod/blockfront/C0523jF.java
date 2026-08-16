package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.reward.ExpRewardType;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jF.class */
public class C0523jF extends AbstractC0526jI<ExpRewardType> {

    /* JADX INFO: renamed from: ly */
    private static final int f3158ly = -13421773;

    /* JADX INFO: renamed from: o */
    @NotNull
    private static final MutableComponent f3159o = Component.literal("EXP").withStyle(ChatFormatting.BOLD);

    @Override // com.boehmod.blockfront.AbstractC0526jI
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Component mo2326a(@NotNull ExpRewardType expRewardType) {
        return Component.literal("+" + C1273xM.m7239b(expRewardType.getAmount())).withColor(9633658).append(Component.literal(" EXP").withStyle(ChatFormatting.WHITE));
    }

    @Override // com.boehmod.blockfront.AbstractC0526jI
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2325a(@NotNull ExpRewardType expRewardType, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        super.mo2325a(expRewardType, guiGraphics, i, i2, i3, i4);
        m2329b(guiGraphics, i, i2, i3, i4, f3158ly);
        PoseStack poseStackPose = guiGraphics.pose();
        int i5 = i + (i3 / 2);
        int i6 = (i2 + (i4 / 2)) - 8;
        Font font = Minecraft.getInstance().font;
        C0129bt.m499a(poseStackPose, font, guiGraphics, (Component) Component.literal(C1273xM.m7239b(expRewardType.getAmount())).withColor(9633658), i5, i6);
        C0129bt.m499a(poseStackPose, font, guiGraphics, (Component) f3159o, i5, i6 + 10);
    }
}
