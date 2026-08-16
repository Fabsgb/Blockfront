package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cY.class */
public abstract class AbstractC0161cY extends C0144cH {

    /* JADX INFO: renamed from: dl */
    private static final Component f1316dl;

    /* JADX INFO: renamed from: c */
    public static final MutableComponent f1317c;

    /* JADX INFO: renamed from: c */
    protected final AbstractC0863pb<?, ?, ?> f1318c;

    /* JADX INFO: renamed from: x */
    protected final List<C0160cX> f1319x;

    /* JADX INFO: renamed from: h */
    protected final Screen f1320h;

    /* JADX INFO: renamed from: y */
    protected final List<C0886py> f1321y;

    /* JADX INFO: renamed from: a */
    protected C0160cX f1322a;

    /* JADX INFO: renamed from: gd */
    protected int f1323gd;

    /* JADX INFO: renamed from: bj */
    static final /* synthetic */ boolean f1324bj;

    /* JADX INFO: renamed from: a */
    public abstract void mo1031a(@NotNull Item item, int i);

    static {
        f1324bj = !AbstractC0161cY.class.desiredAssertionStatus();
        f1316dl = Component.translatable("bf.screen.ingame.gun.store");
        f1317c = Component.translatable("bf.message.selected").withStyle(ChatFormatting.BOLD);
    }

    protected AbstractC0161cY(Screen screen, List<C0886py> list, AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        super(f1316dl);
        this.f1319x = new ObjectArrayList();
        this.f1322a = null;
        this.f1323gd = 20;
        this.f1321y = list;
        this.f1320h = screen;
        this.f1318c = abstractC0863pb;
    }

    /* JADX INFO: renamed from: a */
    public void m1029a(C0886py c0886py, String[] strArr) {
        this.f1319x.add(new C0160cX(0, 0, c0886py, strArr, 0, 0));
    }

    public void init() {
        super.init();
        C0085bB c0085bB = new C0085bB((this.width / 2) - 150, 18, 40, 10, Component.literal("< ").append(Component.translatable("bf.menu.button.back")), button -> {
            this.f1058a.setScreen(this.f1320h);
        });
        c0085bB.m328a(C0085bB.a.NONE);
        addRenderableWidget(c0085bB);
        m1030aa();
    }

