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

/* JADX INFO: renamed from: com.boehmod.blockfront.eg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eg.class */
public final class C0285eg extends AbstractC0298et {

    /* JADX INFO: renamed from: a */
    @NotNull
    public C0494id f2243a;

    /* JADX INFO: renamed from: aI */
    private float f2244aI;

    /* JADX INFO: renamed from: bQ */
    private boolean f2245bQ;

    public C0285eg(@NotNull C0494id c0494id) {
        this.f2243a = c0494id;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo871a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, int i, int i2, int i3) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), (float) (0.800000011920929d + (0.20000000298023224d * Math.random()))));
        this.f2243a.mo2222a(minecraft, this.f2338a.m358a(), i3);
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: o */
    public void mo864o(@NotNull Minecraft minecraft) {
        this.f2243a.onUpdate();
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: w */
    public boolean mo865w() {
        return true;
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
        int iHeight = height();
        int iMo866x = mo866x();
        this.f2244aI = Mth.lerp(0.2f, this.f2244aI, zE ? 1.0f : 0.0f);
        if (zE) {
            C0129bt.m593c(guiGraphics, this.f2339iY, this.f2340iZ, iMo866x, iHeight, ColorReferences.COLOR_WHITE_SOLID, 0.1f);
            if (!this.f2245bQ) {
                this.f2245bQ = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), 1.0f));
            }
        } else {
            this.f2245bQ = false;
        }
        MutableComponent mutableComponentWithStyle = Component.translatable(this.f2243a.getName()).withColor(zE ? ColorReferences.COLOR_THEME_YELLOW_SOLID : this.f2243a.getColor()).withStyle(ChatFormatting.BOLD);
        C0129bt.m523a(guiGraphics, this.f2339iY, this.f2340iZ, iMo866x, iHeight, ColorReferences.COLOR_BLACK_TRANSPARENT, 855638016);
        float f3 = 15.0f * this.f2244aI;
        C0129bt.m468a(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, this.f2339iY + 5 + f3, this.f2340iZ + 4);
        ObjectList<String> objectListM2458a = C0544ja.m2458a(font, I18n.get(this.f2243a.m2229t(), new Object[0]), (int) ((iMo866x - 40) - f3));
        int size = objectListM2458a.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0129bt.m468a(poseStack, font, guiGraphics, (Component) Component.literal((String) objectListM2458a.get(i3)).withStyle(zE ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY), this.f2339iY + 5 + f3, this.f2340iZ + 16 + (10 * i3));
        }
        int i4 = iHeight / 2;
        this.f2243a.mo2017a(minecraft, poseStack, guiGraphics, font, this.f2339iY, this.f2340iZ, iMo866x, iHeight, (this.f2339iY + iMo866x) - i4, this.f2340iZ + i4, f, f2);
    }
}
