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

/* JADX INFO: renamed from: com.boehmod.blockfront.vB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vB.class */
public final class C1156vB extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ChatGraphic f6315a;

    /* JADX INFO: renamed from: jW */
    @NotNull
    private final Component f6316jW;

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final CustomPacketPayload.Type<C1156vB> f6317f = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_chat_graphic"));

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1156vB> f6318g = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6594g(v1);
    }, C1156vB::new);

    public C1156vB(@NotNull ChatGraphic chatGraphic, @NotNull Component component) {
        this.f6315a = chatGraphic;
        this.f6316jW = component;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1156vB.class), C1156vB.class, "graphic;component", "FIELD:Lcom/boehmod/blockfront/vB;->a:Lcom/boehmod/bflib/cloud/common/ChatGraphic;", "FIELD:Lcom/boehmod/blockfront/vB;->jW:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1156vB.class), C1156vB.class, "graphic;component", "FIELD:Lcom/boehmod/blockfront/vB;->a:Lcom/boehmod/bflib/cloud/common/ChatGraphic;", "FIELD:Lcom/boehmod/blockfront/vB;->jW:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1156vB.class, Object.class), C1156vB.class, "graphic;component", "FIELD:Lcom/boehmod/blockfront/vB;->a:Lcom/boehmod/bflib/cloud/common/ChatGraphic;", "FIELD:Lcom/boehmod/blockfront/vB;->jW:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ChatGraphic m6596a() {
        return this.f6315a;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public Component m6597n() {
        return this.f6316jW;
    }

    public C1156vB(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((ChatGraphic) registryFriendlyByteBuf.readEnum(ChatGraphic.class), (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m6594g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeEnum(this.f6315a);
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6316jW);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6317f;
    }

    /* JADX INFO: renamed from: b */
    public static void m6595b(C1156vB c1156vB, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2961a(c1156vB, iPayloadContext);
    }
}
