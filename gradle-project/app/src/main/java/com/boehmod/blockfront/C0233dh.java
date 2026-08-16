package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dh.class */
public class C0233dh extends C0085bB {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0886py f1889b;

    public C0233dh(int i, int i2, int i3, int i4, @NotNull Component component, @NotNull Button.OnPress onPress, @NotNull C0886py c0886py) {
        super(i, i2, i3, i4, component, onPress);
        this.f1889b = c0886py;
    }

    @Override // com.boehmod.blockfront.C0085bB
    /* JADX INFO: renamed from: a */
    public void mo311a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        super.mo311a(guiGraphics, poseStack, i, i2, f, f2);
        C0126bq.m441a(poseStack, guiGraphics, this.f1889b.m4636c(), getX() + (this.width / 2), getY() + (this.height / 2), 1.5f);
    }

    @Override // com.boehmod.blockfront.C0085bB
    /* JADX INFO: renamed from: a */
    public void mo337a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        int x = getX() + (this.width / 2);
        int y = getY() + this.height;
        int iM4637bz = this.f1889b.m4637bz();
        C0129bt.m492c(poseStack, font, guiGraphics, (Component) Component.literal(this.f1889b.m4636c().getDisplayName().getString().replace("[", "").replace("]", "")).withStyle(ChatFormatting.BOLD), x, y - 14, ColorReferences.COLOR_WHITE, 0.4f);
        if (iM4637bz > 0) {
            C0129bt.m492c(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf(this.f1889b.m4637bz())).withStyle(ChatFormatting.GREEN), x, y - 8, ColorReferences.COLOR_WHITE, 0.8f);
        }
    }
}
