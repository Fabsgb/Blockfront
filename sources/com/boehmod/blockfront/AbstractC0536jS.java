package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0531jN;
import com.boehmod.blockfront.AbstractC0537jT;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jS.class */
public abstract class AbstractC0536jS<M extends AbstractC0531jN<?, ?, ?>, S extends AbstractC0537jT<M>> {

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final S f3210a;

    public AbstractC0536jS(@NotNull S s) {
        this.f3210a = s;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: b */
    public void mo2406b(@NotNull M m) {
        this.f3210a.mo2408b(m);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public S m2407a() {
        return this.f3210a;
    }
}
