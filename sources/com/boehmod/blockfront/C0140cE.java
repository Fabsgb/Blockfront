package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.cloud.common.player.PlayerGroup;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cE.class */
public final class C0140cE extends C0195cx {

    /* JADX INFO: renamed from: cg */
    private static final Component f1063cg;

    /* JADX INFO: renamed from: ch */
    private static final Component f1064ch;

    /* JADX INFO: renamed from: ci */
    private static final Component f1065ci;

    /* JADX INFO: renamed from: cj */
    private static final Component f1066cj;

    /* JADX INFO: renamed from: ck */
    private static final Component f1067ck;

    /* JADX INFO: renamed from: cl */
    private static final Component f1068cl;

    /* JADX INFO: renamed from: cm */
    private static final Component f1069cm;

    /* JADX INFO: renamed from: cn */
    private static final Component f1070cn;

    /* JADX INFO: renamed from: co */
    private static final Component f1071co;

    /* JADX INFO: renamed from: cp */
    private static final Component f1072cp;

    /* JADX INFO: renamed from: cq */
    private static final Component f1073cq;

    /* JADX INFO: renamed from: cr */
    private static final Component f1074cr;

    /* JADX INFO: renamed from: cs */
    private static final Component f1075cs;

    /* JADX INFO: renamed from: ct */
    private static final Component f1076ct;

    /* JADX INFO: renamed from: cu */
    private static final Component f1077cu;

    /* JADX INFO: renamed from: cv */
    private static final Component f1078cv;

    /* JADX INFO: renamed from: cw */
    private static final Component f1079cw;

    /* JADX INFO: renamed from: cx */
    private static final Component f1080cx;

    /* JADX INFO: renamed from: cy */
    private static final Component f1081cy;

    /* JADX INFO: renamed from: cz */
    private static final Component f1082cz;

    /* JADX INFO: renamed from: cA */
    private static final Component f1083cA;

    /* JADX INFO: renamed from: cB */
    private static final Component f1084cB;

    /* JADX INFO: renamed from: ek */
    public static final int f1085ek = 16;

    /* JADX INFO: renamed from: f */
    @Nullable
    private final Screen f1086f;

    /* JADX INFO: renamed from: aZ */
    static final /* synthetic */ boolean f1087aZ;

    static {
        f1087aZ = !C0140cE.class.desiredAssertionStatus();
        f1063cg = Component.translatable("bf.message.okay");
        f1064ch = Component.translatable("bf.cloud.popup.discord.button");
        f1065ci = Component.translatable("bf.cloud.popup.discord.button.tip", new Object[]{C0029a.f246a});
        f1066cj = Component.translatable("bf.screen.ingame");
        f1067ck = Component.translatable("bf.message.ingame.resume");
        f1068cl = Component.translatable("bf.message.ingame.team.switch");
        f1069cm = Component.translatable("bf.message.prompt.ingame.switch.teams.title");
        f1070cn = Component.translatable("bf.message.prompt.ingame.switch.teams");
        f1071co = Component.translatable("bf.message.ingame.team.switch.tip");
        f1072cp = Component.translatable("bf.message.ingame.settings.mod");
        f1073cq = Component.translatable("bf.message.ingame.settings.mod.tip", new Object[]{C0029a.f246a});
        f1074cr = Component.translatable("bf.message.ingame.settings.minecraft");
        f1075cs = Component.translatable("bf.message.ingame.settings.minecraft.tip");
        f1076ct = Component.translatable("bf.message.ingame.friends");
        f1077cu = Component.translatable("bf.message.ingame.friends.tip");
        f1078cv = Component.translatable("bf.message.prompt.ingame.exit.title");
        f1079cw = Component.translatable("bf.message.ingame.exit");
        f1080cx = Component.translatable("bf.message.prompt.ingame.exit");
        f1081cy = Component.translatable("menu.savingLevel");
        f1082cz = Component.literal("#players").withStyle(C0565jw.f3202c);
        f1083cA = Component.translatable("bf.screen.report.discord.title");
        f1084cB = Component.translatable("bf.screen.report.discord.message", new Object[]{f1082cz});
    }

    public C0140cE() {
        this(null);
    }

    public C0140cE(@Nullable Screen screen) {
        super(f1066cj);
        this.f1086f = screen;
    }

