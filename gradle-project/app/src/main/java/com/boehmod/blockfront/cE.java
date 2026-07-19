package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.cloud.common.player.PlayerGroup;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cE.class */
public final class cE extends C0080cx {
    private static final Component cg;
    private static final Component ch;
    private static final Component ci;
    private static final Component cj;
    private static final Component ck;
    private static final Component cl;
    private static final Component cm;
    private static final Component cn;
    private static final Component co;
    private static final Component cp;
    private static final Component cq;
    private static final Component cr;
    private static final Component cs;
    private static final Component ct;
    private static final Component cu;
    private static final Component cv;
    private static final Component cw;
    private static final Component cx;
    private static final Component cy;
    private static final Component cz;
    private static final Component cA;
    private static final Component cB;
    public static final int ek = 16;

    @Nullable
    private final Screen f;
    static final /* synthetic */ boolean aZ;

    static {
        aZ = !cE.class.desiredAssertionStatus();
        cg = Component.translatable("bf.message.okay");
        ch = Component.translatable("bf.cloud.popup.discord.button");
        ci = Component.translatable("bf.cloud.popup.discord.button.tip", new Object[]{C0002a.a});
        cj = Component.translatable("bf.screen.ingame");
        ck = Component.translatable("bf.message.ingame.resume");
        cl = Component.translatable("bf.message.ingame.team.switch");
        cm = Component.translatable("bf.message.prompt.ingame.switch.teams.title");
        cn = Component.translatable("bf.message.prompt.ingame.switch.teams");
        co = Component.translatable("bf.message.ingame.team.switch.tip");
        cp = Component.translatable("bf.message.ingame.settings.mod");
        cq = Component.translatable("bf.message.ingame.settings.mod.tip", new Object[]{C0002a.a});
        cr = Component.translatable("bf.message.ingame.settings.minecraft");
        cs = Component.translatable("bf.message.ingame.settings.minecraft.tip");
        ct = Component.translatable("bf.message.ingame.friends");
        cu = Component.translatable("bf.message.ingame.friends.tip");
        cv = Component.translatable("bf.message.prompt.ingame.exit.title");
        cw = Component.translatable("bf.message.ingame.exit");
        cx = Component.translatable("bf.message.prompt.ingame.exit");
        cy = Component.translatable("menu.savingLevel");
        cz = Component.literal("#players").withStyle(C0266jw.c);
        cA = Component.translatable("bf.screen.report.discord.title");
        cB = Component.translatable("bf.screen.report.discord.message", new Object[]{cz});
    }

    public cE() {
        this(null);
    }

    public cE(@Nullable Screen screen) {
        super(cj);
        this.f = screen;
    }

