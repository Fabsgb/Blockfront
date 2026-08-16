package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vA.class */
public final class C1155vA extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final EnumC0883pv f6311b;

    /* JADX INFO: renamed from: G */
    @NotNull
    private final UUID f6312G;

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final CustomPacketPayload.Type<C1155vA> f6313e = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_callout_waypoint"));

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1155vA> f6314f = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6590d(v1);
    }, C1155vA::new);

    public C1155vA(@NotNull EnumC0883pv enumC0883pv, @NotNull UUID uuid) {
        this.f6311b = enumC0883pv;
        this.f6312G = uuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1155vA.class), C1155vA.class, "calloutType;playerUUID", "FIELD:Lcom/boehmod/blockfront/vA;->b:Lcom/boehmod/blockfront/pv;", "FIELD:Lcom/boehmod/blockfront/vA;->G:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1155vA.class), C1155vA.class, "calloutType;playerUUID", "FIELD:Lcom/boehmod/blockfront/vA;->b:Lcom/boehmod/blockfront/pv;", "FIELD:Lcom/boehmod/blockfront/vA;->G:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1155vA.class, Object.class), C1155vA.class, "calloutType;playerUUID", "FIELD:Lcom/boehmod/blockfront/vA;->b:Lcom/boehmod/blockfront/pv;", "FIELD:Lcom/boehmod/blockfront/vA;->G:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public EnumC0883pv m6592b() {
        return this.f6311b;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public UUID m6593b() {
        return this.f6312G;
    }

    public C1155vA(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((EnumC0883pv) friendlyByteBuf.readEnum(EnumC0883pv.class), friendlyByteBuf.readUUID());
    }

    /* JADX INFO: renamed from: d */
    public void m6590d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f6311b);
        friendlyByteBuf.writeUUID(this.f6312G);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6313e;
    }

    /* JADX INFO: renamed from: b */
    public static void m6591b(C1155vA c1155vA, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2958a(c1155vA, iPayloadContext);
    }
}
