package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dw.class */
public class C0105dw extends AbstractC0100dr {

    @NotNull
    private static final Component fc = Component.translatable("bf.message.online").withStyle(ChatFormatting.RED);

    @NotNull
    private static final Component fd = Component.translatable("bf.message.offline").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
    private int gD;
    private int gE = 0;

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull Minecraft minecraft, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        if (((C0163g) c0297l.b()).a() == EnumC0190h.OFFLINE) {
            return;
        }
        C0040bk.c(poseStack, font, guiGraphics, (Component) a(c0297l), i / 2, i2 - 7, ColorReferences.COLOR_WHITE_SOLID, 0.5f);
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, iS iSVar, @NotNull C0080cx c0080cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
        C0163g c0163g = (C0163g) c0297l.b();
        if (c0163g.a().isConnected() || c0163g.a() != EnumC0190h.ONLINE) {
            return;
        }
        int reconnectTickCount = c0163g.a().getReconnectTickCount();
        float fE = C0634xm.e(this.gD, this.gE, f2) / 600.0f;
        float fSin = 1.0f + Mth.sin(f / 20.0f);
        C0040bk.a(poseStack, font, guiGraphics, (Component) Component.translatable("bf.menu.text.network.reconnect", new Object[]{Component.literal(String.valueOf(reconnectTickCount / 20))}).append(C0037bh.a(f)).withStyle(ChatFormatting.YELLOW).withStyle(C0266jw.b), 16, i2 - 11, 0.5f);
        int i5 = i2 - 1;
        C0040bk.a(guiGraphics, 0, i5, i, 1, ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM, 1.0f);
        C0040bk.a(guiGraphics, 0, i5, i, 1, ColorReferences.COLOR_WHITE_SOLID, Math.max(fSin / 4.0f, 0.0f));
        C0040bk.a(poseStack, guiGraphics, 0.0f, i5, i * (1.0f - fE), 1.0f, ColorReferences.COLOR_THEME_YELLOW_SOLID, 1.0f);
        C0040bk.a(guiGraphics, 0, i2 - 17, 16, ColorReferences.COLOR_THEME_YELLOW_SOLID, f);
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, float f) {
        C0163g c0163g = (C0163g) c0297l.b();
        this.gE = this.gD;
        this.gD = c0163g.a().getReconnectTickCount();
    }

    @NotNull
    private MutableComponent a(@NotNull C0297l c0297l) {
        C0163g c0163g = (C0163g) c0297l.b();
        boolean z = c0163g.a() == ConnectionStatus.CONNECTED_VERIFIED;
        Component componentWithColor = fc.copy().append(", ").append(z ? Component.translatable("bf.menu.text.network.verified") : Component.translatable("bf.menu.text.network.unverified")).withColor(z ? ColorReferences.COLOR_TEAM_ALLIES : ChatFormatting.GRAY.getColor().intValue());
        MutableComponent mutableComponentWithColor = Component.literal(C0637xp.a(c0163g.i)).withColor(ColorReferences.COLOR_TEAM_ALLIES);
        MutableComponent mutableComponentWithStyle = Component.literal("???").withStyle(ChatFormatting.GRAY);
        Object[] objArr = new Object[2];
        objArr[0] = c0163g.a().isConnected() ? componentWithColor : fd;
        objArr[1] = z ? mutableComponentWithColor : mutableComponentWithStyle;
        return Component.translatable("bf.menu.text.network", objArr);
    }
}
