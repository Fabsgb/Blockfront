package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: com.boehmod.blockfront.iy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iy.class */
@OnlyIn(Dist.CLIENT)
public final class C0241iy extends Record {
    private final float gJ;
    private final float gK;
    private final float[] a;
    private final float[] b;
    private final float[] c;
    private final float gL;
    private final float gM;
    private final float[] d;
    private final float gN;
    private final float gO;
    private final float gP;
    private final float gQ;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0241iy.class), C0241iy.class, "tailSeconds;predelaySeconds;earlyDelays;earlyGains;combDelays;combFeedback;combDamp;allpassDelays;allpassGain;dry;wet;peakCeiling", "FIELD:Lcom/boehmod/blockfront/iy;->gJ:F", "FIELD:Lcom/boehmod/blockfront/iy;->gK:F", "FIELD:Lcom/boehmod/blockfront/iy;->a:[F", "FIELD:Lcom/boehmod/blockfront/iy;->b:[F", "FIELD:Lcom/boehmod/blockfront/iy;->c:[F", "FIELD:Lcom/boehmod/blockfront/iy;->gL:F", "FIELD:Lcom/boehmod/blockfront/iy;->gM:F", "FIELD:Lcom/boehmod/blockfront/iy;->d:[F", "FIELD:Lcom/boehmod/blockfront/iy;->gN:F", "FIELD:Lcom/boehmod/blockfront/iy;->gO:F", "FIELD:Lcom/boehmod/blockfront/iy;->gP:F", "FIELD:Lcom/boehmod/blockfront/iy;->gQ:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0241iy.class), C0241iy.class, "tailSeconds;predelaySeconds;earlyDelays;earlyGains;combDelays;combFeedback;combDamp;allpassDelays;allpassGain;dry;wet;peakCeiling", "FIELD:Lcom/boehmod/blockfront/iy;->gJ:F", "FIELD:Lcom/boehmod/blockfront/iy;->gK:F", "FIELD:Lcom/boehmod/blockfront/iy;->a:[F", "FIELD:Lcom/boehmod/blockfront/iy;->b:[F", "FIELD:Lcom/boehmod/blockfront/iy;->c:[F", "FIELD:Lcom/boehmod/blockfront/iy;->gL:F", "FIELD:Lcom/boehmod/blockfront/iy;->gM:F", "FIELD:Lcom/boehmod/blockfront/iy;->d:[F", "FIELD:Lcom/boehmod/blockfront/iy;->gN:F", "FIELD:Lcom/boehmod/blockfront/iy;->gO:F", "FIELD:Lcom/boehmod/blockfront/iy;->gP:F", "FIELD:Lcom/boehmod/blockfront/iy;->gQ:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0241iy.class, Object.class), C0241iy.class, "tailSeconds;predelaySeconds;earlyDelays;earlyGains;combDelays;combFeedback;combDamp;allpassDelays;allpassGain;dry;wet;peakCeiling", "FIELD:Lcom/boehmod/blockfront/iy;->gJ:F", "FIELD:Lcom/boehmod/blockfront/iy;->gK:F", "FIELD:Lcom/boehmod/blockfront/iy;->a:[F", "FIELD:Lcom/boehmod/blockfront/iy;->b:[F", "FIELD:Lcom/boehmod/blockfront/iy;->c:[F", "FIELD:Lcom/boehmod/blockfront/iy;->gL:F", "FIELD:Lcom/boehmod/blockfront/iy;->gM:F", "FIELD:Lcom/boehmod/blockfront/iy;->d:[F", "FIELD:Lcom/boehmod/blockfront/iy;->gN:F", "FIELD:Lcom/boehmod/blockfront/iy;->gO:F", "FIELD:Lcom/boehmod/blockfront/iy;->gP:F", "FIELD:Lcom/boehmod/blockfront/iy;->gQ:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public float Q() {
        return this.gJ;
    }

    public float R() {
        return this.gK;
    }

    public float[] a() {
        return this.a;
    }

    public float[] b() {
        return this.b;
    }

    public float[] c() {
        return this.c;
    }

    public float S() {
        return this.gL;
    }

    public float T() {
        return this.gM;
    }

    public float[] d() {
        return this.d;
    }

    public float U() {
        return this.gN;
    }

    public float V() {
        return this.gO;
    }

    public float W() {
        return this.gP;
    }

    public float X() {
        return this.gQ;
    }

    public C0241iy(float f, float f2, float[] fArr, float[] fArr2, float[] fArr3, float f3, float f4, float[] fArr4, float f5, float f6, float f7, float f8) {
        this.gJ = f;
        this.gK = f2;
        this.a = fArr;
        this.b = fArr2;
        this.c = fArr3;
        this.gL = f3;
        this.gM = f4;
        this.d = fArr4;
        this.gN = f5;
        this.gO = f6;
        this.gP = f7;
        this.gQ = f8;
    }
}
