package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemRarity;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCallingCard;
import com.boehmod.bflib.cloud.common.item.types.CloudItemSticker;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.awt.Rectangle;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bu.class */
public final class C0050bu {
    private static final ResourceLocation V;
    private static final ResourceLocation W;
    public static final int cK = 15;

    @NotNull
    public CloudItemStack a;
    public int bm;
    public int cL;
    public int bn;
    public int cM;
    public int cN;
    public boolean aF = false;
    private boolean aG;
    private boolean aH;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final Screen f70a;
    static final /* synthetic */ boolean aI;

    static {
        aI = !C0050bu.class.desiredAssertionStatus();
        V = C0265jv.d("textures/gui/menu/icons/check_long_white.png");
        W = C0265jv.d("textures/gui/menu/icons/magnifying_glass.png");
    }

    public C0050bu(@NotNull Screen screen, @NotNull CloudItemStack cloudItemStack, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.f70a = screen;
        this.a = cloudItemStack;
        this.cL = i;
        this.bm = i;
        this.bn = i2;
        this.cM = i3;
        this.cN = i4;
        this.aG = z;
        this.aH = z2;
    }

    @NotNull
    public C0050bu a(boolean z) {
        this.aF = z;
        return this;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull CloudRegistry cloudRegistry) {
        CloudItem<?> cloudItem = this.a.getCloudItem(cloudRegistry);
        if (cloudItem == null) {
            return;
        }
        CloudItemRarity rarity = cloudItem.getRarity();
        bJ bLVar = null;
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        int i = this.cM / 2;
        int i2 = this.cN / 2;
        int iNextInt = (-i) + threadLocalRandomCurrent.nextInt(i * 2);
        int iNextInt2 = (-i2) + threadLocalRandomCurrent.nextInt(i2 * 2);
        int i3 = this.bm + (this.cM / 2);
        int i4 = this.bn + (this.cN / 2);
        String collection = cloudItem.getCollection();
        if (rarity == CloudItemRarity.DIAMOND || rarity == CloudItemRarity.OBSIDIAN) {
            bLVar = new bL(i3 + iNextInt, i4 + iNextInt2);
        } else if (collection != null && collection.contains("Halloween")) {
            bLVar = new bH(i3 + iNextInt, i4 + iNextInt2);
        } else if (collection != null && collection.contains("Christmas")) {
            bLVar = new bM(i3 + iNextInt, i4 + iNextInt2);
        }
        if (bLVar != null) {
            Screen screen = minecraft.screen;
            if (screen instanceof C0080cx) {
                C0080cx c0080cx = (C0080cx) screen;
                if (Math.random() <= 0.04d) {
                    c0080cx.a(minecraft, bLVar);
                }
            }
        }
    }

