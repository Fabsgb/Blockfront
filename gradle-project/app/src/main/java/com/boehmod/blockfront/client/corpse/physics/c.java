package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.G;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/c.class */
public final class c extends Record {
    private final G a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Quaterniondc f102a;
    private final Quaterniondc b;
    private final Vector3dc e;
    private final Vector3dc f;
    private final Vector3dc g;

    public c(G g, Quaterniondc quaterniondc, Quaterniondc quaterniondc2, Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        this.a = g;
        this.f102a = quaterniondc;
        this.b = quaterniondc2;
        this.e = vector3dc;
        this.f = vector3dc2;
        this.g = vector3dc3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "other;rotationA;rotationB;pivotA;pivotB;rotationLimits", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lcom/boehmod/blockfront/G;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->b:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->e:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->f:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->g:Lorg/joml/Vector3dc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "other;rotationA;rotationB;pivotA;pivotB;rotationLimits", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lcom/boehmod/blockfront/G;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->b:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->e:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->f:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->g:Lorg/joml/Vector3dc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "other;rotationA;rotationB;pivotA;pivotB;rotationLimits", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lcom/boehmod/blockfront/G;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->b:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->e:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->f:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->g:Lorg/joml/Vector3dc;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public G a() {
        return this.a;
    }

    public Quaterniondc b() {
        return this.f102a;
    }

    public Quaterniondc c() {
        return this.b;
    }

    public Vector3dc e() {
        return this.e;
    }

    public Vector3dc f() {
        return this.f;
    }

    public Vector3dc g() {
        return this.g;
    }
}
