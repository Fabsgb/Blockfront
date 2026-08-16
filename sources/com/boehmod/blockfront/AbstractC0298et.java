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

/* JADX INFO: renamed from: com.boehmod.blockfront.et */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/et.class */
public abstract class AbstractC0298et {

    /* JADX INFO: renamed from: a */
    public AbstractC0288ej<?> f2338a;

    /* JADX INFO: renamed from: iY */
    public int f2339iY;

    /* JADX INFO: renamed from: iZ */
    public int f2340iZ;

    /* JADX INFO: renamed from: ja */
    private int f2342ja;

    /* JADX INFO: renamed from: F */
    @NotNull
    protected final List<C0085bB> f2336F = new ObjectArrayList();

    /* JADX INFO: renamed from: D */
    @Nullable
    private Component f2337D = null;

    /* JADX INFO: renamed from: aO */
    private boolean f2341aO = false;

    /* JADX INFO: renamed from: o */
    public abstract void mo864o(@NotNull Minecraft minecraft);

    /* JADX INFO: renamed from: w */
    public abstract boolean mo865w();

    public abstract int height();

    /* JADX INFO: renamed from: x */
    public abstract int mo866x();

    /* JADX INFO: renamed from: c */
    public void m1611c(@Nullable Component component) {
        this.f2337D = component;
    }

    /* JADX INFO: renamed from: a */
    public final void m1612a(@NotNull AbstractC0288ej<?> abstractC0288ej, int i, int i2, int i3) {
        this.f2338a = abstractC0288ej;
        this.f2342ja = i;
        this.f2339iY = i2;
        this.f2340iZ = i3;
        mo1606as();
    }

    /* JADX INFO: renamed from: as */
    protected void mo1606as() {
        this.f2336F.clear();
        m1613K();
    }

    /* JADX INFO: renamed from: K */
    public void m1613K() {
    }

    /* JADX INFO: renamed from: D */
    public final boolean m1614D() {
        return this.f2338a.m1582a(this);
    }

    /* JADX INFO: renamed from: a */
    public void mo871a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, int i, int i2, int i3) {
        for (C0085bB c0085bB : this.f2336F) {
            if (c0085bB.mouseClicked(i, i2, i3)) {
                c0085bB.onClick(i, i2);
                return;
            }
        }
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        this.f2336F.forEach(c0085bB -> {
            c0085bB.render(guiGraphics, i, i2, f2);
        });
        this.f2341aO = this.f2338a.mo1571a(this, i, i2);
    }

    /* JADX INFO: renamed from: b */
    public void mo1591b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        if (this.f2337D != null && this.f2341aO) {
            guiGraphics.renderTooltip(font, this.f2337D, i, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo1596a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
    }

    /* JADX INFO: renamed from: ah */
    public int mo1603ah() {
        return 0;
    }

    /* JADX INFO: renamed from: ag */
    public int mo1602ag() {
        return 0;
    }

    /* JADX INFO: renamed from: ab */
    public int mo1561ab() {
        return 0;
    }

    /* JADX INFO: renamed from: U */
    public int mo1248U() {
        return 0;
    }

    /* JADX INFO: renamed from: E */
    public boolean m1615E() {
        return this.f2341aO;
    }

    /* JADX INFO: renamed from: f */
    public void m1616f(boolean z) {
        this.f2341aO = z;
    }

    /* JADX INFO: renamed from: ai */
    public int m1617ai() {
        return this.f2342ja;
    }
}
