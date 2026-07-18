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

/* JADX INFO: renamed from: com.boehmod.blockfront.ea */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ea.class */
public final class C0278ea extends AbstractC0284eg {

    /* JADX INFO: renamed from: bZ */
    @NotNull
    private static final ResourceLocation f2115bZ = C0564jv.m2555d("textures/gui/menu/icons/check_white.png");

    /* JADX INFO: renamed from: dZ */
    public static final float f2116dZ = 15.0f;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final CloudAchievement f2117a;

    /* JADX INFO: renamed from: bM */
    private final boolean f2118bM;

    /* JADX INFO: renamed from: aD */
    private float f2120aD;

    /* JADX INFO: renamed from: bN */
    public boolean f2119bN = false;

    /* JADX INFO: renamed from: aE */
    private float f2121aE = 0.0f;

    public C0278ea(@NotNull CloudAchievement cloudAchievement, boolean z) {
        this.f2117a = cloudAchievement;
        this.f2118bM = z;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: n */
    public void mo810n(@NotNull Minecraft minecraft) {
        this.f2121aE = this.f2120aD;
        this.f2120aD = Mth.lerp(0.75f, this.f2120aD, m1499D() ? 1.0f : 0.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: v */
    public boolean mo811v() {
        return false;
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
        if (zD) {
            C0119bk.m493c(guiGraphics, this.f2166hI, this.f2167hJ, mo812t(), height(), ColorReferences.COLOR_WHITE_SOLID, 0.25f);
            if (!this.f2119bN) {
                this.f2119bN = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), 1.0f));
            }
        } else {
            this.f2119bN = false;
        }
        int iIntValue = this.f2118bM ? ColorReferences.COLOR_TEAM_ALLIES_SOLID : zD ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ChatFormatting.GRAY.getColor().intValue() + ColorReferences.COLOR_BLACK_SOLID;
        MutableComponent mutableComponentWithStyle = Component.translatable(this.f2117a.getNameKey()).withColor(iIntValue).withStyle(ChatFormatting.BOLD);
        float fM7843e = 15.0f * C1290xm.m7843e(this.f2120aD, this.f2121aE, f2);
        C0119bk.m415a(guiGraphics, this.f2166hI, this.f2167hJ + (height() - 1), mo812t(), 1, iIntValue);
        C0119bk.m368a(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, this.f2166hI + 5 + fM7843e, this.f2167hJ + 6);
        ObjectList<String> objectListM2131a = C0471iH.m2131a(font, Component.translatable(this.f2117a.getDescriptionKey()).getString(), mo812t() - (31 + ((int) (fM7843e * 2.0f))));
        ChatFormatting chatFormatting = zD ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY;
        int size = objectListM2131a.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0119bk.m368a(poseStack, font, guiGraphics, (Component) Component.literal((String) objectListM2131a.get(i3)).withStyle(chatFormatting), this.f2166hI + 5 + fM7843e, this.f2167hJ + 18 + (10 * i3));
        }
        float fMo812t = (this.f2166hI + mo812t()) - (height() / 2.0f);
        float fHeight = this.f2167hJ + (height() / 2.0f);
        if (this.f2118bM) {
            C0119bk.m446b(poseStack, guiGraphics, f2115bZ, fMo812t, fHeight, 16.0f, 16.0f, 0.0f, 1.0f, iIntValue);
        }
    }
}
