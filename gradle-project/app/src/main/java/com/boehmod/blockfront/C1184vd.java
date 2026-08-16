package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vd.class */
public final class C1184vd extends Record {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0543jZ f6439a;

    /* JADX INFO: renamed from: av */
    @NotNull
    private final Vec3 f6440av;

    /* JADX INFO: renamed from: bi */
    private final double f6441bi;

    public C1184vd(@NotNull C0543jZ c0543jZ, @NotNull Vec3 vec3, double d) {
        this.f6439a = c0543jZ;
        this.f6440av = vec3;
        this.f6441bi = d;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1184vd.class), C1184vd.class, "entitySnapshot;intersection;distanceSqr", "FIELD:Lcom/boehmod/blockfront/vd;->a:Lcom/boehmod/blockfront/jZ;", "FIELD:Lcom/boehmod/blockfront/vd;->av:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vd;->bi:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1184vd.class), C1184vd.class, "entitySnapshot;intersection;distanceSqr", "FIELD:Lcom/boehmod/blockfront/vd;->a:Lcom/boehmod/blockfront/jZ;", "FIELD:Lcom/boehmod/blockfront/vd;->av:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vd;->bi:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1184vd.class, Object.class), C1184vd.class, "entitySnapshot;intersection;distanceSqr", "FIELD:Lcom/boehmod/blockfront/vd;->a:Lcom/boehmod/blockfront/jZ;", "FIELD:Lcom/boehmod/blockfront/vd;->av:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vd;->bi:D").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0543jZ m6746b() {
        return this.f6439a;
    }

    @NotNull
    /* JADX INFO: renamed from: D */
    public Vec3 m6747D() {
        return this.f6440av;
    }

    /* JADX INFO: renamed from: w */
    public double m6748w() {
        return this.f6441bi;
    }
}
