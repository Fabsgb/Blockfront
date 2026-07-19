package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rk.class */
public final class C0470rk extends Record {
    private final String cl;
    private final String cm;
    private final List<C0473rn> aH;
    private final Optional<oX> c;
    private final InterfaceC0471rl a;
    private final boolean gJ;

    @NotNull
    public static final Codec<C0470rk> S = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("gameName").forGetter((v0) -> {
            return v0.aa();
        }), Codec.STRING.optionalFieldOf("mapName", "").forGetter((v0) -> {
            return v0.ab();
        }), C0473rn.W.listOf().optionalFieldOf("teams", List.of()).forGetter((v0) -> {
            return v0.P();
        }), oX.s.optionalFieldOf("lobby").forGetter((v0) -> {
            return v0.f();
        }), InterfaceC0471rl.T.fieldOf("gameModeData").forGetter((v0) -> {
            return v0.b();
        }), Codec.BOOL.optionalFieldOf("inRotation", true).forGetter((v0) -> {
            return v0.bJ();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0470rk(v1, v2, v3, v4, v5, v6);
        });
    });

    public C0470rk(String str, String str2, List<C0473rn> list, Optional<oX> optional, InterfaceC0471rl interfaceC0471rl, boolean z) {
        this.cl = str;
        this.cm = str2;
        this.aH = list;
        this.c = optional;
        this.a = interfaceC0471rl;
        this.gJ = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0470rk.class), C0470rk.class, "gameName;mapName;teams;lobby;gameModeData;inRotation", "FIELD:Lcom/boehmod/blockfront/rk;->cl:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->cm:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->aH:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rk;->c:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rk;->a:Lcom/boehmod/blockfront/rl;", "FIELD:Lcom/boehmod/blockfront/rk;->gJ:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0470rk.class), C0470rk.class, "gameName;mapName;teams;lobby;gameModeData;inRotation", "FIELD:Lcom/boehmod/blockfront/rk;->cl:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->cm:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->aH:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rk;->c:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rk;->a:Lcom/boehmod/blockfront/rl;", "FIELD:Lcom/boehmod/blockfront/rk;->gJ:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0470rk.class, Object.class), C0470rk.class, "gameName;mapName;teams;lobby;gameModeData;inRotation", "FIELD:Lcom/boehmod/blockfront/rk;->cl:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->cm:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rk;->aH:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rk;->c:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rk;->a:Lcom/boehmod/blockfront/rl;", "FIELD:Lcom/boehmod/blockfront/rk;->gJ:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public String aa() {
        return this.cl;
    }

    public String ab() {
        return this.cm;
    }

    public List<C0473rn> P() {
        return this.aH;
    }

    public Optional<oX> f() {
        return this.c;
    }

    public InterfaceC0471rl b() {
        return this.a;
    }

    public boolean bJ() {
        return this.gJ;
    }
}
