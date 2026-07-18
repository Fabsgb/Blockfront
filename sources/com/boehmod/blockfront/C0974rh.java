package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rh.class */
public final class C0974rh extends Record {

    /* JADX INFO: renamed from: cd */
    @NotNull
    private final String f5112cd;

    /* JADX INFO: renamed from: eM */
    @NotNull
    private final ResourceLocation f5113eM;

    /* JADX INFO: renamed from: eN */
    @NotNull
    private final ResourceLocation f5114eN;

    /* JADX INFO: renamed from: eO */
    @NotNull
    private final ResourceLocation f5115eO;

    /* JADX INFO: renamed from: eP */
    @NotNull
    private final ResourceLocation f5116eP;

    /* JADX INFO: renamed from: eQ */
    @NotNull
    private final ResourceLocation f5117eQ;

    /* JADX INFO: renamed from: eR */
    @NotNull
    private final ResourceLocation f5118eR;

    /* JADX INFO: renamed from: eS */
    @NotNull
    private final ResourceLocation f5119eS;

    /* JADX INFO: renamed from: P */
    @NotNull
    public static final Codec<C0974rh> f5120P = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("key").forGetter((v0) -> {
            return v0.m5311T();
        }), ResourceLocation.CODEC.fieldOf("goSound").forGetter((v0) -> {
            return v0.m5312D();
        }), ResourceLocation.CODEC.fieldOf("grenadeSound").forGetter((v0) -> {
            return v0.m5313E();
        }), ResourceLocation.CODEC.fieldOf("hurtSound").forGetter((v0) -> {
            return v0.m5314F();
        }), ResourceLocation.CODEC.fieldOf("reloadingSound").forGetter((v0) -> {
            return v0.m5315G();
        }), ResourceLocation.CODEC.fieldOf("spottedSound").forGetter((v0) -> {
            return v0.m5316H();
        }), ResourceLocation.CODEC.fieldOf("tauntSound").forGetter((v0) -> {
            return v0.m5317I();
        }), ResourceLocation.CODEC.fieldOf("introSound").forGetter((v0) -> {
            return v0.m5318J();
        })).apply(instance, C0974rh::new);
    });

    public C0974rh(@NotNull String str, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull ResourceLocation resourceLocation3, @NotNull ResourceLocation resourceLocation4, @NotNull ResourceLocation resourceLocation5, @NotNull ResourceLocation resourceLocation6, @NotNull ResourceLocation resourceLocation7) {
        this.f5112cd = str;
        this.f5113eM = resourceLocation;
        this.f5114eN = resourceLocation2;
        this.f5115eO = resourceLocation3;
        this.f5116eP = resourceLocation4;
        this.f5117eQ = resourceLocation5;
        this.f5118eR = resourceLocation6;
        this.f5119eS = resourceLocation7;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0974rh.class), C0974rh.class, "key;goSound;grenadeSound;hurtSound;reloadingSound;spottedSound;tauntSound;introSound", "FIELD:Lcom/boehmod/blockfront/rh;->cd:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rh;->eM:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eN:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eO:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eP:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eQ:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eR:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eS:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0974rh.class), C0974rh.class, "key;goSound;grenadeSound;hurtSound;reloadingSound;spottedSound;tauntSound;introSound", "FIELD:Lcom/boehmod/blockfront/rh;->cd:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rh;->eM:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eN:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eO:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eP:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eQ:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eR:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eS:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0974rh.class, Object.class), C0974rh.class, "key;goSound;grenadeSound;hurtSound;reloadingSound;spottedSound;tauntSound;introSound", "FIELD:Lcom/boehmod/blockfront/rh;->cd:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rh;->eM:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eN:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eO:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eP:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eQ:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eR:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eS:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: T */
    public String m5311T() {
        return this.f5112cd;
    }

    @NotNull
    /* JADX INFO: renamed from: D */
    public ResourceLocation m5312D() {
        return this.f5113eM;
    }

    @NotNull
    /* JADX INFO: renamed from: E */
    public ResourceLocation m5313E() {
        return this.f5114eN;
    }

    @NotNull
    /* JADX INFO: renamed from: F */
    public ResourceLocation m5314F() {
        return this.f5115eO;
    }

    @NotNull
    /* JADX INFO: renamed from: G */
    public ResourceLocation m5315G() {
        return this.f5116eP;
    }

    @NotNull
    /* JADX INFO: renamed from: H */
    public ResourceLocation m5316H() {
        return this.f5117eQ;
    }

    @NotNull
    /* JADX INFO: renamed from: I */
    public ResourceLocation m5317I() {
        return this.f5118eR;
    }

    @NotNull
    /* JADX INFO: renamed from: J */
    public ResourceLocation m5318J() {
        return this.f5119eS;
    }
}
