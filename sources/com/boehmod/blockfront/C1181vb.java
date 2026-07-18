package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ChatGraphic;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.vb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vb.class */
public final class C1181vb extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ChatGraphic f6231a;

    /* JADX INFO: renamed from: jJ */
    @NotNull
    private final Component f6232jJ;

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final CustomPacketPayload.Type<C1181vb> f6233f = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_chat_graphic"));

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1181vb> f6234g = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6599g(v1);
    }, C1181vb::new);

    public C1181vb(@NotNull ChatGraphic chatGraphic, @NotNull Component component) {
        this.f6231a = chatGraphic;
        this.f6232jJ = component;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1181vb.class), C1181vb.class, "graphic;component", "FIELD:Lcom/boehmod/blockfront/vb;->a:Lcom/boehmod/bflib/cloud/common/ChatGraphic;", "FIELD:Lcom/boehmod/blockfront/vb;->jJ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1181vb.class), C1181vb.class, "graphic;component", "FIELD:Lcom/boehmod/blockfront/vb;->a:Lcom/boehmod/bflib/cloud/common/ChatGraphic;", "FIELD:Lcom/boehmod/blockfront/vb;->jJ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1181vb.class, Object.class), C1181vb.class, "graphic;component", "FIELD:Lcom/boehmod/blockfront/vb;->a:Lcom/boehmod/bflib/cloud/common/ChatGraphic;", "FIELD:Lcom/boehmod/blockfront/vb;->jJ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ChatGraphic m6601a() {
        return this.f6231a;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public Component m6602n() {
        return this.f6232jJ;
    }

    public C1181vb(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((ChatGraphic) registryFriendlyByteBuf.readEnum(ChatGraphic.class), (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m6599g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeEnum(this.f6231a);
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6232jJ);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6233f;
    }

    /* JADX INFO: renamed from: b */
    public static void m6600b(C1181vb c1181vb, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2950a(c1181vb, iPayloadContext);
    }
}
