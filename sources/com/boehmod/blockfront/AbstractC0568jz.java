package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0517jA;
import com.boehmod.blockfront.AbstractC0563ju;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jz.class */
public abstract class AbstractC0568jz<M extends AbstractC0563ju<?, ?, ?>, S extends AbstractC0517jA<M>> {

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final S f3226a;

    public AbstractC0568jz(@NotNull S s) {
        this.f3226a = s;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: b */
    public void mo2581b(@NotNull M m) {
        this.f3226a.mo2274b(m);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public S m2582a() {
        return this.f3226a;
    }
}
