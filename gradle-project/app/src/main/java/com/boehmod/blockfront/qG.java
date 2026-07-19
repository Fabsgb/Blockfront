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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qG.class */
public final class qG extends Record {

    @NotNull
    private final List<EnumC0419pn> aF;

    @Nullable
    private final fY e;

    @Nullable
    private final fY f;

    @Nullable
    private final C0172gi a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private final Float f287a;

    @Nullable
    private final Float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    public static final qG f288b = new qG(List.of(), null, null, null, null, null);

    @NotNull
    public static final Codec<qG> M = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.list(EnumC0419pn.CODEC).optionalFieldOf("weatherType", List.of()).forGetter((v0) -> {
            return v0.N();
        }), fY.c.optionalFieldOf("interiorHeightmap").forGetter(qGVar -> {
            return Optional.ofNullable(qGVar.e);
        }), fY.c.optionalFieldOf("exteriorHeightmap").forGetter(qGVar2 -> {
            return Optional.ofNullable(qGVar2.f);
        }), C0172gi.f.optionalFieldOf("clouds").forGetter(qGVar3 -> {
            return Optional.ofNullable(qGVar3.a);
        }), Codec.FLOAT.optionalFieldOf("darkness").forGetter(qGVar4 -> {
            return Optional.ofNullable(qGVar4.f287a);
        }), Codec.FLOAT.optionalFieldOf("botViewDistance").forGetter(qGVar5 -> {
            return Optional.ofNullable(qGVar5.b);
        })).apply(instance, (list, optional, optional2, optional3, optional4, optional5) -> {
            return new qG(list, (fY) optional.orElse(null), (fY) optional2.orElse(null), (C0172gi) optional3.orElse(null), (Float) optional4.orElse(null), (Float) optional5.orElse(null));
        });
    });

    public qG(@NotNull List<EnumC0419pn> list, @Nullable fY fYVar, @Nullable fY fYVar2, @Nullable C0172gi c0172gi, @Nullable Float f, @Nullable Float f2) {
        this.aF = list;
        this.e = fYVar;
        this.f = fYVar2;
        this.a = c0172gi;
        this.f287a = f;
        this.b = f2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, qG.class), qG.class, "weatherTypes;interiorHeightmap;exteriorHeightmap;cloudsConfig;darkness;botViewDistance", "FIELD:Lcom/boehmod/blockfront/qG;->aF:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/qG;->e:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->f:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Lcom/boehmod/blockfront/gi;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Ljava/lang/Float;", "FIELD:Lcom/boehmod/blockfront/qG;->b:Ljava/lang/Float;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, qG.class), qG.class, "weatherTypes;interiorHeightmap;exteriorHeightmap;cloudsConfig;darkness;botViewDistance", "FIELD:Lcom/boehmod/blockfront/qG;->aF:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/qG;->e:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->f:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Lcom/boehmod/blockfront/gi;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Ljava/lang/Float;", "FIELD:Lcom/boehmod/blockfront/qG;->b:Ljava/lang/Float;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, qG.class, Object.class), qG.class, "weatherTypes;interiorHeightmap;exteriorHeightmap;cloudsConfig;darkness;botViewDistance", "FIELD:Lcom/boehmod/blockfront/qG;->aF:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/qG;->e:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->f:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Lcom/boehmod/blockfront/gi;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Ljava/lang/Float;", "FIELD:Lcom/boehmod/blockfront/qG;->b:Ljava/lang/Float;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public List<EnumC0419pn> N() {
        return this.aF;
    }

    @Nullable
    public fY a() {
        return this.e;
    }

    @Nullable
    public fY b() {
        return this.f;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0172gi m917a() {
        return this.a;
    }

    @Nullable
    public Float w() {
        return this.f287a;
    }

    @Nullable
    public Float x() {
        return this.b;
    }
}
