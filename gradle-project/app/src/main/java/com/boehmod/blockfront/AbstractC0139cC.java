package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.booleans.BooleanArrayList;
import it.unimi.dsi.fastutil.booleans.BooleanList;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.ContainerEventHandler;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cC.class */
public abstract class AbstractC0139cC extends AbstractC0141cE implements ContainerEventHandler {

    /* JADX INFO: renamed from: A */
    @NotNull
    protected final ObjectList<Component> f1017A;

    /* JADX INFO: renamed from: B */
    @NotNull
    protected final ObjectList<Component> f1018B;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final BooleanList f1019a;

    /* JADX INFO: renamed from: cc */
    protected int f1020cc;

    /* JADX INFO: renamed from: cd */
    protected int f1021cd;

    /* JADX INFO: renamed from: dE */
    protected int f1022dE;

    /* JADX INFO: renamed from: dF */
    protected int f1023dF;

    /* JADX INFO: renamed from: g */
    public abstract void mo390g(int i);

    public AbstractC0139cC(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull Component component) {
        super(screen, component);
        this.f1017A = new ObjectArrayList();
        this.f1018B = new ObjectArrayList();
        this.f1019a = new BooleanArrayList();
        this.f1020cc = i;
        this.f1021cd = i2;
        this.f1022dE = i3;
        this.f1023dF = i4;
        while (this.f1020cc + i3 > this.f1058a.getWindow().getGuiScaledWidth()) {
            this.f1020cc -= i3;
        }
        this.f1017A.clear();
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0139cC m770a(@NotNull Component component) {
        this.f1017A.add(component);
        this.f1018B.add((Object) null);
        this.f1019a.add(true);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0139cC m771a(@NotNull Component component, @NotNull Component component2) {
        this.f1017A.add(component);
        this.f1018B.add(component2);
        this.f1019a.add(true);
        int size = this.f1023dF * this.f1017A.size();
        while (this.f1021cd + size > this.f1058a.getWindow().getGuiScaledHeight()) {
            this.f1021cd -= this.f1023dF;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0139cC m772a(@NotNull Component component, boolean z) {
        this.f1017A.add(component);
        this.f1018B.add((Object) null);
        this.f1019a.add(z);
        int size = this.f1023dF * this.f1017A.size();
        while (this.f1021cd + size > this.f1058a.getWindow().getGuiScaledHeight()) {
            this.f1021cd -= this.f1023dF;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0139cC m773a(@NotNull Component component, @NotNull Component component2, boolean z) {
        this.f1017A.add(component);
        this.f1018B.add(component2);
        this.f1019a.add(z);
        int size = this.f1023dF * this.f1017A.size();
        while (this.f1021cd + size > this.f1058a.getWindow().getGuiScaledHeight()) {
            this.f1021cd -= this.f1023dF;
        }
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0141cE
    /* JADX INFO: renamed from: a */
    public boolean mo437a(double d, double d2) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        int size = this.f1017A.size();
        if (size == 0) {
            m782N();
        }
        for (int i = 0; i < size; i++) {
            int i2 = i;
            C0085bB c0085bB = new C0085bB(this.f1020cc, this.f1021cd + (i * this.f1023dF), this.f1022dE, this.f1023dF, (Component) this.f1017A.get(i), button -> {
                mo390g(i2 + 1);
            });
            Component component = (Component) this.f1018B.get(i);
            if (component != null) {
                c0085bB.m326a(component);
            }
            c0085bB.m324a(0.0f, 1.0f);
            c0085bB.active = this.f1019a.getBoolean(i);
            addRenderableWidget(c0085bB);
        }
        this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.5f));
    }

    @Override // com.boehmod.blockfront.AbstractC0141cE, com.boehmod.blockfront.C0143cG
    public boolean mouseClicked(double d, double d2, int i) {
        m782N();
        this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 2.0f));
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.f1035c != null) {
            this.f1035c.render(guiGraphics, this.f1035c.width, this.f1035c.height, f);
        }
        float fM466g = C0129bt.m466g();
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0129bt.m591c(guiGraphics, this.f1020cc, this.f1021cd, this.f1022dE, this.renderables.size() * this.f1023dF, C0129bt.m465t());
        int size = this.renderables.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 % 2 != 0) {
                C0129bt.m515a(guiGraphics, this.f1020cc, this.f1021cd + (this.f1023dF * i3), this.f1022dE, this.f1023dF, ColorReferences.COLOR_TOOL_TIP_BORDER_END);
            }
        }
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            ((Renderable) it.next()).render(guiGraphics, i, i2, f);
        }
        for (C0085bB c0085bB : this.renderables) {
            if (c0085bB instanceof C0085bB) {
                c0085bB.m338a(this.f1058a, poseStackPose, this.font, guiGraphics, i, i2, fM466g);
            }
        }
        poseStackPose.popPose();
    }
}
