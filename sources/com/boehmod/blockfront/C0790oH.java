package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.EntityMountEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oH.class */
public class C0790oH {

    /* JADX INFO: renamed from: gd */
    static final /* synthetic */ boolean f4336gd;

    static {
        f4336gd = !C0790oH.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3676a(@NotNull EntityMountEvent entityMountEvent) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4336gd && abstractC0531jNM179a == null) {
            throw new AssertionError();
        }
        Player entityMounting = entityMountEvent.getEntityMounting();
        if ((entityMounting instanceof Player) && abstractC0531jNM179a.m2353a(entityMounting) != null && !(entityMountEvent.getEntityBeingMounted() instanceof AbstractC0750nU)) {
            entityMountEvent.setCanceled(true);
        } else if (entityMountEvent.getEntity().getPersistentData().getBoolean(C0875pn.f4774bV)) {
            entityMountEvent.setCanceled(true);
        }
    }
}
