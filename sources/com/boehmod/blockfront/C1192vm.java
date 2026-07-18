package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vm.class */
public final class C1192vm extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0023U f6273a;

    /* JADX INFO: renamed from: q */
    @NotNull
    public static final CustomPacketPayload.Type<C1192vm> f6274q = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_debug_line"));

    /* JADX INFO: renamed from: r */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1192vm> f6275r = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6642d(v1);
    }, C1192vm::new);

    public C1192vm(@NotNull C0023U c0023u) {
        this.f6273a = c0023u;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1192vm.class), C1192vm.class, "debugLine", "FIELD:Lcom/boehmod/blockfront/vm;->a:Lcom/boehmod/blockfront/U;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1192vm.class), C1192vm.class, "debugLine", "FIELD:Lcom/boehmod/blockfront/vm;->a:Lcom/boehmod/blockfront/U;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1192vm.class, Object.class), C1192vm.class, "debugLine", "FIELD:Lcom/boehmod/blockfront/vm;->a:Lcom/boehmod/blockfront/U;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0023U m6644a() {
        return this.f6273a;
    }

    public C1192vm(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C0023U.m143a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m6642d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6273a.m144a(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6274q;
    }

    /* JADX INFO: renamed from: b */
    public static void m6643b(C1192vm c1192vm, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2955a(c1192vm, iPayloadContext);
    }
}
