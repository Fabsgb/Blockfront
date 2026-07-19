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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jD.class */
public final class jD extends Record implements CustomPacketPayload {
    private final byte[] f;

    @NotNull
    public static final CustomPacketPayload.Type<jD> c = new CustomPacketPayload.Type<>(C0265jv.d("packet_screenshot_response"));

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, jD> f178c = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, jD::new);

    public jD(byte[] bArr) {
        this.f = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, jD.class), jD.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jD;->f:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, jD.class), jD.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jD;->f:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, jD.class, Object.class), jD.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jD;->f:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public byte[] c() {
        return this.f;
    }

    public jD(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.f);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return c;
    }

    public static void a(jD jDVar, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            String scoreboardName = serverPlayer.getScoreboardName();
            C0263jt.log("[Screenshot] Received screenshot data from player '%s'.", scoreboardName);
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!(abstractC0264juM166a instanceof xw)) {
                C0263jt.logError("[Screenshot] Failed to receive screenshot data from player '%s' - Server Manager is null.", scoreboardName);
                return;
            }
            xC xCVarA = ((xA) ((xw) abstractC0264juM166a).b()).a().a(serverPlayer);
            if (xCVarA != null) {
                xCVarA.a(jDVar.c());
            }
        }
    }
}
