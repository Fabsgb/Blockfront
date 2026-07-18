package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gi.class */
public final class C0392gi extends Record {

    /* JADX INFO: renamed from: J */
    @NotNull
    private final List<C0391gh> f2596J;

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final Codec<C0392gi> f2597f = C0391gh.f2595e.listOf().xmap(C0392gi::new, (v0) -> {
        return v0.m1886k();
    });

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0392gi.class), C0392gi.class, "layers", "FIELD:Lcom/boehmod/blockfront/gi;->J:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0392gi.class), C0392gi.class, "layers", "FIELD:Lcom/boehmod/blockfront/gi;->J:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0392gi.class, Object.class), C0392gi.class, "layers", "FIELD:Lcom/boehmod/blockfront/gi;->J:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public List<C0391gh> m1886k() {
        return this.f2596J;
    }

    public C0392gi(@NotNull List<C0391gh> list) {
        this.f2596J = List.copyOf(list);
    }
}
