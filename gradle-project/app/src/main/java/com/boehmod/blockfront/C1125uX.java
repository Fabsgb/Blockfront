package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uX.class */
public final class C1125uX extends Record {

    /* JADX INFO: renamed from: r */
    @NotNull
    private final Optional<ResourceLocation> f6156r;

    /* JADX INFO: renamed from: s */
    @NotNull
    private final Optional<ResourceLocation> f6157s;

    /* JADX INFO: renamed from: ci */
    @NotNull
    private final List<ResourceLocation> f6158ci;

    /* JADX INFO: renamed from: cj */
    @NotNull
    private final List<String> f6159cj;

    /* JADX INFO: renamed from: iN */
    private final boolean f6160iN;

    /* JADX INFO: renamed from: iO */
    private final boolean f6161iO;

    /* JADX INFO: renamed from: ae */
    @NotNull
    public static final Codec<C1125uX> f6162ae = RecordCodecBuilder.create(instance -> {
        return instance.group(ResourceLocation.CODEC.optionalFieldOf("traversable").forGetter((v0) -> {
            return v0.m6431n();
        }), ResourceLocation.CODEC.optionalFieldOf("impact").forGetter((v0) -> {
            return v0.m6432o();
        }), ResourceLocation.CODEC.listOf().optionalFieldOf("blocks", List.of()).forGetter((v0) -> {
            return v0.m6433aJ();
        }), Codec.STRING.listOf().optionalFieldOf("soundTypes", List.of()).forGetter((v0) -> {
            return v0.m6434aK();
        }), Codec.BOOL.optionalFieldOf("preventsWeaponClipping", false).forGetter((v0) -> {
            return v0.m6435cN();
        }), Codec.BOOL.optionalFieldOf("seeThrough", false).forGetter((v0) -> {
            return v0.m6436cO();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C1125uX(v1, v2, v3, v4, v5, v6);
        });
    });

    public C1125uX(@NotNull Optional<ResourceLocation> optional, @NotNull Optional<ResourceLocation> optional2, @NotNull List<ResourceLocation> list, @NotNull List<String> list2, boolean z, boolean z2) {
        this.f6156r = optional;
        this.f6157s = optional2;
        this.f6158ci = list;
        this.f6159cj = list2;
        this.f6160iN = z;
        this.f6161iO = z2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1125uX.class), C1125uX.class, "traversable;impact;blocks;soundTypes;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uX;->r:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/uX;->s:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/uX;->ci:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uX;->cj:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uX;->iN:Z", "FIELD:Lcom/boehmod/blockfront/uX;->iO:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1125uX.class), C1125uX.class, "traversable;impact;blocks;soundTypes;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uX;->r:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/uX;->s:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/uX;->ci:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uX;->cj:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uX;->iN:Z", "FIELD:Lcom/boehmod/blockfront/uX;->iO:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1125uX.class, Object.class), C1125uX.class, "traversable;impact;blocks;soundTypes;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uX;->r:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/uX;->s:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/uX;->ci:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uX;->cj:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uX;->iN:Z", "FIELD:Lcom/boehmod/blockfront/uX;->iO:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public Optional<ResourceLocation> m6431n() {
        return this.f6156r;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public Optional<ResourceLocation> m6432o() {
        return this.f6157s;
    }

    @NotNull
    /* JADX INFO: renamed from: aJ */
    public List<ResourceLocation> m6433aJ() {
        return this.f6158ci;
    }

    @NotNull
    /* JADX INFO: renamed from: aK */
    public List<String> m6434aK() {
        return this.f6159cj;
    }

    /* JADX INFO: renamed from: cN */
    public boolean m6435cN() {
        return this.f6160iN;
    }

    /* JADX INFO: renamed from: cO */
    public boolean m6436cO() {
        return this.f6161iO;
    }
}
