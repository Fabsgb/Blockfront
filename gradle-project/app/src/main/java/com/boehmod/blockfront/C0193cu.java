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

/* JADX INFO: renamed from: com.boehmod.blockfront.cu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cu.class */
public final class C0193cu extends AbstractC0195cw {

    /* JADX INFO: renamed from: I */
    @Nullable
    private static String f1555I;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static EnumC0960rS f1560a;

    /* JADX INFO: renamed from: J */
    @Nullable
    private static String f1561J;

    /* JADX INFO: renamed from: aY */
    private static boolean f1562aY;

    /* JADX INFO: renamed from: eN */
    private static int f1556eN = -1;

    /* JADX INFO: renamed from: w */
    @NotNull
    private static FormattedCharSequence f1557w = FormattedCharSequence.EMPTY;

    /* JADX INFO: renamed from: eO */
    private static int f1558eO = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: x */
    @NotNull
    private static FormattedCharSequence f1559x = FormattedCharSequence.EMPTY;

    /* JADX INFO: renamed from: y */
    @NotNull
    private static FormattedCharSequence f1563y = FormattedCharSequence.EMPTY;

    /* JADX INFO: renamed from: a */
    private static void m1224a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull InterfaceC1128ua interfaceC1128ua, int i, int i2, float f) {
        if (interfaceC1128ua.mo6471by() <= 0) {
            return;
        }
        int iMo6197cj = (interfaceC1128ua.mo6197cj() - interfaceC1128ua.mo6471by()) / 20;
        String strMo6198az = interfaceC1128ua.mo6198az();
        String strM439a = C0125bp.m439a(f);
        if (!strMo6198az.equals(f1555I) || strM439a.length() != f1556eN) {
            f1555I = strMo6198az;
            f1556eN = strM439a.length();
            f1557w = Component.translatable(strMo6198az).append(strM439a).getVisualOrderText();
        }
        if (iMo6197cj != f1558eO) {
            f1558eO = iMo6197cj;
            f1559x = Component.literal(" " + C0129bt.m602a(iMo6197cj)).withColor(ColorReferences.COLOR_WHITE).getVisualOrderText();
        }
        C0129bt.m591c(guiGraphics, i - 70, i2 - 29, 140, 30, C0129bt.m465t());
        C0129bt.m531a(poseStack, guiGraphics, interfaceC1128ua.getIcon(), (i - 70) - 16, (i2 - 16) - 14, 32, 32);
        C0129bt.m507c(font, guiGraphics, f1557w, i + 4, i2 - 25);
        int i3 = i - 43;
        int i4 = i2 - 12;
        float fMo6471by = (100 * interfaceC1128ua.mo6471by()) / interfaceC1128ua.mo6197cj();
        C0129bt.m517a(guiGraphics, i3, i4, 100, 10, ColorReferences.COLOR_BLACK_SOLID, C0129bt.m465t());
        C0129bt.m516a(poseStack, guiGraphics, i3, i4, fMo6471by, 10.0f, interfaceC1128ua.getColor(), 0.5f);
        C0129bt.m507c(font, guiGraphics, f1559x, i3 + 50, i4 + 2);
    }

    @Override // com.boehmod.blockfront.AbstractC0195cw
    /* JADX INFO: renamed from: a */
    public void mo1214a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0623l c0623l) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        float fM466g = C0129bt.m466g();
        if (localPlayer == null || minecraft.options.hideGui || (abstractC0863pbM2874a = c0623l.m2874a()) == null) {
            return;
        }
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        PoseStack poseStackPose = guiGraphics.pose();
        AbstractC0866pe abstractC0866peM4018b = abstractC0863pbM2874a.m4018b();
        ItemStack itemInHand = localPlayer.getItemInHand(InteractionHand.MAIN_HAND);
        int iGuiWidth = guiGraphics.guiWidth() / 2;
        int iGuiHeight = guiGraphics.guiHeight() / 2;
        if (minecraft.screen == null) {
            EnumC0960rS enumC0960rS = C1102uA.f6003b;
            float f = iGuiHeight - 64;
            float fM7170f = C1270xJ.m7170f(C1102uA.f6004nK, C1102uA.f6005nL, gameTimeDeltaPartialTick);
            C0129bt.m549c(poseStackPose, guiGraphics, C0143cG.f1039aJ, iGuiWidth, f, 64.0f, 64.0f, 1.0f + (0.25f * fM7170f), fM7170f * 0.25f);
            if (!itemInHand.isEmpty() && (itemInHand.getItem() instanceof C1102uA)) {
                float f2 = 10.0f * (1.0f - fM7170f);
                C0872pk c0872pkM4229a = abstractC0866peM4018b.m4229a(localPlayer.getUUID());
                if (c0872pkM4229a != null) {
                    int iM4303a = c0872pkM4229a.m4303a(enumC0960rS.getCooldownStat(), 0);
                    String strM602a = C0129bt.m602a(iM4303a / 20);
                    boolean z = !enumC0960rS.hasCooldown() || iM4303a <= 0;
                    if (enumC0960rS != f1560a || z != f1562aY || !strM602a.equals(f1561J)) {
                        f1560a = enumC0960rS;
                        f1562aY = z;
                        f1561J = strM602a;
                        MutableComponent mutableComponentTranslatable = Component.translatable(enumC0960rS.getLocale());
                        if (!z) {
                            mutableComponentTranslatable.append(" (" + strM602a + ")");
                        }
                        f1563y = mutableComponentTranslatable.withStyle(z ? ChatFormatting.WHITE : ChatFormatting.RED).getVisualOrderText();
                    }
                    C0129bt.m509a(poseStackPose, font, guiGraphics, f1563y, iGuiWidth, (f + 20.0f) - f2);
                }
            }
            if (fM7170f > 0.0f) {
                C0129bt.m549c(poseStackPose, guiGraphics, enumC0960rS.getIcon(), iGuiWidth, f - 5.0f, 30.0f, 30.0f, 1.0f + (0.2f * fM7170f), fM7170f);
            }
        }
        InterfaceC1128ua item = itemInHand.getItem();
        if (item instanceof InterfaceC1128ua) {
            m1224a(poseStackPose, guiGraphics, font, item, iGuiWidth, iGuiHeight, fM466g);
        }
    }
}
