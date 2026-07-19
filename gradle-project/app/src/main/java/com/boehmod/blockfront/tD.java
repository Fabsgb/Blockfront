package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tD.class */
public final class tD extends Record {
    private final float mk;
    private final float ml;
    private final float mm;
    private final float mn;
    private final float mo;
    private final float mp;
    private final float mq;
    public static final float mr = 0.6f;
    public static float ms = 0.0f;
    public static float mt = 0.0f;

    @NotNull
    public static final tD a = new tD(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);

    @NotNull
    private static final Map<ResourceLocation, tD> ae = new Object2ObjectOpenHashMap();

    @NotNull
    public static final Codec<tD> ad = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("jumping").forGetter((v0) -> {
            return v0.bl();
        }), Codec.FLOAT.fieldOf("walking").forGetter((v0) -> {
            return v0.bm();
        }), Codec.FLOAT.fieldOf("walkingAiming").forGetter((v0) -> {
            return v0.bn();
        }), Codec.FLOAT.fieldOf("idle").forGetter((v0) -> {
            return v0.bo();
        }), Codec.FLOAT.fieldOf("idleAiming").forGetter((v0) -> {
            return v0.bp();
        }), Codec.FLOAT.fieldOf("crawling").forGetter((v0) -> {
            return v0.bq();
        }), Codec.FLOAT.fieldOf("crawlingAiming").forGetter((v0) -> {
            return v0.br();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7) -> {
            return new tD(v1, v2, v3, v4, v5, v6, v7);
        });
    });

    public tD(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.mk = f;
        this.ml = f2;
        this.mm = f3;
        this.mn = f4;
        this.mo = f5;
        this.mp = f6;
        this.mq = f7;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, tD.class), tD.class, "jumpingSpread;walkingSpread;walkingSpreadAiming;idleSpread;idleSpreadAiming;crawlingSpread;crawlingSpreadAiming", "FIELD:Lcom/boehmod/blockfront/tD;->mk:F", "FIELD:Lcom/boehmod/blockfront/tD;->ml:F", "FIELD:Lcom/boehmod/blockfront/tD;->mm:F", "FIELD:Lcom/boehmod/blockfront/tD;->mn:F", "FIELD:Lcom/boehmod/blockfront/tD;->mo:F", "FIELD:Lcom/boehmod/blockfront/tD;->mp:F", "FIELD:Lcom/boehmod/blockfront/tD;->mq:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, tD.class), tD.class, "jumpingSpread;walkingSpread;walkingSpreadAiming;idleSpread;idleSpreadAiming;crawlingSpread;crawlingSpreadAiming", "FIELD:Lcom/boehmod/blockfront/tD;->mk:F", "FIELD:Lcom/boehmod/blockfront/tD;->ml:F", "FIELD:Lcom/boehmod/blockfront/tD;->mm:F", "FIELD:Lcom/boehmod/blockfront/tD;->mn:F", "FIELD:Lcom/boehmod/blockfront/tD;->mo:F", "FIELD:Lcom/boehmod/blockfront/tD;->mp:F", "FIELD:Lcom/boehmod/blockfront/tD;->mq:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, tD.class, Object.class), tD.class, "jumpingSpread;walkingSpread;walkingSpreadAiming;idleSpread;idleSpreadAiming;crawlingSpread;crawlingSpreadAiming", "FIELD:Lcom/boehmod/blockfront/tD;->mk:F", "FIELD:Lcom/boehmod/blockfront/tD;->ml:F", "FIELD:Lcom/boehmod/blockfront/tD;->mm:F", "FIELD:Lcom/boehmod/blockfront/tD;->mn:F", "FIELD:Lcom/boehmod/blockfront/tD;->mo:F", "FIELD:Lcom/boehmod/blockfront/tD;->mp:F", "FIELD:Lcom/boehmod/blockfront/tD;->mq:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public float bl() {
        return this.mk;
    }

    public float bm() {
        return this.ml;
    }

    public float bn() {
        return this.mm;
    }

    public float bo() {
        return this.mn;
    }

    public float bp() {
        return this.mo;
    }

    public float bq() {
        return this.mp;
    }

    public float br() {
        return this.mq;
    }

    static {
        jV.bo();
    }

    @NotNull
    public static tD a(@Nullable ResourceLocation resourceLocation) {
        tD tDVar;
        if (resourceLocation != null && (tDVar = ae.get(resourceLocation)) != null) {
            return tDVar;
        }
        return a;
    }

    public static void a(@NotNull ResourceLocation resourceLocation, @NotNull tD tDVar) {
        ae.put(resourceLocation, tDVar);
    }

    public static void aR() {
        ae.clear();
    }

    @NotNull
    public tD a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        return new tD(this.mk * f7, this.ml * f3, this.mm * f4, this.mn * f, this.mo * f2, this.mp * f5, this.mq * f6);
    }
}
