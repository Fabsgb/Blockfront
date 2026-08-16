package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.rc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rc.class */
public final class C0970rc {

    /* JADX INFO: renamed from: S */
    @NotNull
    private static final MapCodec<C0970rc> f5410S = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.DOUBLE.optionalFieldOf("weight", Double.valueOf(1.0d)).forGetter(c0970rc -> {
            return Double.valueOf(c0970rc.f5412al);
        }), Codec.INT.optionalFieldOf("minDurationTicks", 1200).forGetter(c0970rc2 -> {
            return Integer.valueOf(c0970rc2.f5413ra);
        }), Codec.INT.optionalFieldOf("maxDurationTicks", Integer.valueOf(C1062tN.f5737tA)).forGetter(c0970rc3 -> {
            return Integer.valueOf(c0970rc3.f5414rb);
        }), C0859pX.f4602F.optionalFieldOf("interiorSound").forGetter(c0970rc4 -> {
            return c0970rc4.f5415r.get() != null ? Optional.of(c0970rc4.f5415r) : Optional.empty();
        }), C0859pX.f4602F.optionalFieldOf("exteriorSound").forGetter(c0970rc5 -> {
            return c0970rc5.f5416s.get() != null ? Optional.of(c0970rc5.f5416s) : Optional.empty();
        }), Codec.BOOL.optionalFieldOf("hasFogColor", false).forGetter(c0970rc6 -> {
            return Boolean.valueOf(c0970rc6.f5419gR);
        }), C0859pX.f4603G.optionalFieldOf("fogColor", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter(c0970rc7 -> {
            return Integer.valueOf(c0970rc7.f5420rc);
        }), Codec.BOOL.optionalFieldOf("hasFogDensity", false).forGetter(c0970rc8 -> {
            return Boolean.valueOf(c0970rc8.f5421gS);
        }), Codec.FLOAT.optionalFieldOf("nearFogDensity", Float.valueOf(0.0f)).forGetter(c0970rc9 -> {
            return Float.valueOf(c0970rc9.f5422mz);
        }), Codec.FLOAT.optionalFieldOf("farFogDensity", Float.valueOf(0.0f)).forGetter(c0970rc10 -> {
            return Float.valueOf(c0970rc10.f5423mA);
        }), Codec.BOOL.optionalFieldOf("hasSkyColor", false).forGetter(c0970rc11 -> {
            return Boolean.valueOf(c0970rc11.f5424gT);
        }), C0859pX.f4603G.optionalFieldOf("skyColor", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter(c0970rc12 -> {
            return Integer.valueOf(c0970rc12.f5425rd);
        }), Codec.BOOL.optionalFieldOf("hasLightColor", false).forGetter(c0970rc13 -> {
            return Boolean.valueOf(c0970rc13.f5426gU);
        }), C0859pX.f4603G.optionalFieldOf("lightColor", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter(c0970rc14 -> {
            return Integer.valueOf(c0970rc14.f5427re);
        }), a.f5434L.listOf().optionalFieldOf("ambientSounds", List.of()).forGetter(c0970rc15 -> {
            return c0970rc15.f5428aL;
        }), C0971rd.f5442M.optionalFieldOf("fx", C0971rd.f5441b).forGetter(c0970rc16 -> {
            return c0970rc16.f5429a;
        })).apply(instance, (v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15) -> {
            return m5463a(v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15);
        });
    });

    /* JADX INFO: renamed from: K */
    @NotNull
    public static final Codec<C0970rc> f5411K = RecordCodecBuilder.create(instance -> {
        return instance.group(f5410S.forGetter(c0970rc -> {
            return c0970rc;
        }), C0859pX.f4602F.optionalFieldOf("playerInteriorSound").forGetter(c0970rc2 -> {
            return c0970rc2.f5417t.get() != null ? Optional.of(c0970rc2.f5417t) : Optional.empty();
        }), C0859pX.f4602F.optionalFieldOf("playerExteriorSound").forGetter(c0970rc3 -> {
            return c0970rc3.f5418u.get() != null ? Optional.of(c0970rc3.f5418u) : Optional.empty();
        })).apply(instance, (c0970rc4, optional, optional2) -> {
            c0970rc4.f5417t = (Supplier) optional.orElse(() -> {
                return null;
            });
            c0970rc4.f5418u = (Supplier) optional2.orElse(() -> {
                return null;
            });
            return c0970rc4;
        });
    });

    /* JADX INFO: renamed from: gR */
    public boolean f5419gR;

    /* JADX INFO: renamed from: gS */
    public boolean f5421gS;

    /* JADX INFO: renamed from: mz */
    public float f5422mz;

    /* JADX INFO: renamed from: mA */
    public float f5423mA;

    /* JADX INFO: renamed from: gT */
    public boolean f5424gT;

    /* JADX INFO: renamed from: gU */
    public boolean f5426gU;

    /* JADX INFO: renamed from: al */
    public double f5412al = 1.0d;

    /* JADX INFO: renamed from: ra */
    public int f5413ra = 1200;

    /* JADX INFO: renamed from: rb */
    public int f5414rb = C1062tN.f5737tA;

    /* JADX INFO: renamed from: r */
    @NotNull
    public Supplier<SoundEvent> f5415r = () -> {
        return null;
    };

    /* JADX INFO: renamed from: s */
    @NotNull
    public Supplier<SoundEvent> f5416s = () -> {
        return null;
    };

