package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vm.class */
public final class C0580vm extends Record implements CustomPacketPayload {

    @NotNull
    private final U a;

    @NotNull
    public static final CustomPacketPayload.Type<C0580vm> q = new CustomPacketPayload.Type<>(C0265jv.d("packet_debug_line"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0580vm> r = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0580vm::new);

    public C0580vm(@NotNull U u) {
        this.a = u;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0580vm.class), C0580vm.class, "debugLine", "FIELD:Lcom/boehmod/blockfront/vm;->a:Lcom/boehmod/blockfront/U;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0580vm.class), C0580vm.class, "debugLine", "FIELD:Lcom/boehmod/blockfront/vm;->a:Lcom/boehmod/blockfront/U;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0580vm.class, Object.class), C0580vm.class, "debugLine", "FIELD:Lcom/boehmod/blockfront/vm;->a:Lcom/boehmod/blockfront/U;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public U a() {
        return this.a;
    }

    public C0580vm(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(U.a(friendlyByteBuf));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.a.m162a(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return q;
    }

    public static void b(C0580vm c0580vm, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0580vm, iPayloadContext);
    }
}
