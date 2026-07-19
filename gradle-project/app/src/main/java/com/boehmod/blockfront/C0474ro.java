package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ro, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ro.class */
public final class C0474ro extends Record {
    private final int pq;

    @NotNull
    private final String cs;

    @NotNull
    private final String ct;

    @NotNull
    private final List<String> bd;

    @NotNull
    private final Map<ResourceLocation, List<C0411pf>> S;

    @NotNull
    private final Optional<ResourceLocation> q;

    @NotNull
    public static final Codec<C0474ro> X = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("id").forGetter((v0) -> {
            return v0.bA();
        }), Codec.STRING.fieldOf("nation").forGetter((v0) -> {
            return v0.af();
        }), Codec.STRING.fieldOf("skin").forGetter((v0) -> {
            return v0.ag();
        }), Codec.STRING.listOf().optionalFieldOf("races", List.of("caucasian")).forGetter((v0) -> {
            return v0.aj();
        }), Codec.unboundedMap(ResourceLocation.CODEC, C0411pf.w.listOf()).optionalFieldOf("loadouts", Map.of()).forGetter((v0) -> {
            return v0.n();
        }), ResourceLocation.CODEC.optionalFieldOf("inheritsFrom").forGetter((v0) -> {
            return v0.m();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0474ro(v1, v2, v3, v4, v5, v6);
        });
    });

    public C0474ro(int i, @NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull Map<ResourceLocation, List<C0411pf>> map, @NotNull Optional<ResourceLocation> optional) {
        this.pq = i;
        this.cs = str;
        this.ct = str2;
        this.bd = list;
        this.S = map;
        this.q = optional;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0474ro.class), C0474ro.class, "id;nation;skin;races;loadouts;inheritsFrom", "FIELD:Lcom/boehmod/blockfront/ro;->pq:I", "FIELD:Lcom/boehmod/blockfront/ro;->cs:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->ct:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->bd:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ro;->S:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/ro;->q:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0474ro.class), C0474ro.class, "id;nation;skin;races;loadouts;inheritsFrom", "FIELD:Lcom/boehmod/blockfront/ro;->pq:I", "FIELD:Lcom/boehmod/blockfront/ro;->cs:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->ct:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->bd:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ro;->S:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/ro;->q:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0474ro.class, Object.class), C0474ro.class, "id;nation;skin;races;loadouts;inheritsFrom", "FIELD:Lcom/boehmod/blockfront/ro;->pq:I", "FIELD:Lcom/boehmod/blockfront/ro;->cs:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->ct:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->bd:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ro;->S:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/ro;->q:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int bA() {
        return this.pq;
    }

    @NotNull
    public String af() {
        return this.cs;
    }

    @NotNull
    public String ag() {
        return this.ct;
    }

    @NotNull
    public List<String> aj() {
        return this.bd;
    }

    @NotNull
    public Map<ResourceLocation, List<C0411pf>> n() {
        return this.S;
    }

    @NotNull
    public Optional<ResourceLocation> m() {
        return this.q;
    }
}
