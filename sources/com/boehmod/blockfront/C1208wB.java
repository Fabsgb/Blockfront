package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wB.class */
public final class C1208wB implements CustomPacketPayload {

    /* JADX INFO: renamed from: aE */
    @NotNull
    public static final CustomPacketPayload.Type<C1208wB> f6347aE = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_gun_reload"));

    /* JADX INFO: renamed from: aF */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1208wB> f6348aF = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6717d(v1);
    }, C1208wB::new);

    public C1208wB() {
    }

    public C1208wB(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m6717d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6347aE;
    }

    /* JADX INFO: renamed from: a */
    public static void m6718a(C1208wB c1208wB, @NotNull IPayloadContext iPayloadContext) {
        LivingEntity livingEntityPlayer = iPayloadContext.player();
        ItemStack mainHandItem = livingEntityPlayer.getMainHandItem();
        ItemStack offhandItem = livingEntityPlayer.getOffhandItem();
        Item item = mainHandItem.getItem();
        if (item instanceof C1144ur) {
            C1144ur c1144ur = (C1144ur) item;
            if (c1144ur.m6368a(livingEntityPlayer, livingEntityPlayer.level(), mainHandItem, true)) {
                c1144ur.m6368a(livingEntityPlayer, livingEntityPlayer.level(), mainHandItem, true);
                return;
            }
        }
        Item item2 = offhandItem.getItem();
        if (item2 instanceof C1144ur) {
            C1144ur c1144ur2 = (C1144ur) item2;
            if (c1144ur2.m6368a(livingEntityPlayer, livingEntityPlayer.level(), offhandItem, false)) {
                c1144ur2.m6368a(livingEntityPlayer, livingEntityPlayer.level(), offhandItem, false);
            }
        }
    }
}
