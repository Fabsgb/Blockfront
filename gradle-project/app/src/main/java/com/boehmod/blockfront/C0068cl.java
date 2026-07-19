package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.cl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cl.class */
public final class C0068cl extends AbstractC0070cn {

    @Nullable
    private static String C;

    @Nullable
    private static EnumC0481rv a;

    @Nullable
    private static String D;
    private static boolean aT;
    private static int dN = -1;

    @NotNull
    private static FormattedCharSequence u = FormattedCharSequence.EMPTY;
    private static int dO = Integer.MIN_VALUE;

    @NotNull
    private static FormattedCharSequence v = FormattedCharSequence.EMPTY;

    @NotNull
    private static FormattedCharSequence w = FormattedCharSequence.EMPTY;

    private static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull tC tCVar, int i, int i2, float f) {
        if (tCVar.bj() <= 0) {
            return;
        }
        int iBU = (tCVar.bU() - tCVar.bj()) / 20;
        String strAs = tCVar.as();
        String strA = C0037bh.a(f);
        if (!strAs.equals(C) || strA.length() != dN) {
            C = strAs;
            dN = strA.length();
            u = Component.translatable(strAs).append(strA).getVisualOrderText();
        }
        if (iBU != dO) {
            dO = iBU;
            v = Component.literal(" " + C0040bk.a(iBU)).withColor(ColorReferences.COLOR_WHITE).getVisualOrderText();
        }
        C0040bk.c(guiGraphics, i - 70, i2 - 29, 140, 30, C0040bk.p());
        C0040bk.a(poseStack, guiGraphics, tCVar.getIcon(), (i - 70) - 16, (i2 - 16) - 14, 32, 32);
        C0040bk.c(font, guiGraphics, u, i + 4, i2 - 25);
        int i3 = i - 43;
        int i4 = i2 - 12;
        C0040bk.a(guiGraphics, i3, i4, 100, 10, ColorReferences.COLOR_BLACK_SOLID, C0040bk.p());
        C0040bk.a(poseStack, guiGraphics, i3, i4, (100 * tCVar.bj()) / tCVar.bU(), 10.0f, tCVar.getColor(), 0.5f);
        C0040bk.c(font, guiGraphics, v, i3 + 50, i4 + 2);
    }

    @Override // com.boehmod.blockfront.AbstractC0070cn
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0297l c0297l) {
        oF<?, ?, ?> oFVarM591a;
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        float fG = C0040bk.g();
        if (localPlayer == null || minecraft.options.hideGui || (oFVarM591a = c0297l.m591a()) == null) {
            return;
        }
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        PoseStack poseStackPose = guiGraphics.pose();
        oI oIVarB = oFVarM591a.b();
        ItemStack itemInHand = localPlayer.getItemInHand(InteractionHand.MAIN_HAND);
        int iGuiWidth = guiGraphics.guiWidth() / 2;
        int iGuiHeight = guiGraphics.guiHeight() / 2;
        if (minecraft.screen == null) {
            EnumC0481rv enumC0481rv = C0543uc.b;
            float f = iGuiHeight - 64;
            float fE = C0634xm.e(C0543uc.mL, C0543uc.mM, gameTimeDeltaPartialTick);
            C0040bk.c(poseStackPose, guiGraphics, C0080cx.aJ, iGuiWidth, f, 64.0f, 64.0f, 1.0f + (0.25f * fE), fE * 0.25f);
            if (!itemInHand.isEmpty() && (itemInHand.getItem() instanceof C0543uc)) {
                float f2 = 10.0f * (1.0f - fE);
                oO oOVarA = oIVarB.a(localPlayer.getUUID());
                if (oOVarA != null) {
                    int iM790a = oOVarA.m790a(enumC0481rv.getCooldownStat(), 0);
                    String strA = C0040bk.a(iM790a / 20);
                    boolean z = !enumC0481rv.hasCooldown() || iM790a <= 0;
                    if (enumC0481rv != a || z != aT || !strA.equals(D)) {
                        a = enumC0481rv;
                        aT = z;
                        D = strA;
                        MutableComponent mutableComponentTranslatable = Component.translatable(enumC0481rv.getLocale());
                        if (!z) {
                            mutableComponentTranslatable.append(" (" + strA + ")");
                        }
                        w = mutableComponentTranslatable.withStyle(z ? ChatFormatting.WHITE : ChatFormatting.RED).getVisualOrderText();
                    }
                    C0040bk.a(poseStackPose, font, guiGraphics, w, iGuiWidth, (f + 20.0f) - f2);
                }
            }
            if (fE > 0.0f) {
                C0040bk.c(poseStackPose, guiGraphics, enumC0481rv.getIcon(), iGuiWidth, f - 5.0f, 30.0f, 30.0f, 1.0f + (0.2f * fE), fE);
            }
        }
        tC item = itemInHand.getItem();
        if (item instanceof tC) {
            a(poseStackPose, guiGraphics, font, item, iGuiWidth, iGuiHeight, fG);
        }
    }
}
