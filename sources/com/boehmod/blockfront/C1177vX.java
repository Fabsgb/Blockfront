package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vX.class */
public final class C1177vX implements CustomPacketPayload {

    /* JADX INFO: renamed from: aa */
    @NotNull
    public static final CustomPacketPayload.Type<C1177vX> f6218aa;

    /* JADX INFO: renamed from: ab */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1177vX> f6219ab;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final a f6220a;

    /* JADX INFO: renamed from: iU */
    static final /* synthetic */ boolean f6221iU;

    /* JADX INFO: renamed from: com.boehmod.blockfront.vX$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vX$a.class */
    public enum a {
        CYCLE_NEXT,
        CYCLE_PREVIOUS,
        STOP
    }

    static {
        f6221iU = !C1177vX.class.desiredAssertionStatus();
        f6218aa = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_spectate"));
        f6219ab = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6587d(v1);
        }, C1177vX::new);
    }

    public C1177vX(@NotNull a aVar) {
        this.f6220a = aVar;
    }

    public C1177vX(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6220a = (a) friendlyByteBuf.readEnum(a.class);
    }

    /* JADX INFO: renamed from: d */
    public void m6587d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f6220a);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6218aa;
    }

    /* JADX INFO: renamed from: a */
    public static void m6588a(@NotNull C1177vX c1177vX, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f6221iU && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (abstractC0787oFMo2531a == null) {
                return;
            }
            AbstractC0790oI abstractC0790oIM3582b = abstractC0787oFMo2531a.m3582b();
            switch (c1177vX.f6220a) {
                case CYCLE_NEXT:
                    abstractC0790oIM3582b.m3800a(serverPlayer, 1);
                    return;
                case CYCLE_PREVIOUS:
                    abstractC0790oIM3582b.m3800a(serverPlayer, -1);
                    return;
                case STOP:
                    abstractC0790oIM3582b.m3801b(abstractC0563juM168a, serverPlayer);
                    return;
                default:
                    return;
            }
        }
    }
}
