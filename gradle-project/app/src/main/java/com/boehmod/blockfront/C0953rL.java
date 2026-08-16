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

/* JADX INFO: renamed from: com.boehmod.blockfront.rL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rL.class */
public final class C0953rL extends Record {

    /* JADX INFO: renamed from: rp */
    private final int f5312rp;

    /* JADX INFO: renamed from: cC */
    @NotNull
    private final String f5313cC;

    /* JADX INFO: renamed from: cD */
    @NotNull
    private final String f5314cD;

    /* JADX INFO: renamed from: bk */
    @NotNull
    private final List<String> f5315bk;

    /* JADX INFO: renamed from: S */
    @NotNull
    private final Map<ResourceLocation, List<C0837pB>> f5316S;

    /* JADX INFO: renamed from: q */
    @NotNull
    private final Optional<ResourceLocation> f5317q;

    /* JADX INFO: renamed from: X */
    @NotNull
    public static final Codec<C0953rL> f5318X = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("id").forGetter((v0) -> {
            return v0.m5285bP();
        }), Codec.STRING.fieldOf("nation").forGetter((v0) -> {
            return v0.m5286am();
        }), Codec.STRING.fieldOf("skin").forGetter((v0) -> {
            return v0.m5287an();
        }), Codec.STRING.listOf().optionalFieldOf("races", List.of("caucasian")).forGetter((v0) -> {
            return v0.m5288al();
        }), Codec.unboundedMap(ResourceLocation.CODEC, C0837pB.f4508w.listOf()).optionalFieldOf("loadouts", Map.of()).forGetter((v0) -> {
            return v0.m5289n();
        }), ResourceLocation.CODEC.optionalFieldOf("inheritsFrom").forGetter((v0) -> {
            return v0.m5290m();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0953rL(v1, v2, v3, v4, v5, v6);
        });
    });

    public C0953rL(int i, @NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull Map<ResourceLocation, List<C0837pB>> map, @NotNull Optional<ResourceLocation> optional) {
        this.f5312rp = i;
        this.f5313cC = str;
        this.f5314cD = str2;
        this.f5315bk = list;
        this.f5316S = map;
        this.f5317q = optional;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0953rL.class), C0953rL.class, "id;nation;skin;races;loadouts;inheritsFrom", "FIELD:Lcom/boehmod/blockfront/rL;->rp:I", "FIELD:Lcom/boehmod/blockfront/rL;->cC:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rL;->cD:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rL;->bk:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rL;->S:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rL;->q:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0953rL.class), C0953rL.class, "id;nation;skin;races;loadouts;inheritsFrom", "FIELD:Lcom/boehmod/blockfront/rL;->rp:I", "FIELD:Lcom/boehmod/blockfront/rL;->cC:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rL;->cD:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rL;->bk:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rL;->S:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rL;->q:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0953rL.class, Object.class), C0953rL.class, "id;nation;skin;races;loadouts;inheritsFrom", "FIELD:Lcom/boehmod/blockfront/rL;->rp:I", "FIELD:Lcom/boehmod/blockfront/rL;->cC:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rL;->cD:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rL;->bk:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rL;->S:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rL;->q:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bP */
    public int m5285bP() {
        return this.f5312rp;
    }

    @NotNull
    /* JADX INFO: renamed from: am */
    public String m5286am() {
        return this.f5313cC;
    }

    @NotNull
    /* JADX INFO: renamed from: an */
    public String m5287an() {
        return this.f5314cD;
    }

    @NotNull
    /* JADX INFO: renamed from: al */
    public List<String> m5288al() {
        return this.f5315bk;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public Map<ResourceLocation, List<C0837pB>> m5289n() {
        return this.f5316S;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public Optional<ResourceLocation> m5290m() {
        return this.f5317q;
    }
}
