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
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rm.class */
public final class C0472rm extends Record {
    private final int pp;

    @NotNull
    private final String cp;

    @NotNull
    private final String cq;

    @NotNull
    private final List<ResourceLocation> aZ;

    @NotNull
    private final List<ResourceLocation> ba;

    @NotNull
    private final List<String> bb;

    @NotNull
    private final Optional<ResourceLocation> m;

    @NotNull
    private final Optional<ResourceLocation> n;

    @NotNull
    private final Optional<ResourceLocation> o;

    @NotNull
    private final Optional<ResourceLocation> p;

    @NotNull
    private final Map<String, ItemStack> Q;

    @NotNull
    private final Map<String, Map<String, ItemStack>> R;

    @NotNull
    public static final Codec<C0472rm> V = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("index").forGetter((v0) -> {
            return v0.bz();
        }), Codec.STRING.fieldOf("tag").forGetter((v0) -> {
            return v0.ae();
        }), Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.g();
        }), ResourceLocation.CODEC.listOf().optionalFieldOf("botVoices", List.of()).forGetter((v0) -> {
            return v0.af();
        }), ResourceLocation.CODEC.listOf().optionalFieldOf("miscItems", List.of()).forGetter((v0) -> {
            return v0.ag();
        }), Codec.STRING.listOf().optionalFieldOf("usernames", List.of()).forGetter((v0) -> {
            return v0.ah();
        }), ResourceLocation.CODEC.optionalFieldOf("warCrySound").forGetter((v0) -> {
            return v0.i();
        }), ResourceLocation.CODEC.optionalFieldOf("warCrySoundDistant").forGetter((v0) -> {
            return v0.j();
        }), ResourceLocation.CODEC.optionalFieldOf("warCryCrowdSound").forGetter((v0) -> {
            return v0.k();
        }), ResourceLocation.CODEC.optionalFieldOf("warCrySoundCommander").forGetter((v0) -> {
            return v0.l();
        }), Codec.unboundedMap(Codec.STRING, ItemStack.CODEC).optionalFieldOf("weapons", Map.of()).forGetter((v0) -> {
            return v0.m1072l();
        }), Codec.unboundedMap(Codec.STRING, Codec.unboundedMap(Codec.STRING, ItemStack.CODEC)).optionalFieldOf("weaponOverrides", Map.of()).forGetter((v0) -> {
            return v0.m();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12) -> {
            return new C0472rm(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
        });
    });

    public C0472rm(int i, @NotNull String str, @NotNull String str2, @NotNull List<ResourceLocation> list, @NotNull List<ResourceLocation> list2, @NotNull List<String> list3, @NotNull Optional<ResourceLocation> optional, @NotNull Optional<ResourceLocation> optional2, @NotNull Optional<ResourceLocation> optional3, @NotNull Optional<ResourceLocation> optional4, @NotNull Map<String, ItemStack> map, @NotNull Map<String, Map<String, ItemStack>> map2) {
        this.pp = i;
        this.cp = str;
        this.cq = str2;
        this.aZ = list;
        this.ba = list2;
        this.bb = list3;
        this.m = optional;
        this.n = optional2;
        this.o = optional3;
        this.p = optional4;
        this.Q = map;
        this.R = map2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0472rm.class), C0472rm.class, "index;tag;name;botVoices;miscItems;usernames;warCrySound;warCrySoundDistant;warCryCrowdSound;warCrySoundCommander;weapons;weaponOverrides", "FIELD:Lcom/boehmod/blockfront/rm;->pp:I", "FIELD:Lcom/boehmod/blockfront/rm;->cp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->cq:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->aZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->ba:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->bb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->m:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->n:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->o:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->p:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->Q:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rm;->R:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0472rm.class), C0472rm.class, "index;tag;name;botVoices;miscItems;usernames;warCrySound;warCrySoundDistant;warCryCrowdSound;warCrySoundCommander;weapons;weaponOverrides", "FIELD:Lcom/boehmod/blockfront/rm;->pp:I", "FIELD:Lcom/boehmod/blockfront/rm;->cp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->cq:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->aZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->ba:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->bb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->m:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->n:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->o:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->p:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->Q:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rm;->R:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0472rm.class, Object.class), C0472rm.class, "index;tag;name;botVoices;miscItems;usernames;warCrySound;warCrySoundDistant;warCryCrowdSound;warCrySoundCommander;weapons;weaponOverrides", "FIELD:Lcom/boehmod/blockfront/rm;->pp:I", "FIELD:Lcom/boehmod/blockfront/rm;->cp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->cq:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->aZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->ba:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->bb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->m:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->n:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->o:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->p:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->Q:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rm;->R:Ljava/util/Map;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int bz() {
        return this.pp;
    }

    @NotNull
    public String ae() {
        return this.cp;
    }

    @NotNull
    public String g() {
        return this.cq;
    }

    @NotNull
    public List<ResourceLocation> af() {
        return this.aZ;
    }

    @NotNull
    public List<ResourceLocation> ag() {
        return this.ba;
    }

    @NotNull
    public List<String> ah() {
        return this.bb;
    }

    @NotNull
    public Optional<ResourceLocation> i() {
        return this.m;
    }

    @NotNull
    public Optional<ResourceLocation> j() {
        return this.n;
    }

    @NotNull
    public Optional<ResourceLocation> k() {
        return this.o;
    }

    @NotNull
    public Optional<ResourceLocation> l() {
        return this.p;
    }

    @NotNull
    /* JADX INFO: renamed from: l, reason: collision with other method in class */
    public Map<String, ItemStack> m1072l() {
        return this.Q;
    }

    @NotNull
    public Map<String, Map<String, ItemStack>> m() {
        return this.R;
    }
}
