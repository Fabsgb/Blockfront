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

/* JADX INFO: renamed from: com.boehmod.blockfront.et */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/et.class */
public class C0297et extends AbstractC0288ek {

    /* JADX INFO: renamed from: ct */
    @NotNull
    private static final ResourceLocation f2255ct = C0564jv.m2555d("textures/misc/muzzleflash/whiteflash.png");

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final MutableComponent f2256j = Component.translatable("bf.message.game.match.summary.progress.exp.current");

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final MutableComponent f2257k = Component.translatable("bf.message.game.match.summary.progress.exp.earned");

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final MutableComponent f2258l = Component.translatable("bf.message.game.match.summary.progress.exp.remaining");

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final MutableComponent f2259m = Component.translatable("bf.message.game.match.summary.progress.exp.promoted");

    /* JADX INFO: renamed from: ie */
    private static final int f2260ie = 40;

    /* JADX INFO: renamed from: if */
    private static final int f2261if = 140;

    /* JADX INFO: renamed from: ig */
    private static final int f2262ig = 60;

    /* JADX INFO: renamed from: ih */
    private static final int f2263ih = 40;

    /* JADX INFO: renamed from: ii */
    private int f2264ii;

    /* JADX INFO: renamed from: cb */
    private boolean f2265cb;

    /* JADX INFO: renamed from: ij */
    private int f2266ij;

    /* JADX INFO: renamed from: cc */
    private boolean f2267cc;

    /* JADX INFO: renamed from: ik */
    private final int f2268ik;

    /* JADX INFO: renamed from: il */
    private final int f2269il;

    /* JADX INFO: renamed from: im */
    private int f2270im;

    /* JADX INFO: renamed from: du */
    private float f2271du;

    /* JADX INFO: renamed from: ee */
    private float f2272ee;

    /* JADX INFO: renamed from: a */
    private PlayerRank f2273a;

    /* JADX INFO: renamed from: in */
    private int f2274in;

    /* JADX INFO: renamed from: ef */
    private float f2275ef;

    /* JADX INFO: renamed from: eg */
    private float f2276eg;

    /* JADX INFO: renamed from: eh */
    private float f2277eh;

    /* JADX INFO: renamed from: ei */
    private float f2278ei;

