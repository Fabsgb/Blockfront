package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vl.class */
public final class C0579vl extends Record implements CustomPacketPayload {

    @NotNull
    private final T a;

    @NotNull
    public static final CustomPacketPayload.Type<C0579vl> p = new CustomPacketPayload.Type<>(C0265jv.d("packet_debug_box"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0579vl> q = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0579vl::new);

    public C0579vl(@NotNull T t) {
        this.a = t;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0579vl.class), C0579vl.class, "debugBox", "FIELD:Lcom/boehmod/blockfront/vl;->a:Lcom/boehmod/blockfront/T;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0579vl.class), C0579vl.class, "debugBox", "FIELD:Lcom/boehmod/blockfront/vl;->a:Lcom/boehmod/blockfront/T;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0579vl.class, Object.class), C0579vl.class, "debugBox", "FIELD:Lcom/boehmod/blockfront/vl;->a:Lcom/boehmod/blockfront/T;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public T a() {
        return this.a;
    }

    public C0579vl(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(T.a(friendlyByteBuf));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.a.m160a(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return p;
    }

    public static void b(C0579vl c0579vl, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0579vl, iPayloadContext);
    }
}
