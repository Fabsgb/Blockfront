package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.IAbstractWidgetExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ex */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ex.class */
@OnlyIn(Dist.CLIENT)
public abstract class AbstractC0302ex extends AbstractWidget implements IAbstractWidgetExtension {

    /* JADX INFO: renamed from: cb */
    private boolean f2354cb;

    /* JADX INFO: renamed from: aG */
    private boolean f2355aG;

    /* JADX INFO: renamed from: G */
    @NotNull
    private final List<a> f2356G;

    /* JADX INFO: renamed from: a */
    protected abstract void mo1440a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2);

    protected AbstractC0302ex(int i, int i2, int i3, int i4, @NotNull Component component) {
        super(i, i2, i3, i4, component);
        this.f2354cb = false;
        this.f2355aG = false;
        this.f2356G = new ObjectArrayList();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ex$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ex$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: a */
        @NotNull
        private final AbstractWidget f2357a;

        /* JADX INFO: renamed from: cc */
        private final boolean f2358cc;

        private a(@NotNull AbstractWidget abstractWidget, boolean z) {
            this.f2357a = abstractWidget;
            this.f2358cc = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "widget;manualRender", "FIELD:Lcom/boehmod/blockfront/ex$a;->a:Lnet/minecraft/client/gui/components/AbstractWidget;", "FIELD:Lcom/boehmod/blockfront/ex$a;->cc:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "widget;manualRender", "FIELD:Lcom/boehmod/blockfront/ex$a;->a:Lnet/minecraft/client/gui/components/AbstractWidget;", "FIELD:Lcom/boehmod/blockfront/ex$a;->cc:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "widget;manualRender", "FIELD:Lcom/boehmod/blockfront/ex$a;->a:Lnet/minecraft/client/gui/components/AbstractWidget;", "FIELD:Lcom/boehmod/blockfront/ex$a;->cc:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public AbstractWidget m1635a() {
            return this.f2357a;
        }

        /* JADX INFO: renamed from: G */
        public boolean m1636G() {
            return this.f2358cc;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m1631a(@NotNull AbstractWidget abstractWidget) {
        m1632a(abstractWidget, false);
    }

    /* JADX INFO: renamed from: a */
    protected void m1632a(@NotNull AbstractWidget abstractWidget, boolean z) {
        this.f2356G.add(new a(abstractWidget, z));
    }

    /* JADX INFO: renamed from: au */
    protected void m1633au() {
        this.f2356G.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0302ex m1634a() {
        this.f2355aG = true;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void mo1443a(float f) {
    }

    /* JADX INFO: renamed from: F */
    protected boolean mo1444F() {
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected List<Component> mo1441a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0555jl c0555jl) {
        return List.of();
    }

    public void playDownSound(@NotNull SoundManager soundManager) {
    }

    public boolean mouseClicked(double d, double d2, int i) {
        Iterator<a> it = this.f2356G.iterator();
        while (it.hasNext()) {
            if (it.next().m1635a().mouseClicked(d, d2, i)) {
                return true;
            }
        }
        if (mo1444F()) {
            return super.mouseClicked(d, d2, i);
        }
        return false;
    }

    protected final void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return;
        }
        boolean zContains = minecraft.screen.renderables.contains(this);
        if (isHovered() && !zContains) {
            this.isHovered = false;
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        C0555jl c0555jlM1886a = c0396gl.m1886a(minecraft);
        mo1440a(minecraft, c0623lM2852b, c0396gl, c0555jlM1886a, guiGraphics, i, i2, C0129bt.m466g(), f);
        for (a aVar : this.f2356G) {
            if (!aVar.m1636G()) {
                aVar.m1635a().render(guiGraphics, i, i2, f);
            }
        }
        if (!isHovered()) {
            this.f2354cb = false;
            return;
        }
        if (this.f2355aG && !this.f2354cb) {
            this.f2354cb = true;
            C0260eH.m1478r(minecraft);
            C0260eH.m1479b(minecraft, getMessage());
        }
        C0260eH.m1480a(guiGraphics, minecraft.font, mo1441a(minecraft, c0623lM2852b, c0555jlM1886a), i, i2);
    }

    protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
        defaultButtonNarrationText(narrationElementOutput);
    }
}
