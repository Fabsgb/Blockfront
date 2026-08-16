package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.cE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cE.class */
public abstract class AbstractC0141cE extends AbstractC0142cF {
    /* JADX INFO: renamed from: a */
    protected abstract boolean mo437a(double d, double d2);

    public AbstractC0141cE(@Nullable Screen screen, @NotNull Component component) {
        super(screen, component);
        mo783a(false);
    }

    /* JADX INFO: renamed from: M */
    private void m781M() {
        this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7966pn.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        m782N();
    }

    /* JADX INFO: renamed from: N */
    public void m782N() {
        this.f1058a.setScreen(this.f1035c);
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF
    /* JADX INFO: renamed from: a */
    public final void mo720a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        renderBackground(guiGraphics, i, i2, f);
    }

    @Override // com.boehmod.blockfront.C0143cG
    @OverridingMethodsMustInvokeSuper
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        C0129bt.m517a(guiGraphics, 0, 0, this.width, this.height, C0129bt.m465t(), 0.5f);
        C0129bt.m533a(poseStackPose, guiGraphics, f1048aS, 0, 0, this.width, this.height, 1.0f);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public boolean mouseClicked(double d, double d2, int i) {
        if (i == 0 && mo437a(d, d2)) {
            m781M();
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public boolean keyPressed(int i, int i2, int i3) {
        if (i == 256 && shouldCloseOnEsc()) {
            m781M();
            return true;
        }
        return super.keyPressed(i, i2, i3);
    }
}
