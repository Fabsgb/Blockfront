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

/* JADX INFO: renamed from: com.boehmod.blockfront.wL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wL.class */
public final class C1219wL extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: kd */
    private final Component f6628kd;

    /* JADX INFO: renamed from: ao */
    @NotNull
    public static final CustomPacketPayload.Type<C1219wL> f6629ao = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_capture_point_spawn_error"));

    /* JADX INFO: renamed from: ap */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1219wL> f6630ap = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6955g(v1);
    }, C1219wL::new);

    public C1219wL(Component component) {
        this.f6628kd = component;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1219wL.class), C1219wL.class, "message", "FIELD:Lcom/boehmod/blockfront/wL;->kd:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1219wL.class), C1219wL.class, "message", "FIELD:Lcom/boehmod/blockfront/wL;->kd:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1219wL.class, Object.class), C1219wL.class, "message", "FIELD:Lcom/boehmod/blockfront/wL;->kd:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: b */
    public Component m6957b() {
        return this.f6628kd;
    }

    public C1219wL(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m6955g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6628kd);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6629ao;
    }

    /* JADX INFO: renamed from: b */
    public static void m6956b(C1219wL c1219wL, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2960a(c1219wL, iPayloadContext);
    }
}
