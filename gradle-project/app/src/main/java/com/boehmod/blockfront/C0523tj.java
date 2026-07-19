package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tj.class */
public class C0523tj<G extends oF<G, P, ?>, P extends oI<G>> extends AbstractC0524tk<G, P> {

    @NotNull
    private final Supplier<? extends AbstractC0524tk<G, P>> w;

    public C0523tj(@NotNull Supplier<? extends AbstractC0524tk<G, P>> supplier) {
        this.w = supplier;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<G, P> c0525tl) {
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<G, P> c0525tl) {
        return !c0525tl.m().isEmpty();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<G, P> a(@NotNull G g) {
        return this.w.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.IDLE;
    }
}
