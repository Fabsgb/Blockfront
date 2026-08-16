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

/* JADX INFO: renamed from: com.boehmod.blockfront.wg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wg.class */
public final class C1240wg extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0502il f6710a;

    /* JADX INFO: renamed from: J */
    @NotNull
    public static final CustomPacketPayload.Type<C1240wg> f6711J = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_queue_music"));

    /* JADX INFO: renamed from: K */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1240wg> f6712K = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7033g(v1);
    }, C1240wg::new);

    public C1240wg(@NotNull C0502il c0502il) {
        this.f6710a = c0502il;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1240wg.class), C1240wg.class, "queuedMusicBuilder", "FIELD:Lcom/boehmod/blockfront/wg;->a:Lcom/boehmod/blockfront/il;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1240wg.class), C1240wg.class, "queuedMusicBuilder", "FIELD:Lcom/boehmod/blockfront/wg;->a:Lcom/boehmod/blockfront/il;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1240wg.class, Object.class), C1240wg.class, "queuedMusicBuilder", "FIELD:Lcom/boehmod/blockfront/wg;->a:Lcom/boehmod/blockfront/il;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0502il m7035b() {
        return this.f6710a;
    }

    public C1240wg(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C0502il.m2262a((FriendlyByteBuf) registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m7033g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f6710a.m2261c((FriendlyByteBuf) registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6711J;
    }

    /* JADX INFO: renamed from: b */
    public static void m7034b(C1240wg c1240wg, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2972a(c1240wg, iPayloadContext);
    }
}
