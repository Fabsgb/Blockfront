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

/* JADX INFO: renamed from: com.boehmod.blockfront.xG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xG.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public final class C1266xG {

    /* JADX INFO: renamed from: jK */
    static final /* synthetic */ boolean f7457jK;

    static {
        f7457jK = !C1266xG.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m7755a(@NotNull AttackEntityEvent attackEntityEvent) {
        Player entity = attackEntityEvent.getEntity();
        if (entity.getMainHandItem().getItem() instanceof C1144ur) {
            attackEntityEvent.setCanceled(true);
            return;
        }
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f7457jK && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (abstractC0563juM168a.m2530a(entity) != null && (attackEntityEvent.getTarget() instanceof HangingEntity)) {
            attackEntityEvent.setCanceled(true);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m7756b(PlayerInteractEvent.EntityInteract entityInteract) {
        Player entity = entityInteract.getEntity();
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a == null || abstractC0563juM168a.m2530a(entity) == null) {
            return;
        }
        Entity target = entityInteract.getTarget();
        if (target instanceof HangingEntity) {
            entityInteract.setCanceled(true);
        } else if (target.getPersistentData().hasUUID(C0799oR.f4377bK)) {
            entityInteract.setCanceled(true);
        }
    }
}
