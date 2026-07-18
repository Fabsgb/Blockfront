package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cY.class */
public class C0160cY extends C0127bs {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0863pc f1318b;

    public C0160cY(int i, int i2, int i3, int i4, @NotNull Component component, @NotNull Button.OnPress onPress, @NotNull C0863pc c0863pc) {
        super(i, i2, i3, i4, component, onPress);
        this.f1318b = c0863pc;
    }

    @Override // com.boehmod.blockfront.C0127bs
    /* JADX INFO: renamed from: a */
    public void mo636a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        super.mo636a(guiGraphics, poseStack, i, i2, f, f2);
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0119bk.m501a(poseStack, guiGraphics, this.f1318b.m4311a(), getX() + i3, getY() + i4, 1.5f);
    }

    @Override // com.boehmod.blockfront.C0127bs
    /* JADX INFO: renamed from: a */
    public void mo662a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        int x = getX() + (this.width / 2);
        int y = getY() + this.height;
        int iM4312bk = this.f1318b.m4312bk();
        C0119bk.m392c(poseStack, font, guiGraphics, (Component) Component.literal(this.f1318b.m4311a().getDisplayName().getString().replace("[", "").replace("]", "")).withStyle(ChatFormatting.BOLD), x, y - 14, ColorReferences.COLOR_WHITE, 0.4f);
        if (iM4312bk > 0) {
            C0119bk.m392c(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf(this.f1318b.m4312bk())).withStyle(ChatFormatting.GREEN), x, y - 8, ColorReferences.COLOR_WHITE, 0.8f);
        }
    }
}
