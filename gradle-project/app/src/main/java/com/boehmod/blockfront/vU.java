package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vU.class */
public final class vU extends Record implements CustomPacketPayload {

    @NotNull
    private final Holder<SoundEvent> c;

    @NotNull
    private final SoundSource b;
    private final float nX;
    private final float nY;

    @NotNull
    public static final CustomPacketPayload.Type<vU> X = new CustomPacketPayload.Type<>(C0265jv.d("packet_sound"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, vU> Y = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, vU::new);

    public vU(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f, float f2) {
        this.c = holder;
        this.b = soundSource;
        this.nX = f;
        this.nY = f2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vU.class), vU.class, "sound;soundSource;volume;pitch", "FIELD:Lcom/boehmod/blockfront/vU;->c:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vU;->b:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vU;->nX:F", "FIELD:Lcom/boehmod/blockfront/vU;->nY:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vU.class), vU.class, "sound;soundSource;volume;pitch", "FIELD:Lcom/boehmod/blockfront/vU;->c:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vU;->b:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vU;->nX:F", "FIELD:Lcom/boehmod/blockfront/vU;->nY:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vU.class, Object.class), vU.class, "sound;soundSource;volume;pitch", "FIELD:Lcom/boehmod/blockfront/vU;->c:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vU;->b:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vU;->nX:F", "FIELD:Lcom/boehmod/blockfront/vU;->nY:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public Holder<SoundEvent> c() {
        return this.c;
    }

    @NotNull
    public SoundSource a() {
        return this.b;
    }

    public float bP() {
        return this.nX;
    }

    public float bO() {
        return this.nY;
    }

    public vU(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Holder) SoundEvent.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readEnum(SoundSource.class), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat());
    }

    public void g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        SoundEvent.STREAM_CODEC.encode(registryFriendlyByteBuf, this.c);
        registryFriendlyByteBuf.writeEnum(this.b);
        registryFriendlyByteBuf.writeFloat(this.nX);
        registryFriendlyByteBuf.writeFloat(this.nY);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return X;
    }

    public static void b(vU vUVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vUVar, iPayloadContext);
    }
}
