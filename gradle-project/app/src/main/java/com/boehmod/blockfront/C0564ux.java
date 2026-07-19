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

/* JADX INFO: renamed from: com.boehmod.blockfront.ux, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ux.class */
public final class C0564ux extends Record {

    @NotNull
    private final Optional<ResourceLocation> r;

    @NotNull
    private final Optional<ResourceLocation> s;

    @NotNull
    private final List<ResourceLocation> bZ;

    @NotNull
    private final List<String> ca;
    private final boolean it;
    private final boolean iu;

    @NotNull
    public static final Codec<C0564ux> ae = RecordCodecBuilder.create(instance -> {
        return instance.group(ResourceLocation.CODEC.optionalFieldOf("traversable").forGetter((v0) -> {
            return v0.n();
        }), ResourceLocation.CODEC.optionalFieldOf("impact").forGetter((v0) -> {
            return v0.o();
        }), ResourceLocation.CODEC.listOf().optionalFieldOf("blocks", List.of()).forGetter((v0) -> {
            return v0.aF();
        }), Codec.STRING.listOf().optionalFieldOf("soundTypes", List.of()).forGetter((v0) -> {
            return v0.aG();
        }), Codec.BOOL.optionalFieldOf("preventsWeaponClipping", false).forGetter((v0) -> {
            return v0.cE();
        }), Codec.BOOL.optionalFieldOf("seeThrough", false).forGetter((v0) -> {
            return v0.cF();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0564ux(v1, v2, v3, v4, v5, v6);
        });
    });

    public C0564ux(@NotNull Optional<ResourceLocation> optional, @NotNull Optional<ResourceLocation> optional2, @NotNull List<ResourceLocation> list, @NotNull List<String> list2, boolean z, boolean z2) {
        this.r = optional;
        this.s = optional2;
        this.bZ = list;
        this.ca = list2;
        this.it = z;
        this.iu = z2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0564ux.class), C0564ux.class, "traversable;impact;blocks;soundTypes;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/ux;->r:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->s:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->bZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->ca:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->it:Z", "FIELD:Lcom/boehmod/blockfront/ux;->iu:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0564ux.class), C0564ux.class, "traversable;impact;blocks;soundTypes;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/ux;->r:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->s:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->bZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->ca:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->it:Z", "FIELD:Lcom/boehmod/blockfront/ux;->iu:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0564ux.class, Object.class), C0564ux.class, "traversable;impact;blocks;soundTypes;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/ux;->r:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->s:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/ux;->bZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->ca:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/ux;->it:Z", "FIELD:Lcom/boehmod/blockfront/ux;->iu:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public Optional<ResourceLocation> n() {
        return this.r;
    }

    @NotNull
    public Optional<ResourceLocation> o() {
        return this.s;
    }

    @NotNull
    public List<ResourceLocation> aF() {
        return this.bZ;
    }

    @NotNull
    public List<String> aG() {
        return this.ca;
    }

    public boolean cE() {
        return this.it;
    }

    public boolean cF() {
        return this.iu;
    }
}
