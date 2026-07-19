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

/* JADX INFO: renamed from: com.boehmod.blockfront.ev, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ev.class */
@OnlyIn(Dist.CLIENT)
public abstract class AbstractC0131ev extends AbstractWidget implements IAbstractWidgetExtension {

    @Nonnull
    private static final ResourceLocation cu = C0265jv.d("textures/gui/widget/rating/star_empty.png");

    @Nonnull
    private static final ResourceLocation cv = C0265jv.d("textures/gui/widget/rating/star_full.png");
    protected static final float ej = 5.0f;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private final int f414io;
    private float ek;
    private float el;

    protected abstract void b(float f);

    public AbstractC0131ev(int i, int i2, int i3, int i4, int i5) {
        super(i, i2, i3, i4, Component.empty());
        this.ek = 0.0f;
        this.el = 0.0f;
        this.f414io = i5;
    }

    protected boolean G() {
        return true;
    }

    private float a(int i) {
        float width = (getWidth() - (4.0f * this.f414io)) / 5.0f;
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
            f += width + this.f414io;
        }
        return 5.0f;
    }

    public void onClick(double d, double d2, int i) {
        float fA = a((int) d);
        this.ek = fA;
        b(fA);
    }

    protected void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fA = (isHovered() && G()) ? a(i) : Math.max(1.0f, this.ek);
        this.el = fA;
        int width = (getWidth() - ((int) (4.0f * this.f414io))) / 5;
        int height = getHeight();
        int x = getX();
        for (int i3 = 0; i3 < 5.0f; i3++) {
            guiGraphics.blit(fA >= ((float) i3) + 1.0f ? cv : cu, x, getY(), width, height, 0.0f, 0.0f, width, height, width, height);
            x += width + this.f414io;
        }
    }

    protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
    }

    protected float s() {
        return this.ek;
    }

    protected void c(float f) {
        this.ek = f;
        this.el = f;
    }

    protected float t() {
        return this.el;
    }
}
