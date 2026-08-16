package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.p001mm.MatchParty;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ds */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ds.class */
public class C0244ds extends C0143cG {

    /* JADX INFO: renamed from: hc */
    public static final int f1978hc = 173;

    /* JADX INFO: renamed from: hd */
    public static final int f1979hd = 110;

    /* JADX INFO: renamed from: et */
    private static final Component f1980et;

    /* JADX INFO: renamed from: eu */
    private static final Component f1981eu;

    /* JADX INFO: renamed from: ev */
    private static final Component f1982ev;

    /* JADX INFO: renamed from: ew */
    private static final Component f1983ew;

    /* JADX INFO: renamed from: ex */
    private static final Component f1984ex;

    /* JADX INFO: renamed from: ey */
    private static final Component f1985ey;

    /* JADX INFO: renamed from: ez */
    private static final Component f1986ez;

    /* JADX INFO: renamed from: eA */
    private static final Component f1987eA;

    /* JADX INFO: renamed from: bt */
    private static final ResourceLocation f1988bt;

    /* JADX INFO: renamed from: bu */
    private static final ResourceLocation f1989bu;

    /* JADX INFO: renamed from: he */
    public static final int f1990he = 56;

    /* JADX INFO: renamed from: hf */
    private static final int f1991hf = 130;

    /* JADX INFO: renamed from: hg */
    private static final int f1992hg = 40;

    /* JADX INFO: renamed from: dQ */
    private static final float f1993dQ = 410.0f;

    /* JADX INFO: renamed from: hh */
    private static final int f1994hh = 40;

    /* JADX INFO: renamed from: hi */
    private static final int f1995hi = 20;

    /* JADX INFO: renamed from: hj */
    private static final int f1996hj = 200;

    /* JADX INFO: renamed from: dR */
    private static float f1997dR;

    /* JADX INFO: renamed from: dS */
    private static float f1998dS;

    /* JADX INFO: renamed from: hk */
    private int f1999hk;

    /* JADX INFO: renamed from: hl */
    private int f2000hl;

    /* JADX INFO: renamed from: a */
    public C0257eE f2001a;

    /* JADX INFO: renamed from: bt */
    static final /* synthetic */ boolean f2002bt;

    static {
        f2002bt = !C0244ds.class.desiredAssertionStatus();
        f1980et = Component.translatable("bf.dropdown.button.settings");
        f1981eu = Component.translatable("bf.dropdown.button.friends");
        f1982ev = Component.translatable("menu.singleplayer").withStyle(ChatFormatting.BOLD);
        f1983ew = Component.translatable("bf.message.community").withStyle(ChatFormatting.BOLD);
        f1984ex = Component.translatable("bf.menu.button.nav.text.lobby").withStyle(ChatFormatting.BOLD);
        f1985ey = Component.translatable("bf.menu.button.nav.text.armory").withStyle(ChatFormatting.BOLD);
        f1986ez = Component.translatable("bf.menu.button.nav.text.scoreboard").withStyle(ChatFormatting.BOLD);
        f1987eA = Component.translatable("bf.menu.button.nav.text.news").withStyle(ChatFormatting.BOLD);
        f1988bt = C0532jO.m2378d("textures/gui/menu/icons/home.png");
        f1989bu = C0532jO.m2378d("textures/gui/menu/icons/menu.png");
        f1997dR = 1.0f;
        f1998dS = 1.0f;
    }

