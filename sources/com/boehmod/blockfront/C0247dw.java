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

/* JADX INFO: renamed from: com.boehmod.blockfront.dw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dw.class */
public class C0247dw extends AbstractC0242dr {

    /* JADX INFO: renamed from: fc */
    @NotNull
    private static final Component f2032fc = Component.translatable("bf.message.online").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: fd */
    @NotNull
    private static final Component f2033fd = Component.translatable("bf.message.offline").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);

    /* JADX INFO: renamed from: gD */
    private int f2034gD;

    /* JADX INFO: renamed from: gE */
    private int f2035gE = 0;

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1410a(@NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull Minecraft minecraft, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        if (((C0357g) c0622l.m2667b()).m1716a() == EnumC0410h.OFFLINE) {
            return;
        }
        C0119bk.m392c(poseStack, font, guiGraphics, (Component) m1416a(c0622l), i / 2, i2 - 7, ColorReferences.COLOR_WHITE_SOLID, 0.5f);
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1411a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0482iS c0482iS, @NotNull C0195cx c0195cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1412a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
        C0357g c0357g = (C0357g) c0622l.m2667b();
        if (c0357g.m1716a().isConnected() || c0357g.m1716a() != EnumC0410h.ONLINE) {
            return;
        }
        int reconnectTickCount = c0357g.m1716a().getReconnectTickCount();
        float fM7843e = C1290xm.m7843e(this.f2034gD, this.f2035gE, f2) / 600.0f;
        float fSin = 1.0f + Mth.sin(f / 20.0f);
        C0119bk.m387a(poseStack, font, guiGraphics, (Component) Component.translatable("bf.menu.text.network.reconnect", new Object[]{Component.literal(String.valueOf(reconnectTickCount / 20))}).append(C0116bh.m346a(f)).withStyle(ChatFormatting.YELLOW).withStyle(C0565jw.f3201b), 16, i2 - 11, 0.5f);
        int i5 = i2 - 1;
        C0119bk.m417a(guiGraphics, 0, i5, i, 1, ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM, 1.0f);
        C0119bk.m417a(guiGraphics, 0, i5, i, 1, ColorReferences.COLOR_WHITE_SOLID, Math.max(fSin / 4.0f, 0.0f));
        C0119bk.m416a(poseStack, guiGraphics, 0.0f, i5, i * (1.0f - fM7843e), 1.0f, ColorReferences.COLOR_THEME_YELLOW_SOLID, 1.0f);
        C0119bk.m487a(guiGraphics, 0, i2 - 17, 16, ColorReferences.COLOR_THEME_YELLOW_SOLID, f);
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1413a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, float f) {
        C0357g c0357g = (C0357g) c0622l.m2667b();
        this.f2035gE = this.f2034gD;
        this.f2034gD = c0357g.m1716a().getReconnectTickCount();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private MutableComponent m1416a(@NotNull C0622l c0622l) {
        C0357g c0357g = (C0357g) c0622l.m2667b();
        boolean z = c0357g.m1716a() == ConnectionStatus.CONNECTED_VERIFIED;
        Component componentWithColor = f2032fc.copy().append(", ").append(z ? Component.translatable("bf.menu.text.network.verified") : Component.translatable("bf.menu.text.network.unverified")).withColor(z ? ColorReferences.COLOR_TEAM_ALLIES : ChatFormatting.GRAY.getColor().intValue());
        MutableComponent mutableComponentWithColor = Component.literal(C1293xp.m7912a(c0357g.f2443i)).withColor(ColorReferences.COLOR_TEAM_ALLIES);
        MutableComponent mutableComponentWithStyle = Component.literal("???").withStyle(ChatFormatting.GRAY);
        Object[] objArr = new Object[2];
        objArr[0] = c0357g.m1716a().isConnected() ? componentWithColor : f2033fd;
        objArr[1] = z ? mutableComponentWithColor : mutableComponentWithStyle;
        return Component.translatable("bf.menu.text.network", objArr);
    }
}
