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

/* JADX INFO: renamed from: com.boehmod.blockfront.tD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tD.class */
public final class C1051tD extends Record {

    /* JADX INFO: renamed from: mk */
    private final float f5543mk;

    /* JADX INFO: renamed from: ml */
    private final float f5544ml;

    /* JADX INFO: renamed from: mm */
    private final float f5545mm;

    /* JADX INFO: renamed from: mn */
    private final float f5546mn;

    /* JADX INFO: renamed from: mo */
    private final float f5547mo;

    /* JADX INFO: renamed from: mp */
    private final float f5548mp;

    /* JADX INFO: renamed from: mq */
    private final float f5549mq;

    /* JADX INFO: renamed from: mr */
    public static final float f5550mr = 0.6f;

    /* JADX INFO: renamed from: ms */
    public static float f5551ms = 0.0f;

    /* JADX INFO: renamed from: mt */
    public static float f5552mt = 0.0f;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C1051tD f5553a = new C1051tD(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: ae */
    @NotNull
    private static final Map<ResourceLocation, C1051tD> f5554ae = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: ad */
    @NotNull
    public static final Codec<C1051tD> f5555ad = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("jumping").forGetter((v0) -> {
            return v0.m5840bl();
        }), Codec.FLOAT.fieldOf("walking").forGetter((v0) -> {
            return v0.m5841bm();
        }), Codec.FLOAT.fieldOf("walkingAiming").forGetter((v0) -> {
            return v0.m5842bn();
        }), Codec.FLOAT.fieldOf("idle").forGetter((v0) -> {
            return v0.m5843bo();
        }), Codec.FLOAT.fieldOf("idleAiming").forGetter((v0) -> {
            return v0.m5844bp();
        }), Codec.FLOAT.fieldOf("crawling").forGetter((v0) -> {
            return v0.m5845bq();
        }), Codec.FLOAT.fieldOf("crawlingAiming").forGetter((v0) -> {
            return v0.m5846br();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7) -> {
            return new C1051tD(v1, v2, v3, v4, v5, v6, v7);
        });
    });

    public C1051tD(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.f5543mk = f;
        this.f5544ml = f2;
        this.f5545mm = f3;
        this.f5546mn = f4;
        this.f5547mo = f5;
        this.f5548mp = f6;
        this.f5549mq = f7;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1051tD.class), C1051tD.class, "jumpingSpread;walkingSpread;walkingSpreadAiming;idleSpread;idleSpreadAiming;crawlingSpread;crawlingSpreadAiming", "FIELD:Lcom/boehmod/blockfront/tD;->mk:F", "FIELD:Lcom/boehmod/blockfront/tD;->ml:F", "FIELD:Lcom/boehmod/blockfront/tD;->mm:F", "FIELD:Lcom/boehmod/blockfront/tD;->mn:F", "FIELD:Lcom/boehmod/blockfront/tD;->mo:F", "FIELD:Lcom/boehmod/blockfront/tD;->mp:F", "FIELD:Lcom/boehmod/blockfront/tD;->mq:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1051tD.class), C1051tD.class, "jumpingSpread;walkingSpread;walkingSpreadAiming;idleSpread;idleSpreadAiming;crawlingSpread;crawlingSpreadAiming", "FIELD:Lcom/boehmod/blockfront/tD;->mk:F", "FIELD:Lcom/boehmod/blockfront/tD;->ml:F", "FIELD:Lcom/boehmod/blockfront/tD;->mm:F", "FIELD:Lcom/boehmod/blockfront/tD;->mn:F", "FIELD:Lcom/boehmod/blockfront/tD;->mo:F", "FIELD:Lcom/boehmod/blockfront/tD;->mp:F", "FIELD:Lcom/boehmod/blockfront/tD;->mq:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1051tD.class, Object.class), C1051tD.class, "jumpingSpread;walkingSpread;walkingSpreadAiming;idleSpread;idleSpreadAiming;crawlingSpread;crawlingSpreadAiming", "FIELD:Lcom/boehmod/blockfront/tD;->mk:F", "FIELD:Lcom/boehmod/blockfront/tD;->ml:F", "FIELD:Lcom/boehmod/blockfront/tD;->mm:F", "FIELD:Lcom/boehmod/blockfront/tD;->mn:F", "FIELD:Lcom/boehmod/blockfront/tD;->mo:F", "FIELD:Lcom/boehmod/blockfront/tD;->mp:F", "FIELD:Lcom/boehmod/blockfront/tD;->mq:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bl */
    public float m5840bl() {
        return this.f5543mk;
    }

    /* JADX INFO: renamed from: bm */
    public float m5841bm() {
        return this.f5544ml;
    }

    /* JADX INFO: renamed from: bn */
    public float m5842bn() {
        return this.f5545mm;
    }

    /* JADX INFO: renamed from: bo */
    public float m5843bo() {
        return this.f5546mn;
    }

    /* JADX INFO: renamed from: bp */
    public float m5844bp() {
        return this.f5547mo;
    }

    /* JADX INFO: renamed from: bq */
    public float m5845bq() {
        return this.f5548mp;
    }

    /* JADX INFO: renamed from: br */
    public float m5846br() {
        return this.f5549mq;
    }

    static {
        C0538jV.m2433bo();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1051tD m5836a(@Nullable ResourceLocation resourceLocation) {
        C1051tD c1051tD;
        if (resourceLocation != null && (c1051tD = f5554ae.get(resourceLocation)) != null) {
            return c1051tD;
        }
        return f5553a;
    }

    /* JADX INFO: renamed from: a */
    public static void m5837a(@NotNull ResourceLocation resourceLocation, @NotNull C1051tD c1051tD) {
        f5554ae.put(resourceLocation, c1051tD);
    }

    /* JADX INFO: renamed from: aR */
    public static void m5838aR() {
        f5554ae.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1051tD m5839a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        return new C1051tD(this.f5543mk * f7, this.f5544ml * f3, this.f5545mm * f4, this.f5546mn * f, this.f5547mo * f2, this.f5548mp * f5, this.f5549mq * f6);
    }
}
