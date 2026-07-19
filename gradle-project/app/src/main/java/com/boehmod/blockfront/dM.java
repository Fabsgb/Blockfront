package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dM.class */
public abstract class dM extends AbstractC0079cw {
    public static final int gZ = 190;
    public static final int ha = 60;
    public static final int hb = 80;
    public static final int hc = 20;

    @NotNull
    public static final ResourceLocation bY = C0265jv.d("textures/gui/cornershadow.png");
    public static final int hd = C0040bk.p();
    public static final int he = 15;

    @NotNull
    protected final List<FormattedCharSequence> B;
    private float cS;
    private float cT;
    protected boolean bF;
    protected boolean bG;

    @NotNull
    private final Component gA;

    protected abstract int E();

    public dM(@Nullable Screen screen, @NotNull Component component) {
        super(screen, component);
        this.B = new ObjectArrayList();
        this.cT = 0.0f;
        this.bF = false;
        this.bG = true;
        this.gA = component;
    }

    public boolean a(double d, double d2) {
        int size = 60 + (11 * this.B.size()) + 30 + E();
        int i = (this.width / 2) - C0093dj.gd;
        return d < ((double) i) || d > ((double) (i + 220)) || d2 < 35.0d || d2 > ((double) (35 + size));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends dM> T a() {
        this.bG = false;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends dM> T a(@NotNull Component component) {
        if (component.getString().isEmpty()) {
            this.B.add(component.getVisualOrderText());
        } else {
            this.B.addAll(this.font.split(component, gZ));
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends dM> T a(@NotNull Component... componentArr) {
        for (Component component : componentArr) {
            a(component);
        }
        return this;
    }

    public void onClose() {
        if (this.bF && this.bG) {
            J();
        } else {
            super.onClose();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        if (this.bF && this.bG) {
            J();
        }
        this.bF = true;
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    @OverridingMethodsMustInvokeSuper
    public void tick() {
        super.tick();
        this.cT = this.cS;
        this.cS = Mth.lerp(0.4f, this.cS, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw
    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, C0040bk.p(), 0.4f * C0634xm.e(this.cT, this.cS, f));
        int size = 60 + (11 * this.B.size()) + 30 + E();
        int i3 = (this.width / 2) - C0093dj.gd;
        int i4 = hd;
        C0040bk.a(guiGraphics, i3 + 1, 35, 218, 1, i4);
        C0040bk.a(guiGraphics, i3, 36, 220, size - 2, i4);
        C0040bk.a(guiGraphics, i3 + 1, (35 + size) - 1, 218, 1, i4);
        C0040bk.a(poseStack, guiGraphics, i3 + 2, 37, 216, size - 4);
        C0040bk.a(poseStack, guiGraphics, bY, 0, 0, this.width, this.height);
        b(poseStack, guiGraphics);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public boolean mouseClicked(double d, double d2, int i) {
        if (i == 0 && a(d, d2)) {
            this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pl.get(), 1.0f));
            J();
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    protected void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        C0040bk.c(poseStack, this.font, guiGraphics, (Component) this.gA.copy().withStyle(C0266jw.b), ((this.width / 2) - 95) + 95, 48, 1.5f);
    }

    protected void c(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        int size = this.B.size();
        for (int i3 = 0; i3 < size; i3++) {
            FormattedCharSequence formattedCharSequence = this.B.get(i3);
            guiGraphics.drawString(this.font, formattedCharSequence, (i + 95) - (this.font.width(formattedCharSequence) / 2), i2 + (i3 * 11), ColorReferences.COLOR_WHITE);
        }
    }

    protected void J() {
        if (!this.bG) {
            this.b.setScreen((Screen) null);
            return;
        }
        Screen screen = this.d;
        if (screen instanceof AbstractC0078cv) {
            ((AbstractC0078cv) screen).aU = true;
        }
        this.b.setScreen(this.d);
    }
}
