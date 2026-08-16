package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.C0025V;
import com.boehmod.blockfront.C0530jM;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.client.corpse.physics.d */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/d.class */
public final class C0178d extends Record {

    /* JADX INFO: renamed from: aK */
    private final int f1373aK;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final ThreadLocal<double[]> f1374a = ThreadLocal.withInitial(() -> {
        return new double[7];
    });

    /* JADX INFO: renamed from: L */
    private static volatile boolean f1375L = true;

    public C0178d(int i) {
        this.f1373aK = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0178d.class), C0178d.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/d;->aK:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0178d.class), C0178d.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/d;->aK:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0178d.class, Object.class), C0178d.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/d;->aK:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: q */
    public int m1082q() {
        return this.f1373aK;
    }

    /* JADX INFO: renamed from: u */
    public void m1077u() {
        RustCorpsePhysics.removeObject(this.f1373aK);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0025V m1078a(@NotNull C0025V c0025v) {
        if (f1375L) {
            try {
                double[] dArr = f1374a.get();
                RustCorpsePhysics.getPoseInto(this.f1373aK, dArr);
                c0025v.mo157d().set(dArr[0], dArr[1], dArr[2]);
                c0025v.mo156a().set(dArr[3], dArr[4], dArr[5], dArr[6]);
                return c0025v;
            } catch (UnsatisfiedLinkError e) {
                f1375L = false;
                C0530jM.m2337a("[BlockFront] Native getPoseInto unavailable; using allocating getPose fallback. Rebuild corpse_physics natives for best performance.", new Object[0]);
            }
        }
        double[] pose = RustCorpsePhysics.getPose(this.f1373aK);
        c0025v.mo157d().set(pose[0], pose[1], pose[2]);
        c0025v.mo156a().set(pose[3], pose[4], pose[5], pose[6]);
        return c0025v;
    }

    /* JADX INFO: renamed from: b */
    public void m1079b(@NotNull Vector3dc vector3dc, @NotNull Vector3dc vector3dc2) {
        RustCorpsePhysics.addLinearAngularVelocities(this.f1373aK, vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    /* JADX INFO: renamed from: a */
    public void m1080a(double d) {
        RustCorpsePhysics.multiplyVelocities(this.f1373aK, d);
    }

    /* JADX INFO: renamed from: a */
    public void m1081a(@NotNull C0178d c0178d, @NotNull Vector3dc vector3dc, @NotNull Vector3dc vector3dc2, @NotNull Quaterniondc quaterniondc, @NotNull Quaterniondc quaterniondc2, @NotNull Vector3dc vector3dc3, double d) {
        RustCorpsePhysics.addRagdollConstraint(this.f1373aK, c0178d.f1373aK, vector3dc.x(), vector3dc.y(), vector3dc.z(), quaterniondc.x(), quaterniondc.y(), quaterniondc.z(), quaterniondc.w(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), quaterniondc2.x(), quaterniondc2.y(), quaterniondc2.z(), quaterniondc2.w(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), d);
    }
}
