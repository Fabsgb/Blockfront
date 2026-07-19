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

/* JADX INFO: renamed from: com.boehmod.blockfront.et, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/et.class */
public class C0129et extends AbstractC0120ek {

    @NotNull
    private static final ResourceLocation ct = C0265jv.d("textures/misc/muzzleflash/whiteflash.png");

    @NotNull
    private static final MutableComponent j = Component.translatable("bf.message.game.match.summary.progress.exp.current");

    @NotNull
    private static final MutableComponent k = Component.translatable("bf.message.game.match.summary.progress.exp.earned");

    @NotNull
    private static final MutableComponent l = Component.translatable("bf.message.game.match.summary.progress.exp.remaining");

    @NotNull
    private static final MutableComponent m = Component.translatable("bf.message.game.match.summary.progress.exp.promoted");
    private static final int ie = 40;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    private static final int f119if = 140;
    private static final int ig = 60;
    private static final int ih = 40;
    private int ii;
    private boolean cb;
    private int ij;
    private boolean cc;
    private final int ik;
    private final int il;
    private int im;
    private float du;
    private float ee;
    private PlayerRank a;
    private int in;
    private float ef;
    private float eg;
    private float eh;
    private float ei;

    public C0129et(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, Component.empty());
        this.ii = 0;
        this.cb = false;
        this.ij = 60;
        this.cc = false;
        this.in = 0;
        this.ef = 0.0f;
        this.eg = 0.0f;
        this.eh = 0.0f;
        this.ei = 0.0f;
        this.ik = i5;
        this.il = i6;
        this.im = i5;
        this.a = PlayerRank.getRankFromEXP(i5);
        int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(this.a);
        if (PlayerRank.getTotalRequiredEXPForRank(PlayerRank.getNextRank(this.a.getID())) > totalRequiredEXPForRank) {
            this.du = (i5 - totalRequiredEXPForRank) / (r0 - totalRequiredEXPForRank);
            this.du = Math.max(0.0f, Math.min(1.0f, this.du));
        } else {
            this.du = 1.0f;
        }
        this.ee = this.du;
    }

    private void p(@NotNull Minecraft minecraft) {
        this.in = 40;
        this.ef = 1.0f;
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.oT.get(), 1.0f, 1.0f));
    }

    public boolean I() {
        return this.cb && this.in <= 0 && this.ii <= 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    public void a(float f) {
        Minecraft minecraft = Minecraft.getInstance();
        if (I()) {
            return;
        }
        this.eg = this.ef;
        this.ei = this.eh;
        this.ee = this.du;
        this.ef = C0634xm.d(this.ef, 0.0f, 0.05f);
        this.eh = C0634xm.d(this.eh, 0.0f, 0.1f);
        if (!this.cc) {
            if (this.ij > 0) {
                this.ij--;
                return;
            } else {
                this.cc = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.EXPERIENCE_ORB_PICKUP, 0.8f, 1.0f));
            }
        }
        this.in--;
        if (this.in == 0) {
            this.du = 0.0f;
            this.ee = 0.0f;
        } else if (this.in > 0) {
            return;
        }
        if (this.cb) {
            if (this.ii > 0) {
                this.ii--;
                return;
            }
            return;
        }
        this.im = C0634xm.b(this.im, this.il, Math.max(1, (this.il - this.ik) / f119if));
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(this.im);
        if (rankFromEXP.getID() > this.a.getID()) {
            this.a = rankFromEXP;
            p(minecraft);
            this.du = 0.0f;
            this.ee = 0.0f;
        } else {
            PlayerRank nextRank = PlayerRank.getNextRank(this.a.getID());
            int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(this.a);
            if (PlayerRank.getTotalRequiredEXPForRank(nextRank) > totalRequiredEXPForRank) {
                this.du = (this.im - totalRequiredEXPForRank) / (r0 - totalRequiredEXPForRank);
                this.du = Math.max(0.0f, Math.min(1.0f, this.du));
            } else {
                this.du = 1.0f;
            }
        }
        if (this.im >= this.il) {
            this.cb = true;
            this.ii = 40;
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f));
            this.eh = 1.0f;
            return;
        }
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.NOTE_BLOCK_HAT.value(), 1.0f + (this.du * 0.5f), 0.25f));
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        b(poseStackPose, guiGraphics, f2);
        int iP = C0040bk.p();
        C0040bk.a(guiGraphics, getX() + 1, getY(), this.width - 2, 1, iP);
        C0040bk.a(guiGraphics, getX(), getY() + 1, this.width, this.height - 2, iP);
        C0040bk.a(guiGraphics, getX() + 1, (getY() + this.height) - 1, this.width - 2, 1, iP);
        b(guiGraphics, f2);
        if (this.in > 0) {
            a(poseStackPose, guiGraphics, font, f2);
        } else {
            b(poseStackPose, guiGraphics, font, f2);
        }
    }

    private void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f) {
        float fE = C0634xm.e(this.ef, this.eg, f);
        C0040bk.b(poseStack, guiGraphics, ct, getX() + (this.width / 2), getY() + (this.height / 2), InterfaceC0638xq.tQ, InterfaceC0638xq.tQ, 0.0f, fE, ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
    }

    private void b(@NotNull GuiGraphics guiGraphics, float f) {
        float fE = C0634xm.e(this.eh, this.ei, f);
        if (fE <= 0.0f) {
            return;
        }
        int i = ColorReferences.COLOR_STOPWATCH_SOLID;
        float f2 = fE * 0.5f;
        C0040bk.a(guiGraphics, getX() + 1, getY(), this.width - 2, 1, i, f2);
        C0040bk.a(guiGraphics, getX(), getY() + 1, this.width, this.height - 2, i, f2);
        C0040bk.a(guiGraphics, getX() + 1, (getY() + this.height) - 1, this.width - 2, 1, i, f2);
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, float f) {
        float fE = C0634xm.e(this.ef, this.eg, f);
        int i = ColorReferences.COLOR_THEME_PRESTIGE_SOLID;
        float f2 = fE * 0.5f;
        C0040bk.a(guiGraphics, getX() + 1, getY(), this.width - 2, 1, i, f2);
        C0040bk.a(guiGraphics, getX(), getY() + 1, this.width, this.height - 2, i, f2);
        C0040bk.a(guiGraphics, getX() + 1, (getY() + this.height) - 1, this.width - 2, 1, i, f2);
        MutableComponent mutableComponentLiteral = Component.literal(C0637xp.p(m.getString()));
        int x = getX() + (this.width / 2);
        int y = (getY() + (this.height / 2)) - 16;
        C0040bk.c(poseStack, font, guiGraphics, (Component) mutableComponentLiteral, x, y, 2.0f);
        C0040bk.c(poseStack, font, guiGraphics, (Component) Component.literal(C0637xp.p(this.a.getTitle())).withColor(i), getX() + (this.width / 2), y + 18, 1.5f);
    }

    private void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, float f) {
        int iP = C0040bk.p();
        int i = this.width - 80;
        int x = (getX() + (this.width / 2)) - (i / 2);
        int y = ((getY() + this.height) - 10) - 8;
        C0040bk.a(poseStack, guiGraphics, x + 1, y, i - 2, 1.0f, iP);
        C0040bk.a(poseStack, guiGraphics, x, y + 1, i, 8.0f, iP);
        C0040bk.a(poseStack, guiGraphics, x + 1, (y + 10) - 1, i - 2, 1.0f, iP);
        float fE = i * C0634xm.e(this.du, this.ee, f);
        int i2 = x + 2;
        int i3 = y + 2;
        float fClamp = Mth.clamp(fE - 4.0f, 0.0f, i - 4);
        C0040bk.a(poseStack, guiGraphics, i2, i3, i - 4, 6.0f, ColorReferences.COLOR_STOPWATCH_SOLID, 0.15f);
        C0040bk.a(poseStack, guiGraphics, i2, i3, fClamp, 6.0f, ColorReferences.COLOR_STOPWATCH_SOLID);
        float fMin = Math.min(fClamp, 10.0f);
        C0040bk.b(poseStack, guiGraphics, (i2 + fClamp) - fMin, i3, fMin, 6.0f, ColorReferences.COLOR_STOPWATCH_SOLID, ColorReferences.COLOR_WHITE_SOLID);
        float f2 = i2 + fClamp + 3.0f;
        float f3 = i3 + 6 + 3.0f;
        if (this.ij <= 0) {
            if (this.im > 0) {
                C0040bk.b(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.game.match.summary.progress.exp", new Object[]{C0637xp.a(this.im)}), f2, f3, ColorReferences.COLOR_STOPWATCH);
                C0040bk.b(poseStack, font, guiGraphics, (Component) Component.literal(C0637xp.p(j.getString())), f2, f3 + 8.0f);
            }
            int i4 = this.im - this.ik;
            if (i4 > 0) {
                float f4 = f3 + 18.0f;
                C0040bk.b(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.game.match.summary.progress.exp", new Object[]{C0637xp.a(i4)}), f2, f4, 9633658);
                C0040bk.b(poseStack, font, guiGraphics, (Component) Component.literal(C0637xp.p(k.getString())), f2, f4 + 8.0f);
            }
            PlayerRank nextRank = PlayerRank.getNextRank(this.a.getID());
            int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(nextRank) - this.im;
            if (nextRank != this.a && totalRequiredEXPForRank > 0) {
                float f5 = f3 + 36.0f;
                C0040bk.b(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.game.match.summary.progress.exp", new Object[]{C0637xp.a(totalRequiredEXPForRank)}), f2, f5, ChatFormatting.GRAY.getColor().intValue());
                C0040bk.b(poseStack, font, guiGraphics, (Component) Component.literal(C0637xp.p(l.getString())), f2, f5 + 8.0f);
            }
        }
        int i5 = this.height - 8;
        C0040bk.a(poseStack, guiGraphics, C0265jv.d("textures/misc/ranks/" + this.a.getTexture() + ".png"), getX() + 4, getY() + 4, i5, i5);
        C0040bk.c(poseStack, font, guiGraphics, (Component) Component.literal(C0637xp.p(this.a.getTitle())), getX() + (this.width / 2), y - 15, 1.5f);
    }
}
