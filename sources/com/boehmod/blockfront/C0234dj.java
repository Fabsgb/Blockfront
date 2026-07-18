package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dj.class */
public class C0234dj extends C0195cx {

    /* JADX INFO: renamed from: gc */
    public static final int f1918gc = 173;

    /* JADX INFO: renamed from: gd */
    public static final int f1919gd = 110;

    /* JADX INFO: renamed from: er */
    private static final Component f1920er;

    /* JADX INFO: renamed from: es */
    private static final Component f1921es;

    /* JADX INFO: renamed from: et */
    private static final Component f1922et;

    /* JADX INFO: renamed from: eu */
    private static final Component f1923eu;

    /* JADX INFO: renamed from: ev */
    private static final Component f1924ev;

    /* JADX INFO: renamed from: ew */
    private static final Component f1925ew;

    /* JADX INFO: renamed from: ex */
    private static final Component f1926ex;

    /* JADX INFO: renamed from: bv */
    private static final ResourceLocation f1927bv;

    /* JADX INFO: renamed from: bw */
    private static final ResourceLocation f1928bw;

    /* JADX INFO: renamed from: ge */
    public static final int f1929ge = 56;

    /* JADX INFO: renamed from: gf */
    private static final int f1930gf = 130;

    /* JADX INFO: renamed from: gg */
    private static final int f1931gg = 40;

    /* JADX INFO: renamed from: dN */
    private static final float f1932dN = 410.0f;

    /* JADX INFO: renamed from: gh */
    private static final int f1933gh = 40;

    /* JADX INFO: renamed from: gi */
    private static final int f1934gi = 20;

    /* JADX INFO: renamed from: gj */
    private static final int f1935gj = 200;

    /* JADX INFO: renamed from: dO */
    private static float f1936dO;

    /* JADX INFO: renamed from: dP */
    private static float f1937dP;

    /* JADX INFO: renamed from: gk */
    private int f1938gk;

    /* JADX INFO: renamed from: gl */
    private int f1939gl;

    /* JADX INFO: renamed from: a */
    public C0295er f1940a;

    /* JADX INFO: renamed from: bp */
    static final /* synthetic */ boolean f1941bp;

    static {
        f1941bp = !C0234dj.class.desiredAssertionStatus();
        f1920er = Component.translatable("bf.dropdown.button.settings");
        f1921es = Component.translatable("bf.dropdown.button.friends");
        f1922et = Component.translatable("menu.singleplayer").withStyle(ChatFormatting.BOLD);
        f1923eu = Component.translatable("bf.message.community").withStyle(ChatFormatting.BOLD);
        f1924ev = Component.translatable("bf.menu.button.nav.text.lobby").withStyle(ChatFormatting.BOLD);
        f1925ew = Component.translatable("bf.menu.button.nav.text.armory").withStyle(ChatFormatting.BOLD);
        f1926ex = Component.translatable("bf.menu.button.nav.text.scoreboard").withStyle(ChatFormatting.BOLD);
        f1927bv = C0564jv.m2555d("textures/gui/menu/icons/home.png");
        f1928bw = C0564jv.m2555d("textures/gui/menu/icons/menu.png");
        f1936dO = 1.0f;
        f1937dP = 1.0f;
    }

