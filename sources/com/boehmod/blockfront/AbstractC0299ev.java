package com.boehmod.blockfront;

import javax.annotation.Nonnull;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.IAbstractWidgetExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ev */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ev.class */
@OnlyIn(Dist.CLIENT)
public abstract class AbstractC0299ev extends AbstractWidget implements IAbstractWidgetExtension {

    /* JADX INFO: renamed from: cu */
    @Nonnull
    private static final ResourceLocation f2279cu = C0564jv.m2555d("textures/gui/widget/rating/star_empty.png");

    /* JADX INFO: renamed from: cv */
    @Nonnull
    private static final ResourceLocation f2280cv = C0564jv.m2555d("textures/gui/widget/rating/star_full.png");

    /* JADX INFO: renamed from: ej */
    protected static final float f2281ej = 5.0f;

    /* JADX INFO: renamed from: io */
    private final int f2282io;

    /* JADX INFO: renamed from: ek */
    private float f2283ek;

    /* JADX INFO: renamed from: el */
    private float f2284el;

    /* JADX INFO: renamed from: b */
    protected abstract void mo1529b(float f);

    public AbstractC0299ev(int i, int i2, int i3, int i4, int i5) {
        super(i, i2, i3, i4, Component.empty());
        this.f2283ek = 0.0f;
        this.f2284el = 0.0f;
        this.f2282io = i5;
    }

    /* JADX INFO: renamed from: G */
    protected boolean mo1526G() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    private float m1579a(int i) {
        float width = (getWidth() - (4.0f * this.f2282io)) / 5.0f;
        float x = i - getX();
        if (x < 0.0f) {
            return 1.0f;
        }
        if (x >= getWidth()) {
            return 5.0f;
        }
        float f = 0.0f;
        for (int i2 = 0; i2 < 5.0f; i2++) {
            if (x <= f + width) {
                return i2 + 1;
            }
            f += width + this.f2282io;
        }
        return 5.0f;
    }

    public void onClick(double d, double d2, int i) {
        float fM1579a = m1579a((int) d);
        this.f2283ek = fM1579a;
        mo1529b(fM1579a);
    }

    protected void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fM1579a = (isHovered() && mo1526G()) ? m1579a(i) : Math.max(1.0f, this.f2283ek);
        this.f2284el = fM1579a;
        int width = (getWidth() - ((int) (4.0f * this.f2282io))) / 5;
        int height = getHeight();
        int x = getX();
        for (int i3 = 0; i3 < 5.0f; i3++) {
            guiGraphics.blit(fM1579a >= ((float) i3) + 1.0f ? f2280cv : f2279cu, x, getY(), width, height, 0.0f, 0.0f, width, height, width, height);
            x += width + this.f2282io;
        }
    }

    protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
    }

    /* JADX INFO: renamed from: s */
    protected float m1580s() {
        return this.f2283ek;
    }

    /* JADX INFO: renamed from: c */
    protected void m1581c(float f) {
        this.f2283ek = f;
        this.f2284el = f;
    }

    /* JADX INFO: renamed from: t */
    protected float m1582t() {
        return this.f2284el;
    }
}
