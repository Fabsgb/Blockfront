package com.boehmod.blockfront;

import com.boehmod.bflib.common.RandomCollection;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ip */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ip.class */
public final class C0506ip {

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final Map<ResourceLocation, C0506ip> f3116n = new LinkedHashMap();

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final Codec<List<a>> f3117h = a.f3123i.listOf().fieldOf("entries").codec();

    /* JADX INFO: renamed from: dg */
    @NotNull
    private final ResourceLocation f3118dg;

    /* JADX INFO: renamed from: X */
    @NotNull
    private final List<a> f3119X;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final RandomCollection<AbstractC0504in> f3120a = new RandomCollection<>();

    static {
        C0611ko.m2786bz();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ip$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ip$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: al */
        private final double f3121al;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final AbstractC0504in f3122a;

        /* JADX INFO: renamed from: i */
        @NotNull
        public static final Codec<a> f3123i = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.DOUBLE.fieldOf("weight").forGetter((v0) -> {
                return v0.m2281p();
            }), AbstractC0504in.f3107a.forGetter((v0) -> {
                return v0.m2282b();
            })).apply(instance, (v1, v2) -> {
                return new a(v1, v2);
            });
        });

        public a(double d, @NotNull AbstractC0504in abstractC0504in) {
            this.f3121al = d;
            this.f3122a = abstractC0504in;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "weight;entry", "FIELD:Lcom/boehmod/blockfront/ip$a;->al:D", "FIELD:Lcom/boehmod/blockfront/ip$a;->a:Lcom/boehmod/blockfront/in;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "weight;entry", "FIELD:Lcom/boehmod/blockfront/ip$a;->al:D", "FIELD:Lcom/boehmod/blockfront/ip$a;->a:Lcom/boehmod/blockfront/in;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "weight;entry", "FIELD:Lcom/boehmod/blockfront/ip$a;->al:D", "FIELD:Lcom/boehmod/blockfront/ip$a;->a:Lcom/boehmod/blockfront/in;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: p */
        public double m2281p() {
            return this.f3121al;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public AbstractC0504in m2282b() {
            return this.f3122a;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C0506ip m2275a(@NotNull ResourceLocation resourceLocation) {
        return f3116n.get(resourceLocation);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Map<ResourceLocation, C0506ip> m2276a() {
        return Collections.unmodifiableMap(f3116n);
    }

    /* JADX INFO: renamed from: aZ */
    public static void m2277aZ() {
        f3116n.clear();
    }

    public C0506ip(@NotNull ResourceLocation resourceLocation, @NotNull List<a> list) {
        this.f3118dg = resourceLocation;
        this.f3119X = new ObjectArrayList(list);
        for (a aVar : this.f3119X) {
            this.f3120a.add(aVar.m2281p(), aVar.m2282b());
        }
        f3116n.put(resourceLocation, this);
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public ResourceLocation m2278n() {
        return this.f3118dg;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public List<a> m2279o() {
        return Collections.unmodifiableList(this.f3119X);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0504in m2280a() {
        return this.f3120a.getRandom();
    }
}
