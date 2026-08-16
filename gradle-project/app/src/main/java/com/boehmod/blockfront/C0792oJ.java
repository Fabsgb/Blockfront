package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.level.ExplosionKnockbackEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oJ.class */
public final class C0792oJ {

    /* JADX INFO: renamed from: gf */
    static final /* synthetic */ boolean f4338gf;

    static {
        f4338gf = !C0792oJ.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3678a(@NotNull ExplosionKnockbackEvent explosionKnockbackEvent) {
        Player affectedEntity = explosionKnockbackEvent.getAffectedEntity();
        if (affectedEntity instanceof Player) {
            Player player = affectedEntity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4338gf && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0531jNM179a.m2353a(player) != null) {
                explosionKnockbackEvent.setKnockbackVelocity(Vec3.ZERO);
            }
        }
    }
}
