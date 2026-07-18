package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cz.class */
public class C0197cz extends C0195cx {

    /* JADX INFO: renamed from: dT */
    public static final int f1589dT = -3223881;

    /* JADX INFO: renamed from: dU */
    public static final int f1590dU = -601527;

    /* JADX INFO: renamed from: dV */
    public static final int f1593dV = 100;

    /* JADX INFO: renamed from: dW */
    public static final int f1594dW = 15;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final Screen f1596e;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0127bs f1597b;

    /* JADX INFO: renamed from: dX */
    private int f1598dX;

    /* JADX INFO: renamed from: dE */
    private float f1599dE;

    /* JADX INFO: renamed from: dF */
    private float f1600dF;

    /* JADX INFO: renamed from: dG */
    private float f1601dG;

    /* JADX INFO: renamed from: dH */
    private float f1602dH;

    /* JADX INFO: renamed from: dI */
    private float f1603dI;

    /* JADX INFO: renamed from: bk */
    @NotNull
    private static final Component f1591bk = Component.translatable("bf.rankup.title").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bl */
    @NotNull
    private static final Component f1592bl = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: aX */
    public static boolean f1595aX = false;

    public C0197cz(@NotNull Screen screen) {
        super(f1591bk, f1591bk);
        this.f1598dX = 40;
        this.f1600dF = 0.0f;
        this.f1601dG = 0.0f;
        this.f1602dH = 0.0f;
        this.f1603dI = 0.0f;
        this.f1596e = screen;
        this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7545pc.get(), 1.0f, 1.0f));
    }

    /* JADX INFO: renamed from: L */
    public void m1198L() {
        m1199M();
        this.f1587b.setScreen(this.f1596e);
    }

    /* JADX INFO: renamed from: M */
    private void m1199M() {
        this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7554pl.get(), 1.25f, 1.0f));
    }

    public void removed() {
        super.removed();
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        int i = this.f1598dX;
        this.f1598dX = i - 1;
        if (i <= 0 && this.f1597b != null) {
            this.f1597b.visible = true;
        }
        this.f1600dF = this.f1599dE;
        this.f1599dE = Mth.lerp(0.1f, this.f1599dE, 1.0f);
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        this.f1596e.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        float fM366g = C0119bk.m366g();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        float fSin = 1.0f + (Mth.sin(fM366g / 40.0f) / 5.0f);
        this.f1601dG = Mth.lerp(0.1f, this.f1601dG, fSin);
        this.f1602dH = Mth.lerp(0.08f, this.f1602dH, fSin);
        this.f1603dI = Mth.lerp(0.06f, this.f1603dI, fSin);
        float fM7843e = C1290xm.m7843e(this.f1599dE, this.f1600dF, f);
        PlayerRank rank = this.f1585a.m1676a(this.f1587b).getRank();
        int i3 = (this.height / 2) - 20;
        int i4 = this.width / 2;
        float f2 = (this.height / 2.0f) * fM7843e;
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, 0, 0.75f * fM7843e);
        C0119bk.m433a(poseStackPose, guiGraphics, f1570aN, 0, 0, this.width, this.height, fM7843e);
        float f3 = 80.0f * this.f1603dI;
        float f4 = f2 + 10.0f;
        C0119bk.m446b(poseStackPose, guiGraphics, f1567aK, i4, f4, 320.0f, 320.0f, fM366g / 3.0f, this.f1601dG * this.f1599dE, f1589dT);
        C0119bk.m446b(poseStackPose, guiGraphics, f1569aM, i4, f4, 250.0f, 250.0f, -(fM366g / 4.0f), (this.f1601dG / 2.0f) * this.f1599dE, f1589dT);
        C0119bk.m444b(poseStackPose, guiGraphics, f1566aJ, i4, f4, 150.0f, 150.0f, fM366g / 3.0f, this.f1601dG * this.f1599dE);
        C0119bk.m444b(poseStackPose, guiGraphics, f1566aJ, i4, f4, 150.0f, 150.0f, fM366g / 3.0f, this.f1601dG * this.f1599dE);
        ResourceLocation resourceLocationM2555d = C0564jv.m2555d("textures/misc/ranks/" + rank.getTexture() + ".png");
        float fSin2 = Mth.sin(fM366g / 35.0f);
        float fSin3 = Mth.sin((fM366g + 30.0f) / 35.0f);
        float fSin4 = 1.0f + Mth.sin(fM366g / 55.0f);
        float f5 = 5.0f * fSin2;
        float f6 = 5.0f * fSin3;
        float f7 = f3 + (10.0f * fSin4);
        C0119bk.m444b(poseStackPose, guiGraphics, f1572aP, i4, f4, f7, f7, f5, this.f1603dI * this.f1599dE);
        C0119bk.m444b(poseStackPose, guiGraphics, resourceLocationM2555d, i4, f4, f7, f7, f6, this.f1603dI * this.f1599dE);
        if (this.f1598dX <= 0) {
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.rankup.message", new Object[]{Component.literal(rank.getTitle()).withColor(f1590dU)}).withColor(f1589dT).withStyle(ChatFormatting.BOLD);
            C0119bk.m391b(poseStackPose, this.font, guiGraphics, f1591bk, i4, i3 - 75, 2.5f);
            C0119bk.m382c(poseStackPose, this.font, guiGraphics, (Component) mutableComponentWithStyle, i4, i3 - 50);
        }
        for (C0127bs c0127bs : this.renderables) {
            if (c0127bs instanceof C0127bs) {
                c0127bs.render(guiGraphics, i, i2, f);
            }
        }
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        this.f1597b = addRenderableWidget(new C0127bs((this.width / 2) - 50, this.height - 30, 100, 15, f1592bl, button -> {
            m1198L();
        }).m653a(C0127bs.a.SHADOW).m660e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m666f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m639a(C0127bs.c.SHADOW).m649a(0.0f, 1.5f));
        this.f1597b.visible = false;
    }
}
