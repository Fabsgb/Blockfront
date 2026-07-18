package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dL.class */
public class C0210dL extends C0218dT {

    /* JADX INFO: renamed from: gy */
    @NotNull
    private static final Component f1730gy = Component.translatable("bf.message.prestige").withColor(0);

    /* JADX INFO: renamed from: gz */
    @NotNull
    private static final Component f1731gz = Component.translatable("bf.message.cancel").withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: bX */
    @NotNull
    private static final ResourceLocation f1732bX = C0564jv.m2555d("textures/gui/popup/player.png");

    /* JADX INFO: renamed from: gX */
    private static final int f1733gX = 80;

    /* JADX INFO: renamed from: gY */
    private static final int f1734gY = 20;

    /* JADX INFO: renamed from: A */
    @NotNull
    private final List<InterfaceC0092bJ> f1735A;

    /* JADX INFO: renamed from: bE */
    private boolean f1736bE;

    public C0210dL(@NotNull Screen screen, @NotNull Component component, @NotNull InterfaceC0208dJ interfaceC0208dJ) {
        super(screen, component, interfaceC0208dJ);
        this.f1735A = new ObjectArrayList();
        this.f1736bE = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        float fM366g = C0119bk.m366g();
        this.f1735A.removeIf(interfaceC0092bJ -> {
            return interfaceC0092bJ.mo290a(fM366g);
        });
        if (Math.random() < 0.4000000059604645d) {
            this.f1735A.add(new C0091bI(ColorReferences.COLOR_THEME_PRESTIGE_SOLID, (float) (((double) this.width) * Math.random()), this.height));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        if (!this.f1736bE) {
            this.f1736bE = true;
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7529oM.get(), 1.0f));
        }
    }

    @Override // com.boehmod.blockfront.C0218dT, com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        int i = (this.width / 2) - 95;
        int size = 85 + (11 * this.f1744B.size()) + 6;
        addRenderableWidget(new C0127bs(i + 2, size, 80, 20, f1731gz, button -> {
            if (this.f1748bG) {
                this.f1587b.setScreen(this.f1563d);
            }
            m1286t(false);
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW).m661b().m660e(-12891082).m666f(-10981296));
        addRenderableWidget(new C0127bs(((i + AbstractC0211dM.f1737gZ) - 80) - 2, size, 80, 20, f1730gy, button2 -> {
            if (this.f1748bG) {
                this.f1587b.setScreen(this.f1563d);
            }
            m1286t(true);
        }).m653a(C0127bs.a.SHADOW).m661b().m660e(ColorReferences.COLOR_THEME_PRESTIGE_SOLID).m666f(ColorReferences.COLOR_THEME_PRESTIGE_HOVERED_SOLID));
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.AbstractC0194cw
    /* JADX INFO: renamed from: a */
    public void mo615a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.mo615a(poseStack, guiGraphics, i, i2, f);
        float fM366g = C0119bk.m366g();
        for (InterfaceC0092bJ interfaceC0092bJ : this.f1735A) {
            interfaceC0092bJ.mo292b(this.f1587b, guiGraphics, poseStack, fM366g, f);
            interfaceC0092bJ.mo291a(this.f1587b, guiGraphics, poseStack, fM366g, f);
        }
        int i3 = ColorReferences.COLOR_THEME_PRESTIGE_SOLID;
        int i4 = this.height / 2;
        C0119bk.m423a(guiGraphics, 0, this.height - i4, this.width, i4, i3 - ColorReferences.COLOR_BLACK_SOLID, i3 - (-872415232));
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM
    /* JADX INFO: renamed from: b */
    protected void mo1267b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        int i = this.width / 2;
        C0119bk.m415a(guiGraphics, i - 60, 75, C0357g.f2439g, 1, ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
        C0119bk.m447b(poseStack, guiGraphics, f1732bX, i, 43, 64, 64, 0.0f, 1.0f, ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
        super.mo1267b(poseStack, guiGraphics);
    }
}
