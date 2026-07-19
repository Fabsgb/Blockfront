package com.boehmod.blockfront;

import java.util.Iterator;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wd.class */
public final class C0598wd implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<C0598wd> ag = new CustomPacketPayload.Type<>(C0265jv.d("packet_vehicle_fire_shell"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0598wd> ah = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0598wd::new);

    public C0598wd() {
    }

    public C0598wd(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ag;
    }

    public static void a(C0598wd c0598wd, @NotNull IPayloadContext iPayloadContext) {
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
                        if (serverPlayer.equals(nLVar.b()) && nLVar.m724a() == nM.SHELL) {
                            nLVar.c(serverPlayer);
                            return;
                        }
                    }
                }
            }
        }
    }
}
