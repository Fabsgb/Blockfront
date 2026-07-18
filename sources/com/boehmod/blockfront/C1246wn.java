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

/* JADX INFO: renamed from: com.boehmod.blockfront.wn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wn.class */
public final class C1246wn extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: jQ */
    private final Component f7391jQ;

    /* JADX INFO: renamed from: aq */
    @NotNull
    public static final CustomPacketPayload.Type<C1246wn> f7392aq = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_capture_point_spawn_error"));

    /* JADX INFO: renamed from: ar */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1246wn> f7393ar = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7687g(v1);
    }, C1246wn::new);

    public C1246wn(Component component) {
        this.f7391jQ = component;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1246wn.class), C1246wn.class, "message", "FIELD:Lcom/boehmod/blockfront/wn;->jQ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1246wn.class), C1246wn.class, "message", "FIELD:Lcom/boehmod/blockfront/wn;->jQ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1246wn.class, Object.class), C1246wn.class, "message", "FIELD:Lcom/boehmod/blockfront/wn;->jQ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: b */
    public Component m7689b() {
        return this.f7391jQ;
    }

    public C1246wn(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m7687g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f7391jQ);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7392aq;
    }

    /* JADX INFO: renamed from: b */
    public static void m7688b(C1246wn c1246wn, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2949a(c1246wn, iPayloadContext);
    }
}
