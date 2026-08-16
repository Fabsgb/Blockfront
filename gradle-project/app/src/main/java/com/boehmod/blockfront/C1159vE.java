package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vE.class */
public final class C1159vE extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final CustomPacketPayload.Type<C1159vE> f6329i = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_clear_ragdolls"));

    /* JADX INFO: renamed from: j */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1159vE> f6330j = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6607d(v1);
    }, C1159vE::new);

    public C1159vE() {
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1159vE.class), C1159vE.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1159vE.class), C1159vE.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1159vE.class, Object.class), C1159vE.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public C1159vE(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this();
    }

    /* JADX INFO: renamed from: d */
    public void m6607d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6329i;
    }

    /* JADX INFO: renamed from: b */
    public static void m6608b(C1159vE c1159vE, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2959a(c1159vE, iPayloadContext);
    }
}
