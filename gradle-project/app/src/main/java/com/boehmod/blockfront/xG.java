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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xG.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public final class xG {
    static final /* synthetic */ boolean jK;

    static {
        jK = !xG.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    public static void a(@NotNull AttackEntityEvent attackEntityEvent) {
        Player entity = attackEntityEvent.getEntity();
        if (entity.getMainHandItem().getItem() instanceof C0558ur) {
            attackEntityEvent.setCanceled(true);
            return;
        }
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!jK && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (abstractC0264juM166a.a(entity) != null && (attackEntityEvent.getTarget() instanceof HangingEntity)) {
            attackEntityEvent.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void b(PlayerInteractEvent.EntityInteract entityInteract) {
        Player entity = entityInteract.getEntity();
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a == null || abstractC0264juM166a.a(entity) == null) {
            return;
        }
        Entity target = entityInteract.getTarget();
        if (target instanceof HangingEntity) {
            entityInteract.setCanceled(true);
        } else if (target.getPersistentData().hasUUID(oR.bK)) {
            entityInteract.setCanceled(true);
        }
    }
}
