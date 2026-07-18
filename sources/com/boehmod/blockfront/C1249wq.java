package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wq.class */
public final class C1249wq extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0876pp f7404a;

    /* JADX INFO: renamed from: at */
    @NotNull
    public static final CustomPacketPayload.Type<C1249wq> f7405at = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_game_kill_feed"));

    /* JADX INFO: renamed from: au */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1249wq> f7406au = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7700g(v1);
    }, C1249wq::new);

    public C1249wq(@NotNull C0876pp c0876pp) {
        this.f7404a = c0876pp;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1249wq.class), C1249wq.class, "entry", "FIELD:Lcom/boehmod/blockfront/wq;->a:Lcom/boehmod/blockfront/pp;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1249wq.class), C1249wq.class, "entry", "FIELD:Lcom/boehmod/blockfront/wq;->a:Lcom/boehmod/blockfront/pp;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1249wq.class, Object.class), C1249wq.class, "entry", "FIELD:Lcom/boehmod/blockfront/wq;->a:Lcom/boehmod/blockfront/pp;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0876pp m7702a() {
        return this.f7404a;
    }

    public C1249wq(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C0876pp.m4431a(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m7700g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f7404a.m4430a(registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7405at;
    }

    /* JADX INFO: renamed from: b */
    public static void m7701b(C1249wq c1249wq, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2928a(c1249wq, iPayloadContext);
    }
}
