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

/* JADX INFO: renamed from: com.boehmod.blockfront.hY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hY.class */
public final class C0435hY {

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final Map<ResourceLocation, C0435hY> f2814n = new LinkedHashMap();

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final Codec<List<a>> f2815h = a.f2821i.listOf().fieldOf("entries").codec();

    /* JADX INFO: renamed from: dg */
    @NotNull
    private final ResourceLocation f2816dg;

    /* JADX INFO: renamed from: U */
    @NotNull
    private final List<a> f2817U;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final RandomCollection<AbstractC0433hW> f2818a = new RandomCollection<>();

    static {
        C0535jS.m2424bo();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.hY$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hY$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: ad */
        private final double f2819ad;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final AbstractC0433hW f2820a;

        /* JADX INFO: renamed from: i */
        @NotNull
        public static final Codec<a> f2821i = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.DOUBLE.fieldOf("weight").forGetter((v0) -> {
                return v0.m2047n();
            }), AbstractC0433hW.f2805a.forGetter((v0) -> {
                return v0.m2048b();
            })).apply(instance, (v1, v2) -> {
                return new a(v1, v2);
            });
        });

        public a(double d, @NotNull AbstractC0433hW abstractC0433hW) {
            this.f2819ad = d;
            this.f2820a = abstractC0433hW;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "weight;entry", "FIELD:Lcom/boehmod/blockfront/hY$a;->ad:D", "FIELD:Lcom/boehmod/blockfront/hY$a;->a:Lcom/boehmod/blockfront/hW;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "weight;entry", "FIELD:Lcom/boehmod/blockfront/hY$a;->ad:D", "FIELD:Lcom/boehmod/blockfront/hY$a;->a:Lcom/boehmod/blockfront/hW;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "weight;entry", "FIELD:Lcom/boehmod/blockfront/hY$a;->ad:D", "FIELD:Lcom/boehmod/blockfront/hY$a;->a:Lcom/boehmod/blockfront/hW;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: n */
        public double m2047n() {
            return this.f2819ad;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public AbstractC0433hW m2048b() {
            return this.f2820a;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C0435hY m2041a(@NotNull ResourceLocation resourceLocation) {
        return f2814n.get(resourceLocation);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Map<ResourceLocation, C0435hY> m2042a() {
        return Collections.unmodifiableMap(f2814n);
    }

    /* JADX INFO: renamed from: aR */
    public static void m2043aR() {
        f2814n.clear();
    }

    public C0435hY(@NotNull ResourceLocation resourceLocation, @NotNull List<a> list) {
        this.f2816dg = resourceLocation;
        this.f2817U = new ObjectArrayList(list);
        for (a aVar : this.f2817U) {
            this.f2818a.add(aVar.m2047n(), aVar.m2048b());
        }
        f2814n.put(resourceLocation, this);
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public ResourceLocation m2044m() {
        return this.f2816dg;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public List<a> m2045m() {
        return Collections.unmodifiableList(this.f2817U);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0433hW m2046a() {
        return this.f2818a.getRandom();
    }
}
