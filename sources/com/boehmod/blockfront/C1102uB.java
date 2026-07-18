package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC1101uA;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uB.class */
public final class C1102uB<S extends AbstractC1101uA<?, ?, ?, ?>> {

    /* JADX INFO: renamed from: a */
    @Nullable
    private S f5796a;

    @NotNull
    /* JADX INFO: renamed from: a */
    public S m6087a(@NotNull C1109uI c1109uI, @NotNull Function<C1109uI, S> function) {
        if (this.f5796a == null) {
            this.f5796a = function.apply(c1109uI);
        } else {
            this.f5796a.m6061b(c1109uI);
        }
        return this.f5796a;
    }
}
