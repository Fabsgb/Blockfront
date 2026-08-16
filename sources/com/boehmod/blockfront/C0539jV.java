package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jV.class */
public class C0539jV implements CustomPacketPayload {

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final CustomPacketPayload.Type<C0539jV> f3214b = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_screenshot_request"));

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0539jV> f3215b = CustomPacketPayload.codec((v0, v1) -> {
        v0.m2412d(v1);
    }, C0539jV::new);

    public C0539jV() {
    }

    public C0539jV(FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m2412d(FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f3214b;
    }

    /* JADX INFO: renamed from: b */
    public static void m2413b(C0539jV c0539jV, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2970a(c0539jV, iPayloadContext);
    }
}
