package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ne */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ne.class */
public class C0760ne extends AbstractC0759nd<C0737nH> {
    public C0760ne(@NotNull C0756na c0756na, float f) {
        super(c0756na, f);
    }

    @Override // com.boehmod.blockfront.AbstractC0759nd
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Class<C0737nH> mo3598a() {
        return C0737nH.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0759nd
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo3599g(@NotNull C0737nH c0737nH) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0759nd
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean mo3600h(C0737nH c0737nH) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0759nd
    public void start() {
        super.start();
        this.f4259b.m3584c().ifPresent(c1092tr -> {
            this.f4259b.m3537a(c1092tr.m5993f());
        });
    }
}
