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

/* JADX INFO: renamed from: com.boehmod.blockfront.we, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/we.class */
public final class C0599we extends Record implements CustomPacketPayload {

    @NotNull
    private final Component jP;
    private final boolean jb;

    @NotNull
    public static final CustomPacketPayload.Type<C0599we> ah = new CustomPacketPayload.Type<>(C0265jv.d("packet_victory"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0599we> ai = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, C0599we::new);

    public C0599we(@NotNull Component component, boolean z) {
        this.jP = component;
        this.jb = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0599we.class), C0599we.class, "subtitle;victory", "FIELD:Lcom/boehmod/blockfront/we;->jP:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/we;->jb:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0599we.class), C0599we.class, "subtitle;victory", "FIELD:Lcom/boehmod/blockfront/we;->jP:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/we;->jb:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0599we.class, Object.class), C0599we.class, "subtitle;victory", "FIELD:Lcom/boehmod/blockfront/we;->jP:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/we;->jb:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public Component p() {
        return this.jP;
    }

    public boolean dd() {
        return this.jb;
    }

    public C0599we(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readBoolean());
    }

    public void g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.jP);
        registryFriendlyByteBuf.writeBoolean(this.jb);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ah;
    }

    public static void b(C0599we c0599we, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0599we, iPayloadContext);
    }
}
