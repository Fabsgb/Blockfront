package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.C0009G;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.client.corpse.physics.c */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/c.class */
public final class C0176c extends Record {

    /* JADX INFO: renamed from: a */
    private final C0009G f1448a;

    /* JADX INFO: renamed from: a */
    private final Quaterniondc f1449a;

    /* JADX INFO: renamed from: b */
    private final Quaterniondc f1450b;

    /* JADX INFO: renamed from: e */
    private final Vector3dc f1451e;

    /* JADX INFO: renamed from: f */
    private final Vector3dc f1452f;

    /* JADX INFO: renamed from: g */
    private final Vector3dc f1453g;

    public C0176c(C0009G c0009g, Quaterniondc quaterniondc, Quaterniondc quaterniondc2, Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        this.f1448a = c0009g;
        this.f1449a = quaterniondc;
        this.f1450b = quaterniondc2;
        this.f1451e = vector3dc;
        this.f1452f = vector3dc2;
        this.f1453g = vector3dc3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0176c.class), C0176c.class, "other;rotationA;rotationB;pivotA;pivotB;rotationLimits", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lcom/boehmod/blockfront/G;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->b:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->e:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->f:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->g:Lorg/joml/Vector3dc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0176c.class), C0176c.class, "other;rotationA;rotationB;pivotA;pivotB;rotationLimits", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lcom/boehmod/blockfront/G;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->b:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->e:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->f:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->g:Lorg/joml/Vector3dc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0176c.class, Object.class), C0176c.class, "other;rotationA;rotationB;pivotA;pivotB;rotationLimits", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lcom/boehmod/blockfront/G;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->b:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->e:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->f:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->g:Lorg/joml/Vector3dc;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: a */
    public C0009G m1047a() {
        return this.f1448a;
    }

    /* JADX INFO: renamed from: b */
    public Quaterniondc m1048b() {
        return this.f1449a;
    }

    /* JADX INFO: renamed from: c */
    public Quaterniondc m1049c() {
        return this.f1450b;
    }

    /* JADX INFO: renamed from: e */
    public Vector3dc m1050e() {
        return this.f1451e;
    }

    /* JADX INFO: renamed from: f */
    public Vector3dc m1051f() {
        return this.f1452f;
    }

    /* JADX INFO: renamed from: g */
    public Vector3dc m1052g() {
        return this.f1453g;
    }
}
