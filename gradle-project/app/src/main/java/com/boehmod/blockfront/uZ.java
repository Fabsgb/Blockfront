package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uZ.class */
public final class uZ extends Record implements CustomPacketPayload {
    private final boolean iF;

    @NotNull
    public static final CustomPacketPayload.Type<uZ> d;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, uZ> e;
    static final /* synthetic */ boolean iG;

    public uZ(boolean z) {
        this.iF = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, uZ.class), uZ.class, "aiming", "FIELD:Lcom/boehmod/blockfront/uZ;->iF:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, uZ.class), uZ.class, "aiming", "FIELD:Lcom/boehmod/blockfront/uZ;->iF:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, uZ.class, Object.class), uZ.class, "aiming", "FIELD:Lcom/boehmod/blockfront/uZ;->iF:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean cO() {
        return this.iF;
    }

    static {
        iG = !uZ.class.desiredAssertionStatus();
        d = new CustomPacketPayload.Type<>(C0265jv.d("packet_aiming"));
        e = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, uZ::new);
    }

    public uZ(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.iF);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return d;
    }

    public static void a(uZ uZVar, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!iG && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0264juM166a.m531a().m305a(iPayloadContext.player()).aa(uZVar.iF);
    }
}
