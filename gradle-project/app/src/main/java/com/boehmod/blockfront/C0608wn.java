package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wn.class */
public final class C0608wn extends Record implements CustomPacketPayload {
    private final Component jQ;

    @NotNull
    public static final CustomPacketPayload.Type<C0608wn> aq = new CustomPacketPayload.Type<>(C0265jv.d("packet_capture_point_spawn_error"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0608wn> ar = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, C0608wn::new);

    public C0608wn(Component component) {
        this.jQ = component;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0608wn.class), C0608wn.class, "message", "FIELD:Lcom/boehmod/blockfront/wn;->jQ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0608wn.class), C0608wn.class, "message", "FIELD:Lcom/boehmod/blockfront/wn;->jQ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0608wn.class, Object.class), C0608wn.class, "message", "FIELD:Lcom/boehmod/blockfront/wn;->jQ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public Component b() {
        return this.jQ;
    }

    public C0608wn(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf));
    }

    public void g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.jQ);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aq;
    }

    public static void b(C0608wn c0608wn, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0608wn, iPayloadContext);
    }
}
