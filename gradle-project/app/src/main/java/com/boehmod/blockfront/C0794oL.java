package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oL.class */
public final class C0794oL {

    /* JADX INFO: renamed from: gh */
    static final /* synthetic */ boolean f4340gh;

    static {
        f4340gh = !C0794oL.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3680a(@NotNull LivingDropsEvent livingDropsEvent) {
        Player entity = livingDropsEvent.getEntity();
        if (entity instanceof C0698mV) {
            livingDropsEvent.setCanceled(true);
            return;
        }
        if (entity.getPersistentData().hasUUID(C0875pn.f4773bU)) {
            livingDropsEvent.setCanceled(true);
            return;
        }
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4340gh && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(player.getUUID());
            if (abstractC0863pbMo2354a != null && !player.level().isClientSide) {
                Collection drops = livingDropsEvent.getDrops();
                List<ItemEntity> listMo4222a = abstractC0863pbMo2354a.m4018b().mo4222a(player, (List<ItemEntity>) new ObjectArrayList(drops));
                if (listMo4222a == null || listMo4222a.isEmpty()) {
                    livingDropsEvent.setCanceled(true);
                } else {
                    drops.clear();
                    drops.addAll(listMo4222a);
                }
            }
        }
    }
}
