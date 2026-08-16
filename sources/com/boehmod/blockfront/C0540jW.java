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

/* JADX INFO: renamed from: com.boehmod.blockfront.jW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jW.class */
public final class C0540jW extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: f */
    private final byte[] f3216f;

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final CustomPacketPayload.Type<C0540jW> f3217c = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_screenshot_response"));

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0540jW> f3218c = CustomPacketPayload.codec((v0, v1) -> {
        v0.m2414d(v1);
    }, C0540jW::new);

    public C0540jW(byte[] bArr) {
        this.f3216f = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0540jW.class), C0540jW.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jW;->f:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0540jW.class), C0540jW.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jW;->f:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0540jW.class, Object.class), C0540jW.class, "bytes", "FIELD:Lcom/boehmod/blockfront/jW;->f:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: c */
    public byte[] m2416c() {
        return this.f3216f;
    }

    public C0540jW(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m2414d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.f3216f);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f3217c;
    }

    /* JADX INFO: renamed from: a */
    public static void m2415a(C0540jW c0540jW, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            String scoreboardName = serverPlayer.getScoreboardName();
            C0530jM.log("[Screenshot] Received screenshot data from player '%s'.", scoreboardName);
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!(abstractC0531jNM179a instanceof C1280xT)) {
                C0530jM.logError("[Screenshot] Failed to receive screenshot data from player '%s' - Server Manager is null.", scoreboardName);
                return;
            }
            C1286xZ c1286xZM7303a = ((C1284xX) ((C1280xT) abstractC0531jNM179a).m7289b()).m2407a().m7303a(serverPlayer);
            if (c1286xZM7303a != null) {
                c1286xZM7303a.m7308a(c0540jW.m2416c());
            }
        }
    }
}
