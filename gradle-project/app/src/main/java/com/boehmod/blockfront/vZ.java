package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vZ.class */
public final class vZ implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<vZ> ac = new CustomPacketPayload.Type<>(C0265jv.d("packet_use_item"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vZ> ad = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vZ::new);

    public vZ() {
    }

    public vZ(FriendlyByteBuf friendlyByteBuf) {
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ac;
    }

    public static void a(vZ vZVar, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        if (player instanceof ServerPlayer) {
            Player player2 = (ServerPlayer) player;
            ItemStack mainHandItem = player2.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof AbstractC0542ub) {
                AbstractC0542ub abstractC0542ub = (AbstractC0542ub) item;
                abstractC0542ub.a(C0002a.a().m166a(), player2.serverLevel(), player2, abstractC0542ub, mainHandItem);
            }
        }
    }
}
