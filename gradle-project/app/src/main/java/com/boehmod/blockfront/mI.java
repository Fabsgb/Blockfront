package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mI.class */
public class mI extends mH<C0363nl> {
    public mI(@NotNull mE mEVar, float f) {
        super(mEVar, f);
    }

    @Override // com.boehmod.blockfront.mH
    @NotNull
    protected Class<C0363nl> a() {
        return C0363nl.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.mH
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean g(@NotNull C0363nl c0363nl) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.mH
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean h(C0363nl c0363nl) {
        return true;
    }

    @Override // com.boehmod.blockfront.mH
    public void start() {
        super.start();
        this.b.c().ifPresent(sUVar -> {
            this.b.a(sUVar.f());
        });
    }
}
