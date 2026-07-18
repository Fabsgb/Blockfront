package com.boehmod.blockfront.client.corpse.physics;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.client.corpse.physics.a */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/a.class */
public final class C0174a extends Record {

    /* JADX INFO: renamed from: V */
    private final int f1445V;

    public C0174a(int i) {
        this.f1445V = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0174a.class), C0174a.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/a;->V:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0174a.class), C0174a.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/a;->V:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0174a.class, Object.class), C0174a.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/a;->V:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: m */
    public int m1042m() {
        return this.f1445V;
    }

    /* JADX INFO: renamed from: a */
    public void m1041a(@NotNull Vector3dc vector3dc, @NotNull Vector3dc vector3dc2) {
        RustCorpsePhysics.addBox(this.f1445V, new double[]{vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z()});
    }
}
