package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gh.class */
public final class C0391gh extends Record {

    /* JADX INFO: renamed from: cG */
    @NotNull
    private final ResourceLocation f2589cG;

    /* JADX INFO: renamed from: fo */
    private final float f2590fo;

    /* JADX INFO: renamed from: fp */
    private final float f2591fp;

    /* JADX INFO: renamed from: fq */
    private final float f2592fq;

    /* JADX INFO: renamed from: iW */
    private final int f2593iW;

    /* JADX INFO: renamed from: fr */
    private final float f2594fr;

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final Codec<C0391gh> f2595e = RecordCodecBuilder.create(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter((v0) -> {
            return v0.m1879f();
        }), Codec.FLOAT.optionalFieldOf("yOffset", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.m1880B();
        }), Codec.FLOAT.optionalFieldOf("speedMultiplier", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.m1881C();
        }), Codec.FLOAT.optionalFieldOf("scale", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.m1882f();
        }), C0836pB.f4474G.optionalFieldOf("color", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter((v0) -> {
            return v0.m1883q();
        }), Codec.FLOAT.optionalFieldOf("alpha", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.m1884D();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0391gh(v1, v2, v3, v4, v5, v6);
        });
    });

    public C0391gh(@NotNull ResourceLocation resourceLocation, float f, float f2, float f3, int i, float f4) {
        this.f2589cG = resourceLocation;
        this.f2590fo = f;
        this.f2591fp = f2;
        this.f2592fq = f3;
        this.f2593iW = i;
        this.f2594fr = f4;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0391gh.class), C0391gh.class, "texture;yOffset;speedMultiplier;scale;color;alpha", "FIELD:Lcom/boehmod/blockfront/gh;->cG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/gh;->fo:F", "FIELD:Lcom/boehmod/blockfront/gh;->fp:F", "FIELD:Lcom/boehmod/blockfront/gh;->fq:F", "FIELD:Lcom/boehmod/blockfront/gh;->iW:I", "FIELD:Lcom/boehmod/blockfront/gh;->fr:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0391gh.class), C0391gh.class, "texture;yOffset;speedMultiplier;scale;color;alpha", "FIELD:Lcom/boehmod/blockfront/gh;->cG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/gh;->fo:F", "FIELD:Lcom/boehmod/blockfront/gh;->fp:F", "FIELD:Lcom/boehmod/blockfront/gh;->fq:F", "FIELD:Lcom/boehmod/blockfront/gh;->iW:I", "FIELD:Lcom/boehmod/blockfront/gh;->fr:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0391gh.class, Object.class), C0391gh.class, "texture;yOffset;speedMultiplier;scale;color;alpha", "FIELD:Lcom/boehmod/blockfront/gh;->cG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/gh;->fo:F", "FIELD:Lcom/boehmod/blockfront/gh;->fp:F", "FIELD:Lcom/boehmod/blockfront/gh;->fq:F", "FIELD:Lcom/boehmod/blockfront/gh;->iW:I", "FIELD:Lcom/boehmod/blockfront/gh;->fr:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public ResourceLocation m1879f() {
        return this.f2589cG;
    }

    /* JADX INFO: renamed from: B */
    public float m1880B() {
        return this.f2590fo;
    }

    /* JADX INFO: renamed from: C */
    public float m1881C() {
        return this.f2591fp;
    }

    /* JADX INFO: renamed from: f */
    public float m1882f() {
        return this.f2592fq;
    }

    /* JADX INFO: renamed from: q */
    public int m1883q() {
        return this.f2593iW;
    }

    /* JADX INFO: renamed from: D */
    public float m1884D() {
        return this.f2594fr;
    }
}
