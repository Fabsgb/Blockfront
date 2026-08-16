package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wx.class */
public final class C1257wx implements CustomPacketPayload {

    /* JADX INFO: renamed from: aa */
    @NotNull
    public static final CustomPacketPayload.Type<C1257wx> f6794aa;

    /* JADX INFO: renamed from: ab */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1257wx> f6795ab;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final a f6796a;

    /* JADX INFO: renamed from: jn */
    static final /* synthetic */ boolean f6797jn;

    /* JADX INFO: renamed from: com.boehmod.blockfront.wx$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wx$a.class */
    public enum a {
        CYCLE_NEXT,
        CYCLE_PREVIOUS,
        STOP
    }

    static {
        f6797jn = !C1257wx.class.desiredAssertionStatus();
        f6794aa = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_spectate"));
        f6795ab = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7113d(v1);
        }, C1257wx::new);
    }

    public C1257wx(@NotNull a aVar) {
        this.f6796a = aVar;
    }

    public C1257wx(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6796a = (a) friendlyByteBuf.readEnum(a.class);
    }

    /* JADX INFO: renamed from: d */
    public void m7113d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f6796a);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6794aa;
    }

    /* JADX INFO: renamed from: a */
    public static void m7114a(@NotNull C1257wx c1257wx, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f6797jn && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (abstractC0863pbMo2354a == null) {
                return;
            }
            AbstractC0866pe abstractC0866peM4018b = abstractC0863pbMo2354a.m4018b();
            switch (c1257wx.f6796a) {
                case CYCLE_NEXT:
                    abstractC0866peM4018b.m4236a(serverPlayer, 1);
                    return;
                case CYCLE_PREVIOUS:
                    abstractC0866peM4018b.m4236a(serverPlayer, -1);
                    return;
                case STOP:
                    abstractC0866peM4018b.m4237b(abstractC0531jNM179a, serverPlayer);
                    return;
                default:
                    return;
            }
        }
    }
}
