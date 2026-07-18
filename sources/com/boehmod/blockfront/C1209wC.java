package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wC.class */
public final class C1209wC implements CustomPacketPayload {

    /* JADX INFO: renamed from: jm */
    public boolean f6349jm;

    /* JADX INFO: renamed from: aF */
    @NotNull
    public static final CustomPacketPayload.Type<C1209wC> f6350aF = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_gun_reload_client"));

    /* JADX INFO: renamed from: aG */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1209wC> f6351aG = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6719d(v1);
    }, C1209wC::new);

    public C1209wC() {
    }

    public C1209wC(boolean z) {
        this.f6349jm = z;
    }

    public C1209wC(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6349jm = friendlyByteBuf.readBoolean();
    }

    /* JADX INFO: renamed from: d */
    public void m6719d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f6349jm);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6350aF;
    }

    /* JADX INFO: renamed from: b */
    public static void m6720b(C1209wC c1209wC, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2931a(c1209wC, iPayloadContext);
    }
}
