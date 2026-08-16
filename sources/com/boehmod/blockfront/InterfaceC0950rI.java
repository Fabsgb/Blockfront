package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rI.class */
public interface InterfaceC0950rI {

    /* JADX INFO: renamed from: P */
    @NotNull
    public static final Map<String, MapCodec<? extends InterfaceC0950rI>> f5252P = Map.of("boot", a.f5260T, "dom", b.f5266U, "tdm", h.f5292Z, "ffa", c.f5269V, "gg", d.f5271W, "inf", e.f5276X, "of", f.f5281Y, "ttt", i.f5295aa);

    /* JADX INFO: renamed from: T */
    @NotNull
    public static final Codec<InterfaceC0950rI> f5253T = Codec.STRING.dispatch("gameType", (v0) -> {
        return v0.mo5223aj();
    }, str -> {
        return f5252P.getOrDefault(str, null);
    });

    /* JADX INFO: renamed from: aj */
    String mo5223aj();

    MapCodec<? extends InterfaceC0950rI> codec();

    /* JADX INFO: renamed from: com.boehmod.blockfront.rI$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rI$a.class */
    public static final class a extends Record implements InterfaceC0950rI {

        /* JADX INFO: renamed from: g */
        private final C0881pt f5254g;

        /* JADX INFO: renamed from: aP */
        private final List<C0836pA> f5255aP;

        /* JADX INFO: renamed from: aQ */
        private final List<C0840pE> f5256aQ;

        /* JADX INFO: renamed from: aR */
        private final List<C0844pI> f5257aR;

        /* JADX INFO: renamed from: aS */
        private final List<C0842pG> f5258aS;

        /* JADX INFO: renamed from: d */
        private final Optional<C0680mD> f5259d;

