package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0264ju;
import com.boehmod.blockfront.jA;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jz.class */
public abstract class AbstractC0269jz<M extends AbstractC0264ju<?, ?, ?>, S extends jA<M>> {

    @NotNull
    protected final S a;

    public AbstractC0269jz(@NotNull S s) {
        this.a = s;
    }

    @OverridingMethodsMustInvokeSuper
    public void b(@NotNull M m) {
        this.a.b(m);
    }

    @NotNull
    public S a() {
        return this.a;
    }
}
