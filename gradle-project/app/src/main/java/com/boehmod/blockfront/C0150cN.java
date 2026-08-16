package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.cloud.common.player.PlayerGroup;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.GenericMessageScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cN.class */
public final class C0150cN extends C0143cG {

    /* JADX INFO: renamed from: ci */
    private static final Component f1153ci;

    /* JADX INFO: renamed from: cj */
    private static final Component f1154cj;

    /* JADX INFO: renamed from: ck */
    private static final Component f1155ck;

    /* JADX INFO: renamed from: cl */
    private static final Component f1156cl;

    /* JADX INFO: renamed from: cm */
    private static final Component f1157cm;

    /* JADX INFO: renamed from: cn */
    private static final Component f1158cn;

    /* JADX INFO: renamed from: co */
    private static final Component f1159co;

    /* JADX INFO: renamed from: cp */
    private static final Component f1160cp;

    /* JADX INFO: renamed from: cq */
    private static final Component f1161cq;

    /* JADX INFO: renamed from: cr */
    private static final Component f1162cr;

    /* JADX INFO: renamed from: cs */
    private static final Component f1163cs;

    /* JADX INFO: renamed from: ct */
    private static final Component f1164ct;

    /* JADX INFO: renamed from: cu */
    private static final Component f1165cu;

    /* JADX INFO: renamed from: cv */
    private static final Component f1166cv;

    /* JADX INFO: renamed from: cw */
    private static final Component f1167cw;

    /* JADX INFO: renamed from: cx */
    private static final Component f1168cx;

    /* JADX INFO: renamed from: cy */
    private static final Component f1169cy;

    /* JADX INFO: renamed from: cz */
    private static final Component f1170cz;

    /* JADX INFO: renamed from: cA */
    private static final Component f1171cA;

    /* JADX INFO: renamed from: cB */
    private static final Component f1172cB;

    /* JADX INFO: renamed from: cC */
    private static final Component f1173cC;

    /* JADX INFO: renamed from: cD */
    private static final Component f1174cD;

    /* JADX INFO: renamed from: fk */
    public static final int f1175fk = 16;

    /* JADX INFO: renamed from: e */
    @Nullable
    private final Screen f1176e;

    /* JADX INFO: renamed from: bd */
    static final /* synthetic */ boolean f1177bd;

    static {
        f1177bd = !C0150cN.class.desiredAssertionStatus();
        f1153ci = Component.translatable("bf.message.okay");
        f1154cj = Component.translatable("bf.cloud.popup.discord.button");
        f1155ck = Component.translatable("bf.cloud.popup.discord.button.tip", new Object[]{C0030a.f263a});
        f1156cl = Component.translatable("bf.screen.ingame");
        f1157cm = Component.translatable("bf.message.ingame.resume");
        f1158cn = Component.translatable("bf.message.ingame.team.switch");
        f1159co = Component.translatable("bf.message.prompt.ingame.switch.teams.title");
        f1160cp = Component.translatable("bf.message.prompt.ingame.switch.teams");
        f1161cq = Component.translatable("bf.message.ingame.team.switch.tip");
        f1162cr = Component.translatable("bf.message.ingame.settings.mod");
        f1163cs = Component.translatable("bf.message.ingame.settings.mod.tip", new Object[]{C0030a.f263a});
        f1164ct = Component.translatable("bf.message.ingame.settings.minecraft");
        f1165cu = Component.translatable("bf.message.ingame.settings.minecraft.tip");
        f1166cv = Component.translatable("bf.message.ingame.friends");
        f1167cw = Component.translatable("bf.message.ingame.friends.tip");
        f1168cx = Component.translatable("bf.message.prompt.ingame.exit.title");
        f1169cy = Component.translatable("bf.message.ingame.exit");
        f1170cz = Component.translatable("bf.message.prompt.ingame.exit");
        f1171cA = Component.translatable("menu.savingLevel");
        f1172cB = Component.literal("#players").withStyle(C0533jP.f3186c);
        f1173cC = Component.translatable("bf.screen.report.discord.title");
        f1174cD = Component.translatable("bf.screen.report.discord.message", new Object[]{f1172cB});
    }

    public C0150cN() {
        this(null);
    }

    public C0150cN(@Nullable Screen screen) {
        super(f1156cl);
        this.f1176e = screen;
    }