    public C0244ds(@NotNull Component component, @NotNull Component component2) {
        super(component, component2);
        this.f1999hk = 0;
        this.f2000hl = 0;
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        f1998dS = f1997dR;
        f1997dR = Mth.lerp(0.05f, f1997dR, 0.0f);
        C0084bA.onUpdate();
        int i = this.f1999hk;
        this.f1999hk = i - 1;
        if (i < 0) {
            ((C0358g) this.f1057f.m2852b()).m1722a().m2491a(RequestType.CLOUD_STATS);
            this.f1999hk = 200;
        }
        int i2 = this.f2000hl;
        this.f2000hl = i2 + 1;
        if (i2 > 20) {
            this.f2000hl = 0;
            if (this.f2001a != null) {
                this.f2001a.m1466az();
            }
        }
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        if (this.f1058a.screen != this) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        float fM7170f = C1270xJ.m7170f(f1997dR, f1998dS, f);
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, f1993dQ);
        C0129bt.m517a(guiGraphics, 0, 0, this.width, this.height, 0, fM7170f);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        m1390a(this.f1056a);
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        addRenderableWidget(new C0085bB(this.width - 25, 18, 20, 20, Component.empty(), button -> {
            this.f1058a.setScreen(new C0146cJ(this));
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7965pm.get(), 0.9f + (0.1f * threadLocalRandomCurrent.nextFloat())));
        }).m320a(f1989bu).m322a(20, 20).m328a(C0085bB.a.NONE).m326a(f1980et));
        addRenderableWidget(new C0085bB(5, 18, 20, 20, Component.empty(), button2 -> {
            this.f1058a.setScreen(new C0140cD(this));
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7965pm.get(), 0.9f + (0.1f * threadLocalRandomCurrent.nextFloat())));
        }).m320a(f1988bt).m322a(20, 20).m328a(C0085bB.a.NONE).m326a(f1981eu)).m329a(() -> {
            return this.f1057f.m2861a().m4642b().size();
        });
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2002bt && c0623lM2852b == null) {
            throw new AssertionError("Client Mod Manager is null!");
        }
        boolean zIsVerified = ((C0358g) c0623lM2852b.m2852b()).m1722a().isVerified();
        int i = (this.width / 2) - f1978hc;
        addRenderableWidget(new C0258eF(i, 56, f1979hd, 40));
        C0257eE c0257eE = new C0257eE(i, 100, f1979hd, 90);
        this.f2001a = c0257eE;
        addRenderableWidget(c0257eE);
        if (zIsVerified) {
            addRenderableWidget(new C0256eD(7, 56));
        }
        C0255eC c0255eC = new C0255eC((this.width - f1991hf) - 15, this.height - 40, f1991hf, 40);
        addRenderableWidget(c0255eC);
        addRenderableWidget(c0255eC.m1446a());
    }

    /* JADX INFO: renamed from: a */
    protected void m1390a(@NotNull C0396gl c0396gl) {
        Optional<MatchParty> party = c0396gl.m1886a(this.f1058a).getParty();
        int i = this.width / 2;
        ObjectArrayList<C0085bB> objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0086bC(this.f1058a, i, 41, 0, 8, f1982ev, button -> {
            this.f1058a.setScreen(new SelectWorldScreen(new C0245dt()));
        }).mo325a());
        objectArrayList.add(new C0086bC(this.f1058a, i, 41, 0, 8, f1983ew, button2 -> {
            this.f1058a.setScreen(new JoinMultiplayerScreen(new C0245dt()));
        }).mo325a());
        objectArrayList.add(new C0086bC(this.f1058a, i, 41, 0, 8, f1984ex, new C0245dt()).mo325a().m329a(() -> {
            return ((Integer) party.map(matchParty -> {
                return Integer.valueOf(matchParty.getPlayers().size());
            }).orElse(0)).intValue();
        }));
        objectArrayList.add(new C0086bC(this.f1058a, i, 41, 0, 8, f1987eA, new C0208dI()).mo325a().m329a(() -> {
            return this.f1057f.m2863a().m1530an();
        }));
        objectArrayList.add(new C0086bC(this.f1058a, i, 41, 0, 8, f1985ey, new C0248dw()).mo325a().m329a(() -> {
            return c0396gl.m1886a(this.f1058a).getInventory().m2481p().size();
        }));
        objectArrayList.add(new C0086bC(this.f1058a, i, 41, 0, 8, f1986ez, new C0212dM()).mo325a());
        int iSum = i - (objectArrayList.stream().mapToInt(c0085bB -> {
            return c0085bB.getWidth() + 1;
        }).sum() / 2);
        int width = 0;
        for (C0085bB c0085bB2 : objectArrayList) {
            c0085bB2.setX(iSum + width);
            addRenderableWidget(c0085bB2);
            width += c0085bB2.getWidth() + 1;
        }
    }
}
