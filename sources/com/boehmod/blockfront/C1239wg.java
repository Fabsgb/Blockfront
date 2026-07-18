package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wg.class */
public final class C1239wg extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: sL */
    private final int f7358sL;

    /* JADX INFO: renamed from: aj */
    @NotNull
    public static final CustomPacketPayload.Type<C1239wg> f7359aj = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_world_flash"));

    /* JADX INFO: renamed from: ak */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1239wg> f7360ak = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7655d(v1);
    }, C1239wg::new);

    public C1239wg(int i) {
        this.f7358sL = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1239wg.class), C1239wg.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wg;->sL:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1239wg.class), C1239wg.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wg;->sL:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1239wg.class, Object.class), C1239wg.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wg;->sL:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cp */
    public int m7657cp() {
        return this.f7358sL;
    }

    public C1239wg(FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: d */
    public void m7655d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f7358sL);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7359aj;
    }

    /* JADX INFO: renamed from: b */
    public static void m7656b(C1239wg c1239wg, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2943a(c1239wg, iPayloadContext);
    }
}
