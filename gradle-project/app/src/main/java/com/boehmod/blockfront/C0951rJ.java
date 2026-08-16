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

/* JADX INFO: renamed from: com.boehmod.blockfront.rJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rJ.class */
public final class C0951rJ extends Record {

    /* JADX INFO: renamed from: ro */
    private final int f5296ro;

    /* JADX INFO: renamed from: cz */
    @NotNull
    private final String f5297cz;

    /* JADX INFO: renamed from: cA */
    @NotNull
    private final String f5298cA;

    /* JADX INFO: renamed from: bg */
    @NotNull
    private final List<ResourceLocation> f5299bg;

    /* JADX INFO: renamed from: bh */
    @NotNull
    private final List<ResourceLocation> f5300bh;

    /* JADX INFO: renamed from: bi */
    @NotNull
    private final List<String> f5301bi;

    /* JADX INFO: renamed from: m */
    @NotNull
    private final Optional<ResourceLocation> f5302m;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final Optional<ResourceLocation> f5303n;

    /* JADX INFO: renamed from: o */
    @NotNull
    private final Optional<ResourceLocation> f5304o;

    /* JADX INFO: renamed from: p */
    @NotNull
    private final Optional<ResourceLocation> f5305p;

    /* JADX INFO: renamed from: Q */
    @NotNull
    private final Map<String, ItemStack> f5306Q;

    /* JADX INFO: renamed from: R */
    @NotNull
    private final Map<String, Map<String, ItemStack>> f5307R;

    /* JADX INFO: renamed from: V */
    @NotNull
    public static final Codec<C0951rJ> f5308V = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("index").forGetter((v0) -> {
            return v0.m5269bO();
        }), Codec.STRING.fieldOf("tag").forGetter((v0) -> {
            return v0.m5270al();
        }), Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.m5271k();
        }), ResourceLocation.CODEC.listOf().optionalFieldOf("botVoices", List.of()).forGetter((v0) -> {
            return v0.m5272ah();
        }), ResourceLocation.CODEC.listOf().optionalFieldOf("miscItems", List.of()).forGetter((v0) -> {
            return v0.m5273ai();
        }), Codec.STRING.listOf().optionalFieldOf("usernames", List.of()).forGetter((v0) -> {
            return v0.m5274aj();
        }), ResourceLocation.CODEC.optionalFieldOf("warCrySound").forGetter((v0) -> {
            return v0.m5275i();
        }), ResourceLocation.CODEC.optionalFieldOf("warCrySoundDistant").forGetter((v0) -> {
            return v0.m5276j();
        }), ResourceLocation.CODEC.optionalFieldOf("warCryCrowdSound").forGetter((v0) -> {
            return v0.m5277k();
        }), ResourceLocation.CODEC.optionalFieldOf("warCrySoundCommander").forGetter((v0) -> {
            return v0.m5278l();
        }), Codec.unboundedMap(Codec.STRING, ItemStack.CODEC).optionalFieldOf("weapons", Map.of()).forGetter((v0) -> {
            return v0.m5279l();
        }), Codec.unboundedMap(Codec.STRING, Codec.unboundedMap(Codec.STRING, ItemStack.CODEC)).optionalFieldOf("weaponOverrides", Map.of()).forGetter((v0) -> {
            return v0.m5280m();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12) -> {
            return new C0951rJ(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
        });
    });

    public C0951rJ(int i, @NotNull String str, @NotNull String str2, @NotNull List<ResourceLocation> list, @NotNull List<ResourceLocation> list2, @NotNull List<String> list3, @NotNull Optional<ResourceLocation> optional, @NotNull Optional<ResourceLocation> optional2, @NotNull Optional<ResourceLocation> optional3, @NotNull Optional<ResourceLocation> optional4, @NotNull Map<String, ItemStack> map, @NotNull Map<String, Map<String, ItemStack>> map2) {
        this.f5296ro = i;
        this.f5297cz = str;
        this.f5298cA = str2;
        this.f5299bg = list;
        this.f5300bh = list2;
        this.f5301bi = list3;
        this.f5302m = optional;
        this.f5303n = optional2;
        this.f5304o = optional3;
        this.f5305p = optional4;
        this.f5306Q = map;
        this.f5307R = map2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0951rJ.class), C0951rJ.class, "index;tag;name;botVoices;miscItems;usernames;warCrySound;warCrySoundDistant;warCryCrowdSound;warCrySoundCommander;weapons;weaponOverrides", "FIELD:Lcom/boehmod/blockfront/rJ;->ro:I", "FIELD:Lcom/boehmod/blockfront/rJ;->cz:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rJ;->cA:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rJ;->bg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rJ;->bh:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rJ;->bi:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rJ;->m:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->n:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->o:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->p:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->Q:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rJ;->R:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0951rJ.class), C0951rJ.class, "index;tag;name;botVoices;miscItems;usernames;warCrySound;warCrySoundDistant;warCryCrowdSound;warCrySoundCommander;weapons;weaponOverrides", "FIELD:Lcom/boehmod/blockfront/rJ;->ro:I", "FIELD:Lcom/boehmod/blockfront/rJ;->cz:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rJ;->cA:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rJ;->bg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rJ;->bh:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rJ;->bi:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rJ;->m:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->n:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->o:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->p:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->Q:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rJ;->R:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0951rJ.class, Object.class), C0951rJ.class, "index;tag;name;botVoices;miscItems;usernames;warCrySound;warCrySoundDistant;warCryCrowdSound;warCrySoundCommander;weapons;weaponOverrides", "FIELD:Lcom/boehmod/blockfront/rJ;->ro:I", "FIELD:Lcom/boehmod/blockfront/rJ;->cz:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rJ;->cA:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rJ;->bg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rJ;->bh:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rJ;->bi:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rJ;->m:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->n:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->o:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->p:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rJ;->Q:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rJ;->R:Ljava/util/Map;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bO */
    public int m5269bO() {
        return this.f5296ro;
    }

    @NotNull
    /* JADX INFO: renamed from: al */
    public String m5270al() {
        return this.f5297cz;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public String m5271k() {
        return this.f5298cA;
    }

    @NotNull
    /* JADX INFO: renamed from: ah */
    public List<ResourceLocation> m5272ah() {
        return this.f5299bg;
    }

    @NotNull
    /* JADX INFO: renamed from: ai */
    public List<ResourceLocation> m5273ai() {
        return this.f5300bh;
    }

    @NotNull
    /* JADX INFO: renamed from: aj */
    public List<String> m5274aj() {
        return this.f5301bi;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public Optional<ResourceLocation> m5275i() {
        return this.f5302m;
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public Optional<ResourceLocation> m5276j() {
        return this.f5303n;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public Optional<ResourceLocation> m5277k() {
        return this.f5304o;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public Optional<ResourceLocation> m5278l() {
        return this.f5305p;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public Map<String, ItemStack> m5279l() {
        return this.f5306Q;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public Map<String, Map<String, ItemStack>> m5280m() {
        return this.f5307R;
    }
}
