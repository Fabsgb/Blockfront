package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.news.NewsArticleSummary;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.er */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/er.class */
public final class C0296er extends AbstractC0298et {

    /* JADX INFO: renamed from: iT */
    private static final int f2319iT = 46;

    /* JADX INFO: renamed from: iU */
    private static final int f2320iU = 72;

    /* JADX INFO: renamed from: iV */
    private static final int f2321iV = 40;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final SimpleDateFormat f2322b = new SimpleDateFormat("MMM d, yyyy", Locale.ROOT);

    /* JADX INFO: renamed from: cf */
    @NotNull
    private static final ResourceLocation f2323cf = C0532jO.m2378d("textures/gui/loading.png");

    /* JADX INFO: renamed from: hw */
    @NotNull
    private static final Component f2324hw = Component.translatable("bf.menu.news.unread").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: b */
    @NotNull
    private final NewsArticleSummary f2325b;

    /* JADX INFO: renamed from: bU */
    private boolean f2326bU = false;

    public C0296er(@NotNull NewsArticleSummary newsArticleSummary) {
        this.f2325b = newsArticleSummary;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: o */
    public void mo864o(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: w */
    public boolean mo865w() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        super.mo854a(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
        boolean zE = m1615E();
        int iM465t = C0129bt.m465t();
        if (zE) {
            if (!this.f2326bU) {
                this.f2326bU = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), 1.0f));
            }
        } else {
            this.f2326bU = false;
        }
        int iMo866x = mo866x() - 15;
        C0129bt.m593c(guiGraphics, this.f2339iY + 1, this.f2340iZ + 1, iMo866x - 2, 44, iM465t, 0.5f);
        int i3 = this.f2339iY + 3;
        int i4 = this.f2340iZ + 3;
        C0129bt.m591c(guiGraphics, i3, i4, f2320iU, 40, iM465t);
        C0276eX.a aVarM1534a = c0623l.m2863a().m1534a(this.f2325b.m0id());
        if (aVarM1534a == null) {
            C0129bt.m531a(poseStack, guiGraphics, f2323cf, (i3 + 36) - 8, (i4 + 20) - 8, 16, 16);
        } else if (aVarM1534a.m1540j() != null) {
            float fMin = Math.min(72.0f / aVarM1534a.m1541x(), 40.0f / aVarM1534a.height());
            int iMax = Math.max(1, Math.round(aVarM1534a.m1541x() * fMin));
            int iMax2 = Math.max(1, Math.round(aVarM1534a.height() * fMin));
            int i5 = i3 + ((f2320iU - iMax) / 2);
            int i6 = i4 + ((40 - iMax2) / 2);
            C0129bt.m593c(guiGraphics, i5, i6, iMax, iMax2, 0, 0.4f);
            C0129bt.m531a(poseStack, guiGraphics, aVarM1534a.m1540j(), i5, i6, iMax, iMax2);
        }
        int i7 = this.f2339iY + f2320iU + 6;
        int i8 = (iMo866x - f2320iU) - 10;
        C0129bt.m479b(font, guiGraphics, (Component) Component.literal(font.plainSubstrByWidth(this.f2325b.title(), i8)).withStyle(ChatFormatting.BOLD).withColor(zE ? ColorReferences.COLOR_THEME_YELLOW : ColorReferences.COLOR_WHITE), i7, this.f2340iZ + 4);
        C0129bt.m489b(poseStack, font, guiGraphics, (Component) Component.translatable("bf.menu.news.byline", new Object[]{Component.literal(this.f2325b.author()).withColor(ColorReferences.COLOR_STOPWATCH), Component.literal(f2322b.format(new Date(this.f2325b.timestamp()))).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY), i7, this.f2340iZ + 15.0f, ColorReferences.COLOR_WHITE, 0.5f);
        ObjectList<String> objectListM2458a = C0544ja.m2458a(font, this.f2325b.snippet(), i8 * 2);
        int iMin = Math.min(3, objectListM2458a.size());
        for (int i9 = 0; i9 < iMin; i9++) {
            C0129bt.m489b(poseStack, font, guiGraphics, (Component) Component.literal((String) objectListM2458a.get(i9)).withStyle(ChatFormatting.GRAY), i7, this.f2340iZ + 24.0f + (6 * i9), ColorReferences.COLOR_WHITE, 0.5f);
        }
        if (!c0623l.m2863a().m1531a(this.f2325b.m0id())) {
            int i10 = ((this.f2339iY + iMo866x) - 16) - 6;
            C0129bt.m537a(poseStack, guiGraphics, C0532jO.m2378d("textures/gui/ribbon.png"), i10, this.f2340iZ + 2, 16, 16, 0.0f, 1.0f, ColorReferences.COLOR_TEAM_ALLIES_SOLID);
            C0129bt.m492c(poseStack, font, guiGraphics, f2324hw, i10 + 8, this.f2340iZ + 4.0f, ColorReferences.COLOR_WHITE, 0.65f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo871a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, int i, int i2, int i3) {
        super.mo871a(minecraft, c0623l, c0396gl, i, i2, i3);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), (float) (0.800000011920929d + (0.20000000298023224d * Math.random()))));
        minecraft.setScreen(new C0209dJ(minecraft.screen, this.f2325b));
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    public int height() {
        return f2319iT;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: x */
    public int mo866x() {
        return this.f2338a.m374x();
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: U */
    public int mo1248U() {
        return 2;
    }
}
