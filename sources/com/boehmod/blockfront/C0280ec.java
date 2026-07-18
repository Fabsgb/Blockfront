package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ec */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ec.class */
public final class C0280ec extends AbstractC0284eg {

    /* JADX INFO: renamed from: cb */
    @NotNull
    public static final ResourceLocation f2129cb = C0564jv.m2555d("textures/gui/gamemode/ribbon.png");

    /* JADX INFO: renamed from: cc */
    @NotNull
    public static final ResourceLocation f2130cc = C0564jv.m2555d("textures/gui/menu/icons/check_white.png");

    /* JADX INFO: renamed from: cd */
    @NotNull
    public static final ResourceLocation f2131cd = C0564jv.m2555d("textures/gui/menu/icons/friends.png");

    /* JADX INFO: renamed from: ce */
    @NotNull
    public static final ResourceLocation f2132ce = C0564jv.m2555d("textures/gui/cornershadow.png");

    /* JADX INFO: renamed from: cf */
    @NotNull
    public static final ResourceLocation f2133cf = C0564jv.m2555d("textures/gui/gamemode/gamemode_background.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1016sW f2134a;

    /* JADX INFO: renamed from: aD */
    private float f2135aD;

    /* JADX INFO: renamed from: aE */
    private float f2136aE = 0.0f;

    /* JADX INFO: renamed from: bP */
    private boolean f2137bP = false;

    public C0280ec(@NotNull C1016sW c1016sW) {
        this.f2134a = c1016sW;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: n */
    public void mo810n(@NotNull Minecraft minecraft) {
        this.f2136aE = this.f2135aD;
        this.f2135aD = Mth.lerp(0.5f, this.f2135aD, m1499D() ? 1.0f : 0.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m1485a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C1016sW c1016sW) {
        SoundManager soundManager = minecraft.getSoundManager();
        Supplier<SoundEvent> supplierM5544a = c1016sW.m5544a();
        if (supplierM5544a != null) {
            soundManager.play(SimpleSoundInstance.forUI(supplierM5544a.get(), 1.0f));
        }
        C0569k c0569kM2699a = c0622l.m2699a();
        c0569kM2699a.m2585a(c1016sW.m5534a());
        c0569kM2699a.m2599b(minecraft, c0622l);
        minecraft.setScreen(new C0235dk());
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo800a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull C0326fV c0326fV, @NotNull Font font, int i, int i2, float f, float f2) {
        super.mo800a(poseStack, minecraft, c0622l, guiGraphics, c0326fV, font, i, i2, f, f2);
        float fM1488j = m1488j(f2);
        boolean zD = m1499D();
        int iMo812t = mo812t();
        int iHeight = height();
        int i3 = iMo812t / 2;
        if (zD) {
            if (!this.f2137bP) {
                this.f2137bP = true;
                minecraft.getNarrator().sayNow(ChatFormatting.stripFormatting(m1489a().getDisplayName().getString() + ", " + m1489a().getDescription().getString() + ". " + I18n.get("bf.container.gamemode.click", new Object[0])));
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), 1.0f));
            }
        } else {
            this.f2137bP = false;
        }
        C0119bk.m491c(guiGraphics, this.f2166hI, this.f2167hJ + 1, iMo812t, iHeight, C0119bk.m365p());
        C0119bk.m415a(guiGraphics, this.f2166hI, this.f2167hJ + 1, iMo812t, iHeight, -13750738);
        C0119bk.m433a(poseStack, guiGraphics, this.f2134a.getTexture(), this.f2166hI, this.f2167hJ + 1, iMo812t, iHeight, 0.4f + (0.2f * fM1488j));
        C0119bk.m417a(guiGraphics, this.f2166hI, this.f2167hJ + 1, iMo812t, iHeight, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.25f * fM1488j);
        C0119bk.m367a(poseStack, guiGraphics, this.f2166hI + 5, this.f2167hJ + 5, iMo812t - 10, iHeight - 10);
        C0119bk.m431a(poseStack, guiGraphics, f2132ce, this.f2166hI, this.f2167hJ + 1, iMo812t, iHeight);
        int i4 = this.f2166hI + i3;
        int i5 = this.f2167hJ + 35;
        ResourceLocation iconTexture = this.f2134a.getIconTexture();
        C0119bk.m445b(poseStack, guiGraphics, C0195cx.f1566aJ, i4, i5, 32, 32, 0.0f, 0.4f);
        C0119bk.m441b(poseStack, guiGraphics, f2133cf, i4, i5, 32, 32);
        C0119bk.m441b(poseStack, guiGraphics, iconTexture, i4, i5, 16, 16);
        int i6 = this.f2166hI + i3;
        C0119bk.m377a(poseStack, font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) font.split(this.f2134a.getDisplayName().copy().withStyle(C0565jw.f3201b), (int) ((mo812t() - 14) / 1.5f)), i6, i5 + 8 + 13, 14, 1.5f, false);
        C0119bk.m377a(poseStack, font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) font.split(this.f2134a.getDescription(), (int) ((mo812t() - 14) / 0.5f)), i6, r0 + 4 + (14 * r0.size()), 5, 0.5f, true);
        int i7 = this.f2166hI + i3;
        int iHeight2 = (this.f2167hJ + height()) - 30;
        int orDefault = C0424hN.f2715c.getOrDefault(this.f2134a.m5537am(), 0);
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.playercount", new Object[]{Component.literal(C1293xp.m7912a(orDefault)).withColor(orDefault > 0 ? ColorReferences.COLOR_TEAM_ALLIES_HOVERED : ChatFormatting.GRAY.getColor().intValue())});
        C0119bk.m441b(poseStack, guiGraphics, f2131cd, i7, iHeight2, 16, 16);
        C0119bk.m383c(font, guiGraphics, (Component) mutableComponentTranslatable, i7, iHeight2 + 10);
        if (!this.f2134a.m5539bV()) {
            int i8 = this.f2166hI + 18;
            int i9 = this.f2167hJ;
            C0119bk.m437a(poseStack, guiGraphics, f2129cb, i8, i9, 16, 16, 0.0f, 1.0f, ColorReferences.COLOR_TEAM_ALLIES);
            C0119bk.m445b(poseStack, guiGraphics, f2130cc, i8 + 8, (i9 + 8) - 2, 16, 16, 0.0f, 1.0f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo817a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, int i, int i2, int i3) {
        if (!m1499D()) {
            super.mo817a(minecraft, c0622l, c0326fV, i, i2, i3);
        } else {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.0f));
            m1485a(minecraft, c0622l, this.f2134a);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: v */
    public boolean mo811v() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    public int height() {
        return this.f2165a.height() - 17;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: t */
    public int mo812t() {
        return 130;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: W */
    public int mo1486W() {
        return 5;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: X */
    public int mo1487X() {
        return 5;
    }

    /* JADX INFO: renamed from: j */
    public float m1488j(float f) {
        return C1290xm.m7843e(this.f2135aD, this.f2136aE, f);
    }

    /* JADX INFO: renamed from: a */
    public C1016sW m1489a() {
        return this.f2134a;
    }
}
