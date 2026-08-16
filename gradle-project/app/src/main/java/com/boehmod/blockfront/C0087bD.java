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

/* JADX INFO: renamed from: com.boehmod.blockfront.bD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bD.class */
public final class C0087bD {

    /* JADX INFO: renamed from: V */
    private static final ResourceLocation f562V;

    /* JADX INFO: renamed from: W */
    private static final ResourceLocation f563W;

    /* JADX INFO: renamed from: dC */
    public static final int f564dC = 15;

    /* JADX INFO: renamed from: a */
    @NotNull
    public CloudItemStack f565a;

    /* JADX INFO: renamed from: cc */
    public int f566cc;

    /* JADX INFO: renamed from: dD */
    public int f567dD;

    /* JADX INFO: renamed from: cd */
    public int f568cd;

    /* JADX INFO: renamed from: dE */
    public int f569dE;

    /* JADX INFO: renamed from: dF */
    public int f570dF;

    /* JADX INFO: renamed from: aK */
    public boolean f571aK = false;

    /* JADX INFO: renamed from: aL */
    private boolean f572aL;

    /* JADX INFO: renamed from: aM */
    private boolean f573aM;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Screen f574a;

    /* JADX INFO: renamed from: aN */
    static final /* synthetic */ boolean f575aN;

    static {
        f575aN = !C0087bD.class.desiredAssertionStatus();
        f562V = C0532jO.m2378d("textures/gui/menu/icons/check_long_white.png");
        f563W = C0532jO.m2378d("textures/gui/menu/icons/magnifying_glass.png");
    }

