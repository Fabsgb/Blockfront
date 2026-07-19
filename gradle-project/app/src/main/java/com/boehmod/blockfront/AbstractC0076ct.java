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

/* JADX INFO: renamed from: com.boehmod.blockfront.ct, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ct.class */
public abstract class AbstractC0076ct extends AbstractC0078cv implements ContainerEventHandler {

    @NotNull
    protected final ObjectList<Component> r;

    @NotNull
    protected final ObjectList<Component> s;

    @NotNull
    protected final BooleanList a;
    protected int bm;
    protected int bn;
    protected int cM;
    protected int cN;

    public abstract void g(int i);

    public AbstractC0076ct(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull Component component) {
        super(screen, component);
        this.r = new ObjectArrayList();
        this.s = new ObjectArrayList();
        this.a = new BooleanArrayList();
        this.bm = i;
        this.bn = i2;
        this.cM = i3;
        this.cN = i4;
        while (this.bm + i3 > this.b.getWindow().getGuiScaledWidth()) {
            this.bm -= i3;
        }
        this.r.clear();
    }

    public AbstractC0076ct a(@NotNull Component component) {
        this.r.add(component);
        this.s.add((Object) null);
        this.a.add(true);
        return this;
    }

    public AbstractC0076ct a(@NotNull Component component, @NotNull Component component2) {
        this.r.add(component);
        this.s.add(component2);
        this.a.add(true);
        int size = this.cN * this.r.size();
        while (this.bn + size > this.b.getWindow().getGuiScaledHeight()) {
            this.bn -= this.cN;
        }
        return this;
    }

    public AbstractC0076ct a(@NotNull Component component, boolean z) {
        this.r.add(component);
        this.s.add((Object) null);
        this.a.add(z);
        int size = this.cN * this.r.size();
        while (this.bn + size > this.b.getWindow().getGuiScaledHeight()) {
            this.bn -= this.cN;
        }
        return this;
    }

    public AbstractC0076ct a(@NotNull Component component, @NotNull Component component2, boolean z) {
        this.r.add(component);
        this.s.add(component2);
        this.a.add(z);
        int size = this.cN * this.r.size();
        while (this.bn + size > this.b.getWindow().getGuiScaledHeight()) {
            this.bn -= this.cN;
        }
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv
    public boolean a(double d, double d2) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv, com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        int size = this.r.size();
        if (size == 0) {
            J();
        }
        for (int i = 0; i < size; i++) {
            int i2 = i;
            C0048bs c0048bs = new C0048bs(this.bm, this.bn + (i * this.cN), this.cM, this.cN, (Component) this.r.get(i), button -> {
                g(i2 + 1);
            });
            Component component = (Component) this.s.get(i);
            if (component != null) {
                c0048bs.a(component);
            }
            c0048bs.a(0.0f, 1.0f);
            c0048bs.active = this.a.getBoolean(i);
            addRenderableWidget(c0048bs);
        }
        this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.5f));
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv, com.boehmod.blockfront.C0080cx
    public boolean mouseClicked(double d, double d2, int i) {
        J();
        this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 2.0f));
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        this.c.render(guiGraphics, this.c.width, this.c.height, f);
        float fG = C0040bk.g();
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0040bk.c(guiGraphics, this.bm, this.bn, this.cM, this.renderables.size() * this.cN, C0040bk.p());
        int size = this.renderables.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 % 2 != 0) {
                C0040bk.a(guiGraphics, this.bm, this.bn + (this.cN * i3), this.cM, this.cN, ColorReferences.COLOR_TOOL_TIP_BORDER_END);
            }
        }
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            ((Renderable) it.next()).render(guiGraphics, i, i2, f);
        }
        for (C0048bs c0048bs : this.renderables) {
            if (c0048bs instanceof C0048bs) {
                c0048bs.a(this.b, poseStackPose, this.font, guiGraphics, i, i2, fG);
            }
        }
        poseStackPose.popPose();
    }
}
