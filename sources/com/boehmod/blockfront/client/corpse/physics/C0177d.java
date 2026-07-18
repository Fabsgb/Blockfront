package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.C0018P;
import com.boehmod.blockfront.C0562jt;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.client.corpse.physics.d */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/d.class */
public final class C0177d extends Record {

    /* JADX INFO: renamed from: W */
    private final int f1454W;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final ThreadLocal<double[]> f1455a = ThreadLocal.withInitial(() -> {
        return new double[7];
    });

    /* JADX INFO: renamed from: G */
    private static volatile boolean f1456G = true;

    public C0177d(int i) {
        this.f1454W = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0177d.class), C0177d.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/d;->W:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0177d.class), C0177d.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/d;->W:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0177d.class, Object.class), C0177d.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/d;->W:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: m */
    public int m1058m() {
        return this.f1454W;
    }

    /* JADX INFO: renamed from: r */
    public void m1053r() {
        RustCorpsePhysics.removeObject(this.f1454W);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0018P m1054a(@NotNull C0018P c0018p) {
        if (f1456G) {
            try {
                double[] dArr = f1455a.get();
                RustCorpsePhysics.getPoseInto(this.f1454W, dArr);
                c0018p.mo124d().set(dArr[0], dArr[1], dArr[2]);
                c0018p.mo123a().set(dArr[3], dArr[4], dArr[5], dArr[6]);
                return c0018p;
            } catch (UnsatisfiedLinkError e) {
                f1456G = false;
                C0562jt.m2515a("[BlockFront] Native getPoseInto unavailable; using allocating getPose fallback. Rebuild corpse_physics natives for best performance.", new Object[0]);
            }
        }
        double[] pose = RustCorpsePhysics.getPose(this.f1454W);
        c0018p.mo124d().set(pose[0], pose[1], pose[2]);
        c0018p.mo123a().set(pose[3], pose[4], pose[5], pose[6]);
        return c0018p;
    }

    /* JADX INFO: renamed from: b */
    public void m1055b(@NotNull Vector3dc vector3dc, @NotNull Vector3dc vector3dc2) {
        RustCorpsePhysics.addLinearAngularVelocities(this.f1454W, vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    /* JADX INFO: renamed from: a */
    public void m1056a(double d) {
        RustCorpsePhysics.multiplyVelocities(this.f1454W, d);
    }

    /* JADX INFO: renamed from: a */
    public void m1057a(@NotNull C0177d c0177d, @NotNull Vector3dc vector3dc, @NotNull Vector3dc vector3dc2, @NotNull Quaterniondc quaterniondc, @NotNull Quaterniondc quaterniondc2, @NotNull Vector3dc vector3dc3, double d) {
        RustCorpsePhysics.addRagdollConstraint(this.f1454W, c0177d.f1454W, vector3dc.x(), vector3dc.y(), vector3dc.z(), quaterniondc.x(), quaterniondc.y(), quaterniondc.z(), quaterniondc.w(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), quaterniondc2.x(), quaterniondc2.y(), quaterniondc2.z(), quaterniondc2.w(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), d);
    }
}
