package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gr.class */
public final class C0402gr extends Record {

    /* JADX INFO: renamed from: fc */
    private final float f2597fc;

    /* JADX INFO: renamed from: fd */
    private final float f2598fd;

    /* JADX INFO: renamed from: fe */
    private final float f2599fe;

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final Codec<C0402gr> f2600d = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("frequency").forGetter((v0) -> {
            return v0.m1908x();
        }), Codec.FLOAT.fieldOf("amplitude").forGetter((v0) -> {
            return v0.m1909y();
        }), Codec.FLOAT.optionalFieldOf("phaseShift", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.m1910z();
        })).apply(instance, (v1, v2, v3) -> {
            return new C0402gr(v1, v2, v3);
        });
    });

    public C0402gr(float f, float f2, float f3) {
        this.f2597fc = f;
        this.f2598fd = f2;
        this.f2599fe = f3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0402gr.class), C0402gr.class, "frequency;amplitude;phaseShift", "FIELD:Lcom/boehmod/blockfront/gr;->fc:F", "FIELD:Lcom/boehmod/blockfront/gr;->fd:F", "FIELD:Lcom/boehmod/blockfront/gr;->fe:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0402gr.class), C0402gr.class, "frequency;amplitude;phaseShift", "FIELD:Lcom/boehmod/blockfront/gr;->fc:F", "FIELD:Lcom/boehmod/blockfront/gr;->fd:F", "FIELD:Lcom/boehmod/blockfront/gr;->fe:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0402gr.class, Object.class), C0402gr.class, "frequency;amplitude;phaseShift", "FIELD:Lcom/boehmod/blockfront/gr;->fc:F", "FIELD:Lcom/boehmod/blockfront/gr;->fd:F", "FIELD:Lcom/boehmod/blockfront/gr;->fe:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: x */
    public float m1908x() {
        return this.f2597fc;
    }

    /* JADX INFO: renamed from: y */
    public float m1909y() {
        return this.f2598fd;
    }

    /* JADX INFO: renamed from: z */
    public float m1910z() {
        return this.f2599fe;
    }
}
