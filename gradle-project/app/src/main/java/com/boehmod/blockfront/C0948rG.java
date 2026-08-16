package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rG.class */
public final class C0948rG extends Record {

    /* JADX INFO: renamed from: rn */
    private final int f5233rn;

    /* JADX INFO: renamed from: cr */
    @NotNull
    private final String f5234cr;

    /* JADX INFO: renamed from: cs */
    @NotNull
    private final String f5235cs;

    /* JADX INFO: renamed from: ct */
    @NotNull
    private final String f5236ct;

    /* JADX INFO: renamed from: gY */
    private final boolean f5237gY;

    /* JADX INFO: renamed from: eS */
    @NotNull
    private final ResourceLocation f5238eS;

    /* JADX INFO: renamed from: gZ */
    private final boolean f5239gZ;

    /* JADX INFO: renamed from: ha */
    private final boolean f5240ha;

    /* JADX INFO: renamed from: hb */
    private final boolean f5241hb;

    /* JADX INFO: renamed from: hc */
    private final boolean f5242hc;

    /* JADX INFO: renamed from: cu */
    @NotNull
    private final String f5243cu;

    /* JADX INFO: renamed from: R */
    @NotNull
    public static final Codec<C0948rG> f5244R = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("index").forGetter((v0) -> {
            return v0.m5204bO();
        }), Codec.STRING.fieldOf("key").forGetter((v0) -> {
            return v0.m5205aa();
        }), Codec.STRING.fieldOf("displayTitle").forGetter((v0) -> {
            return v0.m5206ae();
        }), Codec.STRING.fieldOf("description").forGetter((v0) -> {
            return v0.m5207af();
        }), Codec.BOOL.optionalFieldOf("botFriendly", true).forGetter((v0) -> {
            return v0.m5208bO();
        }), ResourceLocation.CODEC.fieldOf("icon").forGetter((v0) -> {
            return v0.m5209L();
        }), Codec.BOOL.optionalFieldOf("isDefault", false).forGetter((v0) -> {
            return v0.m5210bP();
        }), Codec.BOOL.optionalFieldOf("seeMedicCallouts", false).forGetter((v0) -> {
            return v0.m5211bQ();
        }), Codec.BOOL.optionalFieldOf("canWarCry", false).forGetter((v0) -> {
            return v0.m5212bR();
        }), Codec.BOOL.optionalFieldOf("highlightInScoreboard", false).forGetter((v0) -> {
            return v0.m5213bS();
        }), Codec.STRING.optionalFieldOf("minRankRequired", "recruit").forGetter((v0) -> {
            return v0.m5214ag();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11) -> {
            return new C0948rG(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11);
        });
    });

    public C0948rG(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull ResourceLocation resourceLocation, boolean z2, boolean z3, boolean z4, boolean z5, @NotNull String str4) {
        this.f5233rn = i;
        this.f5234cr = str;
        this.f5235cs = str2;
        this.f5236ct = str3;
        this.f5237gY = z;
        this.f5238eS = resourceLocation;
        this.f5239gZ = z2;
        this.f5240ha = z3;
        this.f5241hb = z4;
        this.f5242hc = z5;
        this.f5243cu = str4;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0948rG.class), C0948rG.class, "index;key;displayTitle;description;botFriendly;icon;isDefault;seeMedicCallouts;canWarCry;highlightInScoreboard;minRankRequired", "FIELD:Lcom/boehmod/blockfront/rG;->rn:I", "FIELD:Lcom/boehmod/blockfront/rG;->cr:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rG;->cs:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rG;->ct:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rG;->gY:Z", "FIELD:Lcom/boehmod/blockfront/rG;->eS:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rG;->gZ:Z", "FIELD:Lcom/boehmod/blockfront/rG;->ha:Z", "FIELD:Lcom/boehmod/blockfront/rG;->hb:Z", "FIELD:Lcom/boehmod/blockfront/rG;->hc:Z", "FIELD:Lcom/boehmod/blockfront/rG;->cu:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0948rG.class), C0948rG.class, "index;key;displayTitle;description;botFriendly;icon;isDefault;seeMedicCallouts;canWarCry;highlightInScoreboard;minRankRequired", "FIELD:Lcom/boehmod/blockfront/rG;->rn:I", "FIELD:Lcom/boehmod/blockfront/rG;->cr:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rG;->cs:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rG;->ct:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rG;->gY:Z", "FIELD:Lcom/boehmod/blockfront/rG;->eS:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rG;->gZ:Z", "FIELD:Lcom/boehmod/blockfront/rG;->ha:Z", "FIELD:Lcom/boehmod/blockfront/rG;->hb:Z", "FIELD:Lcom/boehmod/blockfront/rG;->hc:Z", "FIELD:Lcom/boehmod/blockfront/rG;->cu:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0948rG.class, Object.class), C0948rG.class, "index;key;displayTitle;description;botFriendly;icon;isDefault;seeMedicCallouts;canWarCry;highlightInScoreboard;minRankRequired", "FIELD:Lcom/boehmod/blockfront/rG;->rn:I", "FIELD:Lcom/boehmod/blockfront/rG;->cr:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rG;->cs:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rG;->ct:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rG;->gY:Z", "FIELD:Lcom/boehmod/blockfront/rG;->eS:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rG;->gZ:Z", "FIELD:Lcom/boehmod/blockfront/rG;->ha:Z", "FIELD:Lcom/boehmod/blockfront/rG;->hb:Z", "FIELD:Lcom/boehmod/blockfront/rG;->hc:Z", "FIELD:Lcom/boehmod/blockfront/rG;->cu:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bO */
    public int m5204bO() {
        return this.f5233rn;
    }

    @NotNull
    /* JADX INFO: renamed from: aa */
    public String m5205aa() {
        return this.f5234cr;
    }

    @NotNull
    /* JADX INFO: renamed from: ae */
    public String m5206ae() {
        return this.f5235cs;
    }

    @NotNull
    /* JADX INFO: renamed from: af */
    public String m5207af() {
        return this.f5236ct;
    }

    /* JADX INFO: renamed from: bO */
    public boolean m5208bO() {
        return this.f5237gY;
    }

    @NotNull
    /* JADX INFO: renamed from: L */
    public ResourceLocation m5209L() {
        return this.f5238eS;
    }

    /* JADX INFO: renamed from: bP */
    public boolean m5210bP() {
        return this.f5239gZ;
    }

    /* JADX INFO: renamed from: bQ */
    public boolean m5211bQ() {
        return this.f5240ha;
    }

    /* JADX INFO: renamed from: bR */
    public boolean m5212bR() {
        return this.f5241hb;
    }

    /* JADX INFO: renamed from: bS */
    public boolean m5213bS() {
        return this.f5242hc;
    }

    @NotNull
    /* JADX INFO: renamed from: ag */
    public String m5214ag() {
        return this.f5243cu;
    }
}
