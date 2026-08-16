package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gx.class */
public final class C0408gx extends Record {

    /* JADX INFO: renamed from: cG */
    @NotNull
    private final ResourceLocation f2648cG;

    /* JADX INFO: renamed from: fy */
    private final float f2649fy;

    /* JADX INFO: renamed from: fz */
    private final float f2650fz;

    /* JADX INFO: renamed from: fA */
    private final float f2651fA;

    /* JADX INFO: renamed from: kr */
    private final int f2652kr;

    /* JADX INFO: renamed from: fB */
    private final float f2653fB;

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final Codec<C0408gx> f2654e = RecordCodecBuilder.create(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter((v0) -> {
            return v0.m1944f();
        }), Codec.FLOAT.optionalFieldOf("yOffset", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.m1945B();
        }), Codec.FLOAT.optionalFieldOf("speedMultiplier", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.m1946C();
        }), Codec.FLOAT.optionalFieldOf("scale", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.m1947f();
        }), C0859pX.f4603G.optionalFieldOf("color", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter((v0) -> {
            return v0.m1948u();
        }), Codec.FLOAT.optionalFieldOf("alpha", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.m1949D();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0408gx(v1, v2, v3, v4, v5, v6);
        });
    });

    public C0408gx(@NotNull ResourceLocation resourceLocation, float f, float f2, float f3, int i, float f4) {
        this.f2648cG = resourceLocation;
        this.f2649fy = f;
        this.f2650fz = f2;
        this.f2651fA = f3;
        this.f2652kr = i;
        this.f2653fB = f4;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0408gx.class), C0408gx.class, "texture;yOffset;speedMultiplier;scale;color;alpha", "FIELD:Lcom/boehmod/blockfront/gx;->cG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/gx;->fy:F", "FIELD:Lcom/boehmod/blockfront/gx;->fz:F", "FIELD:Lcom/boehmod/blockfront/gx;->fA:F", "FIELD:Lcom/boehmod/blockfront/gx;->kr:I", "FIELD:Lcom/boehmod/blockfront/gx;->fB:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0408gx.class), C0408gx.class, "texture;yOffset;speedMultiplier;scale;color;alpha", "FIELD:Lcom/boehmod/blockfront/gx;->cG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/gx;->fy:F", "FIELD:Lcom/boehmod/blockfront/gx;->fz:F", "FIELD:Lcom/boehmod/blockfront/gx;->fA:F", "FIELD:Lcom/boehmod/blockfront/gx;->kr:I", "FIELD:Lcom/boehmod/blockfront/gx;->fB:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0408gx.class, Object.class), C0408gx.class, "texture;yOffset;speedMultiplier;scale;color;alpha", "FIELD:Lcom/boehmod/blockfront/gx;->cG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/gx;->fy:F", "FIELD:Lcom/boehmod/blockfront/gx;->fz:F", "FIELD:Lcom/boehmod/blockfront/gx;->fA:F", "FIELD:Lcom/boehmod/blockfront/gx;->kr:I", "FIELD:Lcom/boehmod/blockfront/gx;->fB:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public ResourceLocation m1944f() {
        return this.f2648cG;
    }

    /* JADX INFO: renamed from: B */
    public float m1945B() {
        return this.f2649fy;
    }

    /* JADX INFO: renamed from: C */
    public float m1946C() {
        return this.f2650fz;
    }

    /* JADX INFO: renamed from: f */
    public float m1947f() {
        return this.f2651fA;
    }

    /* JADX INFO: renamed from: u */
    public int m1948u() {
        return this.f2652kr;
    }

    /* JADX INFO: renamed from: D */
    public float m1949D() {
        return this.f2653fB;
    }
}
