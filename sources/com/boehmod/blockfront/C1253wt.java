package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wt.class */
public final class C1253wt extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: Q */
    @NotNull
    private final C0434hW f6770Q;

    /* JADX INFO: renamed from: W */
    @NotNull
    public static final CustomPacketPayload.Type<C1253wt> f6771W = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_shake_node"));

    /* JADX INFO: renamed from: X */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1253wt> f6772X = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7088d(v1);
    }, C1253wt::new);

    public C1253wt(@NotNull C0434hW c0434hW) {
        this.f6770Q = c0434hW;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1253wt.class), C1253wt.class, "node", "FIELD:Lcom/boehmod/blockfront/wt;->Q:Lcom/boehmod/blockfront/hW;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1253wt.class), C1253wt.class, "node", "FIELD:Lcom/boehmod/blockfront/wt;->Q:Lcom/boehmod/blockfront/hW;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1253wt.class, Object.class), C1253wt.class, "node", "FIELD:Lcom/boehmod/blockfront/wt;->Q:Lcom/boehmod/blockfront/hW;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C0434hW m7090d() {
        return this.f6770Q;
    }

    public C1253wt(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C0434hW.m2007a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m7088d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6770Q.m2006b(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6771W;
    }

    /* JADX INFO: renamed from: b */
    public static void m7089b(C1253wt c1253wt, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2962a(c1253wt, iPayloadContext);
    }
}
