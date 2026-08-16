package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000ac.SuspiciousShotReason;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ke */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ke.class */
public final class C0601ke extends Record {

    /* JADX INFO: renamed from: a */
    @Nullable
    private final SuspiciousShotReason f3475a;

    /* JADX INFO: renamed from: aS */
    @NotNull
    private final String f3476aS;

    public C0601ke(@Nullable SuspiciousShotReason suspiciousShotReason, @NotNull String str) {
        this.f3475a = suspiciousShotReason;
        this.f3476aS = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0601ke.class), C0601ke.class, "reason;detail", "FIELD:Lcom/boehmod/blockfront/ke;->a:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShotReason;", "FIELD:Lcom/boehmod/blockfront/ke;->aS:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0601ke.class), C0601ke.class, "reason;detail", "FIELD:Lcom/boehmod/blockfront/ke;->a:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShotReason;", "FIELD:Lcom/boehmod/blockfront/ke;->aS:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0601ke.class, Object.class), C0601ke.class, "reason;detail", "FIELD:Lcom/boehmod/blockfront/ke;->a:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShotReason;", "FIELD:Lcom/boehmod/blockfront/ke;->aS:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public SuspiciousShotReason m2671a() {
        return this.f3475a;
    }

    @NotNull
    /* JADX INFO: renamed from: C */
    public String m2672C() {
        return this.f3476aS;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0601ke m2669a(@NotNull SuspiciousShotReason suspiciousShotReason, @NotNull String str) {
        return new C0601ke(suspiciousShotReason, str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0601ke m2670a(@NotNull String str) {
        return new C0601ke(null, str);
    }
}
