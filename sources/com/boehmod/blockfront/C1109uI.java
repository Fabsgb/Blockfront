package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.floats.Float2ObjectMap;
import it.unimi.dsi.fastutil.floats.Float2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.floats.FloatFloatImmutablePair;
import it.unimi.dsi.fastutil.floats.FloatFloatPair;
import it.unimi.dsi.fastutil.floats.FloatIterator;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uI.class */
public final class C1109uI {

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final C1109uI f5825d = new C1109uI(0.0f, 0.0f);

    /* JADX INFO: renamed from: ap */
    @NotNull
    private static final Map<ResourceLocation, C1109uI> f5826ap = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: aj */
    @NotNull
    public static final Codec<C1109uI> f5827aj = a.f5832ak.listOf().xmap(list -> {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("GunDamageConfig requires at least one entry");
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(list);
        objectArrayList.sort(Comparator.comparingDouble((v0) -> {
            return v0.m6120bz();
        }));
        a aVar = (a) objectArrayList.getFirst();
        C1109uI c1109uI = new C1109uI(aVar.m6121bA(), aVar.m6122bB());
        for (int i = 1; i < objectArrayList.size(); i++) {
            a aVar2 = (a) objectArrayList.get(i);
            c1109uI.m6114a(aVar2.m6120bz(), aVar2.m6121bA(), aVar2.m6122bB());
        }
        return c1109uI;
    }, c1109uI -> {
        ObjectArrayList objectArrayList = new ObjectArrayList(c1109uI.f5828b.size());
        for (Map.Entry<Float, FloatFloatPair> entry : c1109uI.m6117s().entrySet()) {
            objectArrayList.add(new a(entry.getKey().floatValue(), entry.getValue().leftFloat(), entry.getValue().rightFloat()));
        }
        objectArrayList.sort(Comparator.comparingDouble((v0) -> {
            return v0.m6120bz();
        }));
        return objectArrayList;
    });

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Float2ObjectMap<FloatFloatPair> f5828b = new Float2ObjectOpenHashMap();

    static {
        C0536jT.m2427bo();
    }

    /* JADX INFO: renamed from: a */
    public static void m6111a(@NotNull ResourceLocation resourceLocation, @NotNull C1109uI c1109uI) {
        f5826ap.put(resourceLocation, c1109uI);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1109uI m6112a(@NotNull ResourceLocation resourceLocation) {
        return f5826ap.get(resourceLocation);
    }

    /* JADX INFO: renamed from: aR */
    public static void m6113aR() {
        f5826ap.clear();
    }

    public C1109uI(float f, float f2) {
        this.f5828b.put(0.0f, FloatFloatImmutablePair.of(f, f2));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1109uI m6114a(float f, float f2, float f3) {
        this.f5828b.put(f, FloatFloatImmutablePair.of(f2, f3));
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public FloatFloatPair m6115c(float f) {
        float f2 = 0.0f;
        FloatIterator it = this.f5828b.keySet().iterator();
        while (it.hasNext()) {
            float fFloatValue = ((Float) it.next()).floatValue();
            if (fFloatValue <= f && fFloatValue > f2) {
                f2 = fFloatValue;
            }
        }
        return (FloatFloatPair) this.f5828b.get(f2);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1109uI m6116a(float f) {
        C1109uI c1109uI = new C1109uI(0.0f, 0.0f);
        c1109uI.f5828b.clear();
        ObjectIterator it = this.f5828b.float2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Float2ObjectMap.Entry entry = (Float2ObjectMap.Entry) it.next();
            c1109uI.f5828b.put(entry.getFloatKey(), FloatFloatImmutablePair.of(((FloatFloatPair) entry.getValue()).leftFloat() * f, ((FloatFloatPair) entry.getValue()).rightFloat() * f));
        }
        return c1109uI;
    }

    @NotNull
    /* JADX INFO: renamed from: s */
    public Map<Float, FloatFloatPair> m6117s() {
        return Collections.unmodifiableMap(this.f5828b);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.uI$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uI$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: nv */
        private final float f5829nv;

        /* JADX INFO: renamed from: nw */
        private final float f5830nw;

        /* JADX INFO: renamed from: nx */
        private final float f5831nx;

        /* JADX INFO: renamed from: ak */
        static final Codec<a> f5832ak = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.FLOAT.optionalFieldOf("distance", Float.valueOf(0.0f)).forGetter((v0) -> {
                return v0.m6120bz();
            }), Codec.FLOAT.fieldOf("damage").forGetter((v0) -> {
                return v0.m6121bA();
            }), Codec.FLOAT.fieldOf("damageHeadshot").forGetter((v0) -> {
                return v0.m6122bB();
            })).apply(instance, (v1, v2, v3) -> {
                return new a(v1, v2, v3);
            });
        });

        private a(float f, float f2, float f3) {
            this.f5829nv = f;
            this.f5830nw = f2;
            this.f5831nx = f3;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "distance;damage;damageHeadshot", "FIELD:Lcom/boehmod/blockfront/uI$a;->nv:F", "FIELD:Lcom/boehmod/blockfront/uI$a;->nw:F", "FIELD:Lcom/boehmod/blockfront/uI$a;->nx:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "distance;damage;damageHeadshot", "FIELD:Lcom/boehmod/blockfront/uI$a;->nv:F", "FIELD:Lcom/boehmod/blockfront/uI$a;->nw:F", "FIELD:Lcom/boehmod/blockfront/uI$a;->nx:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "distance;damage;damageHeadshot", "FIELD:Lcom/boehmod/blockfront/uI$a;->nv:F", "FIELD:Lcom/boehmod/blockfront/uI$a;->nw:F", "FIELD:Lcom/boehmod/blockfront/uI$a;->nx:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: bz */
        public float m6120bz() {
            return this.f5829nv;
        }

        /* JADX INFO: renamed from: bA */
        public float m6121bA() {
            return this.f5830nw;
        }

        /* JADX INFO: renamed from: bB */
        public float m6122bB() {
            return this.f5831nx;
        }
    }
}
