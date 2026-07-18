package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rk.class */
public final class C0977rk extends Record {

    /* JADX INFO: renamed from: cl */
    private final String f5141cl;

    /* JADX INFO: renamed from: cm */
    private final String f5142cm;

    /* JADX INFO: renamed from: aH */
    private final List<C0980rn> f5143aH;

    /* JADX INFO: renamed from: c */
    private final Optional<C0805oX> f5144c;

    /* JADX INFO: renamed from: a */
    private final InterfaceC0978rl f5145a;

    /* JADX INFO: renamed from: gJ */
    private final boolean f5146gJ;

    /* JADX INFO: renamed from: S */
    @NotNull
    public static final Codec<C0977rk> f5147S = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("gameName").forGetter((v0) -> {
            return v0.m5340aa();
        }), Codec.STRING.optionalFieldOf("mapName", "").forGetter((v0) -> {
            return v0.m5341ab();
        }), C0980rn.f5207W.listOf().optionalFieldOf("teams", List.of()).forGetter((v0) -> {
            return v0.m5342P();
        }), C0805oX.f4422s.optionalFieldOf("lobby").forGetter((v0) -> {
            return v0.m5343f();
        }), InterfaceC0978rl.f5149T.fieldOf("gameModeData").forGetter((v0) -> {
            return v0.m5344b();
        }), Codec.BOOL.optionalFieldOf("inRotation", true).forGetter((v0) -> {
            return v0.m5345bJ();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0977rk(v1, v2, v3, v4, v5, v6);
        });
    });

    public C0977rk(String str, String str2, List<C0980rn> list, Optional<C0805oX> optional, InterfaceC0978rl interfaceC0978rl, boolean z) {
        this.f5141cl = str;
        this.f5142cm = str2;
        this.f5143aH = list;
        this.f5144c = optional;
        this.f5145a = interfaceC0978rl;
        this.f5146gJ = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0977rk.class), C0977rk.class, "gameName;mapName;teams;lobby;gameModeData;inRotation", "FIELD:Lcom/boehmod/blockfront/rk;->cl:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->cm:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->aH:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rk;->c:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rk;->a:Lcom/boehmod/blockfront/rl;", "FIELD:Lcom/boehmod/blockfront/rk;->gJ:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0977rk.class), C0977rk.class, "gameName;mapName;teams;lobby;gameModeData;inRotation", "FIELD:Lcom/boehmod/blockfront/rk;->cl:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->cm:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->aH:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rk;->c:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rk;->a:Lcom/boehmod/blockfront/rl;", "FIELD:Lcom/boehmod/blockfront/rk;->gJ:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0977rk.class, Object.class), C0977rk.class, "gameName;mapName;teams;lobby;gameModeData;inRotation", "FIELD:Lcom/boehmod/blockfront/rk;->cl:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->cm:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->aH:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rk;->c:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rk;->a:Lcom/boehmod/blockfront/rl;", "FIELD:Lcom/boehmod/blockfront/rk;->gJ:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: aa */
    public String m5340aa() {
        return this.f5141cl;
    }

    /* JADX INFO: renamed from: ab */
    public String m5341ab() {
        return this.f5142cm;
    }

    /* JADX INFO: renamed from: P */
    public List<C0980rn> m5342P() {
        return this.f5143aH;
    }

    /* JADX INFO: renamed from: f */
    public Optional<C0805oX> m5343f() {
        return this.f5144c;
    }

    /* JADX INFO: renamed from: b */
    public InterfaceC0978rl m5344b() {
        return this.f5145a;
    }

    /* JADX INFO: renamed from: bJ */
    public boolean m5345bJ() {
        return this.f5146gJ;
    }
}
