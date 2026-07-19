package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.or, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/or.class */
public class C0396or {
    static final /* synthetic */ boolean fP;

    static {
        fP = !C0396or.class.desiredAssertionStatus();
    }

    public static void a(@NotNull LivingKnockBackEvent livingKnockBackEvent) {
        Player entity = livingKnockBackEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!fP && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            livingKnockBackEvent.setCanceled(abstractC0264juM166a.e(player.getUUID()));
        }
    }
}
