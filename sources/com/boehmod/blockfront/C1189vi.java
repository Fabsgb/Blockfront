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

/* JADX INFO: renamed from: com.boehmod.blockfront.vi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vi.class */
public final class C1189vi {

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final C1189vi f6464d = new C1189vi(0.0f, 0.0f);

    /* JADX INFO: renamed from: ap */
    @NotNull
    private static final Map<ResourceLocation, C1189vi> f6465ap = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: aj */
    @NotNull
    public static final Codec<C1189vi> f6466aj = a.f6471ak.listOf().xmap(list -> {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("GunDamageConfig requires at least one entry");
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(list);
        objectArrayList.sort(Comparator.comparingDouble((v0) -> {
            return v0.m6773bF();
        }));
        a aVar = (a) objectArrayList.getFirst();
        C1189vi c1189vi = new C1189vi(aVar.m6774bG(), aVar.m6775bH());
        for (int i = 1; i < objectArrayList.size(); i++) {
            a aVar2 = (a) objectArrayList.get(i);
            c1189vi.m6767a(aVar2.m6773bF(), aVar2.m6774bG(), aVar2.m6775bH());
        }
        return c1189vi;
    }, c1189vi -> {
        ObjectArrayList objectArrayList = new ObjectArrayList(c1189vi.f6467b.size());
        for (Map.Entry<Float, FloatFloatPair> entry : c1189vi.m6770s().entrySet()) {
            objectArrayList.add(new a(entry.getKey().floatValue(), entry.getValue().leftFloat(), entry.getValue().rightFloat()));
        }
        objectArrayList.sort(Comparator.comparingDouble((v0) -> {
            return v0.m6773bF();
        }));
        return objectArrayList;
    });

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Float2ObjectMap<FloatFloatPair> f6467b = new Float2ObjectOpenHashMap();

    static {
        C0612kp.m2789bz();
    }

    /* JADX INFO: renamed from: a */
    public static void m6764a(@NotNull ResourceLocation resourceLocation, @NotNull C1189vi c1189vi) {
        f6465ap.put(resourceLocation, c1189vi);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1189vi m6765a(@NotNull ResourceLocation resourceLocation) {
        return f6465ap.get(resourceLocation);
    }

    /* JADX INFO: renamed from: aZ */
    public static void m6766aZ() {
        f6465ap.clear();
    }

    public C1189vi(float f, float f2) {
        this.f6467b.put(0.0f, FloatFloatImmutablePair.of(f, f2));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1189vi m6767a(float f, float f2, float f3) {
        this.f6467b.put(f, FloatFloatImmutablePair.of(f2, f3));
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public FloatFloatPair m6768c(float f) {
        float f2 = 0.0f;
        FloatIterator it = this.f6467b.keySet().iterator();
        while (it.hasNext()) {
            float fFloatValue = ((Float) it.next()).floatValue();
            if (fFloatValue <= f && fFloatValue > f2) {
                f2 = fFloatValue;
            }
        }
        return (FloatFloatPair) this.f6467b.get(f2);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1189vi m6769a(float f) {
        C1189vi c1189vi = new C1189vi(0.0f, 0.0f);
        c1189vi.f6467b.clear();
        ObjectIterator it = this.f6467b.float2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Float2ObjectMap.Entry entry = (Float2ObjectMap.Entry) it.next();
            c1189vi.f6467b.put(entry.getFloatKey(), FloatFloatImmutablePair.of(((FloatFloatPair) entry.getValue()).leftFloat() * f, ((FloatFloatPair) entry.getValue()).rightFloat() * f));
        }
        return c1189vi;
    }

    @NotNull
    /* JADX INFO: renamed from: s */
    public Map<Float, FloatFloatPair> m6770s() {
        return Collections.unmodifiableMap(this.f6467b);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.vi$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vi$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: ot */
        private final float f6468ot;

        /* JADX INFO: renamed from: ou */
        private final float f6469ou;

        /* JADX INFO: renamed from: ov */
        private final float f6470ov;

        /* JADX INFO: renamed from: ak */
        static final Codec<a> f6471ak = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.FLOAT.optionalFieldOf("distance", Float.valueOf(0.0f)).forGetter((v0) -> {
                return v0.m6773bF();
            }), Codec.FLOAT.fieldOf("damage").forGetter((v0) -> {
                return v0.m6774bG();
            }), Codec.FLOAT.fieldOf("damageHeadshot").forGetter((v0) -> {
                return v0.m6775bH();
            })).apply(instance, (v1, v2, v3) -> {
                return new a(v1, v2, v3);
            });
        });

        private a(float f, float f2, float f3) {
            this.f6468ot = f;
            this.f6469ou = f2;
            this.f6470ov = f3;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "distance;damage;damageHeadshot", "FIELD:Lcom/boehmod/blockfront/vi$a;->ot:F", "FIELD:Lcom/boehmod/blockfront/vi$a;->ou:F", "FIELD:Lcom/boehmod/blockfront/vi$a;->ov:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "distance;damage;damageHeadshot", "FIELD:Lcom/boehmod/blockfront/vi$a;->ot:F", "FIELD:Lcom/boehmod/blockfront/vi$a;->ou:F", "FIELD:Lcom/boehmod/blockfront/vi$a;->ov:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "distance;damage;damageHeadshot", "FIELD:Lcom/boehmod/blockfront/vi$a;->ot:F", "FIELD:Lcom/boehmod/blockfront/vi$a;->ou:F", "FIELD:Lcom/boehmod/blockfront/vi$a;->ov:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: bF */
        public float m6773bF() {
            return this.f6468ot;
        }

        /* JADX INFO: renamed from: bG */
        public float m6774bG() {
            return this.f6469ou;
        }

        /* JADX INFO: renamed from: bH */
        public float m6775bH() {
            return this.f6470ov;
        }
    }
}
