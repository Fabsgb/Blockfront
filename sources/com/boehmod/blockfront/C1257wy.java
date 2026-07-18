package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wy.class */
public final class C1257wy extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: og */
    private final float f7439og;

    /* JADX INFO: renamed from: aB */
    @NotNull
    public static final CustomPacketPayload.Type<C1257wy> f7440aB = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_grenade_flash"));

    /* JADX INFO: renamed from: aC */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1257wy> f7441aC = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7732d(v1);
    }, C1257wy::new);

    public C1257wy(float f) {
        this.f7439og = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1257wy.class), C1257wy.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wy;->og:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1257wy.class), C1257wy.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wy;->og:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1257wy.class, Object.class), C1257wy.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wy;->og:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bY */
    public float m7734bY() {
        return this.f7439og;
    }

    public C1257wy(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m7732d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeFloat(this.f7439og);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7440aB;
    }

    /* JADX INFO: renamed from: b */
    public static void m7733b(C1257wy c1257wy, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2935a(c1257wy, iPayloadContext);
    }
}
