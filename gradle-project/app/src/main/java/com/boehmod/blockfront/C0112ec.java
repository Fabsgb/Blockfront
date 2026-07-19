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

/* JADX INFO: renamed from: com.boehmod.blockfront.ec, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ec.class */
public final class C0112ec extends AbstractC0116eg {

    @NotNull
    public static final ResourceLocation cb = C0265jv.d("textures/gui/gamemode/ribbon.png");

    @NotNull
    public static final ResourceLocation cc = C0265jv.d("textures/gui/menu/icons/check_white.png");

    @NotNull
    public static final ResourceLocation cd = C0265jv.d("textures/gui/menu/icons/friends.png");

    @NotNull
    public static final ResourceLocation ce = C0265jv.d("textures/gui/cornershadow.png");

    @NotNull
    public static final ResourceLocation cf = C0265jv.d("textures/gui/gamemode/gamemode_background.png");

    @NotNull
    private final sW a;
    private float aD;
    private float aE = 0.0f;
    private boolean bP = false;

    public C0112ec(@NotNull sW sWVar) {
        this.a = sWVar;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void n(@NotNull Minecraft minecraft) {
        this.aE = this.aD;
        this.aD = Mth.lerp(0.5f, this.aD, D() ? 1.0f : 0.0f);
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull sW sWVar) {
        SoundManager soundManager = minecraft.getSoundManager();
        Supplier<SoundEvent> supplierM1096a = sWVar.m1096a();
        if (supplierM1096a != null) {
            soundManager.play(SimpleSoundInstance.forUI(supplierM1096a.get(), 1.0f));
        }
        C0270k c0270kM596a = c0297l.m596a();
        c0270kM596a.a(sWVar.a());
        c0270kM596a.b(minecraft, c0297l);
        minecraft.setScreen(new C0094dk());
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull fV fVVar, @NotNull Font font, int i, int i2, float f, float f2) {
        super.a(poseStack, minecraft, c0297l, guiGraphics, fVVar, font, i, i2, f, f2);
        float fJ = j(f2);
        boolean zD = D();
        int iMo265t = mo265t();
        int iHeight = height();
        int i3 = iMo265t / 2;
        if (zD) {
            if (!this.bP) {
                this.bP = true;
                minecraft.getNarrator().sayNow(ChatFormatting.stripFormatting(a().getDisplayName().getString() + ", " + a().getDescription().getString() + ". " + I18n.get("bf.container.gamemode.click", new Object[0])));
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pq.get(), 1.0f));
            }
        } else {
            this.bP = false;
        }
        C0040bk.c(guiGraphics, this.hI, this.hJ + 1, iMo265t, iHeight, C0040bk.p());
        C0040bk.a(guiGraphics, this.hI, this.hJ + 1, iMo265t, iHeight, -13750738);
        C0040bk.a(poseStack, guiGraphics, this.a.getTexture(), this.hI, this.hJ + 1, iMo265t, iHeight, 0.4f + (0.2f * fJ));
        C0040bk.a(guiGraphics, this.hI, this.hJ + 1, iMo265t, iHeight, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.25f * fJ);
        C0040bk.a(poseStack, guiGraphics, this.hI + 5, this.hJ + 5, iMo265t - 10, iHeight - 10);
        C0040bk.a(poseStack, guiGraphics, ce, this.hI, this.hJ + 1, iMo265t, iHeight);
        int i4 = this.hI + i3;
        int i5 = this.hJ + 35;
        ResourceLocation iconTexture = this.a.getIconTexture();
        C0040bk.b(poseStack, guiGraphics, C0080cx.aJ, i4, i5, 32, 32, 0.0f, 0.4f);
        C0040bk.b(poseStack, guiGraphics, cf, i4, i5, 32, 32);
        C0040bk.b(poseStack, guiGraphics, iconTexture, i4, i5, 16, 16);
        int i6 = this.hI + i3;
        C0040bk.a(poseStack, font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) font.split(this.a.getDisplayName().copy().withStyle(C0266jw.b), (int) ((mo265t() - 14) / 1.5f)), i6, i5 + 8 + 13, 14, 1.5f, false);
        C0040bk.a(poseStack, font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) font.split(this.a.getDescription(), (int) ((mo265t() - 14) / 0.5f)), i6, r0 + 4 + (14 * r0.size()), 5, 0.5f, true);
        int i7 = this.hI + i3;
        int iHeight2 = (this.hJ + height()) - 30;
        int orDefault = hN.c.getOrDefault(this.a.am(), 0);
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.playercount", new Object[]{Component.literal(C0637xp.a(orDefault)).withColor(orDefault > 0 ? ColorReferences.COLOR_TEAM_ALLIES_HOVERED : ChatFormatting.GRAY.getColor().intValue())});
        C0040bk.b(poseStack, guiGraphics, cd, i7, iHeight2, 16, 16);
        C0040bk.c(font, guiGraphics, (Component) mutableComponentTranslatable, i7, iHeight2 + 10);
        if (!this.a.bV()) {
            int i8 = this.hI + 18;
            int i9 = this.hJ;
            C0040bk.a(poseStack, guiGraphics, cb, i8, i9, 16, 16, 0.0f, 1.0f, ColorReferences.COLOR_TEAM_ALLIES);
            C0040bk.b(poseStack, guiGraphics, cc, i8 + 8, (i9 + 8) - 2, 16, 16, 0.0f, 1.0f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, int i, int i2, int i3) {
        if (!D()) {
            super.a(minecraft, c0297l, fVVar, i, i2, i3);
        } else {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.0f));
            a(minecraft, c0297l, this.a);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public boolean v() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int height() {
        return this.a.height() - 17;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    /* JADX INFO: renamed from: t */
    public int mo265t() {
        return 130;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int W() {
        return 5;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int X() {
        return 5;
    }

    public float j(float f) {
        return C0634xm.e(this.aD, this.aE, f);
    }

    public sW a() {
        return this.a;
    }
}
