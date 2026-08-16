package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rF.class */
public final class C0947rF extends Record {

    /* JADX INFO: renamed from: f */
    private final C0881pt f5225f;

    /* JADX INFO: renamed from: co */
    private final String f5226co;

    /* JADX INFO: renamed from: cp */
    private final String f5227cp;

    /* JADX INFO: renamed from: cq */
    private final String f5228cq;

    /* JADX INFO: renamed from: rm */
    private final int f5229rm;

    /* JADX INFO: renamed from: gX */
    private final boolean f5230gX;

    /* JADX INFO: renamed from: b */
    private final Optional<AABB> f5231b;

    /* JADX INFO: renamed from: Q */
    @NotNull
    public static final Codec<C0947rF> f5232Q = RecordCodecBuilder.create(instance -> {
        return instance.group(C0881pt.f4825s.fieldOf("position").forGetter((v0) -> {
            return v0.m5196e();
        }), Codec.STRING.optionalFieldOf("title", "Unknown").forGetter((v0) -> {
            return v0.m5197ab();
        }), Codec.STRING.optionalFieldOf("capturedBy", "").forGetter((v0) -> {
            return v0.m5198ac();
        }), Codec.STRING.optionalFieldOf("capturing", "").forGetter((v0) -> {
            return v0.m5199ad();
        }), Codec.INT.optionalFieldOf("captureTick", 0).forGetter((v0) -> {
            return v0.m5200bN();
        }), Codec.BOOL.optionalFieldOf("flicker", false).forGetter((v0) -> {
            return v0.m5201bN();
        }), C0859pX.f4601E.optionalFieldOf("captureBox").forGetter((v0) -> {
            return v0.m5202e();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7) -> {
            return new C0947rF(v1, v2, v3, v4, v5, v6, v7);
        });
    });

    public C0947rF(C0881pt c0881pt, String str, String str2, String str3, int i, boolean z, Optional<AABB> optional) {
        this.f5225f = c0881pt;
        this.f5226co = str;
        this.f5227cp = str2;
        this.f5228cq = str3;
        this.f5229rm = i;
        this.f5230gX = z;
        this.f5231b = optional;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0947rF.class), C0947rF.class, "position;title;capturedBy;capturing;captureTick;flicker;captureBox", "FIELD:Lcom/boehmod/blockfront/rF;->f:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rF;->co:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rF;->cp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rF;->cq:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rF;->rm:I", "FIELD:Lcom/boehmod/blockfront/rF;->gX:Z", "FIELD:Lcom/boehmod/blockfront/rF;->b:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0947rF.class), C0947rF.class, "position;title;capturedBy;capturing;captureTick;flicker;captureBox", "FIELD:Lcom/boehmod/blockfront/rF;->f:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rF;->co:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rF;->cp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rF;->cq:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rF;->rm:I", "FIELD:Lcom/boehmod/blockfront/rF;->gX:Z", "FIELD:Lcom/boehmod/blockfront/rF;->b:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0947rF.class, Object.class), C0947rF.class, "position;title;capturedBy;capturing;captureTick;flicker;captureBox", "FIELD:Lcom/boehmod/blockfront/rF;->f:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rF;->co:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rF;->cp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rF;->cq:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rF;->rm:I", "FIELD:Lcom/boehmod/blockfront/rF;->gX:Z", "FIELD:Lcom/boehmod/blockfront/rF;->b:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: e */
    public C0881pt m5196e() {
        return this.f5225f;
    }

    /* JADX INFO: renamed from: ab */
    public String m5197ab() {
        return this.f5226co;
    }

    /* JADX INFO: renamed from: ac */
    public String m5198ac() {
        return this.f5227cp;
    }

    /* JADX INFO: renamed from: ad */
    public String m5199ad() {
        return this.f5228cq;
    }

    /* JADX INFO: renamed from: bN */
    public int m5200bN() {
        return this.f5229rm;
    }

    /* JADX INFO: renamed from: bN */
    public boolean m5201bN() {
        return this.f5230gX;
    }

    /* JADX INFO: renamed from: e */
    public Optional<AABB> m5202e() {
        return this.f5231b;
    }
}
