package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ve */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ve.class */
public final class C1184ve extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final CustomPacketPayload.Type<C1184ve> f6245i = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_clear_ragdolls"));

    /* JADX INFO: renamed from: j */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1184ve> f6246j = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6612d(v1);
    }, C1184ve::new);

    public C1184ve() {
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1184ve.class), C1184ve.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1184ve.class), C1184ve.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1184ve.class, Object.class), C1184ve.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public C1184ve(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this();
    }

    /* JADX INFO: renamed from: d */
    public void m6612d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6245i;
    }

    /* JADX INFO: renamed from: b */
    public static void m6613b(C1184ve c1184ve, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2948a(c1184ve, iPayloadContext);
    }
}
