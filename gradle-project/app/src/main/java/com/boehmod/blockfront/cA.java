package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.boehmod.blockfront.C0111eb;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cA.class */
public final class cA extends AbstractC0078cv {
    private static final Component bm = Component.translatable("bf.message.okay");
    private static final Component bn = Component.translatable("bf.cloud.popup.discord.button");
    private static final Component bo = Component.translatable("bf.cloud.popup.discord.button.tip", new Object[]{C0002a.a});
    private static final Component bp = Component.translatable("bf.dropdown.text.my.options").withStyle(C0266jw.b);
    private static final Component bq = Component.translatable("bf.screen.overlay.settings");
    private static final Component br = Component.translatable("bf.menu.button.modsettings").withStyle(C0266jw.b);
    private static final Component bs = Component.translatable("bf.menu.button.modsettings.tip", new Object[]{C0002a.a});
    private static final Component bt = Component.translatable("bf.menu.button.minecraftsettings").withStyle(C0266jw.b);
    private static final Component bu = Component.translatable("bf.menu.button.minecraftsettings.tip");
    private static final Component bv = Component.translatable("bf.menu.button.nav.text.staff.punish").withStyle(C0266jw.b).withStyle(ChatFormatting.BLUE);
    private static final Component bw = Component.translatable("bf.message.ingame.punish.tip");
    private static final Component bx = Component.literal("#players").withStyle(C0266jw.c);
    private static final Component by = Component.translatable("bf.screen.report.discord.message", new Object[]{bx});
    private static final Component bz = Component.translatable("bf.screen.report.discord.title");
    private static final Component bA = Component.translatable("bf.menu.button.report.player.tip");
    private static final Component bB = Component.translatable("bf.menu.button.support").withStyle(C0266jw.b);
    private static final Component bC = Component.translatable("bf.menu.button.support.tip");
    private static final Component bD = Component.translatable("bf.menu.button.credits").withStyle(C0266jw.b);
    private static final Component bE = Component.translatable("bf.menu.button.credits.tip");
    private static final Component bF = Component.translatable("bf.menu.button.rules").withStyle(C0266jw.b);
    private static final Component bG = Component.translatable("bf.menu.button.rules.tip");
    private static final Component bH = Component.translatable("bf.menu.button.discord").withStyle(C0266jw.b);
    private static final Component bI = Component.translatable("bf.menu.button.discord.tip").withColor(ColorReferences.COLOR_THEME_RED).withColor(ColorReferences.COLOR_THEME_DISCORD);
    private static final Component bJ = Component.translatable("bf.menu.button.exit").withStyle(C0266jw.b);
    private static final Component bK = Component.translatable("bf.menu.button.exit.tip").withColor(ColorReferences.COLOR_THEME_RED);
    private static final Component bL = Component.translatable("bf.menu.button.exit.prompt");
    private static final Component bM = Component.translatable("bf.menu.button.exit.prompt.title");
    private static final Component bN = Component.translatable("bf.menu.button.report.player").withStyle(C0266jw.b);
    private static final Component bO = Component.translatable("bf.menu.button.play.online").withStyle(C0266jw.b);
    private static final Component bP = Component.translatable("bf.menu.button.play.online.tip", new Object[]{C0002a.a}).withColor(ColorReferences.COLOR_TEAM_ALLIES_SOLID);
    private static final Component bQ = Component.translatable("bf.menu.button.play.offline").withStyle(C0266jw.b);
    private static final Component bR = Component.translatable("bf.menu.button.play.offline.tip", new Object[]{C0002a.a}).withColor(ColorReferences.COLOR_TEAM_ALLIES_SOLID);

