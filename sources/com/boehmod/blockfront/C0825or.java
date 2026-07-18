package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.or */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/or.class */
public class C0825or {

    /* JADX INFO: renamed from: fP */
    static final /* synthetic */ boolean f4451fP;

    static {
        f4451fP = !C0825or.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4194a(@NotNull LivingKnockBackEvent livingKnockBackEvent) {
        Player entity = livingKnockBackEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f4451fP && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            livingKnockBackEvent.setCanceled(abstractC0563juM168a.m2535e(player.getUUID()));
        }
    }
}