    public C0234dj(@NotNull Component component, @NotNull Component component2) {
        super(component, component2);
        this.f1938gk = 0;
        this.f1939gl = 0;
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        f1937dP = f1936dO;
        f1936dO = Mth.lerp(0.05f, f1936dO, 0.0f);
        C0126br.onUpdate();
        int i = this.f1938gk;
        this.f1938gk = i - 1;
        if (i < 0) {
            ((C0357g) this.f1586e.m2667b()).m1716a().m2164a(RequestType.CLOUD_STATS);
            this.f1938gk = 200;
        }
        int i2 = this.f1939gl;
        this.f1939gl = i2 + 1;
        if (i2 > 20) {
            this.f1939gl = 0;
            if (this.f1940a != null) {
                this.f1940a.m1564au();
            }
        }
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        float fM7843e = C1290xm.m7843e(f1936dO, f1937dP, f);
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, f1932dN);
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, 0, fM7843e);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        m1364a(this.f1585a);
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        addRenderableWidget(new C0127bs(this.width - 25, 18, 20, 20, Component.empty(), button -> {
            this.f1587b.setScreen(new C0136cA(this, false));
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7553pk.get(), 0.9f + (0.1f * threadLocalRandomCurrent.nextFloat())));
        }).m645a(f1928bw).m647a(20, 20).m653a(C0127bs.a.NONE).m651a(f1920er));
        addRenderableWidget(new C0127bs(5, 18, 20, 20, Component.empty(), button2 -> {
            this.f1587b.setScreen(new C0192cu(this, false));
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7553pk.get(), 0.9f + (0.1f * threadLocalRandomCurrent.nextFloat())));
        }).m645a(f1927bv).m647a(20, 20).m653a(C0127bs.a.NONE).m651a(f1921es)).m654a(() -> {
            return this.f1586e.m2676a().m4459b().size();
        });
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f1941bp && c0622lM2667b == null) {
            throw new AssertionError("Client Mod Manager is null!");
        }
        boolean zIsVerified = ((C0357g) c0622lM2667b.m2667b()).m1716a().isVerified();
        int i = (this.width / 2) - f1918gc;
        addRenderableWidget(new C0296es(i, 56, f1919gd, 40));
        C0295er c0295er = new C0295er(i, 100, f1919gd, 90);
        this.f1940a = c0295er;
        addRenderableWidget(c0295er);
        if (zIsVerified) {
            addRenderableWidget(new C0294eq(7, 56));
        }
        C0293ep c0293ep = new C0293ep((this.width - f1930gf) - 15, this.height - 40, f1930gf, 40);
        addRenderableWidget(c0293ep);
        addRenderableWidget(c0293ep.m1544a());
    }

    /* JADX INFO: renamed from: a */
    protected void m1364a(@NotNull C0326fV c0326fV) {
        Optional<MatchParty> party = c0326fV.m1676a(this.f1587b).getParty();
        int i = this.width / 2;
        ObjectArrayList<C0127bs> objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0128bt(this.f1587b, i, 41, 0, 8, f1922et, button -> {
            this.f1587b.setScreen(new SelectWorldScreen(new C0235dk()));
        }).mo650a());
        objectArrayList.add(new C0128bt(this.f1587b, i, 41, 0, 8, f1923eu, button2 -> {
            this.f1587b.setScreen(new JoinMultiplayerScreen(new C0235dk()));
        }).mo650a());
        objectArrayList.add(new C0128bt(this.f1587b, i, 41, 0, 8, f1924ev, new C0235dk()).mo650a().m654a(() -> {
            return ((Integer) party.map(matchParty -> {
                return Integer.valueOf(matchParty.getPlayers().size());
            }).orElse(0)).intValue();
        }));
        objectArrayList.add(new C0128bt(this.f1587b, i, 41, 0, 8, f1925ew, new C0238dn()).mo650a().m654a(() -> {
            return c0326fV.m1676a(this.f1587b).getInventory().m2154n().size();
        }));
        objectArrayList.add(new C0128bt(this.f1587b, i, 41, 0, 8, f1926ex, new C0200dB()).mo650a());
        int iSum = i - (objectArrayList.stream().mapToInt(c0127bs -> {
            return c0127bs.getWidth() + 1;
        }).sum() / 2);
        int width = 0;
        for (C0127bs c0127bs2 : objectArrayList) {
            c0127bs2.setX(iSum + width);
            addRenderableWidget(c0127bs2);
            width += c0127bs2.getWidth() + 1;
        }
    }
}
