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

/* JADX INFO: renamed from: com.boehmod.blockfront.ek, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ek.class */
@OnlyIn(Dist.CLIENT)
public abstract class AbstractC0120ek extends AbstractWidget implements IAbstractWidgetExtension {
    private boolean bT;
    private boolean aB;

    @NotNull
    private final List<a> E;

    protected abstract void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2);

    protected AbstractC0120ek(int i, int i2, int i3, int i4, @NotNull Component component) {
        super(i, i2, i3, i4, component);
        this.bT = false;
        this.aB = false;
        this.E = new ObjectArrayList();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ek$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ek$a.class */
    private static final class a extends Record {

        @NotNull
        private final AbstractWidget a;
        private final boolean bU;

        private a(@NotNull AbstractWidget abstractWidget, boolean z) {
            this.a = abstractWidget;
            this.bU = z;
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
        public AbstractWidget a() {
            return this.a;
        }

        public boolean F() {
            return this.bU;
        }
    }

    protected void a(@NotNull AbstractWidget abstractWidget) {
        a(abstractWidget, false);
    }

    protected void a(@NotNull AbstractWidget abstractWidget, boolean z) {
        this.E.add(new a(abstractWidget, z));
    }

    protected void ap() {
        this.E.clear();
    }

    @NotNull
    public AbstractC0120ek a() {
        this.aB = true;
        return this;
    }

    public void a(float f) {
    }

    protected boolean E() {
        return false;
    }

    @NotNull
    protected List<Component> a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull iS iSVar) {
        return List.of();
    }

    public void playDownSound(@NotNull SoundManager soundManager) {
    }

    public boolean mouseClicked(double d, double d2, int i) {
        Iterator<a> it = this.E.iterator();
        while (it.hasNext()) {
            if (it.next().a().mouseClicked(d, d2, i)) {
                return true;
            }
        }
        if (E()) {
            return super.mouseClicked(d, d2, i);
        }
        return false;
    }

    protected final void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return;
        }
        boolean zContains = minecraft.screen.renderables.contains(this);
        if (isHovered() && !zContains) {
            this.isHovered = false;
        }
        fV fVVar = (fV) c0297lB.a();
        iS iSVarM404a = fVVar.m404a(minecraft);
        a(minecraft, c0297lB, fVVar, iSVarM404a, guiGraphics, i, i2, C0040bk.g(), f);
        for (a aVar : this.E) {
            if (!aVar.F()) {
                aVar.a().render(guiGraphics, i, i2, f);
            }
        }
        if (!isHovered()) {
            this.bT = false;
            return;
        }
        if (this.aB && !this.bT) {
            this.bT = true;
            C0130eu.q(minecraft);
            C0130eu.b(minecraft, getMessage());
        }
        C0130eu.a(guiGraphics, minecraft.font, a(minecraft, c0297lB, iSVarM404a), i, i2);
    }

    protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
        defaultButtonNarrationText(narrationElementOutput);
    }
}
