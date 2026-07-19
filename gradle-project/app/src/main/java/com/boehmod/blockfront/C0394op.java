package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.op, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/op.class */
public final class C0394op {
    static final /* synthetic */ boolean fN;

    static {
        fN = !C0394op.class.desiredAssertionStatus();
    }

    public static void a(@NotNull LivingDropsEvent livingDropsEvent) {
        Player entity = livingDropsEvent.getEntity();
        if (entity instanceof C0350mz) {
            livingDropsEvent.setCanceled(true);
            return;
        }
        if (entity.getPersistentData().hasUUID(oR.bK)) {
            livingDropsEvent.setCanceled(true);
            return;
        }
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!fN && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(player.getUUID());
            if (oFVarMo604a != null && !player.level().isClientSide) {
                Collection drops = livingDropsEvent.getDrops();
                List<ItemEntity> listA = oFVarMo604a.b().a(player, (List<ItemEntity>) new ObjectArrayList(drops));
                if (listA == null || listA.isEmpty()) {
                    livingDropsEvent.setCanceled(true);
                } else {
                    drops.clear();
                    drops.addAll(listA);
                }
            }
        }
    }
}
