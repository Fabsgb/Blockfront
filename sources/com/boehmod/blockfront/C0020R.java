package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.R */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/R.class */
public final class C0020R extends Record {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0008F f212b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final PoseStack f213a;

    /* JADX INFO: renamed from: p */
    private final float f214p;

    public C0020R(@NotNull C0008F c0008f, @NotNull PoseStack poseStack, float f) {
        this.f212b = c0008f;
        this.f213a = poseStack;
        this.f214p = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0020R.class), C0020R.class, "ragdollManager;transformStack;scaleFactor", "FIELD:Lcom/boehmod/blockfront/R;->b:Lcom/boehmod/blockfront/F;", "FIELD:Lcom/boehmod/blockfront/R;->a:Lcom/mojang/blaze3d/vertex/PoseStack;", "FIELD:Lcom/boehmod/blockfront/R;->p:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0020R.class), C0020R.class, "ragdollManager;transformStack;scaleFactor", "FIELD:Lcom/boehmod/blockfront/R;->b:Lcom/boehmod/blockfront/F;", "FIELD:Lcom/boehmod/blockfront/R;->a:Lcom/mojang/blaze3d/vertex/PoseStack;", "FIELD:Lcom/boehmod/blockfront/R;->p:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0020R.class, Object.class), C0020R.class, "ragdollManager;transformStack;scaleFactor", "FIELD:Lcom/boehmod/blockfront/R;->b:Lcom/boehmod/blockfront/F;", "FIELD:Lcom/boehmod/blockfront/R;->a:Lcom/mojang/blaze3d/vertex/PoseStack;", "FIELD:Lcom/boehmod/blockfront/R;->p:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0008F m131b() {
        return this.f212b;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public PoseStack m132a() {
        return this.f213a;
    }

    /* JADX INFO: renamed from: a */
    public float m133a() {
        return this.f214p;
    }
}