        /* JADX INFO: renamed from: T */
        @NotNull
        public static final MapCodec<a> f5260T = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0881pt.f4825s.fieldOf("finishPoint").forGetter((v0) -> {
                return v0.m5225f();
            }), C0836pA.f4503v.listOf().optionalFieldOf("npcSpawns", List.of()).forGetter((v0) -> {
                return v0.m5226S();
            }), C0840pE.f4533x.listOf().optionalFieldOf("soundPoints", List.of()).forGetter((v0) -> {
                return v0.m5227T();
            }), C0844pI.f4552B.listOf().optionalFieldOf("weaponPoints", List.of()).forGetter((v0) -> {
                return v0.m5228U();
            }), C0842pG.f4543z.listOf().optionalFieldOf("texturePoints", List.of()).forGetter((v0) -> {
                return v0.m5229V();
            }), C0680mD.f3735p.optionalFieldOf("introSequence").forGetter((v0) -> {
                return v0.m5230g();
            })).apply(instance, a::new);
        });

        public a(C0881pt c0881pt, List<C0836pA> list, List<C0840pE> list2, List<C0844pI> list3, List<C0842pG> list4, Optional<C0680mD> optional) {
            this.f5254g = c0881pt;
            this.f5255aP = list;
            this.f5256aQ = list2;
            this.f5257aR = list3;
            this.f5258aS = list4;
            this.f5259d = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "finishPoint;npcSpawns;soundPoints;weaponPoints;texturePoints;introSequence", "FIELD:Lcom/boehmod/blockfront/rI$a;->g:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aP:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aQ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aR:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aS:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->d:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "finishPoint;npcSpawns;soundPoints;weaponPoints;texturePoints;introSequence", "FIELD:Lcom/boehmod/blockfront/rI$a;->g:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aP:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aQ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aR:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aS:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->d:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "finishPoint;npcSpawns;soundPoints;weaponPoints;texturePoints;introSequence", "FIELD:Lcom/boehmod/blockfront/rI$a;->g:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aP:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aQ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aR:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->aS:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$a;->d:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: f */
        public C0881pt m5225f() {
            return this.f5254g;
        }

        /* JADX INFO: renamed from: S */
        public List<C0836pA> m5226S() {
            return this.f5255aP;
        }

        /* JADX INFO: renamed from: T */
        public List<C0840pE> m5227T() {
            return this.f5256aQ;
        }

        /* JADX INFO: renamed from: U */
        public List<C0844pI> m5228U() {
            return this.f5257aR;
        }

        /* JADX INFO: renamed from: V */
        public List<C0842pG> m5229V() {
            return this.f5258aS;
        }

        /* JADX INFO: renamed from: g */
        public Optional<C0680mD> m5230g() {
            return this.f5259d;
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        /* JADX INFO: renamed from: aj */
        public String mo5223aj() {
            return "boot";
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        public MapCodec<a> codec() {
            return f5260T;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rI$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rI$b.class */
    public static final class b extends Record implements InterfaceC0950rI {

        /* JADX INFO: renamed from: aT */
        private final List<C0947rF> f5261aT;

        /* JADX INFO: renamed from: aU */
        private final List<C0880ps> f5262aU;

        /* JADX INFO: renamed from: aV */
        private final List<C0843pH> f5263aV;

        /* JADX INFO: renamed from: e */
        private final Optional<C0680mD> f5264e;

        /* JADX INFO: renamed from: f */
        private final Optional<C0680mD> f5265f;

        /* JADX INFO: renamed from: U */
        @NotNull
        public static final MapCodec<b> f5266U = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0947rF.f5232Q.listOf().optionalFieldOf("capturePoints", List.of()).forGetter((v0) -> {
                return v0.m5232W();
            }), C0880ps.f4820r.listOf().optionalFieldOf("ammoPoints", List.of()).forGetter((v0) -> {
                return v0.m5233X();
            }), C0843pH.f4546A.listOf().optionalFieldOf("vehiclePoints", List.of()).forGetter((v0) -> {
                return v0.m5234Y();
            }), C0680mD.f3735p.optionalFieldOf("introSequence").forGetter((v0) -> {
                return v0.m5235g();
            }), C0680mD.f3735p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.m5236h();
            })).apply(instance, b::new);
        });

        public b(List<C0947rF> list, List<C0880ps> list2, List<C0843pH> list3, Optional<C0680mD> optional, Optional<C0680mD> optional2) {
            this.f5261aT = list;
            this.f5262aU = list2;
            this.f5263aV = list3;
            this.f5264e = optional;
            this.f5265f = optional2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "capturePoints;ammoPoints;vehiclePoints;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$b;->aT:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$b;->aU:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$b;->aV:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$b;->e:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rI$b;->f:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "capturePoints;ammoPoints;vehiclePoints;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$b;->aT:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$b;->aU:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$b;->aV:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$b;->e:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rI$b;->f:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "capturePoints;ammoPoints;vehiclePoints;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$b;->aT:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$b;->aU:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$b;->aV:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$b;->e:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rI$b;->f:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: W */
        public List<C0947rF> m5232W() {
            return this.f5261aT;
        }

        /* JADX INFO: renamed from: X */
        public List<C0880ps> m5233X() {
            return this.f5262aU;
        }

        /* JADX INFO: renamed from: Y */
        public List<C0843pH> m5234Y() {
            return this.f5263aV;
        }

        /* JADX INFO: renamed from: g */
        public Optional<C0680mD> m5235g() {
            return this.f5264e;
        }

        /* JADX INFO: renamed from: h */
        public Optional<C0680mD> m5236h() {
            return this.f5265f;
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        /* JADX INFO: renamed from: aj */
        public String mo5223aj() {
            return "dom";
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        public MapCodec<b> codec() {
            return f5266U;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rI$h */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rI$h.class */
    public static final class h extends Record implements InterfaceC0950rI {

        /* JADX INFO: renamed from: l */
        private final Optional<C0680mD> f5291l;

        /* JADX INFO: renamed from: Z */
        @NotNull
        public static final MapCodec<h> f5292Z = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0680mD.f3735p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.m5264h();
            })).apply(instance, h::new);
        });

        public h(Optional<C0680mD> optional) {
            this.f5291l = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, h.class), h.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$h;->l:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, h.class), h.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$h;->l:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, h.class, Object.class), h.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$h;->l:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: h */
        public Optional<C0680mD> m5264h() {
            return this.f5291l;
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        /* JADX INFO: renamed from: aj */
        public String mo5223aj() {
            return "tdm";
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        public MapCodec<h> codec() {
            return f5292Z;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rI$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rI$c.class */
    public static final class c extends Record implements InterfaceC0950rI {

        /* JADX INFO: renamed from: aW */
        private final List<C0881pt> f5267aW;

        /* JADX INFO: renamed from: g */
        private final Optional<C0680mD> f5268g;

        /* JADX INFO: renamed from: V */
        @NotNull
        public static final MapCodec<c> f5269V = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0881pt.f4825s.listOf().optionalFieldOf("randomSpawns", List.of()).forGetter((v0) -> {
                return v0.m5238Z();
            }), C0680mD.f3735p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.m5239h();
            })).apply(instance, c::new);
        });

        public c(List<C0881pt> list, Optional<C0680mD> optional) {
            this.f5267aW = list;
            this.f5268g = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "randomSpawns;outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$c;->aW:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$c;->g:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "randomSpawns;outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$c;->aW:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$c;->g:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "randomSpawns;outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$c;->aW:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$c;->g:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: Z */
        public List<C0881pt> m5238Z() {
            return this.f5267aW;
        }

        /* JADX INFO: renamed from: h */
        public Optional<C0680mD> m5239h() {
            return this.f5268g;
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        /* JADX INFO: renamed from: aj */
        public String mo5223aj() {
            return "ffa";
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        public MapCodec<c> codec() {
            return f5269V;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rI$d */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rI$d.class */
    public static final class d extends Record implements InterfaceC0950rI {

        /* JADX INFO: renamed from: h */
        private final Optional<C0680mD> f5270h;

        /* JADX INFO: renamed from: W */
        @NotNull
        public static final MapCodec<d> f5271W = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0680mD.f3735p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.m5241h();
            })).apply(instance, d::new);
        });

        public d(Optional<C0680mD> optional) {
            this.f5270h = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$d;->h:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$d;->h:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$d;->h:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: h */
        public Optional<C0680mD> m5241h() {
            return this.f5270h;
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        /* JADX INFO: renamed from: aj */
        public String mo5223aj() {
            return "gg";
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        public MapCodec<d> codec() {
            return f5271W;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rI$e */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rI$e.class */
    public static final class e extends Record implements InterfaceC0950rI {

        /* JADX INFO: renamed from: aX */
        private final List<C0881pt> f5272aX;

        /* JADX INFO: renamed from: aY */
        private final List<C0995sA> f5273aY;

        /* JADX INFO: renamed from: aZ */
        private final List<C1047sz> f5274aZ;

        /* JADX INFO: renamed from: ba */
        private final List<C0881pt> f5275ba;

        /* JADX INFO: renamed from: X */
        @NotNull
        public static final MapCodec<e> f5276X = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0881pt.f4825s.listOf().optionalFieldOf("randomSpawns", List.of()).forGetter((v0) -> {
                return v0.m5243Z();
            }), C0995sA.f5478aa.listOf().optionalFieldOf("zombieZoneDoors", List.of()).forGetter((v0) -> {
                return v0.m5244aa();
            }), C1047sz.f5693Z.listOf().optionalFieldOf("zombieZones", List.of()).forGetter((v0) -> {
                return v0.m5245ab();
            }), C0881pt.f4825s.listOf().optionalFieldOf("vendorLocations", List.of()).forGetter((v0) -> {
                return v0.m5246ac();
            })).apply(instance, e::new);
        });

        public e(List<C0881pt> list, List<C0995sA> list2, List<C1047sz> list3, List<C0881pt> list4) {
            this.f5272aX = list;
            this.f5273aY = list2;
            this.f5274aZ = list3;
            this.f5275ba = list4;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, e.class), e.class, "randomSpawns;zombieZoneDoors;zombieZones;vendorLocations", "FIELD:Lcom/boehmod/blockfront/rI$e;->aX:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$e;->aY:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$e;->aZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$e;->ba:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, e.class), e.class, "randomSpawns;zombieZoneDoors;zombieZones;vendorLocations", "FIELD:Lcom/boehmod/blockfront/rI$e;->aX:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$e;->aY:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$e;->aZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$e;->ba:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, e.class, Object.class), e.class, "randomSpawns;zombieZoneDoors;zombieZones;vendorLocations", "FIELD:Lcom/boehmod/blockfront/rI$e;->aX:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$e;->aY:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$e;->aZ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$e;->ba:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: Z */
        public List<C0881pt> m5243Z() {
            return this.f5272aX;
        }

        /* JADX INFO: renamed from: aa */
        public List<C0995sA> m5244aa() {
            return this.f5273aY;
        }

        /* JADX INFO: renamed from: ab */
        public List<C1047sz> m5245ab() {
            return this.f5274aZ;
        }

        /* JADX INFO: renamed from: ac */
        public List<C0881pt> m5246ac() {
            return this.f5275ba;
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        /* JADX INFO: renamed from: aj */
        public String mo5223aj() {
            return "inf";
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        public MapCodec<e> codec() {
            return f5276X;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rI$i */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rI$i.class */
    public static final class i extends Record implements InterfaceC0950rI {

        /* JADX INFO: renamed from: be */
        private final List<C0881pt> f5293be;

        /* JADX INFO: renamed from: bf */
        private final List<C0881pt> f5294bf;

        /* JADX INFO: renamed from: aa */
        @NotNull
        public static final MapCodec<i> f5295aa = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0881pt.f4825s.listOf().optionalFieldOf("randomSpawns", List.of()).forGetter((v0) -> {
                return v0.m5266Z();
            }), C0881pt.f4825s.listOf().optionalFieldOf("weaponSpawns", List.of()).forGetter((v0) -> {
                return v0.m5267ag();
            })).apply(instance, i::new);
        });

        public i(List<C0881pt> list, List<C0881pt> list2) {
            this.f5293be = list;
            this.f5294bf = list2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, i.class), i.class, "randomSpawns;weaponSpawns", "FIELD:Lcom/boehmod/blockfront/rI$i;->be:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$i;->bf:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, i.class), i.class, "randomSpawns;weaponSpawns", "FIELD:Lcom/boehmod/blockfront/rI$i;->be:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$i;->bf:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, i.class, Object.class), i.class, "randomSpawns;weaponSpawns", "FIELD:Lcom/boehmod/blockfront/rI$i;->be:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$i;->bf:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: Z */
        public List<C0881pt> m5266Z() {
            return this.f5293be;
        }

        /* JADX INFO: renamed from: ag */
        public List<C0881pt> m5267ag() {
            return this.f5294bf;
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        /* JADX INFO: renamed from: aj */
        public String mo5223aj() {
            return "ttt";
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        public MapCodec<i> codec() {
            return f5295aa;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rI$g */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rI$g.class */
    public static final class g extends Record {

        /* JADX INFO: renamed from: h */
        private final C0881pt f5282h;

        /* JADX INFO: renamed from: cy */
        private final String f5283cy;

        /* JADX INFO: renamed from: bc */
        private final List<C0881pt> f5284bc;

        /* JADX INFO: renamed from: bd */
        private final List<C0881pt> f5285bd;

        /* JADX INFO: renamed from: i */
        private final C0881pt f5286i;

        /* JADX INFO: renamed from: c */
        private final C0882pu f5287c;

        /* JADX INFO: renamed from: d */
        private final C0882pu f5288d;

        /* JADX INFO: renamed from: k */
        private final Optional<AABB> f5289k;

        /* JADX INFO: renamed from: U */
        @NotNull
        public static final Codec<g> f5290U = RecordCodecBuilder.create(instance -> {
            return instance.group(C0881pt.f4825s.fieldOf("position").forGetter((v0) -> {
                return v0.m5253e();
            }), Codec.STRING.optionalFieldOf("title", "Unknown").forGetter((v0) -> {
                return v0.m5254ab();
            }), C0881pt.f4825s.listOf().optionalFieldOf("attackerSpawns", List.of()).forGetter((v0) -> {
                return v0.m5255ae();
            }), C0881pt.f4825s.listOf().optionalFieldOf("defenderSpawns", List.of()).forGetter((v0) -> {
                return v0.m5256af();
            }), C0881pt.f4825s.fieldOf("regroupPoint").forGetter((v0) -> {
                return v0.m5257g();
            }), C0882pu.f4828t.optionalFieldOf("attackerBoundary").xmap(optional -> {
                return (C0882pu) optional.orElseGet(C0882pu::new);
            }, (v0) -> {
                return Optional.of(v0);
            }).forGetter((v0) -> {
                return v0.m5258a();
            }), C0882pu.f4828t.optionalFieldOf("defenderBoundary").xmap(optional2 -> {
                return (C0882pu) optional2.orElseGet(C0882pu::new);
            }, (v0) -> {
                return Optional.of(v0);
            }).forGetter((v0) -> {
                return v0.m5259b();
            }), C0859pX.f4601E.optionalFieldOf("captureBox").forGetter((v0) -> {
                return v0.m5260e();
            })).apply(instance, g::new);
        });

        public g(C0881pt c0881pt, String str, List<C0881pt> list, List<C0881pt> list2, C0881pt c0881pt2, C0882pu c0882pu, C0882pu c0882pu2, Optional<AABB> optional) {
            this.f5282h = c0881pt;
            this.f5283cy = str;
            this.f5284bc = list;
            this.f5285bd = list2;
            this.f5286i = c0881pt2;
            this.f5287c = c0882pu;
            this.f5288d = c0882pu2;
            this.f5289k = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, g.class), g.class, "position;title;attackerSpawns;defenderSpawns;regroupPoint;attackerBoundary;defenderBoundary;captureBox", "FIELD:Lcom/boehmod/blockfront/rI$g;->h:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rI$g;->cy:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rI$g;->bc:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$g;->bd:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$g;->i:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rI$g;->c:Lcom/boehmod/blockfront/pu;", "FIELD:Lcom/boehmod/blockfront/rI$g;->d:Lcom/boehmod/blockfront/pu;", "FIELD:Lcom/boehmod/blockfront/rI$g;->k:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, g.class), g.class, "position;title;attackerSpawns;defenderSpawns;regroupPoint;attackerBoundary;defenderBoundary;captureBox", "FIELD:Lcom/boehmod/blockfront/rI$g;->h:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rI$g;->cy:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rI$g;->bc:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$g;->bd:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$g;->i:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rI$g;->c:Lcom/boehmod/blockfront/pu;", "FIELD:Lcom/boehmod/blockfront/rI$g;->d:Lcom/boehmod/blockfront/pu;", "FIELD:Lcom/boehmod/blockfront/rI$g;->k:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, g.class, Object.class), g.class, "position;title;attackerSpawns;defenderSpawns;regroupPoint;attackerBoundary;defenderBoundary;captureBox", "FIELD:Lcom/boehmod/blockfront/rI$g;->h:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rI$g;->cy:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rI$g;->bc:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$g;->bd:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$g;->i:Lcom/boehmod/blockfront/pt;", "FIELD:Lcom/boehmod/blockfront/rI$g;->c:Lcom/boehmod/blockfront/pu;", "FIELD:Lcom/boehmod/blockfront/rI$g;->d:Lcom/boehmod/blockfront/pu;", "FIELD:Lcom/boehmod/blockfront/rI$g;->k:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: e */
        public C0881pt m5253e() {
            return this.f5282h;
        }

        /* JADX INFO: renamed from: ab */
        public String m5254ab() {
            return this.f5283cy;
        }

        /* JADX INFO: renamed from: ae */
        public List<C0881pt> m5255ae() {
            return this.f5284bc;
        }

        /* JADX INFO: renamed from: af */
        public List<C0881pt> m5256af() {
            return this.f5285bd;
        }

        /* JADX INFO: renamed from: g */
        public C0881pt m5257g() {
            return this.f5286i;
        }

        /* JADX INFO: renamed from: a */
        public C0882pu m5258a() {
            return this.f5287c;
        }

        /* JADX INFO: renamed from: b */
        public C0882pu m5259b() {
            return this.f5288d;
        }

        /* JADX INFO: renamed from: e */
        public Optional<AABB> m5260e() {
            return this.f5289k;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rI$f */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rI$f.class */
    public static final class f extends Record implements InterfaceC0950rI {

        /* JADX INFO: renamed from: bb */
        private final List<g> f5277bb;

        /* JADX INFO: renamed from: cx */
        private final String f5278cx;

        /* JADX INFO: renamed from: i */
        private final Optional<C0680mD> f5279i;

        /* JADX INFO: renamed from: j */
        private final Optional<C0680mD> f5280j;

        /* JADX INFO: renamed from: Y */
        @NotNull
        public static final MapCodec<f> f5281Y = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(g.f5290U.listOf().optionalFieldOf("objectives", List.of()).forGetter((v0) -> {
                return v0.m5248ad();
            }), Codec.STRING.optionalFieldOf("attackerTeam", "allies").forGetter((v0) -> {
                return v0.m5249ak();
            }), C0680mD.f3735p.optionalFieldOf("introSequence").forGetter((v0) -> {
                return v0.m5250g();
            }), C0680mD.f3735p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.m5251h();
            })).apply(instance, f::new);
        });

        public f(List<g> list, String str, Optional<C0680mD> optional, Optional<C0680mD> optional2) {
            this.f5277bb = list;
            this.f5278cx = str;
            this.f5279i = optional;
            this.f5280j = optional2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, f.class), f.class, "objectives;attackerTeam;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$f;->bb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$f;->cx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rI$f;->i:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rI$f;->j:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, f.class), f.class, "objectives;attackerTeam;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$f;->bb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$f;->cx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rI$f;->i:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rI$f;->j:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, f.class, Object.class), f.class, "objectives;attackerTeam;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rI$f;->bb:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rI$f;->cx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rI$f;->i:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rI$f;->j:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: ad */
        public List<g> m5248ad() {
            return this.f5277bb;
        }

        /* JADX INFO: renamed from: ak */
        public String m5249ak() {
            return this.f5278cx;
        }

        /* JADX INFO: renamed from: g */
        public Optional<C0680mD> m5250g() {
            return this.f5279i;
        }

        /* JADX INFO: renamed from: h */
        public Optional<C0680mD> m5251h() {
            return this.f5280j;
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        /* JADX INFO: renamed from: aj */
        public String mo5223aj() {
            return "of";
        }

        @Override // com.boehmod.blockfront.InterfaceC0950rI
        public MapCodec<f> codec() {
            return f5281Y;
        }
    }
}
