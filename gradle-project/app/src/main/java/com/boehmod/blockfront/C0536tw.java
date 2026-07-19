package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: renamed from: com.boehmod.blockfront.tw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tw.class */
public final class C0536tw extends Record {
    private final float lZ;
    private final float ma;
    private final float mb;
    private final float mc;
    private final float md;
    private final float me;
    private final float mf;
    private final float mg;
    private final float mh;
    public static final float mi = 0.5f;
    public static final float mj = 0.5f;

    public C0536tw(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.lZ = f;
        this.ma = f2;
        this.mb = f3;
        this.mc = f4;
        this.md = f5;
        this.me = f6;
        this.mf = f7;
        this.mg = f8;
        this.mh = f9;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0536tw.class), C0536tw.class, "maxModelDistance;maxModelPitch;maxCameraPitch;recoverSpeed;idleAmount;walkingAmount;sprintingAmount;crawlingAmount;jumpingAmount", "FIELD:Lcom/boehmod/blockfront/tw;->lZ:F", "FIELD:Lcom/boehmod/blockfront/tw;->ma:F", "FIELD:Lcom/boehmod/blockfront/tw;->mb:F", "FIELD:Lcom/boehmod/blockfront/tw;->mc:F", "FIELD:Lcom/boehmod/blockfront/tw;->md:F", "FIELD:Lcom/boehmod/blockfront/tw;->me:F", "FIELD:Lcom/boehmod/blockfront/tw;->mf:F", "FIELD:Lcom/boehmod/blockfront/tw;->mg:F", "FIELD:Lcom/boehmod/blockfront/tw;->mh:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0536tw.class), C0536tw.class, "maxModelDistance;maxModelPitch;maxCameraPitch;recoverSpeed;idleAmount;walkingAmount;sprintingAmount;crawlingAmount;jumpingAmount", "FIELD:Lcom/boehmod/blockfront/tw;->lZ:F", "FIELD:Lcom/boehmod/blockfront/tw;->ma:F", "FIELD:Lcom/boehmod/blockfront/tw;->mb:F", "FIELD:Lcom/boehmod/blockfront/tw;->mc:F", "FIELD:Lcom/boehmod/blockfront/tw;->md:F", "FIELD:Lcom/boehmod/blockfront/tw;->me:F", "FIELD:Lcom/boehmod/blockfront/tw;->mf:F", "FIELD:Lcom/boehmod/blockfront/tw;->mg:F", "FIELD:Lcom/boehmod/blockfront/tw;->mh:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0536tw.class, Object.class), C0536tw.class, "maxModelDistance;maxModelPitch;maxCameraPitch;recoverSpeed;idleAmount;walkingAmount;sprintingAmount;crawlingAmount;jumpingAmount", "FIELD:Lcom/boehmod/blockfront/tw;->lZ:F", "FIELD:Lcom/boehmod/blockfront/tw;->ma:F", "FIELD:Lcom/boehmod/blockfront/tw;->mb:F", "FIELD:Lcom/boehmod/blockfront/tw;->mc:F", "FIELD:Lcom/boehmod/blockfront/tw;->md:F", "FIELD:Lcom/boehmod/blockfront/tw;->me:F", "FIELD:Lcom/boehmod/blockfront/tw;->mf:F", "FIELD:Lcom/boehmod/blockfront/tw;->mg:F", "FIELD:Lcom/boehmod/blockfront/tw;->mh:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public float bc() {
        return this.lZ;
    }

    public float bd() {
        return this.ma;
    }

    public float be() {
        return this.mb;
    }

    public float bf() {
        return this.mc;
    }

    public float bg() {
        return this.md;
    }

    public float bh() {
        return this.me;
    }

    public float bi() {
        return this.mf;
    }

    public float bj() {
        return this.mg;
    }

    public float bk() {
        return this.mh;
    }
}
