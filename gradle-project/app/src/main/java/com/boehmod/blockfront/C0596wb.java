package com.boehmod.blockfront;

import java.util.Iterator;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wb.class */
public final class C0596wb implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<C0596wb> ae = new CustomPacketPayload.Type<>(C0265jv.d("packet_vehicle_fire_bullet"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0596wb> af = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0596wb::new);

    public C0596wb() {
    }

    public C0596wb(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ae;
    }

    public static void a(C0596wb c0596wb, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            Entity vehicle = serverPlayer.getVehicle();
            if (vehicle instanceof AbstractC0376ny) {
                Iterator it = ((AbstractC0376ny) vehicle).m741b().ak.iterator();
                while (it.hasNext()) {
                    nN nNVar = (nN) it.next();
                    if (nNVar instanceof nL) {
                        nL nLVar = (nL) nNVar;
                        if (serverPlayer.equals(nLVar.b())) {
                            nLVar.b(serverPlayer);
                            return;
                        }
                    }
                }
            }
        }
    }
}
