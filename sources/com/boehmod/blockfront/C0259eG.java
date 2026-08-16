package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eG.class */
public class C0259eG extends AbstractC0302ex {

    /* JADX INFO: renamed from: cs */
    @NotNull
    private static final ResourceLocation f2125cs = C0532jO.m2378d("textures/misc/muzzleflash/whiteflash.png");

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final MutableComponent f2126j = Component.translatable("bf.message.game.match.summary.progress.exp.current");

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final MutableComponent f2127k = Component.translatable("bf.message.game.match.summary.progress.exp.earned");

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final MutableComponent f2128l = Component.translatable("bf.message.game.match.summary.progress.exp.remaining");

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final MutableComponent f2129m = Component.translatable("bf.message.game.match.summary.progress.exp.promoted");

    /* JADX INFO: renamed from: ju */
    private static final int f2130ju = 40;

    /* JADX INFO: renamed from: jv */
    private static final int f2131jv = 140;

    /* JADX INFO: renamed from: jw */
    private static final int f2132jw = 60;

    /* JADX INFO: renamed from: jx */
    private static final int f2133jx = 40;

    /* JADX INFO: renamed from: jy */
    private int f2134jy;

    /* JADX INFO: renamed from: cj */
    private boolean f2135cj;

    /* JADX INFO: renamed from: jz */
    private int f2136jz;

    /* JADX INFO: renamed from: ck */
    private boolean f2137ck;

    /* JADX INFO: renamed from: jA */
    private final int f2138jA;

    /* JADX INFO: renamed from: jB */
    private final int f2139jB;

    /* JADX INFO: renamed from: jC */
    private int f2140jC;

    /* JADX INFO: renamed from: dA */
    private float f2141dA;

    /* JADX INFO: renamed from: eh */
    private float f2142eh;

    /* JADX INFO: renamed from: a */
    private PlayerRank f2143a;

    /* JADX INFO: renamed from: jD */
    private int f2144jD;

    /* JADX INFO: renamed from: ei */
    private float f2145ei;

    /* JADX INFO: renamed from: ej */
    private float f2146ej;

    /* JADX INFO: renamed from: ek */
    private float f2147ek;

    /* JADX INFO: renamed from: el */
    private float f2148el;

