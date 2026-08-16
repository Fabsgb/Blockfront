package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jU.class */
public final class C0538jU extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: e */
    private final byte[] f3211e;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final CustomPacketPayload.Type<C0538jU> f3212a = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_screenshot_display"));

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0538jU> f3213a = CustomPacketPayload.codec((v0, v1) -> {
        v0.m2409d(v1);
    }, C0538jU::new);

    public C0538jU(byte[] bArr) {
        this.f3211e = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0538jU.class), C0538jU.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jU;->e:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0538jU.class), C0538jU.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jU;->e:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0538jU.class, Object.class), C0538jU.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jU;->e:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: c */
    public byte[] m2411c() {
        return this.f3211e;
    }

    public C0538jU(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m2409d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.f3211e);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f3212a;
    }

    /* JADX INFO: renamed from: b */
    public static void m2410b(C0538jU c0538jU, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2971a(c0538jU, iPayloadContext);
    }
}
