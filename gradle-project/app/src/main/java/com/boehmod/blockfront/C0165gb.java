package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gb.class */
public final class C0165gb extends Record {
    private final float eW;
    private final float eX;
    private final float eY;

    @NotNull
    public static final Codec<C0165gb> d = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("frequency").forGetter((v0) -> {
            return v0.x();
        }), Codec.FLOAT.fieldOf("amplitude").forGetter((v0) -> {
            return v0.y();
        }), Codec.FLOAT.optionalFieldOf("phaseShift", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.z();
        })).apply(instance, (v1, v2, v3) -> {
            return new C0165gb(v1, v2, v3);
        });
    });

    public C0165gb(float f, float f2, float f3) {
        this.eW = f;
        this.eX = f2;
        this.eY = f3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0165gb.class), C0165gb.class, "frequency;amplitude;phaseShift", "FIELD:Lcom/boehmod/blockfront/gb;->eW:F", "FIELD:Lcom/boehmod/blockfront/gb;->eX:F", "FIELD:Lcom/boehmod/blockfront/gb;->eY:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0165gb.class), C0165gb.class, "frequency;amplitude;phaseShift", "FIELD:Lcom/boehmod/blockfront/gb;->eW:F", "FIELD:Lcom/boehmod/blockfront/gb;->eX:F", "FIELD:Lcom/boehmod/blockfront/gb;->eY:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0165gb.class, Object.class), C0165gb.class, "frequency;amplitude;phaseShift", "FIELD:Lcom/boehmod/blockfront/gb;->eW:F", "FIELD:Lcom/boehmod/blockfront/gb;->eX:F", "FIELD:Lcom/boehmod/blockfront/gb;->eY:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public float x() {
        return this.eW;
    }

    public float y() {
        return this.eX;
    }

    public float z() {
        return this.eY;
    }
}
