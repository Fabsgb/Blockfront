package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.C0263jt;
import com.boehmod.blockfront.P;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/d.class */
public final class d extends Record {
    private final int W;

    @NotNull
    private static final ThreadLocal<double[]> a = ThreadLocal.withInitial(() -> {
        return new double[7];
    });
    private static volatile boolean G = true;

    public d(int i) {
        this.W = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/d;->W:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/d;->W:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/d;->W:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int m() {
        return this.W;
    }

    public void r() {
        RustCorpsePhysics.removeObject(this.W);
    }

    @NotNull
    public P a(@NotNull P p) {
        if (G) {
            try {
                double[] dArr = a.get();
                RustCorpsePhysics.getPoseInto(this.W, dArr);
                p.d().set(dArr[0], dArr[1], dArr[2]);
                p.mo158a().set(dArr[3], dArr[4], dArr[5], dArr[6]);
                return p;
            } catch (UnsatisfiedLinkError e) {
                G = false;
                C0263jt.a("[BlockFront] Native getPoseInto unavailable; using allocating getPose fallback. Rebuild corpse_physics natives for best performance.", new Object[0]);
            }
        }
        double[] pose = RustCorpsePhysics.getPose(this.W);
        p.d().set(pose[0], pose[1], pose[2]);
        p.mo158a().set(pose[3], pose[4], pose[5], pose[6]);
        return p;
    }

    public void b(@NotNull Vector3dc vector3dc, @NotNull Vector3dc vector3dc2) {
        RustCorpsePhysics.addLinearAngularVelocities(this.W, vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public void a(double d) {
        RustCorpsePhysics.multiplyVelocities(this.W, d);
    }

    public void a(@NotNull d dVar, @NotNull Vector3dc vector3dc, @NotNull Vector3dc vector3dc2, @NotNull Quaterniondc quaterniondc, @NotNull Quaterniondc quaterniondc2, @NotNull Vector3dc vector3dc3, double d) {
        RustCorpsePhysics.addRagdollConstraint(this.W, dVar.W, vector3dc.x(), vector3dc.y(), vector3dc.z(), quaterniondc.x(), quaterniondc.y(), quaterniondc.z(), quaterniondc.w(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), quaterniondc2.x(), quaterniondc2.y(), quaterniondc2.z(), quaterniondc2.w(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), d);
    }
}
