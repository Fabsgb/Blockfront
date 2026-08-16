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

/* JADX INFO: renamed from: com.boehmod.blockfront.ub */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ub.class */
public final class C1129ub extends Record {

    /* JADX INFO: renamed from: nj */
    private final float f6182nj;

    /* JADX INFO: renamed from: nk */
    private final float f6183nk;

    /* JADX INFO: renamed from: nl */
    private final float f6184nl;

    /* JADX INFO: renamed from: nm */
    private final float f6185nm;

    /* JADX INFO: renamed from: nn */
    private final float f6186nn;

    /* JADX INFO: renamed from: no */
    private final float f6187no;

    /* JADX INFO: renamed from: np */
    private final float f6188np;

    /* JADX INFO: renamed from: nq */
    public static final float f6189nq = 0.6f;

    /* JADX INFO: renamed from: nr */
    public static float f6190nr = 0.0f;

    /* JADX INFO: renamed from: ns */
    public static float f6191ns = 0.0f;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C1129ub f6192a = new C1129ub(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: ae */
    @NotNull
    private static final Map<ResourceLocation, C1129ub> f6193ae = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: ad */
    @NotNull
    public static final Codec<C1129ub> f6194ad = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("jumping").forGetter((v0) -> {
            return v0.m6476br();
        }), Codec.FLOAT.fieldOf("walking").forGetter((v0) -> {
            return v0.m6477bs();
        }), Codec.FLOAT.fieldOf("walkingAiming").forGetter((v0) -> {
            return v0.m6478bt();
        }), Codec.FLOAT.fieldOf("idle").forGetter((v0) -> {
            return v0.m6479bu();
        }), Codec.FLOAT.fieldOf("idleAiming").forGetter((v0) -> {
            return v0.m6480bv();
        }), Codec.FLOAT.fieldOf("crawling").forGetter((v0) -> {
            return v0.m6481bw();
        }), Codec.FLOAT.fieldOf("crawlingAiming").forGetter((v0) -> {
            return v0.m6482bx();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7) -> {
            return new C1129ub(v1, v2, v3, v4, v5, v6, v7);
        });
    });

    public C1129ub(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.f6182nj = f;
        this.f6183nk = f2;
        this.f6184nl = f3;
        this.f6185nm = f4;
        this.f6186nn = f5;
        this.f6187no = f6;
        this.f6188np = f7;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1129ub.class), C1129ub.class, "jumpingSpread;walkingSpread;walkingSpreadAiming;idleSpread;idleSpreadAiming;crawlingSpread;crawlingSpreadAiming", "FIELD:Lcom/boehmod/blockfront/ub;->nj:F", "FIELD:Lcom/boehmod/blockfront/ub;->nk:F", "FIELD:Lcom/boehmod/blockfront/ub;->nl:F", "FIELD:Lcom/boehmod/blockfront/ub;->nm:F", "FIELD:Lcom/boehmod/blockfront/ub;->nn:F", "FIELD:Lcom/boehmod/blockfront/ub;->no:F", "FIELD:Lcom/boehmod/blockfront/ub;->np:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1129ub.class), C1129ub.class, "jumpingSpread;walkingSpread;walkingSpreadAiming;idleSpread;idleSpreadAiming;crawlingSpread;crawlingSpreadAiming", "FIELD:Lcom/boehmod/blockfront/ub;->nj:F", "FIELD:Lcom/boehmod/blockfront/ub;->nk:F", "FIELD:Lcom/boehmod/blockfront/ub;->nl:F", "FIELD:Lcom/boehmod/blockfront/ub;->nm:F", "FIELD:Lcom/boehmod/blockfront/ub;->nn:F", "FIELD:Lcom/boehmod/blockfront/ub;->no:F", "FIELD:Lcom/boehmod/blockfront/ub;->np:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1129ub.class, Object.class), C1129ub.class, "jumpingSpread;walkingSpread;walkingSpreadAiming;idleSpread;idleSpreadAiming;crawlingSpread;crawlingSpreadAiming", "FIELD:Lcom/boehmod/blockfront/ub;->nj:F", "FIELD:Lcom/boehmod/blockfront/ub;->nk:F", "FIELD:Lcom/boehmod/blockfront/ub;->nl:F", "FIELD:Lcom/boehmod/blockfront/ub;->nm:F", "FIELD:Lcom/boehmod/blockfront/ub;->nn:F", "FIELD:Lcom/boehmod/blockfront/ub;->no:F", "FIELD:Lcom/boehmod/blockfront/ub;->np:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: br */
    public float m6476br() {
        return this.f6182nj;
    }

    /* JADX INFO: renamed from: bs */
    public float m6477bs() {
        return this.f6183nk;
    }

    /* JADX INFO: renamed from: bt */
    public float m6478bt() {
        return this.f6184nl;
    }

    /* JADX INFO: renamed from: bu */
    public float m6479bu() {
        return this.f6185nm;
    }

    /* JADX INFO: renamed from: bv */
    public float m6480bv() {
        return this.f6186nn;
    }

    /* JADX INFO: renamed from: bw */
    public float m6481bw() {
        return this.f6187no;
    }

    /* JADX INFO: renamed from: bx */
    public float m6482bx() {
        return this.f6188np;
    }

    static {
        C0614kr.m2792bz();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1129ub m6472a(@Nullable ResourceLocation resourceLocation) {
        C1129ub c1129ub;
        if (resourceLocation != null && (c1129ub = f6193ae.get(resourceLocation)) != null) {
            return c1129ub;
        }
        return f6192a;
    }

    /* JADX INFO: renamed from: a */
    public static void m6473a(@NotNull ResourceLocation resourceLocation, @NotNull C1129ub c1129ub) {
        f6193ae.put(resourceLocation, c1129ub);
    }

    /* JADX INFO: renamed from: aZ */
    public static void m6474aZ() {
        f6193ae.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1129ub m6475a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        return new C1129ub(this.f6182nj * f7, this.f6183nk * f3, this.f6184nl * f4, this.f6185nm * f, this.f6186nn * f2, this.f6187no * f5, this.f6188np * f6);
    }
}
