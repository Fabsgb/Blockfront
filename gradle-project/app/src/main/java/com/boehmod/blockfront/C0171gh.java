package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gh.class */
public final class C0171gh extends Record {

    @NotNull
    private final ResourceLocation cG;
    private final float fo;
    private final float fp;
    private final float fq;
    private final int iW;
    private final float fr;

    @NotNull
    public static final Codec<C0171gh> e = RecordCodecBuilder.create(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter((v0) -> {
            return v0.f();
        }), Codec.FLOAT.optionalFieldOf("yOffset", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.B();
        }), Codec.FLOAT.optionalFieldOf("speedMultiplier", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.C();
        }), Codec.FLOAT.optionalFieldOf("scale", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.m439f();
        }), pB.G.optionalFieldOf("color", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter((v0) -> {
            return v0.q();
        }), Codec.FLOAT.optionalFieldOf("alpha", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.D();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0171gh(v1, v2, v3, v4, v5, v6);
        });
    });

    public C0171gh(@NotNull ResourceLocation resourceLocation, float f, float f2, float f3, int i, float f4) {
        this.cG = resourceLocation;
        this.fo = f;
        this.fp = f2;
        this.fq = f3;
        this.iW = i;
        this.fr = f4;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0171gh.class), C0171gh.class, "texture;yOffset;speedMultiplier;scale;color;alpha", "FIELD:Lcom/boehmod/blockfront/gh;->cG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/gh;->fo:F", "FIELD:Lcom/boehmod/blockfront/gh;->fp:F", "FIELD:Lcom/boehmod/blockfront/gh;->fq:F", "FIELD:Lcom/boehmod/blockfront/gh;->iW:I", "FIELD:Lcom/boehmod/blockfront/gh;->fr:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0171gh.class), C0171gh.class, "texture;yOffset;speedMultiplier;scale;color;alpha", "FIELD:Lcom/boehmod/blockfront/gh;->cG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/gh;->fo:F", "FIELD:Lcom/boehmod/blockfront/gh;->fp:F", "FIELD:Lcom/boehmod/blockfront/gh;->fq:F", "FIELD:Lcom/boehmod/blockfront/gh;->iW:I", "FIELD:Lcom/boehmod/blockfront/gh;->fr:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0171gh.class, Object.class), C0171gh.class, "texture;yOffset;speedMultiplier;scale;color;alpha", "FIELD:Lcom/boehmod/blockfront/gh;->cG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/gh;->fo:F", "FIELD:Lcom/boehmod/blockfront/gh;->fp:F", "FIELD:Lcom/boehmod/blockfront/gh;->fq:F", "FIELD:Lcom/boehmod/blockfront/gh;->iW:I", "FIELD:Lcom/boehmod/blockfront/gh;->fr:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public ResourceLocation f() {
        return this.cG;
    }

    public float B() {
        return this.fo;
    }

    public float C() {
        return this.fp;
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public float m439f() {
        return this.fq;
    }

    public int q() {
        return this.iW;
    }

    public float D() {
        return this.fr;
    }
}