    public void onClose() {
        this.f1587b.setScreen(this.f1086f);
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = this.f1586e.m2688a();
        int i = this.width / 2;
        int i2 = (this.height / 2) - 60;
        C0482iS c0482iSM1676a = this.f1585a.m1676a(this.f1587b);
        C0127bs c0127bs = new C0127bs(i - 75, i2, 150, 15, f1067ck, button -> {
            this.f1587b.setScreen(this.f1086f);
            this.f1587b.setWindowActive(true);
            this.f1587b.getSoundManager().resume();
        });
        c0127bs.m652a(C0127bs.b.LEFT);
        c0127bs.m653a(C0127bs.a.NONE);
        addRenderableWidget(c0127bs);
        if (abstractC0787oFM2688a instanceof InterfaceC0971re) {
            C0127bs c0127bsM651a = new C0127bs(i - 75, i2 + 15, 150, 15, f1068cl, button2 -> {
                C0218dT c0218dT = new C0218dT(this, f1069cm, z -> {
                    if (z) {
                        C1194vo.m6653c(new C1204vy());
                    }
                    this.f1587b.setWindowActive(true);
                    this.f1587b.getSoundManager().resume();
                    this.f1587b.setScreen((Screen) null);
                });
                c0218dT.m1273a(f1070cn).mo1272a();
                this.f1587b.setScreen(c0218dT);
            }).m651a(f1071co);
            c0127bsM651a.m652a(C0127bs.b.LEFT);
            c0127bsM651a.m653a(C0127bs.a.NONE);
            c0127bsM651a.active = !this.f1586e.m2689d() && abstractC0787oFM2688a.m3598a(c0482iSM1676a.getUUID()).m3853a(C1089tp.f5708y.getKey()) <= 0;
            addRenderableWidget(c0127bsM651a);
        }
        C0127bs c0127bsM651a2 = new C0127bs(i - 75, i2 + 30, 150, 15, f1072cp, button3 -> {
            this.f1587b.setScreen(new C0219dU(this));
        }).m651a(f1073cq);
        c0127bsM651a2.m652a(C0127bs.b.LEFT);
        c0127bsM651a2.m653a(C0127bs.a.NONE);
        addRenderableWidget(c0127bsM651a2);
        addRenderableWidget(c0127bsM651a2);
        C0127bs c0127bsM651a3 = new C0127bs(i - 75, i2 + 45, 150, 15, f1074cr, button4 -> {
            this.f1587b.setScreen(new OptionsScreen(this, this.f1587b.options));
        }).m651a(f1075cs);
        c0127bsM651a3.m652a(C0127bs.b.LEFT);
        c0127bsM651a3.m653a(C0127bs.a.NONE);
        addRenderableWidget(c0127bsM651a3);
        Optional<PlayerGroup> group = c0482iSM1676a.getGroup();
        boolean z = group.isPresent() && group.get().hasPermission(GroupPermissions.PERMISSION_STAFF_PUNISH);
        C0127bs c0127bsM651a4 = new C0127bs(i - 75, i2 + 60, 150, 15, Component.translatable("bf.message.ingame." + (z ? "punish" : "report")).withStyle(z ? ChatFormatting.BLUE : ChatFormatting.RED), button5 -> {
            if (z) {
                this.f1587b.setScreen(new C0153cR(this));
            } else {
                C0622l.m2668a(f1083cA, f1084cB, PopupType.DISCORD_LINK, new C0121bm(f1063cg, null, button5 -> {
                    this.f1587b.setScreen(this);
                }), new C0121bm(f1064ch, f1065ci, button6 -> {
                    C0234dj.m1186b(this.f1587b, C0560jr.f3182aB);
                }));
            }
        }).m651a((Component) Component.translatable("bf.message.ingame." + (z ? "punish" : "report") + ".tip"));
        c0127bsM651a4.active = ((C0357g) this.f1586e.m2667b()).m1716a().isConnected();
        c0127bsM651a4.m652a(C0127bs.b.LEFT);
        c0127bsM651a4.m653a(C0127bs.a.NONE);
        addRenderableWidget(c0127bsM651a4);
        C0127bs c0127bsM651a5 = new C0127bs(i - 75, i2 + 90, 150, 15, f1076ct, button6 -> {
            this.f1587b.setScreen(new C0192cu(this, false));
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7553pk.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        }).m651a(f1077cu);
        c0127bsM651a5.m652a(C0127bs.b.LEFT);
        c0127bsM651a5.m653a(C0127bs.a.NONE);
        c0127bsM651a5.m654a(() -> {
            return this.f1586e.m2676a().m4459b().size();
        });
        addRenderableWidget(c0127bsM651a5);
        C0127bs c0127bs2 = new C0127bs(i - 75, i2 + C0357g.f2439g, 150, 15, Component.empty(), button7 -> {
            this.f1587b.setScreen(new C0218dT(this, f1078cv, z2 -> {
                if (z2) {
                    ClientLevel clientLevel = this.f1587b.level;
                    if (clientLevel != null) {
                        boolean zIsLocalServer = this.f1587b.isLocalServer();
                        clientLevel.disconnect();
                        if (zIsLocalServer) {
                            this.f1587b.disconnect(new GenericMessageScreen(f1081cy));
                        } else {
                            this.f1587b.disconnect();
                        }
                        this.f1587b.setScreen(new TitleScreen());
                        return;
                    }
                    return;
                }
                this.f1587b.setScreen(this);
            }).m1273a(f1080cx));
        });
        c0127bs2.setMessage(f1079cw);
        c0127bs2.m652a(C0127bs.b.LEFT);
        c0127bs2.m653a(C0127bs.a.NONE);
        addRenderableWidget(c0127bs2);
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f1087aZ && c0622lM2667b == null) {
            throw new AssertionError("Client Mod Manager is null!");
        }
        if (((C0357g) c0622lM2667b.m2667b()).m1716a().isVerified()) {
            addRenderableWidget(new C0294eq(7, 56));
            addRenderableWidget(new C0291en((this.width - 16) - 10, 56, 16, 16));
        }
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        if (this.f1086f != null) {
            this.f1086f.render(guiGraphics, i, i2, f);
            poseStackPose.translate(0.0f, 0.0f, 100.0f);
        }
        super.render(guiGraphics, i, i2, f);
        C0119bk.m441b(poseStackPose, guiGraphics, f1565aI, this.width / 2, (this.height / 2) - 82, 150, 25);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        if (this.f1086f != null) {
            this.f1086f.renderBackground(guiGraphics, i, i2, f);
        } else {
            super.renderBackground(guiGraphics, i, i2, f);
        }
        int i3 = this.width / 2;
        int i4 = (i3 - 75) - 5;
        int i5 = ((this.height / 2) - 70) + 5;
        int iM365p = C0119bk.m365p();
        C0119bk.m415a(guiGraphics, i4 + 1, i5 - 1, 158, 1, iM365p);
        C0119bk.m415a(guiGraphics, i4, i5, 160, 145, iM365p);
        C0119bk.m415a(guiGraphics, i4 + 1, i5 + 145, 158, 1, iM365p);
        poseStackPose.popPose();
    }
}
