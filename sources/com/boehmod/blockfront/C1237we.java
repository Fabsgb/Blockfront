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

/* JADX INFO: renamed from: com.boehmod.blockfront.we */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/we.class */
public final class C1237we extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: jP */
    @NotNull
    private final Component f7349jP;

    /* JADX INFO: renamed from: jb */
    private final boolean f7350jb;

    /* JADX INFO: renamed from: ah */
    @NotNull
    public static final CustomPacketPayload.Type<C1237we> f7351ah = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_victory"));

    /* JADX INFO: renamed from: ai */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1237we> f7352ai = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7646g(v1);
    }, C1237we::new);

    public C1237we(@NotNull Component component, boolean z) {
        this.f7349jP = component;
        this.f7350jb = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1237we.class), C1237we.class, "subtitle;victory", "FIELD:Lcom/boehmod/blockfront/we;->jP:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/we;->jb:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1237we.class), C1237we.class, "subtitle;victory", "FIELD:Lcom/boehmod/blockfront/we;->jP:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/we;->jb:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1237we.class, Object.class), C1237we.class, "subtitle;victory", "FIELD:Lcom/boehmod/blockfront/we;->jP:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/we;->jb:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public Component m7648p() {
        return this.f7349jP;
    }

    /* JADX INFO: renamed from: dd */
    public boolean m7649dd() {
        return this.f7350jb;
    }

    public C1237we(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: g */
    public void m7646g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f7349jP);
        registryFriendlyByteBuf.writeBoolean(this.f7350jb);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7351ah;
    }

    /* JADX INFO: renamed from: b */
    public static void m7647b(C1237we c1237we, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2963a(c1237we, iPayloadContext);
    }
}
