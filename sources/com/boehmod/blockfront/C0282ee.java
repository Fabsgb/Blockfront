package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.report.MatchResult;
import com.boehmod.bflib.cloud.common.p000mm.report.MatchSummary;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.bflib.common.util.TimeFormatUtils;
import com.boehmod.blockfront.C0204dF;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Locale;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ee */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ee.class */
public final class C0282ee extends AbstractC0284eg {

    /* JADX INFO: renamed from: hA */
    private static final int f2141hA = -1;

    /* JADX INFO: renamed from: hB */
    private static final int f2142hB = -5592406;

    /* JADX INFO: renamed from: hC */
    private static final int f2143hC = -7829368;

    /* JADX INFO: renamed from: hD */
    private static final int f2144hD = 1090519039;

    /* JADX INFO: renamed from: S */
    private static final String f2145S = "bf.message.matches.detail.";

    /* JADX INFO: renamed from: ea */
    private static final float f2146ea = 0.25f;

    /* JADX INFO: renamed from: hE */
    public static final int f2147hE = 640;

    /* JADX INFO: renamed from: hF */
    public static final int f2148hF = 360;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final MatchSummary f2149b;

    /* JADX INFO: renamed from: cg */
    @NotNull
    private final ResourceLocation f2150cg;

    /* JADX INFO: renamed from: aD */
    private float f2152aD;

    /* JADX INFO: renamed from: bN */
    private boolean f2151bN = false;

    /* JADX INFO: renamed from: aE */
    private float f2153aE = 0.0f;

