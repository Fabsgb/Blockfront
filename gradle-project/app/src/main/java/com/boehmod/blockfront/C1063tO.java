package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tO.class */
public class C1063tO {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final AbstractC0864pc<?, ?> f5786c;

    /* JADX INFO: renamed from: tD */
    private final int f5788tD;

    /* JADX INFO: renamed from: ai */
    @NotNull
    private final ObjectList<AbstractC0229dd> f5785ai = new ObjectArrayList();

    /* JADX INFO: renamed from: gF */
    private boolean f5787gF = false;

    public C1063tO(@NotNull C0623l c0623l, @NotNull AbstractC0864pc<?, ?> abstractC0864pc) {
        this.f5786c = abstractC0864pc;
        this.f5788tD = ((C0396gl) c0623l.m2855a()).m1886a(Minecraft.getInstance()).getExp();
    }

    /* JADX INFO: renamed from: ci */
    public int m5899ci() {
        return this.f5788tD;
    }

    /* JADX INFO: renamed from: V */
    public void m5900V(boolean z) {
        this.f5785ai.addAll(this.f5786c.mo4179a(z));
    }

    /* JADX INFO: renamed from: W */
    public void m5901W(boolean z) {
        if (this.f5787gF) {
            return;
        }
        m5900V(z);
        this.f5787gF = true;
    }

    /* JADX INFO: renamed from: o */
    public void m5902o(@NotNull Minecraft minecraft) {
        if (this.f5785ai.isEmpty()) {
            return;
        }
        if (minecraft.screen != null) {
            Screen screen = minecraft.screen;
            if (!(screen instanceof AbstractC0229dd) || !((AbstractC0229dd) screen).mo1347y()) {
                return;
            }
        }
        minecraft.setScreen(((AbstractC0229dd) this.f5785ai.removeFirst()).m1346a(this.f5785ai.isEmpty()));
    }

    /* JADX INFO: renamed from: cq */
    public boolean m5903cq() {
        return this.f5787gF;
    }
}
