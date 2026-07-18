package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cP.class */
public abstract class AbstractC0151cP extends C0196cy {

    /* JADX INFO: renamed from: dj */
    private static final Component f1226dj;

    /* JADX INFO: renamed from: c */
    public static final MutableComponent f1227c;

    /* JADX INFO: renamed from: c */
    protected final AbstractC0787oF<?, ?, ?> f1228c;

    /* JADX INFO: renamed from: v */
    protected final List<C0150cO> f1229v;

    /* JADX INFO: renamed from: i */
    protected final Screen f1230i;

    /* JADX INFO: renamed from: w */
    protected final List<C0863pc> f1231w;

    /* JADX INFO: renamed from: a */
    protected C0150cO f1232a;

    /* JADX INFO: renamed from: fd */
    protected int f1233fd;

    /* JADX INFO: renamed from: bf */
    static final /* synthetic */ boolean f1234bf;

    /* JADX INFO: renamed from: a */
    public abstract void mo977a(@NotNull Item item, int i);

    static {
        f1234bf = !AbstractC0151cP.class.desiredAssertionStatus();
        f1226dj = Component.translatable("bf.screen.ingame.gun.store");
        f1227c = Component.translatable("bf.message.selected").withStyle(ChatFormatting.BOLD);
    }

    protected AbstractC0151cP(Screen screen, List<C0863pc> list, AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        super(f1226dj);
        this.f1229v = new ObjectArrayList();
        this.f1232a = null;
        this.f1233fd = 20;
        this.f1231w = list;
        this.f1230i = screen;
        this.f1228c = abstractC0787oF;
    }

    /* JADX INFO: renamed from: a */
    public void m975a(C0863pc c0863pc, String[] strArr) {
        this.f1229v.add(new C0150cO(0, 0, c0863pc, strArr, 0, 0));
    }

    public void init() {
        super.init();
        C0127bs c0127bs = new C0127bs((this.width / 2) - 150, 18, 40, 10, Component.literal("< ").append(Component.translatable("bf.menu.button.back")), button -> {
            this.f1587b.setScreen(this.f1230i);
        });
        c0127bs.m653a(C0127bs.a.NONE);
        addRenderableWidget(c0127bs);
        m976W();
    }

