package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rH.class */
public final class C0949rH extends Record {

    /* JADX INFO: renamed from: cv */
    private final String f5245cv;

    /* JADX INFO: renamed from: cw */
    private final String f5246cw;

    /* JADX INFO: renamed from: aO */
    private final List<C0952rK> f5247aO;

    /* JADX INFO: renamed from: c */
    private final Optional<C0881pt> f5248c;

    /* JADX INFO: renamed from: a */
    private final InterfaceC0950rI f5249a;

    /* JADX INFO: renamed from: hd */
    private final boolean f5250hd;

    /* JADX INFO: renamed from: S */
    @NotNull
    public static final Codec<C0949rH> f5251S = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("gameName").forGetter((v0) -> {
            return v0.m5216ah();
        }), Codec.STRING.optionalFieldOf("mapName", "").forGetter((v0) -> {
            return v0.m5217ai();
        }), C0952rK.f5311W.listOf().optionalFieldOf("teams", List.of()).forGetter((v0) -> {
            return v0.m5218R();
        }), C0881pt.f4825s.optionalFieldOf("lobby").forGetter((v0) -> {
            return v0.m5219f();
        }), InterfaceC0950rI.f5253T.fieldOf("gameModeData").forGetter((v0) -> {
            return v0.m5220b();
        }), Codec.BOOL.optionalFieldOf("inRotation", true).forGetter((v0) -> {
            return v0.m5221bT();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0949rH(v1, v2, v3, v4, v5, v6);
        });
    });

    public C0949rH(String str, String str2, List<C0952rK> list, Optional<C0881pt> optional, InterfaceC0950rI interfaceC0950rI, boolean z) {
        this.f5245cv = str;
        this.f5246cw = str2;
        this.f5247aO = list;
        this.f5248c = optional;
        this.f5249a = interfaceC0950rI;
        this.f5250hd = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0949rH.class), C0949rH.class, "gameName;mapName;teams;lobby;gameModeData;inRotation", "FIELD:Lcom/boehmod/blockfront/rH;->cv:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rH;->cw:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rH;->aO:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rH;->c:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rH;->a:Lcom/boehmod/blockfront/rI;", "FIELD:Lcom/boehmod/blockfront/rH;->hd:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0949rH.class), C0949rH.class, "gameName;mapName;teams;lobby;gameModeData;inRotation", "FIELD:Lcom/boehmod/blockfront/rH;->cv:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rH;->cw:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rH;->aO:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rH;->c:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rH;->a:Lcom/boehmod/blockfront/rI;", "FIELD:Lcom/boehmod/blockfront/rH;->hd:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0949rH.class, Object.class), C0949rH.class, "gameName;mapName;teams;lobby;gameModeData;inRotation", "FIELD:Lcom/boehmod/blockfront/rH;->cv:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rH;->cw:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rH;->aO:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rH;->c:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rH;->a:Lcom/boehmod/blockfront/rI;", "FIELD:Lcom/boehmod/blockfront/rH;->hd:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: ah */
    public String m5216ah() {
        return this.f5245cv;
    }

    /* JADX INFO: renamed from: ai */
    public String m5217ai() {
        return this.f5246cw;
    }

    /* JADX INFO: renamed from: R */
    public List<C0952rK> m5218R() {
        return this.f5247aO;
    }

    /* JADX INFO: renamed from: f */
    public Optional<C0881pt> m5219f() {
        return this.f5248c;
    }

    /* JADX INFO: renamed from: b */
    public InterfaceC0950rI m5220b() {
        return this.f5249a;
    }

    /* JADX INFO: renamed from: bT */
    public boolean m5221bT() {
        return this.f5250hd;
    }
}
