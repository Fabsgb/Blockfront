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

/* JADX INFO: renamed from: com.boehmod.blockfront.jm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jm.class */
public class C0256jm extends AbstractC0259jp<ExpRewardType> {
    private static final int jR = -13421773;

    @NotNull
    private static final MutableComponent o = Component.literal("EXP").withStyle(ChatFormatting.BOLD);

    @Override // com.boehmod.blockfront.AbstractC0259jp
    @NotNull
    public Component a(@NotNull ExpRewardType expRewardType) {
        return Component.literal("+" + C0637xp.a(expRewardType.getAmount())).withColor(9633658).append(Component.literal(" EXP").withStyle(ChatFormatting.WHITE));
    }

    @Override // com.boehmod.blockfront.AbstractC0259jp
    public void a(@NotNull ExpRewardType expRewardType, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        super.a(expRewardType, guiGraphics, i, i2, i3, i4);
        b(guiGraphics, i, i2, i3, i4, jR);
        PoseStack poseStackPose = guiGraphics.pose();
        int i5 = i + (i3 / 2);
        int i6 = (i2 + (i4 / 2)) - 8;
        Font font = Minecraft.getInstance().font;
        C0040bk.a(poseStackPose, font, guiGraphics, (Component) Component.literal(C0637xp.a(expRewardType.getAmount())).withColor(9633658), i5, i6);
        C0040bk.a(poseStackPose, font, guiGraphics, (Component) o, i5, i6 + 10);
    }
}
