package com.boehmod.blockfront;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ye */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ye.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public final class C1318ye {

    /* JADX INFO: renamed from: ka */
    static final /* synthetic */ boolean f9041ka;

    static {
        f9041ka = !C1318ye.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m8271a(@NotNull AttackEntityEvent attackEntityEvent) {
        Player entity = attackEntityEvent.getEntity();
        if (entity.getMainHandItem().getItem() instanceof C1117uP) {
            attackEntityEvent.setCanceled(true);
            return;
        }
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f9041ka && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (abstractC0531jNM179a.m2353a(entity) != null && (attackEntityEvent.getTarget() instanceof HangingEntity)) {
            attackEntityEvent.setCanceled(true);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m8272b(PlayerInteractEvent.EntityInteract entityInteract) {
        Player entity = entityInteract.getEntity();
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a == null || abstractC0531jNM179a.m2353a(entity) == null) {
            return;
        }
        Entity target = entityInteract.getTarget();
        if (target instanceof HangingEntity) {
            entityInteract.setCanceled(true);
        } else if (target.getPersistentData().hasUUID(C0875pn.f4773bU)) {
            entityInteract.setCanceled(true);
        }
    }
}
