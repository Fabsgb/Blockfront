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

/* JADX INFO: renamed from: com.boehmod.blockfront.ro */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ro.class */
public final class C0981ro extends Record {

    /* JADX INFO: renamed from: pq */
    private final int f5208pq;

    /* JADX INFO: renamed from: cs */
    @NotNull
    private final String f5209cs;

    /* JADX INFO: renamed from: ct */
    @NotNull
    private final String f5210ct;

    /* JADX INFO: renamed from: bd */
    @NotNull
    private final List<String> f5211bd;

    /* JADX INFO: renamed from: S */
    @NotNull
    private final Map<ResourceLocation, List<C0866pf>> f5212S;

    /* JADX INFO: renamed from: q */
    @NotNull
    private final Optional<ResourceLocation> f5213q;

    /* JADX INFO: renamed from: X */
    @NotNull
    public static final Codec<C0981ro> f5214X = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("id").forGetter((v0) -> {
            return v0.m5409bA();
        }), Codec.STRING.fieldOf("nation").forGetter((v0) -> {
            return v0.m5410af();
        }), Codec.STRING.fieldOf("skin").forGetter((v0) -> {
            return v0.m5411ag();
        }), Codec.STRING.listOf().optionalFieldOf("races", List.of("caucasian")).forGetter((v0) -> {
            return v0.m5412aj();
        }), Codec.unboundedMap(ResourceLocation.CODEC, C0866pf.f4539w.listOf()).optionalFieldOf("loadouts", Map.of()).forGetter((v0) -> {
            return v0.m5413n();
        }), ResourceLocation.CODEC.optionalFieldOf("inheritsFrom").forGetter((v0) -> {
            return v0.m5414m();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0981ro(v1, v2, v3, v4, v5, v6);
        });
    });

    public C0981ro(int i, @NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull Map<ResourceLocation, List<C0866pf>> map, @NotNull Optional<ResourceLocation> optional) {
        this.f5208pq = i;
        this.f5209cs = str;
        this.f5210ct = str2;
        this.f5211bd = list;
        this.f5212S = map;
        this.f5213q = optional;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0981ro.class), C0981ro.class, "id;nation;skin;races;loadouts;inheritsFrom", "FIELD:Lcom/boehmod/blockfront/ro;->pq:I", "FIELD:Lcom/boehmod/blockfront/ro;->cs:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->ct:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->bd:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ro;->S:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/ro;->q:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0981ro.class), C0981ro.class, "id;nation;skin;races;loadouts;inheritsFrom", "FIELD:Lcom/boehmod/blockfront/ro;->pq:I", "FIELD:Lcom/boehmod/blockfront/ro;->cs:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->ct:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->bd:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ro;->S:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/ro;->q:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0981ro.class, Object.class), C0981ro.class, "id;nation;skin;races;loadouts;inheritsFrom", "FIELD:Lcom/boehmod/blockfront/ro;->pq:I", "FIELD:Lcom/boehmod/blockfront/ro;->cs:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->ct:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ro;->bd:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ro;->S:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/ro;->q:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bA */
    public int m5409bA() {
        return this.f5208pq;
    }

    @NotNull
    /* JADX INFO: renamed from: af */
    public String m5410af() {
        return this.f5209cs;
    }

    @NotNull
    /* JADX INFO: renamed from: ag */
    public String m5411ag() {
        return this.f5210ct;
    }

    @NotNull
    /* JADX INFO: renamed from: aj */
    public List<String> m5412aj() {
        return this.f5211bd;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public Map<ResourceLocation, List<C0866pf>> m5413n() {
        return this.f5212S;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public Optional<ResourceLocation> m5414m() {
        return this.f5213q;
    }
}
