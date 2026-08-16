package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cI.class */
public class C0145cI extends C0143cG {

    /* JADX INFO: renamed from: eT */
    public static final int f1060eT = -3223881;

    /* JADX INFO: renamed from: eU */
    public static final int f1061eU = -601527;

    /* JADX INFO: renamed from: eV */
    public static final int f1064eV = 100;

    /* JADX INFO: renamed from: eW */
    public static final int f1065eW = 15;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Screen f1067d;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0085bB f1068b;

    /* JADX INFO: renamed from: eX */
    private int f1069eX;

    /* JADX INFO: renamed from: dH */
    private float f1070dH;

    /* JADX INFO: renamed from: dI */
    private float f1071dI;

    /* JADX INFO: renamed from: dJ */
    private float f1072dJ;

    /* JADX INFO: renamed from: dK */
    private float f1073dK;

    /* JADX INFO: renamed from: dL */
    private float f1074dL;

    /* JADX INFO: renamed from: bm */
    @NotNull
    private static final Component f1062bm = Component.translatable("bf.rankup.title").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bn */
    @NotNull
    private static final Component f1063bn = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: bb */
    public static boolean f1066bb = false;

    public C0145cI(@NotNull Screen screen) {
        super(f1062bm, f1062bm);
        this.f1069eX = 40;
        this.f1071dI = 0.0f;
        this.f1072dJ = 0.0f;
        this.f1073dK = 0.0f;
        this.f1074dL = 0.0f;
        this.f1067d = screen;
        this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7957pe.get(), 1.0f, 1.0f));
    }

    /* JADX INFO: renamed from: P */
    public void m797P() {
        m798Q();
        this.f1058a.setScreen(this.f1067d);
    }

    /* JADX INFO: renamed from: Q */
    private void m798Q() {
        this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7966pn.get(), 1.25f, 1.0f));
    }

    public void removed() {
        super.removed();
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        int i = this.f1069eX;
        this.f1069eX = i - 1;
        if (i <= 0 && this.f1068b != null) {
            this.f1068b.visible = true;
        }
        this.f1071dI = this.f1070dH;
        this.f1070dH = Mth.lerp(0.1f, this.f1070dH, 1.0f);
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        this.f1067d.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        float fM466g = C0129bt.m466g();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        float fSin = 1.0f + (Mth.sin(fM466g / 40.0f) / 5.0f);
        this.f1072dJ = Mth.lerp(0.1f, this.f1072dJ, fSin);
        this.f1073dK = Mth.lerp(0.08f, this.f1073dK, fSin);
        this.f1074dL = Mth.lerp(0.06f, this.f1074dL, fSin);
        float fM7170f = C1270xJ.m7170f(this.f1070dH, this.f1071dI, f);
        PlayerRank rank = this.f1056a.m1886a(this.f1058a).getRank();
        int i3 = (this.height / 2) - 20;
        int i4 = this.width / 2;
        float f2 = (this.height / 2.0f) * fM7170f;
        C0129bt.m517a(guiGraphics, 0, 0, this.width, this.height, 0, 0.75f * fM7170f);
        C0129bt.m533a(poseStackPose, guiGraphics, f1043aN, 0, 0, this.width, this.height, fM7170f);
        float f3 = 80.0f * this.f1074dL;
        float f4 = f2 + 10.0f;
        C0129bt.m546b(poseStackPose, guiGraphics, f1040aK, i4, f4, 320.0f, 320.0f, fM466g / 3.0f, this.f1072dJ * this.f1070dH, f1060eT);
        C0129bt.m546b(poseStackPose, guiGraphics, f1042aM, i4, f4, 250.0f, 250.0f, -(fM466g / 4.0f), (this.f1072dJ / 2.0f) * this.f1070dH, f1060eT);
        C0129bt.m544b(poseStackPose, guiGraphics, f1039aJ, i4, f4, 150.0f, 150.0f, fM466g / 3.0f, this.f1072dJ * this.f1070dH);
        C0129bt.m544b(poseStackPose, guiGraphics, f1039aJ, i4, f4, 150.0f, 150.0f, fM466g / 3.0f, this.f1072dJ * this.f1070dH);
        ResourceLocation resourceLocationM2378d = C0532jO.m2378d("textures/misc/ranks/" + rank.getTexture() + ".png");
        float fSin2 = Mth.sin(fM466g / 35.0f);
        float fSin3 = Mth.sin((fM466g + 30.0f) / 35.0f);
        float fSin4 = 1.0f + Mth.sin(fM466g / 55.0f);
        float f5 = 5.0f * fSin2;
        float f6 = 5.0f * fSin3;
        float f7 = f3 + (10.0f * fSin4);
        C0129bt.m544b(poseStackPose, guiGraphics, f1044aO, i4, f4, f7, f7, f5, this.f1074dL * this.f1070dH);
        C0129bt.m544b(poseStackPose, guiGraphics, resourceLocationM2378d, i4, f4, f7, f7, f6, this.f1074dL * this.f1070dH);
        if (this.f1069eX <= 0) {
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.rankup.message", new Object[]{Component.literal(rank.getTitle()).withColor(f1061eU)}).withColor(f1060eT).withStyle(ChatFormatting.BOLD);
            C0129bt.m491b(poseStackPose, this.font, guiGraphics, f1062bm, i4, i3 - 75, 2.5f);
            C0129bt.m482c(poseStackPose, this.font, guiGraphics, (Component) mutableComponentWithStyle, i4, i3 - 50);
        }
        for (C0085bB c0085bB : this.renderables) {
            if (c0085bB instanceof C0085bB) {
                c0085bB.render(guiGraphics, i, i2, f);
            }
        }
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        this.f1068b = addRenderableWidget(new C0085bB((this.width / 2) - 50, this.height - 30, 100, 15, f1063bn, button -> {
            m797P();
        }).m328a(C0085bB.a.SHADOW).m335e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m341f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m314a(C0085bB.c.SHADOW).m324a(0.0f, 1.5f));
        this.f1068b.visible = false;
    }
}
