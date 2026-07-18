package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.level.ExplosionKnockbackEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.on */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/on.class */
public final class C0821on {

    /* JADX INFO: renamed from: fL */
    static final /* synthetic */ boolean f4447fL;

    static {
        f4447fL = !C0821on.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4190a(@NotNull ExplosionKnockbackEvent explosionKnockbackEvent) {
        Player affectedEntity = explosionKnockbackEvent.getAffectedEntity();
        if (affectedEntity instanceof Player) {
            Player player = affectedEntity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f4447fL && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0563juM168a.m2530a(player) != null) {
                explosionKnockbackEvent.setKnockbackVelocity(Vec3.ZERO);
            }
        }
    }
}
