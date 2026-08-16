package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.C0016M;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.client.corpse.physics.c */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/c.class */
public final class C0177c extends Record {

    /* JADX INFO: renamed from: a */
    private final C0016M f1367a;

    /* JADX INFO: renamed from: a */
    private final Quaterniondc f1368a;

    /* JADX INFO: renamed from: b */
    private final Quaterniondc f1369b;

    /* JADX INFO: renamed from: e */
    private final Vector3dc f1370e;

    /* JADX INFO: renamed from: f */
    private final Vector3dc f1371f;

    /* JADX INFO: renamed from: g */
    private final Vector3dc f1372g;

    public C0177c(C0016M c0016m, Quaterniondc quaterniondc, Quaterniondc quaterniondc2, Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        this.f1367a = c0016m;
        this.f1368a = quaterniondc;
        this.f1369b = quaterniondc2;
        this.f1370e = vector3dc;
        this.f1371f = vector3dc2;
        this.f1372g = vector3dc3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0177c.class), C0177c.class, "other;rotationA;rotationB;pivotA;pivotB;rotationLimits", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lcom/boehmod/blockfront/M;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->b:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->e:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->f:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->g:Lorg/joml/Vector3dc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0177c.class), C0177c.class, "other;rotationA;rotationB;pivotA;pivotB;rotationLimits", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lcom/boehmod/blockfront/M;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->b:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->e:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->f:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->g:Lorg/joml/Vector3dc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0177c.class, Object.class), C0177c.class, "other;rotationA;rotationB;pivotA;pivotB;rotationLimits", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lcom/boehmod/blockfront/M;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->a:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->b:Lorg/joml/Quaterniondc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->e:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->f:Lorg/joml/Vector3dc;", "FIELD:Lcom/boehmod/blockfront/client/corpse/physics/c;->g:Lorg/joml/Vector3dc;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: a */
    public C0016M m1071a() {
        return this.f1367a;
    }

    /* JADX INFO: renamed from: b */
    public Quaterniondc m1072b() {
        return this.f1368a;
    }

    /* JADX INFO: renamed from: c */
    public Quaterniondc m1073c() {
        return this.f1369b;
    }

    /* JADX INFO: renamed from: e */
    public Vector3dc m1074e() {
        return this.f1370e;
    }

    /* JADX INFO: renamed from: f */
    public Vector3dc m1075f() {
        return this.f1371f;
    }

    /* JADX INFO: renamed from: g */
    public Vector3dc m1076g() {
        return this.f1372g;
    }
}
