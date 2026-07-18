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

/* JADX INFO: renamed from: com.boehmod.blockfront.dM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dM.class */
public abstract class AbstractC0211dM extends AbstractC0194cw {

    /* JADX INFO: renamed from: gZ */
    public static final int f1737gZ = 190;

    /* JADX INFO: renamed from: ha */
    public static final int f1738ha = 60;

    /* JADX INFO: renamed from: hb */
    public static final int f1739hb = 80;

    /* JADX INFO: renamed from: hc */
    public static final int f1740hc = 20;

    /* JADX INFO: renamed from: bY */
    @NotNull
    public static final ResourceLocation f1741bY = C0564jv.m2555d("textures/gui/cornershadow.png");

    /* JADX INFO: renamed from: hd */
    public static final int f1742hd = C0119bk.m365p();

    /* JADX INFO: renamed from: he */
    public static final int f1743he = 15;

    /* JADX INFO: renamed from: B */
    @NotNull
    protected final List<FormattedCharSequence> f1744B;

    /* JADX INFO: renamed from: cS */
    private float f1745cS;

    /* JADX INFO: renamed from: cT */
    private float f1746cT;

    /* JADX INFO: renamed from: bF */
    protected boolean f1747bF;

    /* JADX INFO: renamed from: bG */
    protected boolean f1748bG;

    /* JADX INFO: renamed from: gA */
    @NotNull
    private final Component f1749gA;

    /* JADX INFO: renamed from: E */
    protected abstract int mo859E();

    public AbstractC0211dM(@Nullable Screen screen, @NotNull Component component) {
        super(screen, component);
        this.f1744B = new ObjectArrayList();
        this.f1746cT = 0.0f;
        this.f1747bF = false;
        this.f1748bG = true;
        this.f1749gA = component;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1271a(double d, double d2) {
        int size = 60 + (11 * this.f1744B.size()) + 30 + mo859E();
        int i = (this.width / 2) - C0234dj.f1919gd;
        return d < ((double) i) || d > ((double) (i + 220)) || d2 < 35.0d || d2 > ((double) (35 + size));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public <T extends AbstractC0211dM> T mo1272a() {
        this.f1748bG = false;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public <T extends AbstractC0211dM> T m1273a(@NotNull Component component) {
        if (component.getString().isEmpty()) {
            this.f1744B.add(component.getVisualOrderText());
        } else {
            this.f1744B.addAll(this.font.split(component, f1737gZ));
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public <T extends AbstractC0211dM> T m1274a(@NotNull Component... componentArr) {
        for (Component component : componentArr) {
            m1273a(component);
        }
        return this;
    }

    public void onClose() {
        if (this.f1747bF && this.f1748bG) {
            mo1276J();
        } else {
            super.onClose();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        if (this.f1747bF && this.f1748bG) {
            mo1276J();
        }
        this.f1747bF = true;
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    @OverridingMethodsMustInvokeSuper
    public void tick() {
        super.tick();
        this.f1746cT = this.f1745cS;
        this.f1745cS = Mth.lerp(0.4f, this.f1745cS, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo615a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, C0119bk.m365p(), 0.4f * C1290xm.m7843e(this.f1746cT, this.f1745cS, f));
        int size = 60 + (11 * this.f1744B.size()) + 30 + mo859E();
        int i3 = (this.width / 2) - C0234dj.f1919gd;
        int i4 = f1742hd;
        C0119bk.m415a(guiGraphics, i3 + 1, 35, 218, 1, i4);
        C0119bk.m415a(guiGraphics, i3, 36, 220, size - 2, i4);
        C0119bk.m415a(guiGraphics, i3 + 1, (35 + size) - 1, 218, 1, i4);
        C0119bk.m367a(poseStack, guiGraphics, i3 + 2, 37, 216, size - 4);
        C0119bk.m431a(poseStack, guiGraphics, f1741bY, 0, 0, this.width, this.height);
        mo1267b(poseStack, guiGraphics);
    }

    @Override // com.boehmod.blockfront.C0195cx
    public boolean mouseClicked(double d, double d2, int i) {
        if (i == 0 && m1271a(d, d2)) {
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7554pl.get(), 1.0f));
            mo1276J();
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    /* JADX INFO: renamed from: b */
    protected void mo1267b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        C0119bk.m394c(poseStack, this.font, guiGraphics, (Component) this.f1749gA.copy().withStyle(C0565jw.f3201b), ((this.width / 2) - 95) + 95, 48, 1.5f);
    }

    /* JADX INFO: renamed from: c */
    protected void m1275c(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        int size = this.f1744B.size();
        for (int i3 = 0; i3 < size; i3++) {
            FormattedCharSequence formattedCharSequence = this.f1744B.get(i3);
            guiGraphics.drawString(this.font, formattedCharSequence, (i + 95) - (this.font.width(formattedCharSequence) / 2), i2 + (i3 * 11), ColorReferences.COLOR_WHITE);
        }
    }

    /* JADX INFO: renamed from: J */
    protected void mo1276J() {
        if (!this.f1748bG) {
            this.f1587b.setScreen((Screen) null);
            return;
        }
        Screen screen = this.f1563d;
        if (screen instanceof AbstractC0193cv) {
            ((AbstractC0193cv) screen).f1557aU = true;
        }
        this.f1587b.setScreen(this.f1563d);
    }
}
