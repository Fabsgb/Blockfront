package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.report.MatchResult;
import com.boehmod.bflib.cloud.common.mm.report.MatchSummary;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.bflib.common.util.TimeFormatUtils;
import com.boehmod.blockfront.dF;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ee, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ee.class */
public final class C0114ee extends AbstractC0116eg {
    private static final int hA = -1;
    private static final int hB = -5592406;
    private static final int hC = -7829368;
    private static final int hD = 1090519039;
    private static final String S = "bf.message.matches.detail.";
    private static final float ea = 0.25f;
    public static final int hE = 640;
    public static final int hF = 360;

    @NotNull
    private final MatchSummary b;

    @NotNull
    private final ResourceLocation cg;
    private float aD;
    private boolean bN = false;
    private float aE = 0.0f;

    public C0114ee(@NotNull MatchSummary matchSummary) {
        this.b = matchSummary;
        this.cg = C0265jv.d("textures/gui/maps/" + this.b.mapName().toLowerCase(Locale.ROOT) + "_" + this.b.environment().toLowerCase(Locale.ROOT) + ".png");
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
        return 30;
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
        int iMo265t = mo265t();
        int iHeight = height();
        int i3 = iMo265t / 2;
        int i4 = iHeight / 2;
        float fE = C0634xm.e(this.aD, this.aE, f2);
        C0040bk.a(guiGraphics, this.hI, (int) (this.hJ - this.a.k(f2)), iMo265t, iHeight);
        C0040bk.c(poseStack, guiGraphics, this.cg, this.hI + i3, this.hJ + i4, iMo265t, (int) ((iMo265t / 640.0f) * 360.0f), 1.0f + (0.1f * fE), 0.25f);
        guiGraphics.disableScissor();
        boolean zD = D();
        if (fE > 0.0f) {
            C0040bk.a(guiGraphics, this.hI, this.hJ, iMo265t, iHeight, -1, 0.12f * fE);
        }
        if (zD) {
            if (!this.bN) {
                this.bN = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pq.get(), 1.0f));
            }
        } else {
            this.bN = false;
        }
        C0040bk.a(guiGraphics, this.hI, this.hJ, 2, iHeight, this.b.result().getColor());
        C0040bk.a(guiGraphics, this.hI, this.hJ + (iHeight - 1), iMo265t, 1, hD);
        sW sWVarA = sW.a(this.b.gameMode().getId());
        float f3 = this.hI + 7 + 8.0f;
        float f4 = this.hJ + i4;
        if (sWVarA != null) {
            C0040bk.b(poseStack, guiGraphics, sWVarA.getIconTexture(), f3, f4, 16.0f, 16.0f);
        }
        int i5 = this.hI + 7 + 16 + 6;
        C0040bk.a(poseStack, font, guiGraphics, (Component) Component.literal(this.b.mapName().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD).withColor(-1), i5, this.hJ + 6);
        C0040bk.a(poseStack, font, guiGraphics, (Component) Component.empty().append(C0637xp.p(sWVarA != null ? sWVarA.getDisplayName().getString() : this.b.gameMode().getId())).withColor(ColorReferences.COLOR_STOPWATCH_SOLID), i5, this.hJ + 15);
        int i6 = ((this.hI + iMo265t) - 7) - 32;
        C0040bk.c(font, guiGraphics, a(this.b.result()), i6, this.hJ + 5);
        C0040bk.c(font, guiGraphics, (Component) Component.literal(TimeFormatUtils.formatRelativeTime(this.b.endedAtEpochMillis())).withColor(hC), i6, this.hJ + 16);
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull fV fVVar, @NotNull Font font, int i, int i2, float f, float f2) {
        super.b(poseStack, minecraft, c0297l, guiGraphics, fVVar, font, i, i2, f, f2);
        if (D()) {
            guiGraphics.renderComponentTooltip(font, a(this.b), i, i2);
        }
    }

    @NotNull
    public static List<Component> a(@NotNull MatchSummary matchSummary) {
        sW sWVarA = sW.a(matchSummary.gameMode().getId());
        Component displayName = sWVarA != null ? sWVarA.getDisplayName() : Component.literal(matchSummary.gameMode().getId());
        MutableComponent mutableComponentWithColor = Component.literal(matchSummary.mapName().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD).withColor(-1);
        MutableComponent mutableComponentWithColor2 = Component.empty().append(C0637xp.p(sWVarA != null ? sWVarA.getDisplayName().getString() : matchSummary.gameMode().getId())).withColor(ColorReferences.COLOR_STOPWATCH_SOLID);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(mutableComponentWithColor);
        objectArrayList.add(mutableComponentWithColor2);
        objectArrayList.add(Component.empty());
        objectArrayList.add(a("bf.message.matches.detail.result", a(matchSummary.result())));
        String strPlayerTeam = matchSummary.playerTeam();
        if (strPlayerTeam != null) {
            objectArrayList.add(a("bf.message.matches.detail.team", Component.literal(strPlayerTeam).withStyle(ChatFormatting.WHITE)));
        }
        objectArrayList.add(Component.empty());
        objectArrayList.add(a("bf.message.matches.detail.kills", Component.literal(String.valueOf(matchSummary.kills())).withColor(dF.b.KILLS.getColor())));
        objectArrayList.add(a("bf.message.matches.detail.deaths", Component.literal(String.valueOf(matchSummary.deaths())).withColor(dF.b.DEATHS.getColor())));
        objectArrayList.add(a("bf.message.matches.detail.assists", Component.literal(String.valueOf(matchSummary.assists())).withColor(dF.b.KD.getColor())));
        objectArrayList.add(a("bf.message.matches.detail.score", Component.literal(String.valueOf(matchSummary.score())).withColor(dF.b.SCORE.getColor())));
        objectArrayList.add(Component.empty());
        if (matchSummary.placement() > 0) {
            objectArrayList.add(a("bf.message.matches.detail.placement", Component.literal("#" + matchSummary.placement()).withColor(-1)));
        }
        objectArrayList.add(a("bf.message.matches.detail.played", Component.literal(TimeFormatUtils.formatRelativeTime(matchSummary.endedAtEpochMillis())).withColor(-1)));
        if (matchSummary.durationSeconds() > 0) {
            objectArrayList.add(a("bf.message.matches.detail.duration", Component.literal(TimeFormatUtils.formatDuration(matchSummary.durationSeconds())).withColor(-1)));
        }
        return objectArrayList;
    }

    @NotNull
    private static Component a(@NotNull String str, @NotNull Component component) {
        return Component.translatable(str).withColor(hB).append(Component.literal(": ").withColor(hB)).append(component);
    }

    @NotNull
    private static Component a(@NotNull MatchResult matchResult) {
        return Component.translatable("bf.message.matches.result." + matchResult.getId()).withColor(matchResult.getColor()).withStyle(ChatFormatting.BOLD);
    }
}
