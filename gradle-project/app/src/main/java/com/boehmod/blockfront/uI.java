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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uI.class */
public final class uI {

    @NotNull
    public static final uI d = new uI(0.0f, 0.0f);

    @NotNull
    private static final Map<ResourceLocation, uI> ap = new Object2ObjectOpenHashMap();

    @NotNull
    public static final Codec<uI> aj = a.ak.listOf().xmap(list -> {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("GunDamageConfig requires at least one entry");
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(list);
        objectArrayList.sort(Comparator.comparingDouble((v0) -> {
            return v0.bz();
        }));
        a aVar = (a) objectArrayList.getFirst();
        uI uIVar = new uI(aVar.bA(), aVar.bB());
        for (int i = 1; i < objectArrayList.size(); i++) {
            a aVar2 = (a) objectArrayList.get(i);
            uIVar.a(aVar2.bz(), aVar2.bA(), aVar2.bB());
        }
        return uIVar;
    }, uIVar -> {
        ObjectArrayList objectArrayList = new ObjectArrayList(uIVar.b.size());
        for (Map.Entry<Float, FloatFloatPair> entry : uIVar.s().entrySet()) {
            objectArrayList.add(new a(entry.getKey().floatValue(), entry.getValue().leftFloat(), entry.getValue().rightFloat()));
        }
        objectArrayList.sort(Comparator.comparingDouble((v0) -> {
            return v0.bz();
        }));
        return objectArrayList;
    });

    @NotNull
    private final Float2ObjectMap<FloatFloatPair> b = new Float2ObjectOpenHashMap();

    static {
        jT.bo();
    }

    public static void a(@NotNull ResourceLocation resourceLocation, @NotNull uI uIVar) {
        ap.put(resourceLocation, uIVar);
    }

    @Nullable
    public static uI a(@NotNull ResourceLocation resourceLocation) {
        return ap.get(resourceLocation);
    }

    public static void aR() {
        ap.clear();
    }

    public uI(float f, float f2) {
        this.b.put(0.0f, FloatFloatImmutablePair.of(f, f2));
    }

    @NotNull
    public uI a(float f, float f2, float f3) {
        this.b.put(f, FloatFloatImmutablePair.of(f2, f3));
        return this;
    }

    @NotNull
    public FloatFloatPair c(float f) {
        float f2 = 0.0f;
        FloatIterator it = this.b.keySet().iterator();
        while (it.hasNext()) {
            float fFloatValue = ((Float) it.next()).floatValue();
            if (fFloatValue <= f && fFloatValue > f2) {
                f2 = fFloatValue;
            }
        }
        return (FloatFloatPair) this.b.get(f2);
    }

    @NotNull
    public uI a(float f) {
        uI uIVar = new uI(0.0f, 0.0f);
        uIVar.b.clear();
        ObjectIterator it = this.b.float2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Float2ObjectMap.Entry entry = (Float2ObjectMap.Entry) it.next();
            uIVar.b.put(entry.getFloatKey(), FloatFloatImmutablePair.of(((FloatFloatPair) entry.getValue()).leftFloat() * f, ((FloatFloatPair) entry.getValue()).rightFloat() * f));
        }
        return uIVar;
    }

    @NotNull
    public Map<Float, FloatFloatPair> s() {
        return Collections.unmodifiableMap(this.b);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uI$a.class */
    private static final class a extends Record {
        private final float nv;
        private final float nw;
        private final float nx;
        static final Codec<a> ak = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.FLOAT.optionalFieldOf("distance", Float.valueOf(0.0f)).forGetter((v0) -> {
                return v0.bz();
            }), Codec.FLOAT.fieldOf("damage").forGetter((v0) -> {
                return v0.bA();
            }), Codec.FLOAT.fieldOf("damageHeadshot").forGetter((v0) -> {
                return v0.bB();
            })).apply(instance, (v1, v2, v3) -> {
                return new a(v1, v2, v3);
            });
        });

        private a(float f, float f2, float f3) {
            this.nv = f;
            this.nw = f2;
            this.nx = f3;
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

        public float bz() {
            return this.nv;
        }

        public float bA() {
            return this.nw;
        }

        public float bB() {
            return this.nx;
        }
    }
}
