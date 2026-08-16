package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jX.class */
public final class C0541jX extends Record {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final a f3219a;

    /* JADX INFO: renamed from: Z */
    @NotNull
    private final List<C1120uS> f3220Z;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C0541jX f3221a = new C0541jX(a.INVALID, List.of());

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final C0541jX f3222b = new C0541jX(a.QUEUED, List.of());

    /* JADX INFO: renamed from: com.boehmod.blockfront.jX$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jX$a.class */
    public enum a {
        INVALID,
        QUEUED,
        VALID
    }

    public C0541jX(@NotNull a aVar, @NotNull List<C1120uS> list) {
        this.f3219a = aVar;
        this.f3220Z = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0541jX.class), C0541jX.class, "status;validatedPellets", "FIELD:Lcom/boehmod/blockfront/jX;->a:Lcom/boehmod/blockfront/jX$a;", "FIELD:Lcom/boehmod/blockfront/jX;->Z:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0541jX.class), C0541jX.class, "status;validatedPellets", "FIELD:Lcom/boehmod/blockfront/jX;->a:Lcom/boehmod/blockfront/jX$a;", "FIELD:Lcom/boehmod/blockfront/jX;->Z:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0541jX.class, Object.class), C0541jX.class, "status;validatedPellets", "FIELD:Lcom/boehmod/blockfront/jX;->a:Lcom/boehmod/blockfront/jX$a;", "FIELD:Lcom/boehmod/blockfront/jX;->Z:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m2419a() {
        return this.f3219a;
    }

    @NotNull
    /* JADX INFO: renamed from: q */
    public List<C1120uS> m2420q() {
        return this.f3220Z;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0541jX m2417a(@NotNull List<C1120uS> list) {
        return new C0541jX(a.VALID, list);
    }

    /* JADX INFO: renamed from: aj */
    public boolean m2418aj() {
        return this.f3219a == a.VALID;
    }
}
