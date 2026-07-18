package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oq.class */
public final class C0824oq {

    /* JADX INFO: renamed from: fO */
    static final /* synthetic */ boolean f4450fO;

    static {
        f4450fO = !C0824oq.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4193a(@NotNull ItemEntityPickupEvent.Pre pre) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4450fO && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        Player player = pre.getPlayer();
        AbstractC0182b abstractC0182bM1136a = abstractC0183cM2528a.m1136a(player);
        if (abstractC0182bM1136a.m1087dk()) {
            pre.setCanPickup(TriState.FALSE);
            return;
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(player.getUUID());
        if (!player.level().isClientSide && abstractC0787oFMo2531a != null) {
            ItemEntity itemEntity = pre.getItemEntity();
            if (abstractC0182bM1136a.m1087dk() || !abstractC0787oFMo2531a.m3582b().mo3788a(player, itemEntity, itemEntity.getItem())) {
                pre.setCanPickup(TriState.FALSE);
            }
        }
    }
}
