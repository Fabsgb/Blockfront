package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ri, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ri.class */
public final class C0468ri extends Record {
    private final oX f;
    private final String ce;
    private final String cf;
    private final String cg;
    private final int pn;
    private final boolean gD;
    private final Optional<AABB> b;

    @NotNull
    public static final Codec<C0468ri> Q = RecordCodecBuilder.create(instance -> {
        return instance.group(oX.s.fieldOf("position").forGetter((v0) -> {
            return v0.e();
        }), Codec.STRING.optionalFieldOf("title", "Unknown").forGetter((v0) -> {
            return v0.U();
        }), Codec.STRING.optionalFieldOf("capturedBy", "").forGetter((v0) -> {
            return v0.V();
        }), Codec.STRING.optionalFieldOf("capturing", "").forGetter((v0) -> {
            return v0.W();
        }), Codec.INT.optionalFieldOf("captureTick", 0).forGetter((v0) -> {
            return v0.by();
        }), Codec.BOOL.optionalFieldOf("flicker", false).forGetter((v0) -> {
            return v0.bD();
        }), pB.E.optionalFieldOf("captureBox").forGetter((v0) -> {
            return v0.m1057e();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7) -> {
            return new C0468ri(v1, v2, v3, v4, v5, v6, v7);
        });
    });

    public C0468ri(oX oXVar, String str, String str2, String str3, int i, boolean z, Optional<AABB> optional) {
        this.f = oXVar;
        this.ce = str;
        this.cf = str2;
        this.cg = str3;
        this.pn = i;
        this.gD = z;
        this.b = optional;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0468ri.class), C0468ri.class, "position;title;capturedBy;capturing;captureTick;flicker;captureBox", "FIELD:Lcom/boehmod/blockfront/ri;->f:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/ri;->ce:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cf:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cg:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->pn:I", "FIELD:Lcom/boehmod/blockfront/ri;->gD:Z", "FIELD:Lcom/boehmod/blockfront/ri;->b:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0468ri.class), C0468ri.class, "position;title;capturedBy;capturing;captureTick;flicker;captureBox", "FIELD:Lcom/boehmod/blockfront/ri;->f:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/ri;->ce:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cf:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cg:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->pn:I", "FIELD:Lcom/boehmod/blockfront/ri;->gD:Z", "FIELD:Lcom/boehmod/blockfront/ri;->b:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0468ri.class, Object.class), C0468ri.class, "position;title;capturedBy;capturing;captureTick;flicker;captureBox", "FIELD:Lcom/boehmod/blockfront/ri;->f:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/ri;->ce:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cf:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->cg:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ri;->pn:I", "FIELD:Lcom/boehmod/blockfront/ri;->gD:Z", "FIELD:Lcom/boehmod/blockfront/ri;->b:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public oX e() {
        return this.f;
    }

    public String U() {
        return this.ce;
    }

    public String V() {
        return this.cf;
    }

    public String W() {
        return this.cg;
    }

    public int by() {
        return this.pn;
    }

    public boolean bD() {
        return this.gD;
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public Optional<AABB> m1057e() {
        return this.b;
    }
}
