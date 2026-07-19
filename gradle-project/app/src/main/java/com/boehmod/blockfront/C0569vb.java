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

/* JADX INFO: renamed from: com.boehmod.blockfront.vb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vb.class */
public final class C0569vb extends Record implements CustomPacketPayload {

    @NotNull
    private final ChatGraphic a;

    @NotNull
    private final Component jJ;

    @NotNull
    public static final CustomPacketPayload.Type<C0569vb> f = new CustomPacketPayload.Type<>(C0265jv.d("packet_chat_graphic"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0569vb> g = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, C0569vb::new);

    public C0569vb(@NotNull ChatGraphic chatGraphic, @NotNull Component component) {
        this.a = chatGraphic;
        this.jJ = component;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0569vb.class), C0569vb.class, "graphic;component", "FIELD:Lcom/boehmod/blockfront/vb;->a:Lcom/boehmod/bflib/cloud/common/ChatGraphic;", "FIELD:Lcom/boehmod/blockfront/vb;->jJ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0569vb.class), C0569vb.class, "graphic;component", "FIELD:Lcom/boehmod/blockfront/vb;->a:Lcom/boehmod/bflib/cloud/common/ChatGraphic;", "FIELD:Lcom/boehmod/blockfront/vb;->jJ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0569vb.class, Object.class), C0569vb.class, "graphic;component", "FIELD:Lcom/boehmod/blockfront/vb;->a:Lcom/boehmod/bflib/cloud/common/ChatGraphic;", "FIELD:Lcom/boehmod/blockfront/vb;->jJ:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public ChatGraphic a() {
        return this.a;
    }

    @NotNull
    public Component n() {
        return this.jJ;
    }

    public C0569vb(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((ChatGraphic) registryFriendlyByteBuf.readEnum(ChatGraphic.class), (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf));
    }

    public void g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeEnum(this.a);
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.jJ);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f;
    }

    public static void b(C0569vb c0569vb, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0569vb, iPayloadContext);
    }
}
