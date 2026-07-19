package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jC.class */
public class jC implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<jC> b = new CustomPacketPayload.Type<>(C0265jv.d("packet_screenshot_request"));

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, jC> f177b = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, jC::new);

    public jC() {
    }

    public jC(FriendlyByteBuf friendlyByteBuf) {
    }

    public void d(FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return b;
    }

    public static void b(jC jCVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(jCVar, iPayloadContext);
    }
}
