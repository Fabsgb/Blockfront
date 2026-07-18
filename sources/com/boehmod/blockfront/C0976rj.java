package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rj.class */
public final class C0976rj extends Record {

    /* JADX INFO: renamed from: po */
    private final int f5129po;

    /* JADX INFO: renamed from: ch */
    @NotNull
    private final String f5130ch;

    /* JADX INFO: renamed from: ci */
    @NotNull
    private final String f5131ci;

    /* JADX INFO: renamed from: cj */
    @NotNull
    private final String f5132cj;

    /* JADX INFO: renamed from: gE */
    private final boolean f5133gE;

    /* JADX INFO: renamed from: eT */
    @NotNull
    private final ResourceLocation f5134eT;

    /* JADX INFO: renamed from: gF */
    private final boolean f5135gF;

    /* JADX INFO: renamed from: gG */
    private final boolean f5136gG;

    /* JADX INFO: renamed from: gH */
    private final boolean f5137gH;

    /* JADX INFO: renamed from: gI */
    private final boolean f5138gI;

    /* JADX INFO: renamed from: ck */
    @NotNull
    private final String f5139ck;

    /* JADX INFO: renamed from: R */
    @NotNull
    public static final Codec<C0976rj> f5140R = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("index").forGetter((v0) -> {
            return v0.m5328bz();
        }), Codec.STRING.fieldOf("key").forGetter((v0) -> {
            return v0.m5329T();
        }), Codec.STRING.fieldOf("displayTitle").forGetter((v0) -> {
            return v0.m5330X();
        }), Codec.STRING.fieldOf("description").forGetter((v0) -> {
            return v0.m5331Y();
        }), Codec.BOOL.optionalFieldOf("botFriendly", true).forGetter((v0) -> {
            return v0.m5332bE();
        }), ResourceLocation.CODEC.fieldOf("icon").forGetter((v0) -> {
            return v0.m5333K();
        }), Codec.BOOL.optionalFieldOf("isDefault", false).forGetter((v0) -> {
            return v0.m5334bF();
        }), Codec.BOOL.optionalFieldOf("seeMedicCallouts", false).forGetter((v0) -> {
            return v0.m5335bG();
        }), Codec.BOOL.optionalFieldOf("canWarCry", false).forGetter((v0) -> {
            return v0.m5336bH();
        }), Codec.BOOL.optionalFieldOf("highlightInScoreboard", false).forGetter((v0) -> {
            return v0.m5337bI();
        }), Codec.STRING.optionalFieldOf("minRankRequired", "recruit").forGetter((v0) -> {
            return v0.m5338Z();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11) -> {
            return new C0976rj(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11);
        });
    });

    public C0976rj(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull ResourceLocation resourceLocation, boolean z2, boolean z3, boolean z4, boolean z5, @NotNull String str4) {
        this.f5129po = i;
        this.f5130ch = str;
        this.f5131ci = str2;
        this.f5132cj = str3;
        this.f5133gE = z;
        this.f5134eT = resourceLocation;
        this.f5135gF = z2;
        this.f5136gG = z3;
        this.f5137gH = z4;
        this.f5138gI = z5;
        this.f5139ck = str4;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0976rj.class), C0976rj.class, "index;key;displayTitle;description;botFriendly;icon;isDefault;seeMedicCallouts;canWarCry;highlightInScoreboard;minRankRequired", "FIELD:Lcom/boehmod/blockfront/rj;->po:I", "FIELD:Lcom/boehmod/blockfront/rj;->ch:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->ci:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->cj:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->gE:Z", "FIELD:Lcom/boehmod/blockfront/rj;->eT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rj;->gF:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gG:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gH:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gI:Z", "FIELD:Lcom/boehmod/blockfront/rj;->ck:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0976rj.class), C0976rj.class, "index;key;displayTitle;description;botFriendly;icon;isDefault;seeMedicCallouts;canWarCry;highlightInScoreboard;minRankRequired", "FIELD:Lcom/boehmod/blockfront/rj;->po:I", "FIELD:Lcom/boehmod/blockfront/rj;->ch:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->ci:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->cj:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->gE:Z", "FIELD:Lcom/boehmod/blockfront/rj;->eT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rj;->gF:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gG:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gH:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gI:Z", "FIELD:Lcom/boehmod/blockfront/rj;->ck:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0976rj.class, Object.class), C0976rj.class, "index;key;displayTitle;description;botFriendly;icon;isDefault;seeMedicCallouts;canWarCry;highlightInScoreboard;minRankRequired", "FIELD:Lcom/boehmod/blockfront/rj;->po:I", "FIELD:Lcom/boehmod/blockfront/rj;->ch:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->ci:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->cj:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->gE:Z", "FIELD:Lcom/boehmod/blockfront/rj;->eT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rj;->gF:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gG:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gH:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gI:Z", "FIELD:Lcom/boehmod/blockfront/rj;->ck:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bz */
    public int m5328bz() {
        return this.f5129po;
    }

    @NotNull
    /* JADX INFO: renamed from: T */
    public String m5329T() {
        return this.f5130ch;
    }

    @NotNull
    /* JADX INFO: renamed from: X */
    public String m5330X() {
        return this.f5131ci;
    }

    @NotNull
    /* JADX INFO: renamed from: Y */
    public String m5331Y() {
        return this.f5132cj;
    }

    /* JADX INFO: renamed from: bE */
    public boolean m5332bE() {
        return this.f5133gE;
    }

    @NotNull
    /* JADX INFO: renamed from: K */
    public ResourceLocation m5333K() {
        return this.f5134eT;
    }

    /* JADX INFO: renamed from: bF */
    public boolean m5334bF() {
        return this.f5135gF;
    }

    /* JADX INFO: renamed from: bG */
    public boolean m5335bG() {
        return this.f5136gG;
    }

    /* JADX INFO: renamed from: bH */
    public boolean m5336bH() {
        return this.f5137gH;
    }

    /* JADX INFO: renamed from: bI */
    public boolean m5337bI() {
        return this.f5138gI;
    }

    @NotNull
    /* JADX INFO: renamed from: Z */
    public String m5338Z() {
        return this.f5139ck;
    }
}
