package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vH.class */
public final class vH extends Record implements CustomPacketPayload {

    @NotNull
    private final hU a;

    @NotNull
    public static final CustomPacketPayload.Type<vH> K = new CustomPacketPayload.Type<>(C0265jv.d("packet_queue_music"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, vH> L = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, vH::new);

    public vH(@NotNull hU hUVar) {
        this.a = hUVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vH.class), vH.class, "queuedMusicBuilder", "FIELD:Lcom/boehmod/blockfront/vH;->a:Lcom/boehmod/blockfront/hU;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vH.class), vH.class, "queuedMusicBuilder", "FIELD:Lcom/boehmod/blockfront/vH;->a:Lcom/boehmod/blockfront/hU;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vH.class, Object.class), vH.class, "queuedMusicBuilder", "FIELD:Lcom/boehmod/blockfront/vH;->a:Lcom/boehmod/blockfront/hU;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public hU b() {
        return this.a;
    }

    public vH(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(hU.a((FriendlyByteBuf) registryFriendlyByteBuf));
    }

    public void g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.a.c((FriendlyByteBuf) registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return K;
    }

    public static void b(vH vHVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vHVar, iPayloadContext);
    }
}
