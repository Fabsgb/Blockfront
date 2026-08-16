package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rE.class */
public final class C0946rE extends Record {

    /* JADX INFO: renamed from: cn */
    @NotNull
    private final String f5216cn;

    /* JADX INFO: renamed from: eL */
    @NotNull
    private final ResourceLocation f5217eL;

    /* JADX INFO: renamed from: eM */
    @NotNull
    private final ResourceLocation f5218eM;

    /* JADX INFO: renamed from: eN */
    @NotNull
    private final ResourceLocation f5219eN;

    /* JADX INFO: renamed from: eO */
    @NotNull
    private final ResourceLocation f5220eO;

    /* JADX INFO: renamed from: eP */
    @NotNull
    private final ResourceLocation f5221eP;

    /* JADX INFO: renamed from: eQ */
    @NotNull
    private final ResourceLocation f5222eQ;

    /* JADX INFO: renamed from: eR */
    @NotNull
    private final ResourceLocation f5223eR;

    /* JADX INFO: renamed from: P */
    @NotNull
    public static final Codec<C0946rE> f5224P = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("key").forGetter((v0) -> {
            return v0.m5187aa();
        }), ResourceLocation.CODEC.fieldOf("goSound").forGetter((v0) -> {
            return v0.m5188E();
        }), ResourceLocation.CODEC.fieldOf("grenadeSound").forGetter((v0) -> {
            return v0.m5189F();
        }), ResourceLocation.CODEC.fieldOf("hurtSound").forGetter((v0) -> {
            return v0.m5190G();
        }), ResourceLocation.CODEC.fieldOf("reloadingSound").forGetter((v0) -> {
            return v0.m5191H();
        }), ResourceLocation.CODEC.fieldOf("spottedSound").forGetter((v0) -> {
            return v0.m5192I();
        }), ResourceLocation.CODEC.fieldOf("tauntSound").forGetter((v0) -> {
            return v0.m5193J();
        }), ResourceLocation.CODEC.fieldOf("introSound").forGetter((v0) -> {
            return v0.m5194K();
        })).apply(instance, C0946rE::new);
    });

    public C0946rE(@NotNull String str, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull ResourceLocation resourceLocation3, @NotNull ResourceLocation resourceLocation4, @NotNull ResourceLocation resourceLocation5, @NotNull ResourceLocation resourceLocation6, @NotNull ResourceLocation resourceLocation7) {
        this.f5216cn = str;
        this.f5217eL = resourceLocation;
        this.f5218eM = resourceLocation2;
        this.f5219eN = resourceLocation3;
        this.f5220eO = resourceLocation4;
        this.f5221eP = resourceLocation5;
        this.f5222eQ = resourceLocation6;
        this.f5223eR = resourceLocation7;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0946rE.class), C0946rE.class, "key;goSound;grenadeSound;hurtSound;reloadingSound;spottedSound;tauntSound;introSound", "FIELD:Lcom/boehmod/blockfront/rE;->cn:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rE;->eL:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eM:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eN:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eO:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eP:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eQ:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eR:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0946rE.class), C0946rE.class, "key;goSound;grenadeSound;hurtSound;reloadingSound;spottedSound;tauntSound;introSound", "FIELD:Lcom/boehmod/blockfront/rE;->cn:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rE;->eL:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eM:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eN:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eO:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eP:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eQ:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eR:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0946rE.class, Object.class), C0946rE.class, "key;goSound;grenadeSound;hurtSound;reloadingSound;spottedSound;tauntSound;introSound", "FIELD:Lcom/boehmod/blockfront/rE;->cn:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rE;->eL:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eM:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eN:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eO:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eP:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eQ:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rE;->eR:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: aa */
    public String m5187aa() {
        return this.f5216cn;
    }

    @NotNull
    /* JADX INFO: renamed from: E */
    public ResourceLocation m5188E() {
        return this.f5217eL;
    }

    @NotNull
    /* JADX INFO: renamed from: F */
    public ResourceLocation m5189F() {
        return this.f5218eM;
    }

    @NotNull
    /* JADX INFO: renamed from: G */
    public ResourceLocation m5190G() {
        return this.f5219eN;
    }

    @NotNull
    /* JADX INFO: renamed from: H */
    public ResourceLocation m5191H() {
        return this.f5220eO;
    }

    @NotNull
    /* JADX INFO: renamed from: I */
    public ResourceLocation m5192I() {
        return this.f5221eP;
    }

    @NotNull
    /* JADX INFO: renamed from: J */
    public ResourceLocation m5193J() {
        return this.f5222eQ;
    }

    @NotNull
    /* JADX INFO: renamed from: K */
    public ResourceLocation m5194K() {
        return this.f5223eR;
    }
}
