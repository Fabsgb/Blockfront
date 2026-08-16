package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tG.class */
public class C1055tG<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC1056tH<G, P> {

    /* JADX INFO: renamed from: w */
    @NotNull
    private final Supplier<? extends AbstractC1056tH<G, P>> f5711w;

    public C1055tG(@NotNull Supplier<? extends AbstractC1056tH<G, P>> supplier) {
        this.f5711w = supplier;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<G, P> c1057tI) {
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<G, P> c1057tI) {
        return !c1057tI.m5874m().isEmpty();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1056tH<G, P> mo5319a(@NotNull G g) {
        return this.f5711w.get();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj mo5316a() {
        return EnumC0871pj.IDLE;
    }
}
