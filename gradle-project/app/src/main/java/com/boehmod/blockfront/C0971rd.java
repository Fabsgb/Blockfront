package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.rd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rd.class */
public final class C0971rd extends Record {

    /* JADX INFO: renamed from: aM */
    @NotNull
    private final List<EnumC0845pJ> f5435aM;

    /* JADX INFO: renamed from: e */
    @Nullable
    private final C0399go f5436e;

    /* JADX INFO: renamed from: f */
    @Nullable
    private final C0399go f5437f;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final C0409gy f5438a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final Float f5439a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private final Float f5440b;

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final C0971rd f5441b = new C0971rd(List.of(), null, null, null, null, null);

    /* JADX INFO: renamed from: M */
    @NotNull
    public static final Codec<C0971rd> f5442M = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.list(EnumC0845pJ.CODEC).optionalFieldOf("weatherType", List.of()).forGetter((v0) -> {
            return v0.m5503P();
        }), C0399go.f2586c.optionalFieldOf("interiorHeightmap").forGetter(c0971rd -> {
            return Optional.ofNullable(c0971rd.f5436e);
        }), C0399go.f2586c.optionalFieldOf("exteriorHeightmap").forGetter(c0971rd2 -> {
            return Optional.ofNullable(c0971rd2.f5437f);
        }), C0409gy.f2656f.optionalFieldOf("clouds").forGetter(c0971rd3 -> {
            return Optional.ofNullable(c0971rd3.f5438a);
        }), Codec.FLOAT.optionalFieldOf("darkness").forGetter(c0971rd4 -> {
            return Optional.ofNullable(c0971rd4.f5439a);
        }), Codec.FLOAT.optionalFieldOf("botViewDistance").forGetter(c0971rd5 -> {
            return Optional.ofNullable(c0971rd5.f5440b);
        })).apply(instance, (list, optional, optional2, optional3, optional4, optional5) -> {
            return new C0971rd(list, (C0399go) optional.orElse(null), (C0399go) optional2.orElse(null), (C0409gy) optional3.orElse(null), (Float) optional4.orElse(null), (Float) optional5.orElse(null));
        });
    });

    public C0971rd(@NotNull List<EnumC0845pJ> list, @Nullable C0399go c0399go, @Nullable C0399go c0399go2, @Nullable C0409gy c0409gy, @Nullable Float f, @Nullable Float f2) {
        this.f5435aM = list;
        this.f5436e = c0399go;
        this.f5437f = c0399go2;
        this.f5438a = c0409gy;
        this.f5439a = f;
        this.f5440b = f2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0971rd.class), C0971rd.class, "weatherTypes;interiorHeightmap;exteriorHeightmap;cloudsConfig;darkness;botViewDistance", "FIELD:Lcom/boehmod/blockfront/rd;->aM:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rd;->e:Lcom/boehmod/blockfront/go;", "FIELD:Lcom/boehmod/blockfront/rd;->f:Lcom/boehmod/blockfront/go;", "FIELD:Lcom/boehmod/blockfront/rd;->a:Lcom/boehmod/blockfront/gy;", "FIELD:Lcom/boehmod/blockfront/rd;->a:Ljava/lang/Float;", "FIELD:Lcom/boehmod/blockfront/rd;->b:Ljava/lang/Float;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0971rd.class), C0971rd.class, "weatherTypes;interiorHeightmap;exteriorHeightmap;cloudsConfig;darkness;botViewDistance", "FIELD:Lcom/boehmod/blockfront/rd;->aM:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rd;->e:Lcom/boehmod/blockfront/go;", "FIELD:Lcom/boehmod/blockfront/rd;->f:Lcom/boehmod/blockfront/go;", "FIELD:Lcom/boehmod/blockfront/rd;->a:Lcom/boehmod/blockfront/gy;", "FIELD:Lcom/boehmod/blockfront/rd;->a:Ljava/lang/Float;", "FIELD:Lcom/boehmod/blockfront/rd;->b:Ljava/lang/Float;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0971rd.class, Object.class), C0971rd.class, "weatherTypes;interiorHeightmap;exteriorHeightmap;cloudsConfig;darkness;botViewDistance", "FIELD:Lcom/boehmod/blockfront/rd;->aM:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rd;->e:Lcom/boehmod/blockfront/go;", "FIELD:Lcom/boehmod/blockfront/rd;->f:Lcom/boehmod/blockfront/go;", "FIELD:Lcom/boehmod/blockfront/rd;->a:Lcom/boehmod/blockfront/gy;", "FIELD:Lcom/boehmod/blockfront/rd;->a:Ljava/lang/Float;", "FIELD:Lcom/boehmod/blockfront/rd;->b:Ljava/lang/Float;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: P */
    public List<EnumC0845pJ> m5503P() {
        return this.f5435aM;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0399go m5504a() {
        return this.f5436e;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C0399go m5505b() {
        return this.f5437f;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0409gy m5506a() {
        return this.f5438a;
    }

    @Nullable
    /* JADX INFO: renamed from: D */
    public Float m5507D() {
        return this.f5439a;
    }

    @Nullable
    /* JADX INFO: renamed from: E */
    public Float m5508E() {
        return this.f5440b;
    }
}