    /* JADX INFO: renamed from: W */
    public void m976W() {
        int i = (this.width / 2) - 140;
        int i2 = (this.height / 2) - 72;
        int size = this.f1229v.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0150cO c0150cO = this.f1229v.get(i3);
            c0150cO.m971c(i);
            c0150cO.m972d(i2 + (i3 * 22));
            c0150cO.m973e(100);
            c0150cO.m974f(20);
        }
    }

    public boolean keyPressed(int i, int i2, int i3) {
        if (!f1234bf && this.f1587b == null) {
            throw new AssertionError();
        }
        this.f1587b.setScreen(this.f1230i);
        return true;
    }

    public void tick() {
        if (!f1234bf && this.f1587b == null) {
            throw new AssertionError();
        }
        int i = this.f1233fd;
        this.f1233fd = i - 1;
        if (i <= 0) {
            this.f1587b.setScreen(new C0152cQ(null, this.f1231w, this.f1228c));
        }
    }

    public boolean isPauseScreen() {
        return false;
    }

    public boolean mouseClicked(double d, double d2, int i) {
        if (!f1234bf && this.f1587b == null) {
            throw new AssertionError();
        }
        int size = this.f1229v.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0150cO c0150cO = this.f1229v.get(i2);
            if (c0150cO.m968a((int) d, (int) d2) && i == 0) {
                mo977a(c0150cO.m969a(), i2 + 1);
                this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.0f));
            }
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fM366g = C0119bk.m366g();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0119bk.m491c(guiGraphics, 0, 0, this.width, 30, C0119bk.m365p());
        C0119bk.m491c(guiGraphics, 0, this.height - 30, this.width, 30, C0119bk.m365p());
        C0119bk.m383c(this.font, guiGraphics, (Component) Component.translatable("bf.message.weapon.vendor").withStyle(ChatFormatting.BOLD), i3, 10);
        super.render(guiGraphics, i, i2, f);
        C0119bk.m491c(guiGraphics, i3 - 150, i4 - 80, C0357g.f2439g, (this.f1229v.size() * 22) + 15, C0119bk.m365p());
        this.f1229v.forEach(c0150cO -> {
            c0150cO.m966c(guiGraphics, this.font);
            if (c0150cO.m968a(i, i2)) {
                this.f1232a = c0150cO;
                c0150cO.m967a(this.f1586e, guiGraphics, 1, fM366g);
            }
        });
        int i5 = i3 - 25;
        int i6 = i4 - 80;
        C0119bk.m491c(guiGraphics, i5, i6, 100, 160, C0119bk.m365p());
        C0119bk.m370a(this.font, guiGraphics, (Component) f1227c, i3 - 20, i4 - 75);
        if (this.f1232a != null) {
            Item itemM969a = this.f1232a.m969a();
            C0099bQ c0099bQM315a = C0119bk.f736a.m315a(this.f1587b);
            if (c0099bQM315a.getMainHandItem().isEmpty() || c0099bQM315a.getMainHandItem().getItem() != itemM969a) {
                c0099bQM315a.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(itemM969a));
            }
            C0119bk.m517a(guiGraphics, i5, i6, 100, 160);
            if (this.f1228c != null) {
                if (!f1234bf && this.f1587b.player == null) {
                    throw new AssertionError();
                }
                C0796oO c0796oOM3793a = this.f1228c.m3582b().m3793a(this.f1587b.player.getUUID());
                if (c0796oOM3793a != null) {
                    C0119bk.m445b(poseStackPose, guiGraphics, c0796oOM3793a.m3860a(this.f1228c).m5976a().m5670N(), i5 + 50, (i6 + 80) - 10, 85, 85, 0.0f, 0.5f);
                    C0119bk.m441b(poseStackPose, guiGraphics, C0195cx.f1566aJ, i5 + 50, i6 + 80 + 20, 100, 100);
                    C0119bk.m441b(poseStackPose, guiGraphics, C0195cx.f1566aJ, i5 + 50, i6 + 80 + 20, 100, 100);
                    C0119bk.m415a(guiGraphics, i5, i6, 1, 160, C0119bk.m365p());
                    C0119bk.m415a(guiGraphics, (i5 + 100) - 1, i6, 1, 160, C0119bk.m365p());
                    poseStackPose.pushPose();
                    poseStackPose.translate(0.0f, 0.0f, 100.0f);
                    int iHashCode = 6 * (itemM969a.hashCode() % 5);
                    C0119bk.m494a(this.f1585a, poseStackPose, guiGraphics, this.f1587b, (LivingEntity) c0099bQM315a, i5 + 50, i6 + 160 + 60, 90.0f, 0.0f, (-30) + iHashCode + Mth.sin(fM366g / 50.0f), 0.0f);
                    poseStackPose.popPose();
                    guiGraphics.disableScissor();
                    C0119bk.m423a(guiGraphics, i5, i6 + 100, 100, 60, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
                    C0119bk.m370a(this.font, guiGraphics, itemM969a.getName(itemM969a.getDefaultInstance()), i3 - 20, i4 - 65);
                    ObjectList<String> objectListM2131a = C0471iH.m2131a(this.font, C0471iH.m2130a((List<String>) new ObjectArrayList(Arrays.asList(this.f1232a.m970a()))), AbstractC0211dM.f1737gZ);
                    int size = objectListM2131a.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        C0119bk.m387a(poseStackPose, this.font, guiGraphics, (Component) Component.literal((String) objectListM2131a.get(i7)), i3 - 22, i4 + 45 + (i7 * 5), 0.5f);
                    }
                }
            }
        }
        for (C0127bs c0127bs : this.renderables) {
            if (c0127bs instanceof C0127bs) {
                c0127bs.m663a(this.f1587b, poseStackPose, this.font, guiGraphics, i, i2, fM366g);
            }
        }
    }
}
