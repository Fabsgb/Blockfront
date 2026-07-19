package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vA.class */
public final class vA extends Record implements CustomPacketPayload {
    private final boolean iL;

    @NotNull
    public static final CustomPacketPayload.Type<vA> D = new CustomPacketPayload.Type<>(C0265jv.d("packet_hit_marker"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vA> E = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vA::new);

    public vA(boolean z) {
        this.iL = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vA.class), vA.class, "isKill", "FIELD:Lcom/boehmod/blockfront/vA;->iL:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vA.class), vA.class, "isKill", "FIELD:Lcom/boehmod/blockfront/vA;->iL:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vA.class, Object.class), vA.class, "isKill", "FIELD:Lcom/boehmod/blockfront/vA;->iL:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean cT() {
        return this.iL;
    }

    public vA(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.iL);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return D;
    }

    public static void b(vA vAVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vAVar, iPayloadContext);
    }
}
