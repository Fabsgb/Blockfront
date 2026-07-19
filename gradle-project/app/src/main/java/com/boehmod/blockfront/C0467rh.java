package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rh.class */
public final class C0467rh extends Record {

    @NotNull
    private final String cd;

    @NotNull
    private final ResourceLocation eM;

    @NotNull
    private final ResourceLocation eN;

    @NotNull
    private final ResourceLocation eO;

    @NotNull
    private final ResourceLocation eP;

    @NotNull
    private final ResourceLocation eQ;

    @NotNull
    private final ResourceLocation eR;

    @NotNull
    private final ResourceLocation eS;

    @NotNull
    public static final Codec<C0467rh> P = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("key").forGetter((v0) -> {
            return v0.T();
        }), ResourceLocation.CODEC.fieldOf("goSound").forGetter((v0) -> {
            return v0.D();
        }), ResourceLocation.CODEC.fieldOf("grenadeSound").forGetter((v0) -> {
            return v0.E();
        }), ResourceLocation.CODEC.fieldOf("hurtSound").forGetter((v0) -> {
            return v0.F();
        }), ResourceLocation.CODEC.fieldOf("reloadingSound").forGetter((v0) -> {
            return v0.G();
        }), ResourceLocation.CODEC.fieldOf("spottedSound").forGetter((v0) -> {
            return v0.H();
        }), ResourceLocation.CODEC.fieldOf("tauntSound").forGetter((v0) -> {
            return v0.I();
        }), ResourceLocation.CODEC.fieldOf("introSound").forGetter((v0) -> {
            return v0.J();
        })).apply(instance, C0467rh::new);
    });

    public C0467rh(@NotNull String str, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull ResourceLocation resourceLocation3, @NotNull ResourceLocation resourceLocation4, @NotNull ResourceLocation resourceLocation5, @NotNull ResourceLocation resourceLocation6, @NotNull ResourceLocation resourceLocation7) {
        this.cd = str;
        this.eM = resourceLocation;
        this.eN = resourceLocation2;
        this.eO = resourceLocation3;
        this.eP = resourceLocation4;
        this.eQ = resourceLocation5;
        this.eR = resourceLocation6;
        this.eS = resourceLocation7;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0467rh.class), C0467rh.class, "key;goSound;grenadeSound;hurtSound;reloadingSound;spottedSound;tauntSound;introSound", "FIELD:Lcom/boehmod/blockfront/rh;->cd:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rh;->eM:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eN:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eO:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eP:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eQ:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eR:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eS:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0467rh.class), C0467rh.class, "key;goSound;grenadeSound;hurtSound;reloadingSound;spottedSound;tauntSound;introSound", "FIELD:Lcom/boehmod/blockfront/rh;->cd:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rh;->eM:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eN:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eO:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eP:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eQ:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eR:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eS:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0467rh.class, Object.class), C0467rh.class, "key;goSound;grenadeSound;hurtSound;reloadingSound;spottedSound;tauntSound;introSound", "FIELD:Lcom/boehmod/blockfront/rh;->cd:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rh;->eM:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eN:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eO:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eP:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eQ:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eR:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/rh;->eS:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public String T() {
        return this.cd;
    }

    @NotNull
    public ResourceLocation D() {
        return this.eM;
    }

    @NotNull
    public ResourceLocation E() {
        return this.eN;
    }

    @NotNull
    public ResourceLocation F() {
        return this.eO;
    }

    @NotNull
    public ResourceLocation G() {
        return this.eP;
    }

    @NotNull
    public ResourceLocation H() {
        return this.eQ;
    }

    @NotNull
    public ResourceLocation I() {
        return this.eR;
    }

    @NotNull
    public ResourceLocation J() {
        return this.eS;
    }
}
