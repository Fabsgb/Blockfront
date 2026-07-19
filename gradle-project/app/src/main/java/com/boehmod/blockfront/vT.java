package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vT.class */
public final class vT extends Record implements CustomPacketPayload {

    @NotNull
    private final hG P;

    @NotNull
    public static final CustomPacketPayload.Type<vT> W = new CustomPacketPayload.Type<>(C0265jv.d("packet_shake_node"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vT> X = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vT::new);

    public vT(@NotNull hG hGVar) {
        this.P = hGVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vT.class), vT.class, "node", "FIELD:Lcom/boehmod/blockfront/vT;->P:Lcom/boehmod/blockfront/hG;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vT.class), vT.class, "node", "FIELD:Lcom/boehmod/blockfront/vT;->P:Lcom/boehmod/blockfront/hG;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vT.class, Object.class), vT.class, "node", "FIELD:Lcom/boehmod/blockfront/vT;->P:Lcom/boehmod/blockfront/hG;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public hG c() {
        return this.P;
    }

    public vT(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(hG.a(friendlyByteBuf));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.P.b(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return W;
    }

    public static void b(vT vTVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vTVar, iPayloadContext);
    }
}
