package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vT.class */
public final class C1173vT extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: P */
    @NotNull
    private final C0417hG f6194P;

    /* JADX INFO: renamed from: W */
    @NotNull
    public static final CustomPacketPayload.Type<C1173vT> f6195W = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_shake_node"));

    /* JADX INFO: renamed from: X */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1173vT> f6196X = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6562d(v1);
    }, C1173vT::new);

    public C1173vT(@NotNull C0417hG c0417hG) {
        this.f6194P = c0417hG;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1173vT.class), C1173vT.class, "node", "FIELD:Lcom/boehmod/blockfront/vT;->P:Lcom/boehmod/blockfront/hG;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1173vT.class), C1173vT.class, "node", "FIELD:Lcom/boehmod/blockfront/vT;->P:Lcom/boehmod/blockfront/hG;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1173vT.class, Object.class), C1173vT.class, "node", "FIELD:Lcom/boehmod/blockfront/vT;->P:Lcom/boehmod/blockfront/hG;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C0417hG m6564c() {
        return this.f6194P;
    }

    public C1173vT(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C0417hG.m1976a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m6562d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6194P.m1975b(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6195W;
    }

    /* JADX INFO: renamed from: b */
    public static void m6563b(C1173vT c1173vT, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2951a(c1173vT, iPayloadContext);
    }
}