    public void onClose() {
        this.f1058a.setScreen(this.f1176e);
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = this.f1057f.m2874a();
        int i = this.width / 2;
        int i2 = (this.height / 2) - 60;
        C0555jl c0555jlM1886a = this.f1056a.m1886a(this.f1058a);
        C0085bB c0085bB = new C0085bB(i - 75, i2, 150, 15, f1157cm, button -> {
            this.f1058a.setScreen(this.f1176e);
            this.f1058a.setWindowActive(true);
            this.f1058a.getSoundManager().resume();
        });
        c0085bB.m327a(C0085bB.b.LEFT);
        c0085bB.m328a(C0085bB.a.NONE);
        addRenderableWidget(c0085bB);
        if (abstractC0863pbM2874a instanceof InterfaceC0943rB) {
            C0085bB c0085bBM326a = new C0085bB(i - 75, i2 + 15, 150, 15, f1158cn, button2 -> {
                C0283ee c0283ee = new C0283ee(this, f1159co, z -> {
                    if (z) {
                        C1169vO.m6648c(new C1178vX());
                    }
                    this.f1058a.setWindowActive(true);
                    this.f1058a.getSoundManager().resume();
                    this.f1058a.setScreen((Screen) null);
                });
                c0283ee.m1324a(f1160cp).mo1323a();
                this.f1058a.setScreen(c0283ee);
            }).m326a(f1161cq);
            c0085bBM326a.m327a(C0085bB.b.LEFT);
            c0085bBM326a.m328a(C0085bB.a.NONE);
            c0085bBM326a.active = !this.f1057f.m2875d() && abstractC0863pbM2874a.m4034a(c0555jlM1886a.getUUID()).m4289a(C1062tN.f5761y.getKey()) <= 0;
            addRenderableWidget(c0085bBM326a);
        }
        C0085bB c0085bBM326a2 = new C0085bB(i - 75, i2 + 30, 150, 15, f1162cr, button3 -> {
            this.f1058a.setScreen(new C0284ef(this));
        }).m326a(f1163cs);
        c0085bBM326a2.m327a(C0085bB.b.LEFT);
        c0085bBM326a2.m328a(C0085bB.a.NONE);
        addRenderableWidget(c0085bBM326a2);
        addRenderableWidget(c0085bBM326a2);
        C0085bB c0085bBM326a3 = new C0085bB(i - 75, i2 + 45, 150, 15, f1164ct, button4 -> {
            this.f1058a.setScreen(new OptionsScreen(this, this.f1058a.options));
        }).m326a(f1165cu);
        c0085bBM326a3.m327a(C0085bB.b.LEFT);
        c0085bBM326a3.m328a(C0085bB.a.NONE);
        addRenderableWidget(c0085bBM326a3);
        Optional<PlayerGroup> group = c0555jlM1886a.getGroup();
        boolean z = group.isPresent() && group.get().hasPermission(GroupPermissions.PERMISSION_STAFF_PUNISH);
        C0085bB c0085bBM326a4 = new C0085bB(i - 75, i2 + 60, 150, 15, Component.translatable("bf.message.ingame." + (z ? "punish" : "report")).withStyle(z ? ChatFormatting.BLUE : ChatFormatting.RED), button5 -> {
            if (z) {
                this.f1058a.setScreen(new C0226da(this));
            } else {
                C0623l.m2853a(f1173cC, f1174cD, PopupType.DISCORD_LINK, new C0131bv(f1153ci, null, button5 -> {
                    this.f1058a.setScreen(this);
                }), new C0131bv(f1154cj, f1155ck, button6 -> {
                    C0244ds.m784b(this.f1058a, C0528jK.f3165aH);
                }));
            }
        }).m326a((Component) Component.translatable("bf.message.ingame." + (z ? "punish" : "report") + ".tip"));
        c0085bBM326a4.active = ((C0358g) this.f1057f.m2852b()).m1722a().isConnected();
        c0085bBM326a4.m327a(C0085bB.b.LEFT);
        c0085bBM326a4.m328a(C0085bB.a.NONE);
        addRenderableWidget(c0085bBM326a4);
        C0085bB c0085bBM326a5 = new C0085bB(i - 75, i2 + 90, 150, 15, f1166cv, button6 -> {
            this.f1058a.setScreen(new C0140cD(this));
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7965pm.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        }).m326a(f1167cw);
        c0085bBM326a5.m327a(C0085bB.b.LEFT);
        c0085bBM326a5.m328a(C0085bB.a.NONE);
        c0085bBM326a5.m329a(() -> {
            return this.f1057f.m2861a().m4642b().size();
        });
        addRenderableWidget(c0085bBM326a5);
        C0085bB c0085bB2 = new C0085bB(i - 75, i2 + C0358g.f2490g, 150, 15, Component.empty(), button7 -> {
            this.f1058a.setScreen(new C0283ee(this, f1168cx, z2 -> {
                if (z2) {
                    ClientLevel clientLevel = this.f1058a.level;
                    if (clientLevel != null) {
                        boolean zIsLocalServer = this.f1058a.isLocalServer();
                        clientLevel.disconnect();
                        if (zIsLocalServer) {
                            this.f1058a.disconnect(new GenericMessageScreen(f1171cA));
                        } else {
                            this.f1058a.disconnect();
                        }
                        this.f1058a.setScreen(new TitleScreen());
                        return;
                    }
                    return;
                }
                this.f1058a.setScreen(this);
            }).m1324a(f1170cz));
        });
        c0085bB2.setMessage(f1169cy);
        c0085bB2.m327a(C0085bB.b.LEFT);
        c0085bB2.m328a(C0085bB.a.NONE);
        addRenderableWidget(c0085bB2);
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f1177bd && c0623lM2852b == null) {
            throw new AssertionError("Client Mod Manager is null!");
        }
        if (((C0358g) c0623lM2852b.m2852b()).m1722a().isVerified()) {
            addRenderableWidget(new C0256eD(7, 56));
            addRenderableWidget(new C0253eA((this.width - 16) - 10, 56, 16, 16));
        }
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        if (this.f1176e != null) {
            this.f1176e.render(guiGraphics, i, i2, f);
            poseStackPose.translate(0.0f, 0.0f, 100.0f);
        }
        super.render(guiGraphics, i, i2, f);
        C0129bt.m541b(poseStackPose, guiGraphics, f1038aI, this.width / 2, (this.height / 2) - 82, 150, 25);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        if (this.f1176e != null) {
            this.f1176e.renderBackground(guiGraphics, i, i2, f);
        } else {
            super.renderBackground(guiGraphics, i, i2, f);
        }
        int i3 = this.width / 2;
        C0129bt.m518b(guiGraphics, (i3 - 75) - 5, (((this.height / 2) - 70) + 5) - 1, 160, 147, C0129bt.m465t());
        poseStackPose.popPose();
    }
}
