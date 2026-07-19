package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/s.class */
public final class C0486s extends Thread {

    @NotNull
    private final C0297l b;

    @NotNull
    private final C0459r a;

    public C0486s(@NotNull C0297l c0297l, @NotNull C0459r c0459r) {
        this.b = c0297l;
        this.a = c0459r;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            this.a.b(this.b);
            try {
                Thread.sleep(80L);
            } catch (InterruptedException e) {
                C0263jt.a("An exception was encountered.", e, new Object[0]);
            }
        }
    }
}