    /* JADX INFO: renamed from: aa */
    public void m1030aa() {
        int i = (this.width / 2) - 140;
        int i2 = (this.height / 2) - 72;
        int size = this.f1319x.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0160cX c0160cX = this.f1319x.get(i3);
            c0160cX.m1025c(i);
            c0160cX.m1026d(i2 + (i3 * 22));
            c0160cX.m1027e(100);
            c0160cX.m1028f(20);
        }
    }

    public boolean keyPressed(int i, int i2, int i3) {
        if (!f1324bj && this.f1058a == null) {
            throw new AssertionError();
        }
        this.f1058a.setScreen(this.f1320h);
        return true;
    }

    public void tick() {
        if (!f1324bj && this.f1058a == null) {
            throw new AssertionError();
        }
        int i = this.f1323gd;
        this.f1323gd = i - 1;
        if (i <= 0) {
            this.f1058a.setScreen(new C0162cZ(null, this.f1321y, this.f1318c));
        }
    }

    public boolean isPauseScreen() {
        return false;
    }

    public boolean mouseClicked(double d, double d2, int i) {
        if (!f1324bj && this.f1058a == null) {
            throw new AssertionError();
        }
        int size = this.f1319x.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0160cX c0160cX = this.f1319x.get(i2);
            if (c0160cX.m1022a((int) d, (int) d2) && i == 0) {
                mo1031a(c0160cX.m1023a(), i2 + 1);
                this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.0f));
            }
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fM466g = C0129bt.m466g();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0129bt.m591c(guiGraphics, 0, 0, this.width, 30, C0129bt.m465t());
        C0129bt.m591c(guiGraphics, 0, this.height - 30, this.width, 30, C0129bt.m465t());
        C0129bt.m483c(this.font, guiGraphics, (Component) Component.translatable("bf.message.weapon.vendor").withStyle(ChatFormatting.BOLD), i3, 10);
        super.render(guiGraphics, i, i2, f);
        C0129bt.m591c(guiGraphics, i3 - 150, i4 - 80, C0358g.f2490g, (this.f1319x.size() * 22) + 15, C0129bt.m465t());
        this.f1319x.forEach(c0160cX -> {
            c0160cX.m1020c(guiGraphics, this.font);
            if (c0160cX.m1022a(i, i2)) {
                this.f1322a = c0160cX;
                c0160cX.m1021a(this.f1057f, guiGraphics, 1, fM466g);
            }
        });
        int i5 = i3 - 25;
        int i6 = i4 - 80;
        C0129bt.m591c(guiGraphics, i5, i6, 100, 160, C0129bt.m465t());
        C0129bt.m470a(this.font, guiGraphics, (Component) f1317c, i3 - 20, i4 - 75);
        if (this.f1322a != null) {
            Item itemM1023a = this.f1322a.m1023a();
            C0109bZ c0109bZM1038a = C0129bt.f871a.m1038a(this.f1058a);
            if (c0109bZM1038a.getMainHandItem().isEmpty() || c0109bZM1038a.getMainHandItem().getItem() != itemM1023a) {
                c0109bZM1038a.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(itemM1023a));
            }
            C0129bt.m618a(guiGraphics, i5, i6, 100, 160);
            if (this.f1318c != null) {
                if (!f1324bj && this.f1058a.player == null) {
                    throw new AssertionError();
                }
                C0872pk c0872pkM4229a = this.f1318c.m4018b().m4229a(this.f1058a.player.getUUID());
                if (c0872pkM4229a != null) {
                    C0129bt.m545b(poseStackPose, guiGraphics, c0872pkM4229a.m4296a(this.f1318c).m6179a().m6158O(), i5 + 50, (i6 + 80) - 10, 85, 85, 0.0f, 0.5f);
                    C0129bt.m541b(poseStackPose, guiGraphics, C0143cG.f1039aJ, i5 + 50, i6 + 80 + 20, 100, 100);
                    C0129bt.m541b(poseStackPose, guiGraphics, C0143cG.f1039aJ, i5 + 50, i6 + 80 + 20, 100, 100);
                    C0129bt.m515a(guiGraphics, i5, i6, 1, 160, C0129bt.m465t());
                    C0129bt.m515a(guiGraphics, (i5 + 100) - 1, i6, 1, 160, C0129bt.m465t());
                    poseStackPose.pushPose();
                    poseStackPose.translate(0.0f, 0.0f, 100.0f);
                    C0129bt.m594a(this.f1056a, poseStackPose, guiGraphics, this.f1058a, (LivingEntity) c0109bZM1038a, i5 + 50, i6 + 160 + 60, 90.0f, 0.0f, (-30) + (6 * (itemM1023a.hashCode() % 5)) + Mth.sin(fM466g / 50.0f), 0.0f);
                    poseStackPose.popPose();
                    guiGraphics.disableScissor();
                    C0129bt.m523a(guiGraphics, i5, i6 + 100, 100, 60, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
                    C0129bt.m470a(this.font, guiGraphics, itemM1023a.getName(itemM1023a.getDefaultInstance()), i3 - 20, i4 - 65);
                    ObjectList<String> objectListM2458a = C0544ja.m2458a(this.font, C0544ja.m2457a((List<String>) new ObjectArrayList(Arrays.asList(this.f1322a.m1024a()))), AbstractC0223dX.f1766ij);
                    int size = objectListM2458a.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        C0129bt.m487a(poseStackPose, this.font, guiGraphics, (Component) Component.literal((String) objectListM2458a.get(i7)), i3 - 22, i4 + 45 + (i7 * 5), 0.5f);
                    }
                }
            }
        }
        for (C0085bB c0085bB : this.renderables) {
            if (c0085bB instanceof C0085bB) {
                c0085bB.m338a(this.f1058a, poseStackPose, this.font, guiGraphics, i, i2, fM466g);
            }
        }
    }
}
