package com.boehmod.blockfront;

import java.util.Iterator;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wb.class */
public final class C1234wb implements CustomPacketPayload {

    /* JADX INFO: renamed from: ae */
    @NotNull
    public static final CustomPacketPayload.Type<C1234wb> f7341ae = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_vehicle_fire_bullet"));

    /* JADX INFO: renamed from: af */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1234wb> f7342af = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7638d(v1);
    }, C1234wb::new);

    public C1234wb() {
    }

    public C1234wb(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m7638d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7341ae;
    }

    /* JADX INFO: renamed from: a */
    public static void m7639a(C1234wb c1234wb, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            Entity vehicle = serverPlayer.getVehicle();
            if (vehicle instanceof AbstractC0779ny) {
                Iterator it = ((AbstractC0779ny) vehicle).m3499b().f3945ak.iterator();
                while (it.hasNext()) {
                    AbstractC0742nN abstractC0742nN = (AbstractC0742nN) it.next();
                    if (abstractC0742nN instanceof C0740nL) {
                        C0740nL c0740nL = (C0740nL) abstractC0742nN;
                        if (serverPlayer.equals(c0740nL.m3410b())) {
                            c0740nL.m3403b(serverPlayer);
                            return;
                        }
                    }
                }
            }
        }
    }
}
