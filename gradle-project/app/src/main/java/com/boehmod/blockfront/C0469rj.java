package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rj.class */
public final class C0469rj extends Record {
    private final int po;

    @NotNull
    private final String ch;

    @NotNull
    private final String ci;

    @NotNull
    private final String cj;
    private final boolean gE;

    @NotNull
    private final ResourceLocation eT;
    private final boolean gF;
    private final boolean gG;
    private final boolean gH;
    private final boolean gI;

    @NotNull
    private final String ck;

    @NotNull
    public static final Codec<C0469rj> R = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("index").forGetter((v0) -> {
            return v0.bz();
        }), Codec.STRING.fieldOf("key").forGetter((v0) -> {
            return v0.T();
        }), Codec.STRING.fieldOf("displayTitle").forGetter((v0) -> {
            return v0.X();
        }), Codec.STRING.fieldOf("description").forGetter((v0) -> {
            return v0.Y();
        }), Codec.BOOL.optionalFieldOf("botFriendly", true).forGetter((v0) -> {
            return v0.bE();
        }), ResourceLocation.CODEC.fieldOf("icon").forGetter((v0) -> {
            return v0.K();
        }), Codec.BOOL.optionalFieldOf("isDefault", false).forGetter((v0) -> {
            return v0.bF();
        }), Codec.BOOL.optionalFieldOf("seeMedicCallouts", false).forGetter((v0) -> {
            return v0.bG();
        }), Codec.BOOL.optionalFieldOf("canWarCry", false).forGetter((v0) -> {
            return v0.bH();
        }), Codec.BOOL.optionalFieldOf("highlightInScoreboard", false).forGetter((v0) -> {
            return v0.bI();
        }), Codec.STRING.optionalFieldOf("minRankRequired", "recruit").forGetter((v0) -> {
            return v0.Z();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11) -> {
            return new C0469rj(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11);
        });
    });

    public C0469rj(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull ResourceLocation resourceLocation, boolean z2, boolean z3, boolean z4, boolean z5, @NotNull String str4) {
        this.po = i;
        this.ch = str;
        this.ci = str2;
        this.cj = str3;
        this.gE = z;
        this.eT = resourceLocation;
        this.gF = z2;
        this.gG = z3;
        this.gH = z4;
        this.gI = z5;
        this.ck = str4;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0469rj.class), C0469rj.class, "index;key;displayTitle;description;botFriendly;icon;isDefault;seeMedicCallouts;canWarCry;highlightInScoreboard;minRankRequired", "FIELD:Lcom/boehmod/blockfront/rj;->po:I", "FIELD:Lcom/boehmod/blockfront/rj;->ch:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->ci:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->cj:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->gE:Z", "FIELD:Lcom/boehmod/blockfront/rj;->eT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rj;->gF:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gG:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gH:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gI:Z", "FIELD:Lcom/boehmod/blockfront/rj;->ck:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0469rj.class), C0469rj.class, "index;key;displayTitle;description;botFriendly;icon;isDefault;seeMedicCallouts;canWarCry;highlightInScoreboard;minRankRequired", "FIELD:Lcom/boehmod/blockfront/rj;->po:I", "FIELD:Lcom/boehmod/blockfront/rj;->ch:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->ci:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->cj:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->gE:Z", "FIELD:Lcom/boehmod/blockfront/rj;->eT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rj;->gF:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gG:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gH:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gI:Z", "FIELD:Lcom/boehmod/blockfront/rj;->ck:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0469rj.class, Object.class), C0469rj.class, "index;key;displayTitle;description;botFriendly;icon;isDefault;seeMedicCallouts;canWarCry;highlightInScoreboard;minRankRequired", "FIELD:Lcom/boehmod/blockfront/rj;->po:I", "FIELD:Lcom/boehmod/blockfront/rj;->ch:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->ci:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->cj:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rj;->gE:Z", "FIELD:Lcom/boehmod/blockfront/rj;->eT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rj;->gF:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gG:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gH:Z", "FIELD:Lcom/boehmod/blockfront/rj;->gI:Z", "FIELD:Lcom/boehmod/blockfront/rj;->ck:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int bz() {
        return this.po;
    }

    @NotNull
    public String T() {
        return this.ch;
    }

    @NotNull
    public String X() {
        return this.ci;
    }

    @NotNull
    public String Y() {
        return this.cj;
    }

    public boolean bE() {
        return this.gE;
    }

    @NotNull
    public ResourceLocation K() {
        return this.eT;
    }

    public boolean bF() {
        return this.gF;
    }

    public boolean bG() {
        return this.gG;
    }

    public boolean bH() {
        return this.gH;
    }

    public boolean bI() {
        return this.gI;
    }

    @NotNull
    public String Z() {
        return this.ck;
    }
}
