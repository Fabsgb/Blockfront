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

/* JADX INFO: renamed from: com.boehmod.blockfront.cl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cl.class */
public final class C0173cl extends AbstractC0179cn {

    /* JADX INFO: renamed from: C */
    @Nullable
    private static String f1431C;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static EnumC0988rv f1436a;

    /* JADX INFO: renamed from: D */
    @Nullable
    private static String f1437D;

    /* JADX INFO: renamed from: aT */
    private static boolean f1438aT;

    /* JADX INFO: renamed from: dN */
    private static int f1432dN = -1;

    /* JADX INFO: renamed from: u */
    @NotNull
    private static FormattedCharSequence f1433u = FormattedCharSequence.EMPTY;

    /* JADX INFO: renamed from: dO */
    private static int f1434dO = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: v */
    @NotNull
    private static FormattedCharSequence f1435v = FormattedCharSequence.EMPTY;

    /* JADX INFO: renamed from: w */
    @NotNull
    private static FormattedCharSequence f1439w = FormattedCharSequence.EMPTY;

    /* JADX INFO: renamed from: a */
    private static void m1036a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull InterfaceC1050tC interfaceC1050tC, int i, int i2, float f) {
        if (interfaceC1050tC.mo5833bj() <= 0) {
            return;
        }
        int iMo5834bU = (interfaceC1050tC.mo5834bU() - interfaceC1050tC.mo5833bj()) / 20;
        String strMo5835as = interfaceC1050tC.mo5835as();
        String strM346a = C0116bh.m346a(f);
        if (!strMo5835as.equals(f1431C) || strM346a.length() != f1432dN) {
            f1431C = strMo5835as;
            f1432dN = strM346a.length();
            f1433u = Component.translatable(strMo5835as).append(strM346a).getVisualOrderText();
        }
        if (iMo5834bU != f1434dO) {
            f1434dO = iMo5834bU;
            f1435v = Component.literal(" " + C0119bk.m502a(iMo5834bU)).withColor(ColorReferences.COLOR_WHITE).getVisualOrderText();
        }
        C0119bk.m491c(guiGraphics, i - 70, i2 - 29, 140, 30, C0119bk.m365p());
        C0119bk.m431a(poseStack, guiGraphics, interfaceC1050tC.getIcon(), (i - 70) - 16, (i2 - 16) - 14, 32, 32);
        C0119bk.m407c(font, guiGraphics, f1433u, i + 4, i2 - 25);
        int i3 = i - 43;
        int i4 = i2 - 12;
        C0119bk.m417a(guiGraphics, i3, i4, 100, 10, ColorReferences.COLOR_BLACK_SOLID, C0119bk.m365p());
        C0119bk.m416a(poseStack, guiGraphics, i3, i4, (100 * interfaceC1050tC.mo5833bj()) / interfaceC1050tC.mo5834bU(), 10.0f, interfaceC1050tC.getColor(), 0.5f);
        C0119bk.m407c(font, guiGraphics, f1435v, i3 + 50, i4 + 2);
    }

    @Override // com.boehmod.blockfront.AbstractC0179cn
    /* JADX INFO: renamed from: a */
    public void mo1027a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0622l c0622l) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        float fM366g = C0119bk.m366g();
        if (localPlayer == null || minecraft.options.hideGui || (abstractC0787oFM2688a = c0622l.m2688a()) == null) {
            return;
        }
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        PoseStack poseStackPose = guiGraphics.pose();
        AbstractC0790oI abstractC0790oIM3582b = abstractC0787oFM2688a.m3582b();
        ItemStack itemInHand = localPlayer.getItemInHand(InteractionHand.MAIN_HAND);
        int iGuiWidth = guiGraphics.guiWidth() / 2;
        int iGuiHeight = guiGraphics.guiHeight() / 2;
        if (minecraft.screen == null) {
            EnumC0988rv enumC0988rv = C1129uc.f5937b;
            float f = iGuiHeight - 64;
            float fM7843e = C1290xm.m7843e(C1129uc.f5938mL, C1129uc.f5939mM, gameTimeDeltaPartialTick);
            C0119bk.m449c(poseStackPose, guiGraphics, C0195cx.f1566aJ, iGuiWidth, f, 64.0f, 64.0f, 1.0f + (0.25f * fM7843e), fM7843e * 0.25f);
            if (!itemInHand.isEmpty() && (itemInHand.getItem() instanceof C1129uc)) {
                float f2 = 10.0f * (1.0f - fM7843e);
                C0796oO c0796oOM3793a = abstractC0790oIM3582b.m3793a(localPlayer.getUUID());
                if (c0796oOM3793a != null) {
                    int iM3867a = c0796oOM3793a.m3867a(enumC0988rv.getCooldownStat(), 0);
                    String strM502a = C0119bk.m502a(iM3867a / 20);
                    boolean z = !enumC0988rv.hasCooldown() || iM3867a <= 0;
                    if (enumC0988rv != f1436a || z != f1438aT || !strM502a.equals(f1437D)) {
                        f1436a = enumC0988rv;
                        f1438aT = z;
                        f1437D = strM502a;
                        MutableComponent mutableComponentTranslatable = Component.translatable(enumC0988rv.getLocale());
                        if (!z) {
                            mutableComponentTranslatable.append(" (" + strM502a + ")");
                        }
                        f1439w = mutableComponentTranslatable.withStyle(z ? ChatFormatting.WHITE : ChatFormatting.RED).getVisualOrderText();
                    }
                    C0119bk.m409a(poseStackPose, font, guiGraphics, f1439w, iGuiWidth, (f + 20.0f) - f2);
                }
            }
            if (fM7843e > 0.0f) {
                C0119bk.m449c(poseStackPose, guiGraphics, enumC0988rv.getIcon(), iGuiWidth, f - 5.0f, 30.0f, 30.0f, 1.0f + (0.2f * fM7843e), fM7843e);
            }
        }
        InterfaceC1050tC item = itemInHand.getItem();
        if (item instanceof InterfaceC1050tC) {
            m1036a(poseStackPose, guiGraphics, font, item, iGuiWidth, iGuiHeight, fM366g);
        }
    }
}
