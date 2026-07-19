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

/* JADX INFO: renamed from: com.boehmod.blockfront.eg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eg.class */
public abstract class AbstractC0116eg {
    public dY<?> a;
    public int hI;
    public int hJ;
    private int hK;

    @NotNull
    protected final List<C0048bs> D = new ObjectArrayList();

    /* JADX INFO: renamed from: D, reason: collision with other field name */
    @Nullable
    private Component f118D = null;
    private boolean aJ = false;

    public abstract void n(@NotNull Minecraft minecraft);

    public abstract boolean v();

    public abstract int height();

    /* JADX INFO: renamed from: t */
    public abstract int mo265t();

    public void c(@Nullable Component component) {
        this.f118D = component;
    }

    public final void a(@NotNull dY<?> dYVar, int i, int i2, int i3) {
        this.a = dYVar;
        this.hK = i;
        this.hI = i2;
        this.hJ = i3;
        an();
    }

    protected void an() {
        this.D.clear();
        G();
    }

    public void G() {
    }

    public final boolean C() {
        return this.a.m339a(this);
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, int i, int i2, int i3) {
        for (C0048bs c0048bs : this.D) {
            if (c0048bs.mouseClicked(i, i2, i3)) {
                c0048bs.onClick(i, i2);
                return;
            }
        }
    }

    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull fV fVVar, @NotNull Font font, int i, int i2, float f, float f2) {
        this.D.forEach(c0048bs -> {
            c0048bs.render(guiGraphics, i, i2, f2);
        });
        this.aJ = this.a.a(this, i, i2);
    }

    public void b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull fV fVVar, @NotNull Font font, int i, int i2, float f, float f2) {
        if (this.f118D != null && this.aJ) {
            guiGraphics.renderTooltip(font, this.f118D, i, i2);
        }
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
    }

    public int X() {
        return 0;
    }

    public int W() {
        return 0;
    }

    public int R() {
        return 0;
    }

    public int S() {
        return 0;
    }

    public boolean D() {
        return this.aJ;
    }

    public void f(boolean z) {
        this.aJ = z;
    }

    public int Y() {
        return this.hK;
    }
}
