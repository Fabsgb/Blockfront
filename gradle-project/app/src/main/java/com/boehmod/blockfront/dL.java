package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dL.class */
public class dL extends dT {

    @NotNull
    private static final Component gy = Component.translatable("bf.message.prestige").withColor(0);

    @NotNull
    private static final Component gz = Component.translatable("bf.message.cancel").withColor(ColorReferences.COLOR_WHITE);

    @NotNull
    private static final ResourceLocation bX = C0265jv.d("textures/gui/popup/player.png");
    private static final int gX = 80;
    private static final int gY = 20;

    @NotNull
    private final List<bJ> A;
    private boolean bE;

    public dL(@NotNull Screen screen, @NotNull Component component, @NotNull dJ dJVar) {
        super(screen, component, dJVar);
        this.A = new ObjectArrayList();
        this.bE = false;
    }

    @Override // com.boehmod.blockfront.dM, com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        float fG = C0040bk.g();
        this.A.removeIf(bJVar -> {
            return bJVar.mo206a(fG);
        });
        if (Math.random() < 0.4000000059604645d) {
            this.A.add(new bI(ColorReferences.COLOR_THEME_PRESTIGE_SOLID, (float) (((double) this.width) * Math.random()), this.height));
        }
    }

    @Override // com.boehmod.blockfront.dM, com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        if (!this.bE) {
            this.bE = true;
            this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.oM.get(), 1.0f));
        }
    }

    @Override // com.boehmod.blockfront.dT, com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        int i = (this.width / 2) - 95;
        int size = 85 + (11 * this.B.size()) + 6;
        addRenderableWidget(new C0048bs(i + 2, size, 80, 20, gz, button -> {
            if (this.bG) {
                this.b.setScreen(this.d);
            }
            t(false);
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW).b().e(-12891082).f(-10981296));
        addRenderableWidget(new C0048bs(((i + dM.gZ) - 80) - 2, size, 80, 20, gy, button2 -> {
            if (this.bG) {
                this.b.setScreen(this.d);
            }
            t(true);
        }).a(C0048bs.a.SHADOW).b().e(ColorReferences.COLOR_THEME_PRESTIGE_SOLID).f(ColorReferences.COLOR_THEME_PRESTIGE_HOVERED_SOLID));
    }

    @Override // com.boehmod.blockfront.dM, com.boehmod.blockfront.AbstractC0079cw
    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.a(poseStack, guiGraphics, i, i2, f);
        float fG = C0040bk.g();
        for (bJ bJVar : this.A) {
            bJVar.b(this.b, guiGraphics, poseStack, fG, f);
            bJVar.a(this.b, guiGraphics, poseStack, fG, f);
        }
        int i3 = ColorReferences.COLOR_THEME_PRESTIGE_SOLID;
        int i4 = this.height / 2;
        C0040bk.a(guiGraphics, 0, this.height - i4, this.width, i4, i3 - ColorReferences.COLOR_BLACK_SOLID, i3 - (-872415232));
    }

    @Override // com.boehmod.blockfront.dM
    protected void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        int i = this.width / 2;
        C0040bk.a(guiGraphics, i - 60, 75, C0163g.g, 1, ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
        C0040bk.b(poseStack, guiGraphics, bX, i, 43, 64, 64, 0.0f, 1.0f, ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
        super.b(poseStack, guiGraphics);
    }
}
