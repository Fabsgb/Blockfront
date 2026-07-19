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

/* JADX INFO: renamed from: com.boehmod.blockfront.rl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl.class */
public interface InterfaceC0471rl {

    @NotNull
    public static final Map<String, MapCodec<? extends InterfaceC0471rl>> P = Map.of("boot", a.S, "dom", b.T, "tdm", h.Y, "ffa", c.U, "gg", d.V, "inf", e.W, "of", f.X, "ttt", i.Z);

    @NotNull
    public static final Codec<InterfaceC0471rl> T = Codec.STRING.dispatch("gameType", (v0) -> {
        return v0.ac();
    }, str -> {
        return P.getOrDefault(str, null);
    });

    String ac();

    MapCodec<? extends InterfaceC0471rl> codec();

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$a.class */
    public static final class a extends Record implements InterfaceC0471rl {
        private final oX g;
        private final List<C0410pe> aI;
        private final List<C0414pi> aJ;
        private final List<C0418pm> aK;
        private final List<C0416pk> aL;
        private final Optional<C0332mh> d;

        @NotNull
        public static final MapCodec<a> S = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(oX.s.fieldOf("finishPoint").forGetter((v0) -> {
                return v0.f();
            }), C0410pe.v.listOf().optionalFieldOf("npcSpawns", List.of()).forGetter((v0) -> {
                return v0.Q();
            }), C0414pi.x.listOf().optionalFieldOf("soundPoints", List.of()).forGetter((v0) -> {
                return v0.R();
            }), C0418pm.B.listOf().optionalFieldOf("weaponPoints", List.of()).forGetter((v0) -> {
                return v0.S();
            }), C0416pk.z.listOf().optionalFieldOf("texturePoints", List.of()).forGetter((v0) -> {
                return v0.T();
            }), C0332mh.p.optionalFieldOf("introSequence").forGetter((v0) -> {
                return v0.g();
            })).apply(instance, a::new);
        });

        public a(oX oXVar, List<C0410pe> list, List<C0414pi> list2, List<C0418pm> list3, List<C0416pk> list4, Optional<C0332mh> optional) {
            this.g = oXVar;
            this.aI = list;
            this.aJ = list2;
            this.aK = list3;
            this.aL = list4;
            this.d = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "finishPoint;npcSpawns;soundPoints;weaponPoints;texturePoints;introSequence", "FIELD:Lcom/boehmod/blockfront/rl$a;->g:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aI:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aJ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aK:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aL:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->d:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "finishPoint;npcSpawns;soundPoints;weaponPoints;texturePoints;introSequence", "FIELD:Lcom/boehmod/blockfront/rl$a;->g:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aI:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aJ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aK:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aL:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->d:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "finishPoint;npcSpawns;soundPoints;weaponPoints;texturePoints;introSequence", "FIELD:Lcom/boehmod/blockfront/rl$a;->g:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aI:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aJ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aK:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->aL:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$a;->d:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public oX f() {
            return this.g;
        }

        public List<C0410pe> Q() {
            return this.aI;
        }

        public List<C0414pi> R() {
            return this.aJ;
        }

        public List<C0418pm> S() {
            return this.aK;
        }

        public List<C0416pk> T() {
            return this.aL;
        }

        public Optional<C0332mh> g() {
            return this.d;
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public String ac() {
            return "boot";
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public MapCodec<a> codec() {
            return S;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$b.class */
    public static final class b extends Record implements InterfaceC0471rl {
        private final List<C0468ri> aM;
        private final List<oW> aN;
        private final List<C0417pl> aO;
        private final Optional<C0332mh> e;
        private final Optional<C0332mh> f;

        @NotNull
        public static final MapCodec<b> T = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0468ri.Q.listOf().optionalFieldOf("capturePoints", List.of()).forGetter((v0) -> {
                return v0.U();
            }), oW.r.listOf().optionalFieldOf("ammoPoints", List.of()).forGetter((v0) -> {
                return v0.V();
            }), C0417pl.A.listOf().optionalFieldOf("vehiclePoints", List.of()).forGetter((v0) -> {
                return v0.W();
            }), C0332mh.p.optionalFieldOf("introSequence").forGetter((v0) -> {
                return v0.g();
            }), C0332mh.p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.h();
            })).apply(instance, b::new);
        });

        public b(List<C0468ri> list, List<oW> list2, List<C0417pl> list3, Optional<C0332mh> optional, Optional<C0332mh> optional2) {
            this.aM = list;
            this.aN = list2;
            this.aO = list3;
            this.e = optional;
            this.f = optional2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "capturePoints;ammoPoints;vehiclePoints;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$b;->aM:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$b;->aN:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$b;->aO:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$b;->e:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rl$b;->f:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "capturePoints;ammoPoints;vehiclePoints;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$b;->aM:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$b;->aN:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$b;->aO:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$b;->e:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rl$b;->f:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "capturePoints;ammoPoints;vehiclePoints;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$b;->aM:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$b;->aN:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$b;->aO:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$b;->e:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rl$b;->f:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public List<C0468ri> U() {
            return this.aM;
        }

        public List<oW> V() {
            return this.aN;
        }

        public List<C0417pl> W() {
            return this.aO;
        }

        public Optional<C0332mh> g() {
            return this.e;
        }

        public Optional<C0332mh> h() {
            return this.f;
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public String ac() {
            return "dom";
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public MapCodec<b> codec() {
            return T;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$h */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$h.class */
    public static final class h extends Record implements InterfaceC0471rl {
        private final Optional<C0332mh> l;

        @NotNull
        public static final MapCodec<h> Y = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0332mh.p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.h();
            })).apply(instance, h::new);
        });

        public h(Optional<C0332mh> optional) {
            this.l = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, h.class), h.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$h;->l:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, h.class), h.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$h;->l:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, h.class, Object.class), h.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$h;->l:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Optional<C0332mh> h() {
            return this.l;
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public String ac() {
            return "tdm";
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public MapCodec<h> codec() {
            return Y;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$c.class */
    public static final class c extends Record implements InterfaceC0471rl {
        private final List<oX> aP;
        private final Optional<C0332mh> g;

        @NotNull
        public static final MapCodec<c> U = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(oX.s.listOf().optionalFieldOf("randomSpawns", List.of()).forGetter((v0) -> {
                return v0.X();
            }), C0332mh.p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.h();
            })).apply(instance, c::new);
        });

        public c(List<oX> list, Optional<C0332mh> optional) {
            this.aP = list;
            this.g = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "randomSpawns;outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$c;->aP:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$c;->g:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "randomSpawns;outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$c;->aP:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$c;->g:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "randomSpawns;outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$c;->aP:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$c;->g:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public List<oX> X() {
            return this.aP;
        }

        public Optional<C0332mh> h() {
            return this.g;
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public String ac() {
            return "ffa";
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public MapCodec<c> codec() {
            return U;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$d */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$d.class */
    public static final class d extends Record implements InterfaceC0471rl {
        private final Optional<C0332mh> h;

        @NotNull
        public static final MapCodec<d> V = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0332mh.p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.h();
            })).apply(instance, d::new);
        });

        public d(Optional<C0332mh> optional) {
            this.h = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$d;->h:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$d;->h:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$d;->h:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Optional<C0332mh> h() {
            return this.h;
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public String ac() {
            return "gg";
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public MapCodec<d> codec() {
            return V;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$e */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$e.class */
    public static final class e extends Record implements InterfaceC0471rl {
        private final List<oX> aQ;
        private final List<C0490sd> aR;
        private final List<C0489sc> aS;
        private final List<oX> aT;

        @NotNull
        public static final MapCodec<e> W = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(oX.s.listOf().optionalFieldOf("randomSpawns", List.of()).forGetter((v0) -> {
                return v0.X();
            }), C0490sd.aa.listOf().optionalFieldOf("zombieZoneDoors", List.of()).forGetter((v0) -> {
                return v0.Y();
            }), C0489sc.Z.listOf().optionalFieldOf("zombieZones", List.of()).forGetter((v0) -> {
                return v0.Z();
            }), oX.s.listOf().optionalFieldOf("vendorLocations", List.of()).forGetter((v0) -> {
                return v0.aa();
            })).apply(instance, e::new);
        });

        public e(List<oX> list, List<C0490sd> list2, List<C0489sc> list3, List<oX> list4) {
            this.aQ = list;
            this.aR = list2;
            this.aS = list3;
            this.aT = list4;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, e.class), e.class, "randomSpawns;zombieZoneDoors;zombieZones;vendorLocations", "FIELD:Lcom/boehmod/blockfront/rl$e;->aQ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$e;->aR:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$e;->aS:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$e;->aT:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, e.class), e.class, "randomSpawns;zombieZoneDoors;zombieZones;vendorLocations", "FIELD:Lcom/boehmod/blockfront/rl$e;->aQ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$e;->aR:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$e;->aS:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$e;->aT:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, e.class, Object.class), e.class, "randomSpawns;zombieZoneDoors;zombieZones;vendorLocations", "FIELD:Lcom/boehmod/blockfront/rl$e;->aQ:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$e;->aR:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$e;->aS:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$e;->aT:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public List<oX> X() {
            return this.aQ;
        }

        public List<C0490sd> Y() {
            return this.aR;
        }

        public List<C0489sc> Z() {
            return this.aS;
        }

        public List<oX> aa() {
            return this.aT;
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public String ac() {
            return "inf";
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public MapCodec<e> codec() {
            return W;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$i */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$i.class */
    public static final class i extends Record implements InterfaceC0471rl {
        private final List<oX> aX;
        private final List<oX> aY;

        @NotNull
        public static final MapCodec<i> Z = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(oX.s.listOf().optionalFieldOf("randomSpawns", List.of()).forGetter((v0) -> {
                return v0.X();
            }), oX.s.listOf().optionalFieldOf("weaponSpawns", List.of()).forGetter((v0) -> {
                return v0.ae();
            })).apply(instance, i::new);
        });

        public i(List<oX> list, List<oX> list2) {
            this.aX = list;
            this.aY = list2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, i.class), i.class, "randomSpawns;weaponSpawns", "FIELD:Lcom/boehmod/blockfront/rl$i;->aX:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$i;->aY:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, i.class), i.class, "randomSpawns;weaponSpawns", "FIELD:Lcom/boehmod/blockfront/rl$i;->aX:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$i;->aY:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, i.class, Object.class), i.class, "randomSpawns;weaponSpawns", "FIELD:Lcom/boehmod/blockfront/rl$i;->aX:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$i;->aY:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public List<oX> X() {
            return this.aX;
        }

        public List<oX> ae() {
            return this.aY;
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public String ac() {
            return "ttt";
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public MapCodec<i> codec() {
            return Z;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$g */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$g.class */
    public static final class g extends Record {
        private final oX h;
        private final String co;
        private final List<oX> aV;
        private final List<oX> aW;
        private final oX i;
        private final oY c;
        private final oY d;
        private final Optional<AABB> k;

        @NotNull
        public static final Codec<g> U = RecordCodecBuilder.create(instance -> {
            return instance.group(oX.s.fieldOf("position").forGetter((v0) -> {
                return v0.e();
            }), Codec.STRING.optionalFieldOf("title", "Unknown").forGetter((v0) -> {
                return v0.U();
            }), oX.s.listOf().optionalFieldOf("attackerSpawns", List.of()).forGetter((v0) -> {
                return v0.ac();
            }), oX.s.listOf().optionalFieldOf("defenderSpawns", List.of()).forGetter((v0) -> {
                return v0.ad();
            }), oX.s.fieldOf("regroupPoint").forGetter((v0) -> {
                return v0.g();
            }), oY.t.optionalFieldOf("attackerBoundary").xmap(optional -> {
                return (oY) optional.orElseGet(oY::new);
            }, (v0) -> {
                return Optional.of(v0);
            }).forGetter((v0) -> {
                return v0.a();
            }), oY.t.optionalFieldOf("defenderBoundary").xmap(optional2 -> {
                return (oY) optional2.orElseGet(oY::new);
            }, (v0) -> {
                return Optional.of(v0);
            }).forGetter((v0) -> {
                return v0.b();
            }), pB.E.optionalFieldOf("captureBox").forGetter((v0) -> {
                return v0.m1068e();
            })).apply(instance, g::new);
        });

        public g(oX oXVar, String str, List<oX> list, List<oX> list2, oX oXVar2, oY oYVar, oY oYVar2, Optional<AABB> optional) {
            this.h = oXVar;
            this.co = str;
            this.aV = list;
            this.aW = list2;
            this.i = oXVar2;
            this.c = oYVar;
            this.d = oYVar2;
            this.k = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, g.class), g.class, "position;title;attackerSpawns;defenderSpawns;regroupPoint;attackerBoundary;defenderBoundary;captureBox", "FIELD:Lcom/boehmod/blockfront/rl$g;->h:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/rl$g;->co:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rl$g;->aV:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$g;->aW:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$g;->i:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/rl$g;->c:Lcom/boehmod/blockfront/oY;", "FIELD:Lcom/boehmod/blockfront/rl$g;->d:Lcom/boehmod/blockfront/oY;", "FIELD:Lcom/boehmod/blockfront/rl$g;->k:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, g.class), g.class, "position;title;attackerSpawns;defenderSpawns;regroupPoint;attackerBoundary;defenderBoundary;captureBox", "FIELD:Lcom/boehmod/blockfront/rl$g;->h:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/rl$g;->co:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rl$g;->aV:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$g;->aW:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$g;->i:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/rl$g;->c:Lcom/boehmod/blockfront/oY;", "FIELD:Lcom/boehmod/blockfront/rl$g;->d:Lcom/boehmod/blockfront/oY;", "FIELD:Lcom/boehmod/blockfront/rl$g;->k:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, g.class, Object.class), g.class, "position;title;attackerSpawns;defenderSpawns;regroupPoint;attackerBoundary;defenderBoundary;captureBox", "FIELD:Lcom/boehmod/blockfront/rl$g;->h:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/rl$g;->co:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rl$g;->aV:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$g;->aW:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$g;->i:Lcom/boehmod/blockfront/oX;", "FIELD:Lcom/boehmod/blockfront/rl$g;->c:Lcom/boehmod/blockfront/oY;", "FIELD:Lcom/boehmod/blockfront/rl$g;->d:Lcom/boehmod/blockfront/oY;", "FIELD:Lcom/boehmod/blockfront/rl$g;->k:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public oX e() {
            return this.h;
        }

        public String U() {
            return this.co;
        }

        public List<oX> ac() {
            return this.aV;
        }

        public List<oX> ad() {
            return this.aW;
        }

        public oX g() {
            return this.i;
        }

        public oY a() {
            return this.c;
        }

        public oY b() {
            return this.d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public Optional<AABB> m1068e() {
            return this.k;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$f */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$f.class */
    public static final class f extends Record implements InterfaceC0471rl {
        private final List<g> aU;
        private final String cn;
        private final Optional<C0332mh> i;
        private final Optional<C0332mh> j;

        @NotNull
        public static final MapCodec<f> X = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(g.U.listOf().optionalFieldOf("objectives", List.of()).forGetter((v0) -> {
                return v0.ab();
            }), Codec.STRING.optionalFieldOf("attackerTeam", "allies").forGetter((v0) -> {
                return v0.ad();
            }), C0332mh.p.optionalFieldOf("introSequence").forGetter((v0) -> {
                return v0.g();
            }), C0332mh.p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.h();
            })).apply(instance, f::new);
        });

        public f(List<g> list, String str, Optional<C0332mh> optional, Optional<C0332mh> optional2) {
            this.aU = list;
            this.cn = str;
            this.i = optional;
            this.j = optional2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, f.class), f.class, "objectives;attackerTeam;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$f;->aU:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$f;->cn:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rl$f;->i:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rl$f;->j:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, f.class), f.class, "objectives;attackerTeam;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$f;->aU:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$f;->cn:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rl$f;->i:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rl$f;->j:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, f.class, Object.class), f.class, "objectives;attackerTeam;introSequence;outroSequence", "FIELD:Lcom/boehmod/blockfront/rl$f;->aU:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/rl$f;->cn:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rl$f;->i:Ljava/util/Optional;", "FIELD:Lcom/boehmod/blockfront/rl$f;->j:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public List<g> ab() {
            return this.aU;
        }

        public String ad() {
            return this.cn;
        }

        public Optional<C0332mh> g() {
            return this.i;
        }

        public Optional<C0332mh> h() {
            return this.j;
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public String ac() {
            return "of";
        }

        @Override // com.boehmod.blockfront.InterfaceC0471rl
        public MapCodec<f> codec() {
            return X;
        }
    }
}
