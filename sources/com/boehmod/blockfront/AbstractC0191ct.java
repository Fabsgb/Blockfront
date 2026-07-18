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

/* JADX INFO: renamed from: com.boehmod.blockfront.ct */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ct.class */
public abstract class AbstractC0191ct extends AbstractC0193cv implements ContainerEventHandler {

    /* JADX INFO: renamed from: r */
    @NotNull
    protected final ObjectList<Component> f1537r;

    /* JADX INFO: renamed from: s */
    @NotNull
    protected final ObjectList<Component> f1538s;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final BooleanList f1539a;

    /* JADX INFO: renamed from: bm */
    protected int f1540bm;

    /* JADX INFO: renamed from: bn */
    protected int f1541bn;

    /* JADX INFO: renamed from: cM */
    protected int f1542cM;

    /* JADX INFO: renamed from: cN */
    protected int f1543cN;

    /* JADX INFO: renamed from: g */
    public abstract void mo286g(int i);

    public AbstractC0191ct(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull Component component) {
        super(screen, component);
        this.f1537r = new ObjectArrayList();
        this.f1538s = new ObjectArrayList();
        this.f1539a = new BooleanArrayList();
        this.f1540bm = i;
        this.f1541bn = i2;
        this.f1542cM = i3;
        this.f1543cN = i4;
        while (this.f1540bm + i3 > this.f1587b.getWindow().getGuiScaledWidth()) {
            this.f1540bm -= i3;
        }
        this.f1537r.clear();
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0191ct m1173a(@NotNull Component component) {
        this.f1537r.add(component);
        this.f1538s.add((Object) null);
        this.f1539a.add(true);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0191ct m1174a(@NotNull Component component, @NotNull Component component2) {
        this.f1537r.add(component);
        this.f1538s.add(component2);
        this.f1539a.add(true);
        int size = this.f1543cN * this.f1537r.size();
        while (this.f1541bn + size > this.f1587b.getWindow().getGuiScaledHeight()) {
            this.f1541bn -= this.f1543cN;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0191ct m1175a(@NotNull Component component, boolean z) {
        this.f1537r.add(component);
        this.f1538s.add((Object) null);
        this.f1539a.add(z);
        int size = this.f1543cN * this.f1537r.size();
        while (this.f1541bn + size > this.f1587b.getWindow().getGuiScaledHeight()) {
            this.f1541bn -= this.f1543cN;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0191ct m1176a(@NotNull Component component, @NotNull Component component2, boolean z) {
        this.f1537r.add(component);
        this.f1538s.add(component2);
        this.f1539a.add(z);
        int size = this.f1543cN * this.f1537r.size();
        while (this.f1541bn + size > this.f1587b.getWindow().getGuiScaledHeight()) {
            this.f1541bn -= this.f1543cN;
        }
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv
    /* JADX INFO: renamed from: a */
    public boolean mo344a(double d, double d2) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv, com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        int size = this.f1537r.size();
        if (size == 0) {
            m1184J();
        }
        for (int i = 0; i < size; i++) {
            int i2 = i;
            C0127bs c0127bs = new C0127bs(this.f1540bm, this.f1541bn + (i * this.f1543cN), this.f1542cM, this.f1543cN, (Component) this.f1537r.get(i), button -> {
                mo286g(i2 + 1);
            });
            Component component = (Component) this.f1538s.get(i);
            if (component != null) {
                c0127bs.m651a(component);
            }
            c0127bs.m649a(0.0f, 1.0f);
            c0127bs.active = this.f1539a.getBoolean(i);
            addRenderableWidget(c0127bs);
        }
        this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.5f));
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv, com.boehmod.blockfront.C0195cx
    public boolean mouseClicked(double d, double d2, int i) {
        m1184J();
        this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 2.0f));
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        this.f1556c.render(guiGraphics, this.f1556c.width, this.f1556c.height, f);
        float fM366g = C0119bk.m366g();
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0119bk.m491c(guiGraphics, this.f1540bm, this.f1541bn, this.f1542cM, this.renderables.size() * this.f1543cN, C0119bk.m365p());
        int size = this.renderables.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 % 2 != 0) {
                C0119bk.m415a(guiGraphics, this.f1540bm, this.f1541bn + (this.f1543cN * i3), this.f1542cM, this.f1543cN, ColorReferences.COLOR_TOOL_TIP_BORDER_END);
            }
        }
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            ((Renderable) it.next()).render(guiGraphics, i, i2, f);
        }
        for (C0127bs c0127bs : this.renderables) {
            if (c0127bs instanceof C0127bs) {
                c0127bs.m663a(this.f1587b, poseStackPose, this.font, guiGraphics, i, i2, fM366g);
            }
        }
        poseStackPose.popPose();
    }
}
