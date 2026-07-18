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

/* JADX INFO: renamed from: com.boehmod.blockfront.vU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vU.class */
public final class C1174vU extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Holder<SoundEvent> f6197c;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final SoundSource f6198b;

    /* JADX INFO: renamed from: nX */
    private final float f6199nX;

    /* JADX INFO: renamed from: nY */
    private final float f6200nY;

    /* JADX INFO: renamed from: X */
    @NotNull
    public static final CustomPacketPayload.Type<C1174vU> f6201X = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_sound"));

    /* JADX INFO: renamed from: Y */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1174vU> f6202Y = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6565g(v1);
    }, C1174vU::new);

    public C1174vU(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f, float f2) {
        this.f6197c = holder;
        this.f6198b = soundSource;
        this.f6199nX = f;
        this.f6200nY = f2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1174vU.class), C1174vU.class, "sound;soundSource;volume;pitch", "FIELD:Lcom/boehmod/blockfront/vU;->c:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vU;->b:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vU;->nX:F", "FIELD:Lcom/boehmod/blockfront/vU;->nY:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1174vU.class), C1174vU.class, "sound;soundSource;volume;pitch", "FIELD:Lcom/boehmod/blockfront/vU;->c:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vU;->b:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vU;->nX:F", "FIELD:Lcom/boehmod/blockfront/vU;->nY:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1174vU.class, Object.class), C1174vU.class, "sound;soundSource;volume;pitch", "FIELD:Lcom/boehmod/blockfront/vU;->c:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vU;->b:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vU;->nX:F", "FIELD:Lcom/boehmod/blockfront/vU;->nY:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Holder<SoundEvent> m6567c() {
        return this.f6197c;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public SoundSource m6568a() {
        return this.f6198b;
    }

    /* JADX INFO: renamed from: bP */
    public float m6569bP() {
        return this.f6199nX;
    }

    /* JADX INFO: renamed from: bO */
    public float m6570bO() {
        return this.f6200nY;
    }

    public C1174vU(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Holder) SoundEvent.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readEnum(SoundSource.class), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: g */
    public void m6565g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        SoundEvent.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6197c);
        registryFriendlyByteBuf.writeEnum(this.f6198b);
        registryFriendlyByteBuf.writeFloat(this.f6199nX);
        registryFriendlyByteBuf.writeFloat(this.f6200nY);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6201X;
    }

    /* JADX INFO: renamed from: b */
    public static void m6566b(C1174vU c1174vU, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2936a(c1174vU, iPayloadContext);
    }
}
