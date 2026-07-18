package com.boehmod.blockfront;

import com.boehmod.blockfront.C0171cj;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.uy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uy.class */
public final class C1151uy extends Record {

    /* JADX INFO: renamed from: gk */
    @NotNull
    private final ResourceLocation f6094gk;

    /* JADX INFO: renamed from: gl */
    @NotNull
    private final ResourceLocation f6095gl;

    /* JADX INFO: renamed from: gm */
    @Nullable
    private final ResourceLocation f6096gm;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final C0171cj.b.a f6097a;

    /* JADX INFO: renamed from: iv */
    private final boolean f6098iv;

    /* JADX INFO: renamed from: iw */
    private final boolean f6099iw;

    /* JADX INFO: renamed from: ix */
    private final boolean f6100ix;

    /* JADX INFO: renamed from: cb */
    @NotNull
    private final List<a> f6101cb;

    /* JADX INFO: renamed from: cc */
    @NotNull
    private final List<a> f6102cc;

    /* JADX INFO: renamed from: af */
    @NotNull
    private static final Codec<C0171cj.b.a> f6103af = Codec.STRING.xmap(str -> {
        return C0171cj.b.a.valueOf(str.toUpperCase(Locale.ROOT));
    }, aVar -> {
        return aVar.name().toLowerCase(Locale.ROOT);
    });

