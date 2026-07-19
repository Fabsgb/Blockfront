package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Iterator;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.cw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cw.class */
public abstract class AbstractC0079cw extends C0080cx {

    @Nullable
    protected final Screen d;

    public abstract void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f);

    public AbstractC0079cw(@Nullable Screen screen, @NotNull Component component) {
        this(screen, component, Component.empty());
    }

    public AbstractC0079cw(@Nullable Screen screen, @NotNull Component component, @NotNull Component component2) {
        super(component, component2);
        this.d = screen;
    }

    @Override // com.boehmod.blockfront.C0080cx
    @OverridingMethodsMustInvokeSuper
    public void init() {
        super.init();
        if (this.d != null) {
            this.d.init(this.b, this.width, this.height);
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    @OverridingMethodsMustInvokeSuper
    public void tick() {
        super.tick();
        if (this.d != null) {
            this.d.tick();
        }
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    @OverridingMethodsMustInvokeSuper
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        iS iSVarM404a = ((fV) this.e.a()).m404a(this.b);
        float fG = C0040bk.g();
        if (this.d != null) {
            this.d.render(guiGraphics, i, i2, f);
        }
        C0040bk.b(this.b, f);
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        a(poseStackPose, guiGraphics, i, i2, f);
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            ((Renderable) it.next()).render(guiGraphics, i, i2, f);
        }
        Iterator<C0051bv> it2 = this.p.iterator();
        while (it2.hasNext()) {
            it2.next().a(this.b, this.e, this.a, poseStackPose, guiGraphics, this.font, iSVarM404a, i, i2, fG, f);
        }
        for (C0048bs c0048bs : this.renderables) {
            if (c0048bs instanceof C0048bs) {
                c0048bs.a(this.b, poseStackPose, this.font, guiGraphics, i, i2, f);
            }
        }
        poseStackPose.popPose();
    }
}
