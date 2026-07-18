package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dV.class */
public final class C0220dV extends AbstractC0284eg {

    /* JADX INFO: renamed from: a */
    @NotNull
    public C0423hM f1802a;

    /* JADX INFO: renamed from: aD */
    private float f1803aD;

    /* JADX INFO: renamed from: bJ */
    private boolean f1804bJ;

    public C0220dV(@NotNull C0423hM c0423hM) {
        this.f1802a = c0423hM;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo817a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, int i, int i2, int i3) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), (float) (0.800000011920929d + (0.20000000298023224d * Math.random()))));
        this.f1802a.mo1991a(minecraft, this.f2165a.m683a(), i3);
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: n */
    public void mo810n(@NotNull Minecraft minecraft) {
        this.f1802a.onUpdate();
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: v */
    public boolean mo811v() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    public int height() {
        return 40;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: t */
    public int mo812t() {
        return this.f2165a.m699t() - 15;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: R */
    public int mo1299R() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: S */
    public int mo1300S() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo800a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull C0326fV c0326fV, @NotNull Font font, int i, int i2, float f, float f2) {
        super.mo800a(poseStack, minecraft, c0622l, guiGraphics, c0326fV, font, i, i2, f, f2);
        boolean zD = m1499D();
        int iHeight = height();
        int iMo812t = mo812t();
        this.f1803aD = Mth.lerp(0.2f, this.f1803aD, zD ? 1.0f : 0.0f);
        if (zD) {
            C0119bk.m493c(guiGraphics, this.f2166hI, this.f2167hJ, iMo812t, iHeight, ColorReferences.COLOR_WHITE_SOLID, 0.1f);
            if (!this.f1804bJ) {
                this.f1804bJ = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), 1.0f));
            }
        } else {
            this.f1804bJ = false;
        }
        MutableComponent mutableComponentWithStyle = Component.translatable(this.f1802a.getName()).withColor(zD ? ColorReferences.COLOR_THEME_YELLOW_SOLID : this.f1802a.getColor()).withStyle(ChatFormatting.BOLD);
        C0119bk.m423a(guiGraphics, this.f2166hI, this.f2167hJ, iMo812t, iHeight, ColorReferences.COLOR_BLACK_TRANSPARENT, 855638016);
        float f3 = 15.0f * this.f1803aD;
        C0119bk.m368a(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, this.f2166hI + 5 + f3, this.f2167hJ + 4);
        ObjectList<String> objectListM2131a = C0471iH.m2131a(font, I18n.get(this.f1802a.m1995p(), new Object[0]), (int) ((iMo812t - 40) - f3));
        int size = objectListM2131a.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0119bk.m368a(poseStack, font, guiGraphics, (Component) Component.literal((String) objectListM2131a.get(i3)).withStyle(zD ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY), this.f2166hI + 5 + f3, this.f2167hJ + 16 + (10 * i3));
        }
        int i4 = iHeight / 2;
        this.f1802a.mo1986a(minecraft, poseStack, guiGraphics, font, this.f2166hI, this.f2167hJ, iMo812t, iHeight, (this.f2166hI + iMo812t) - i4, this.f2167hJ + i4, f, f2);
    }
}
