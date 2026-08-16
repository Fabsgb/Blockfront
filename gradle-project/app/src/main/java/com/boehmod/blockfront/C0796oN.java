package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oN.class */
public class C0796oN {

    /* JADX INFO: renamed from: gj */
    static final /* synthetic */ boolean f4342gj;

    static {
        f4342gj = !C0796oN.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3682a(@NotNull LivingKnockBackEvent livingKnockBackEvent) {
        Player entity = livingKnockBackEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4342gj && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            livingKnockBackEvent.setCanceled(abstractC0531jNM179a.m2358e(player.getUUID()));
        }
    }
}
