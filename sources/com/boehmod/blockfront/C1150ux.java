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

/* JADX INFO: renamed from: com.boehmod.blockfront.ux */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ux.class */
public final class C1150ux extends Record {

    /* JADX INFO: renamed from: r */
    @NotNull
    private final Optional<ResourceLocation> f6087r;

    /* JADX INFO: renamed from: s */
    @NotNull
    private final Optional<ResourceLocation> f6088s;

    /* JADX INFO: renamed from: bZ */
    @NotNull
    private final List<ResourceLocation> f6089bZ;

    /* JADX INFO: renamed from: ca */
    @NotNull
    private final List<String> f6090ca;

    /* JADX INFO: renamed from: it */
    private final boolean f6091it;

    /* JADX INFO: renamed from: iu */
    private final boolean f6092iu;

    /* JADX INFO: renamed from: ae */
    @NotNull
    public static final Codec<C1150ux> f6093ae = RecordCodecBuilder.create(instance -> {
        return instance.group(ResourceLocation.CODEC.optionalFieldOf("traversable").forGetter((v0) -> {
            return v0.m6445n();
        }), ResourceLocation.CODEC.optionalFieldOf("impact").forGetter((v0) -> {
            return v0.m6446o();
        }), ResourceLocation.CODEC.listOf().optionalFieldOf("blocks", List.of()).forGetter((v0) -> {
            return v0.m6447aF();
        }), Codec.STRING.listOf().optionalFieldOf("soundTypes", List.of()).forGetter((v0) -> {
            return v0.m6448aG();
        }), Codec.BOOL.optionalFieldOf("preventsWeaponClipping", false).forGetter((v0) -> {
            return v0.m6449cE();
        }), Codec.BOOL.optionalFieldOf("seeThrough", false).forGetter((v0) -> {
            return v0.m6450cF();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C1150ux(v1, v2, v3, v4, v5, v6);
        });
    });

    public C1150ux(@NotNull Optional<ResourceLocation> optional, @NotNull Optional<ResourceLocation> optional2, @NotNull List<ResourceLocation> list, @NotNull List<String> list2, boolean z, boolean z2) {
        this.f6087r = optional;
        this.f6088s = optional2;
        this.f6089bZ = list;
        this.f6090ca = list2;
        this.f6091it = z;
        this.f6092iu = z2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1150ux.class), C1150ux.class, "traversable;impact;blocks;soundTypes;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/ux;->r:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->s:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->bZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->ca:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->it:Z", "FIELD:Lcom/boehmod/blockfront/ux;->iu:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1150ux.class), C1150ux.class, "traversable;impact;blocks;soundTypes;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/ux;->r:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->s:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->bZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->ca:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->it:Z", "FIELD:Lcom/boehmod/blockfront/ux;->iu:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1150ux.class, Object.class), C1150ux.class, "traversable;impact;blocks;soundTypes;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/ux;->r:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->s:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->bZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->ca:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->it:Z", "FIELD:Lcom/boehmod/blockfront/ux;->iu:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public Optional<ResourceLocation> m6445n() {
        return this.f6087r;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public Optional<ResourceLocation> m6446o() {
        return this.f6088s;
    }

    @NotNull
    /* JADX INFO: renamed from: aF */
    public List<ResourceLocation> m6447aF() {
        return this.f6089bZ;
    }

    @NotNull
    /* JADX INFO: renamed from: aG */
    public List<String> m6448aG() {
        return this.f6090ca;
    }

    /* JADX INFO: renamed from: cE */
    public boolean m6449cE() {
        return this.f6091it;
    }

    /* JADX INFO: renamed from: cF */
    public boolean m6450cF() {
        return this.f6092iu;
    }
}
