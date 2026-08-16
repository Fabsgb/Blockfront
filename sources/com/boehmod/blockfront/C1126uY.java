package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.uY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uY.class */
public final class C1126uY extends Record {

    /* JADX INFO: renamed from: gj */
    @NotNull
    private final ResourceLocation f6163gj;

    /* JADX INFO: renamed from: gk */
    @NotNull
    private final ResourceLocation f6164gk;

    /* JADX INFO: renamed from: gl */
    @Nullable
    private final ResourceLocation f6165gl;

    /* JADX INFO: renamed from: gm */
    @Nullable
    private final ResourceLocation f6166gm;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final C0191cs.b.a f6167a;

    /* JADX INFO: renamed from: iP */
    private final boolean f6168iP;

    /* JADX INFO: renamed from: iQ */
    private final boolean f6169iQ;

    /* JADX INFO: renamed from: iR */
    private final boolean f6170iR;

    /* JADX INFO: renamed from: ck */
    @NotNull
    private final List<a> f6171ck;

    /* JADX INFO: renamed from: cl */
    @NotNull
    private final List<a> f6172cl;

    /* JADX INFO: renamed from: af */
    @NotNull
    private static final Codec<C0191cs.b.a> f6173af = Codec.STRING.xmap(str -> {
        return C0191cs.b.a.valueOf(str.toUpperCase(Locale.ROOT));
    }, aVar -> {
        return aVar.name().toLowerCase(Locale.ROOT);
    });

