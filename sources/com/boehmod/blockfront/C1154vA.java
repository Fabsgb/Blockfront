package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vA.class */
public final class C1154vA extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: iL */
    private final boolean f6113iL;

    /* JADX INFO: renamed from: D */
    @NotNull
    public static final CustomPacketPayload.Type<C1154vA> f6114D = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_hit_marker"));

    /* JADX INFO: renamed from: E */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1154vA> f6115E = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6485d(v1);
    }, C1154vA::new);

    public C1154vA(boolean z) {
        this.f6113iL = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1154vA.class), C1154vA.class, "isKill", "FIELD:Lcom/boehmod/blockfront/vA;->iL:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1154vA.class), C1154vA.class, "isKill", "FIELD:Lcom/boehmod/blockfront/vA;->iL:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1154vA.class, Object.class), C1154vA.class, "isKill", "FIELD:Lcom/boehmod/blockfront/vA;->iL:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cT */
    public boolean m6487cT() {
        return this.f6113iL;
    }

    public C1154vA(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: d */
    public void m6485d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f6113iL);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6114D;
    }

    /* JADX INFO: renamed from: b */
    public static void m6486b(C1154vA c1154vA, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2954a(c1154vA, iPayloadContext);
    }
}
