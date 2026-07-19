package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.mm.MatchParty;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dj.class */
public class C0093dj extends C0080cx {
    public static final int gc = 173;
    public static final int gd = 110;
    private static final Component er;
    private static final Component es;
    private static final Component et;
    private static final Component eu;
    private static final Component ev;
    private static final Component ew;
    private static final Component ex;
    private static final ResourceLocation bv;
    private static final ResourceLocation bw;
    public static final int ge = 56;
    private static final int gf = 130;

    /* JADX INFO: renamed from: gg, reason: collision with root package name */
    private static final int f413gg = 40;
    private static final float dN = 410.0f;
    private static final int gh = 40;
    private static final int gi = 20;
    private static final int gj = 200;
    private static float dO;
    private static float dP;
    private int gk;
    private int gl;
    public C0127er a;
    static final /* synthetic */ boolean bp;

    static {
        bp = !C0093dj.class.desiredAssertionStatus();
        er = Component.translatable("bf.dropdown.button.settings");
        es = Component.translatable("bf.dropdown.button.friends");
        et = Component.translatable("menu.singleplayer").withStyle(ChatFormatting.BOLD);
        eu = Component.translatable("bf.message.community").withStyle(ChatFormatting.BOLD);
        ev = Component.translatable("bf.menu.button.nav.text.lobby").withStyle(ChatFormatting.BOLD);
        ew = Component.translatable("bf.menu.button.nav.text.armory").withStyle(ChatFormatting.BOLD);
        ex = Component.translatable("bf.menu.button.nav.text.scoreboard").withStyle(ChatFormatting.BOLD);
        bv = C0265jv.d("textures/gui/menu/icons/home.png");
        bw = C0265jv.d("textures/gui/menu/icons/menu.png");
        dO = 1.0f;
        dP = 1.0f;
    }

    public C0093dj(@NotNull Component component, @NotNull Component component2) {
        super(component, component2);
        this.gk = 0;
        this.gl = 0;
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        dP = dO;
        dO = Mth.lerp(0.05f, dO, 0.0f);
        C0047br.onUpdate();
        int i = this.gk;
        this.gk = i - 1;
        if (i < 0) {
            ((C0163g) this.e.b()).a().a(RequestType.CLOUD_STATS);
            this.gk = 200;
        }
        int i2 = this.gl;
        this.gl = i2 + 1;
        if (i2 > 20) {
            this.gl = 0;
            if (this.a != null) {
                this.a.au();
            }
        }
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        float fE = C0634xm.e(dO, dP, f);
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, dN);
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, 0, fE);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        a(this.a);
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        addRenderableWidget(new C0048bs(this.width - 25, 18, 20, 20, Component.empty(), button -> {
            this.b.setScreen(new cA(this, false));
            this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pk.get(), 0.9f + (0.1f * threadLocalRandomCurrent.nextFloat())));
        }).a(bw).a(20, 20).a(C0048bs.a.NONE).a(er));
        addRenderableWidget(new C0048bs(5, 18, 20, 20, Component.empty(), button2 -> {
            this.b.setScreen(new C0077cu(this, false));
            this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pk.get(), 0.9f + (0.1f * threadLocalRandomCurrent.nextFloat())));
        }).a(bv).a(20, 20).a(C0048bs.a.NONE).a(es)).a(() -> {
            return this.e.m582a().b().size();
        });
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        C0297l c0297lB = C0297l.b();
        if (!bp && c0297lB == null) {
            throw new AssertionError("Client Mod Manager is null!");
        }
        boolean zIsVerified = ((C0163g) c0297lB.b()).a().isVerified();
        int i = (this.width / 2) - gc;
        addRenderableWidget(new C0128es(i, 56, gd, 40));
        C0127er c0127er = new C0127er(i, 100, gd, 90);
        this.a = c0127er;
        addRenderableWidget(c0127er);
        if (zIsVerified) {
            addRenderableWidget(new C0126eq(7, 56));
        }
        C0125ep c0125ep = new C0125ep((this.width - gf) - 15, this.height - 40, gf, 40);
        addRenderableWidget(c0125ep);
        addRenderableWidget(c0125ep.a());
    }

    protected void a(@NotNull fV fVVar) {
        Optional<MatchParty> party = fVVar.m404a(this.b).getParty();
        int i = this.width / 2;
        ObjectArrayList<C0048bs> objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0049bt(this.b, i, 41, 0, 8, et, button -> {
            this.b.setScreen(new SelectWorldScreen(new C0094dk()));
        }).a());
        objectArrayList.add(new C0049bt(this.b, i, 41, 0, 8, eu, button2 -> {
            this.b.setScreen(new JoinMultiplayerScreen(new C0094dk()));
        }).a());
        objectArrayList.add(new C0049bt(this.b, i, 41, 0, 8, ev, new C0094dk()).a().a(() -> {
            return ((Integer) party.map(matchParty -> {
                return Integer.valueOf(matchParty.getPlayers().size());
            }).orElse(0)).intValue();
        }));
        objectArrayList.add(new C0049bt(this.b, i, 41, 0, 8, ew, new C0097dn()).a().a(() -> {
            return fVVar.m404a(this.b).getInventory().n().size();
        }));
        objectArrayList.add(new C0049bt(this.b, i, 41, 0, 8, ex, new dB()).a());
        int iSum = i - (objectArrayList.stream().mapToInt(c0048bs -> {
            return c0048bs.getWidth() + 1;
        }).sum() / 2);
        int width = 0;
        for (C0048bs c0048bs2 : objectArrayList) {
            c0048bs2.setX(iSum + width);
            addRenderableWidget(c0048bs2);
            width += c0048bs2.getWidth() + 1;
        }
    }
}
