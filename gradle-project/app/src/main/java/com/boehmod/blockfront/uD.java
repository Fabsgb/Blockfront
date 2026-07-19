package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uD.class */
public final class uD extends Record {

    @NotNull
    private final jG a;

    @NotNull
    private final Vec3 au;
    private final double aU;

    public uD(@NotNull jG jGVar, @NotNull Vec3 vec3, double d) {
        this.a = jGVar;
        this.au = vec3;
        this.aU = d;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, uD.class), uD.class, "entitySnapshot;intersection;distanceSqr", "FIELD:Lcom/boehmod/blockfront/uD;->a:Lcom/boehmod/blockfront/jG;", "FIELD:Lcom/boehmod/blockfront/uD;->au:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/uD;->aU:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, uD.class), uD.class, "entitySnapshot;intersection;distanceSqr", "FIELD:Lcom/boehmod/blockfront/uD;->a:Lcom/boehmod/blockfront/jG;", "FIELD:Lcom/boehmod/blockfront/uD;->au:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/uD;->aU:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, uD.class, Object.class), uD.class, "entitySnapshot;intersection;distanceSqr", "FIELD:Lcom/boehmod/blockfront/uD;->a:Lcom/boehmod/blockfront/jG;", "FIELD:Lcom/boehmod/blockfront/uD;->au:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/uD;->aU:D").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public jG a() {
        return this.a;
    }

    @NotNull
    public Vec3 C() {
        return this.au;
    }

    public double u() {
        return this.aU;
    }
}
