package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.t */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/t.class */
public final class C1048t extends Thread {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0623l f5697c;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0994s f5698a;

    public C1048t(@NotNull C0623l c0623l, @NotNull C0994s c0994s) {
        this.f5697c = c0623l;
        this.f5698a = c0994s;
    }

    /* JADX INFO: Infinite loop detected, blocks: 13, insns: 0 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            try {
                this.f5698a.mo2406b(this.f5697c);
            } catch (Throwable th) {
                C0530jM.m2338a("An exception was encountered.", th, new Object[0]);
            }
            try {
                Thread.sleep(80L);
            } catch (InterruptedException e) {
                C0530jM.m2338a("An exception was encountered.", e, new Object[0]);
            }
        }
    }
}
