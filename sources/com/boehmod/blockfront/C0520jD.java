package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jD.class */
public final class C0520jD extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: f */
    private final byte[] f3060f;

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final CustomPacketPayload.Type<C0520jD> f3061c = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_screenshot_response"));

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0520jD> f3062c = CustomPacketPayload.codec((v0, v1) -> {
        v0.m2280d(v1);
    }, C0520jD::new);

    public C0520jD(byte[] bArr) {
        this.f3060f = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0520jD.class), C0520jD.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jD;->f:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0520jD.class), C0520jD.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jD;->f:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0520jD.class, Object.class), C0520jD.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jD;->f:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: c */
    public byte[] m2282c() {
        return this.f3060f;
    }

    public C0520jD(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m2280d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.f3060f);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f3061c;
    }

    /* JADX INFO: renamed from: a */
    public static void m2281a(C0520jD c0520jD, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            String scoreboardName = serverPlayer.getScoreboardName();
            C0562jt.log("[Screenshot] Received screenshot data from player '%s'.", scoreboardName);
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!(abstractC0563juM168a instanceof C1300xw)) {
                C0562jt.logError("[Screenshot] Failed to receive screenshot data from player '%s' - Server Manager is null.", scoreboardName);
                return;
            }
            C1262xC c1262xCM7745a = ((C1260xA) ((C1300xw) abstractC0563juM168a).m7961b()).m2582a().m7745a(serverPlayer);
            if (c1262xCM7745a != null) {
                c1262xCM7745a.m7750a(c0520jD.m2282c());
            }
        }
    }
}
