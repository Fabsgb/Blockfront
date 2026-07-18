package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vH.class */
public final class C1161vH extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0431hU f6137a;

    /* JADX INFO: renamed from: K */
    @NotNull
    public static final CustomPacketPayload.Type<C1161vH> f6138K = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_queue_music"));

    /* JADX INFO: renamed from: L */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1161vH> f6139L = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6510g(v1);
    }, C1161vH::new);

    public C1161vH(@NotNull C0431hU c0431hU) {
        this.f6137a = c0431hU;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1161vH.class), C1161vH.class, "queuedMusicBuilder", "FIELD:Lcom/boehmod/blockfront/vH;->a:Lcom/boehmod/blockfront/hU;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1161vH.class), C1161vH.class, "queuedMusicBuilder", "FIELD:Lcom/boehmod/blockfront/vH;->a:Lcom/boehmod/blockfront/hU;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1161vH.class, Object.class), C1161vH.class, "queuedMusicBuilder", "FIELD:Lcom/boehmod/blockfront/vH;->a:Lcom/boehmod/blockfront/hU;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0431hU m6512b() {
        return this.f6137a;
    }

    public C1161vH(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C0431hU.m2028a((FriendlyByteBuf) registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m6510g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f6137a.m2027c((FriendlyByteBuf) registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6138K;
    }

    /* JADX INFO: renamed from: b */
    public static void m6511b(C1161vH c1161vH, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2961a(c1161vH, iPayloadContext);
    }
}
