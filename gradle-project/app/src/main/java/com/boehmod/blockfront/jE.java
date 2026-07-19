package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jE.class */
public final class jE extends Record {

    @NotNull
    private final a a;

    @NotNull
    private final List<C0556up> V;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final jE f179a = new jE(a.INVALID, List.of());

    @NotNull
    public static final jE b = new jE(a.QUEUED, List.of());

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jE$a.class */
    public enum a {
        INVALID,
        QUEUED,
        VALID
    }

    public jE(@NotNull a aVar, @NotNull List<C0556up> list) {
        this.a = aVar;
        this.V = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, jE.class), jE.class, "status;validatedHits", "FIELD:Lcom/boehmod/blockfront/jE;->a:Lcom/boehmod/blockfront/jE$a;", "FIELD:Lcom/boehmod/blockfront/jE;->V:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, jE.class), jE.class, "status;validatedHits", "FIELD:Lcom/boehmod/blockfront/jE;->a:Lcom/boehmod/blockfront/jE$a;", "FIELD:Lcom/boehmod/blockfront/jE;->V:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, jE.class, Object.class), jE.class, "status;validatedHits", "FIELD:Lcom/boehmod/blockfront/jE;->a:Lcom/boehmod/blockfront/jE$a;", "FIELD:Lcom/boehmod/blockfront/jE;->V:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public a a() {
        return this.a;
    }

    @NotNull
    public List<C0556up> o() {
        return this.V;
    }

    @NotNull
    public static jE a(@NotNull List<C0556up> list) {
        return new jE(a.VALID, list);
    }

    public boolean af() {
        return this.a == a.VALID;
    }
}