    /* JADX INFO: renamed from: ag */
    @NotNull
    public static final Codec<C1126uY> f6174ag = RecordCodecBuilder.create(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("impactSound").forGetter((v0) -> {
            return v0.m6446T();
        }), ResourceLocation.CODEC.fieldOf("impactDebrisSound").forGetter((v0) -> {
            return v0.m6447U();
        }), ResourceLocation.CODEC.optionalFieldOf("impactDebrisLateSound").forGetter(c1126uY -> {
            return Optional.ofNullable(c1126uY.m6448V());
        }), ResourceLocation.CODEC.optionalFieldOf("explosionDebrisSound").forGetter(c1126uY2 -> {
            return Optional.ofNullable(c1126uY2.m6449W());
        }), f6173af.optionalFieldOf("overlayEffectType").forGetter(c1126uY3 -> {
            return Optional.ofNullable(c1126uY3.m6450a());
        }), Codec.BOOL.optionalFieldOf("hardMaterial", false).forGetter((v0) -> {
            return v0.m6451cP();
        }), Codec.BOOL.optionalFieldOf("displayBlockBreakParticles", false).forGetter((v0) -> {
            return v0.m6452cQ();
        }), Codec.BOOL.optionalFieldOf("displayBulletHole", false).forGetter((v0) -> {
            return v0.m6453cR();
        }), a.f6178ah.listOf().optionalFieldOf("impactParticles", List.of()).forGetter((v0) -> {
            return v0.m6454aL();
        }), a.f6178ah.listOf().optionalFieldOf("directionalImpactParticles", List.of()).forGetter((v0) -> {
            return v0.m6455aM();
        })).apply(instance, (v0, v1, v2, v3, v4, v5, v6, v7, v8, v9) -> {
            return m6438a(v0, v1, v2, v3, v4, v5, v6, v7, v8, v9);
        });
    });

    /* JADX INFO: renamed from: am */
    @NotNull
    public static final Map<ResourceLocation, C1126uY> f6175am = new LinkedHashMap();

    public C1126uY(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @Nullable ResourceLocation resourceLocation3, @Nullable ResourceLocation resourceLocation4, @Nullable C0191cs.b.a aVar, boolean z, boolean z2, boolean z3, @NotNull List<a> list, @NotNull List<a> list2) {
        this.f6163gj = resourceLocation;
        this.f6164gk = resourceLocation2;
        this.f6165gl = resourceLocation3;
        this.f6166gm = resourceLocation4;
        this.f6167a = aVar;
        this.f6168iP = z;
        this.f6169iQ = z2;
        this.f6170iR = z3;
        this.f6171ck = list;
        this.f6172cl = list2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1126uY.class), C1126uY.class, "impactSound;impactDebrisSound;impactDebrisLateSound;explosionDebrisSound;overlayEffectType;hardMaterial;displayBlockBreakParticles;displayBulletHole;impactParticles;directionalImpactParticles", "FIELD:Lcom/boehmod/blockfront/uY;->gj:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->gk:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->gl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->gm:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->a:Lcom/boehmod/blockfront/cs$b$a;", "FIELD:Lcom/boehmod/blockfront/uY;->iP:Z", "FIELD:Lcom/boehmod/blockfront/uY;->iQ:Z", "FIELD:Lcom/boehmod/blockfront/uY;->iR:Z", "FIELD:Lcom/boehmod/blockfront/uY;->ck:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uY;->cl:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1126uY.class), C1126uY.class, "impactSound;impactDebrisSound;impactDebrisLateSound;explosionDebrisSound;overlayEffectType;hardMaterial;displayBlockBreakParticles;displayBulletHole;impactParticles;directionalImpactParticles", "FIELD:Lcom/boehmod/blockfront/uY;->gj:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->gk:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->gl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->gm:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->a:Lcom/boehmod/blockfront/cs$b$a;", "FIELD:Lcom/boehmod/blockfront/uY;->iP:Z", "FIELD:Lcom/boehmod/blockfront/uY;->iQ:Z", "FIELD:Lcom/boehmod/blockfront/uY;->iR:Z", "FIELD:Lcom/boehmod/blockfront/uY;->ck:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uY;->cl:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1126uY.class, Object.class), C1126uY.class, "impactSound;impactDebrisSound;impactDebrisLateSound;explosionDebrisSound;overlayEffectType;hardMaterial;displayBlockBreakParticles;displayBulletHole;impactParticles;directionalImpactParticles", "FIELD:Lcom/boehmod/blockfront/uY;->gj:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->gk:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->gl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->gm:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/uY;->a:Lcom/boehmod/blockfront/cs$b$a;", "FIELD:Lcom/boehmod/blockfront/uY;->iP:Z", "FIELD:Lcom/boehmod/blockfront/uY;->iQ:Z", "FIELD:Lcom/boehmod/blockfront/uY;->iR:Z", "FIELD:Lcom/boehmod/blockfront/uY;->ck:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uY;->cl:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: T */
    public ResourceLocation m6446T() {
        return this.f6163gj;
    }

    @NotNull
    /* JADX INFO: renamed from: U */
    public ResourceLocation m6447U() {
        return this.f6164gk;
    }

    @Nullable
    /* JADX INFO: renamed from: V */
    public ResourceLocation m6448V() {
        return this.f6165gl;
    }

    @Nullable
    /* JADX INFO: renamed from: W */
    public ResourceLocation m6449W() {
        return this.f6166gm;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0191cs.b.a m6450a() {
        return this.f6167a;
    }

    /* JADX INFO: renamed from: cP */
    public boolean m6451cP() {
        return this.f6168iP;
    }

    /* JADX INFO: renamed from: cQ */
    public boolean m6452cQ() {
        return this.f6169iQ;
    }

    /* JADX INFO: renamed from: cR */
    public boolean m6453cR() {
        return this.f6170iR;
    }

    @NotNull
    /* JADX INFO: renamed from: aL */
    public List<a> m6454aL() {
        return this.f6171ck;
    }

    @NotNull
    /* JADX INFO: renamed from: aM */
    public List<a> m6455aM() {
        return this.f6172cl;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C1126uY m6438a(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull Optional<ResourceLocation> optional, @NotNull Optional<ResourceLocation> optional2, @NotNull Optional<C0191cs.b.a> optional3, boolean z, boolean z2, boolean z3, @NotNull List<a> list, @NotNull List<a> list2) {
        return new C1126uY(resourceLocation, resourceLocation2, optional.orElse(null), optional2.orElse(null), optional3.orElse(null), z, z2, z3, list, list2);
    }

    /* JADX INFO: renamed from: aZ */
    public static void m6439aZ() {
        f6175am.clear();
    }

    /* JADX INFO: renamed from: a */
    public static void m6440a(@NotNull ResourceLocation resourceLocation, @NotNull C1126uY c1126uY) {
        f6175am.put(resourceLocation, c1126uY);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1126uY m6441a(@NotNull ResourceLocation resourceLocation) {
        return f6175am.get(resourceLocation);
    }

    @Nullable
    /* JADX INFO: renamed from: B */
    public SoundEvent m6442B() {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(this.f6163gj);
    }

    @Nullable
    /* JADX INFO: renamed from: C */
    public SoundEvent m6443C() {
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(this.f6164gk);
    }

    @Nullable
    /* JADX INFO: renamed from: D */
    public SoundEvent m6444D() {
        if (this.f6165gl == null) {
            return null;
        }
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(this.f6165gl);
    }

    @Nullable
    /* JADX INFO: renamed from: E */
    public SoundEvent m6445E() {
        if (this.f6166gm == null) {
            return null;
        }
        return (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(this.f6166gm);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.uY$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uY$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: up */
        private final int f6176up;

        /* JADX INFO: renamed from: gn */
        @NotNull
        private final ResourceLocation f6177gn;

        /* JADX INFO: renamed from: ah */
        @NotNull
        public static final Codec<a> f6178ah = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.INT.fieldOf("count").forGetter((v0) -> {
                return v0.m6463ct();
            }), ResourceLocation.CODEC.fieldOf("particleType").forGetter((v0) -> {
                return v0.m6464X();
            })).apply(instance, (v1, v2) -> {
                return new a(v1, v2);
            });
        });

        public a(int i, @NotNull ResourceLocation resourceLocation) {
            this.f6176up = i;
            this.f6177gn = resourceLocation;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "count;particleType", "FIELD:Lcom/boehmod/blockfront/uY$a;->up:I", "FIELD:Lcom/boehmod/blockfront/uY$a;->gn:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "count;particleType", "FIELD:Lcom/boehmod/blockfront/uY$a;->up:I", "FIELD:Lcom/boehmod/blockfront/uY$a;->gn:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "count;particleType", "FIELD:Lcom/boehmod/blockfront/uY$a;->up:I", "FIELD:Lcom/boehmod/blockfront/uY$a;->gn:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: ct */
        public int m6463ct() {
            return this.f6176up;
        }

        @NotNull
        /* JADX INFO: renamed from: X */
        public ResourceLocation m6464X() {
            return this.f6177gn;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public ParticleOptions m6462a() {
            ParticleOptions particleOptions = (ParticleType) BuiltInRegistries.PARTICLE_TYPE.get(this.f6177gn);
            if (particleOptions instanceof ParticleOptions) {
                return particleOptions;
            }
            throw new IllegalStateException("Particle type " + String.valueOf(this.f6177gn) + " is not a ParticleOptions");
        }
    }
}
