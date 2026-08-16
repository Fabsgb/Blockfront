package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oC.class */
public final class C0785oC {

    /* JADX INFO: renamed from: ga */
    static final /* synthetic */ boolean f4330ga;

    static {
        f4330ga = !C0785oC.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3665a(@NotNull BlockEvent.BreakEvent breakEvent) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4330ga && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Player player = breakEvent.getPlayer();
        UUID uuid = player.getUUID();
        Block block = breakEvent.getLevel().getBlockState(breakEvent.getPos()).getBlock();
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
        if (abstractC0863pbMo2354a != null && !abstractC0863pbMo2354a.m4018b().mo4257a(player, block)) {
            breakEvent.setCanceled(true);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3666a(BlockEvent.EntityPlaceEvent entityPlaceEvent) {
        Player entity = entityPlaceEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4330ga && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(player.getUUID());
            if (abstractC0863pbMo2354a != null && !abstractC0863pbMo2354a.m4018b().mo4258b(player, entityPlaceEvent.getLevel().getBlockState(entityPlaceEvent.getPos()).getBlock())) {
                entityPlaceEvent.setCanceled(true);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m3667b(PlayerInteractEvent.RightClickBlock rightClickBlock) {
        Player entity = rightClickBlock.getEntity();
        Level level = entity.level();
        UUID uuid = entity.getUUID();
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4330ga && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
        if (abstractC0863pbMo2354a == null) {
            return;
        }
        BlockPos pos = rightClickBlock.getPos();
        Block block = level.getBlockState(pos).getBlock();
        if (block instanceof AirBlock) {
            return;
        }
        AbstractC0184c<?> abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        AbstractC0866pe abstractC0866peM4018b = abstractC0863pbMo2354a.m4018b();
        if (!abstractC0866peM4018b.mo4259a(abstractC0184cM2351a, level, entity, block, pos) || !abstractC0866peM4018b.mo4225a(abstractC0184cM2351a, level, entity, uuid, block, pos)) {
            rightClickBlock.setCanceled(true);
        }
    }
}
