package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ve, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ve.class */
public final class C0572ve extends Record implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<C0572ve> i = new CustomPacketPayload.Type<>(C0265jv.d("packet_clear_ragdolls"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0572ve> j = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0572ve::new);

    public C0572ve() {
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0572ve.class), C0572ve.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0572ve.class), C0572ve.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0572ve.class, Object.class), C0572ve.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public C0572ve(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this();
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return i;
    }

    public static void b(C0572ve c0572ve, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0572ve, iPayloadContext);
    }
}
