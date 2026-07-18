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

/* JADX INFO: renamed from: com.boehmod.blockfront.bu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bu.class */
public final class C0129bu {

    /* JADX INFO: renamed from: V */
    private static final ResourceLocation f923V;

    /* JADX INFO: renamed from: W */
    private static final ResourceLocation f924W;

    /* JADX INFO: renamed from: cK */
    public static final int f925cK = 15;

    /* JADX INFO: renamed from: a */
    @NotNull
    public CloudItemStack f926a;

    /* JADX INFO: renamed from: bm */
    public int f927bm;

    /* JADX INFO: renamed from: cL */
    public int f928cL;

    /* JADX INFO: renamed from: bn */
    public int f929bn;

    /* JADX INFO: renamed from: cM */
    public int f930cM;

    /* JADX INFO: renamed from: cN */
    public int f931cN;

    /* JADX INFO: renamed from: aF */
    public boolean f932aF = false;

    /* JADX INFO: renamed from: aG */
    private boolean f933aG;

    /* JADX INFO: renamed from: aH */
    private boolean f934aH;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Screen f935a;

    /* JADX INFO: renamed from: aI */
    static final /* synthetic */ boolean f936aI;

    static {
        f936aI = !C0129bu.class.desiredAssertionStatus();
        f923V = C0564jv.m2555d("textures/gui/menu/icons/check_long_white.png");
        f924W = C0564jv.m2555d("textures/gui/menu/icons/magnifying_glass.png");
    }

