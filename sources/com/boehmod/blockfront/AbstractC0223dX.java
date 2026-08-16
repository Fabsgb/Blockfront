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

/* JADX INFO: renamed from: com.boehmod.blockfront.dX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dX.class */
public abstract class AbstractC0223dX extends AbstractC0142cF {

    /* JADX INFO: renamed from: ij */
    public static final int f1766ij = 190;

    /* JADX INFO: renamed from: ik */
    public static final int f1767ik = 60;

    /* JADX INFO: renamed from: il */
    public static final int f1768il = 80;

    /* JADX INFO: renamed from: im */
    public static final int f1769im = 20;

    /* JADX INFO: renamed from: bW */
    @NotNull
    public static final ResourceLocation f1770bW = C0532jO.m2378d("textures/gui/cornershadow.png");

    /* JADX INFO: renamed from: in */
    public static final int f1771in = C0129bt.m465t();

    /* JADX INFO: renamed from: io */
    public static final int f1772io = 15;

    /* JADX INFO: renamed from: D */
    @NotNull
    protected final List<FormattedCharSequence> f1773D;

    /* JADX INFO: renamed from: cY */
    private float f1774cY;

    /* JADX INFO: renamed from: cZ */
    private float f1775cZ;

    /* JADX INFO: renamed from: bM */
    protected boolean f1776bM;

    /* JADX INFO: renamed from: bN */
    protected boolean f1777bN;

    /* JADX INFO: renamed from: gG */
    @NotNull
    private final Component f1778gG;

    /* JADX INFO: renamed from: I */
    protected abstract int mo913I();

    public AbstractC0223dX(@Nullable Screen screen, @NotNull Component component) {
        super(screen, component);
        this.f1773D = new ObjectArrayList();
        this.f1775cZ = 0.0f;
        this.f1776bM = false;
        this.f1777bN = true;
        this.f1778gG = component;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1322a(double d, double d2) {
        int size = 60 + (11 * this.f1773D.size()) + 30 + mo913I();
        int i = (this.width / 2) - C0244ds.f1979hd;
        return d < ((double) i) || d > ((double) (i + 220)) || d2 < 35.0d || d2 > ((double) (35 + size));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public <T extends AbstractC0223dX> T mo1323a() {
        this.f1777bN = false;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public <T extends AbstractC0223dX> T m1324a(@NotNull Component component) {
        if (component.getString().isEmpty()) {
            this.f1773D.add(component.getVisualOrderText());
        } else {
            this.f1773D.addAll(this.font.split(component, f1766ij));
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public <T extends AbstractC0223dX> T m1325a(@NotNull Component... componentArr) {
        for (Component component : componentArr) {
            m1324a(component);
        }
        return this;
    }

    public void onClose() {
        if (this.f1776bM && this.f1777bN) {
            m1327N();
        } else {
            super.onClose();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        if (this.f1776bM && this.f1777bN) {
            m1327N();
        }
        this.f1776bM = true;
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    @OverridingMethodsMustInvokeSuper
    public void tick() {
        super.tick();
        this.f1775cZ = this.f1774cY;
        this.f1774cY = Mth.lerp(0.4f, this.f1774cY, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo720a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0129bt.m517a(guiGraphics, 0, 0, this.width, this.height, C0129bt.m465t(), 0.4f * C1270xJ.m7170f(this.f1775cZ, this.f1774cY, f));
        int size = 60 + (11 * this.f1773D.size()) + 30 + mo913I();
        int i3 = (this.width / 2) - C0244ds.f1979hd;
        C0129bt.m518b(guiGraphics, i3, 35, 220, size, f1771in);
        C0129bt.m467a(poseStack, guiGraphics, i3 + 2, 37, 216, size - 4);
        C0129bt.m531a(poseStack, guiGraphics, f1770bW, 0, 0, this.width, this.height);
        mo1318b(poseStack, guiGraphics);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public boolean mouseClicked(double d, double d2, int i) {
        if (i == 0 && m1322a(d, d2)) {
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7966pn.get(), 1.0f));
            m1327N();
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    /* JADX INFO: renamed from: b */
    protected void mo1318b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        C0129bt.m494c(poseStack, this.font, guiGraphics, (Component) this.f1778gG.copy().withStyle(C0533jP.f3185b), ((this.width / 2) - 95) + 95, 48, 1.5f);
    }

    /* JADX INFO: renamed from: c */
    protected void m1326c(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        int size = this.f1773D.size();
        for (int i3 = 0; i3 < size; i3++) {
            FormattedCharSequence formattedCharSequence = this.f1773D.get(i3);
            guiGraphics.drawString(this.font, formattedCharSequence, (i + 95) - (this.font.width(formattedCharSequence) / 2), i2 + (i3 * 11), ColorReferences.COLOR_WHITE);
        }
    }

    /* JADX INFO: renamed from: N */
    protected void m1327N() {
        if (!this.f1777bN) {
            this.f1058a.setScreen((Screen) null);
        } else {
            this.f1058a.setScreen(this.f1035c);
        }
    }
}
