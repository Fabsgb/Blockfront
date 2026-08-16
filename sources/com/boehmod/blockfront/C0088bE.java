package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bE.class */
public class C0088bE {

    /* JADX INFO: renamed from: b */
    @NotNull
    private Screen f576b;

    /* JADX INFO: renamed from: cc */
    protected int f579cc;

    /* JADX INFO: renamed from: cd */
    protected int f580cd;

    /* JADX INFO: renamed from: dE */
    protected int f581dE;

    /* JADX INFO: renamed from: dF */
    protected int f582dF;

    /* JADX INFO: renamed from: p */
    @NotNull
    private final List<C0088bE> f577p = new ObjectArrayList();

    /* JADX INFO: renamed from: q */
    @NotNull
    private final List<AbstractWidget> f578q = new ObjectArrayList();

    /* JADX INFO: renamed from: aO */
    private boolean f583aO = false;

    /* JADX INFO: renamed from: aP */
    private boolean f584aP = true;

    /* JADX INFO: renamed from: D */
    @Nullable
    private Component f585D = null;

    /* JADX INFO: renamed from: aG */
    private boolean f586aG = false;

    /* JADX INFO: renamed from: aH */
    private boolean f587aH = false;

    public C0088bE(int i, int i2, int i3, int i4, @NotNull Screen screen) {
        this.f579cc = i;
        this.f580cd = i2;
        this.f581dE = i3;
        this.f582dF = i4;
        this.f576b = screen;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0088bE m357a(@NotNull Component component) {
        this.f585D = component;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0088bE m358a() {
        this.f586aG = true;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0088bE m359b() {
        this.f584aP = false;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void mo360a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0396gl c0396gl) {
        m367G();
        m368H();
        this.f577p.forEach(c0088bE -> {
            c0088bE.mo360a(minecraft, c0623l, c0396gl);
        });
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo361a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, float f) {
        this.f577p.forEach(c0088bE -> {
            c0088bE.mo361a(minecraft, c0623l, c0396gl, f);
        });
        if (this.f583aO) {
            if (!this.f587aH && this.f586aG) {
                this.f587aH = true;
                if (this.f585D != null) {
                    minecraft.getNarrator().sayNow(Component.literal(this.f585D.getString()));
                }
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
                return;
            }
            return;
        }
        this.f587aH = false;
    }

    /* JADX INFO: renamed from: a */
    public void mo362a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull C0555jl c0555jl, int i, int i2, float f, float f2) {
        this.f583aO = C0129bt.m573b((double) this.f579cc, (double) this.f580cd, (double) this.f581dE, (double) this.f582dF, (double) i, (double) i2) && minecraft.screen == this.f576b;
        poseStack.pushPose();
        if (this.f584aP) {
            mo364a(minecraft, c0396gl, poseStack, guiGraphics, i, i2, f, f2);
        }
        Iterator<C0088bE> it = this.f577p.iterator();
        while (it.hasNext()) {
            it.next().mo362a(minecraft, c0623l, c0396gl, poseStack, guiGraphics, font, c0555jl, i, i2, f, f2);
        }
        Iterator<C0088bE> it2 = this.f577p.iterator();
        while (it2.hasNext()) {
            it2.next().m363a(minecraft, c0623l, c0396gl, font, guiGraphics, i, i2, f2);
        }
        Iterator<AbstractWidget> it3 = this.f578q.iterator();
        while (it3.hasNext()) {
            it3.next().render(guiGraphics, i, i2, f2);
        }
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public void m363a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.f583aO) {
            m365a(font, guiGraphics, i, i2);
        }
        Iterator<AbstractWidget> it = this.f578q.iterator();
        while (it.hasNext()) {
            C0085bB c0085bB = (AbstractWidget) it.next();
            if (c0085bB instanceof C0085bB) {
                c0085bB.m338a(minecraft, guiGraphics.pose(), font, guiGraphics, i, i2, f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo364a(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        poseStack.pushPose();
        Iterator<C0088bE> it = this.f577p.iterator();
        while (it.hasNext()) {
            it.next().mo364a(minecraft, c0396gl, poseStack, guiGraphics, i, i2, f, f2);
        }
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public void m365a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        if (this.f585D != null) {
            guiGraphics.renderTooltip(font, this.f585D, i, i2);
        }
        poseStackPose.popPose();
    }

    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        Iterator<AbstractWidget> it = this.f578q.iterator();
        while (it.hasNext()) {
            if (it.next().mouseScrolled(d, d2, d3, d4)) {
                return true;
            }
        }
        Iterator<C0088bE> it2 = this.f577p.iterator();
        while (it2.hasNext()) {
            if (it2.next().mouseScrolled(d, d2, d3, d4)) {
                return true;
            }
        }
        return false;
    }

    public boolean mouseReleased(double d, double d2, int i) {
        Iterator<AbstractWidget> it = this.f578q.iterator();
        while (it.hasNext()) {
            if (it.next().mouseReleased(d, d2, i)) {
                return true;
            }
        }
        Iterator<C0088bE> it2 = this.f577p.iterator();
        while (it2.hasNext()) {
            if (it2.next().mouseReleased(d, d2, i)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo366a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, double d, double d2, int i) {
        Iterator<AbstractWidget> it = this.f578q.iterator();
        while (it.hasNext()) {
            if (it.next().mouseClicked(d, d2, i)) {
                return true;
            }
        }
        Iterator<C0088bE> it2 = this.f577p.iterator();
        while (it2.hasNext()) {
            if (it2.next().mo366a(minecraft, c0623l, c0396gl, d, d2, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean keyPressed(int i, int i2, int i3) {
        return true;
    }

    /* JADX INFO: renamed from: G */
    public void m367G() {
        this.f578q.clear();
        this.f577p.forEach((v0) -> {
            v0.m367G();
        });
    }

    /* JADX INFO: renamed from: H */
    public void m368H() {
        this.f577p.forEach((v0) -> {
            v0.m368H();
        });
    }

    /* JADX INFO: renamed from: a */
    public boolean m369a(@NotNull AbstractWidget abstractWidget) {
        return this.f578q.add(abstractWidget);
    }

    /* JADX INFO: renamed from: a */
    public boolean m370a(@NotNull C0088bE c0088bE) {
        return this.f577p.add(c0088bE);
    }

    /* JADX INFO: renamed from: b */
    public boolean m371b(@NotNull C0088bE c0088bE) {
        return this.f577p.remove(c0088bE);
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public List<AbstractWidget> m372d() {
        return Collections.unmodifiableList(this.f578q);
    }

    /* JADX INFO: renamed from: b */
    public boolean m373b(@NotNull AbstractWidget abstractWidget) {
        return this.f578q.stream().anyMatch(abstractWidget2 -> {
            return abstractWidget2 == abstractWidget;
        });
    }

    /* JADX INFO: renamed from: x */
    public int m374x() {
        return this.f581dE;
    }

    public int height() {
        return this.f582dF;
    }

    /* JADX INFO: renamed from: c */
    public void m375c(int i) {
        this.f579cc = i;
    }

    /* JADX INFO: renamed from: d */
    public void m376d(int i) {
        this.f580cd = i;
    }

    /* JADX INFO: renamed from: e */
    public void m377e(int i) {
        this.f581dE = i;
    }

    /* JADX INFO: renamed from: f */
    public void m378f(int i) {
        this.f582dF = i;
    }

    /* JADX INFO: renamed from: I */
    protected void m379I() {
        this.f577p.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Screen m380a() {
        return this.f576b;
    }

    /* JADX INFO: renamed from: r */
    protected boolean m381r() {
        return this.f583aO;
    }

    /* JADX INFO: renamed from: f */
    protected void m382f(boolean z) {
        this.f583aO = z;
    }

    /* JADX INFO: renamed from: g */
    public void m383g(boolean z) {
        this.f584aP = z;
    }

    /* JADX INFO: renamed from: r */
    public int m384r() {
        return this.f579cc;
    }

    /* JADX INFO: renamed from: s */
    public int m385s() {
        return this.f580cd;
    }

    /* JADX INFO: renamed from: a */
    public void m386a(@NotNull Screen screen) {
        this.f576b = screen;
    }
}
