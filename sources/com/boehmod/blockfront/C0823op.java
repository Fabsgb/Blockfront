package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.op */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/op.class */
public final class C0823op {

    /* JADX INFO: renamed from: fN */
    static final /* synthetic */ boolean f4449fN;

    static {
        f4449fN = !C0823op.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4192a(@NotNull LivingDropsEvent livingDropsEvent) {
        Player entity = livingDropsEvent.getEntity();
        if (entity instanceof C0727mz) {
            livingDropsEvent.setCanceled(true);
            return;
        }
        if (entity.getPersistentData().hasUUID(C0799oR.f4377bK)) {
            livingDropsEvent.setCanceled(true);
            return;
        }
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f4449fN && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(player.getUUID());
            if (abstractC0787oFMo2531a != null && !player.level().isClientSide) {
                Collection drops = livingDropsEvent.getDrops();
                List<ItemEntity> listMo3786a = abstractC0787oFMo2531a.m3582b().mo3786a(player, (List<ItemEntity>) new ObjectArrayList(drops));
                if (listMo3786a == null || listMo3786a.isEmpty()) {
                    livingDropsEvent.setCanceled(true);
                } else {
                    drops.clear();
                    drops.addAll(listMo3786a);
                }
            }
        }
    }
}
