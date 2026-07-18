package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jB.class */
public final class C0518jB extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: e */
    private final byte[] f3055e;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final CustomPacketPayload.Type<C0518jB> f3056a = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_screenshot_display"));

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0518jB> f3057a = CustomPacketPayload.codec((v0, v1) -> {
        v0.m2275d(v1);
    }, C0518jB::new);

    public C0518jB(byte[] bArr) {
        this.f3055e = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0518jB.class), C0518jB.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jB;->e:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0518jB.class), C0518jB.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jB;->e:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0518jB.class, Object.class), C0518jB.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jB;->e:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: c */
    public byte[] m2277c() {
        return this.f3055e;
    }

    public C0518jB(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m2275d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.f3055e);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f3056a;
    }

    /* JADX INFO: renamed from: b */
    public static void m2276b(C0518jB c0518jB, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2960a(c0518jB, iPayloadContext);
    }
}
