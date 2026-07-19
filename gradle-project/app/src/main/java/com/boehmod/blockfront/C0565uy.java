package com.boehmod.blockfront;

import com.boehmod.blockfront.C0066cj;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uy.class */
public final class C0565uy extends Record {

    @NotNull
    private final ResourceLocation gk;

    @NotNull
    private final ResourceLocation gl;

    @Nullable
    private final ResourceLocation gm;

    @Nullable
    private final C0066cj.b.a a;
    private final boolean iv;
    private final boolean iw;
    private final boolean ix;

    @NotNull
    private final List<a> cb;

    @NotNull
    private final List<a> cc;

    @NotNull
    private static final Codec<C0066cj.b.a> af = Codec.STRING.xmap(str -> {
        return C0066cj.b.a.valueOf(str.toUpperCase(Locale.ROOT));
    }, aVar -> {
        return aVar.name().toLowerCase(Locale.ROOT);
    });

    @NotNull
    public static final Codec<C0565uy> ag = RecordCodecBuilder.create(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("impactSound").forGetter((v0) -> {
            return v0.S();
        }), ResourceLocation.CODEC.fieldOf("impactDebrisSound").forGetter((v0) -> {
            return v0.T();
        }), ResourceLocation.CODEC.optionalFieldOf("explosionDebrisSound").forGetter(c0565uy -> {
            return Optional.ofNullable(c0565uy.U());
        }), af.optionalFieldOf("overlayEffectType").forGetter(c0565uy2 -> {
            return Optional.ofNullable(c0565uy2.a());
        }), Codec.BOOL.optionalFieldOf("hardMaterial", false).forGetter((v0) -> {
            return v0.cG();
        }), Codec.BOOL.optionalFieldOf("displayImpactEffects", false).forGetter((v0) -> {
            return v0.cH();
        }), Codec.BOOL.optionalFieldOf("displayBulletHole", false).forGetter((v0) -> {
            return v0.cI();
        }), a.ah.listOf().optionalFieldOf("impactParticles", List.of()).forGetter((v0) -> {
            return v0.aH();
        }), a.ah.listOf().optionalFieldOf("directionalImpactParticles", List.of()).forGetter((v0) -> {
            return v0.aI();
        })).apply(instance, (v0, v1, v2, v3, v4, v5, v6, v7, v8) -> {
            return a(v0, v1, v2, v3, v4, v5, v6, v7, v8);
        });
    });

    @NotNull
    public static final Map<ResourceLocation, C0565uy> am = new LinkedHashMap();

    public C0565uy(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @Nullable ResourceLocation resourceLocation3, @Nullable C0066cj.b.a aVar, boolean z, boolean z2, boolean z3, @NotNull List<a> list, @NotNull List<a> list2) {
        this.gk = resourceLocation;
        this.gl = resourceLocation2;
        this.gm = resourceLocation3;
        this.a = aVar;
        this.iv = z;
        this.iw = z2;
        this.ix = z3;
        this.cb = list;
        this.cc = list2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0565uy.class), C0565uy.class, "impactSound;impactDebrisSound;explosionDebrisSound;overlayEffectType;hardMaterial;displayImpactEffects;displayBulletHole;impactParticles;directionalImpactParticles", "FIELD:Lcom/boehmod/blockfront/uy;->gk:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gm:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->a:Lcom/boehmod/blockfront/cj$b$a;", "FIELD:Lcom/boehmod/blockfront/uy;->iv:Z", "FIELD:Lcom/boehmod/blockfront/uy;->iw:Z", "FIELD:Lcom/boehmod/blockfront/uy;->ix:Z", "FIELD:Lcom/boehmod/blockfront/uy;->cb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uy;->cc:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0565uy.class), C0565uy.class, "impactSound;impactDebrisSound;explosionDebrisSound;overlayEffectType;hardMaterial;displayImpactEffects;displayBulletHole;impactParticles;directionalImpactParticles", "FIELD:Lcom/boehmod/blockfront/uy;->gk:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gm:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->a:Lcom/boehmod/blockfront/cj$b$a;", "FIELD:Lcom/boehmod/blockfront/uy;->iv:Z", "FIELD:Lcom/boehmod/blockfront/uy;->iw:Z", "FIELD:Lcom/boehmod/blockfront/uy;->ix:Z", "FIELD:Lcom/boehmod/blockfront/uy;->cb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uy;->cc:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0565uy.class, Object.class), C0565uy.class, "impactSound;impactDebrisSound;explosionDebrisSound;overlayEffectType;hardMaterial;displayImpactEffects;displayBulletHole;impactParticles;directionalImpactParticles", "FIELD:Lcom/boehmod/blockfront/uy;->gk:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gm:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->a:Lcom/boehmod/blockfront/cj$b$a;", "FIELD:Lcom/boehmod/blockfront/uy;->iv:Z", "FIELD:Lcom/boehmod/blockfront/uy;->iw:Z", "FIELD:Lcom/boehmod/blockfront/uy;->ix:Z", "FIELD:Lcom/boehmod/blockfront/uy;->cb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uy;->cc:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public ResourceLocation S() {
        return this.gk;
    }

    @NotNull
    public ResourceLocation T() {
        return this.gl;
    }

    @Nullable
    public ResourceLocation U() {
        return this.gm;
    }

    @Nullable
    public C0066cj.b.a a() {
        return this.a;
    }

    public boolean cG() {
        return this.iv;
    }

    public boolean cH() {
        return this.iw;
    }

    public boolean cI() {
        return this.ix;
    }

    @NotNull
    public List<a> aH() {
        return this.cb;
    }

    @NotNull
    public List<a> aI() {
        return this.cc;
    }

    @NotNull
    private static C0565uy a(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull Optional<ResourceLocation> optional, @NotNull Optional<C0066cj.b.a> optional2, boolean z, boolean z2, boolean z3, @NotNull List<a> list, @NotNull List<a> list2) {
        return new C0565uy(resourceLocation, resourceLocation2, optional.orElse(null), optional2.orElse(null), z, z2, z3, list, list2);
    }

    public static void aR() {
        am.clear();
    }

    public static void a(@NotNull ResourceLocation resourceLocation, @NotNull C0565uy c0565uy) {
        am.put(resourceLocation, c0565uy);
    }

    @Nullable
    public static C0565uy a(@NotNull ResourceLocation resourceLocation) {
        return am.get(resourceLocation);
    }

    @Nullable
    public SoundEvent B() {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(this.gk);
    }

    @Nullable
    public SoundEvent C() {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(this.gl);
    }

    @Nullable
    public SoundEvent D() {
        if (this.gm == null) {
            return null;
        }
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(this.gm);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.uy$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uy$a.class */
    public static final class a extends Record {
        private final int sj;

        @NotNull
        private final ResourceLocation gn;

        @NotNull
        public static final Codec<a> ah = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.INT.fieldOf("count").forGetter((v0) -> {
                return v0.cd();
            }), ResourceLocation.CODEC.fieldOf("particleType").forGetter((v0) -> {
                return v0.V();
            })).apply(instance, (v1, v2) -> {
                return new a(v1, v2);
            });
        });

        public a(int i, @NotNull ResourceLocation resourceLocation) {
            this.sj = i;
            this.gn = resourceLocation;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "count;particleType", "FIELD:Lcom/boehmod/blockfront/uy$a;->sj:I", "FIELD:Lcom/boehmod/blockfront/uy$a;->gn:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "count;particleType", "FIELD:Lcom/boehmod/blockfront/uy$a;->sj:I", "FIELD:Lcom/boehmod/blockfront/uy$a;->gn:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "count;particleType", "FIELD:Lcom/boehmod/blockfront/uy$a;->sj:I", "FIELD:Lcom/boehmod/blockfront/uy$a;->gn:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int cd() {
            return this.sj;
        }

        @NotNull
        public ResourceLocation V() {
            return this.gn;
        }

        @NotNull
        public ParticleOptions a() {
            ParticleOptions particleOptions = (ParticleType) BuiltInRegistries.PARTICLE_TYPE.get(this.gn);
            if (particleOptions instanceof ParticleOptions) {
                return particleOptions;
            }
            throw new IllegalStateException("Particle type " + String.valueOf(this.gn) + " is not a ParticleOptions");
        }
    }
}
