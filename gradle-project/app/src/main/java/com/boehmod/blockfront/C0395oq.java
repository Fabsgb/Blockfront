package com.boehmod.blockfront;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oq.class */
public final class C0395oq {
    static final /* synthetic */ boolean fO;

    static {
        fO = !C0395oq.class.desiredAssertionStatus();
    }

    public static void a(@NotNull ItemEntityPickupEvent.Pre pre) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fO && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        Player player = pre.getPlayer();
        com.boehmod.blockfront.common.player.b bVarM305a = cVarM531a.m305a(player);
        if (bVarM305a.dk()) {
            pre.setCanPickup(TriState.FALSE);
            return;
        }
        oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(player.getUUID());
        if (!player.level().isClientSide && oFVarMo604a != null) {
            ItemEntity itemEntity = pre.getItemEntity();
            if (bVarM305a.dk() || !oFVarMo604a.b().a(player, itemEntity, itemEntity.getItem())) {
                pre.setCanPickup(TriState.FALSE);
            }
        }
    }
}
