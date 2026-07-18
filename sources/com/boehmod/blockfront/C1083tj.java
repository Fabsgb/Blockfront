package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tj.class */
public class C1083tj<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC1084tk<G, P> {

    /* JADX INFO: renamed from: w */
    @NotNull
    private final Supplier<? extends AbstractC1084tk<G, P>> f5664w;

    public C1083tj(@NotNull Supplier<? extends AbstractC1084tk<G, P>> supplier) {
        this.f5664w = supplier;
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<G, P> c1085tl) {
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<G, P> c1085tl) {
        return !c1085tl.m5994m().isEmpty();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<G, P> mo5148a(@NotNull G g) {
        return this.f5664w.get();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.IDLE;
    }
}
