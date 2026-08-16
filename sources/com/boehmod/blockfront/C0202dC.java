package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.Booster;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dC.class */
public class C0202dC extends AbstractC0200dA {
    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1236a(@NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull Minecraft minecraft, @NotNull C0143cG c0143cG, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        int i5 = i - 90;
        List<Booster> activeBoosters = c0396gl.m1886a(minecraft).getActiveBoosters();
        if (!activeBoosters.isEmpty()) {
            boolean zM573b = C0129bt.m573b(i5 - 25, 1.0d, 50.0d, 15.0d, i3, i4);
            C0129bt.m491b(poseStack, font, guiGraphics, (Component) Component.translatable("bf.menu.text.boosters.active", new Object[]{Integer.valueOf(activeBoosters.size())}).withStyle(zM573b ? ChatFormatting.WHITE : ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD), i5, 6, 0.5f);
            if (zM573b) {
                guiGraphics.pose().pushPose();
                guiGraphics.pose().translate(0.0f, 0.0f, 250.0f);
                int size = 11 * activeBoosters.size();
                int i6 = 104;
                int i7 = 0;
                ObjectArrayList objectArrayList = new ObjectArrayList();
                for (Booster booster : activeBoosters) {
                    String str = String.valueOf(ChatFormatting.GREEN) + "Booster " + booster.getType().getTitle().toUpperCase(Locale.ROOT) + " - " + String.valueOf(ChatFormatting.WHITE) + booster.getTimeRemainingInMinutes() + "m" + String.valueOf(ChatFormatting.GREEN) + "/" + String.valueOf(ChatFormatting.WHITE) + booster.getMaxMinutes() + "m";
                    objectArrayList.add(str);
                    int iWidth = font.width(ChatFormatting.stripFormatting(str));
                    if (iWidth > i6) {
                        i6 = iWidth;
                    }
                }
                C0129bt.m593c(guiGraphics, i3 - i6, i4, i6, size, 0, 0.5f);
                Iterator it = objectArrayList.iterator();
                while (it.hasNext()) {
                    C0129bt.m470a(font, guiGraphics, (Component) Component.literal((String) it.next()), (i3 - i6) + 2, i4 + i7 + 2);
                    i7 += 11;
                }
                guiGraphics.pose().popPose();
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1237a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0555jl c0555jl, @NotNull C0143cG c0143cG, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1238a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0143cG c0143cG, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1239a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0143cG c0143cG, float f) {
    }
}