    public C0259eG(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, Component.empty());
        this.f2134jy = 0;
        this.f2135cj = false;
        this.f2136jz = 60;
        this.f2137ck = false;
        this.f2144jD = 0;
        this.f2145ei = 0.0f;
        this.f2146ej = 0.0f;
        this.f2147ek = 0.0f;
        this.f2148el = 0.0f;
        this.f2138jA = i5;
        this.f2139jB = i6;
        this.f2140jC = i5;
        this.f2143a = PlayerRank.getRankFromEXP(i5);
        int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(this.f2143a);
        int totalRequiredEXPForRank2 = PlayerRank.getTotalRequiredEXPForRank(PlayerRank.getNextRank(this.f2143a.getID()));
        if (totalRequiredEXPForRank2 > totalRequiredEXPForRank) {
            this.f2141dA = (i5 - totalRequiredEXPForRank) / (totalRequiredEXPForRank2 - totalRequiredEXPForRank);
            this.f2141dA = Math.max(0.0f, Math.min(1.0f, this.f2141dA));
        } else {
            this.f2141dA = 1.0f;
        }
        this.f2142eh = this.f2141dA;
    }

    /* JADX INFO: renamed from: q */
    private void m1472q(@NotNull Minecraft minecraft) {
        this.f2144jD = 40;
        this.f2145ei = 1.0f;
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7948oV.get(), 1.0f, 1.0f));
    }

    /* JADX INFO: renamed from: J */
    public boolean m1473J() {
        return this.f2135cj && this.f2144jD <= 0 && this.f2134jy <= 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    public void mo1443a(float f) {
        Minecraft minecraft = Minecraft.getInstance();
        if (m1473J()) {
            return;
        }
        this.f2146ej = this.f2145ei;
        this.f2148el = this.f2147ek;
        this.f2142eh = this.f2141dA;
        this.f2145ei = C1270xJ.m7161d(this.f2145ei, 0.0f, 0.05f);
        this.f2147ek = C1270xJ.m7161d(this.f2147ek, 0.0f, 0.1f);
        if (!this.f2137ck) {
            if (this.f2136jz > 0) {
                this.f2136jz--;
                return;
            } else {
                this.f2137ck = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.EXPERIENCE_ORB_PICKUP, 0.8f, 1.0f));
            }
        }
        this.f2144jD--;
        if (this.f2144jD == 0) {
            this.f2141dA = 0.0f;
            this.f2142eh = 0.0f;
        } else if (this.f2144jD > 0) {
            return;
        }
        if (this.f2135cj) {
            if (this.f2134jy > 0) {
                this.f2134jy--;
                return;
            }
            return;
        }
        this.f2140jC = C1270xJ.m7160b(this.f2140jC, this.f2139jB, Math.max(1, (this.f2139jB - this.f2138jA) / f2131jv));
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(this.f2140jC);
        if (rankFromEXP.getID() > this.f2143a.getID()) {
            this.f2143a = rankFromEXP;
            m1472q(minecraft);
            this.f2141dA = 0.0f;
            this.f2142eh = 0.0f;
        } else {
            PlayerRank nextRank = PlayerRank.getNextRank(this.f2143a.getID());
            int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(this.f2143a);
            int totalRequiredEXPForRank2 = PlayerRank.getTotalRequiredEXPForRank(nextRank);
            if (totalRequiredEXPForRank2 > totalRequiredEXPForRank) {
                this.f2141dA = (this.f2140jC - totalRequiredEXPForRank) / (totalRequiredEXPForRank2 - totalRequiredEXPForRank);
                this.f2141dA = Math.max(0.0f, Math.min(1.0f, this.f2141dA));
            } else {
                this.f2141dA = 1.0f;
            }
        }
        if (this.f2140jC >= this.f2139jB) {
            this.f2135cj = true;
            this.f2134jy = 40;
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f));
            this.f2147ek = 1.0f;
            return;
        }
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.NOTE_BLOCK_HAT.value(), 1.0f + (this.f2141dA * 0.5f), 0.25f));
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    protected void mo1440a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        m1474b(poseStackPose, guiGraphics, f2);
        C0129bt.m518b(guiGraphics, getX(), getY(), this.width, this.height, C0129bt.m465t());
        m1475b(guiGraphics, f2);
        if (this.f2144jD > 0) {
            m1476a(poseStackPose, guiGraphics, font, f2);
        } else {
            m1477b(poseStackPose, guiGraphics, font, f2);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1474b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f) {
        float fM7170f = C1270xJ.m7170f(this.f2145ei, this.f2146ej, f);
        C0129bt.m547b(poseStack, guiGraphics, f2125cs, getX() + (this.width / 2), getY() + (this.height / 2), InterfaceC1274xN.f6852vU, InterfaceC1274xN.f6852vU, 0.0f, fM7170f, ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
    }

    /* JADX INFO: renamed from: b */
    private void m1475b(@NotNull GuiGraphics guiGraphics, float f) {
        float fM7170f = C1270xJ.m7170f(this.f2147ek, this.f2148el, f);
        if (fM7170f <= 0.0f) {
            return;
        }
        C0129bt.m519b(guiGraphics, getX(), getY(), this.width, this.height, ColorReferences.COLOR_STOPWATCH_SOLID, fM7170f * 0.5f);
    }

    /* JADX INFO: renamed from: a */
    private void m1476a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, float f) {
        float fM7170f = C1270xJ.m7170f(this.f2145ei, this.f2146ej, f);
        int i = ColorReferences.COLOR_THEME_PRESTIGE_SOLID;
        C0129bt.m519b(guiGraphics, getX(), getY(), this.width, this.height, i, fM7170f * 0.5f);
        MutableComponent mutableComponentLiteral = Component.literal(C1273xM.m7244p(f2129m.getString()));
        int x = getX() + (this.width / 2);
        int y = (getY() + (this.height / 2)) - 16;
        C0129bt.m494c(poseStack, font, guiGraphics, (Component) mutableComponentLiteral, x, y, 2.0f);
        C0129bt.m494c(poseStack, font, guiGraphics, (Component) Component.literal(C1273xM.m7244p(this.f2143a.getTitle())).withColor(i), getX() + (this.width / 2), y + 18, 1.5f);
    }

    /* JADX INFO: renamed from: b */
    private void m1477b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, float f) {
        int iM465t = C0129bt.m465t();
        int i = this.width - 80;
        int x = (getX() + (this.width / 2)) - (i / 2);
        int y = ((getY() + this.height) - 10) - 8;
        C0129bt.m514a(poseStack, guiGraphics, x + 1, y, i - 2, 1.0f, iM465t);
        C0129bt.m514a(poseStack, guiGraphics, x, y + 1, i, 8.0f, iM465t);
        C0129bt.m514a(poseStack, guiGraphics, x + 1, (y + 10) - 1, i - 2, 1.0f, iM465t);
        float fM7170f = i * C1270xJ.m7170f(this.f2141dA, this.f2142eh, f);
        int i2 = x + 2;
        int i3 = y + 2;
        float fClamp = Mth.clamp(fM7170f - 4.0f, 0.0f, i - 4);
        C0129bt.m516a(poseStack, guiGraphics, i2, i3, i - 4, 6.0f, ColorReferences.COLOR_STOPWATCH_SOLID, 0.15f);
        C0129bt.m514a(poseStack, guiGraphics, i2, i3, fClamp, 6.0f, ColorReferences.COLOR_STOPWATCH_SOLID);
        float fMin = Math.min(fClamp, 10.0f);
        C0129bt.m524b(poseStack, guiGraphics, (i2 + fClamp) - fMin, i3, fMin, 6.0f, ColorReferences.COLOR_STOPWATCH_SOLID, ColorReferences.COLOR_WHITE_SOLID);
        float f2 = i2 + fClamp + 3.0f;
        float f3 = i3 + 6 + 3.0f;
        if (this.f2136jz <= 0) {
            if (this.f2140jC > 0) {
                C0129bt.m480b(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.game.match.summary.progress.exp", new Object[]{C1273xM.m7239b(this.f2140jC)}), f2, f3, ColorReferences.COLOR_STOPWATCH);
                C0129bt.m478b(poseStack, font, guiGraphics, (Component) Component.literal(C1273xM.m7244p(f2126j.getString())), f2, f3 + 8.0f);
            }
            int i4 = this.f2140jC - this.f2138jA;
            if (i4 > 0) {
                float f4 = f3 + 18.0f;
                C0129bt.m480b(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.game.match.summary.progress.exp", new Object[]{C1273xM.m7239b(i4)}), f2, f4, 9633658);
                C0129bt.m478b(poseStack, font, guiGraphics, (Component) Component.literal(C1273xM.m7244p(f2127k.getString())), f2, f4 + 8.0f);
            }
            PlayerRank nextRank = PlayerRank.getNextRank(this.f2143a.getID());
            int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(nextRank) - this.f2140jC;
            if (nextRank != this.f2143a && totalRequiredEXPForRank > 0) {
                float f5 = f3 + 36.0f;
                C0129bt.m480b(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.game.match.summary.progress.exp", new Object[]{C1273xM.m7239b(totalRequiredEXPForRank)}), f2, f5, ChatFormatting.GRAY.getColor().intValue());
                C0129bt.m478b(poseStack, font, guiGraphics, (Component) Component.literal(C1273xM.m7244p(f2128l.getString())), f2, f5 + 8.0f);
            }
        }
        int i5 = this.height - 8;
        C0129bt.m531a(poseStack, guiGraphics, C0532jO.m2378d("textures/misc/ranks/" + this.f2143a.getTexture() + ".png"), getX() + 4, getY() + 4, i5, i5);
        C0129bt.m494c(poseStack, font, guiGraphics, (Component) Component.literal(C1273xM.m7244p(this.f2143a.getTitle())), getX() + (this.width / 2), y - 15, 1.5f);
    }
}
