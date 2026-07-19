package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wC.class */
public final class wC implements CustomPacketPayload {
    public boolean jm;

    @NotNull
    public static final CustomPacketPayload.Type<wC> aF = new CustomPacketPayload.Type<>(C0265jv.d("packet_gun_reload_client"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, wC> aG = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, wC::new);

    public wC() {
    }

    public wC(boolean z) {
        this.jm = z;
    }

    public wC(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.jm = friendlyByteBuf.readBoolean();
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.jm);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aF;
    }

    public static void b(wC wCVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(wCVar, iPayloadContext);
    }
}
