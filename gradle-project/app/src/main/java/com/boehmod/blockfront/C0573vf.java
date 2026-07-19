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

/* JADX INFO: renamed from: com.boehmod.blockfront.vf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vf.class */
public final class C0573vf extends Record implements CustomPacketPayload {

    @NotNull
    private final Component jK;

    @NotNull
    private final Component jL;

    @NotNull
    private final EnumC0118ei b;

    @NotNull
    public static final CustomPacketPayload.Type<C0573vf> j = new CustomPacketPayload.Type<>(C0265jv.d("packet_client_notification"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0573vf> k = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, C0573vf::new);

    public C0573vf(@NotNull Component component, @NotNull Component component2, @NotNull EnumC0118ei enumC0118ei) {
        this.jK = component;
        this.jL = component2;
        this.b = enumC0118ei;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0573vf.class), C0573vf.class, "title;subMessage;toastType", "FIELD:Lcom/boehmod/blockfront/vf;->jK:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->jL:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->b:Lcom/boehmod/blockfront/ei;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0573vf.class), C0573vf.class, "title;subMessage;toastType", "FIELD:Lcom/boehmod/blockfront/vf;->jK:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->jL:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->b:Lcom/boehmod/blockfront/ei;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0573vf.class, Object.class), C0573vf.class, "title;subMessage;toastType", "FIELD:Lcom/boehmod/blockfront/vf;->jK:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->jL:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->b:Lcom/boehmod/blockfront/ei;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public Component a() {
        return this.jK;
    }

    @NotNull
    public Component o() {
        return this.jL;
    }

    @NotNull
    public EnumC0118ei b() {
        return this.b;
    }

    public C0573vf(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), (EnumC0118ei) registryFriendlyByteBuf.readEnum(EnumC0118ei.class));
    }

    public void g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.jK);
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.jL);
        registryFriendlyByteBuf.writeEnum(this.b);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return j;
    }

    public static void b(C0573vf c0573vf, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0573vf, iPayloadContext);
    }
}
