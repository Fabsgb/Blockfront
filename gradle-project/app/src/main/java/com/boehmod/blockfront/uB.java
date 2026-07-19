package com.boehmod.blockfront;

import com.boehmod.blockfront.uA;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uB.class */
public final class uB<S extends uA<?, ?, ?, ?>> {

    @Nullable
    private S a;

    @NotNull
    public S a(@NotNull uI uIVar, @NotNull Function<uI, S> function) {
        if (this.a == null) {
            this.a = function.apply(uIVar);
        } else {
            this.a.b(uIVar);
        }
        return this.a;
    }
}
