package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vl.class */
public final class C1191vl extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0022T f6270a;

    /* JADX INFO: renamed from: p */
    @NotNull
    public static final CustomPacketPayload.Type<C1191vl> f6271p = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_debug_box"));

    /* JADX INFO: renamed from: q */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1191vl> f6272q = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6639d(v1);
    }, C1191vl::new);

    public C1191vl(@NotNull C0022T c0022t) {
        this.f6270a = c0022t;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1191vl.class), C1191vl.class, "debugBox", "FIELD:Lcom/boehmod/blockfront/vl;->a:Lcom/boehmod/blockfront/T;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1191vl.class), C1191vl.class, "debugBox", "FIELD:Lcom/boehmod/blockfront/vl;->a:Lcom/boehmod/blockfront/T;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1191vl.class, Object.class), C1191vl.class, "debugBox", "FIELD:Lcom/boehmod/blockfront/vl;->a:Lcom/boehmod/blockfront/T;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0022T m6641a() {
        return this.f6270a;
    }

    public C1191vl(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C0022T.m137a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m6639d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6270a.m138a(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6271p;
    }

    /* JADX INFO: renamed from: b */
    public static void m6640b(C1191vl c1191vl, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2956a(c1191vl, iPayloadContext);
    }
}
