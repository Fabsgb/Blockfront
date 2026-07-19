package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vX.class */
public final class vX implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<vX> aa;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vX> ab;

    @NotNull
    private final a a;
    static final /* synthetic */ boolean iU;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vX$a.class */
    public enum a {
        CYCLE_NEXT,
        CYCLE_PREVIOUS,
        STOP
    }

    static {
        iU = !vX.class.desiredAssertionStatus();
        aa = new CustomPacketPayload.Type<>(C0265jv.d("packet_spectate"));
        ab = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, vX::new);
    }

    public vX(@NotNull a aVar) {
        this.a = aVar;
    }

    public vX(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.a = (a) friendlyByteBuf.readEnum(a.class);
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.a);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aa;
    }

    public static void a(@NotNull vX vXVar, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!iU && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (oFVarMo604a == null) {
                return;
            }
            oI oIVarB = oFVarMo604a.b();
            switch (vXVar.a) {
                case CYCLE_NEXT:
                    oIVarB.a(serverPlayer, 1);
                    return;
                case CYCLE_PREVIOUS:
                    oIVarB.a(serverPlayer, -1);
                    return;
                case STOP:
                    oIVarB.b(abstractC0264juM166a, serverPlayer);
                    return;
                default:
                    return;
            }
        }
    }
}
