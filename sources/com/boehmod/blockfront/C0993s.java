package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.s */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/s.class */
public final class C0993s extends Thread {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0622l f5256b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0940r f5257a;

    public C0993s(@NotNull C0622l c0622l, @NotNull C0940r c0940r) {
        this.f5256b = c0622l;
        this.f5257a = c0940r;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            this.f5257a.mo2581b(this.f5256b);
            try {
                Thread.sleep(80L);
            } catch (InterruptedException e) {
                C0562jt.m2516a("An exception was encountered.", e, new Object[0]);
            }
        }
    }
}
