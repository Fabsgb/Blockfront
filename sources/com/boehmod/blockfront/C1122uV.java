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

/* JADX INFO: renamed from: com.boehmod.blockfront.uV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uV.class */
public final class C1122uV extends Record {

    /* JADX INFO: renamed from: cf */
    @NotNull
    private final List<Vec2> f5919cf;

    /* JADX INFO: renamed from: iE */
    private final boolean f5920iE;

    /* JADX INFO: renamed from: nK */
    private final float f5921nK;

    /* JADX INFO: renamed from: al */
    @NotNull
    private static final Codec<Vec2> f5922al = Codec.FLOAT.listOf().comapFlatMap(list -> {
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
    public static final Codec<C1122uV> f5923am = RecordCodecBuilder.create(instance -> {
        return instance.group(f5922al.listOf().fieldOf("points").forGetter((v0) -> {
            return v0.m6233aJ();
        }), Codec.BOOL.optionalFieldOf("randomRotation", false).forGetter((v0) -> {
            return v0.m6234cN();
        }), Codec.FLOAT.optionalFieldOf("jitter", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.m6235bJ();
        })).apply(instance, (v1, v2, v3) -> {
            return new C1122uV(v1, v2, v3);
        });
    });

    /* JADX INFO: renamed from: aq */
    @NotNull
    public static final Map<ResourceLocation, C1122uV> f5924aq = new Object2ObjectOpenHashMap();

    public C1122uV(@NotNull List<Vec2> list, boolean z, float f) {
        this.f5919cf = list;
        this.f5920iE = z;
        this.f5921nK = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1122uV.class), C1122uV.class, "points;randomRotation;jitter", "FIELD:Lcom/boehmod/blockfront/uV;->cf:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uV;->iE:Z", "FIELD:Lcom/boehmod/blockfront/uV;->nK:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1122uV.class), C1122uV.class, "points;randomRotation;jitter", "FIELD:Lcom/boehmod/blockfront/uV;->cf:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uV;->iE:Z", "FIELD:Lcom/boehmod/blockfront/uV;->nK:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1122uV.class, Object.class), C1122uV.class, "points;randomRotation;jitter", "FIELD:Lcom/boehmod/blockfront/uV;->cf:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uV;->iE:Z", "FIELD:Lcom/boehmod/blockfront/uV;->nK:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: aJ */
    public List<Vec2> m6233aJ() {
        return this.f5919cf;
    }

    /* JADX INFO: renamed from: cN */
    public boolean m6234cN() {
        return this.f5920iE;
    }

    /* JADX INFO: renamed from: bJ */
    public float m6235bJ() {
        return this.f5921nK;
    }

    static {
        C0542jZ.m2458bo();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec2 m6228a(int i) {
        return this.f5919cf.get(Math.floorMod(i, this.f5919cf.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec2 m6229a(int i, long j) {
        Vec2 vec2M6228a = m6228a(i);
        if (this.f5921nK > 0.0f) {
            RandomSource randomSourceCreate = RandomSource.create(j);
            float fNextFloat = randomSourceCreate.nextFloat() * 6.2831855f;
            float fSqrt = Mth.sqrt(randomSourceCreate.nextFloat()) * this.f5921nK;
            vec2M6228a = new Vec2(vec2M6228a.x + (Mth.cos(fNextFloat) * fSqrt), vec2M6228a.y + (Mth.sin(fNextFloat) * fSqrt));
        }
        if (!this.f5920iE) {
            return vec2M6228a;
        }
        float fNextFloat2 = RandomSource.create(j - ((long) i)).nextFloat() * 6.2831855f;
        float fCos = Mth.cos(fNextFloat2);
        float fSin = Mth.sin(fNextFloat2);
        return new Vec2((vec2M6228a.x * fCos) - (vec2M6228a.y * fSin), (vec2M6228a.x * fSin) + (vec2M6228a.y * fCos));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1122uV m6230a(@NotNull ResourceLocation resourceLocation) {
        return f5924aq.get(resourceLocation);
    }

    /* JADX INFO: renamed from: a */
    public static void m6231a(@NotNull ResourceLocation resourceLocation, @NotNull C1122uV c1122uV) {
        f5924aq.put(resourceLocation, c1122uV);
    }

    /* JADX INFO: renamed from: aR */
    public static void m6232aR() {
        f5924aq.clear();
    }
}