    public cA(Screen screen, boolean z) {
        super(screen, bq, z);
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv
    public void a(@NotNull GuiGraphics guiGraphics, float f) {
        super.a(guiGraphics, f);
        int i = this.width / 4;
        int i2 = this.width - i;
        PoseStack poseStackPose = guiGraphics.pose();
        C0040bk.c(guiGraphics, i2, 0, i, this.height, C0040bk.p());
        C0040bk.a(this.a, guiGraphics, this.font, this.b.getUser().getProfileId(), C0111eb.b.FRIEND, i2, 12, 20, false);
        C0040bk.a(this.b, this.e, poseStackPose, guiGraphics, this.b.getGameProfile(), (i2 + (i - 18)) - 4, 14.0f, 18);
        C0040bk.c(this.font, guiGraphics, bp, i2 + (i / 2), 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv
    public boolean a(double d, double d2) {
        return d <= ((double) this.width) * 0.75d;
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv, com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        int i;
        super.mo280G();
        iS iSVarM404a = this.a.m404a(this.b);
        int i2 = this.width / 4;
        int i3 = this.width - i2;
        int i4 = i2 - 4;
        addRenderableWidget(new C0048bs(i3 + 4, 40, i4, 18, br, button -> {
            this.b.setScreen(new dU(this));
        }).a(bs).a(C0048bs.b.LEFT));
        int i5 = 40 + 20;
        addRenderableWidget(new C0048bs(i3 + 4, i5, i4, 18, bt, button2 -> {
            this.b.setScreen(new OptionsScreen(this, this.b.options));
        }).a(bu).a(C0048bs.b.LEFT));
        if (iSVarM404a.j(GroupPermissions.PERMISSION_STAFF_PUNISH)) {
            i = i5 + 20;
            addRenderableWidget(new C0048bs(i3 + 4, i, i4, 18, bv, button3 -> {
                this.b.setScreen(new cR(this));
            }).a(bw).a(C0048bs.b.LEFT));
        } else {
            i = i5 + 20;
            addRenderableWidget(new C0048bs(i3 + 4, i, i4, 18, bN, button4 -> {
                C0297l.a(bz, by, PopupType.DISCORD_LINK, new C0042bm(bm, null, button4 -> {
                    this.b.setScreen(this);
                }), new C0042bm(bn, bo, button5 -> {
                    C0093dj.b(this.b, C0261jr.aB);
                }));
            }).a(ColorReferences.COLOR_THEME_RED).b(ColorReferences.COLOR_WHITE).a(bA).a(C0048bs.b.LEFT));
        }
        int i6 = i + 20;
        addRenderableWidget(new C0048bs(i3 + 4, i6, i4, 18, bB, button5 -> {
        }).a(bC).a(C0048bs.b.LEFT));
        int i7 = i6 + 20;
        addRenderableWidget(new C0048bs(i3 + 4, i7, i4, 18, bD, button6 -> {
            this.b.setScreen(new cD());
        }).a(bE).a(C0048bs.b.LEFT));
        int i8 = i7 + 20;
        addRenderableWidget(new C0048bs(i3 + 4, i8, i4, 18, bF, button7 -> {
            C0093dj.b(this.b, C0261jr.aE);
        }).a(bG).a(C0048bs.b.LEFT));
        EnumC0190h enumC0190hA = ((C0163g) this.e.b()).a();
        if (enumC0190hA == EnumC0190h.OFFLINE) {
            i8 += 20;
            addRenderableWidget(new C0048bs(i3 + 4, i8, i4, 18, bO, button8 -> {
                ((C0163g) this.e.b()).a(EnumC0190h.UNDECIDED);
                this.b.setScreen(new C0089df());
            }).e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).b(ColorReferences.COLOR_WHITE).a(bP).a(C0048bs.b.LEFT));
        }
        if (enumC0190hA == EnumC0190h.ONLINE) {
            i8 += 20;
            addRenderableWidget(new C0048bs(i3 + 4, i8, i4, 18, bQ, button9 -> {
                C0163g c0163g = (C0163g) this.e.b();
                c0163g.a(EnumC0190h.UNDECIDED);
                c0163g.disconnect("User requested disconnect", false);
                this.b.setScreen(new C0089df());
            }).e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).b(ColorReferences.COLOR_WHITE).a(bR).a(C0048bs.b.LEFT));
        }
        int i9 = i8 + 20;
        addRenderableWidget(new C0048bs(i3 + 4, i9, i4, 18, bH, button10 -> {
            C0093dj.b(this.b, C0261jr.aB);
        }).e(ColorReferences.COLOR_THEME_DISCORD_SOLID).f(ColorReferences.COLOR_THEME_DISCORD_HOVERED_SOLID).b(ColorReferences.COLOR_WHITE).a(bI).a(C0048bs.b.LEFT));
        addRenderableWidget(new C0048bs(i3 + 4, i9 + 20, i4, 18, bJ, button11 -> {
            dT dTVar = new dT(this, bM, z -> {
                if (z) {
                    this.b.stop();
                }
            });
            dTVar.a(bL);
            this.b.setScreen(dTVar);
        }).e(ColorReferences.COLOR_THEME_RED_SOLID).f(ColorReferences.COLOR_THEME_RED_HOVERED_SOLID).a(ColorReferences.COLOR_WHITE).b(ColorReferences.COLOR_WHITE).a(bK).a(C0048bs.b.LEFT));
    }
}
