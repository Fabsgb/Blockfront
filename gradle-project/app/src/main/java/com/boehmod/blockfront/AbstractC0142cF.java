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

/* JADX INFO: renamed from: com.boehmod.blockfront.cF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cF.class */
public abstract class AbstractC0142cF extends C0143cG {

    /* JADX INFO: renamed from: c */
    @Nullable
    protected final Screen f1035c;

    /* JADX INFO: renamed from: aZ */
    private boolean f1036aZ;

    /* JADX INFO: renamed from: a */
    public abstract void mo720a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f);

    public AbstractC0142cF(@Nullable Screen screen, @NotNull Component component) {
        this(screen, component, Component.empty());
    }

    public AbstractC0142cF(@Nullable Screen screen, @NotNull Component component, @NotNull Component component2) {
        super(component, component2);
        this.f1036aZ = true;
        this.f1035c = screen;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0142cF mo783a(boolean z) {
        this.f1036aZ = z;
        return this;
    }

    @Override // com.boehmod.blockfront.C0143cG
    @OverridingMethodsMustInvokeSuper
    public void init() {
        super.init();
        if (this.f1035c != null) {
            this.f1035c.init(this.f1058a, this.width, this.height);
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    @OverridingMethodsMustInvokeSuper
    public void tick() {
        super.tick();
        if (this.f1035c != null) {
            this.f1035c.tick();
        }
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    @OverridingMethodsMustInvokeSuper
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        C0555jl c0555jlM1886a = ((C0396gl) this.f1057f.m2855a()).m1886a(this.f1058a);
        float fM466g = C0129bt.m466g();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, -400.0f);
        if (this.f1035c != null) {
            this.f1035c.render(guiGraphics, i, i2, f);
        }
        poseStackPose.popPose();
        if (this.f1036aZ) {
            C0129bt.m628b(this.f1058a, f);
        }
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        mo720a(poseStackPose, guiGraphics, i, i2, f);
        mo775a(guiGraphics, f);
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            ((Renderable) it.next()).render(guiGraphics, i, i2, f);
        }
        Iterator<C0088bE> it2 = this.f1054r.iterator();
        while (it2.hasNext()) {
            it2.next().mo362a(this.f1058a, this.f1057f, this.f1056a, poseStackPose, guiGraphics, this.font, c0555jlM1886a, i, i2, fM466g, f);
        }
        for (C0085bB c0085bB : this.renderables) {
            if (c0085bB instanceof C0085bB) {
                c0085bB.m338a(this.f1058a, poseStackPose, this.font, guiGraphics, i, i2, fM466g);
            }
        }
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    public void mo775a(@NotNull GuiGraphics guiGraphics, float f) {
    }
}
