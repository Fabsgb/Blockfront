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

/* JADX INFO: renamed from: com.boehmod.blockfront.eI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eI.class */
@OnlyIn(Dist.CLIENT)
public abstract class AbstractC0261eI extends AbstractWidget implements IAbstractWidgetExtension {

    /* JADX INFO: renamed from: ct */
    @Nonnull
    private static final ResourceLocation f2149ct = C0532jO.m2378d("textures/gui/widget/rating/star_empty.png");

    /* JADX INFO: renamed from: cu */
    @Nonnull
    private static final ResourceLocation f2150cu = C0532jO.m2378d("textures/gui/widget/rating/star_full.png");

    /* JADX INFO: renamed from: em */
    protected static final float f2151em = 5.0f;

    /* JADX INFO: renamed from: jE */
    private final int f2152jE;

    /* JADX INFO: renamed from: en */
    private float f2153en;

    /* JADX INFO: renamed from: eo */
    private float f2154eo;

    /* JADX INFO: renamed from: b */
    protected abstract void mo1481b(float f);

    public AbstractC0261eI(int i, int i2, int i3, int i4, int i5) {
        super(i, i2, i3, i4, Component.empty());
        this.f2153en = 0.0f;
        this.f2154eo = 0.0f;
        this.f2152jE = i5;
    }

    /* JADX INFO: renamed from: H */
    protected boolean mo1482H() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    private float m1483a(int i) {
        float width = (getWidth() - (4.0f * this.f2152jE)) / 5.0f;
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
            f += width + this.f2152jE;
        }
        return 5.0f;
    }

    public void onClick(double d, double d2, int i) {
        float fM1483a = m1483a((int) d);
        this.f2153en = fM1483a;
        mo1481b(fM1483a);
    }

    protected void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fM1483a = (isHovered() && mo1482H()) ? m1483a(i) : Math.max(1.0f, this.f2153en);
        this.f2154eo = fM1483a;
        int width = (getWidth() - ((int) (4.0f * this.f2152jE))) / 5;
        int height = getHeight();
        int x = getX();
        for (int i3 = 0; i3 < 5.0f; i3++) {
            guiGraphics.blit(fM1483a >= ((float) i3) + 1.0f ? f2150cu : f2149ct, x, getY(), width, height, 0.0f, 0.0f, width, height, width, height);
            x += width + this.f2152jE;
        }
    }

    protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
    }

    /* JADX INFO: renamed from: s */
    protected float m1484s() {
        return this.f2153en;
    }

    /* JADX INFO: renamed from: c */
    protected void m1485c(float f) {
        this.f2153en = f;
        this.f2154eo = f;
    }

    /* JADX INFO: renamed from: t */
    protected float m1486t() {
        return this.f2154eo;
    }
}
