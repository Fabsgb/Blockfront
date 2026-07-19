package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wF.class */
public final class wF implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<wF> aI;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, wF> aJ;
    static final /* synthetic */ boolean jr;

    static {
        jr = !wF.class.desiredAssertionStatus();
        aI = new CustomPacketPayload.Type<>(C0265jv.d("packet_gun_trigger"));
        aJ = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, wF::new);
    }

    public wF() {
    }

    public wF(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aI;
    }

    public static void a(wF wFVar, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!jr && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        LivingEntity livingEntityPlayer = iPayloadContext.player();
        if (cVarM531a.m305a((Player) livingEntityPlayer).dm()) {
            return;
        }
        ItemStack selected = livingEntityPlayer.getInventory().getSelected();
        if (selected.isEmpty()) {
            return;
        }
        Item item = selected.getItem();
        if (item instanceof C0558ur) {
            ((C0558ur) item).m1214a(selected, livingEntityPlayer.level(), livingEntityPlayer);
        }
    }
}
