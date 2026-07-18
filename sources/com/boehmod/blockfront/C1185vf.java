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

/* JADX INFO: renamed from: com.boehmod.blockfront.vf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vf.class */
public final class C1185vf extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: jK */
    @NotNull
    private final Component f6247jK;

    /* JADX INFO: renamed from: jL */
    @NotNull
    private final Component f6248jL;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final EnumC0286ei f6249b;

    /* JADX INFO: renamed from: j */
    @NotNull
    public static final CustomPacketPayload.Type<C1185vf> f6250j = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_client_notification"));

    /* JADX INFO: renamed from: k */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1185vf> f6251k = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6614g(v1);
    }, C1185vf::new);

    public C1185vf(@NotNull Component component, @NotNull Component component2, @NotNull EnumC0286ei enumC0286ei) {
        this.f6247jK = component;
        this.f6248jL = component2;
        this.f6249b = enumC0286ei;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1185vf.class), C1185vf.class, "title;subMessage;toastType", "FIELD:Lcom/boehmod/blockfront/vf;->jK:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->jL:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->b:Lcom/boehmod/blockfront/ei;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1185vf.class), C1185vf.class, "title;subMessage;toastType", "FIELD:Lcom/boehmod/blockfront/vf;->jK:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->jL:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->b:Lcom/boehmod/blockfront/ei;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1185vf.class, Object.class), C1185vf.class, "title;subMessage;toastType", "FIELD:Lcom/boehmod/blockfront/vf;->jK:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->jL:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/vf;->b:Lcom/boehmod/blockfront/ei;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Component m6616a() {
        return this.f6247jK;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public Component m6617o() {
        return this.f6248jL;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public EnumC0286ei m6618b() {
        return this.f6249b;
    }

    public C1185vf(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), (EnumC0286ei) registryFriendlyByteBuf.readEnum(EnumC0286ei.class));
    }

    /* JADX INFO: renamed from: g */
    public void m6614g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6247jK);
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6248jL);
        registryFriendlyByteBuf.writeEnum(this.f6249b);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6250j;
    }

    /* JADX INFO: renamed from: b */
    public static void m6615b(C1185vf c1185vf, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2938a(c1185vf, iPayloadContext);
    }
}
