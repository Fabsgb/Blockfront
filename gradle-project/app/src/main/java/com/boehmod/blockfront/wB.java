package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wB.class */
public final class wB implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<wB> aE = new CustomPacketPayload.Type<>(C0265jv.d("packet_gun_reload"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, wB> aF = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, wB::new);

    public wB() {
    }

    public wB(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aE;
    }

    public static void a(wB wBVar, @NotNull IPayloadContext iPayloadContext) {
        LivingEntity livingEntityPlayer = iPayloadContext.player();
        ItemStack mainHandItem = livingEntityPlayer.getMainHandItem();
        ItemStack offhandItem = livingEntityPlayer.getOffhandItem();
        Item item = mainHandItem.getItem();
        if (item instanceof C0558ur) {
            C0558ur c0558ur = (C0558ur) item;
            if (c0558ur.a(livingEntityPlayer, livingEntityPlayer.level(), mainHandItem, true)) {
                c0558ur.a(livingEntityPlayer, livingEntityPlayer.level(), mainHandItem, true);
                return;
            }
        }
        Item item2 = offhandItem.getItem();
        if (item2 instanceof C0558ur) {
            C0558ur c0558ur2 = (C0558ur) item2;
            if (c0558ur2.a(livingEntityPlayer, livingEntityPlayer.level(), offhandItem, false)) {
                c0558ur2.a(livingEntityPlayer, livingEntityPlayer.level(), offhandItem, false);
            }
        }
    }
}
