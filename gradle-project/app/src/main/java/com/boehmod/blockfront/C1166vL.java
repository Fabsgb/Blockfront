package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vL.class */
public final class C1166vL extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0029Z f6354a;

    /* JADX INFO: renamed from: p */
    @NotNull
    public static final CustomPacketPayload.Type<C1166vL> f6355p = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_debug_box"));

    /* JADX INFO: renamed from: q */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1166vL> f6356q = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6634d(v1);
    }, C1166vL::new);

    public C1166vL(@NotNull C0029Z c0029z) {
        this.f6354a = c0029z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1166vL.class), C1166vL.class, "debugBox", "FIELD:Lcom/boehmod/blockfront/vL;->a:Lcom/boehmod/blockfront/Z;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1166vL.class), C1166vL.class, "debugBox", "FIELD:Lcom/boehmod/blockfront/vL;->a:Lcom/boehmod/blockfront/Z;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1166vL.class, Object.class), C1166vL.class, "debugBox", "FIELD:Lcom/boehmod/blockfront/vL;->a:Lcom/boehmod/blockfront/Z;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0029Z m6636a() {
        return this.f6354a;
    }

    public C1166vL(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C0029Z.m170a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m6634d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6354a.m171a(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6355p;
    }

    /* JADX INFO: renamed from: b */
    public static void m6635b(C1166vL c1166vL, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2967a(c1166vL, iPayloadContext);
    }
}
