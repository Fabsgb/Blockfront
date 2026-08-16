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

/* JADX INFO: renamed from: com.boehmod.blockfront.wz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wz.class */
public final class C1259wz implements CustomPacketPayload {

    /* JADX INFO: renamed from: ac */
    @NotNull
    public static final CustomPacketPayload.Type<C1259wz> f6801ac = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_use_item"));

    /* JADX INFO: renamed from: ad */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1259wz> f6802ad = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7119d(v1);
    }, C1259wz::new);

    public C1259wz() {
    }

    public C1259wz(FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m7119d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6801ac;
    }

    /* JADX INFO: renamed from: a */
    public static void m7120a(C1259wz c1259wz, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        if (player instanceof ServerPlayer) {
            Player player2 = (ServerPlayer) player;
            ItemStack mainHandItem = player2.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof AbstractC1153uz) {
                AbstractC1153uz abstractC1153uz = (AbstractC1153uz) item;
                abstractC1153uz.mo6579a(C0030a.m175a().m179a(), player2.serverLevel(), player2, abstractC1153uz, mainHandItem);
            }
        }
    }
}
