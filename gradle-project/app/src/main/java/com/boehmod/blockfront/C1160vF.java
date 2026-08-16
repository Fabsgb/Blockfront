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

/* JADX INFO: renamed from: com.boehmod.blockfront.vF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vF.class */
public final class C1160vF extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: jX */
    @NotNull
    private final Component f6331jX;

    /* JADX INFO: renamed from: jY */
    @NotNull
    private final Component f6332jY;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final EnumC0300ev f6333b;

    /* JADX INFO: renamed from: j */
    @NotNull
    public static final CustomPacketPayload.Type<C1160vF> f6334j = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_client_notification"));

    /* JADX INFO: renamed from: k */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1160vF> f6335k = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6609g(v1);
    }, C1160vF::new);

    public C1160vF(@NotNull Component component, @NotNull Component component2, @NotNull EnumC0300ev enumC0300ev) {
        this.f6331jX = component;
        this.f6332jY = component2;
        this.f6333b = enumC0300ev;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1160vF.class), C1160vF.class, "title;subMessage;toastType", "FIELD:Lcom/boehmod/blockfront/vF;->jX:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vF;->jY:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vF;->b:Lcom/boehmod/blockfront/ev;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1160vF.class), C1160vF.class, "title;subMessage;toastType", "FIELD:Lcom/boehmod/blockfront/vF;->jX:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vF;->jY:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vF;->b:Lcom/boehmod/blockfront/ev;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1160vF.class, Object.class), C1160vF.class, "title;subMessage;toastType", "FIELD:Lcom/boehmod/blockfront/vF;->jX:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vF;->jY:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vF;->b:Lcom/boehmod/blockfront/ev;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Component m6611a() {
        return this.f6331jX;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public Component m6612o() {
        return this.f6332jY;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public EnumC0300ev m6613b() {
        return this.f6333b;
    }

    public C1160vF(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), (EnumC0300ev) registryFriendlyByteBuf.readEnum(EnumC0300ev.class));
    }

    /* JADX INFO: renamed from: g */
    public void m6609g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6331jX);
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6332jY);
        registryFriendlyByteBuf.writeEnum(this.f6333b);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6334j;
    }

    /* JADX INFO: renamed from: b */
    public static void m6610b(C1160vF c1160vF, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2949a(c1160vF, iPayloadContext);
    }
}
