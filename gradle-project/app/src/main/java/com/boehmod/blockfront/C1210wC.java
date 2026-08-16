package com.boehmod.blockfront;

import java.util.Iterator;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wC.class */
public final class C1210wC implements CustomPacketPayload {

    /* JADX INFO: renamed from: af */
    @NotNull
    public static final CustomPacketPayload.Type<C1210wC> f6589af = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_vehicle_fire_shell"));

    /* JADX INFO: renamed from: ag */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1210wC> f6590ag = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6916d(v1);
    }, C1210wC::new);

    public C1210wC() {
    }

    public C1210wC(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m6916d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6589af;
    }

    /* JADX INFO: renamed from: a */
    public static void m6917a(C1210wC c1210wC, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            Entity vehicle = serverPlayer.getVehicle();
            if (vehicle instanceof AbstractC0750nU) {
                Iterator it = ((AbstractC0750nU) vehicle).m3436b().f4373ar.iterator();
                while (it.hasNext()) {
                    AbstractC0818oj abstractC0818oj = (AbstractC0818oj) it.next();
                    if (abstractC0818oj instanceof C0816oh) {
                        C0816oh c0816oh = (C0816oh) abstractC0818oj;
                        if (serverPlayer.equals(c0816oh.m3782b()) && c0816oh.m3763a() == EnumC0817oi.SHELL) {
                            c0816oh.m3776c(serverPlayer);
                            return;
                        }
                    }
                }
            }
        }
    }
}
