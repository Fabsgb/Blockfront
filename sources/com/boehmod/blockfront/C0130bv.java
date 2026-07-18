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

/* JADX INFO: renamed from: com.boehmod.blockfront.bv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bv.class */
public class C0130bv {

    /* JADX INFO: renamed from: b */
    @NotNull
    private Screen f937b;

    /* JADX INFO: renamed from: bm */
    protected int f940bm;

    /* JADX INFO: renamed from: bn */
    protected int f941bn;

    /* JADX INFO: renamed from: cM */
    protected int f942cM;

    /* JADX INFO: renamed from: cN */
    protected int f943cN;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final List<C0130bv> f938n = new ObjectArrayList();

    /* JADX INFO: renamed from: o */
    @NotNull
    private final List<AbstractWidget> f939o = new ObjectArrayList();

    /* JADX INFO: renamed from: aJ */
    private boolean f944aJ = false;

    /* JADX INFO: renamed from: aK */
    private boolean f945aK = true;

    /* JADX INFO: renamed from: D */
    @Nullable
    private Component f946D = null;

    /* JADX INFO: renamed from: aB */
    private boolean f947aB = false;

    /* JADX INFO: renamed from: aC */
    private boolean f948aC = false;

    public C0130bv(int i, int i2, int i3, int i4, @NotNull Screen screen) {
        this.f940bm = i;
        this.f941bn = i2;
        this.f942cM = i3;
        this.f943cN = i4;
        this.f937b = screen;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0130bv m682a(@NotNull Component component) {
        this.f946D = component;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0130bv m683a() {
        this.f947aB = true;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0130bv m684b() {
        this.f945aK = false;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void mo685a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0326fV c0326fV) {
        m692D();
        m693E();
        this.f938n.forEach(c0130bv -> {
            c0130bv.mo685a(minecraft, c0622l, c0326fV);
        });
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo686a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, float f) {
        this.f938n.forEach(c0130bv -> {
            c0130bv.mo686a(minecraft, c0622l, c0326fV, f);
        });
        if (this.f944aJ) {
            if (!this.f948aC && this.f947aB) {
                this.f948aC = true;
                if (this.f946D != null) {
                    minecraft.getNarrator().sayNow(Component.literal(this.f946D.getString()));
                }
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
                return;
            }
            return;
        }
        this.f948aC = false;
    }

    /* JADX INFO: renamed from: a */
    public void mo687a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull C0482iS c0482iS, int i, int i2, float f, float f2) {
        this.f944aJ = C0119bk.m473b((double) this.f940bm, (double) this.f941bn, (double) this.f942cM, (double) this.f943cN, (double) i, (double) i2) && minecraft.screen == this.f937b;
        poseStack.pushPose();
        if (this.f945aK) {
            mo689a(minecraft, c0326fV, poseStack, guiGraphics, i, i2, f, f2);
        }
        Iterator<C0130bv> it = this.f938n.iterator();
        while (it.hasNext()) {
            it.next().mo687a(minecraft, c0622l, c0326fV, poseStack, guiGraphics, font, c0482iS, i, i2, f, f2);
        }
        Iterator<C0130bv> it2 = this.f938n.iterator();
        while (it2.hasNext()) {
            it2.next().m688a(minecraft, c0622l, c0326fV, font, guiGraphics, i, i2, f2);
        }
        Iterator<AbstractWidget> it3 = this.f939o.iterator();
        while (it3.hasNext()) {
            it3.next().render(guiGraphics, i, i2, f2);
        }
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public void m688a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.f944aJ) {
            m690a(font, guiGraphics, i, i2);
        }
        Iterator<AbstractWidget> it = this.f939o.iterator();
        while (it.hasNext()) {
            C0127bs c0127bs = (AbstractWidget) it.next();
            if (c0127bs instanceof C0127bs) {
                c0127bs.m663a(minecraft, guiGraphics.pose(), font, guiGraphics, i, i2, f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo689a(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        poseStack.pushPose();
        Iterator<C0130bv> it = this.f938n.iterator();
        while (it.hasNext()) {
            it.next().mo689a(minecraft, c0326fV, poseStack, guiGraphics, i, i2, f, f2);
        }
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public void m690a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        if (this.f946D != null) {
            guiGraphics.renderTooltip(font, this.f946D, i, i2);
        }
        poseStackPose.popPose();
    }

    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        Iterator<AbstractWidget> it = this.f939o.iterator();
        while (it.hasNext()) {
            if (it.next().mouseScrolled(d, d2, d3, d4)) {
                return true;
            }
        }
        Iterator<C0130bv> it2 = this.f938n.iterator();
        while (it2.hasNext()) {
            if (it2.next().mouseScrolled(d, d2, d3, d4)) {
                return true;
            }
        }
        return false;
    }

    public boolean mouseReleased(double d, double d2, int i) {
        Iterator<AbstractWidget> it = this.f939o.iterator();
        while (it.hasNext()) {
            if (it.next().mouseReleased(d, d2, i)) {
                return true;
            }
        }
        Iterator<C0130bv> it2 = this.f938n.iterator();
        while (it2.hasNext()) {
            if (it2.next().mouseReleased(d, d2, i)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo691a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, double d, double d2, int i) {
        Iterator<AbstractWidget> it = this.f939o.iterator();
        while (it.hasNext()) {
            if (it.next().mouseClicked(d, d2, i)) {
                return true;
            }
        }
        Iterator<C0130bv> it2 = this.f938n.iterator();
        while (it2.hasNext()) {
            if (it2.next().mo691a(minecraft, c0622l, c0326fV, d, d2, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean keyPressed(int i, int i2, int i3) {
        return true;
    }

    /* JADX INFO: renamed from: D */
    public void m692D() {
        this.f939o.clear();
        this.f938n.forEach((v0) -> {
            v0.m692D();
        });
    }

    /* JADX INFO: renamed from: E */
    public void m693E() {
        this.f938n.forEach((v0) -> {
            v0.m693E();
        });
    }

    /* JADX INFO: renamed from: a */
    public boolean m694a(@NotNull AbstractWidget abstractWidget) {
        return this.f939o.add(abstractWidget);
    }

    /* JADX INFO: renamed from: a */
    public boolean m695a(@NotNull C0130bv c0130bv) {
        return this.f938n.add(c0130bv);
    }

    /* JADX INFO: renamed from: b */
    public boolean m696b(@NotNull C0130bv c0130bv) {
        return this.f938n.remove(c0130bv);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public List<AbstractWidget> m697c() {
        return Collections.unmodifiableList(this.f939o);
    }

    /* JADX INFO: renamed from: b */
    public boolean m698b(@NotNull AbstractWidget abstractWidget) {
        return this.f939o.stream().anyMatch(abstractWidget2 -> {
            return abstractWidget2 == abstractWidget;
        });
    }

    /* JADX INFO: renamed from: t */
    public int m699t() {
        return this.f942cM;
    }

    public int height() {
        return this.f943cN;
    }

    /* JADX INFO: renamed from: c */
    public void m700c(int i) {
        this.f940bm = i;
    }

    /* JADX INFO: renamed from: d */
    public void m701d(int i) {
        this.f941bn = i;
    }

    /* JADX INFO: renamed from: e */
    public void m702e(int i) {
        this.f942cM = i;
    }

    /* JADX INFO: renamed from: f */
    public void m703f(int i) {
        this.f943cN = i;
    }

    /* JADX INFO: renamed from: F */
    protected void m704F() {
        this.f938n.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Screen m705a() {
        return this.f937b;
    }

    /* JADX INFO: renamed from: q */
    protected boolean m706q() {
        return this.f944aJ;
    }

    /* JADX INFO: renamed from: f */
    protected void m707f(boolean z) {
        this.f944aJ = z;
    }

    /* JADX INFO: renamed from: g */
    public void m708g(boolean z) {
        this.f945aK = z;
    }

    /* JADX INFO: renamed from: n */
    public int m709n() {
        return this.f940bm;
    }

    /* JADX INFO: renamed from: o */
    public int m710o() {
        return this.f941bn;
    }

    /* JADX INFO: renamed from: a */
    public void m711a(@NotNull Screen screen) {
        this.f937b = screen;
    }
}
