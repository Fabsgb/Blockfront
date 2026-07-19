package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/R.class */
public final class R extends Record {

    @NotNull
    private final F b;

    @NotNull
    private final PoseStack a;
    private final float p;

    public R(@NotNull F f, @NotNull PoseStack poseStack, float f2) {
        this.b = f;
        this.a = poseStack;
        this.p = f2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, R.class), R.class, "ragdollManager;transformStack;scaleFactor", "FIELD:Lcom/boehmod/blockfront/R;->b:Lcom/boehmod/blockfront/F;", "FIELD:Lcom/boehmod/blockfront/R;->a:Lcom/mojang/blaze3d/vertex/PoseStack;", "FIELD:Lcom/boehmod/blockfront/R;->p:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, R.class), R.class, "ragdollManager;transformStack;scaleFactor", "FIELD:Lcom/boehmod/blockfront/R;->b:Lcom/boehmod/blockfront/F;", "FIELD:Lcom/boehmod/blockfront/R;->a:Lcom/mojang/blaze3d/vertex/PoseStack;", "FIELD:Lcom/boehmod/blockfront/R;->p:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, R.class, Object.class), R.class, "ragdollManager;transformStack;scaleFactor", "FIELD:Lcom/boehmod/blockfront/R;->b:Lcom/boehmod/blockfront/F;", "FIELD:Lcom/boehmod/blockfront/R;->a:Lcom/mojang/blaze3d/vertex/PoseStack;", "FIELD:Lcom/boehmod/blockfront/R;->p:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public F b() {
        return this.b;
    }

    @NotNull
    public PoseStack a() {
        return this.a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public float m159a() {
        return this.p;
    }
}
