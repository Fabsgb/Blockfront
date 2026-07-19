package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.EntityMountEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ol, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ol.class */
public class C0390ol {
    static final /* synthetic */ boolean fJ;

    static {
        fJ = !C0390ol.class.desiredAssertionStatus();
    }

    public static void a(@NotNull EntityMountEvent entityMountEvent) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fJ && abstractC0264juM166a == null) {
            throw new AssertionError();
        }
        Player entityMounting = entityMountEvent.getEntityMounting();
        if ((entityMounting instanceof Player) && abstractC0264juM166a.a(entityMounting) != null && !(entityMountEvent.getEntityBeingMounted() instanceof AbstractC0376ny)) {
            entityMountEvent.setCanceled(true);
        } else if (entityMountEvent.getEntity().getPersistentData().getBoolean(oR.bL)) {
            entityMountEvent.setCanceled(true);
        }
    }
}
