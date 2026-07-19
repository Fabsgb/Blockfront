package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jB.class */
public final class jB extends Record implements CustomPacketPayload {
    private final byte[] e;

    @NotNull
    public static final CustomPacketPayload.Type<jB> a = new CustomPacketPayload.Type<>(C0265jv.d("packet_screenshot_display"));

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, jB> f176a = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, jB::new);

    public jB(byte[] bArr) {
        this.e = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, jB.class), jB.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jB;->e:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, jB.class), jB.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jB;->e:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, jB.class, Object.class), jB.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jB;->e:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public byte[] c() {
        return this.e;
    }

    public jB(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.e);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void b(jB jBVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(jBVar, iPayloadContext);
    }
}
