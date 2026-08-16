package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.report.MatchResult;
import com.boehmod.bflib.cloud.common.p001mm.report.MatchSummary;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.bflib.common.util.TimeFormatUtils;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.eq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eq.class */
public final class C0295eq extends AbstractC0298et {

    /* JADX INFO: renamed from: iN */
    private static final int f2306iN = -1;

    /* JADX INFO: renamed from: iO */
    private static final int f2307iO = -5592406;

    /* JADX INFO: renamed from: iP */
    private static final int f2308iP = -7829368;

    /* JADX INFO: renamed from: iQ */
    private static final int f2309iQ = 1090519039;

    /* JADX INFO: renamed from: Z */
    private static final String f2310Z = "bf.message.matches.detail.";

    /* JADX INFO: renamed from: ed */
    private static final float f2311ed = 0.25f;

    /* JADX INFO: renamed from: iR */
    public static final int f2312iR = 640;

    /* JADX INFO: renamed from: iS */
    public static final int f2313iS = 360;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final MatchSummary f2314b;

    /* JADX INFO: renamed from: ce */
    @NotNull
    private final ResourceLocation f2315ce;

    /* JADX INFO: renamed from: aI */
    private float f2317aI;

    /* JADX INFO: renamed from: bU */
    private boolean f2316bU = false;

    /* JADX INFO: renamed from: aJ */
    private float f2318aJ = 0.0f;

