package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gy.class */
public final class C0409gy extends Record {

    /* JADX INFO: renamed from: M */
    @NotNull
    private final List<C0408gx> f2655M;

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final Codec<C0409gy> f2656f = C0408gx.f2654e.listOf().xmap(C0409gy::new, (v0) -> {
        return v0.m1951m();
    });

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0409gy.class), C0409gy.class, "layers", "FIELD:Lcom/boehmod/blockfront/gy;->M:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0409gy.class), C0409gy.class, "layers", "FIELD:Lcom/boehmod/blockfront/gy;->M:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0409gy.class, Object.class), C0409gy.class, "layers", "FIELD:Lcom/boehmod/blockfront/gy;->M:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public List<C0408gx> m1951m() {
        return this.f2655M;
    }

    public C0409gy(@NotNull List<C0408gx> list) {
        this.f2655M = List.copyOf(list);
    }
}
