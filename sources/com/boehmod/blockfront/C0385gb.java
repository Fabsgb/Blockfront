package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gb.class */
public final class C0385gb extends Record {

    /* JADX INFO: renamed from: eW */
    private final float f2542eW;

    /* JADX INFO: renamed from: eX */
    private final float f2543eX;

    /* JADX INFO: renamed from: eY */
    private final float f2544eY;

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final Codec<C0385gb> f2545d = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("frequency").forGetter((v0) -> {
            return v0.m1844x();
        }), Codec.FLOAT.fieldOf("amplitude").forGetter((v0) -> {
            return v0.m1845y();
        }), Codec.FLOAT.optionalFieldOf("phaseShift", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.m1846z();
        })).apply(instance, (v1, v2, v3) -> {
            return new C0385gb(v1, v2, v3);
        });
    });

    public C0385gb(float f, float f2, float f3) {
        this.f2542eW = f;
        this.f2543eX = f2;
        this.f2544eY = f3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0385gb.class), C0385gb.class, "frequency;amplitude;phaseShift", "FIELD:Lcom/boehmod/blockfront/gb;->eW:F", "FIELD:Lcom/boehmod/blockfront/gb;->eX:F", "FIELD:Lcom/boehmod/blockfront/gb;->eY:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0385gb.class), C0385gb.class, "frequency;amplitude;phaseShift", "FIELD:Lcom/boehmod/blockfront/gb;->eW:F", "FIELD:Lcom/boehmod/blockfront/gb;->eX:F", "FIELD:Lcom/boehmod/blockfront/gb;->eY:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0385gb.class, Object.class), C0385gb.class, "frequency;amplitude;phaseShift", "FIELD:Lcom/boehmod/blockfront/gb;->eW:F", "FIELD:Lcom/boehmod/blockfront/gb;->eX:F", "FIELD:Lcom/boehmod/blockfront/gb;->eY:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: x */
    public float m1844x() {
        return this.f2542eW;
    }

    /* JADX INFO: renamed from: y */
    public float m1845y() {
        return this.f2543eX;
    }

    /* JADX INFO: renamed from: z */
    public float m1846z() {
        return this.f2544eY;
    }
}
