package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oM.class */
public final class C0795oM {

    /* JADX INFO: renamed from: gi */
    static final /* synthetic */ boolean f4341gi;

    static {
        f4341gi = !C0795oM.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3681a(@NotNull ItemEntityPickupEvent.Pre pre) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4341gi && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        Player player = pre.getPlayer();
        AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a(player);
        if (abstractC0183bM1153a.m1104dt()) {
            pre.setCanPickup(TriState.FALSE);
            return;
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(player.getUUID());
        if (!player.level().isClientSide && abstractC0863pbMo2354a != null) {
            ItemEntity itemEntity = pre.getItemEntity();
            if (abstractC0183bM1153a.m1104dt() || !abstractC0863pbMo2354a.m4018b().mo4224a(player, itemEntity, itemEntity.getItem())) {
                pre.setCanPickup(TriState.FALSE);
            }
        }
    }
}
