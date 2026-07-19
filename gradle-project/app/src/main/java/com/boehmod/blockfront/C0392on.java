package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.level.ExplosionKnockbackEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.on, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/on.class */
public final class C0392on {
    static final /* synthetic */ boolean fL;

    static {
        fL = !C0392on.class.desiredAssertionStatus();
    }

    public static void a(@NotNull ExplosionKnockbackEvent explosionKnockbackEvent) {
        Player affectedEntity = explosionKnockbackEvent.getAffectedEntity();
        if (affectedEntity instanceof Player) {
            Player player = affectedEntity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!fL && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0264juM166a.a(player) != null) {
                explosionKnockbackEvent.setKnockbackVelocity(Vec3.ZERO);
            }
        }
    }
}