    public C0295eq(@NotNull MatchSummary matchSummary) {
        this.f2314b = matchSummary;
        this.f2315ce = C0532jO.m2378d("textures/gui/maps/" + this.f2314b.mapName().toLowerCase(Locale.ROOT) + "_" + this.f2314b.environment().toLowerCase(Locale.ROOT) + ".png");
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: o */
    public void mo864o(@NotNull Minecraft minecraft) {
        this.f2318aJ = this.f2317aI;
        this.f2317aI = Mth.lerp(0.75f, this.f2317aI, m1615E() ? 1.0f : 0.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: w */
    public boolean mo865w() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    public int height() {
        return 30;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: x */
    public int mo866x() {
        return this.f2338a.m374x() - 15;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: ab */
    public int mo1561ab() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: U */
    public int mo1248U() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        super.mo854a(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
        int iMo866x = mo866x();
        int iHeight = height();
        int i3 = iMo866x / 2;
        int i4 = iHeight / 2;
        float fM7170f = C1270xJ.m7170f(this.f2317aI, this.f2318aJ, f2);
        C0129bt.m618a(guiGraphics, this.f2339iY, (int) (this.f2340iZ - this.f2338a.mo1572j(f2)), iMo866x, iHeight);
        C0129bt.m549c(poseStack, guiGraphics, this.f2315ce, this.f2339iY + i3, this.f2340iZ + i4, iMo866x, (int) ((iMo866x / 640.0f) * 360.0f), 1.0f + (0.1f * fM7170f), 0.25f);
        guiGraphics.disableScissor();
        boolean zE = m1615E();
        if (fM7170f > 0.0f) {
            C0129bt.m517a(guiGraphics, this.f2339iY, this.f2340iZ, iMo866x, iHeight, -1, 0.12f * fM7170f);
        }
        if (zE) {
            if (!this.f2316bU) {
                this.f2316bU = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), 1.0f));
            }
        } else {
            this.f2316bU = false;
        }
        C0129bt.m515a(guiGraphics, this.f2339iY, this.f2340iZ, 2, iHeight, this.f2314b.result().getColor());
        C0129bt.m515a(guiGraphics, this.f2339iY, this.f2340iZ + (iHeight - 1), iMo866x, 1, f2309iQ);
        C1094tt c1094ttM6019a = C1094tt.m6019a(this.f2314b.gameMode().getId());
        float f3 = this.f2339iY + 7 + 8.0f;
        float f4 = this.f2340iZ + i4;
        if (c1094ttM6019a != null) {
            C0129bt.m540b(poseStack, guiGraphics, c1094ttM6019a.getIconTexture(), f3, f4, 16.0f, 16.0f);
        }
        int i5 = this.f2339iY + 7 + 16 + 6;
        C0129bt.m468a(poseStack, font, guiGraphics, (Component) Component.literal(this.f2314b.mapName().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD).withColor(-1), i5, this.f2340iZ + 6);
        C0129bt.m468a(poseStack, font, guiGraphics, (Component) Component.empty().append(C1273xM.m7244p(c1094ttM6019a != null ? c1094ttM6019a.getDisplayName().getString() : this.f2314b.gameMode().getId())).withColor(ColorReferences.COLOR_STOPWATCH_SOLID), i5, this.f2340iZ + 15);
        int i6 = ((this.f2339iY + iMo866x) - 7) - 32;
        C0129bt.m483c(font, guiGraphics, m1609a(this.f2314b.result()), i6, this.f2340iZ + 5);
        C0129bt.m483c(font, guiGraphics, (Component) Component.literal(TimeFormatUtils.formatRelativeTime(this.f2314b.endedAtEpochMillis())).withColor(f2308iP), i6, this.f2340iZ + 16);
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: b */
    public void mo1591b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        super.mo1591b(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
        if (m1615E()) {
            guiGraphics.renderComponentTooltip(font, m1607a(this.f2314b), i, i2);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static List<Component> m1607a(@NotNull MatchSummary matchSummary) {
        C1094tt c1094ttM6019a = C1094tt.m6019a(matchSummary.gameMode().getId());
        Component displayName = c1094ttM6019a != null ? c1094ttM6019a.getDisplayName() : Component.literal(matchSummary.gameMode().getId());
        MutableComponent mutableComponentWithColor = Component.literal(matchSummary.mapName().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD).withColor(-1);
        MutableComponent mutableComponentWithColor2 = Component.empty().append(C1273xM.m7244p(c1094ttM6019a != null ? c1094ttM6019a.getDisplayName().getString() : matchSummary.gameMode().getId())).withColor(ColorReferences.COLOR_STOPWATCH_SOLID);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(mutableComponentWithColor);
        objectArrayList.add(mutableComponentWithColor2);
        objectArrayList.add(Component.empty());
        objectArrayList.add(m1608a("bf.message.matches.detail.result", m1609a(matchSummary.result())));
        String strPlayerTeam = matchSummary.playerTeam();
        if (strPlayerTeam != null) {
            objectArrayList.add(m1608a("bf.message.matches.detail.team", Component.literal(strPlayerTeam).withStyle(ChatFormatting.WHITE)));
        }
        objectArrayList.add(Component.empty());
        objectArrayList.add(m1608a("bf.message.matches.detail.kills", Component.literal(String.valueOf(matchSummary.kills())).withColor(C0216dQ.b.KILLS.getColor())));
        objectArrayList.add(m1608a("bf.message.matches.detail.deaths", Component.literal(String.valueOf(matchSummary.deaths())).withColor(C0216dQ.b.DEATHS.getColor())));
        objectArrayList.add(m1608a("bf.message.matches.detail.assists", Component.literal(String.valueOf(matchSummary.assists())).withColor(C0216dQ.b.KD.getColor())));
        objectArrayList.add(m1608a("bf.message.matches.detail.score", Component.literal(String.valueOf(matchSummary.score())).withColor(C0216dQ.b.SCORE.getColor())));
        objectArrayList.add(Component.empty());
        if (matchSummary.placement() > 0) {
            objectArrayList.add(m1608a("bf.message.matches.detail.placement", Component.literal("#" + matchSummary.placement()).withColor(-1)));
        }
        objectArrayList.add(m1608a("bf.message.matches.detail.played", Component.literal(TimeFormatUtils.formatRelativeTime(matchSummary.endedAtEpochMillis())).withColor(-1)));
        if (matchSummary.durationSeconds() > 0) {
            objectArrayList.add(m1608a("bf.message.matches.detail.duration", Component.literal(TimeFormatUtils.formatDuration(matchSummary.durationSeconds())).withColor(-1)));
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m1608a(@NotNull String str, @NotNull Component component) {
        return Component.translatable(str).withColor(f2307iO).append(Component.literal(": ").withColor(f2307iO)).append(component);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m1609a(@NotNull MatchResult matchResult) {
        return Component.translatable("bf.message.matches.result." + matchResult.getId()).withColor(matchResult.getColor()).withStyle(ChatFormatting.BOLD);
    }
}
