package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.eg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eg.class */
public abstract class AbstractC0284eg {

    /* JADX INFO: renamed from: a */
    public AbstractC0223dY<?> f2165a;

    /* JADX INFO: renamed from: hI */
    public int f2166hI;

    /* JADX INFO: renamed from: hJ */
    public int f2167hJ;

    /* JADX INFO: renamed from: hK */
    private int f2169hK;

    /* JADX INFO: renamed from: D */
    @NotNull
    protected final List<C0127bs> f2163D = new ObjectArrayList();

    /* JADX INFO: renamed from: D */
    @Nullable
    private Component f2164D = null;

    /* JADX INFO: renamed from: aJ */
    private boolean f2168aJ = false;

    /* JADX INFO: renamed from: n */
    public abstract void mo810n(@NotNull Minecraft minecraft);

    /* JADX INFO: renamed from: v */
    public abstract boolean mo811v();

    public abstract int height();

    /* JADX INFO: renamed from: t */
    public abstract int mo812t();

    /* JADX INFO: renamed from: c */
    public void m1495c(@Nullable Component component) {
        this.f2164D = component;
    }

    /* JADX INFO: renamed from: a */
    public final void m1496a(@NotNull AbstractC0223dY<?> abstractC0223dY, int i, int i2, int i3) {
        this.f2165a = abstractC0223dY;
        this.f2169hK = i;
        this.f2166hI = i2;
        this.f2167hJ = i3;
        mo1490an();
    }

    /* JADX INFO: renamed from: an */
    protected void mo1490an() {
        this.f2163D.clear();
        m1497G();
    }

    /* JADX INFO: renamed from: G */
    public void m1497G() {
    }

    /* JADX INFO: renamed from: C */
    public final boolean m1498C() {
        return this.f2165a.m1321a(this);
    }

    /* JADX INFO: renamed from: a */
    public void mo817a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, int i, int i2, int i3) {
        for (C0127bs c0127bs : this.f2163D) {
            if (c0127bs.mouseClicked(i, i2, i3)) {
                c0127bs.onClick(i, i2);
                return;
            }
        }
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo800a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull C0326fV c0326fV, @NotNull Font font, int i, int i2, float f, float f2) {
        this.f2163D.forEach(c0127bs -> {
            c0127bs.render(guiGraphics, i, i2, f2);
        });
        this.f2168aJ = this.f2165a.mo1310a(this, i, i2);
    }

    /* JADX INFO: renamed from: b */
    public void mo1479b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull C0326fV c0326fV, @NotNull Font font, int i, int i2, float f, float f2) {
        if (this.f2164D != null && this.f2168aJ) {
            guiGraphics.renderTooltip(font, this.f2164D, i, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo1480a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
    }

    /* JADX INFO: renamed from: X */
    public int mo1487X() {
        return 0;
    }

    /* JADX INFO: renamed from: W */
    public int mo1486W() {
        return 0;
    }

    /* JADX INFO: renamed from: R */
    public int mo1299R() {
        return 0;
    }

    /* JADX INFO: renamed from: S */
    public int mo1300S() {
        return 0;
    }

    /* JADX INFO: renamed from: D */
    public boolean m1499D() {
        return this.f2168aJ;
    }

    /* JADX INFO: renamed from: f */
    public void m1500f(boolean z) {
        this.f2168aJ = z;
    }

    /* JADX INFO: renamed from: Y */
    public int m1501Y() {
        return this.f2169hK;
    }
}
