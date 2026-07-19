package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cz.class */
public class C0082cz extends C0080cx {
    public static final int dT = -3223881;
    public static final int dU = -601527;
    public static final int dV = 100;
    public static final int dW = 15;

    @NotNull
    private final Screen e;

    @Nullable
    private C0048bs b;
    private int dX;
    private float dE;
    private float dF;
    private float dG;
    private float dH;
    private float dI;

    @NotNull
    private static final Component bk = Component.translatable("bf.rankup.title").withStyle(C0266jw.b);

    @NotNull
    private static final Component bl = Component.translatable("bf.menu.button.close");
    public static boolean aX = false;

    public C0082cz(@NotNull Screen screen) {
        super(bk, bk);
        this.dX = 40;
        this.dF = 0.0f;
        this.dG = 0.0f;
        this.dH = 0.0f;
        this.dI = 0.0f;
        this.e = screen;
        this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pc.get(), 1.0f, 1.0f));
    }

    public void L() {
        M();
        this.b.setScreen(this.e);
    }

    private void M() {
        this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pl.get(), 1.25f, 1.0f));
    }

    public void removed() {
        super.removed();
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        int i = this.dX;
        this.dX = i - 1;
        if (i <= 0 && this.b != null) {
            this.b.visible = true;
        }
        this.dF = this.dE;
        this.dE = Mth.lerp(0.1f, this.dE, 1.0f);
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        this.e.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        float fG = C0040bk.g();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        float fSin = 1.0f + (Mth.sin(fG / 40.0f) / 5.0f);
        this.dG = Mth.lerp(0.1f, this.dG, fSin);
        this.dH = Mth.lerp(0.08f, this.dH, fSin);
        this.dI = Mth.lerp(0.06f, this.dI, fSin);
        float fE = C0634xm.e(this.dE, this.dF, f);
        PlayerRank rank = this.a.m404a(this.b).getRank();
        int i3 = (this.height / 2) - 20;
        int i4 = this.width / 2;
        float f2 = (this.height / 2.0f) * fE;
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, 0, 0.75f * fE);
        C0040bk.a(poseStackPose, guiGraphics, aN, 0, 0, this.width, this.height, fE);
        float f3 = 80.0f * this.dI;
        float f4 = f2 + 10.0f;
        C0040bk.b(poseStackPose, guiGraphics, aK, i4, f4, 320.0f, 320.0f, fG / 3.0f, this.dG * this.dE, dT);
        C0040bk.b(poseStackPose, guiGraphics, aM, i4, f4, 250.0f, 250.0f, -(fG / 4.0f), (this.dG / 2.0f) * this.dE, dT);
        C0040bk.b(poseStackPose, guiGraphics, aJ, i4, f4, 150.0f, 150.0f, fG / 3.0f, this.dG * this.dE);
        C0040bk.b(poseStackPose, guiGraphics, aJ, i4, f4, 150.0f, 150.0f, fG / 3.0f, this.dG * this.dE);
        ResourceLocation resourceLocationD = C0265jv.d("textures/misc/ranks/" + rank.getTexture() + ".png");
        float fSin2 = Mth.sin(fG / 35.0f);
        float fSin3 = Mth.sin((fG + 30.0f) / 35.0f);
        float fSin4 = 1.0f + Mth.sin(fG / 55.0f);
        float f5 = 5.0f * fSin2;
        float f6 = 5.0f * fSin3;
        float f7 = f3 + (10.0f * fSin4);
        C0040bk.b(poseStackPose, guiGraphics, aP, i4, f4, f7, f7, f5, this.dI * this.dE);
        C0040bk.b(poseStackPose, guiGraphics, resourceLocationD, i4, f4, f7, f7, f6, this.dI * this.dE);
        if (this.dX <= 0) {
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.rankup.message", new Object[]{Component.literal(rank.getTitle()).withColor(dU)}).withColor(dT).withStyle(ChatFormatting.BOLD);
            C0040bk.b(poseStackPose, this.font, guiGraphics, bk, i4, i3 - 75, 2.5f);
            C0040bk.c(poseStackPose, this.font, guiGraphics, (Component) mutableComponentWithStyle, i4, i3 - 50);
        }
        for (C0048bs c0048bs : this.renderables) {
            if (c0048bs instanceof C0048bs) {
                c0048bs.render(guiGraphics, i, i2, f);
            }
        }
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        this.b = addRenderableWidget(new C0048bs((this.width / 2) - 50, this.height - 30, 100, 15, bl, button -> {
            L();
        }).a(C0048bs.a.SHADOW).e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).a(C0048bs.c.SHADOW).a(0.0f, 1.5f));
        this.b.visible = false;
    }
}
