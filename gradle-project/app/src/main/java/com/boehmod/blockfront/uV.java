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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uV.class */
public final class uV extends Record {

    @NotNull
    private final List<Vec2> cf;
    private final boolean iE;
    private final float nK;

    @NotNull
    private static final Codec<Vec2> al = Codec.FLOAT.listOf().comapFlatMap(list -> {
        if (list.size() == 2) {
            return DataResult.success(new Vec2(((Float) list.getFirst()).floatValue(), ((Float) list.get(1)).floatValue()));
        }
        return DataResult.error(() -> {
            return "Spread pattern point must be [x, y]";
        });
    }, vec2 -> {
        return List.of(Float.valueOf(vec2.x), Float.valueOf(vec2.y));
    });

    @NotNull
    public static final Codec<uV> am = RecordCodecBuilder.create(instance -> {
        return instance.group(al.listOf().fieldOf("points").forGetter((v0) -> {
            return v0.aJ();
        }), Codec.BOOL.optionalFieldOf("randomRotation", false).forGetter((v0) -> {
            return v0.cN();
        }), Codec.FLOAT.optionalFieldOf("jitter", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.bJ();
        })).apply(instance, (v1, v2, v3) -> {
            return new uV(v1, v2, v3);
        });
    });

    @NotNull
    public static final Map<ResourceLocation, uV> aq = new Object2ObjectOpenHashMap();

    public uV(@NotNull List<Vec2> list, boolean z, float f) {
        this.cf = list;
        this.iE = z;
        this.nK = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, uV.class), uV.class, "points;randomRotation;jitter", "FIELD:Lcom/boehmod/blockfront/uV;->cf:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uV;->iE:Z", "FIELD:Lcom/boehmod/blockfront/uV;->nK:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, uV.class), uV.class, "points;randomRotation;jitter", "FIELD:Lcom/boehmod/blockfront/uV;->cf:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uV;->iE:Z", "FIELD:Lcom/boehmod/blockfront/uV;->nK:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, uV.class, Object.class), uV.class, "points;randomRotation;jitter", "FIELD:Lcom/boehmod/blockfront/uV;->cf:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uV;->iE:Z", "FIELD:Lcom/boehmod/blockfront/uV;->nK:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public List<Vec2> aJ() {
        return this.cf;
    }

    public boolean cN() {
        return this.iE;
    }

    public float bJ() {
        return this.nK;
    }

    static {
        jZ.bo();
    }

    @NotNull
    public Vec2 a(int i) {
        return this.cf.get(Math.floorMod(i, this.cf.size()));
    }

    @NotNull
    public Vec2 a(int i, long j) {
        Vec2 vec2A = a(i);
        if (this.nK > 0.0f) {
            RandomSource randomSourceCreate = RandomSource.create(j);
            float fNextFloat = randomSourceCreate.nextFloat() * 6.2831855f;
            float fSqrt = Mth.sqrt(randomSourceCreate.nextFloat()) * this.nK;
            vec2A = new Vec2(vec2A.x + (Mth.cos(fNextFloat) * fSqrt), vec2A.y + (Mth.sin(fNextFloat) * fSqrt));
        }
        if (!this.iE) {
            return vec2A;
        }
        float fNextFloat2 = RandomSource.create(j - ((long) i)).nextFloat() * 6.2831855f;
        float fCos = Mth.cos(fNextFloat2);
        float fSin = Mth.sin(fNextFloat2);
        return new Vec2((vec2A.x * fCos) - (vec2A.y * fSin), (vec2A.x * fSin) + (vec2A.y * fCos));
    }

    @Nullable
    public static uV a(@NotNull ResourceLocation resourceLocation) {
        return aq.get(resourceLocation);
    }

    public static void a(@NotNull ResourceLocation resourceLocation, @NotNull uV uVVar) {
        aq.put(resourceLocation, uVVar);
    }

    public static void aR() {
        aq.clear();
    }
}
