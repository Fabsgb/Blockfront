package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uD.class */
public final class C1104uD extends Record {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0523jG f5800a;

    /* JADX INFO: renamed from: au */
    @NotNull
    private final Vec3 f5801au;

    /* JADX INFO: renamed from: aU */
    private final double f5802aU;

    public C1104uD(@NotNull C0523jG c0523jG, @NotNull Vec3 vec3, double d) {
        this.f5800a = c0523jG;
        this.f5801au = vec3;
        this.f5802aU = d;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1104uD.class), C1104uD.class, "entitySnapshot;intersection;distanceSqr", "FIELD:Lcom/boehmod/blockfront/uD;->a:Lcom/boehmod/blockfront/jG;", "FIELD:Lcom/boehmod/blockfront/uD;->au:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/uD;->aU:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1104uD.class), C1104uD.class, "entitySnapshot;intersection;distanceSqr", "FIELD:Lcom/boehmod/blockfront/uD;->a:Lcom/boehmod/blockfront/jG;", "FIELD:Lcom/boehmod/blockfront/uD;->au:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/uD;->aU:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1104uD.class, Object.class), C1104uD.class, "entitySnapshot;intersection;distanceSqr", "FIELD:Lcom/boehmod/blockfront/uD;->a:Lcom/boehmod/blockfront/jG;", "FIELD:Lcom/boehmod/blockfront/uD;->au:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/uD;->aU:D").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0523jG m6094a() {
        return this.f5800a;
    }

    @NotNull
    /* JADX INFO: renamed from: C */
    public Vec3 m6095C() {
        return this.f5801au;
    }

    /* JADX INFO: renamed from: u */
    public double m6096u() {
        return this.f5802aU;
    }
}
