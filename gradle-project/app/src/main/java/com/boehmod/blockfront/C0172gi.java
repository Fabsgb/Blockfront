package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gi.class */
public final class C0172gi extends Record {

    @NotNull
    private final List<C0171gh> J;

    @NotNull
    public static final Codec<C0172gi> f = C0171gh.e.listOf().xmap(C0172gi::new, (v0) -> {
        return v0.k();
    });

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0172gi.class), C0172gi.class, "layers", "FIELD:Lcom/boehmod/blockfront/gi;->J:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0172gi.class), C0172gi.class, "layers", "FIELD:Lcom/boehmod/blockfront/gi;->J:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0172gi.class, Object.class), C0172gi.class, "layers", "FIELD:Lcom/boehmod/blockfront/gi;->J:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public List<C0171gh> k() {
        return this.J;
    }

    public C0172gi(@NotNull List<C0171gh> list) {
        this.J = List.copyOf(list);
    }
}
