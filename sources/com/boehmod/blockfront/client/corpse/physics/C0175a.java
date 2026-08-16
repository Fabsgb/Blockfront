package com.boehmod.blockfront.client.corpse.physics;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.client.corpse.physics.a */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/a.class */
public final class C0175a extends Record {

    /* JADX INFO: renamed from: aJ */
    private final int f1364aJ;

    public C0175a(int i) {
        this.f1364aJ = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0175a.class), C0175a.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/a;->aJ:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0175a.class), C0175a.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/a;->aJ:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0175a.class, Object.class), C0175a.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/a;->aJ:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: q */
    public int m1066q() {
        return this.f1364aJ;
    }

    /* JADX INFO: renamed from: a */
    public void m1065a(@NotNull Vector3dc vector3dc, @NotNull Vector3dc vector3dc2) {
        RustCorpsePhysics.addBox(this.f1364aJ, new double[]{vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z()});
    }
}
