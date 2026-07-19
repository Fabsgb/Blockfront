package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oy.class */
public final class C0403oy {
    static final /* synthetic */ boolean fU;

    static {
        fU = !C0403oy.class.desiredAssertionStatus();
    }

    public static void a(@NotNull BlockEvent.FarmlandTrampleEvent farmlandTrampleEvent) {
        Player entity = farmlandTrampleEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!fU && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0264juM166a.a(player) != null) {
                farmlandTrampleEvent.setCanceled(true);
            }
        }
        if (farmlandTrampleEvent.getEntity() instanceof C0350mz) {
            farmlandTrampleEvent.setCanceled(true);
        }
        if (farmlandTrampleEvent.getEntity() instanceof C0349my) {
            farmlandTrampleEvent.setCanceled(true);
        }
    }
}
