package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mI.class */
public class C0684mI extends AbstractC0683mH<C0766nl> {
    public C0684mI(@NotNull C0680mE c0680mE, float f) {
        super(c0680mE, f);
    }

    @Override // com.boehmod.blockfront.AbstractC0683mH
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Class<C0766nl> mo3091a() {
        return C0766nl.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0683mH
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo3092g(@NotNull C0766nl c0766nl) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0683mH
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean mo3093h(C0766nl c0766nl) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0683mH
    public void start() {
        super.start();
        this.f3696b.m3077c().ifPresent(c1014sU -> {
            this.f3696b.m3029a(c1014sU.m5505f());
        });
    }
}
