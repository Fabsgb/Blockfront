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

/* JADX INFO: renamed from: com.boehmod.blockfront.ea, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ea.class */
public final class C0110ea extends AbstractC0116eg {

    @NotNull
    private static final ResourceLocation bZ = C0265jv.d("textures/gui/menu/icons/check_white.png");
    public static final float dZ = 15.0f;

    @NotNull
    private final CloudAchievement a;
    private final boolean bM;
    private float aD;
    public boolean bN = false;
    private float aE = 0.0f;

    public C0110ea(@NotNull CloudAchievement cloudAchievement, boolean z) {
        this.a = cloudAchievement;
        this.bM = z;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void n(@NotNull Minecraft minecraft) {
        this.aE = this.aD;
        this.aD = Mth.lerp(0.75f, this.aD, D() ? 1.0f : 0.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public boolean v() {
        return false;
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
        if (zD) {
            C0040bk.c(guiGraphics, this.hI, this.hJ, mo265t(), height(), ColorReferences.COLOR_WHITE_SOLID, 0.25f);
            if (!this.bN) {
                this.bN = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pq.get(), 1.0f));
            }
        } else {
            this.bN = false;
        }
        int iIntValue = this.bM ? ColorReferences.COLOR_TEAM_ALLIES_SOLID : zD ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ChatFormatting.GRAY.getColor().intValue() + ColorReferences.COLOR_BLACK_SOLID;
        MutableComponent mutableComponentWithStyle = Component.translatable(this.a.getNameKey()).withColor(iIntValue).withStyle(ChatFormatting.BOLD);
        float fE = 15.0f * C0634xm.e(this.aD, this.aE, f2);
        C0040bk.a(guiGraphics, this.hI, this.hJ + (height() - 1), mo265t(), 1, iIntValue);
        C0040bk.a(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, this.hI + 5 + fE, this.hJ + 6);
        ObjectList<String> objectListA = iH.a(font, Component.translatable(this.a.getDescriptionKey()).getString(), mo265t() - (31 + ((int) (fE * 2.0f))));
        ChatFormatting chatFormatting = zD ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY;
        int size = objectListA.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0040bk.a(poseStack, font, guiGraphics, (Component) Component.literal((String) objectListA.get(i3)).withStyle(chatFormatting), this.hI + 5 + fE, this.hJ + 18 + (10 * i3));
        }
        float fMo265t = (this.hI + mo265t()) - (height() / 2.0f);
        float fHeight = this.hJ + (height() / 2.0f);
        if (this.bM) {
            C0040bk.b(poseStack, guiGraphics, bZ, fMo265t, fHeight, 16.0f, 16.0f, 0.0f, 1.0f, iIntValue);
        }
    }
}
