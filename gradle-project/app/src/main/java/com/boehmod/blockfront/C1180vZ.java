package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vZ.class */
public final class C1180vZ extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: je */
    private final boolean f6420je;

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final CustomPacketPayload.Type<C1180vZ> f6421C = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_hit_marker"));

    /* JADX INFO: renamed from: D */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1180vZ> f6422D = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6705d(v1);
    }, C1180vZ::new);

    public C1180vZ(boolean z) {
        this.f6420je = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1180vZ.class), C1180vZ.class, "isKill", "FIELD:Lcom/boehmod/blockfront/vZ;->je:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1180vZ.class), C1180vZ.class, "isKill", "FIELD:Lcom/boehmod/blockfront/vZ;->je:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1180vZ.class, Object.class), C1180vZ.class, "isKill", "FIELD:Lcom/boehmod/blockfront/vZ;->je:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: dc */
    public boolean m6707dc() {
        return this.f6420je;
    }

    public C1180vZ(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: d */
    public void m6705d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f6420je);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6421C;
    }

    /* JADX INFO: renamed from: b */
    public static void m6706b(C1180vZ c1180vZ, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2965a(c1180vZ, iPayloadContext);
    }
}
