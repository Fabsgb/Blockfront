package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ri */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ri.class */
public final class C0975ri extends Record {

    /* JADX INFO: renamed from: f */
    private final C0805oX f5121f;

    /* JADX INFO: renamed from: ce */
    private final String f5122ce;

    /* JADX INFO: renamed from: cf */
    private final String f5123cf;

    /* JADX INFO: renamed from: cg */
    private final String f5124cg;

    /* JADX INFO: renamed from: pn */
    private final int f5125pn;

    /* JADX INFO: renamed from: gD */
    private final boolean f5126gD;

    /* JADX INFO: renamed from: b */
    private final Optional<AABB> f5127b;

    /* JADX INFO: renamed from: Q */
    @NotNull
    public static final Codec<C0975ri> f5128Q = RecordCodecBuilder.create(instance -> {
        return instance.group(C0805oX.f4422s.fieldOf("position").forGetter((v0) -> {
            return v0.m5320e();
        }), Codec.STRING.optionalFieldOf("title", "Unknown").forGetter((v0) -> {
            return v0.m5321U();
        }), Codec.STRING.optionalFieldOf("capturedBy", "").forGetter((v0) -> {
            return v0.m5322V();
        }), Codec.STRING.optionalFieldOf("capturing", "").forGetter((v0) -> {
            return v0.m5323W();
        }), Codec.INT.optionalFieldOf("captureTick", 0).forGetter((v0) -> {
            return v0.m5324by();
        }), Codec.BOOL.optionalFieldOf("flicker", false).forGetter((v0) -> {
            return v0.m5325bD();
        }), C0836pB.f4472E.optionalFieldOf("captureBox").forGetter((v0) -> {
            return v0.m5326e();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7) -> {
            return new C0975ri(v1, v2, v3, v4, v5, v6, v7);
        });
    });

    public C0975ri(C0805oX c0805oX, String str, String str2, String str3, int i, boolean z, Optional<AABB> optional) {
        this.f5121f = c0805oX;
        this.f5122ce = str;
        this.f5123cf = str2;
        this.f5124cg = str3;
        this.f5125pn = i;
        this.f5126gD = z;
        this.f5127b = optional;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0975ri.class), C0975ri.class, "position;title;capturedBy;capturing;captureTick;flicker;captureBox", "FIELD:Lcom/boehmod/blockfront/ri;->f:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/ri;->ce:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cf:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cg:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->pn:I", "FIELD:Lcom/boehmod/blockfront/ri;->gD:Z", "FIELD:Lcom/boehmod/blockfront/ri;->b:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0975ri.class), C0975ri.class, "position;title;capturedBy;capturing;captureTick;flicker;captureBox", "FIELD:Lcom/boehmod/blockfront/ri;->f:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/ri;->ce:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cf:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cg:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->pn:I", "FIELD:Lcom/boehmod/blockfront/ri;->gD:Z", "FIELD:Lcom/boehmod/blockfront/ri;->b:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0975ri.class, Object.class), C0975ri.class, "position;title;capturedBy;capturing;captureTick;flicker;captureBox", "FIELD:Lcom/boehmod/blockfront/ri;->f:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/ri;->ce:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cf:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cg:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->pn:I", "FIELD:Lcom/boehmod/blockfront/ri;->gD:Z", "FIELD:Lcom/boehmod/blockfront/ri;->b:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: e */
    public C0805oX m5320e() {
        return this.f5121f;
    }

    /* JADX INFO: renamed from: U */
    public String m5321U() {
        return this.f5122ce;
    }

    /* JADX INFO: renamed from: V */
    public String m5322V() {
        return this.f5123cf;
    }

    /* JADX INFO: renamed from: W */
    public String m5323W() {
        return this.f5124cg;
    }

    /* JADX INFO: renamed from: by */
    public int m5324by() {
        return this.f5125pn;
    }

    /* JADX INFO: renamed from: bD */
    public boolean m5325bD() {
        return this.f5126gD;
    }

    /* JADX INFO: renamed from: e */
    public Optional<AABB> m5326e() {
        return this.f5127b;
    }
}
