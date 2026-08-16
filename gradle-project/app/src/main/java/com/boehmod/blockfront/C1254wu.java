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

/* JADX INFO: renamed from: com.boehmod.blockfront.wu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wu.class */
public final class C1254wu extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Holder<SoundEvent> f6773c;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final SoundSource f6774b;

    /* JADX INFO: renamed from: oV */
    private final float f6775oV;

    /* JADX INFO: renamed from: oW */
    private final float f6776oW;

    /* JADX INFO: renamed from: X */
    @NotNull
    public static final CustomPacketPayload.Type<C1254wu> f6777X = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_sound"));

    /* JADX INFO: renamed from: Y */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1254wu> f6778Y = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7091g(v1);
    }, C1254wu::new);

    public C1254wu(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f, float f2) {
        this.f6773c = holder;
        this.f6774b = soundSource;
        this.f6775oV = f;
        this.f6776oW = f2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1254wu.class), C1254wu.class, "sound;soundSource;volume;pitch", "FIELD:Lcom/boehmod/blockfront/wu;->c:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/wu;->b:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/wu;->oV:F", "FIELD:Lcom/boehmod/blockfront/wu;->oW:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1254wu.class), C1254wu.class, "sound;soundSource;volume;pitch", "FIELD:Lcom/boehmod/blockfront/wu;->c:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/wu;->b:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/wu;->oV:F", "FIELD:Lcom/boehmod/blockfront/wu;->oW:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1254wu.class, Object.class), C1254wu.class, "sound;soundSource;volume;pitch", "FIELD:Lcom/boehmod/blockfront/wu;->c:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/wu;->b:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/wu;->oV:F", "FIELD:Lcom/boehmod/blockfront/wu;->oW:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Holder<SoundEvent> m7093c() {
        return this.f6773c;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public SoundSource m7094a() {
        return this.f6774b;
    }

    /* JADX INFO: renamed from: bV */
    public float m7095bV() {
        return this.f6775oV;
    }

    /* JADX INFO: renamed from: bU */
    public float m7096bU() {
        return this.f6776oW;
    }

    public C1254wu(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Holder) SoundEvent.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readEnum(SoundSource.class), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: g */
    public void m7091g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        SoundEvent.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6773c);
        registryFriendlyByteBuf.writeEnum(this.f6774b);
        registryFriendlyByteBuf.writeFloat(this.f6775oV);
        registryFriendlyByteBuf.writeFloat(this.f6776oW);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6777X;
    }

    /* JADX INFO: renamed from: b */
    public static void m7092b(C1254wu c1254wu, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2947a(c1254wu, iPayloadContext);
    }
}