    public void a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f) {
        a(minecraft, guiGraphics, font, false, i, i2, f);
    }

    public void a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, Font font, boolean z, int i, int i2, float f) {
        C0297l c0297lB = C0297l.b();
        if (!aI && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudRegistry cloudRegistryA = c0297lB.a();
        int i3 = this.cM / 2;
        float fE = C0634xm.e(this.bm, this.cL, f);
        boolean z2 = this.f70a == minecraft.screen && a(i, i2) && !z;
        CloudItem<?> cloudItem = this.a.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        AbstractC0244ja<?> abstractC0244jaA = C0245jb.a(cloudItem);
        float fHashCode = (this.a.getUUID().hashCode() + this.a.getDisplayName(cloudRegistryA).hashCode()) / 100000.0f;
        int color = cloudItem.getRarity().getColor();
        PoseStack poseStackPose = guiGraphics.pose();
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        a(poseStackPose, guiGraphics, color, (int) fE);
        abstractC0244jaA.a(cloudItem, this.a, minecraft, guiGraphics, poseStackPose, bufferSource, (int) fE, this.bn, this.cM, this.cN, i, i2, fE, fHashCode, f);
        int i4 = 0;
        for (int i5 = 0; i5 < 16; i5++) {
            int sticker = this.a.getSticker(i5);
            if (sticker != -1) {
                CloudItem<?> item = cloudRegistryA.getItem(sticker);
                if (item instanceof CloudItemSticker) {
                    C0040bk.a(poseStackPose, guiGraphics, C0265jv.d("textures/stickers/" + ((CloudItemSticker) item).getSuffixForDisplay() + ".png"), ((int) fE) + 2 + (10 * i4), this.bn + 2, 8, 8);
                    i4++;
                }
            }
        }
        Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.WHITE);
        String name = cloudItem.getName();
        String suffix = cloudItem.getRarity() == CloudItemRarity.DEFAULT ? iP.ax : cloudItem.getSuffix();
        int iWidth = font.width(name);
        int iWidth2 = font.width(suffix);
        float f2 = iWidth <= this.cM ? 0.85f : 0.55f;
        float f3 = iWidth2 <= this.cM ? 0.7f : 0.5f;
        float f4 = iWidth <= this.cM ? -1.0f : 0.5f;
        float f5 = iWidth2 <= this.cM ? 0.0f : 1.0f;
        MutableComponent mutableComponentWithStyle = Component.literal(C0637xp.a(name, 12)).withStyle(styleWithColor).withStyle(C0266jw.b);
        if (z2) {
            mutableComponentWithStyle.withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
        }
        C0040bk.b(poseStackPose, font, guiGraphics, (Component) mutableComponentWithStyle, fE + i3, ((this.bn + this.cN) - 15) + f4, f2);
        if (suffix.isEmpty()) {
            suffix = "";
        }
        if (cloudItem instanceof CloudItemCallingCard) {
            suffix = cloudItem.getSuffix();
        }
        if (suffix.length() > 14) {
            suffix = suffix.substring(0, 14) + "..";
        }
        MutableComponent mutableComponentLiteral = Component.literal(suffix);
        if (z2) {
            mutableComponentLiteral.withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
        }
        C0040bk.c(poseStackPose, font, guiGraphics, (Component) mutableComponentLiteral, ((int) fE) + i3, ((this.bn + this.cN) - 7) + f5, f3);
        float f6 = ((fE + this.cM) - 10.0f) + 0.5f;
        int i6 = this.bn + 1;
        float f7 = 0.0f;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 15.0f);
        if (this.aG) {
            C0040bk.a(poseStackPose, guiGraphics, V, f6, i6, 8.0f, 8.0f, 0.0f, 1.0f, color);
            f7 = 0.0f - 9.0f;
        }
        if (this.aH) {
            C0040bk.a(poseStackPose, guiGraphics, W, f6 + f7, i6, 8.0f, 8.0f, 0.0f, 1.0f, color);
        }
        poseStackPose.popPose();
        if (z2) {
            if (this.aF) {
                a(guiGraphics, (int) fE);
            }
            CloudItemStack cloudItemStack = this.a;
            ObjectArrayList objectArrayList = new ObjectArrayList();
            iX.a(c0297lB.a(), minecraft, (fV) c0297lB.a(), cloudItemStack, objectArrayList, font, C0163g.g);
            if (hN.Q.T()) {
                objectArrayList.add(Component.empty());
                objectArrayList.add(Component.literal("UUID: ").withColor(ColorReferences.COLOR_WHITE).append(Component.literal(cloudItemStack.getUUID().toString()).withStyle(ChatFormatting.GRAY)));
            }
            guiGraphics.renderTooltip(font, objectArrayList, Optional.empty(), i, i2);
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        C0040bk.a(guiGraphics, i2, this.bn + 1, this.cM, this.cN - 2, i, 0.4f);
        C0040bk.a(guiGraphics, i2 + 1, this.bn + 1, this.cM - 2, this.cN - 1, i, 0.4f);
        C0040bk.a(guiGraphics, i2, this.bn, this.cM, 1, i, 0.3f);
        C0040bk.a(guiGraphics, i2, this.bn + 1, this.cM, this.cN - 16, 570425344, i);
        C0040bk.a(guiGraphics, i2, (this.bn + this.cN) - 19, this.cM, 3, ColorReferences.COLOR_BLACK_TRANSPARENT, 855638016);
        C0040bk.a(guiGraphics, i2, (this.bn + this.cN) - 15, this.cM, 14, i);
        C0040bk.a(guiGraphics, i2, (this.bn + this.cN) - 1, this.cM, 1, i);
        C0040bk.a(guiGraphics, i2, (this.bn + this.cN) - 8, this.cM, 7, 0, 0.2f);
        C0040bk.a(guiGraphics, i2, (this.bn + this.cN) - 8, this.cM, 3, 1426063360, ColorReferences.COLOR_BLACK_TRANSPARENT);
        C0040bk.a(guiGraphics, i2 + 1, (this.bn + this.cN) - 1, this.cM - 2, 1, 0, 0.2f);
        C0040bk.a(poseStack, guiGraphics, C0080cx.aU, i2 + 1, this.bn + 1, this.cM - 2, this.cN - 2);
    }

    public void a(@NotNull GuiGraphics guiGraphics, int i) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        int i2 = ColorReferences.COLOR_THEME_YELLOW_SOLID;
        C0040bk.a(guiGraphics, i - 1, this.bn, 1, this.cN, i2);
        C0040bk.a(guiGraphics, i + this.cM, this.bn, 1, this.cN, i2);
        C0040bk.a(guiGraphics, i - 1, this.bn - 1, this.cM + 2, 1, i2);
        C0040bk.a(guiGraphics, i - 1, this.bn + this.cN, this.cM + 2, 1, i2);
        poseStackPose.popPose();
    }

    public boolean a(int i, int i2) {
        return new Rectangle(this.bm, this.bn, this.cM, this.cN).contains(i, i2);
    }

    public void d(boolean z) {
        this.aG = z;
    }

    public void e(boolean z) {
        this.aH = z;
    }

    @NotNull
    public CloudItemStack a() {
        return this.a;
    }
}
