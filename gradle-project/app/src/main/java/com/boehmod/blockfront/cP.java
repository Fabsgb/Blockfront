package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cP.class */
public abstract class cP extends C0081cy {
    private static final Component dj;
    public static final MutableComponent c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    protected final oF<?, ?, ?> f86c;
    protected final List<cO> v;
    protected final Screen i;
    protected final List<C0408pc> w;
    protected cO a;
    protected int fd;
    static final /* synthetic */ boolean bf;

    public abstract void a(@NotNull Item item, int i);

    static {
        bf = !cP.class.desiredAssertionStatus();
        dj = Component.translatable("bf.screen.ingame.gun.store");
        c = Component.translatable("bf.message.selected").withStyle(ChatFormatting.BOLD);
    }

    protected cP(Screen screen, List<C0408pc> list, oF<?, ?, ?> oFVar) {
        super(dj);
        this.v = new ObjectArrayList();
        this.a = null;
        this.fd = 20;
        this.w = list;
        this.i = screen;
        this.f86c = oFVar;
    }

    public void a(C0408pc c0408pc, String[] strArr) {
        this.v.add(new cO(0, 0, c0408pc, strArr, 0, 0));
    }

    public void init() {
        super.init();
        C0048bs c0048bs = new C0048bs((this.width / 2) - 150, 18, 40, 10, Component.literal("< ").append(Component.translatable("bf.menu.button.back")), button -> {
            this.b.setScreen(this.i);
        });
        c0048bs.a(C0048bs.a.NONE);
        addRenderableWidget(c0048bs);
        W();
    }

    public void W() {
        int i = (this.width / 2) - 140;
        int i2 = (this.height / 2) - 72;
        int size = this.v.size();
        for (int i3 = 0; i3 < size; i3++) {
            cO cOVar = this.v.get(i3);
            cOVar.c(i);
            cOVar.d(i2 + (i3 * 22));
            cOVar.e(100);
            cOVar.f(20);
        }
    }

    public boolean keyPressed(int i, int i2, int i3) {
        if (!bf && this.b == null) {
            throw new AssertionError();
        }
        this.b.setScreen(this.i);
        return true;
    }

    public void tick() {
        if (!bf && this.b == null) {
            throw new AssertionError();
        }
        int i = this.fd;
        this.fd = i - 1;
        if (i <= 0) {
            this.b.setScreen(new cQ(null, this.w, this.f86c));
        }
    }

    public boolean isPauseScreen() {
        return false;
    }

    public boolean mouseClicked(double d, double d2, int i) {
        if (!bf && this.b == null) {
            throw new AssertionError();
        }
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            cO cOVar = this.v.get(i2);
            if (cOVar.a((int) d, (int) d2) && i == 0) {
                a(cOVar.a(), i2 + 1);
                this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.0f));
            }
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fG = C0040bk.g();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0040bk.c(guiGraphics, 0, 0, this.width, 30, C0040bk.p());
        C0040bk.c(guiGraphics, 0, this.height - 30, this.width, 30, C0040bk.p());
        C0040bk.c(this.font, guiGraphics, (Component) Component.translatable("bf.message.weapon.vendor").withStyle(ChatFormatting.BOLD), i3, 10);
        super.render(guiGraphics, i, i2, f);
        C0040bk.c(guiGraphics, i3 - 150, i4 - 80, C0163g.g, (this.v.size() * 22) + 15, C0040bk.p());
        this.v.forEach(cOVar -> {
            cOVar.c(guiGraphics, this.font);
            if (cOVar.a(i, i2)) {
                this.a = cOVar;
                cOVar.a(this.e, guiGraphics, 1, fG);
            }
        });
        int i5 = i3 - 25;
        int i6 = i4 - 80;
        C0040bk.c(guiGraphics, i5, i6, 100, 160, C0040bk.p());
        C0040bk.a(this.font, guiGraphics, (Component) c, i3 - 20, i4 - 75);
        if (this.a != null) {
            Item itemA = this.a.a();
            bQ bQVarA = C0040bk.a.a(this.b);
            if (bQVarA.getMainHandItem().isEmpty() || bQVarA.getMainHandItem().getItem() != itemA) {
                bQVarA.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(itemA));
            }
            C0040bk.a(guiGraphics, i5, i6, 100, 160);
            if (this.f86c != null) {
                if (!bf && this.b.player == null) {
                    throw new AssertionError();
                }
                oO oOVarA = this.f86c.b().a(this.b.player.getUUID());
                if (oOVarA != null) {
                    C0040bk.b(poseStackPose, guiGraphics, oOVarA.a(this.f86c).m1156a().N(), i5 + 50, (i6 + 80) - 10, 85, 85, 0.0f, 0.5f);
                    C0040bk.b(poseStackPose, guiGraphics, C0080cx.aJ, i5 + 50, i6 + 80 + 20, 100, 100);
                    C0040bk.b(poseStackPose, guiGraphics, C0080cx.aJ, i5 + 50, i6 + 80 + 20, 100, 100);
                    C0040bk.a(guiGraphics, i5, i6, 1, 160, C0040bk.p());
                    C0040bk.a(guiGraphics, (i5 + 100) - 1, i6, 1, 160, C0040bk.p());
                    poseStackPose.pushPose();
                    poseStackPose.translate(0.0f, 0.0f, 100.0f);
                    int iHashCode = 6 * (itemA.hashCode() % 5);
                    C0040bk.a(this.a, poseStackPose, guiGraphics, this.b, (LivingEntity) bQVarA, i5 + 50, i6 + 160 + 60, 90.0f, 0.0f, (-30) + iHashCode + Mth.sin(fG / 50.0f), 0.0f);
                    poseStackPose.popPose();
                    guiGraphics.disableScissor();
                    C0040bk.a(guiGraphics, i5, i6 + 100, 100, 60, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
                    C0040bk.a(this.font, guiGraphics, itemA.getName(itemA.getDefaultInstance()), i3 - 20, i4 - 65);
                    ObjectList<String> objectListA = iH.a(this.font, iH.a((List<String>) new ObjectArrayList(Arrays.asList(this.a.m275a()))), dM.gZ);
                    int size = objectListA.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        C0040bk.a(poseStackPose, this.font, guiGraphics, (Component) Component.literal((String) objectListA.get(i7)), i3 - 22, i4 + 45 + (i7 * 5), 0.5f);
                    }
                }
            }
        }
        for (C0048bs c0048bs : this.renderables) {
            if (c0048bs instanceof C0048bs) {
                c0048bs.a(this.b, poseStackPose, this.font, guiGraphics, i, i2, fG);
            }
        }
    }
}
