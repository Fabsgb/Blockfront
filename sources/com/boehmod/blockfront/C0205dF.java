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

/* JADX INFO: renamed from: com.boehmod.blockfront.dF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dF.class */
public class C0205dF extends AbstractC0200dA {

    /* JADX INFO: renamed from: ff */
    @NotNull
    private static final Component f1597ff = Component.translatable("bf.message.online").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: fg */
    @NotNull
    private static final Component f1598fg = Component.translatable("bf.message.offline").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);

    /* JADX INFO: renamed from: hI */
    private int f1599hI;

    /* JADX INFO: renamed from: hJ */
    private int f1600hJ = 0;

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1236a(@NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull Minecraft minecraft, @NotNull C0143cG c0143cG, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        if (((C0358g) c0623l.m2852b()).m1722a() == EnumC0411h.OFFLINE) {
            return;
        }
        C0129bt.m492c(poseStack, font, guiGraphics, (Component) m1242a(c0623l), i / 2, i2 - 7, ColorReferences.COLOR_WHITE_SOLID, 0.5f);
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1237a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0555jl c0555jl, @NotNull C0143cG c0143cG, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1238a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0143cG c0143cG, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
        C0358g c0358g = (C0358g) c0623l.m2852b();
        if (c0358g.m1722a().isConnected() || c0358g.m1722a() != EnumC0411h.ONLINE) {
            return;
        }
        int reconnectTickCount = c0358g.m1722a().getReconnectTickCount();
        float fM7170f = C1270xJ.m7170f(this.f1599hI, this.f1600hJ, f2) / c0358g.m1722a().getReconnectTickTarget();
        float fSin = 1.0f + Mth.sin(f / 20.0f);
        C0129bt.m487a(poseStack, font, guiGraphics, (Component) Component.translatable("bf.menu.text.network.reconnect", new Object[]{Component.literal(String.valueOf(reconnectTickCount / 20))}).append(C0125bp.m439a(f)).withStyle(ChatFormatting.YELLOW).withStyle(C0533jP.f3185b), 16, i2 - 11, 0.5f);
        int i5 = i2 - 1;
        C0129bt.m517a(guiGraphics, 0, i5, i, 1, ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM, 1.0f);
        C0129bt.m517a(guiGraphics, 0, i5, i, 1, ColorReferences.COLOR_WHITE_SOLID, Math.max(fSin / 4.0f, 0.0f));
        C0129bt.m516a(poseStack, guiGraphics, 0.0f, i5, i * (1.0f - fM7170f), 1.0f, ColorReferences.COLOR_THEME_YELLOW_SOLID, 1.0f);
        C0129bt.m587a(guiGraphics, 0, i2 - 17, 16, ColorReferences.COLOR_THEME_YELLOW_SOLID, f);
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1239a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0143cG c0143cG, float f) {
        C0358g c0358g = (C0358g) c0623l.m2852b();
        this.f1600hJ = this.f1599hI;
        this.f1599hI = c0358g.m1722a().getReconnectTickCount();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private MutableComponent m1242a(@NotNull C0623l c0623l) {
        C0358g c0358g = (C0358g) c0623l.m2852b();
        boolean z = c0358g.m1722a() == ConnectionStatus.CONNECTED_VERIFIED;
        Component componentWithColor = f1597ff.copy().append(", ").append(z ? Component.translatable("bf.menu.text.network.verified") : Component.translatable("bf.menu.text.network.unverified")).withColor(z ? ColorReferences.COLOR_TEAM_ALLIES : ChatFormatting.GRAY.getColor().intValue());
        MutableComponent mutableComponentWithColor = Component.literal(C1273xM.m7239b(c0358g.f2495j)).withColor(ColorReferences.COLOR_TEAM_ALLIES);
        MutableComponent mutableComponentWithStyle = Component.literal("???").withStyle(ChatFormatting.GRAY);
        Object[] objArr = new Object[2];
        objArr[0] = c0358g.m1722a().isConnected() ? componentWithColor : f1598fg;
        objArr[1] = z ? mutableComponentWithColor : mutableComponentWithStyle;
        return Component.translatable("bf.menu.text.network", objArr);
    }
}
