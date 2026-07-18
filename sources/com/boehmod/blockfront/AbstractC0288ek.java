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

/* JADX INFO: renamed from: com.boehmod.blockfront.ek */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ek.class */
@OnlyIn(Dist.CLIENT)
public abstract class AbstractC0288ek extends AbstractWidget implements IAbstractWidgetExtension {

    /* JADX INFO: renamed from: bT */
    private boolean f2181bT;

    /* JADX INFO: renamed from: aB */
    private boolean f2182aB;

    /* JADX INFO: renamed from: E */
    @NotNull
    private final List<a> f2183E;

    /* JADX INFO: renamed from: a */
    protected abstract void mo1521a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2);

    protected AbstractC0288ek(int i, int i2, int i3, int i4, @NotNull Component component) {
        super(i, i2, i3, i4, component);
        this.f2181bT = false;
        this.f2182aB = false;
        this.f2183E = new ObjectArrayList();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ek$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ek$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: a */
        @NotNull
        private final AbstractWidget f2184a;

        /* JADX INFO: renamed from: bU */
        private final boolean f2185bU;

        private a(@NotNull AbstractWidget abstractWidget, boolean z) {
            this.f2184a = abstractWidget;
            this.f2185bU = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "widget;manualRender", "FIELD:Lcom/boehmod/blockfront/ek$a;->a:Lnet/minecraft/client/gui/components/AbstractWidget;", "FIELD:Lcom/boehmod/blockfront/ek$a;->bU:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "widget;manualRender", "FIELD:Lcom/boehmod/blockfront/ek$a;->a:Lnet/minecraft/client/gui/components/AbstractWidget;", "FIELD:Lcom/boehmod/blockfront/ek$a;->bU:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "widget;manualRender", "FIELD:Lcom/boehmod/blockfront/ek$a;->a:Lnet/minecraft/client/gui/components/AbstractWidget;", "FIELD:Lcom/boehmod/blockfront/ek$a;->bU:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public AbstractWidget m1523a() {
            return this.f2184a;
        }

        /* JADX INFO: renamed from: F */
        public boolean m1524F() {
            return this.f2185bU;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m1515a(@NotNull AbstractWidget abstractWidget) {
        m1516a(abstractWidget, false);
    }

    /* JADX INFO: renamed from: a */
    protected void m1516a(@NotNull AbstractWidget abstractWidget, boolean z) {
        this.f2183E.add(new a(abstractWidget, z));
    }

    /* JADX INFO: renamed from: ap */
    protected void m1517ap() {
        this.f2183E.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0288ek m1518a() {
        this.f2182aB = true;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void mo1519a(float f) {
    }

    /* JADX INFO: renamed from: E */
    protected boolean mo1520E() {
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected List<Component> mo1522a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0482iS c0482iS) {
        return List.of();
    }

    public void playDownSound(@NotNull SoundManager soundManager) {
    }

    public boolean mouseClicked(double d, double d2, int i) {
        Iterator<a> it = this.f2183E.iterator();
        while (it.hasNext()) {
            if (it.next().m1523a().mouseClicked(d, d2, i)) {
                return true;
            }
        }
        if (mo1520E()) {
            return super.mouseClicked(d, d2, i);
        }
        return false;
    }

    protected final void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return;
        }
        boolean zContains = minecraft.screen.renderables.contains(this);
        if (isHovered() && !zContains) {
            this.isHovered = false;
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        C0482iS c0482iSM1676a = c0326fV.m1676a(minecraft);
        mo1521a(minecraft, c0622lM2667b, c0326fV, c0482iSM1676a, guiGraphics, i, i2, C0119bk.m366g(), f);
        for (a aVar : this.f2183E) {
            if (!aVar.m1524F()) {
                aVar.m1523a().render(guiGraphics, i, i2, f);
            }
        }
        if (!isHovered()) {
            this.f2181bT = false;
            return;
        }
        if (this.f2182aB && !this.f2181bT) {
            this.f2181bT = true;
            C0298eu.m1576q(minecraft);
            C0298eu.m1577b(minecraft, getMessage());
        }
        C0298eu.m1578a(guiGraphics, minecraft.font, mo1522a(minecraft, c0622lM2667b, c0482iSM1676a), i, i2);
    }

    protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
        defaultButtonNarrationText(narrationElementOutput);
    }
}
