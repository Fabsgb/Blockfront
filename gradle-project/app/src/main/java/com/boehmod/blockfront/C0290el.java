package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.el */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/el.class */
public final class C0290el extends AbstractC0298et {

    /* JADX INFO: renamed from: bX */
    @NotNull
    private static final ResourceLocation f2273bX = C0532jO.m2378d("textures/gui/menu/icons/check_white.png");

    /* JADX INFO: renamed from: ec */
    public static final float f2274ec = 15.0f;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final CloudAchievement f2275a;

    /* JADX INFO: renamed from: bT */
    private final boolean f2276bT;

    /* JADX INFO: renamed from: aI */
    private float f2278aI;

    /* JADX INFO: renamed from: bU */
    public boolean f2277bU = false;

    /* JADX INFO: renamed from: aJ */
    private float f2279aJ = 0.0f;

    public C0290el(@NotNull CloudAchievement cloudAchievement, boolean z) {
        this.f2275a = cloudAchievement;
        this.f2276bT = z;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: o */
    public void mo864o(@NotNull Minecraft minecraft) {
        this.f2279aJ = this.f2278aI;
        this.f2278aI = Mth.lerp(0.75f, this.f2278aI, m1615E() ? 1.0f : 0.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: w */
    public boolean mo865w() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    public int height() {
        return 40;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: x */
    public int mo866x() {
        return this.f2338a.m374x() - 15;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: ab */
    public int mo1561ab() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: U */
    public int mo1248U() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        super.mo854a(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
        boolean zE = m1615E();
        if (zE) {
            C0129bt.m593c(guiGraphics, this.f2339iY, this.f2340iZ, mo866x(), height(), ColorReferences.COLOR_WHITE_SOLID, 0.25f);
            if (!this.f2277bU) {
                this.f2277bU = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), 1.0f));
            }
        } else {
            this.f2277bU = false;
        }
        int iIntValue = this.f2276bT ? ColorReferences.COLOR_TEAM_ALLIES_SOLID : zE ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ChatFormatting.GRAY.getColor().intValue() + ColorReferences.COLOR_BLACK_SOLID;
        MutableComponent mutableComponentWithStyle = Component.translatable(this.f2275a.getNameKey()).withColor(iIntValue).withStyle(ChatFormatting.BOLD);
        float fM7170f = 15.0f * C1270xJ.m7170f(this.f2278aI, this.f2279aJ, f2);
        C0129bt.m515a(guiGraphics, this.f2339iY, this.f2340iZ + (height() - 1), mo866x(), 1, iIntValue);
        C0129bt.m468a(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, this.f2339iY + 5 + fM7170f, this.f2340iZ + 6);
        ObjectList<String> objectListM2458a = C0544ja.m2458a(font, Component.translatable(this.f2275a.getDescriptionKey()).getString(), mo866x() - (31 + ((int) (fM7170f * 2.0f))));
        ChatFormatting chatFormatting = zE ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY;
        int size = objectListM2458a.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0129bt.m468a(poseStack, font, guiGraphics, (Component) Component.literal((String) objectListM2458a.get(i3)).withStyle(chatFormatting), this.f2339iY + 5 + fM7170f, this.f2340iZ + 18 + (10 * i3));
        }
        float fMo866x = (this.f2339iY + mo866x()) - (height() / 2.0f);
        float fHeight = this.f2340iZ + (height() / 2.0f);
        if (this.f2276bT) {
            C0129bt.m546b(poseStack, guiGraphics, f2273bX, fMo866x, fHeight, 16.0f, 16.0f, 0.0f, 1.0f, iIntValue);
        }
    }
}
