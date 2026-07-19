package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tq.class */
public class C0530tq {

    @NotNull
    private final oG<?, ?> c;
    private final int rA;

    @NotNull
    private final ObjectList<cU> Z = new ObjectArrayList();
    private boolean gl = false;

    public C0530tq(@NotNull C0297l c0297l, @NotNull oG<?, ?> oGVar) {
        this.c = oGVar;
        this.rA = ((fV) c0297l.a()).m404a(Minecraft.getInstance()).getExp();
    }

    public int bT() {
        return this.rA;
    }

    public void U(boolean z) {
        this.Z.addAll(this.c.a(z));
    }

    public void V(boolean z) {
        if (this.gl) {
            return;
        }
        U(z);
        this.gl = true;
    }

    public void n(@NotNull Minecraft minecraft) {
        if (this.Z.isEmpty()) {
            return;
        }
        if (minecraft.screen != null) {
            Screen screen = minecraft.screen;
            if (!(screen instanceof cU) || !((cU) screen).x()) {
                return;
            }
        }
        minecraft.setScreen(((cU) this.Z.removeFirst()).a(this.Z.isEmpty()));
    }

    public boolean cg() {
        return this.gl;
    }
}
