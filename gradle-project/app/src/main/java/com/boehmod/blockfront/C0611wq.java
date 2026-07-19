package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wq.class */
public final class C0611wq extends Record implements CustomPacketPayload {

    @NotNull
    private final C0421pp a;

    @NotNull
    public static final CustomPacketPayload.Type<C0611wq> at = new CustomPacketPayload.Type<>(C0265jv.d("packet_game_kill_feed"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0611wq> au = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, C0611wq::new);

    public C0611wq(@NotNull C0421pp c0421pp) {
        this.a = c0421pp;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0611wq.class), C0611wq.class, "entry", "FIELD:Lcom/boehmod/blockfront/wq;->a:Lcom/boehmod/blockfront/pp;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0611wq.class), C0611wq.class, "entry", "FIELD:Lcom/boehmod/blockfront/wq;->a:Lcom/boehmod/blockfront/pp;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0611wq.class, Object.class), C0611wq.class, "entry", "FIELD:Lcom/boehmod/blockfront/wq;->a:Lcom/boehmod/blockfront/pp;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public C0421pp a() {
        return this.a;
    }

    public C0611wq(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C0421pp.m875a(registryFriendlyByteBuf));
    }

    public void g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.a.a(registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return at;
    }

    public static void b(C0611wq c0611wq, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0611wq, iPayloadContext);
    }
}
