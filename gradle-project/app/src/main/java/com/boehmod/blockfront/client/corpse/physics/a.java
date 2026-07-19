package com.boehmod.blockfront.client.corpse.physics;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/a.class */
public final class a extends Record {
    private final int V;

    public a(int i) {
        this.V = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/a;->V:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/a;->V:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "handle", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/a;->V:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int m() {
        return this.V;
    }

    public void a(@NotNull Vector3dc vector3dc, @NotNull Vector3dc vector3dc2) {
        RustCorpsePhysics.addBox(this.V, new double[]{vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z()});
    }
}
