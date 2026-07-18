package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.EntityMountEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ol */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ol.class */
public class C0819ol {

    /* JADX INFO: renamed from: fJ */
    static final /* synthetic */ boolean f4445fJ;

    static {
        f4445fJ = !C0819ol.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4188a(@NotNull EntityMountEvent entityMountEvent) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4445fJ && abstractC0563juM168a == null) {
            throw new AssertionError();
        }
        Player entityMounting = entityMountEvent.getEntityMounting();
        if ((entityMounting instanceof Player) && abstractC0563juM168a.m2530a(entityMounting) != null && !(entityMountEvent.getEntityBeingMounted() instanceof AbstractC0779ny)) {
            entityMountEvent.setCanceled(true);
        } else if (entityMountEvent.getEntity().getPersistentData().getBoolean(C0799oR.f4378bL)) {
            entityMountEvent.setCanceled(true);
        }
    }
}
