package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wA.class */
public final class wA implements CustomPacketPayload {
    private static final int sT = 2;

    @NotNull
    public static final CustomPacketPayload.Type<wA> aD;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, wA> aE;
    static final /* synthetic */ boolean jl;

    static {
        jl = !wA.class.desiredAssertionStatus();
        aD = new CustomPacketPayload.Type<>(C0265jv.d("packet_gun_dry_fire"));
        aE = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, wA::new);
    }

    public wA() {
    }

    public wA(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aD;
    }

    public static void a(wA wAVar, @NotNull IPayloadContext iPayloadContext) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM1212a;
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!jl && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        Player player = iPayloadContext.player();
        com.boehmod.blockfront.common.player.b bVarM305a = cVarM531a.m305a(player);
        if (bVarM305a.dm()) {
            return;
        }
        ItemStack selected = player.getInventory().getSelected();
        if (selected.isEmpty()) {
            return;
        }
        Item item = selected.getItem();
        if (item instanceof C0558ur) {
            C0558ur c0558ur = (C0558ur) item;
            if (C0558ur.e(selected) || (deferredHolderM1212a = c0558ur.m1212a(selected)) == null) {
                return;
            }
            Level level = player.level();
            if (bVarM305a.a(level.getGameTime(), Math.max(1, c0558ur.bX() - 2))) {
                Vec3 eyePosition = player.getEyePosition();
                level.playSound(player, eyePosition.x, eyePosition.y, eyePosition.z, (SoundEvent) deferredHolderM1212a.get(), SoundSource.PLAYERS, 0.25f, 1.0f);
            }
        }
    }
}
