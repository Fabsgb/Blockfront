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

/* JADX INFO: renamed from: com.boehmod.blockfront.rl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl.class */
public interface InterfaceC0978rl {

    /* JADX INFO: renamed from: P */
    @NotNull
    public static final Map<String, MapCodec<? extends InterfaceC0978rl>> f5148P = Map.of("boot", a.f5156S, "dom", b.f5162T, "tdm", h.f5188Y, "ffa", c.f5165U, "gg", d.f5167V, "inf", e.f5172W, "of", f.f5177X, "ttt", i.f5191Z);

    /* JADX INFO: renamed from: T */
    @NotNull
    public static final Codec<InterfaceC0978rl> f5149T = Codec.STRING.dispatch("gameType", (v0) -> {
        return v0.mo5347ac();
    }, str -> {
        return f5148P.getOrDefault(str, null);
    });

    /* JADX INFO: renamed from: ac */
    String mo5347ac();

    MapCodec<? extends InterfaceC0978rl> codec();

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$a.class */
    public static final class a extends Record implements InterfaceC0978rl {

        /* JADX INFO: renamed from: g */
        private final C0805oX f5150g;

        /* JADX INFO: renamed from: aI */
        private final List<C0865pe> f5151aI;

        /* JADX INFO: renamed from: aJ */
        private final List<C0869pi> f5152aJ;

        /* JADX INFO: renamed from: aK */
        private final List<C0873pm> f5153aK;

        /* JADX INFO: renamed from: aL */
        private final List<C0871pk> f5154aL;

        /* JADX INFO: renamed from: d */
        private final Optional<C0709mh> f5155d;

