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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dV.class */
public final class dV extends AbstractC0116eg {

    @NotNull
    public hM a;
    private float aD;
    private boolean bJ;

    public dV(@NotNull hM hMVar) {
        this.a = hMVar;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, int i, int i2, int i3) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), (float) (0.800000011920929d + (0.20000000298023224d * Math.random()))));
        this.a.a(minecraft, this.a.a(), i3);
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void n(@NotNull Minecraft minecraft) {
        this.a.onUpdate();
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public boolean v() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int height() {
        return 40;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    /* JADX INFO: renamed from: t */
    public int mo265t() {
        return this.a.t() - 15;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int R() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int S() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull fV fVVar, @NotNull Font font, int i, int i2, float f, float f2) {
        super.a(poseStack, minecraft, c0297l, guiGraphics, fVVar, font, i, i2, f, f2);
        boolean zD = D();
        int iHeight = height();
        int iMo265t = mo265t();
        this.aD = Mth.lerp(0.2f, this.aD, zD ? 1.0f : 0.0f);
        if (zD) {
            C0040bk.c(guiGraphics, this.hI, this.hJ, iMo265t, iHeight, ColorReferences.COLOR_WHITE_SOLID, 0.1f);
            if (!this.bJ) {
                this.bJ = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pq.get(), 1.0f));
            }
        } else {
            this.bJ = false;
        }
        MutableComponent mutableComponentWithStyle = Component.translatable(this.a.getName()).withColor(zD ? ColorReferences.COLOR_THEME_YELLOW_SOLID : this.a.getColor()).withStyle(ChatFormatting.BOLD);
        C0040bk.a(guiGraphics, this.hI, this.hJ, iMo265t, iHeight, ColorReferences.COLOR_BLACK_TRANSPARENT, 855638016);
        float f3 = 15.0f * this.aD;
        C0040bk.a(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, this.hI + 5 + f3, this.hJ + 4);
        ObjectList<String> objectListA = iH.a(font, I18n.get(this.a.p(), new Object[0]), (int) ((iMo265t - 40) - f3));
        int size = objectListA.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0040bk.a(poseStack, font, guiGraphics, (Component) Component.literal((String) objectListA.get(i3)).withStyle(zD ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY), this.hI + 5 + f3, this.hJ + 16 + (10 * i3));
        }
        int i4 = iHeight / 2;
        this.a.a(minecraft, poseStack, guiGraphics, font, this.hI, this.hJ, iMo265t, iHeight, (this.hI + iMo265t) - i4, this.hJ + i4, f, f2);
    }
}