    public void onClose() {
        this.b.setScreen(this.f);
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        oF<?, ?, ?> oFVarM591a = this.e.m591a();
        int i = this.width / 2;
        int i2 = (this.height / 2) - 60;
        iS iSVarM404a = this.a.m404a(this.b);
        C0048bs c0048bs = new C0048bs(i - 75, i2, 150, 15, ck, button -> {
            this.b.setScreen(this.f);
            this.b.setWindowActive(true);
            this.b.getSoundManager().resume();
        });
        c0048bs.a(C0048bs.b.LEFT);
        c0048bs.a(C0048bs.a.NONE);
        addRenderableWidget(c0048bs);
        if (oFVarM591a instanceof InterfaceC0464re) {
            C0048bs c0048bsA = new C0048bs(i - 75, i2 + 15, 150, 15, cl, button2 -> {
                dT dTVar = new dT(this, cm, z -> {
                    if (z) {
                        C0582vo.c(new C0592vy());
                    }
                    this.b.setWindowActive(true);
                    this.b.getSoundManager().resume();
                    this.b.setScreen((Screen) null);
                });
                dTVar.a(cn).a();
                this.b.setScreen(dTVar);
            }).a(co);
            c0048bsA.a(C0048bs.b.LEFT);
            c0048bsA.a(C0048bs.a.NONE);
            c0048bsA.active = !this.e.m592d() && oFVarM591a.a(iSVarM404a.getUUID()).a(C0529tp.y.getKey()) <= 0;
            addRenderableWidget(c0048bsA);
        }
        C0048bs c0048bsA2 = new C0048bs(i - 75, i2 + 30, 150, 15, cp, button3 -> {
            this.b.setScreen(new dU(this));
        }).a(cq);
        c0048bsA2.a(C0048bs.b.LEFT);
        c0048bsA2.a(C0048bs.a.NONE);
        addRenderableWidget(c0048bsA2);
        addRenderableWidget(c0048bsA2);
        C0048bs c0048bsA3 = new C0048bs(i - 75, i2 + 45, 150, 15, cr, button4 -> {
            this.b.setScreen(new OptionsScreen(this, this.b.options));
        }).a(cs);
        c0048bsA3.a(C0048bs.b.LEFT);
        c0048bsA3.a(C0048bs.a.NONE);
        addRenderableWidget(c0048bsA3);
        Optional<PlayerGroup> group = iSVarM404a.getGroup();
        boolean z = group.isPresent() && group.get().hasPermission(GroupPermissions.PERMISSION_STAFF_PUNISH);
        C0048bs c0048bsA4 = new C0048bs(i - 75, i2 + 60, 150, 15, Component.translatable("bf.message.ingame." + (z ? "punish" : "report")).withStyle(z ? ChatFormatting.BLUE : ChatFormatting.RED), button5 -> {
            if (z) {
                this.b.setScreen(new cR(this));
            } else {
                C0297l.a(cA, cB, PopupType.DISCORD_LINK, new C0042bm(cg, null, button5 -> {
                    this.b.setScreen(this);
                }), new C0042bm(ch, ci, button6 -> {
                    C0093dj.b(this.b, C0261jr.aB);
                }));
            }
        }).a((Component) Component.translatable("bf.message.ingame." + (z ? "punish" : "report") + ".tip"));
        c0048bsA4.active = ((C0163g) this.e.b()).a().isConnected();
        c0048bsA4.a(C0048bs.b.LEFT);
        c0048bsA4.a(C0048bs.a.NONE);
        addRenderableWidget(c0048bsA4);
        C0048bs c0048bsA5 = new C0048bs(i - 75, i2 + 90, 150, 15, ct, button6 -> {
            this.b.setScreen(new C0077cu(this, false));
            this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pk.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        }).a(cu);
        c0048bsA5.a(C0048bs.b.LEFT);
        c0048bsA5.a(C0048bs.a.NONE);
        c0048bsA5.a(() -> {
            return this.e.m582a().b().size();
        });
        addRenderableWidget(c0048bsA5);
        C0048bs c0048bs2 = new C0048bs(i - 75, i2 + C0163g.g, 150, 15, Component.empty(), button7 -> {
            this.b.setScreen(new dT(this, cv, z2 -> {
                if (z2) {
                    ClientLevel clientLevel = this.b.level;
                    if (clientLevel != null) {
                        boolean zIsLocalServer = this.b.isLocalServer();
                        clientLevel.disconnect();
                        if (zIsLocalServer) {
                            this.b.disconnect(new GenericMessageScreen(cy));
                        } else {
                            this.b.disconnect();
                        }
                        this.b.setScreen(new TitleScreen());
                        return;
                    }
                    return;
                }
                this.b.setScreen(this);
            }).a(cx));
        });
        c0048bs2.setMessage(cw);
        c0048bs2.a(C0048bs.b.LEFT);
        c0048bs2.a(C0048bs.a.NONE);
        addRenderableWidget(c0048bs2);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        C0297l c0297lB = C0297l.b();
        if (!aZ && c0297lB == null) {
            throw new AssertionError("Client Mod Manager is null!");
        }
        if (((C0163g) c0297lB.b()).a().isVerified()) {
            addRenderableWidget(new C0126eq(7, 56));
            addRenderableWidget(new C0123en((this.width - 16) - 10, 56, 16, 16));
        }
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        if (this.f != null) {
            this.f.render(guiGraphics, i, i2, f);
            poseStackPose.translate(0.0f, 0.0f, 100.0f);
        }
        super.render(guiGraphics, i, i2, f);
        C0040bk.b(poseStackPose, guiGraphics, aI, this.width / 2, (this.height / 2) - 82, 150, 25);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        if (this.f != null) {
            this.f.renderBackground(guiGraphics, i, i2, f);
        } else {
            super.renderBackground(guiGraphics, i, i2, f);
        }
        int i3 = this.width / 2;
        int i4 = (i3 - 75) - 5;
        int i5 = ((this.height / 2) - 70) + 5;
        int iP = C0040bk.p();
        C0040bk.a(guiGraphics, i4 + 1, i5 - 1, 158, 1, iP);
        C0040bk.a(guiGraphics, i4, i5, 160, 145, iP);
        C0040bk.a(guiGraphics, i4 + 1, i5 + 145, 158, 1, iP);
        poseStackPose.popPose();
    }
}
