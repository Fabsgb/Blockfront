package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ds */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ds.class */
public class C0243ds extends AbstractC0242dr {

    /* JADX INFO: renamed from: eX */
    @NotNull
    private static final Component f2015eX = Component.translatable("bf.menu.text.punished.title").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final ItemStack f2016b = new ItemStack((ItemLike) C1231wY.f7115l.get());

    /* JADX INFO: renamed from: gw */
    private static final int f2017gw = 50;

    /* JADX INFO: renamed from: gx */
    private static final int f2018gx = 250;

    /* JADX INFO: renamed from: dU */
    private static final float f2019dU = 1.5f;

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1410a(@NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull Minecraft minecraft, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        C0482iS c0482iSM1676a = c0326fV.m1676a(minecraft);
        int i5 = i / 2;
        int i6 = 8;
        poseStack.pushPose();
        if (minecraft.screen instanceof AbstractC0205dG) {
            i6 = 15;
        }
        C0119bk.m415a(guiGraphics, 0, 40, i, i6, C0119bk.m365p());
        C0119bk.m417a(guiGraphics, 0, 40 + i6, i, 1, C0119bk.m365p(), 0.25f);
        C0119bk.m491c(guiGraphics, 0, 0, i, 40, C0119bk.m365p());
        C0119bk.m491c(guiGraphics, 0, i2 - 40, i, 40, C0119bk.m365p());
        C0119bk.m517a(guiGraphics, i5 - 162, 0, 325, 40);
        m1414a(poseStack, font, guiGraphics, i5, c0482iSM1676a);
        guiGraphics.disableScissor();
        C0119bk.m423a(guiGraphics, 0, i2 - 50, i, 50, ColorReferences.COLOR_BLACK_TRANSPARENT, -1442840576);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    private static void m1414a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, @NotNull C0482iS c0482iS) {
        if (!c0482iS.getActivePunishments().isEmpty()) {
            C0119bk.m383c(font, guiGraphics, f2015eX, i, 10);
            int i2 = 0;
            ObjectListIterator it = C0471iH.m2131a(font, I18n.get("bf.menu.text.punished.par1", new Object[]{String.valueOf(ChatFormatting.RED) + String.valueOf(c0482iS.getActivePunishments().size()) + String.valueOf(ChatFormatting.GRAY)}), 350).iterator();
            while (it.hasNext()) {
                C0119bk.m391b(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()).withStyle(ChatFormatting.GRAY), i, 20 + (5 * i2), 0.5f);
                i2++;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1411a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0482iS c0482iS, @NotNull C0195cx c0195cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
        boolean z = !c0482iS.getActivePunishments().isEmpty();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 50.0f);
        int i5 = i / 2;
        if (!z) {
            C0119bk.m501a(poseStack, guiGraphics, f2016b, i5, 32.0f, 0.19f);
            m1415a(guiGraphics, poseStack, font, f, i5);
        }
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    private static void m1415a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, float f, int i) {
        ObjectList<String> objectListM2131a = C0471iH.m2131a(font, C0195cx.f1582F, f2018gx);
        poseStack.pushPose();
        poseStack.translate(i + 40.0f, 27.0f, 50.0f);
        poseStack.mulPose(Axis.ZP.rotationDegrees(-2.5f));
        float size = (1.5f - (0.4f * objectListM2131a.size())) + (0.1f * ((Mth.sin(f / 30.0f) + 1.0f) / 2.0f));
        poseStack.scale(size, size, size);
        ObjectListIterator it = objectListM2131a.iterator();
        while (it.hasNext()) {
            C0119bk.m401a(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()), 0, 0, ColorReferences.COLOR_THEME_YELLOW_SOLID);
            poseStack.translate(0.0f, 8.0f, 0.0f);
        }
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1412a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1413a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, float f) {
    }
}