    public C0129bu(@NotNull Screen screen, @NotNull CloudItemStack cloudItemStack, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.f935a = screen;
        this.f926a = cloudItemStack;
        this.f928cL = i;
        this.f927bm = i;
        this.f929bn = i2;
        this.f930cM = i3;
        this.f931cN = i4;
        this.f933aG = z;
        this.f934aH = z2;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0129bu m672a(boolean z) {
        this.f932aF = z;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m673a(@NotNull Minecraft minecraft, @NotNull CloudRegistry cloudRegistry) {
        CloudItem<?> cloudItem = this.f926a.getCloudItem(cloudRegistry);
        if (cloudItem == null) {
            return;
        }
        CloudItemRarity rarity = cloudItem.getRarity();
        InterfaceC0092bJ c0094bL = null;
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        int i = this.f930cM / 2;
        int i2 = this.f931cN / 2;
        int iNextInt = (-i) + threadLocalRandomCurrent.nextInt(i * 2);
        int iNextInt2 = (-i2) + threadLocalRandomCurrent.nextInt(i2 * 2);
        int i3 = this.f927bm + (this.f930cM / 2);
        int i4 = this.f929bn + (this.f931cN / 2);
        String collection = cloudItem.getCollection();
        if (rarity == CloudItemRarity.DIAMOND || rarity == CloudItemRarity.OBSIDIAN) {
            c0094bL = new C0094bL(i3 + iNextInt, i4 + iNextInt2);
        } else if (collection != null && collection.contains("Halloween")) {
            c0094bL = new C0090bH(i3 + iNextInt, i4 + iNextInt2);
        } else if (collection != null && collection.contains("Christmas")) {
            c0094bL = new C0095bM(i3 + iNextInt, i4 + iNextInt2);
        }
        if (c0094bL != null) {
            Screen screen = minecraft.screen;
            if (screen instanceof C0195cx) {
                C0195cx c0195cx = (C0195cx) screen;
                if (Math.random() <= 0.04d) {
                    c0195cx.m1191a(minecraft, c0094bL);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m674a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f) {
        m675a(minecraft, guiGraphics, font, false, i, i2, f);
    }

    /* JADX INFO: renamed from: a */
    public void m675a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, Font font, boolean z, int i, int i2, float f) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f936aI && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudRegistry cloudRegistryA = c0622lM2667b.m2670a();
        int i3 = this.f930cM / 2;
        float fM7843e = C1290xm.m7843e(this.f927bm, this.f928cL, f);
        boolean z2 = this.f935a == minecraft.screen && m678a(i, i2) && !z;
        CloudItem<?> cloudItem = this.f926a.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        AbstractC0543ja<?> abstractC0543jaM2468a = C0544jb.m2468a(cloudItem);
        float fHashCode = (this.f926a.getUUID().hashCode() + this.f926a.getDisplayName(cloudRegistryA).hashCode()) / 100000.0f;
        int color = cloudItem.getRarity().getColor();
        PoseStack poseStackPose = guiGraphics.pose();
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        m676a(poseStackPose, guiGraphics, color, (int) fM7843e);
        abstractC0543jaM2468a.mo2227a(cloudItem, this.f926a, minecraft, guiGraphics, poseStackPose, bufferSource, (int) fM7843e, this.f929bn, this.f930cM, this.f931cN, i, i2, fM7843e, fHashCode, f);
        int i4 = 0;
        for (int i5 = 0; i5 < 16; i5++) {
            int sticker = this.f926a.getSticker(i5);
            if (sticker != -1) {
                CloudItem<?> item = cloudRegistryA.getItem(sticker);
                if (item instanceof CloudItemSticker) {
                    C0119bk.m431a(poseStackPose, guiGraphics, C0564jv.m2555d("textures/stickers/" + ((CloudItemSticker) item).getSuffixForDisplay() + ".png"), ((int) fM7843e) + 2 + (10 * i4), this.f929bn + 2, 8, 8);
                    i4++;
                }
            }
        }
        Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.WHITE);
        String name = cloudItem.getName();
        String suffix = cloudItem.getRarity() == CloudItemRarity.DEFAULT ? C0479iP.f2938ax : cloudItem.getSuffix();
        int iWidth = font.width(name);
        int iWidth2 = font.width(suffix);
        float f2 = iWidth <= this.f930cM ? 0.85f : 0.55f;
        float f3 = iWidth2 <= this.f930cM ? 0.7f : 0.5f;
        float f4 = iWidth <= this.f930cM ? -1.0f : 0.5f;
        float f5 = iWidth2 <= this.f930cM ? 0.0f : 1.0f;
        MutableComponent mutableComponentWithStyle = Component.literal(C1293xp.m7914a(name, 12)).withStyle(styleWithColor).withStyle(C0565jw.f3201b);
        if (z2) {
            mutableComponentWithStyle.withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
        }
        C0119bk.m390b(poseStackPose, font, guiGraphics, (Component) mutableComponentWithStyle, fM7843e + i3, ((this.f929bn + this.f931cN) - 15) + f4, f2);
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
        C0119bk.m393c(poseStackPose, font, guiGraphics, (Component) mutableComponentLiteral, ((int) fM7843e) + i3, ((this.f929bn + this.f931cN) - 7) + f5, f3);
        float f6 = ((fM7843e + this.f930cM) - 10.0f) + 0.5f;
        int i6 = this.f929bn + 1;
        float f7 = 0.0f;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 15.0f);
        if (this.f933aG) {
            C0119bk.m436a(poseStackPose, guiGraphics, f923V, f6, i6, 8.0f, 8.0f, 0.0f, 1.0f, color);
            f7 = 0.0f - 9.0f;
        }
        if (this.f934aH) {
            C0119bk.m436a(poseStackPose, guiGraphics, f924W, f6 + f7, i6, 8.0f, 8.0f, 0.0f, 1.0f, color);
        }
        poseStackPose.popPose();
        if (z2) {
            if (this.f932aF) {
                m677a(guiGraphics, (int) fM7843e);
            }
            CloudItemStack cloudItemStack = this.f926a;
            ObjectArrayList objectArrayList = new ObjectArrayList();
            C0487iX.m2214a(c0622lM2667b.m2670a(), minecraft, (C0326fV) c0622lM2667b.m2670a(), cloudItemStack, objectArrayList, font, C0357g.f2439g);
            if (C0424hN.f2763Q.m1996T()) {
                objectArrayList.add(Component.empty());
                objectArrayList.add(Component.literal("UUID: ").withColor(ColorReferences.COLOR_WHITE).append(Component.literal(cloudItemStack.getUUID().toString()).withStyle(ChatFormatting.GRAY)));
            }
            guiGraphics.renderTooltip(font, objectArrayList, Optional.empty(), i, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m676a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        C0119bk.m417a(guiGraphics, i2, this.f929bn + 1, this.f930cM, this.f931cN - 2, i, 0.4f);
        C0119bk.m417a(guiGraphics, i2 + 1, this.f929bn + 1, this.f930cM - 2, this.f931cN - 1, i, 0.4f);
        C0119bk.m417a(guiGraphics, i2, this.f929bn, this.f930cM, 1, i, 0.3f);
        C0119bk.m423a(guiGraphics, i2, this.f929bn + 1, this.f930cM, this.f931cN - 16, 570425344, i);
        C0119bk.m423a(guiGraphics, i2, (this.f929bn + this.f931cN) - 19, this.f930cM, 3, ColorReferences.COLOR_BLACK_TRANSPARENT, 855638016);
        C0119bk.m415a(guiGraphics, i2, (this.f929bn + this.f931cN) - 15, this.f930cM, 14, i);
        C0119bk.m415a(guiGraphics, i2, (this.f929bn + this.f931cN) - 1, this.f930cM, 1, i);
        C0119bk.m417a(guiGraphics, i2, (this.f929bn + this.f931cN) - 8, this.f930cM, 7, 0, 0.2f);
        C0119bk.m423a(guiGraphics, i2, (this.f929bn + this.f931cN) - 8, this.f930cM, 3, 1426063360, ColorReferences.COLOR_BLACK_TRANSPARENT);
        C0119bk.m417a(guiGraphics, i2 + 1, (this.f929bn + this.f931cN) - 1, this.f930cM - 2, 1, 0, 0.2f);
        C0119bk.m431a(poseStack, guiGraphics, C0195cx.f1577aU, i2 + 1, this.f929bn + 1, this.f930cM - 2, this.f931cN - 2);
    }

    /* JADX INFO: renamed from: a */
    public void m677a(@NotNull GuiGraphics guiGraphics, int i) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        int i2 = ColorReferences.COLOR_THEME_YELLOW_SOLID;
        C0119bk.m415a(guiGraphics, i - 1, this.f929bn, 1, this.f931cN, i2);
        C0119bk.m415a(guiGraphics, i + this.f930cM, this.f929bn, 1, this.f931cN, i2);
        C0119bk.m415a(guiGraphics, i - 1, this.f929bn - 1, this.f930cM + 2, 1, i2);
        C0119bk.m415a(guiGraphics, i - 1, this.f929bn + this.f931cN, this.f930cM + 2, 1, i2);
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    public boolean m678a(int i, int i2) {
        return new Rectangle(this.f927bm, this.f929bn, this.f930cM, this.f931cN).contains(i, i2);
    }

    /* JADX INFO: renamed from: d */
    public void m679d(boolean z) {
        this.f933aG = z;
    }

    /* JADX INFO: renamed from: e */
    public void m680e(boolean z) {
        this.f934aH = z;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudItemStack m681a() {
        return this.f926a;
    }
}
