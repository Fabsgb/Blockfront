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

/* JADX INFO: renamed from: com.boehmod.blockfront.wD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wD.class */
public final class C1211wD extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: kc */
    @NotNull
    private final Component f6591kc;

    /* JADX INFO: renamed from: ju */
    private final boolean f6592ju;

    /* JADX INFO: renamed from: ag */
    @NotNull
    public static final CustomPacketPayload.Type<C1211wD> f6593ag = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_victory"));

    /* JADX INFO: renamed from: ah */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1211wD> f6594ah = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6918g(v1);
    }, C1211wD::new);

    public C1211wD(@NotNull Component component, boolean z) {
        this.f6591kc = component;
        this.f6592ju = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1211wD.class), C1211wD.class, "subtitle;victory", "FIELD:Lcom/boehmod/blockfront/wD;->kc:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/wD;->ju:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1211wD.class), C1211wD.class, "subtitle;victory", "FIELD:Lcom/boehmod/blockfront/wD;->kc:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/wD;->ju:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1211wD.class, Object.class), C1211wD.class, "subtitle;victory", "FIELD:Lcom/boehmod/blockfront/wD;->kc:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/wD;->ju:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public Component m6920p() {
        return this.f6591kc;
    }

    /* JADX INFO: renamed from: dm */
    public boolean m6921dm() {
        return this.f6592ju;
    }

    public C1211wD(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: g */
    public void m6918g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6591kc);
        registryFriendlyByteBuf.writeBoolean(this.f6592ju);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6593ag;
    }

    /* JADX INFO: renamed from: b */
    public static void m6919b(C1211wD c1211wD, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2974a(c1211wD, iPayloadContext);
    }
}
