package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oU.class */
public final class C0803oU {

    /* JADX INFO: renamed from: go */
    static final /* synthetic */ boolean f4347go;

    static {
        f4347go = !C0803oU.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3689a(@NotNull BlockEvent.FarmlandTrampleEvent farmlandTrampleEvent) {
        Player entity = farmlandTrampleEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4347go && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0531jNM179a.m2353a(player) != null) {
                farmlandTrampleEvent.setCanceled(true);
            }
        }
        if (farmlandTrampleEvent.getEntity() instanceof C0698mV) {
            farmlandTrampleEvent.setCanceled(true);
        }
        if (farmlandTrampleEvent.getEntity() instanceof C0697mU) {
            farmlandTrampleEvent.setCanceled(true);
        }
    }
}