    public C0282ee(@NotNull MatchSummary matchSummary) {
        this.f2149b = matchSummary;
        this.f2150cg = C0564jv.m2555d("textures/gui/maps/" + this.f2149b.mapName().toLowerCase(Locale.ROOT) + "_" + this.f2149b.environment().toLowerCase(Locale.ROOT) + ".png");
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: n */
    public void mo810n(@NotNull Minecraft minecraft) {
        this.f2153aE = this.f2152aD;
        this.f2152aD = Mth.lerp(0.75f, this.f2152aD, m1499D() ? 1.0f : 0.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: v */
    public boolean mo811v() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    public int height() {
        return 30;
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
        int iMo812t = mo812t();
        int iHeight = height();
        int i3 = iMo812t / 2;
        int i4 = iHeight / 2;
        float fM7843e = C1290xm.m7843e(this.f2152aD, this.f2153aE, f2);
        C0119bk.m517a(guiGraphics, this.f2166hI, (int) (this.f2167hJ - this.f2165a.mo1311k(f2)), iMo812t, iHeight);
        C0119bk.m449c(poseStack, guiGraphics, this.f2150cg, this.f2166hI + i3, this.f2167hJ + i4, iMo812t, (int) ((iMo812t / 640.0f) * 360.0f), 1.0f + (0.1f * fM7843e), 0.25f);
        guiGraphics.disableScissor();
        boolean zD = m1499D();
        if (fM7843e > 0.0f) {
            C0119bk.m417a(guiGraphics, this.f2166hI, this.f2167hJ, iMo812t, iHeight, -1, 0.12f * fM7843e);
        }
        if (zD) {
            if (!this.f2151bN) {
                this.f2151bN = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), 1.0f));
            }
        } else {
            this.f2151bN = false;
        }
        C0119bk.m415a(guiGraphics, this.f2166hI, this.f2167hJ, 2, iHeight, this.f2149b.result().getColor());
        C0119bk.m415a(guiGraphics, this.f2166hI, this.f2167hJ + (iHeight - 1), iMo812t, 1, f2144hD);
        C1016sW c1016sWM5531a = C1016sW.m5531a(this.f2149b.gameMode().getId());
        float f3 = this.f2166hI + 7 + 8.0f;
        float f4 = this.f2167hJ + i4;
        if (c1016sWM5531a != null) {
            C0119bk.m440b(poseStack, guiGraphics, c1016sWM5531a.getIconTexture(), f3, f4, 16.0f, 16.0f);
        }
        int i5 = this.f2166hI + 7 + 16 + 6;
        C0119bk.m368a(poseStack, font, guiGraphics, (Component) Component.literal(this.f2149b.mapName().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD).withColor(-1), i5, this.f2167hJ + 6);
        C0119bk.m368a(poseStack, font, guiGraphics, (Component) Component.empty().append(C1293xp.m7917p(c1016sWM5531a != null ? c1016sWM5531a.getDisplayName().getString() : this.f2149b.gameMode().getId())).withColor(ColorReferences.COLOR_STOPWATCH_SOLID), i5, this.f2167hJ + 15);
        int i6 = ((this.f2166hI + iMo812t) - 7) - 32;
        C0119bk.m383c(font, guiGraphics, m1493a(this.f2149b.result()), i6, this.f2167hJ + 5);
        C0119bk.m383c(font, guiGraphics, (Component) Component.literal(TimeFormatUtils.formatRelativeTime(this.f2149b.endedAtEpochMillis())).withColor(f2143hC), i6, this.f2167hJ + 16);
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: b */
    public void mo1479b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull C0326fV c0326fV, @NotNull Font font, int i, int i2, float f, float f2) {
        super.mo1479b(poseStack, minecraft, c0622l, guiGraphics, c0326fV, font, i, i2, f, f2);
        if (m1499D()) {
            guiGraphics.renderComponentTooltip(font, m1491a(this.f2149b), i, i2);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static List<Component> m1491a(@NotNull MatchSummary matchSummary) {
        C1016sW c1016sWM5531a = C1016sW.m5531a(matchSummary.gameMode().getId());
        Component displayName = c1016sWM5531a != null ? c1016sWM5531a.getDisplayName() : Component.literal(matchSummary.gameMode().getId());
        MutableComponent mutableComponentWithColor = Component.literal(matchSummary.mapName().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD).withColor(-1);
        MutableComponent mutableComponentWithColor2 = Component.empty().append(C1293xp.m7917p(c1016sWM5531a != null ? c1016sWM5531a.getDisplayName().getString() : matchSummary.gameMode().getId())).withColor(ColorReferences.COLOR_STOPWATCH_SOLID);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(mutableComponentWithColor);
        objectArrayList.add(mutableComponentWithColor2);
        objectArrayList.add(Component.empty());
        objectArrayList.add(m1492a("bf.message.matches.detail.result", m1493a(matchSummary.result())));
        String strPlayerTeam = matchSummary.playerTeam();
        if (strPlayerTeam != null) {
            objectArrayList.add(m1492a("bf.message.matches.detail.team", Component.literal(strPlayerTeam).withStyle(ChatFormatting.WHITE)));
        }
        objectArrayList.add(Component.empty());
        objectArrayList.add(m1492a("bf.message.matches.detail.kills", Component.literal(String.valueOf(matchSummary.kills())).withColor(C0204dF.b.KILLS.getColor())));
        objectArrayList.add(m1492a("bf.message.matches.detail.deaths", Component.literal(String.valueOf(matchSummary.deaths())).withColor(C0204dF.b.DEATHS.getColor())));
        objectArrayList.add(m1492a("bf.message.matches.detail.assists", Component.literal(String.valueOf(matchSummary.assists())).withColor(C0204dF.b.KD.getColor())));
        objectArrayList.add(m1492a("bf.message.matches.detail.score", Component.literal(String.valueOf(matchSummary.score())).withColor(C0204dF.b.SCORE.getColor())));
        objectArrayList.add(Component.empty());
        if (matchSummary.placement() > 0) {
            objectArrayList.add(m1492a("bf.message.matches.detail.placement", Component.literal("#" + matchSummary.placement()).withColor(-1)));
        }
        objectArrayList.add(m1492a("bf.message.matches.detail.played", Component.literal(TimeFormatUtils.formatRelativeTime(matchSummary.endedAtEpochMillis())).withColor(-1)));
        if (matchSummary.durationSeconds() > 0) {
            objectArrayList.add(m1492a("bf.message.matches.detail.duration", Component.literal(TimeFormatUtils.formatDuration(matchSummary.durationSeconds())).withColor(-1)));
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m1492a(@NotNull String str, @NotNull Component component) {
        return Component.translatable(str).withColor(f2142hB).append(Component.literal(": ").withColor(f2142hB)).append(component);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m1493a(@NotNull MatchResult matchResult) {
        return Component.translatable("bf.message.matches.result." + matchResult.getId()).withColor(matchResult.getColor()).withStyle(ChatFormatting.BOLD);
    }
}
