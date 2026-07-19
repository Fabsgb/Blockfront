package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bv.class */
public class C0051bv {

    @NotNull
    private Screen b;
    protected int bm;
    protected int bn;
    protected int cM;
    protected int cN;

    @NotNull
    private final List<C0051bv> n = new ObjectArrayList();

    @NotNull
    private final List<AbstractWidget> o = new ObjectArrayList();
    private boolean aJ = false;
    private boolean aK = true;

    @Nullable
    private Component D = null;
    private boolean aB = false;
    private boolean aC = false;

    public C0051bv(int i, int i2, int i3, int i4, @NotNull Screen screen) {
        this.bm = i;
        this.bn = i2;
        this.cM = i3;
        this.cN = i4;
        this.b = screen;
    }

    @NotNull
    public C0051bv a(@NotNull Component component) {
        this.D = component;
        return this;
    }

    @NotNull
    public C0051bv a() {
        this.aB = true;
        return this;
    }

    @NotNull
    public C0051bv b() {
        this.aK = false;
        return this;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, fV fVVar) {
        D();
        E();
        this.n.forEach(c0051bv -> {
            c0051bv.a(minecraft, c0297l, fVVar);
        });
    }

    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, float f) {
        this.n.forEach(c0051bv -> {
            c0051bv.a(minecraft, c0297l, fVVar, f);
        });
        if (this.aJ) {
            if (!this.aC && this.aB) {
                this.aC = true;
                if (this.D != null) {
                    minecraft.getNarrator().sayNow(Component.literal(this.D.getString()));
                }
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pq.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
                return;
            }
            return;
        }
        this.aC = false;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, fV fVVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull iS iSVar, int i, int i2, float f, float f2) {
        this.aJ = C0040bk.b((double) this.bm, (double) this.bn, (double) this.cM, (double) this.cN, (double) i, (double) i2) && minecraft.screen == this.b;
        poseStack.pushPose();
        if (this.aK) {
            a(minecraft, fVVar, poseStack, guiGraphics, i, i2, f, f2);
        }
        Iterator<C0051bv> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().a(minecraft, c0297l, fVVar, poseStack, guiGraphics, font, iSVar, i, i2, f, f2);
        }
        Iterator<C0051bv> it2 = this.n.iterator();
        while (it2.hasNext()) {
            it2.next().a(minecraft, c0297l, fVVar, font, guiGraphics, i, i2, f2);
        }
        Iterator<AbstractWidget> it3 = this.o.iterator();
        while (it3.hasNext()) {
            it3.next().render(guiGraphics, i, i2, f2);
        }
        poseStack.popPose();
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.aJ) {
            a(font, guiGraphics, i, i2);
        }
        Iterator<AbstractWidget> it = this.o.iterator();
        while (it.hasNext()) {
            C0048bs c0048bs = (AbstractWidget) it.next();
            if (c0048bs instanceof C0048bs) {
                c0048bs.a(minecraft, guiGraphics.pose(), font, guiGraphics, i, i2, f);
            }
        }
    }

    protected void a(@NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        poseStack.pushPose();
        Iterator<C0051bv> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().a(minecraft, fVVar, poseStack, guiGraphics, i, i2, f, f2);
        }
        poseStack.popPose();
    }

    public void a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        if (this.D != null) {
            guiGraphics.renderTooltip(font, this.D, i, i2);
        }
        poseStackPose.popPose();
    }

    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        Iterator<AbstractWidget> it = this.o.iterator();
        while (it.hasNext()) {
            if (it.next().mouseScrolled(d, d2, d3, d4)) {
                return true;
            }
        }
        Iterator<C0051bv> it2 = this.n.iterator();
        while (it2.hasNext()) {
            if (it2.next().mouseScrolled(d, d2, d3, d4)) {
                return true;
            }
        }
        return false;
    }

    public boolean mouseReleased(double d, double d2, int i) {
        Iterator<AbstractWidget> it = this.o.iterator();
        while (it.hasNext()) {
            if (it.next().mouseReleased(d, d2, i)) {
                return true;
            }
        }
        Iterator<C0051bv> it2 = this.n.iterator();
        while (it2.hasNext()) {
            if (it2.next().mouseReleased(d, d2, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, double d, double d2, int i) {
        Iterator<AbstractWidget> it = this.o.iterator();
        while (it.hasNext()) {
            if (it.next().mouseClicked(d, d2, i)) {
                return true;
            }
        }
        Iterator<C0051bv> it2 = this.n.iterator();
        while (it2.hasNext()) {
            if (it2.next().a(minecraft, c0297l, fVVar, d, d2, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean keyPressed(int i, int i2, int i3) {
        return true;
    }

    public void D() {
        this.o.clear();
        this.n.forEach((v0) -> {
            v0.D();
        });
    }

    public void E() {
        this.n.forEach((v0) -> {
            v0.E();
        });
    }

    public boolean a(@NotNull AbstractWidget abstractWidget) {
        return this.o.add(abstractWidget);
    }

    public boolean a(@NotNull C0051bv c0051bv) {
        return this.n.add(c0051bv);
    }

    public boolean b(@NotNull C0051bv c0051bv) {
        return this.n.remove(c0051bv);
    }

    @NotNull
    public List<AbstractWidget> c() {
        return Collections.unmodifiableList(this.o);
    }

    public boolean b(@NotNull AbstractWidget abstractWidget) {
        return this.o.stream().anyMatch(abstractWidget2 -> {
            return abstractWidget2 == abstractWidget;
        });
    }

    public int t() {
        return this.cM;
    }

    public int height() {
        return this.cN;
    }

    public void c(int i) {
        this.bm = i;
    }

    public void d(int i) {
        this.bn = i;
    }

    public void e(int i) {
        this.cM = i;
    }

    public void f(int i) {
        this.cN = i;
    }

    protected void F() {
        this.n.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Screen m248a() {
        return this.b;
    }

    protected boolean q() {
        return this.aJ;
    }

    protected void f(boolean z) {
        this.aJ = z;
    }

    public void g(boolean z) {
        this.aK = z;
    }

    public int n() {
        return this.bm;
    }

    public int o() {
        return this.bn;
    }

    public void a(@NotNull Screen screen) {
        this.b = screen;
    }
}
