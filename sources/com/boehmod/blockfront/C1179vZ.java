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

/* JADX INFO: renamed from: com.boehmod.blockfront.vZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vZ.class */
public final class C1179vZ implements CustomPacketPayload {

    /* JADX INFO: renamed from: ac */
    @NotNull
    public static final CustomPacketPayload.Type<C1179vZ> f6225ac = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_use_item"));

    /* JADX INFO: renamed from: ad */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1179vZ> f6226ad = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6593d(v1);
    }, C1179vZ::new);

    public C1179vZ() {
    }

    public C1179vZ(FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m6593d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6225ac;
    }

    /* JADX INFO: renamed from: a */
    public static void m6594a(C1179vZ c1179vZ, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        if (player instanceof ServerPlayer) {
            Player player2 = (ServerPlayer) player;
            ItemStack mainHandItem = player2.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof AbstractC1128ub) {
                AbstractC1128ub abstractC1128ub = (AbstractC1128ub) item;
                abstractC1128ub.mo5962a(C0029a.m164a().m168a(), player2.serverLevel(), player2, abstractC1128ub, mainHandItem);
            }
        }
    }
}
