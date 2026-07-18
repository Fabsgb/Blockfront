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

/* JADX INFO: renamed from: com.boehmod.blockfront.qF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qF.class */
public final class C0893qF {

    /* JADX INFO: renamed from: R */
    @NotNull
    private static final MapCodec<C0893qF> f4680R = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.DOUBLE.optionalFieldOf("weight", Double.valueOf(1.0d)).forGetter(c0893qF -> {
            return Double.valueOf(c0893qF.f4682ad);
        }), Codec.INT.optionalFieldOf("minDurationTicks", 1200).forGetter(c0893qF2 -> {
            return Integer.valueOf(c0893qF2.f4683pb);
        }), Codec.INT.optionalFieldOf("maxDurationTicks", Integer.valueOf(C1089tp.f5684rx)).forGetter(c0893qF3 -> {
            return Integer.valueOf(c0893qF3.f4684pc);
        }), C0836pB.f4473F.optionalFieldOf("interiorSound").forGetter(c0893qF4 -> {
            return c0893qF4.f4685r.get() != null ? Optional.of(c0893qF4.f4685r) : Optional.empty();
        }), C0836pB.f4473F.optionalFieldOf("exteriorSound").forGetter(c0893qF5 -> {
            return c0893qF5.f4686s.get() != null ? Optional.of(c0893qF5.f4686s) : Optional.empty();
        }), Codec.BOOL.optionalFieldOf("hasFogColor", false).forGetter(c0893qF6 -> {
            return Boolean.valueOf(c0893qF6.f4689gx);
        }), C0836pB.f4474G.optionalFieldOf("fogColor", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter(c0893qF7 -> {
            return Integer.valueOf(c0893qF7.f4690pd);
        }), Codec.BOOL.optionalFieldOf("hasFogDensity", false).forGetter(c0893qF8 -> {
            return Boolean.valueOf(c0893qF8.f4691gy);
        }), Codec.FLOAT.optionalFieldOf("nearFogDensity", Float.valueOf(0.0f)).forGetter(c0893qF9 -> {
            return Float.valueOf(c0893qF9.f4692lA);
        }), Codec.FLOAT.optionalFieldOf("farFogDensity", Float.valueOf(0.0f)).forGetter(c0893qF10 -> {
            return Float.valueOf(c0893qF10.f4693lB);
        }), Codec.BOOL.optionalFieldOf("hasSkyColor", false).forGetter(c0893qF11 -> {
            return Boolean.valueOf(c0893qF11.f4694gz);
        }), C0836pB.f4474G.optionalFieldOf("skyColor", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter(c0893qF12 -> {
            return Integer.valueOf(c0893qF12.f4695pe);
        }), Codec.BOOL.optionalFieldOf("hasLightColor", false).forGetter(c0893qF13 -> {
            return Boolean.valueOf(c0893qF13.f4696gA);
        }), C0836pB.f4474G.optionalFieldOf("lightColor", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter(c0893qF14 -> {
            return Integer.valueOf(c0893qF14.f4697pf);
        }), a.f4704L.listOf().optionalFieldOf("ambientSounds", List.of()).forGetter(c0893qF15 -> {
            return c0893qF15.f4698aE;
        }), C0894qG.f4712M.optionalFieldOf("fx", C0894qG.f4711b).forGetter(c0893qF16 -> {
            return c0893qF16.f4699a;
        })).apply(instance, (v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15) -> {
            return m4568a(v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15);
        });
    });

    /* JADX INFO: renamed from: K */
    @NotNull
    public static final Codec<C0893qF> f4681K = RecordCodecBuilder.create(instance -> {
        return instance.group(f4680R.forGetter(c0893qF -> {
            return c0893qF;
        }), C0836pB.f4473F.optionalFieldOf("playerInteriorSound").forGetter(c0893qF2 -> {
            return c0893qF2.f4687t.get() != null ? Optional.of(c0893qF2.f4687t) : Optional.empty();
        }), C0836pB.f4473F.optionalFieldOf("playerExteriorSound").forGetter(c0893qF3 -> {
            return c0893qF3.f4688u.get() != null ? Optional.of(c0893qF3.f4688u) : Optional.empty();
        })).apply(instance, (c0893qF4, optional, optional2) -> {
            c0893qF4.f4687t = (Supplier) optional.orElse(() -> {
                return null;
            });
            c0893qF4.f4688u = (Supplier) optional2.orElse(() -> {
                return null;
            });
            return c0893qF4;
        });
    });

    /* JADX INFO: renamed from: gx */
    public boolean f4689gx;

    /* JADX INFO: renamed from: gy */
    public boolean f4691gy;

    /* JADX INFO: renamed from: lA */
    public float f4692lA;

    /* JADX INFO: renamed from: lB */
    public float f4693lB;

    /* JADX INFO: renamed from: gz */
    public boolean f4694gz;

    /* JADX INFO: renamed from: gA */
    public boolean f4696gA;

    /* JADX INFO: renamed from: ad */
    public double f4682ad = 1.0d;

    /* JADX INFO: renamed from: pb */
    public int f4683pb = 1200;

    /* JADX INFO: renamed from: pc */
    public int f4684pc = C1089tp.f5684rx;

    /* JADX INFO: renamed from: r */
    @NotNull
    public Supplier<SoundEvent> f4685r = () -> {
        return null;
    };

