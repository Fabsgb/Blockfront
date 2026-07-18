package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jE.class */
public final class C0521jE extends Record {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final a f3063a;

    /* JADX INFO: renamed from: V */
    @NotNull
    private final List<C1142up> f3064V;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C0521jE f3065a = new C0521jE(a.INVALID, List.of());

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final C0521jE f3066b = new C0521jE(a.QUEUED, List.of());

    /* JADX INFO: renamed from: com.boehmod.blockfront.jE$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jE$a.class */
    public enum a {
        INVALID,
        QUEUED,
        VALID
    }

    public C0521jE(@NotNull a aVar, @NotNull List<C1142up> list) {
        this.f3063a = aVar;
        this.f3064V = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0521jE.class), C0521jE.class, "status;validatedHits", "FIELD:Lcom/boehmod/blockfront/jE;->a:Lcom/boehmod/blockfront/jE$a;", "FIELD:Lcom/boehmod/blockfront/jE;->V:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0521jE.class), C0521jE.class, "status;validatedHits", "FIELD:Lcom/boehmod/blockfront/jE;->a:Lcom/boehmod/blockfront/jE$a;", "FIELD:Lcom/boehmod/blockfront/jE;->V:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0521jE.class, Object.class), C0521jE.class, "status;validatedHits", "FIELD:Lcom/boehmod/blockfront/jE;->a:Lcom/boehmod/blockfront/jE$a;", "FIELD:Lcom/boehmod/blockfront/jE;->V:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m2285a() {
        return this.f3063a;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public List<C1142up> m2286o() {
        return this.f3064V;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0521jE m2283a(@NotNull List<C1142up> list) {
        return new C0521jE(a.VALID, list);
    }

    /* JADX INFO: renamed from: af */
    public boolean m2284af() {
        return this.f3063a == a.VALID;
    }
}