        /* JADX INFO: renamed from: S */
        @NotNull
        public static final MapCodec<a> f5156S = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0805oX.f4422s.fieldOf("finishPoint").forGetter((v0) -> {
                return v0.m5349f();
            }), C0865pe.f4534v.listOf().optionalFieldOf("npcSpawns", List.of()).forGetter((v0) -> {
                return v0.m5350Q();
            }), C0869pi.f4564x.listOf().optionalFieldOf("soundPoints", List.of()).forGetter((v0) -> {
                return v0.m5351R();
            }), C0873pm.f4583B.listOf().optionalFieldOf("weaponPoints", List.of()).forGetter((v0) -> {
                return v0.m5352S();
            }), C0871pk.f4574z.listOf().optionalFieldOf("texturePoints", List.of()).forGetter((v0) -> {
                return v0.m5353T();
            }), C0709mh.f3780p.optionalFieldOf("introSequence").forGetter((v0) -> {
                return v0.m5354g();
            })).apply(instance, a::new);
        });

        public a(C0805oX c0805oX, List<C0865pe> list, List<C0869pi> list2, List<C0873pm> list3, List<C0871pk> list4, Optional<C0709mh> optional) {
            this.f5150g = c0805oX;
            this.f5151aI = list;
            this.f5152aJ = list2;
            this.f5153aK = list3;
            this.f5154aL = list4;
            this.f5155d = optional;
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

        /* JADX INFO: renamed from: f */
        public C0805oX m5349f() {
            return this.f5150g;
        }

        /* JADX INFO: renamed from: Q */
        public List<C0865pe> m5350Q() {
            return this.f5151aI;
        }

        /* JADX INFO: renamed from: R */
        public List<C0869pi> m5351R() {
            return this.f5152aJ;
        }

        /* JADX INFO: renamed from: S */
        public List<C0873pm> m5352S() {
            return this.f5153aK;
        }

        /* JADX INFO: renamed from: T */
        public List<C0871pk> m5353T() {
            return this.f5154aL;
        }

        /* JADX INFO: renamed from: g */
        public Optional<C0709mh> m5354g() {
            return this.f5155d;
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        /* JADX INFO: renamed from: ac */
        public String mo5347ac() {
            return "boot";
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        public MapCodec<a> codec() {
            return f5156S;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$b.class */
    public static final class b extends Record implements InterfaceC0978rl {

        /* JADX INFO: renamed from: aM */
        private final List<C0975ri> f5157aM;

        /* JADX INFO: renamed from: aN */
        private final List<C0804oW> f5158aN;

        /* JADX INFO: renamed from: aO */
        private final List<C0872pl> f5159aO;

        /* JADX INFO: renamed from: e */
        private final Optional<C0709mh> f5160e;

        /* JADX INFO: renamed from: f */
        private final Optional<C0709mh> f5161f;

        /* JADX INFO: renamed from: T */
        @NotNull
        public static final MapCodec<b> f5162T = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0975ri.f5128Q.listOf().optionalFieldOf("capturePoints", List.of()).forGetter((v0) -> {
                return v0.m5356U();
            }), C0804oW.f4417r.listOf().optionalFieldOf("ammoPoints", List.of()).forGetter((v0) -> {
                return v0.m5357V();
            }), C0872pl.f4577A.listOf().optionalFieldOf("vehiclePoints", List.of()).forGetter((v0) -> {
                return v0.m5358W();
            }), C0709mh.f3780p.optionalFieldOf("introSequence").forGetter((v0) -> {
                return v0.m5359g();
            }), C0709mh.f3780p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.m5360h();
            })).apply(instance, b::new);
        });

        public b(List<C0975ri> list, List<C0804oW> list2, List<C0872pl> list3, Optional<C0709mh> optional, Optional<C0709mh> optional2) {
            this.f5157aM = list;
            this.f5158aN = list2;
            this.f5159aO = list3;
            this.f5160e = optional;
            this.f5161f = optional2;
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

        /* JADX INFO: renamed from: U */
        public List<C0975ri> m5356U() {
            return this.f5157aM;
        }

        /* JADX INFO: renamed from: V */
        public List<C0804oW> m5357V() {
            return this.f5158aN;
        }

        /* JADX INFO: renamed from: W */
        public List<C0872pl> m5358W() {
            return this.f5159aO;
        }

        /* JADX INFO: renamed from: g */
        public Optional<C0709mh> m5359g() {
            return this.f5160e;
        }

        /* JADX INFO: renamed from: h */
        public Optional<C0709mh> m5360h() {
            return this.f5161f;
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        /* JADX INFO: renamed from: ac */
        public String mo5347ac() {
            return "dom";
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        public MapCodec<b> codec() {
            return f5162T;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$h */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$h.class */
    public static final class h extends Record implements InterfaceC0978rl {

        /* JADX INFO: renamed from: l */
        private final Optional<C0709mh> f5187l;

        /* JADX INFO: renamed from: Y */
        @NotNull
        public static final MapCodec<h> f5188Y = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0709mh.f3780p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.m5388h();
            })).apply(instance, h::new);
        });

        public h(Optional<C0709mh> optional) {
            this.f5187l = optional;
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

        /* JADX INFO: renamed from: h */
        public Optional<C0709mh> m5388h() {
            return this.f5187l;
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        /* JADX INFO: renamed from: ac */
        public String mo5347ac() {
            return "tdm";
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        public MapCodec<h> codec() {
            return f5188Y;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$c.class */
    public static final class c extends Record implements InterfaceC0978rl {

        /* JADX INFO: renamed from: aP */
        private final List<C0805oX> f5163aP;

        /* JADX INFO: renamed from: g */
        private final Optional<C0709mh> f5164g;

        /* JADX INFO: renamed from: U */
        @NotNull
        public static final MapCodec<c> f5165U = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0805oX.f4422s.listOf().optionalFieldOf("randomSpawns", List.of()).forGetter((v0) -> {
                return v0.m5362X();
            }), C0709mh.f3780p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.m5363h();
            })).apply(instance, c::new);
        });

        public c(List<C0805oX> list, Optional<C0709mh> optional) {
            this.f5163aP = list;
            this.f5164g = optional;
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

        /* JADX INFO: renamed from: X */
        public List<C0805oX> m5362X() {
            return this.f5163aP;
        }

        /* JADX INFO: renamed from: h */
        public Optional<C0709mh> m5363h() {
            return this.f5164g;
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        /* JADX INFO: renamed from: ac */
        public String mo5347ac() {
            return "ffa";
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        public MapCodec<c> codec() {
            return f5165U;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$d */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$d.class */
    public static final class d extends Record implements InterfaceC0978rl {

        /* JADX INFO: renamed from: h */
        private final Optional<C0709mh> f5166h;

        /* JADX INFO: renamed from: V */
        @NotNull
        public static final MapCodec<d> f5167V = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0709mh.f3780p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.m5365h();
            })).apply(instance, d::new);
        });

        public d(Optional<C0709mh> optional) {
            this.f5166h = optional;
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

        /* JADX INFO: renamed from: h */
        public Optional<C0709mh> m5365h() {
            return this.f5166h;
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        /* JADX INFO: renamed from: ac */
        public String mo5347ac() {
            return "gg";
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        public MapCodec<d> codec() {
            return f5167V;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$e */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$e.class */
    public static final class e extends Record implements InterfaceC0978rl {

        /* JADX INFO: renamed from: aQ */
        private final List<C0805oX> f5168aQ;

        /* JADX INFO: renamed from: aR */
        private final List<C1023sd> f5169aR;

        /* JADX INFO: renamed from: aS */
        private final List<C1022sc> f5170aS;

        /* JADX INFO: renamed from: aT */
        private final List<C0805oX> f5171aT;

        /* JADX INFO: renamed from: W */
        @NotNull
        public static final MapCodec<e> f5172W = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0805oX.f4422s.listOf().optionalFieldOf("randomSpawns", List.of()).forGetter((v0) -> {
                return v0.m5367X();
            }), C1023sd.f5430aa.listOf().optionalFieldOf("zombieZoneDoors", List.of()).forGetter((v0) -> {
                return v0.m5368Y();
            }), C1022sc.f5426Z.listOf().optionalFieldOf("zombieZones", List.of()).forGetter((v0) -> {
                return v0.m5369Z();
            }), C0805oX.f4422s.listOf().optionalFieldOf("vendorLocations", List.of()).forGetter((v0) -> {
                return v0.m5370aa();
            })).apply(instance, e::new);
        });

        public e(List<C0805oX> list, List<C1023sd> list2, List<C1022sc> list3, List<C0805oX> list4) {
            this.f5168aQ = list;
            this.f5169aR = list2;
            this.f5170aS = list3;
            this.f5171aT = list4;
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

        /* JADX INFO: renamed from: X */
        public List<C0805oX> m5367X() {
            return this.f5168aQ;
        }

        /* JADX INFO: renamed from: Y */
        public List<C1023sd> m5368Y() {
            return this.f5169aR;
        }

        /* JADX INFO: renamed from: Z */
        public List<C1022sc> m5369Z() {
            return this.f5170aS;
        }

        /* JADX INFO: renamed from: aa */
        public List<C0805oX> m5370aa() {
            return this.f5171aT;
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        /* JADX INFO: renamed from: ac */
        public String mo5347ac() {
            return "inf";
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        public MapCodec<e> codec() {
            return f5172W;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$i */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$i.class */
    public static final class i extends Record implements InterfaceC0978rl {

        /* JADX INFO: renamed from: aX */
        private final List<C0805oX> f5189aX;

        /* JADX INFO: renamed from: aY */
        private final List<C0805oX> f5190aY;

        /* JADX INFO: renamed from: Z */
        @NotNull
        public static final MapCodec<i> f5191Z = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(C0805oX.f4422s.listOf().optionalFieldOf("randomSpawns", List.of()).forGetter((v0) -> {
                return v0.m5390X();
            }), C0805oX.f4422s.listOf().optionalFieldOf("weaponSpawns", List.of()).forGetter((v0) -> {
                return v0.m5391ae();
            })).apply(instance, i::new);
        });

        public i(List<C0805oX> list, List<C0805oX> list2) {
            this.f5189aX = list;
            this.f5190aY = list2;
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

        /* JADX INFO: renamed from: X */
        public List<C0805oX> m5390X() {
            return this.f5189aX;
        }

        /* JADX INFO: renamed from: ae */
        public List<C0805oX> m5391ae() {
            return this.f5190aY;
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        /* JADX INFO: renamed from: ac */
        public String mo5347ac() {
            return "ttt";
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        public MapCodec<i> codec() {
            return f5191Z;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$g */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$g.class */
    public static final class g extends Record {

        /* JADX INFO: renamed from: h */
        private final C0805oX f5178h;

        /* JADX INFO: renamed from: co */
        private final String f5179co;

        /* JADX INFO: renamed from: aV */
        private final List<C0805oX> f5180aV;

        /* JADX INFO: renamed from: aW */
        private final List<C0805oX> f5181aW;

        /* JADX INFO: renamed from: i */
        private final C0805oX f5182i;

        /* JADX INFO: renamed from: c */
        private final C0806oY f5183c;

        /* JADX INFO: renamed from: d */
        private final C0806oY f5184d;

        /* JADX INFO: renamed from: k */
        private final Optional<AABB> f5185k;

        /* JADX INFO: renamed from: U */
        @NotNull
        public static final Codec<g> f5186U = RecordCodecBuilder.create(instance -> {
            return instance.group(C0805oX.f4422s.fieldOf("position").forGetter((v0) -> {
                return v0.m5377e();
            }), Codec.STRING.optionalFieldOf("title", "Unknown").forGetter((v0) -> {
                return v0.m5378U();
            }), C0805oX.f4422s.listOf().optionalFieldOf("attackerSpawns", List.of()).forGetter((v0) -> {
                return v0.m5379ac();
            }), C0805oX.f4422s.listOf().optionalFieldOf("defenderSpawns", List.of()).forGetter((v0) -> {
                return v0.m5380ad();
            }), C0805oX.f4422s.fieldOf("regroupPoint").forGetter((v0) -> {
                return v0.m5381g();
            }), C0806oY.f4425t.optionalFieldOf("attackerBoundary").xmap(optional -> {
                return (C0806oY) optional.orElseGet(C0806oY::new);
            }, (v0) -> {
                return Optional.of(v0);
            }).forGetter((v0) -> {
                return v0.m5382a();
            }), C0806oY.f4425t.optionalFieldOf("defenderBoundary").xmap(optional2 -> {
                return (C0806oY) optional2.orElseGet(C0806oY::new);
            }, (v0) -> {
                return Optional.of(v0);
            }).forGetter((v0) -> {
                return v0.m5383b();
            }), C0836pB.f4472E.optionalFieldOf("captureBox").forGetter((v0) -> {
                return v0.m5384e();
            })).apply(instance, g::new);
        });

        public g(C0805oX c0805oX, String str, List<C0805oX> list, List<C0805oX> list2, C0805oX c0805oX2, C0806oY c0806oY, C0806oY c0806oY2, Optional<AABB> optional) {
            this.f5178h = c0805oX;
            this.f5179co = str;
            this.f5180aV = list;
            this.f5181aW = list2;
            this.f5182i = c0805oX2;
            this.f5183c = c0806oY;
            this.f5184d = c0806oY2;
            this.f5185k = optional;
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

        /* JADX INFO: renamed from: e */
        public C0805oX m5377e() {
            return this.f5178h;
        }

        /* JADX INFO: renamed from: U */
        public String m5378U() {
            return this.f5179co;
        }

        /* JADX INFO: renamed from: ac */
        public List<C0805oX> m5379ac() {
            return this.f5180aV;
        }

        /* JADX INFO: renamed from: ad */
        public List<C0805oX> m5380ad() {
            return this.f5181aW;
        }

        /* JADX INFO: renamed from: g */
        public C0805oX m5381g() {
            return this.f5182i;
        }

        /* JADX INFO: renamed from: a */
        public C0806oY m5382a() {
            return this.f5183c;
        }

        /* JADX INFO: renamed from: b */
        public C0806oY m5383b() {
            return this.f5184d;
        }

        /* JADX INFO: renamed from: e */
        public Optional<AABB> m5384e() {
            return this.f5185k;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.rl$f */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rl$f.class */
    public static final class f extends Record implements InterfaceC0978rl {

        /* JADX INFO: renamed from: aU */
        private final List<g> f5173aU;

        /* JADX INFO: renamed from: cn */
        private final String f5174cn;

        /* JADX INFO: renamed from: i */
        private final Optional<C0709mh> f5175i;

        /* JADX INFO: renamed from: j */
        private final Optional<C0709mh> f5176j;

        /* JADX INFO: renamed from: X */
        @NotNull
        public static final MapCodec<f> f5177X = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(g.f5186U.listOf().optionalFieldOf("objectives", List.of()).forGetter((v0) -> {
                return v0.m5372ab();
            }), Codec.STRING.optionalFieldOf("attackerTeam", "allies").forGetter((v0) -> {
                return v0.m5373ad();
            }), C0709mh.f3780p.optionalFieldOf("introSequence").forGetter((v0) -> {
                return v0.m5374g();
            }), C0709mh.f3780p.optionalFieldOf("outroSequence").forGetter((v0) -> {
                return v0.m5375h();
            })).apply(instance, f::new);
        });

        public f(List<g> list, String str, Optional<C0709mh> optional, Optional<C0709mh> optional2) {
            this.f5173aU = list;
            this.f5174cn = str;
            this.f5175i = optional;
            this.f5176j = optional2;
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

        /* JADX INFO: renamed from: ab */
        public List<g> m5372ab() {
            return this.f5173aU;
        }

        /* JADX INFO: renamed from: ad */
        public String m5373ad() {
            return this.f5174cn;
        }

        /* JADX INFO: renamed from: g */
        public Optional<C0709mh> m5374g() {
            return this.f5175i;
        }

        /* JADX INFO: renamed from: h */
        public Optional<C0709mh> m5375h() {
            return this.f5176j;
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        /* JADX INFO: renamed from: ac */
        public String mo5347ac() {
            return "of";
        }

        @Override // com.boehmod.blockfront.InterfaceC0978rl
        public MapCodec<f> codec() {
            return f5177X;
        }
    }
}
