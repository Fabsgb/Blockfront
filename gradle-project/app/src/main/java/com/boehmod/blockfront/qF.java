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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qF.class */
public final class qF {

    @NotNull
    private static final MapCodec<qF> R = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.DOUBLE.optionalFieldOf("weight", Double.valueOf(1.0d)).forGetter(qFVar -> {
            return Double.valueOf(qFVar.ad);
        }), Codec.INT.optionalFieldOf("minDurationTicks", 1200).forGetter(qFVar2 -> {
            return Integer.valueOf(qFVar2.pb);
        }), Codec.INT.optionalFieldOf("maxDurationTicks", Integer.valueOf(C0529tp.rx)).forGetter(qFVar3 -> {
            return Integer.valueOf(qFVar3.pc);
        }), pB.F.optionalFieldOf("interiorSound").forGetter(qFVar4 -> {
            return qFVar4.r.get() != null ? Optional.of(qFVar4.r) : Optional.empty();
        }), pB.F.optionalFieldOf("exteriorSound").forGetter(qFVar5 -> {
            return qFVar5.s.get() != null ? Optional.of(qFVar5.s) : Optional.empty();
        }), Codec.BOOL.optionalFieldOf("hasFogColor", false).forGetter(qFVar6 -> {
            return Boolean.valueOf(qFVar6.gx);
        }), pB.G.optionalFieldOf("fogColor", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter(qFVar7 -> {
            return Integer.valueOf(qFVar7.pd);
        }), Codec.BOOL.optionalFieldOf("hasFogDensity", false).forGetter(qFVar8 -> {
            return Boolean.valueOf(qFVar8.gy);
        }), Codec.FLOAT.optionalFieldOf("nearFogDensity", Float.valueOf(0.0f)).forGetter(qFVar9 -> {
            return Float.valueOf(qFVar9.lA);
        }), Codec.FLOAT.optionalFieldOf("farFogDensity", Float.valueOf(0.0f)).forGetter(qFVar10 -> {
            return Float.valueOf(qFVar10.lB);
        }), Codec.BOOL.optionalFieldOf("hasSkyColor", false).forGetter(qFVar11 -> {
            return Boolean.valueOf(qFVar11.gz);
        }), pB.G.optionalFieldOf("skyColor", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter(qFVar12 -> {
            return Integer.valueOf(qFVar12.pe);
        }), Codec.BOOL.optionalFieldOf("hasLightColor", false).forGetter(qFVar13 -> {
            return Boolean.valueOf(qFVar13.gA);
        }), pB.G.optionalFieldOf("lightColor", Integer.valueOf(ColorReferences.COLOR_WHITE)).forGetter(qFVar14 -> {
            return Integer.valueOf(qFVar14.pf);
        }), a.L.listOf().optionalFieldOf("ambientSounds", List.of()).forGetter(qFVar15 -> {
            return qFVar15.aE;
        }), qG.M.optionalFieldOf("fx", qG.f288b).forGetter(qFVar16 -> {
            return qFVar16.a;
        })).apply(instance, (v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15) -> {
            return a(v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15);
        });
    });

    @NotNull
    public static final Codec<qF> K = RecordCodecBuilder.create(instance -> {
        return instance.group(R.forGetter(qFVar -> {
            return qFVar;
        }), pB.F.optionalFieldOf("playerInteriorSound").forGetter(qFVar2 -> {
            return qFVar2.t.get() != null ? Optional.of(qFVar2.t) : Optional.empty();
        }), pB.F.optionalFieldOf("playerExteriorSound").forGetter(qFVar3 -> {
            return qFVar3.u.get() != null ? Optional.of(qFVar3.u) : Optional.empty();
        })).apply(instance, (qFVar4, optional, optional2) -> {
            qFVar4.t = (Supplier) optional.orElse(() -> {
                return null;
            });
            qFVar4.u = (Supplier) optional2.orElse(() -> {
                return null;
            });
            return qFVar4;
        });
    });
    public boolean gx;
    public boolean gy;
    public float lA;
    public float lB;
    public boolean gz;
    public boolean gA;
    public double ad = 1.0d;
    public int pb = 1200;
    public int pc = C0529tp.rx;

    @NotNull
    public Supplier<SoundEvent> r = () -> {
        return null;
    };

    @NotNull
    public Supplier<SoundEvent> s = () -> {
        return null;
    };

    @NotNull
    public Supplier<SoundEvent> t = () -> {
        return null;
    };

    @NotNull
    public Supplier<SoundEvent> u = () -> {
        return null;
    };
    public int pd = ColorReferences.COLOR_WHITE;
    public int pe = ColorReferences.COLOR_WHITE;
    public int pf = ColorReferences.COLOR_WHITE;

    @NotNull
    public List<a> aE = new ObjectArrayList();

    @NotNull
    public qG a = qG.f288b;

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

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qF$a.class */
    public static final class a extends Record {
        private final int pg;
        private final int ph;

        @Nullable
        private final ResourceLocation eL;

        @NotNull
        private final b a;

        @NotNull
        public static final Codec<a> L = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.INT.fieldOf("tickIntervalMin").forGetter((v0) -> {
                return v0.bo();
            }), Codec.INT.fieldOf("tickIntervalMax").forGetter((v0) -> {
                return v0.bp();
            }), ResourceLocation.CODEC.optionalFieldOf("soundGroup").forGetter(aVar -> {
                return Optional.ofNullable(aVar.eL);
            }), Codec.STRING.optionalFieldOf("playbackEnvironment", b.ANY.name()).forGetter(aVar2 -> {
                return aVar2.a.name();
            })).apply(instance, (num, num2, optional, str) -> {
                return new a(num.intValue(), num2.intValue(), (ResourceLocation) optional.orElse(null), b.fromName(str));
            });
        });

        public a(int i, int i2, @Nullable ResourceLocation resourceLocation, @NotNull b bVar) {
            this.pg = i;
            this.ph = i2;
            this.eL = resourceLocation;
            this.a = bVar;
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

        public int bo() {
            return this.pg;
        }

        public int bp() {
            return this.ph;
        }

        @Nullable
        public ResourceLocation C() {
            return this.eL;
        }

        @NotNull
        public b a() {
            return this.a;
        }
    }

    private static qF a(double d, int i, int i2, Optional<Supplier<SoundEvent>> optional, Optional<Supplier<SoundEvent>> optional2, boolean z, int i3, boolean z2, float f, float f2, boolean z3, int i4, boolean z4, int i5, List<a> list, qG qGVar) {
        qF qFVar = new qF();
        qFVar.ad = d;
        qFVar.pb = i;
        qFVar.pc = i2;
        qFVar.r = optional.orElse(() -> {
            return null;
        });
        qFVar.s = optional2.orElse(() -> {
            return null;
        });
        qFVar.gx = z;
        qFVar.pd = i3;
        qFVar.gy = z2;
        qFVar.lA = f;
        qFVar.lB = f2;
        qFVar.gz = z3;
        qFVar.pe = i4;
        qFVar.gA = z4;
        qFVar.pf = i5;
        qFVar.aE = new ObjectArrayList(list);
        qFVar.a = qGVar;
        return qFVar;
    }

    public int b(double d) {
        int i = this.pb;
        int iMax = Math.max(i, this.pc);
        return iMax == i ? i : i + ((int) (d * ((double) ((iMax - i) + 1))));
    }
}