    /* JADX INFO: renamed from: t */
    @NotNull
    public Supplier<SoundEvent> f5417t = () -> {
        return null;
    };

    /* JADX INFO: renamed from: u */
    @NotNull
    public Supplier<SoundEvent> f5418u = () -> {
        return null;
    };

    /* JADX INFO: renamed from: rc */
    public int f5420rc = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: rd */
    public int f5425rd = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: re */
    public int f5427re = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: aL */
    @NotNull
    public List<a> f5428aL = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    public C0971rd f5429a = C0971rd.f5441b;

    /* JADX INFO: renamed from: com.boehmod.blockfront.rc$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rc$b.class */
    public enum b {
        ANY,
        INTERIOR,
        EXTERIOR;

        @NotNull
        public static b fromName(@Nullable String str) {
            if (str == null) {
                return ANY;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException e) {
                return ANY;
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rc$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rc$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: rf */
        private final int f5430rf;

        /* JADX INFO: renamed from: rg */
        private final int f5431rg;

        /* JADX INFO: renamed from: eK */
        @Nullable
        private final ResourceLocation f5432eK;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final b f5433a;

        /* JADX INFO: renamed from: L */
        @NotNull
        public static final Codec<a> f5434L = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.INT.fieldOf("tickIntervalMin").forGetter((v0) -> {
                return v0.m5495bD();
            }), Codec.INT.fieldOf("tickIntervalMax").forGetter((v0) -> {
                return v0.m5496bE();
            }), ResourceLocation.CODEC.optionalFieldOf("soundGroup").forGetter(aVar -> {
                return Optional.ofNullable(aVar.f5432eK);
            }), Codec.STRING.optionalFieldOf("playbackEnvironment", b.ANY.name()).forGetter(aVar2 -> {
                return aVar2.f5433a.name();
            })).apply(instance, (num, num2, optional, str) -> {
                return new a(num.intValue(), num2.intValue(), (ResourceLocation) optional.orElse(null), b.fromName(str));
            });
        });

        public a(int i, int i2, @Nullable ResourceLocation resourceLocation, @NotNull b bVar) {
            this.f5430rf = i;
            this.f5431rg = i2;
            this.f5432eK = resourceLocation;
            this.f5433a = bVar;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "tickIntervalMin;tickIntervalMax;soundGroup;playbackEnvironment", "FIELD:Lcom/boehmod/blockfront/rc$a;->rf:I", "FIELD:Lcom/boehmod/blockfront/rc$a;->rg:I", "FIELD:Lcom/boehmod/blockfront/rc$a;->eK:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rc$a;->a:Lcom/boehmod/blockfront/rc$b;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "tickIntervalMin;tickIntervalMax;soundGroup;playbackEnvironment", "FIELD:Lcom/boehmod/blockfront/rc$a;->rf:I", "FIELD:Lcom/boehmod/blockfront/rc$a;->rg:I", "FIELD:Lcom/boehmod/blockfront/rc$a;->eK:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rc$a;->a:Lcom/boehmod/blockfront/rc$b;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "tickIntervalMin;tickIntervalMax;soundGroup;playbackEnvironment", "FIELD:Lcom/boehmod/blockfront/rc$a;->rf:I", "FIELD:Lcom/boehmod/blockfront/rc$a;->rg:I", "FIELD:Lcom/boehmod/blockfront/rc$a;->eK:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rc$a;->a:Lcom/boehmod/blockfront/rc$b;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: bD */
        public int m5495bD() {
            return this.f5430rf;
        }

        /* JADX INFO: renamed from: bE */
        public int m5496bE() {
            return this.f5431rg;
        }

        @Nullable
        /* JADX INFO: renamed from: D */
        public ResourceLocation m5497D() {
            return this.f5432eK;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public b m5498a() {
            return this.f5433a;
        }
    }

    /* JADX INFO: renamed from: a */
    private static C0970rc m5463a(double d, int i, int i2, Optional<Supplier<SoundEvent>> optional, Optional<Supplier<SoundEvent>> optional2, boolean z, int i3, boolean z2, float f, float f2, boolean z3, int i4, boolean z4, int i5, List<a> list, C0971rd c0971rd) {
        C0970rc c0970rc = new C0970rc();
        c0970rc.f5412al = d;
        c0970rc.f5413ra = i;
        c0970rc.f5414rb = i2;
        c0970rc.f5415r = optional.orElse(() -> {
            return null;
        });
        c0970rc.f5416s = optional2.orElse(() -> {
            return null;
        });
        c0970rc.f5419gR = z;
        c0970rc.f5420rc = i3;
        c0970rc.f5421gS = z2;
        c0970rc.f5422mz = f;
        c0970rc.f5423mA = f2;
        c0970rc.f5424gT = z3;
        c0970rc.f5425rd = i4;
        c0970rc.f5426gU = z4;
        c0970rc.f5427re = i5;
        c0970rc.f5428aL = new ObjectArrayList(list);
        c0970rc.f5429a = c0971rd;
        return c0970rc;
    }

    /* JADX INFO: renamed from: b */
    public int m5464b(double d) {
        int i = this.f5413ra;
        int iMax = Math.max(i, this.f5414rb);
        return iMax == i ? i : i + ((int) (d * ((double) ((iMax - i) + 1))));
    }
}