    public C0087bD(@NotNull Screen screen, @NotNull CloudItemStack cloudItemStack, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.f574a = screen;
        this.f565a = cloudItemStack;
        this.f567dD = i;
        this.f566cc = i;
        this.f568cd = i2;
        this.f569dE = i3;
        this.f570dF = i4;
        this.f572aL = z;
        this.f573aM = z2;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0087bD m347a(boolean z) {
        this.f571aK = z;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m348a(@NotNull Minecraft minecraft, @NotNull CloudRegistry cloudRegistry) {
        CloudItem<?> cloudItem = this.f565a.getCloudItem(cloudRegistry);
        if (cloudItem == null) {
            return;
        }
        CloudItemRarity rarity = cloudItem.getRarity();
        InterfaceC0102bS c0104bU = null;
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        int i = this.f569dE / 2;
        int i2 = this.f570dF / 2;
        int iNextInt = (-i) + threadLocalRandomCurrent.nextInt(i * 2);
        int iNextInt2 = (-i2) + threadLocalRandomCurrent.nextInt(i2 * 2);
        int i3 = this.f566cc + (this.f569dE / 2);
        int i4 = this.f568cd + (this.f570dF / 2);
        String collection = cloudItem.getCollection();
        if (rarity == CloudItemRarity.DIAMOND || rarity == CloudItemRarity.OBSIDIAN) {
            c0104bU = new C0104bU(i3 + iNextInt, i4 + iNextInt2);
        } else if (collection != null && collection.contains("Halloween")) {
            c0104bU = new C0100bQ(i3 + iNextInt, i4 + iNextInt2);
        } else if (collection != null && collection.contains("Christmas")) {
            c0104bU = new C0105bV(i3 + iNextInt, i4 + iNextInt2);
        }
        if (c0104bU != null) {
            Screen screen = minecraft.screen;
            if (screen instanceof C0143cG) {
                C0143cG c0143cG = (C0143cG) screen;
                if (Math.random() <= 0.04d) {
                    c0143cG.m790a(minecraft, c0104bU);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m349a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f) {
        m350a(minecraft, guiGraphics, font, false, i, i2, f);
    }

    /* JADX INFO: renamed from: a */
    public void m350a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, Font font, boolean z, int i, int i2, float f) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f575aN && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudRegistry cloudRegistryA = c0623lM2852b.m2855a();
        int i3 = this.f569dE / 2;
        float fM7170f = C1270xJ.m7170f(this.f566cc, this.f567dD, f);
        boolean z2 = this.f574a == minecraft.screen && m353a(i, i2) && !z;
        CloudItem<?> cloudItem = this.f565a.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        AbstractC0563jt<?> abstractC0563jtM2556a = C0564ju.m2556a(cloudItem);
        float fHashCode = (this.f565a.getUUID().hashCode() + this.f565a.getDisplayName(cloudRegistryA).hashCode()) / 100000.0f;
        int color = cloudItem.getRarity().getColor();
        PoseStack poseStackPose = guiGraphics.pose();
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        m351a(poseStackPose, guiGraphics, color, (int) fM7170f);
        abstractC0563jtM2556a.mo2303a(cloudItem, this.f565a, minecraft, guiGraphics, poseStackPose, bufferSource, (int) fM7170f, this.f568cd, this.f569dE, this.f570dF, i, i2, fM7170f, fHashCode, f);
        int i4 = 0;
        for (int i5 = 0; i5 < 16; i5++) {
            int sticker = this.f565a.getSticker(i5);
            if (sticker != -1) {
                CloudItem<?> item = cloudRegistryA.getItem(sticker);
                if (item instanceof CloudItemSticker) {
                    C0129bt.m531a(poseStackPose, guiGraphics, C0532jO.m2378d("textures/stickers/" + ((CloudItemSticker) item).getSuffixForDisplay() + ".png"), ((int) fM7170f) + 2 + (10 * i4), this.f568cd + 2, 8, 8);
                    i4++;
                }
            }
        }
        Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.WHITE);
        String name = cloudItem.getName();
        String suffix = cloudItem.getRarity() == CloudItemRarity.DEFAULT ? C0552ji.f3289aD : cloudItem.getSuffix();
        int iWidth = font.width(name);
        int iWidth2 = font.width(suffix);
        float f2 = iWidth <= this.f569dE ? 0.85f : 0.55f;
        float f3 = iWidth2 <= this.f569dE ? 0.7f : 0.5f;
        float f4 = iWidth <= this.f569dE ? -1.0f : 0.5f;
        float f5 = iWidth2 <= this.f569dE ? 0.0f : 1.0f;
        MutableComponent mutableComponentWithStyle = Component.literal(C1273xM.m7241a(name, 12)).withStyle(styleWithColor).withStyle(C0533jP.f3185b);
        if (z2) {
            mutableComponentWithStyle.withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
        }
        C0129bt.m490b(poseStackPose, font, guiGraphics, (Component) mutableComponentWithStyle, fM7170f + i3, ((this.f568cd + this.f570dF) - 15) + f4, f2);
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
        C0129bt.m493c(poseStackPose, font, guiGraphics, (Component) mutableComponentLiteral, ((int) fM7170f) + i3, ((this.f568cd + this.f570dF) - 7) + f5, f3);
        float f6 = ((fM7170f + this.f569dE) - 10.0f) + 0.5f;
        int i6 = this.f568cd + 1;
        float f7 = 0.0f;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 15.0f);
        if (this.f572aL) {
            C0129bt.m536a(poseStackPose, guiGraphics, f562V, f6, i6, 8.0f, 8.0f, 0.0f, 1.0f, color);
            f7 = 0.0f - 9.0f;
        }
        if (this.f573aM) {
            C0129bt.m536a(poseStackPose, guiGraphics, f563W, f6 + f7, i6, 8.0f, 8.0f, 0.0f, 1.0f, color);
        }
        poseStackPose.popPose();
        if (z2) {
            if (this.f571aK) {
                m352a(guiGraphics, (int) fM7170f);
            }
            CloudItemStack cloudItemStack = this.f565a;
            ObjectArrayList objectArrayList = new ObjectArrayList();
            C0560jq.m2541a(c0623lM2852b.m2855a(), minecraft, (C0396gl) c0623lM2852b.m2855a(), cloudItemStack, objectArrayList, font, C0358g.f2490g);
            if (C0495ie.f3064Q.m2230U()) {
                objectArrayList.add(Component.empty());
                objectArrayList.add(Component.literal("UUID: ").withColor(ColorReferences.COLOR_WHITE).append(Component.literal(cloudItemStack.getUUID().toString()).withStyle(ChatFormatting.GRAY)));
            }
            guiGraphics.renderTooltip(font, objectArrayList, Optional.empty(), i, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m351a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        C0129bt.m517a(guiGraphics, i2, this.f568cd + 1, this.f569dE, this.f570dF - 2, i, 0.4f);
        C0129bt.m517a(guiGraphics, i2 + 1, this.f568cd + 1, this.f569dE - 2, this.f570dF - 1, i, 0.4f);
        C0129bt.m517a(guiGraphics, i2, this.f568cd, this.f569dE, 1, i, 0.3f);
        C0129bt.m523a(guiGraphics, i2, this.f568cd + 1, this.f569dE, this.f570dF - 16, 570425344, i);
        C0129bt.m523a(guiGraphics, i2, (this.f568cd + this.f570dF) - 19, this.f569dE, 3, ColorReferences.COLOR_BLACK_TRANSPARENT, 855638016);
        C0129bt.m515a(guiGraphics, i2, (this.f568cd + this.f570dF) - 15, this.f569dE, 14, i);
        C0129bt.m515a(guiGraphics, i2, (this.f568cd + this.f570dF) - 1, this.f569dE, 1, i);
        C0129bt.m517a(guiGraphics, i2, (this.f568cd + this.f570dF) - 8, this.f569dE, 7, 0, 0.2f);
        C0129bt.m523a(guiGraphics, i2, (this.f568cd + this.f570dF) - 8, this.f569dE, 3, 1426063360, ColorReferences.COLOR_BLACK_TRANSPARENT);
        C0129bt.m517a(guiGraphics, i2 + 1, (this.f568cd + this.f570dF) - 1, this.f569dE - 2, 1, 0, 0.2f);
        C0129bt.m531a(poseStack, guiGraphics, C0143cG.f1048aS, i2 + 1, this.f568cd + 1, this.f569dE - 2, this.f570dF - 2);
    }

    /* JADX INFO: renamed from: a */
    public void m352a(@NotNull GuiGraphics guiGraphics, int i) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        int i2 = ColorReferences.COLOR_THEME_YELLOW_SOLID;
        C0129bt.m515a(guiGraphics, i - 1, this.f568cd, 1, this.f570dF, i2);
        C0129bt.m515a(guiGraphics, i + this.f569dE, this.f568cd, 1, this.f570dF, i2);
        C0129bt.m515a(guiGraphics, i - 1, this.f568cd - 1, this.f569dE + 2, 1, i2);
        C0129bt.m515a(guiGraphics, i - 1, this.f568cd + this.f570dF, this.f569dE + 2, 1, i2);
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    public boolean m353a(int i, int i2) {
        return new Rectangle(this.f566cc, this.f568cd, this.f569dE, this.f570dF).contains(i, i2);
    }

    /* JADX INFO: renamed from: d */
    public void m354d(boolean z) {
        this.f572aL = z;
    }

    /* JADX INFO: renamed from: e */
    public void m355e(boolean z) {
        this.f573aM = z;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudItemStack m356a() {
        return this.f565a;
    }
}
