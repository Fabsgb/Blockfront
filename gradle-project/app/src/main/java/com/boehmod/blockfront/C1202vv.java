package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.vv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vv.class */
public final class C1202vv extends Record {

    /* JADX INFO: renamed from: co */
    @NotNull
    private final List<Vec2> f6558co;

    /* JADX INFO: renamed from: iY */
    private final boolean f6559iY;

    /* JADX INFO: renamed from: oI */
    private final float f6560oI;

    /* JADX INFO: renamed from: al */
    @NotNull
    private static final Codec<Vec2> f6561al = Codec.FLOAT.listOf().comapFlatMap(list -> {
        if (list.size() == 2) {
            return DataResult.success(new Vec2(((Float) list.getFirst()).floatValue(), ((Float) list.get(1)).floatValue()));
        }
        return DataResult.error(() -> {
            return "Spread pattern point must be [x, y]";
        });
    }, vec2 -> {
        return List.of(Float.valueOf(vec2.x), Float.valueOf(vec2.y));
    });

    /* JADX INFO: renamed from: am */
    @NotNull
    public static final Codec<C1202vv> f6562am = RecordCodecBuilder.create(instance -> {
        return instance.group(f6561al.listOf().fieldOf("points").forGetter((v0) -> {
            return v0.m6886aQ();
        }), Codec.BOOL.optionalFieldOf("randomRotation", false).forGetter((v0) -> {
            return v0.m6887cW();
        }), Codec.FLOAT.optionalFieldOf("jitter", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.m6888bP();
        })).apply(instance, (v1, v2, v3) -> {
            return new C1202vv(v1, v2, v3);
        });
    });

    /* JADX INFO: renamed from: aq */
    @NotNull
    public static final Map<ResourceLocation, C1202vv> f6563aq = new Object2ObjectOpenHashMap();

    public C1202vv(@NotNull List<Vec2> list, boolean z, float f) {
        this.f6558co = list;
        this.f6559iY = z;
        this.f6560oI = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1202vv.class), C1202vv.class, "points;randomRotation;jitter", "FIELD:Lcom/boehmod/blockfront/vv;->co:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vv;->iY:Z", "FIELD:Lcom/boehmod/blockfront/vv;->oI:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1202vv.class), C1202vv.class, "points;randomRotation;jitter", "FIELD:Lcom/boehmod/blockfront/vv;->co:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vv;->iY:Z", "FIELD:Lcom/boehmod/blockfront/vv;->oI:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1202vv.class, Object.class), C1202vv.class, "points;randomRotation;jitter", "FIELD:Lcom/boehmod/blockfront/vv;->co:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vv;->iY:Z", "FIELD:Lcom/boehmod/blockfront/vv;->oI:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: aQ */
    public List<Vec2> m6886aQ() {
        return this.f6558co;
    }

    /* JADX INFO: renamed from: cW */
    public boolean m6887cW() {
        return this.f6559iY;
    }

    /* JADX INFO: renamed from: bP */
    public float m6888bP() {
        return this.f6560oI;
    }

    static {
        C0618kv.m2817bz();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec2 m6881a(int i) {
        return this.f6558co.get(Math.floorMod(i, this.f6558co.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec2 m6882a(int i, long j) {
        Vec2 vec2M6881a = m6881a(i);
        if (this.f6560oI > 0.0f) {
            RandomSource randomSourceCreate = RandomSource.create(j);
            float fNextFloat = randomSourceCreate.nextFloat() * 6.2831855f;
            float fSqrt = Mth.sqrt(randomSourceCreate.nextFloat()) * this.f6560oI;
            vec2M6881a = new Vec2(vec2M6881a.x + (Mth.cos(fNextFloat) * fSqrt), vec2M6881a.y + (Mth.sin(fNextFloat) * fSqrt));
        }
        if (!this.f6559iY) {
            return vec2M6881a;
        }
        float fNextFloat2 = RandomSource.create(j - ((long) i)).nextFloat() * 6.2831855f;
        float fCos = Mth.cos(fNextFloat2);
        float fSin = Mth.sin(fNextFloat2);
        return new Vec2((vec2M6881a.x * fCos) - (vec2M6881a.y * fSin), (vec2M6881a.x * fSin) + (vec2M6881a.y * fCos));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1202vv m6883a(@NotNull ResourceLocation resourceLocation) {
        return f6563aq.get(resourceLocation);
    }

    /* JADX INFO: renamed from: a */
    public static void m6884a(@NotNull ResourceLocation resourceLocation, @NotNull C1202vv c1202vv) {
        f6563aq.put(resourceLocation, c1202vv);
    }

    /* JADX INFO: renamed from: aZ */
    public static void m6885aZ() {
        f6563aq.clear();
    }
}