    public C0297et(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, Component.empty());
        this.f2264ii = 0;
        this.f2265cb = false;
        this.f2266ij = 60;
        this.f2267cc = false;
        this.f2274in = 0;
        this.f2275ef = 0.0f;
        this.f2276eg = 0.0f;
        this.f2277eh = 0.0f;
        this.f2278ei = 0.0f;
        this.f2268ik = i5;
        this.f2269il = i6;
        this.f2270im = i5;
        this.f2273a = PlayerRank.getRankFromEXP(i5);
        int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(this.f2273a);
        if (PlayerRank.getTotalRequiredEXPForRank(PlayerRank.getNextRank(this.f2273a.getID())) > totalRequiredEXPForRank) {
            this.f2271du = (i5 - totalRequiredEXPForRank) / (r0 - totalRequiredEXPForRank);
            this.f2271du = Math.max(0.0f, Math.min(1.0f, this.f2271du));
        } else {
            this.f2271du = 1.0f;
        }
        this.f2272ee = this.f2271du;
    }

    /* JADX INFO: renamed from: p */
    private void m1570p(@NotNull Minecraft minecraft) {
        this.f2274in = 40;
        this.f2275ef = 1.0f;
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7536oT.get(), 1.0f, 1.0f));
    }

    /* JADX INFO: renamed from: I */
    public boolean m1571I() {
        return this.f2265cb && this.f2274in <= 0 && this.f2264ii <= 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    public void mo1519a(float f) {
        Minecraft minecraft = Minecraft.getInstance();
        if (m1571I()) {
            return;
        }
        this.f2276eg = this.f2275ef;
        this.f2278ei = this.f2277eh;
        this.f2272ee = this.f2271du;
        this.f2275ef = C1290xm.m7835d(this.f2275ef, 0.0f, 0.05f);
        this.f2277eh = C1290xm.m7835d(this.f2277eh, 0.0f, 0.1f);
        if (!this.f2267cc) {
            if (this.f2266ij > 0) {
                this.f2266ij--;
                return;
            } else {
                this.f2267cc = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.EXPERIENCE_ORB_PICKUP, 0.8f, 1.0f));
            }
        }
        this.f2274in--;
        if (this.f2274in == 0) {
            this.f2271du = 0.0f;
            this.f2272ee = 0.0f;
        } else if (this.f2274in > 0) {
            return;
        }
        if (this.f2265cb) {
            if (this.f2264ii > 0) {
                this.f2264ii--;
                return;
            }
            return;
        }
        this.f2270im = C1290xm.m7834b(this.f2270im, this.f2269il, Math.max(1, (this.f2269il - this.f2268ik) / f2261if));
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(this.f2270im);
        if (rankFromEXP.getID() > this.f2273a.getID()) {
            this.f2273a = rankFromEXP;
            m1570p(minecraft);
            this.f2271du = 0.0f;
            this.f2272ee = 0.0f;
        } else {
            PlayerRank nextRank = PlayerRank.getNextRank(this.f2273a.getID());
            int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(this.f2273a);
            if (PlayerRank.getTotalRequiredEXPForRank(nextRank) > totalRequiredEXPForRank) {
                this.f2271du = (this.f2270im - totalRequiredEXPForRank) / (r0 - totalRequiredEXPForRank);
                this.f2271du = Math.max(0.0f, Math.min(1.0f, this.f2271du));
            } else {
                this.f2271du = 1.0f;
            }
        }
        if (this.f2270im >= this.f2269il) {
            this.f2265cb = true;
            this.f2264ii = 40;
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f));
            this.f2277eh = 1.0f;
            return;
        }
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.NOTE_BLOCK_HAT.value(), 1.0f + (this.f2271du * 0.5f), 0.25f));
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    protected void mo1521a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        m1572b(poseStackPose, guiGraphics, f2);
        int iM365p = C0119bk.m365p();
        C0119bk.m415a(guiGraphics, getX() + 1, getY(), this.width - 2, 1, iM365p);
        C0119bk.m415a(guiGraphics, getX(), getY() + 1, this.width, this.height - 2, iM365p);
        C0119bk.m415a(guiGraphics, getX() + 1, (getY() + this.height) - 1, this.width - 2, 1, iM365p);
        m1573b(guiGraphics, f2);
        if (this.f2274in > 0) {
            m1574a(poseStackPose, guiGraphics, font, f2);
        } else {
            m1575b(poseStackPose, guiGraphics, font, f2);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1572b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f) {
        float fM7843e = C1290xm.m7843e(this.f2275ef, this.f2276eg, f);
        C0119bk.m447b(poseStack, guiGraphics, f2255ct, getX() + (this.width / 2), getY() + (this.height / 2), InterfaceC1294xq.f8655tQ, InterfaceC1294xq.f8655tQ, 0.0f, fM7843e, ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
    }

    /* JADX INFO: renamed from: b */
    private void m1573b(@NotNull GuiGraphics guiGraphics, float f) {
        float fM7843e = C1290xm.m7843e(this.f2277eh, this.f2278ei, f);
        if (fM7843e <= 0.0f) {
            return;
        }
        int i = ColorReferences.COLOR_STOPWATCH_SOLID;
        float f2 = fM7843e * 0.5f;
        C0119bk.m417a(guiGraphics, getX() + 1, getY(), this.width - 2, 1, i, f2);
        C0119bk.m417a(guiGraphics, getX(), getY() + 1, this.width, this.height - 2, i, f2);
        C0119bk.m417a(guiGraphics, getX() + 1, (getY() + this.height) - 1, this.width - 2, 1, i, f2);
    }

    /* JADX INFO: renamed from: a */
    private void m1574a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, float f) {
        float fM7843e = C1290xm.m7843e(this.f2275ef, this.f2276eg, f);
        int i = ColorReferences.COLOR_THEME_PRESTIGE_SOLID;
        float f2 = fM7843e * 0.5f;
        C0119bk.m417a(guiGraphics, getX() + 1, getY(), this.width - 2, 1, i, f2);
        C0119bk.m417a(guiGraphics, getX(), getY() + 1, this.width, this.height - 2, i, f2);
        C0119bk.m417a(guiGraphics, getX() + 1, (getY() + this.height) - 1, this.width - 2, 1, i, f2);
        MutableComponent mutableComponentLiteral = Component.literal(C1293xp.m7917p(f2259m.getString()));
        int x = getX() + (this.width / 2);
        int y = (getY() + (this.height / 2)) - 16;
        C0119bk.m394c(poseStack, font, guiGraphics, (Component) mutableComponentLiteral, x, y, 2.0f);
        C0119bk.m394c(poseStack, font, guiGraphics, (Component) Component.literal(C1293xp.m7917p(this.f2273a.getTitle())).withColor(i), getX() + (this.width / 2), y + 18, 1.5f);
    }

    /* JADX INFO: renamed from: b */
    private void m1575b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, float f) {
        int iM365p = C0119bk.m365p();
        int i = this.width - 80;
        int x = (getX() + (this.width / 2)) - (i / 2);
        int y = ((getY() + this.height) - 10) - 8;
        C0119bk.m414a(poseStack, guiGraphics, x + 1, y, i - 2, 1.0f, iM365p);
        C0119bk.m414a(poseStack, guiGraphics, x, y + 1, i, 8.0f, iM365p);
        C0119bk.m414a(poseStack, guiGraphics, x + 1, (y + 10) - 1, i - 2, 1.0f, iM365p);
        float fM7843e = i * C1290xm.m7843e(this.f2271du, this.f2272ee, f);
        int i2 = x + 2;
        int i3 = y + 2;
        float fClamp = Mth.clamp(fM7843e - 4.0f, 0.0f, i - 4);
        C0119bk.m416a(poseStack, guiGraphics, i2, i3, i - 4, 6.0f, ColorReferences.COLOR_STOPWATCH_SOLID, 0.15f);
        C0119bk.m414a(poseStack, guiGraphics, i2, i3, fClamp, 6.0f, ColorReferences.COLOR_STOPWATCH_SOLID);
        float fMin = Math.min(fClamp, 10.0f);
        C0119bk.m424b(poseStack, guiGraphics, (i2 + fClamp) - fMin, i3, fMin, 6.0f, ColorReferences.COLOR_STOPWATCH_SOLID, ColorReferences.COLOR_WHITE_SOLID);
        float f2 = i2 + fClamp + 3.0f;
        float f3 = i3 + 6 + 3.0f;
        if (this.f2266ij <= 0) {
            if (this.f2270im > 0) {
                C0119bk.m380b(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.game.match.summary.progress.exp", new Object[]{C1293xp.m7912a(this.f2270im)}), f2, f3, ColorReferences.COLOR_STOPWATCH);
                C0119bk.m378b(poseStack, font, guiGraphics, (Component) Component.literal(C1293xp.m7917p(f2256j.getString())), f2, f3 + 8.0f);
            }
            int i4 = this.f2270im - this.f2268ik;
            if (i4 > 0) {
                float f4 = f3 + 18.0f;
                C0119bk.m380b(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.game.match.summary.progress.exp", new Object[]{C1293xp.m7912a(i4)}), f2, f4, 9633658);
                C0119bk.m378b(poseStack, font, guiGraphics, (Component) Component.literal(C1293xp.m7917p(f2257k.getString())), f2, f4 + 8.0f);
            }
            PlayerRank nextRank = PlayerRank.getNextRank(this.f2273a.getID());
            int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(nextRank) - this.f2270im;
            if (nextRank != this.f2273a && totalRequiredEXPForRank > 0) {
                float f5 = f3 + 36.0f;
                C0119bk.m380b(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.game.match.summary.progress.exp", new Object[]{C1293xp.m7912a(totalRequiredEXPForRank)}), f2, f5, ChatFormatting.GRAY.getColor().intValue());
                C0119bk.m378b(poseStack, font, guiGraphics, (Component) Component.literal(C1293xp.m7917p(f2258l.getString())), f2, f5 + 8.0f);
            }
        }
        int i5 = this.height - 8;
        C0119bk.m431a(poseStack, guiGraphics, C0564jv.m2555d("textures/misc/ranks/" + this.f2273a.getTexture() + ".png"), getX() + 4, getY() + 4, i5, i5);
        C0119bk.m394c(poseStack, font, guiGraphics, (Component) Component.literal(C1293xp.m7917p(this.f2273a.getTitle())), getX() + (this.width / 2), y - 15, 1.5f);
    }
}
