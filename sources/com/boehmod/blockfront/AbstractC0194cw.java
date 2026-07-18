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

/* JADX INFO: renamed from: com.boehmod.blockfront.cw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cw.class */
public abstract class AbstractC0194cw extends C0195cx {

    /* JADX INFO: renamed from: d */
    @Nullable
    protected final Screen f1563d;

    /* JADX INFO: renamed from: a */
    public abstract void mo615a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f);

    public AbstractC0194cw(@Nullable Screen screen, @NotNull Component component) {
        this(screen, component, Component.empty());
    }

    public AbstractC0194cw(@Nullable Screen screen, @NotNull Component component, @NotNull Component component2) {
        super(component, component2);
        this.f1563d = screen;
    }

    @Override // com.boehmod.blockfront.C0195cx
    @OverridingMethodsMustInvokeSuper
    public void init() {
        super.init();
        if (this.f1563d != null) {
            this.f1563d.init(this.f1587b, this.width, this.height);
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    @OverridingMethodsMustInvokeSuper
    public void tick() {
        super.tick();
        if (this.f1563d != null) {
            this.f1563d.tick();
        }
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    @OverridingMethodsMustInvokeSuper
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        C0482iS c0482iSM1676a = ((C0326fV) this.f1586e.m2670a()).m1676a(this.f1587b);
        float fM366g = C0119bk.m366g();
        if (this.f1563d != null) {
            this.f1563d.render(guiGraphics, i, i2, f);
        }
        C0119bk.m526b(this.f1587b, f);
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        mo615a(poseStackPose, guiGraphics, i, i2, f);
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            ((Renderable) it.next()).render(guiGraphics, i, i2, f);
        }
        Iterator<C0130bv> it2 = this.f1583p.iterator();
        while (it2.hasNext()) {
            it2.next().mo687a(this.f1587b, this.f1586e, this.f1585a, poseStackPose, guiGraphics, this.font, c0482iSM1676a, i, i2, fM366g, f);
        }
        for (C0127bs c0127bs : this.renderables) {
            if (c0127bs instanceof C0127bs) {
                c0127bs.m663a(this.f1587b, poseStackPose, this.font, guiGraphics, i, i2, f);
            }
        }
        poseStackPose.popPose();
    }
}
