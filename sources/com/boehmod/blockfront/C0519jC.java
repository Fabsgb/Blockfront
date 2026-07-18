package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jC.class */
public class C0519jC implements CustomPacketPayload {

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final CustomPacketPayload.Type<C0519jC> f3058b = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_screenshot_request"));

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0519jC> f3059b = CustomPacketPayload.codec((v0, v1) -> {
        v0.m2278d(v1);
    }, C0519jC::new);

    public C0519jC() {
    }

    public C0519jC(FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m2278d(FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f3058b;
    }

    /* JADX INFO: renamed from: b */
    public static void m2279b(C0519jC c0519jC, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2959a(c0519jC, iPayloadContext);
    }
}
