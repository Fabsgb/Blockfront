package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.X */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/X.class */
public final class C0027X extends Record {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0015L f255b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final PoseStack f256a;

    /* JADX INFO: renamed from: u */
    private final float f257u;

    public C0027X(@NotNull C0015L c0015l, @NotNull PoseStack poseStack, float f) {
        this.f255b = c0015l;
        this.f256a = poseStack;
        this.f257u = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0027X.class), C0027X.class, "ragdollManager;transformStack;scaleFactor", "FIELD:Lcom/boehmod/blockfront/X;->b:Lcom/boehmod/blockfront/L;", "FIELD:Lcom/boehmod/blockfront/X;->a:Lcom/mojang/blaze3d/vertex/PoseStack;", "FIELD:Lcom/boehmod/blockfront/X;->u:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0027X.class), C0027X.class, "ragdollManager;transformStack;scaleFactor", "FIELD:Lcom/boehmod/blockfront/X;->b:Lcom/boehmod/blockfront/L;", "FIELD:Lcom/boehmod/blockfront/X;->a:Lcom/mojang/blaze3d/vertex/PoseStack;", "FIELD:Lcom/boehmod/blockfront/X;->u:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0027X.class, Object.class), C0027X.class, "ragdollManager;transformStack;scaleFactor", "FIELD:Lcom/boehmod/blockfront/X;->b:Lcom/boehmod/blockfront/L;", "FIELD:Lcom/boehmod/blockfront/X;->a:Lcom/mojang/blaze3d/vertex/PoseStack;", "FIELD:Lcom/boehmod/blockfront/X;->u:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0015L m164b() {
        return this.f255b;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public PoseStack m165a() {
        return this.f256a;
    }

    /* JADX INFO: renamed from: a */
    public float m166a() {
        return this.f257u;
    }
}
