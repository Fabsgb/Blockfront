package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordLinkRequest;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cJ.class */
public final class C0146cJ extends AbstractC0141cE {

    /* JADX INFO: renamed from: bo */
    private static final Component f1075bo = Component.translatable("bf.message.okay");

    /* JADX INFO: renamed from: bp */
    private static final Component f1076bp = Component.translatable("bf.cloud.popup.discord.button");

    /* JADX INFO: renamed from: bq */
    private static final Component f1077bq = Component.translatable("bf.cloud.popup.discord.button.tip", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: br */
    private static final Component f1078br = Component.translatable("bf.dropdown.text.my.options").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bs */
    private static final Component f1079bs = Component.translatable("bf.screen.overlay.settings");

    /* JADX INFO: renamed from: bt */
    private static final Component f1080bt = Component.translatable("bf.menu.button.modsettings").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bu */
    private static final Component f1081bu = Component.translatable("bf.menu.button.modsettings.tip", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: bv */
    private static final Component f1082bv = Component.translatable("bf.menu.button.minecraftsettings").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bw */
    private static final Component f1083bw = Component.translatable("bf.menu.button.minecraftsettings.tip");

    /* JADX INFO: renamed from: bx */
    private static final Component f1084bx = Component.translatable("bf.menu.button.nav.text.staff.punish").withStyle(C0533jP.f3185b).withStyle(ChatFormatting.BLUE);

    /* JADX INFO: renamed from: by */
    private static final Component f1085by = Component.translatable("bf.message.ingame.punish.tip");

    /* JADX INFO: renamed from: bz */
    private static final Component f1086bz = Component.literal("#players").withStyle(C0533jP.f3186c);

    /* JADX INFO: renamed from: bA */
    private static final Component f1087bA = Component.translatable("bf.screen.report.discord.message", new Object[]{f1086bz});

    /* JADX INFO: renamed from: bB */
    private static final Component f1088bB = Component.translatable("bf.screen.report.discord.title");

    /* JADX INFO: renamed from: bC */
    private static final Component f1089bC = Component.translatable("bf.menu.button.report.player.tip");

    /* JADX INFO: renamed from: bD */
    private static final Component f1090bD = Component.translatable("bf.menu.button.support").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bE */
    private static final Component f1091bE = Component.translatable("bf.menu.button.support.tip");

    /* JADX INFO: renamed from: bF */
    private static final Component f1092bF = Component.translatable("bf.menu.button.credits").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bG */
    private static final Component f1093bG = Component.translatable("bf.menu.button.credits.tip");

    /* JADX INFO: renamed from: bH */
    private static final Component f1094bH = Component.translatable("bf.menu.button.rules").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bI */
    private static final Component f1095bI = Component.translatable("bf.menu.button.rules.tip");

    /* JADX INFO: renamed from: bJ */
    private static final Component f1096bJ = Component.translatable("bf.menu.button.discord").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bK */
    private static final Component f1097bK = Component.translatable("bf.menu.button.discord.tip").withColor(ColorReferences.COLOR_THEME_RED).withColor(ColorReferences.COLOR_THEME_DISCORD);

    /* JADX INFO: renamed from: bL */
    private static final Component f1098bL = Component.translatable("bf.menu.button.exit").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bM */
    private static final Component f1099bM = Component.translatable("bf.menu.button.exit.tip").withColor(ColorReferences.COLOR_THEME_RED);

    /* JADX INFO: renamed from: bN */
    private static final Component f1100bN = Component.translatable("bf.menu.button.exit.prompt");

    /* JADX INFO: renamed from: bO */
    private static final Component f1101bO = Component.translatable("bf.menu.button.exit.prompt.title");

    /* JADX INFO: renamed from: bP */
    private static final Component f1102bP = Component.translatable("bf.menu.button.report.player").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bQ */
    private static final Component f1103bQ = Component.translatable("bf.menu.button.play.online").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bR */
    private static final Component f1104bR = Component.translatable("bf.menu.button.play.online.tip", new Object[]{C0030a.f263a}).withColor(ColorReferences.COLOR_TEAM_ALLIES_SOLID);

    /* JADX INFO: renamed from: bS */
    private static final Component f1105bS = Component.translatable("bf.menu.button.play.offline").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bT */
    private static final Component f1106bT = Component.translatable("bf.menu.button.play.offline.tip", new Object[]{C0030a.f263a}).withColor(ColorReferences.COLOR_TEAM_ALLIES_SOLID);

    public C0146cJ(Screen screen) {
        super(screen, f1079bs);
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF
    /* JADX INFO: renamed from: a */
    public void mo775a(@NotNull GuiGraphics guiGraphics, float f) {
        super.mo775a(guiGraphics, f);
        int i = this.width / 4;
        int i2 = this.width - i;
        PoseStack poseStackPose = guiGraphics.pose();
        C0129bt.m591c(guiGraphics, i2, 0, i, this.height, C0129bt.m465t());
        C0129bt.m596a(this.f1056a, guiGraphics, this.font, this.f1058a.getUser().getProfileId(), C0292en.b.FRIEND, i2, 12, 20, false);
        C0129bt.m585a(this.f1058a, this.f1057f, poseStackPose, guiGraphics, this.f1058a.getGameProfile(), (i2 + (i - 18)) - 4, 14.0f, 18);
        C0129bt.m483c(this.font, guiGraphics, f1078br, i2 + (i / 2), 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0141cE
    /* JADX INFO: renamed from: a */
    public boolean mo437a(double d, double d2) {
        return d <= ((double) this.width) * 0.75d;
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        int i;
        super.mo776K();
        C0555jl c0555jlM1886a = this.f1056a.m1886a(this.f1058a);
        int i2 = this.width / 4;
        int i3 = this.width - i2;
        int i4 = i2 - 4;
        addRenderableWidget(new C0085bB(i3 + 4, 40, i4, 18, f1080bt, button -> {
            this.f1058a.setScreen(new C0284ef(this));
        }).m326a(f1081bu).m327a(C0085bB.b.LEFT));
        int i5 = 40 + 20;
        addRenderableWidget(new C0085bB(i3 + 4, i5, i4, 18, f1082bv, button2 -> {
            this.f1058a.setScreen(new OptionsScreen(this, this.f1058a.options));
        }).m326a(f1083bw).m327a(C0085bB.b.LEFT));
        if (c0555jlM1886a.m2516l(GroupPermissions.PERMISSION_STAFF_PUNISH)) {
            i = i5 + 20;
            addRenderableWidget(new C0085bB(i3 + 4, i, i4, 18, f1084bx, button3 -> {
                this.f1058a.setScreen(new C0226da(this));
            }).m326a(f1085by).m327a(C0085bB.b.LEFT));
        } else {
            i = i5 + 20;
            addRenderableWidget(new C0085bB(i3 + 4, i, i4, 18, f1102bP, button4 -> {
                C0623l.m2853a(f1088bB, f1087bA, PopupType.DISCORD_LINK, new C0131bv(f1075bo, null, button4 -> {
                    this.f1058a.setScreen(this);
                }), new C0131bv(f1076bp, f1077bq, button5 -> {
                    C0244ds.m784b(this.f1058a, C0528jK.f3165aH);
                }));
            }).m313a(ColorReferences.COLOR_THEME_RED).m315b(ColorReferences.COLOR_WHITE).m326a(f1089bC).m327a(C0085bB.b.LEFT));
        }
        int i6 = i + 20;
        addRenderableWidget(new C0085bB(i3 + 4, i6, i4, 18, f1090bD, button5 -> {
        }).m326a(f1091bE).m327a(C0085bB.b.LEFT));
        int i7 = i6 + 20;
        addRenderableWidget(new C0085bB(i3 + 4, i7, i4, 18, f1092bF, button6 -> {
            this.f1058a.setScreen(new C0149cM());
        }).m326a(f1093bG).m327a(C0085bB.b.LEFT));
        int i8 = i7 + 20;
        addRenderableWidget(new C0085bB(i3 + 4, i8, i4, 18, f1094bH, button7 -> {
            C0244ds.m784b(this.f1058a, C0528jK.f3168aK);
        }).m326a(f1095bI).m327a(C0085bB.b.LEFT));
        EnumC0411h enumC0411hM1722a = ((C0358g) this.f1057f.m2852b()).m1722a();
        if (enumC0411hM1722a == EnumC0411h.OFFLINE) {
            i8 += 20;
            addRenderableWidget(new C0085bB(i3 + 4, i8, i4, 18, f1103bQ, button8 -> {
                ((C0358g) this.f1057f.m2852b()).m1723a(EnumC0411h.UNDECIDED);
                this.f1058a.setScreen(new C0240do());
            }).m335e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m341f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m315b(ColorReferences.COLOR_WHITE).m326a(f1104bR).m327a(C0085bB.b.LEFT));
        }
        if (enumC0411hM1722a == EnumC0411h.ONLINE) {
            i8 += 20;
            addRenderableWidget(new C0085bB(i3 + 4, i8, i4, 18, f1105bS, button9 -> {
                C0358g c0358g = (C0358g) this.f1057f.m2852b();
                c0358g.m1723a(EnumC0411h.UNDECIDED);
                c0358g.disconnect("User requested disconnect", false);
                this.f1058a.setScreen(new C0240do());
            }).m335e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m341f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m315b(ColorReferences.COLOR_WHITE).m326a(f1106bT).m327a(C0085bB.b.LEFT));
        }
        int i9 = i8 + 20;
        addRenderableWidget(new C0085bB(i3 + 4, i9, i4, 18, f1096bJ, button10 -> {
            C0358g c0358g = (C0358g) this.f1057f.m2852b();
            if (c0358g.m1722a().isConnected()) {
                c0358g.sendPacket(new PacketDiscordLinkRequest());
            } else {
                C0244ds.m784b(this.f1058a, C0528jK.f3165aH);
            }
        }).m335e(ColorReferences.COLOR_THEME_DISCORD_SOLID).m341f(ColorReferences.COLOR_THEME_DISCORD_HOVERED_SOLID).m315b(ColorReferences.COLOR_WHITE).m326a(f1097bK).m327a(C0085bB.b.LEFT));
        addRenderableWidget(new C0085bB(i3 + 4, i9 + 20, i4, 18, f1098bL, button11 -> {
            C0283ee c0283ee = new C0283ee(this, f1101bO, z -> {
                if (z) {
                    this.f1058a.stop();
                }
            });
            c0283ee.m1324a(f1100bN);
            this.f1058a.setScreen(c0283ee);
        }).m335e(ColorReferences.COLOR_THEME_RED_SOLID).m341f(ColorReferences.COLOR_THEME_RED_HOVERED_SOLID).m313a(ColorReferences.COLOR_WHITE).m315b(ColorReferences.COLOR_WHITE).m326a(f1099bM).m327a(C0085bB.b.LEFT));
    }
}
