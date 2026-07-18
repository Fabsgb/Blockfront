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

/* JADX INFO: renamed from: com.boehmod.blockfront.qG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qG.class */
public final class C0894qG extends Record {

    /* JADX INFO: renamed from: aF */
    @NotNull
    private final List<EnumC0874pn> f4705aF;

    /* JADX INFO: renamed from: e */
    @Nullable
    private final C0329fY f4706e;

    /* JADX INFO: renamed from: f */
    @Nullable
    private final C0329fY f4707f;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final C0392gi f4708a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final Float f4709a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private final Float f4710b;

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final C0894qG f4711b = new C0894qG(List.of(), null, null, null, null, null);

    /* JADX INFO: renamed from: M */
    @NotNull
    public static final Codec<C0894qG> f4712M = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.list(EnumC0874pn.CODEC).optionalFieldOf("weatherType", List.of()).forGetter((v0) -> {
            return v0.m4608N();
        }), C0329fY.f2391c.optionalFieldOf("interiorHeightmap").forGetter(c0894qG -> {
            return Optional.ofNullable(c0894qG.f4706e);
        }), C0329fY.f2391c.optionalFieldOf("exteriorHeightmap").forGetter(c0894qG2 -> {
            return Optional.ofNullable(c0894qG2.f4707f);
        }), C0392gi.f2597f.optionalFieldOf("clouds").forGetter(c0894qG3 -> {
            return Optional.ofNullable(c0894qG3.f4708a);
        }), Codec.FLOAT.optionalFieldOf("darkness").forGetter(c0894qG4 -> {
            return Optional.ofNullable(c0894qG4.f4709a);
        }), Codec.FLOAT.optionalFieldOf("botViewDistance").forGetter(c0894qG5 -> {
            return Optional.ofNullable(c0894qG5.f4710b);
        })).apply(instance, (list, optional, optional2, optional3, optional4, optional5) -> {
            return new C0894qG(list, (C0329fY) optional.orElse(null), (C0329fY) optional2.orElse(null), (C0392gi) optional3.orElse(null), (Float) optional4.orElse(null), (Float) optional5.orElse(null));
        });
    });

    public C0894qG(@NotNull List<EnumC0874pn> list, @Nullable C0329fY c0329fY, @Nullable C0329fY c0329fY2, @Nullable C0392gi c0392gi, @Nullable Float f, @Nullable Float f2) {
        this.f4705aF = list;
        this.f4706e = c0329fY;
        this.f4707f = c0329fY2;
        this.f4708a = c0392gi;
        this.f4709a = f;
        this.f4710b = f2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0894qG.class), C0894qG.class, "weatherTypes;interiorHeightmap;exteriorHeightmap;cloudsConfig;darkness;botViewDistance", "FIELD:Lcom/boehmod/blockfront/qG;->aF:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/qG;->e:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->f:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Lcom/boehmod/blockfront/gi;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Ljava/lang/Float;", "FIELD:Lcom/boehmod/blockfront/qG;->b:Ljava/lang/Float;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0894qG.class), C0894qG.class, "weatherTypes;interiorHeightmap;exteriorHeightmap;cloudsConfig;darkness;botViewDistance", "FIELD:Lcom/boehmod/blockfront/qG;->aF:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/qG;->e:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->f:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Lcom/boehmod/blockfront/gi;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Ljava/lang/Float;", "FIELD:Lcom/boehmod/blockfront/qG;->b:Ljava/lang/Float;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0894qG.class, Object.class), C0894qG.class, "weatherTypes;interiorHeightmap;exteriorHeightmap;cloudsConfig;darkness;botViewDistance", "FIELD:Lcom/boehmod/blockfront/qG;->aF:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/qG;->e:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->f:Lcom/boehmod/blockfront/fY;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Lcom/boehmod/blockfront/gi;", "FIELD:Lcom/boehmod/blockfront/qG;->a:Ljava/lang/Float;", "FIELD:Lcom/boehmod/blockfront/qG;->b:Ljava/lang/Float;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: N */
    public List<EnumC0874pn> m4608N() {
        return this.f4705aF;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0329fY m4609a() {
        return this.f4706e;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C0329fY m4610b() {
        return this.f4707f;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0392gi m4611a() {
        return this.f4708a;
    }

    @Nullable
    /* JADX INFO: renamed from: w */
    public Float m4612w() {
        return this.f4709a;
    }

    @Nullable
    /* JADX INFO: renamed from: x */
    public Float m4613x() {
        return this.f4710b;
    }
}