    /* JADX INFO: renamed from: s */
    @NotNull
    public Supplier<SoundEvent> f4686s = () -> {
        return null;
    };

    /* JADX INFO: renamed from: t */
    @NotNull
    public Supplier<SoundEvent> f4687t = () -> {
        return null;
    };

    /* JADX INFO: renamed from: u */
    @NotNull
    public Supplier<SoundEvent> f4688u = () -> {
        return null;
    };

    /* JADX INFO: renamed from: pd */
    public int f4690pd = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: pe */
    public int f4695pe = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: pf */
    public int f4697pf = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: aE */
    @NotNull
    public List<a> f4698aE = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    public C0894qG f4699a = C0894qG.f4711b;

    /* JADX INFO: renamed from: com.boehmod.blockfront.qF$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qF$b.class */
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

    /* JADX INFO: renamed from: com.boehmod.blockfront.qF$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qF$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: pg */
        private final int f4700pg;

        /* JADX INFO: renamed from: ph */
        private final int f4701ph;

        /* JADX INFO: renamed from: eL */
        @Nullable
        private final ResourceLocation f4702eL;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final b f4703a;

        /* JADX INFO: renamed from: L */
        @NotNull
        public static final Codec<a> f4704L = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.INT.fieldOf("tickIntervalMin").forGetter((v0) -> {
                return v0.m4600bo();
            }), Codec.INT.fieldOf("tickIntervalMax").forGetter((v0) -> {
                return v0.m4601bp();
            }), ResourceLocation.CODEC.optionalFieldOf("soundGroup").forGetter(aVar -> {
                return Optional.ofNullable(aVar.f4702eL);
            }), Codec.STRING.optionalFieldOf("playbackEnvironment", b.ANY.name()).forGetter(aVar2 -> {
                return aVar2.f4703a.name();
            })).apply(instance, (num, num2, optional, str) -> {
                return new a(num.intValue(), num2.intValue(), (ResourceLocation) optional.orElse(null), b.fromName(str));
            });
        });

        public a(int i, int i2, @Nullable ResourceLocation resourceLocation, @NotNull b bVar) {
            this.f4700pg = i;
            this.f4701ph = i2;
            this.f4702eL = resourceLocation;
            this.f4703a = bVar;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "tickIntervalMin;tickIntervalMax;soundGroup;playbackEnvironment", "FIELD:Lcom/boehmod/blockfront/qF$a;->pg:I", "FIELD:Lcom/boehmod/blockfront/qF$a;->ph:I", "FIELD:Lcom/boehmod/blockfront/qF$a;->eL:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/qF$a;->a:Lcom/boehmod/blockfront/qF$b;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "tickIntervalMin;tickIntervalMax;soundGroup;playbackEnvironment", "FIELD:Lcom/boehmod/blockfront/qF$a;->pg:I", "FIELD:Lcom/boehmod/blockfront/qF$a;->ph:I", "FIELD:Lcom/boehmod/blockfront/qF$a;->eL:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/qF$a;->a:Lcom/boehmod/blockfront/qF$b;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "tickIntervalMin;tickIntervalMax;soundGroup;playbackEnvironment", "FIELD:Lcom/boehmod/blockfront/qF$a;->pg:I", "FIELD:Lcom/boehmod/blockfront/qF$a;->ph:I", "FIELD:Lcom/boehmod/blockfront/qF$a;->eL:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/qF$a;->a:Lcom/boehmod/blockfront/qF$b;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: bo */
        public int m4600bo() {
            return this.f4700pg;
        }

        /* JADX INFO: renamed from: bp */
        public int m4601bp() {
            return this.f4701ph;
        }

        @Nullable
        /* JADX INFO: renamed from: C */
        public ResourceLocation m4602C() {
            return this.f4702eL;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public b m4603a() {
            return this.f4703a;
        }
    }

    /* JADX INFO: renamed from: a */
    private static C0893qF m4568a(double d, int i, int i2, Optional<Supplier<SoundEvent>> optional, Optional<Supplier<SoundEvent>> optional2, boolean z, int i3, boolean z2, float f, float f2, boolean z3, int i4, boolean z4, int i5, List<a> list, C0894qG c0894qG) {
        C0893qF c0893qF = new C0893qF();
        c0893qF.f4682ad = d;
        c0893qF.f4683pb = i;
        c0893qF.f4684pc = i2;
        c0893qF.f4685r = optional.orElse(() -> {
            return null;
        });
        c0893qF.f4686s = optional2.orElse(() -> {
            return null;
        });
        c0893qF.f4689gx = z;
        c0893qF.f4690pd = i3;
        c0893qF.f4691gy = z2;
        c0893qF.f4692lA = f;
        c0893qF.f4693lB = f2;
        c0893qF.f4694gz = z3;
        c0893qF.f4695pe = i4;
        c0893qF.f4696gA = z4;
        c0893qF.f4697pf = i5;
        c0893qF.f4698aE = new ObjectArrayList(list);
        c0893qF.f4699a = c0894qG;
        return c0893qF;
    }

    /* JADX INFO: renamed from: b */
    public int m4569b(double d) {
        int i = this.f4683pb;
        int iMax = Math.max(i, this.f4684pc);
        return iMax == i ? i : i + ((int) (d * ((double) ((iMax - i) + 1))));
    }
}
