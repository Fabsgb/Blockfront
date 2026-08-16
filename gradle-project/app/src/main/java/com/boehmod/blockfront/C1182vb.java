package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC1181va;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.vb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vb.class */
public final class C1182vb<S extends AbstractC1181va<?, ?, ?, ?>> {

    /* JADX INFO: renamed from: a */
    @Nullable
    private S f6437a;

    @NotNull
    /* JADX INFO: renamed from: a */
    public S m6739a(@NotNull C1189vi c1189vi, @NotNull Function<C1189vi, S> function) {
        if (this.f6437a == null) {
            this.f6437a = function.apply(c1189vi);
        } else {
            this.f6437a.m6712b(c1189vi);
        }
        return this.f6437a;
    }
}
