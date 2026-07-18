package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tq.class */
public class C1090tq {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final AbstractC0788oG<?, ?> f5733c;

    /* JADX INFO: renamed from: rA */
    private final int f5735rA;

    /* JADX INFO: renamed from: Z */
    @NotNull
    private final ObjectList<AbstractC0156cU> f5732Z = new ObjectArrayList();

    /* JADX INFO: renamed from: gl */
    private boolean f5734gl = false;

    public C1090tq(@NotNull C0622l c0622l, @NotNull AbstractC0788oG<?, ?> abstractC0788oG) {
        this.f5733c = abstractC0788oG;
        this.f5735rA = ((C0326fV) c0622l.m2670a()).m1676a(Minecraft.getInstance()).getExp();
    }

    /* JADX INFO: renamed from: bT */
    public int m6013bT() {
        return this.f5735rA;
    }

    /* JADX INFO: renamed from: U */
    public void m6014U(boolean z) {
        this.f5732Z.addAll(this.f5733c.mo3743a(z));
    }

    /* JADX INFO: renamed from: V */
    public void m6015V(boolean z) {
        if (this.f5734gl) {
            return;
        }
        m6014U(z);
        this.f5734gl = true;
    }

    /* JADX INFO: renamed from: n */
    public void m6016n(@NotNull Minecraft minecraft) {
        if (this.f5732Z.isEmpty()) {
            return;
        }
        if (minecraft.screen != null) {
            Screen screen = minecraft.screen;
            if (!(screen instanceof AbstractC0156cU) || !((AbstractC0156cU) screen).mo992x()) {
                return;
            }
        }
        minecraft.setScreen(((AbstractC0156cU) this.f5732Z.removeFirst()).m991a(this.f5732Z.isEmpty()));
    }

    /* JADX INFO: renamed from: cg */
    public boolean m6017cg() {
        return this.f5734gl;
    }
}
