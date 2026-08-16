package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dW.class */
public class C0222dW extends C0283ee {

    /* JADX INFO: renamed from: gE */
    @NotNull
    private static final Component f1759gE = Component.translatable("bf.message.prestige").withColor(0);

    /* JADX INFO: renamed from: gF */
    @NotNull
    private static final Component f1760gF = Component.translatable("bf.message.cancel").withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: bV */
    @NotNull
    private static final ResourceLocation f1761bV = C0532jO.m2378d("textures/gui/popup/player.png");

    /* JADX INFO: renamed from: ih */
    private static final int f1762ih = 80;

    /* JADX INFO: renamed from: ii */
    private static final int f1763ii = 20;

    /* JADX INFO: renamed from: C */
    @NotNull
    private final List<InterfaceC0102bS> f1764C;

    /* JADX INFO: renamed from: bL */
    private boolean f1765bL;

    public C0222dW(@NotNull Screen screen, @NotNull Component component, @NotNull InterfaceC0220dU interfaceC0220dU) {
        super(screen, component, interfaceC0220dU);
        this.f1764C = new ObjectArrayList();
        this.f1765bL = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        float fM466g = C0129bt.m466g();
        this.f1764C.removeIf(interfaceC0102bS -> {
            return interfaceC0102bS.mo395a(fM466g);
        });
        if (Math.random() < 0.4000000059604645d) {
            this.f1764C.add(new C0101bR(ColorReferences.COLOR_THEME_PRESTIGE_SOLID, (float) (((double) this.width) * Math.random()), this.height));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        if (!this.f1765bL) {
            this.f1765bL = true;
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7941oO.get(), 1.0f));
        }
    }

    @Override // com.boehmod.blockfront.C0283ee, com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        int i = (this.width / 2) - 95;
        int size = 85 + (11 * this.f1773D.size()) + 6;
        addRenderableWidget(new C0085bB(i + 2, size, 80, 20, f1760gF, button -> {
            if (this.f1777bN) {
                this.f1058a.setScreen(this.f1035c);
            }
            m1548t(false);
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW).m336b().m335e(-12891082).m341f(-10981296));
        addRenderableWidget(new C0085bB(((i + AbstractC0223dX.f1766ij) - 80) - 2, size, 80, 20, f1759gE, button2 -> {
            if (this.f1777bN) {
                this.f1058a.setScreen(this.f1035c);
            }
            m1548t(true);
        }).m328a(C0085bB.a.SHADOW).m336b().m335e(ColorReferences.COLOR_THEME_PRESTIGE_SOLID).m341f(ColorReferences.COLOR_THEME_PRESTIGE_HOVERED_SOLID));
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.AbstractC0142cF
    /* JADX INFO: renamed from: a */
    public void mo720a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.mo720a(poseStack, guiGraphics, i, i2, f);
        float fM466g = C0129bt.m466g();
        for (InterfaceC0102bS interfaceC0102bS : this.f1764C) {
            interfaceC0102bS.mo397b(this.f1058a, guiGraphics, poseStack, fM466g, f);
            interfaceC0102bS.mo396a(this.f1058a, guiGraphics, poseStack, fM466g, f);
        }
        int i3 = ColorReferences.COLOR_THEME_PRESTIGE_SOLID;
        int i4 = this.height / 2;
        C0129bt.m523a(guiGraphics, 0, this.height - i4, this.width, i4, i3 - ColorReferences.COLOR_BLACK_SOLID, i3 - (-872415232));
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX
    /* JADX INFO: renamed from: b */
    protected void mo1318b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        int i = this.width / 2;
        C0129bt.m515a(guiGraphics, i - 60, 75, C0358g.f2490g, 1, ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
        C0129bt.m547b(poseStack, guiGraphics, f1761bV, i, 43, 64, 64, 0.0f, 1.0f, ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
        super.mo1318b(poseStack, guiGraphics);
    }
}
