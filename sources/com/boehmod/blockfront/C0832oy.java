package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oy.class */
public final class C0832oy {

    /* JADX INFO: renamed from: fU */
    static final /* synthetic */ boolean f4456fU;

    static {
        f4456fU = !C0832oy.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4201a(@NotNull BlockEvent.FarmlandTrampleEvent farmlandTrampleEvent) {
        Player entity = farmlandTrampleEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f4456fU && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0563juM168a.m2530a(player) != null) {
                farmlandTrampleEvent.setCanceled(true);
            }
        }
        if (farmlandTrampleEvent.getEntity() instanceof C0727mz) {
            farmlandTrampleEvent.setCanceled(true);
        }
        if (farmlandTrampleEvent.getEntity() instanceof C0726my) {
            farmlandTrampleEvent.setCanceled(true);
        }
    }
}