    /* JADX INFO: renamed from: ag */
    @NotNull
    public static final Codec<C1151uy> f6104ag = RecordCodecBuilder.create(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("impactSound").forGetter((v0) -> {
            return v0.m6459S();
        }), ResourceLocation.CODEC.fieldOf("impactDebrisSound").forGetter((v0) -> {
            return v0.m6460T();
        }), ResourceLocation.CODEC.optionalFieldOf("explosionDebrisSound").forGetter(c1151uy -> {
            return Optional.ofNullable(c1151uy.m6461U());
        }), f6103af.optionalFieldOf("overlayEffectType").forGetter(c1151uy2 -> {
            return Optional.ofNullable(c1151uy2.m6462a());
        }), Codec.BOOL.optionalFieldOf("hardMaterial", false).forGetter((v0) -> {
            return v0.m6463cG();
        }), Codec.BOOL.optionalFieldOf("displayImpactEffects", false).forGetter((v0) -> {
            return v0.m6464cH();
        }), Codec.BOOL.optionalFieldOf("displayBulletHole", false).forGetter((v0) -> {
            return v0.m6465cI();
        }), a.f6108ah.listOf().optionalFieldOf("impactParticles", List.of()).forGetter((v0) -> {
            return v0.m6466aH();
        }), a.f6108ah.listOf().optionalFieldOf("directionalImpactParticles", List.of()).forGetter((v0) -> {
            return v0.m6467aI();
        })).apply(instance, (v0, v1, v2, v3, v4, v5, v6, v7, v8) -> {
            return m6452a(v0, v1, v2, v3, v4, v5, v6, v7, v8);
        });
    });

    /* JADX INFO: renamed from: am */
    @NotNull
    public static final Map<ResourceLocation, C1151uy> f6105am = new LinkedHashMap();

    public C1151uy(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @Nullable ResourceLocation resourceLocation3, @Nullable C0171cj.b.a aVar, boolean z, boolean z2, boolean z3, @NotNull List<a> list, @NotNull List<a> list2) {
        this.f6094gk = resourceLocation;
        this.f6095gl = resourceLocation2;
        this.f6096gm = resourceLocation3;
        this.f6097a = aVar;
        this.f6098iv = z;
        this.f6099iw = z2;
        this.f6100ix = z3;
        this.f6101cb = list;
        this.f6102cc = list2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1151uy.class), C1151uy.class, "impactSound;impactDebrisSound;explosionDebrisSound;overlayEffectType;hardMaterial;displayImpactEffects;displayBulletHole;impactParticles;directionalImpactParticles", "FIELD:Lcom/boehmod/blockfront/uy;->gk:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gm:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->a:Lcom/boehmod/blockfront/cj$b$a;", "FIELD:Lcom/boehmod/blockfront/uy;->iv:Z", "FIELD:Lcom/boehmod/blockfront/uy;->iw:Z", "FIELD:Lcom/boehmod/blockfront/uy;->ix:Z", "FIELD:Lcom/boehmod/blockfront/uy;->cb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uy;->cc:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1151uy.class), C1151uy.class, "impactSound;impactDebrisSound;explosionDebrisSound;overlayEffectType;hardMaterial;displayImpactEffects;displayBulletHole;impactParticles;directionalImpactParticles", "FIELD:Lcom/boehmod/blockfront/uy;->gk:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gm:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->a:Lcom/boehmod/blockfront/cj$b$a;", "FIELD:Lcom/boehmod/blockfront/uy;->iv:Z", "FIELD:Lcom/boehmod/blockfront/uy;->iw:Z", "FIELD:Lcom/boehmod/blockfront/uy;->ix:Z", "FIELD:Lcom/boehmod/blockfront/uy;->cb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uy;->cc:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1151uy.class, Object.class), C1151uy.class, "impactSound;impactDebrisSound;explosionDebrisSound;overlayEffectType;hardMaterial;displayImpactEffects;displayBulletHole;impactParticles;directionalImpactParticles", "FIELD:Lcom/boehmod/blockfront/uy;->gk:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->gm:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uy;->a:Lcom/boehmod/blockfront/cj$b$a;", "FIELD:Lcom/boehmod/blockfront/uy;->iv:Z", "FIELD:Lcom/boehmod/blockfront/uy;->iw:Z", "FIELD:Lcom/boehmod/blockfront/uy;->ix:Z", "FIELD:Lcom/boehmod/blockfront/uy;->cb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uy;->cc:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: S */
    public ResourceLocation m6459S() {
        return this.f6094gk;
    }

    @NotNull
    /* JADX INFO: renamed from: T */
    public ResourceLocation m6460T() {
        return this.f6095gl;
    }

    @Nullable
    /* JADX INFO: renamed from: U */
    public ResourceLocation m6461U() {
        return this.f6096gm;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0171cj.b.a m6462a() {
        return this.f6097a;
    }

    /* JADX INFO: renamed from: cG */
    public boolean m6463cG() {
        return this.f6098iv;
    }

    /* JADX INFO: renamed from: cH */
    public boolean m6464cH() {
        return this.f6099iw;
    }

    /* JADX INFO: renamed from: cI */
    public boolean m6465cI() {
        return this.f6100ix;
    }

    @NotNull
    /* JADX INFO: renamed from: aH */
    public List<a> m6466aH() {
        return this.f6101cb;
    }

    @NotNull
    /* JADX INFO: renamed from: aI */
    public List<a> m6467aI() {
        return this.f6102cc;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C1151uy m6452a(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull Optional<ResourceLocation> optional, @NotNull Optional<C0171cj.b.a> optional2, boolean z, boolean z2, boolean z3, @NotNull List<a> list, @NotNull List<a> list2) {
        return new C1151uy(resourceLocation, resourceLocation2, optional.orElse(null), optional2.orElse(null), z, z2, z3, list, list2);
    }

    /* JADX INFO: renamed from: aR */
    public static void m6453aR() {
        f6105am.clear();
    }

    /* JADX INFO: renamed from: a */
    public static void m6454a(@NotNull ResourceLocation resourceLocation, @NotNull C1151uy c1151uy) {
        f6105am.put(resourceLocation, c1151uy);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1151uy m6455a(@NotNull ResourceLocation resourceLocation) {
        return f6105am.get(resourceLocation);
    }

    @Nullable
    /* JADX INFO: renamed from: B */
    public SoundEvent m6456B() {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(this.f6094gk);
    }

    @Nullable
    /* JADX INFO: renamed from: C */
    public SoundEvent m6457C() {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(this.f6095gl);
    }

    @Nullable
    /* JADX INFO: renamed from: D */
    public SoundEvent m6458D() {
        if (this.f6096gm == null) {
            return null;
        }
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(this.f6096gm);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.uy$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uy$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: sj */
        private final int f6106sj;

        /* JADX INFO: renamed from: gn */
        @NotNull
        private final ResourceLocation f6107gn;

        /* JADX INFO: renamed from: ah */
        @NotNull
        public static final Codec<a> f6108ah = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.INT.fieldOf("count").forGetter((v0) -> {
                return v0.m6474cd();
            }), ResourceLocation.CODEC.fieldOf("particleType").forGetter((v0) -> {
                return v0.m6475V();
            })).apply(instance, (v1, v2) -> {
                return new a(v1, v2);
            });
        });

        public a(int i, @NotNull ResourceLocation resourceLocation) {
            this.f6106sj = i;
            this.f6107gn = resourceLocation;
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

        /* JADX INFO: renamed from: cd */
        public int m6474cd() {
            return this.f6106sj;
        }

        @NotNull
        /* JADX INFO: renamed from: V */
        public ResourceLocation m6475V() {
            return this.f6107gn;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public ParticleOptions m6473a() {
            ParticleOptions particleOptions = (ParticleType) BuiltInRegistries.PARTICLE_TYPE.get(this.f6107gn);
            if (particleOptions instanceof ParticleOptions) {
                return particleOptions;
            }
            throw new IllegalStateException("Particle type " + String.valueOf(this.f6107gn) + " is not a ParticleOptions");
        }
    }
}
