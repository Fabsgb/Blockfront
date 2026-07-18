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

/* JADX INFO: renamed from: com.boehmod.blockfront.rm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rm.class */
public final class C0979rm extends Record {

    /* JADX INFO: renamed from: pp */
    private final int f5192pp;

    /* JADX INFO: renamed from: cp */
    @NotNull
    private final String f5193cp;

    /* JADX INFO: renamed from: cq */
    @NotNull
    private final String f5194cq;

    /* JADX INFO: renamed from: aZ */
    @NotNull
    private final List<ResourceLocation> f5195aZ;

    /* JADX INFO: renamed from: ba */
    @NotNull
    private final List<ResourceLocation> f5196ba;

    /* JADX INFO: renamed from: bb */
    @NotNull
    private final List<String> f5197bb;

    /* JADX INFO: renamed from: m */
    @NotNull
    private final Optional<ResourceLocation> f5198m;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final Optional<ResourceLocation> f5199n;

    /* JADX INFO: renamed from: o */
    @NotNull
    private final Optional<ResourceLocation> f5200o;

    /* JADX INFO: renamed from: p */
    @NotNull
    private final Optional<ResourceLocation> f5201p;

    /* JADX INFO: renamed from: Q */
    @NotNull
    private final Map<String, ItemStack> f5202Q;

    /* JADX INFO: renamed from: R */
    @NotNull
    private final Map<String, Map<String, ItemStack>> f5203R;

    /* JADX INFO: renamed from: V */
    @NotNull
    public static final Codec<C0979rm> f5204V = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("index").forGetter((v0) -> {
            return v0.m5393bz();
        }), Codec.STRING.fieldOf("tag").forGetter((v0) -> {
            return v0.m5394ae();
        }), Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.m5395g();
        }), ResourceLocation.CODEC.listOf().optionalFieldOf("botVoices", List.of()).forGetter((v0) -> {
            return v0.m5396af();
        }), ResourceLocation.CODEC.listOf().optionalFieldOf("miscItems", List.of()).forGetter((v0) -> {
            return v0.m5397ag();
        }), Codec.STRING.listOf().optionalFieldOf("usernames", List.of()).forGetter((v0) -> {
            return v0.m5398ah();
        }), ResourceLocation.CODEC.optionalFieldOf("warCrySound").forGetter((v0) -> {
            return v0.m5399i();
        }), ResourceLocation.CODEC.optionalFieldOf("warCrySoundDistant").forGetter((v0) -> {
            return v0.m5400j();
        }), ResourceLocation.CODEC.optionalFieldOf("warCryCrowdSound").forGetter((v0) -> {
            return v0.m5401k();
        }), ResourceLocation.CODEC.optionalFieldOf("warCrySoundCommander").forGetter((v0) -> {
            return v0.m5402l();
        }), Codec.unboundedMap(Codec.STRING, ItemStack.CODEC).optionalFieldOf("weapons", Map.of()).forGetter((v0) -> {
            return v0.m5403l();
        }), Codec.unboundedMap(Codec.STRING, Codec.unboundedMap(Codec.STRING, ItemStack.CODEC)).optionalFieldOf("weaponOverrides", Map.of()).forGetter((v0) -> {
            return v0.m5404m();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12) -> {
            return new C0979rm(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
        });
    });

    public C0979rm(int i, @NotNull String str, @NotNull String str2, @NotNull List<ResourceLocation> list, @NotNull List<ResourceLocation> list2, @NotNull List<String> list3, @NotNull Optional<ResourceLocation> optional, @NotNull Optional<ResourceLocation> optional2, @NotNull Optional<ResourceLocation> optional3, @NotNull Optional<ResourceLocation> optional4, @NotNull Map<String, ItemStack> map, @NotNull Map<String, Map<String, ItemStack>> map2) {
        this.f5192pp = i;
        this.f5193cp = str;
        this.f5194cq = str2;
        this.f5195aZ = list;
        this.f5196ba = list2;
        this.f5197bb = list3;
        this.f5198m = optional;
        this.f5199n = optional2;
        this.f5200o = optional3;
        this.f5201p = optional4;
        this.f5202Q = map;
        this.f5203R = map2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0979rm.class), C0979rm.class, "index;tag;name;botVoices;miscItems;usernames;warCrySound;warCrySoundDistant;warCryCrowdSound;warCrySoundCommander;weapons;weaponOverrides", "FIELD:Lcom/boehmod/blockfront/rm;->pp:I", "FIELD:Lcom/boehmod/blockfront/rm;->cp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->cq:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->aZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->ba:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->bb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->m:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->n:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->o:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->p:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->Q:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rm;->R:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0979rm.class), C0979rm.class, "index;tag;name;botVoices;miscItems;usernames;warCrySound;warCrySoundDistant;warCryCrowdSound;warCrySoundCommander;weapons;weaponOverrides", "FIELD:Lcom/boehmod/blockfront/rm;->pp:I", "FIELD:Lcom/boehmod/blockfront/rm;->cp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->cq:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->aZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->ba:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->bb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->m:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->n:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->o:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->p:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->Q:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rm;->R:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0979rm.class, Object.class), C0979rm.class, "index;tag;name;botVoices;miscItems;usernames;warCrySound;warCrySoundDistant;warCryCrowdSound;warCrySoundCommander;weapons;weaponOverrides", "FIELD:Lcom/boehmod/blockfront/rm;->pp:I", "FIELD:Lcom/boehmod/blockfront/rm;->cp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->cq:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rm;->aZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->ba:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->bb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rm;->m:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->n:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->o:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->p:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rm;->Q:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/rm;->R:Ljava/util/Map;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bz */
    public int m5393bz() {
        return this.f5192pp;
    }

    @NotNull
    /* JADX INFO: renamed from: ae */
    public String m5394ae() {
        return this.f5193cp;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public String m5395g() {
        return this.f5194cq;
    }

    @NotNull
    /* JADX INFO: renamed from: af */
    public List<ResourceLocation> m5396af() {
        return this.f5195aZ;
    }

    @NotNull
    /* JADX INFO: renamed from: ag */
    public List<ResourceLocation> m5397ag() {
        return this.f5196ba;
    }

    @NotNull
    /* JADX INFO: renamed from: ah */
    public List<String> m5398ah() {
        return this.f5197bb;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public Optional<ResourceLocation> m5399i() {
        return this.f5198m;
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public Optional<ResourceLocation> m5400j() {
        return this.f5199n;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public Optional<ResourceLocation> m5401k() {
        return this.f5200o;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public Optional<ResourceLocation> m5402l() {
        return this.f5201p;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public Map<String, ItemStack> m5403l() {
        return this.f5202Q;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public Map<String, Map<String, ItemStack>> m5404m() {
        return this.f5203R;
    }
}
