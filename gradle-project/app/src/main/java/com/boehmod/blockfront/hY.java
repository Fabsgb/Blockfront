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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hY.class */
public final class hY {

    @NotNull
    private static final Map<ResourceLocation, hY> n = new LinkedHashMap();

    @NotNull
    public static final Codec<List<a>> h = a.i.listOf().fieldOf("entries").codec();

    @NotNull
    private final ResourceLocation dg;

    @NotNull
    private final List<a> U;

    @NotNull
    private final RandomCollection<hW> a = new RandomCollection<>();

    static {
        jS.bo();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hY$a.class */
    public static final class a extends Record {
        private final double ad;

        @NotNull
        private final hW a;

        @NotNull
        public static final Codec<a> i = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.DOUBLE.fieldOf("weight").forGetter((v0) -> {
                return v0.n();
            }), hW.a.forGetter((v0) -> {
                return v0.b();
            })).apply(instance, (v1, v2) -> {
                return new a(v1, v2);
            });
        });

        public a(double d, @NotNull hW hWVar) {
            this.ad = d;
            this.a = hWVar;
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

        public double n() {
            return this.ad;
        }

        @NotNull
        public hW b() {
            return this.a;
        }
    }

    @Nullable
    public static hY a(@NotNull ResourceLocation resourceLocation) {
        return n.get(resourceLocation);
    }

    @NotNull
    public static Map<ResourceLocation, hY> a() {
        return Collections.unmodifiableMap(n);
    }

    public static void aR() {
        n.clear();
    }

    public hY(@NotNull ResourceLocation resourceLocation, @NotNull List<a> list) {
        this.dg = resourceLocation;
        this.U = new ObjectArrayList(list);
        for (a aVar : this.U) {
            this.a.add(aVar.n(), aVar.b());
        }
        n.put(resourceLocation, this);
    }

    @NotNull
    public ResourceLocation m() {
        return this.dg;
    }

    @NotNull
    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public List<a> m464m() {
        return Collections.unmodifiableList(this.U);
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hW m465a() {
        return this.a.getRandom();
    }
}
