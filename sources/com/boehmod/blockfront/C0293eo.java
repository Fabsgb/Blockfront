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

/* JADX INFO: renamed from: com.boehmod.blockfront.eo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eo.class */
public final class C0293eo extends AbstractC0298et {

    /* JADX INFO: renamed from: bZ */
    @NotNull
    public static final ResourceLocation f2294bZ = C0532jO.m2378d("textures/gui/ribbon.png");

    /* JADX INFO: renamed from: ca */
    @NotNull
    public static final ResourceLocation f2295ca = C0532jO.m2378d("textures/gui/menu/icons/check_white.png");

    /* JADX INFO: renamed from: cb */
    @NotNull
    public static final ResourceLocation f2296cb = C0532jO.m2378d("textures/gui/menu/icons/friends.png");

    /* JADX INFO: renamed from: cc */
    @NotNull
    public static final ResourceLocation f2297cc = C0532jO.m2378d("textures/gui/cornershadow.png");

    /* JADX INFO: renamed from: cd */
    @NotNull
    public static final ResourceLocation f2298cd = C0532jO.m2378d("textures/gui/gamemode/gamemode_background.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1094tt f2299a;

    /* JADX INFO: renamed from: aI */
    private float f2300aI;

    /* JADX INFO: renamed from: aJ */
    private float f2301aJ = 0.0f;

    /* JADX INFO: renamed from: bY */
    private boolean f2302bY = false;

    public C0293eo(@NotNull C1094tt c1094tt) {
        this.f2299a = c1094tt;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: o */
    public void mo864o(@NotNull Minecraft minecraft) {
        this.f2301aJ = this.f2300aI;
        this.f2300aI = Mth.lerp(0.5f, this.f2300aI, m1615E() ? 1.0f : 0.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m1601a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C1094tt c1094tt) {
        SoundManager soundManager = minecraft.getSoundManager();
        Supplier<SoundEvent> supplierM6032a = c1094tt.m6032a();
        if (supplierM6032a != null) {
            soundManager.play(SimpleSoundInstance.forUI(supplierM6032a.get(), 1.0f));
        }
        C0570k c0570kM2885a = c0623l.m2885a();
        c0570kM2885a.m2574a(c1094tt.m6022a());
        c0570kM2885a.m2588b(minecraft, c0623l);
        minecraft.setScreen(new C0245dt());
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        super.mo854a(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
        float fM1604i = m1604i(f2);
        boolean zE = m1615E();
        int iMo866x = mo866x();
        int iHeight = height();
        int i3 = iMo866x / 2;
        if (zE) {
            if (!this.f2302bY) {
                this.f2302bY = true;
                minecraft.getNarrator().sayNow(ChatFormatting.stripFormatting(m1605a().getDisplayName().getString() + ", " + m1605a().getDescription().getString() + ". " + I18n.get("bf.container.gamemode.click", new Object[0])));
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), 1.0f));
            }
        } else {
            this.f2302bY = false;
        }
        C0129bt.m591c(guiGraphics, this.f2339iY, this.f2340iZ + 1, iMo866x, iHeight, C0129bt.m465t());
        C0129bt.m515a(guiGraphics, this.f2339iY, this.f2340iZ + 1, iMo866x, iHeight, -13750738);
        C0129bt.m533a(poseStack, guiGraphics, this.f2299a.getTexture(), this.f2339iY, this.f2340iZ + 1, iMo866x, iHeight, 0.4f + (0.2f * fM1604i));
        C0129bt.m517a(guiGraphics, this.f2339iY, this.f2340iZ + 1, iMo866x, iHeight, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.25f * fM1604i);
        C0129bt.m467a(poseStack, guiGraphics, this.f2339iY + 5, this.f2340iZ + 5, iMo866x - 10, iHeight - 10);
        C0129bt.m531a(poseStack, guiGraphics, f2297cc, this.f2339iY, this.f2340iZ + 1, iMo866x, iHeight);
        int i4 = this.f2339iY + i3;
        int i5 = this.f2340iZ + 35;
        ResourceLocation iconTexture = this.f2299a.getIconTexture();
        C0129bt.m545b(poseStack, guiGraphics, C0143cG.f1039aJ, i4, i5, 32, 32, 0.0f, 0.4f);
        C0129bt.m541b(poseStack, guiGraphics, f2298cd, i4, i5, 32, 32);
        C0129bt.m541b(poseStack, guiGraphics, iconTexture, i4, i5, 16, 16);
        int i6 = this.f2339iY + i3;
        int i7 = i5 + 8 + 13;
        List listSplit = font.split(this.f2299a.getDisplayName().copy().withStyle(C0533jP.f3185b), (int) ((mo866x() - 14) / 1.5f));
        C0129bt.m477a(poseStack, font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) listSplit, i6, i7, 14, 1.5f, false);
        C0129bt.m477a(poseStack, font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) font.split(this.f2299a.getDescription(), (int) ((mo866x() - 14) / 0.5f)), i6, i7 + 4 + (14 * listSplit.size()), 5, 0.5f, true);
        int i8 = this.f2339iY + i3;
        int iHeight2 = (this.f2340iZ + height()) - 30;
        int orDefault = C0495ie.f3016c.getOrDefault(this.f2299a.m6025at(), 0);
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.playercount", new Object[]{Component.literal(C1273xM.m7239b(orDefault)).withColor(orDefault > 0 ? ColorReferences.COLOR_TEAM_ALLIES_HOVERED : ChatFormatting.GRAY.getColor().intValue())});
        C0129bt.m541b(poseStack, guiGraphics, f2296cb, i8, iHeight2, 16, 16);
        C0129bt.m483c(font, guiGraphics, (Component) mutableComponentTranslatable, i8, iHeight2 + 10);
        if (!this.f2299a.m6027cf()) {
            int i9 = this.f2339iY + 18;
            int i10 = this.f2340iZ;
            C0129bt.m537a(poseStack, guiGraphics, f2294bZ, i9, i10, 16, 16, 0.0f, 1.0f, ColorReferences.COLOR_TEAM_ALLIES);
            C0129bt.m545b(poseStack, guiGraphics, f2295ca, i9 + 8, (i10 + 8) - 2, 16, 16, 0.0f, 1.0f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo871a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, int i, int i2, int i3) {
        if (!m1615E()) {
            super.mo871a(minecraft, c0623l, c0396gl, i, i2, i3);
        } else {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.0f));
            m1601a(minecraft, c0623l, this.f2299a);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: w */
    public boolean mo865w() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    public int height() {
        return this.f2338a.height() - 17;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: x */
    public int mo866x() {
        return 130;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: ag */
    public int mo1602ag() {
        return 5;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: ah */
    public int mo1603ah() {
        return 5;
    }

    /* JADX INFO: renamed from: i */
    public float m1604i(float f) {
        return C1270xJ.m7170f(this.f2300aI, this.f2301aJ, f);
    }

    /* JADX INFO: renamed from: a */
    public C1094tt m1605a() {
        return this.f2299a;
    }
}
