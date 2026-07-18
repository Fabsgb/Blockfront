package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import com.boehmod.blockfront.C0279eb;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cA.class */
public final class C0136cA extends AbstractC0193cv {

    /* JADX INFO: renamed from: bm */
    private static final Component f985bm = Component.translatable("bf.message.okay");

    /* JADX INFO: renamed from: bn */
    private static final Component f986bn = Component.translatable("bf.cloud.popup.discord.button");

    /* JADX INFO: renamed from: bo */
    private static final Component f987bo = Component.translatable("bf.cloud.popup.discord.button.tip", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: bp */
    private static final Component f988bp = Component.translatable("bf.dropdown.text.my.options").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bq */
    private static final Component f989bq = Component.translatable("bf.screen.overlay.settings");

    /* JADX INFO: renamed from: br */
    private static final Component f990br = Component.translatable("bf.menu.button.modsettings").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bs */
    private static final Component f991bs = Component.translatable("bf.menu.button.modsettings.tip", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: bt */
    private static final Component f992bt = Component.translatable("bf.menu.button.minecraftsettings").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bu */
    private static final Component f993bu = Component.translatable("bf.menu.button.minecraftsettings.tip");

    /* JADX INFO: renamed from: bv */
    private static final Component f994bv = Component.translatable("bf.menu.button.nav.text.staff.punish").withStyle(C0565jw.f3201b).withStyle(ChatFormatting.BLUE);

    /* JADX INFO: renamed from: bw */
    private static final Component f995bw = Component.translatable("bf.message.ingame.punish.tip");

    /* JADX INFO: renamed from: bx */
    private static final Component f996bx = Component.literal("#players").withStyle(C0565jw.f3202c);

    /* JADX INFO: renamed from: by */
    private static final Component f997by = Component.translatable("bf.screen.report.discord.message", new Object[]{f996bx});

    /* JADX INFO: renamed from: bz */
    private static final Component f998bz = Component.translatable("bf.screen.report.discord.title");

    /* JADX INFO: renamed from: bA */
    private static final Component f999bA = Component.translatable("bf.menu.button.report.player.tip");

    /* JADX INFO: renamed from: bB */
    private static final Component f1000bB = Component.translatable("bf.menu.button.support").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bC */
    private static final Component f1001bC = Component.translatable("bf.menu.button.support.tip");

    /* JADX INFO: renamed from: bD */
    private static final Component f1002bD = Component.translatable("bf.menu.button.credits").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bE */
    private static final Component f1003bE = Component.translatable("bf.menu.button.credits.tip");

    /* JADX INFO: renamed from: bF */
    private static final Component f1004bF = Component.translatable("bf.menu.button.rules").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bG */
    private static final Component f1005bG = Component.translatable("bf.menu.button.rules.tip");

    /* JADX INFO: renamed from: bH */
    private static final Component f1006bH = Component.translatable("bf.menu.button.discord").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bI */
    private static final Component f1007bI = Component.translatable("bf.menu.button.discord.tip").withColor(ColorReferences.COLOR_THEME_RED).withColor(ColorReferences.COLOR_THEME_DISCORD);

    /* JADX INFO: renamed from: bJ */
    private static final Component f1008bJ = Component.translatable("bf.menu.button.exit").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bK */
    private static final Component f1009bK = Component.translatable("bf.menu.button.exit.tip").withColor(ColorReferences.COLOR_THEME_RED);

    /* JADX INFO: renamed from: bL */
    private static final Component f1010bL = Component.translatable("bf.menu.button.exit.prompt");

    /* JADX INFO: renamed from: bM */
    private static final Component f1011bM = Component.translatable("bf.menu.button.exit.prompt.title");

    /* JADX INFO: renamed from: bN */
    private static final Component f1012bN = Component.translatable("bf.menu.button.report.player").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bO */
    private static final Component f1013bO = Component.translatable("bf.menu.button.play.online").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bP */
    private static final Component f1014bP = Component.translatable("bf.menu.button.play.online.tip", new Object[]{C0029a.f246a}).withColor(ColorReferences.COLOR_TEAM_ALLIES_SOLID);

    /* JADX INFO: renamed from: bQ */
    private static final Component f1015bQ = Component.translatable("bf.menu.button.play.offline").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bR */
    private static final Component f1016bR = Component.translatable("bf.menu.button.play.offline.tip", new Object[]{C0029a.f246a}).withColor(ColorReferences.COLOR_TEAM_ALLIES_SOLID);

    public C0136cA(Screen screen, boolean z) {
        super(screen, f989bq, z);
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv
    /* JADX INFO: renamed from: a */
    public void mo743a(@NotNull GuiGraphics guiGraphics, float f) {
        super.mo743a(guiGraphics, f);
        int i = this.width / 4;
        int i2 = this.width - i;
        PoseStack poseStackPose = guiGraphics.pose();
        C0119bk.m491c(guiGraphics, i2, 0, i, this.height, C0119bk.m365p());
        C0119bk.m496a(this.f1585a, guiGraphics, this.font, this.f1587b.getUser().getProfileId(), C0279eb.b.FRIEND, i2, 12, 20, false);
        C0119bk.m485a(this.f1587b, this.f1586e, poseStackPose, guiGraphics, this.f1587b.getGameProfile(), (i2 + (i - 18)) - 4, 14.0f, 18);
        C0119bk.m383c(this.font, guiGraphics, f988bp, i2 + (i / 2), 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv
    /* JADX INFO: renamed from: a */
    public boolean mo344a(double d, double d2) {
        return d <= ((double) this.width) * 0.75d;
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv, com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        int i;
        super.mo744G();
        C0482iS c0482iSM1676a = this.f1585a.m1676a(this.f1587b);
        int i2 = this.width / 4;
        int i3 = this.width - i2;
        int i4 = i2 - 4;
        addRenderableWidget(new C0127bs(i3 + 4, 40, i4, 18, f990br, button -> {
            this.f1587b.setScreen(new C0219dU(this));
        }).m651a(f991bs).m652a(C0127bs.b.LEFT));
        int i5 = 40 + 20;
        addRenderableWidget(new C0127bs(i3 + 4, i5, i4, 18, f992bt, button2 -> {
            this.f1587b.setScreen(new OptionsScreen(this, this.f1587b.options));
        }).m651a(f993bu).m652a(C0127bs.b.LEFT));
        if (c0482iSM1676a.m2189j(GroupPermissions.PERMISSION_STAFF_PUNISH)) {
            i = i5 + 20;
            addRenderableWidget(new C0127bs(i3 + 4, i, i4, 18, f994bv, button3 -> {
                this.f1587b.setScreen(new C0153cR(this));
            }).m651a(f995bw).m652a(C0127bs.b.LEFT));
        } else {
            i = i5 + 20;
            addRenderableWidget(new C0127bs(i3 + 4, i, i4, 18, f1012bN, button4 -> {
                C0622l.m2668a(f998bz, f997by, PopupType.DISCORD_LINK, new C0121bm(f985bm, null, button4 -> {
                    this.f1587b.setScreen(this);
                }), new C0121bm(f986bn, f987bo, button5 -> {
                    C0234dj.m1186b(this.f1587b, C0560jr.f3182aB);
                }));
            }).m638a(ColorReferences.COLOR_THEME_RED).m640b(ColorReferences.COLOR_WHITE).m651a(f999bA).m652a(C0127bs.b.LEFT));
        }
        int i6 = i + 20;
        addRenderableWidget(new C0127bs(i3 + 4, i6, i4, 18, f1000bB, button5 -> {
        }).m651a(f1001bC).m652a(C0127bs.b.LEFT));
        int i7 = i6 + 20;
        addRenderableWidget(new C0127bs(i3 + 4, i7, i4, 18, f1002bD, button6 -> {
            this.f1587b.setScreen(new C0139cD());
        }).m651a(f1003bE).m652a(C0127bs.b.LEFT));
        int i8 = i7 + 20;
        addRenderableWidget(new C0127bs(i3 + 4, i8, i4, 18, f1004bF, button7 -> {
            C0234dj.m1186b(this.f1587b, C0560jr.f3185aE);
        }).m651a(f1005bG).m652a(C0127bs.b.LEFT));
        EnumC0410h enumC0410hM1716a = ((C0357g) this.f1586e.m2667b()).m1716a();
        if (enumC0410hM1716a == EnumC0410h.OFFLINE) {
            i8 += 20;
            addRenderableWidget(new C0127bs(i3 + 4, i8, i4, 18, f1013bO, button8 -> {
                ((C0357g) this.f1586e.m2667b()).m1717a(EnumC0410h.UNDECIDED);
                this.f1587b.setScreen(new C0230df());
            }).m660e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m666f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m640b(ColorReferences.COLOR_WHITE).m651a(f1014bP).m652a(C0127bs.b.LEFT));
        }
        if (enumC0410hM1716a == EnumC0410h.ONLINE) {
            i8 += 20;
            addRenderableWidget(new C0127bs(i3 + 4, i8, i4, 18, f1015bQ, button9 -> {
                C0357g c0357g = (C0357g) this.f1586e.m2667b();
                c0357g.m1717a(EnumC0410h.UNDECIDED);
                c0357g.disconnect("User requested disconnect", false);
                this.f1587b.setScreen(new C0230df());
            }).m660e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m666f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m640b(ColorReferences.COLOR_WHITE).m651a(f1016bR).m652a(C0127bs.b.LEFT));
        }
        int i9 = i8 + 20;
        addRenderableWidget(new C0127bs(i3 + 4, i9, i4, 18, f1006bH, button10 -> {
            C0234dj.m1186b(this.f1587b, C0560jr.f3182aB);
        }).m660e(ColorReferences.COLOR_THEME_DISCORD_SOLID).m666f(ColorReferences.COLOR_THEME_DISCORD_HOVERED_SOLID).m640b(ColorReferences.COLOR_WHITE).m651a(f1007bI).m652a(C0127bs.b.LEFT));
        addRenderableWidget(new C0127bs(i3 + 4, i9 + 20, i4, 18, f1008bJ, button11 -> {
            C0218dT c0218dT = new C0218dT(this, f1011bM, z -> {
                if (z) {
                    this.f1587b.stop();
                }
            });
            c0218dT.m1273a(f1010bL);
            this.f1587b.setScreen(c0218dT);
        }).m660e(ColorReferences.COLOR_THEME_RED_SOLID).m666f(ColorReferences.COLOR_THEME_RED_HOVERED_SOLID).m638a(ColorReferences.COLOR_WHITE).m640b(ColorReferences.COLOR_WHITE).m651a(f1009bK).m652a(C0127bs.b.LEFT));
    }
}
