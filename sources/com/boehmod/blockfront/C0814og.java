package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.og */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/og.class */
public final class C0814og {

    /* JADX INFO: renamed from: fG */
    static final /* synthetic */ boolean f4439fG;

    static {
        f4439fG = !C0814og.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4178a(@NotNull BlockEvent.BreakEvent breakEvent) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4439fG && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Player player = breakEvent.getPlayer();
        UUID uuid = player.getUUID();
        Block block = breakEvent.getLevel().getBlockState(breakEvent.getPos()).getBlock();
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
        if (abstractC0787oFMo2531a != null && !abstractC0787oFMo2531a.m3582b().mo3821a(player, block)) {
            breakEvent.setCanceled(true);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4179a(BlockEvent.EntityPlaceEvent entityPlaceEvent) {
        Player entity = entityPlaceEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f4439fG && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(player.getUUID());
            if (abstractC0787oFMo2531a != null && !abstractC0787oFMo2531a.m3582b().mo3822b(player, entityPlaceEvent.getLevel().getBlockState(entityPlaceEvent.getPos()).getBlock())) {
                entityPlaceEvent.setCanceled(true);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4180b(PlayerInteractEvent.RightClickBlock rightClickBlock) {
        Player entity = rightClickBlock.getEntity();
        Level level = entity.level();
        UUID uuid = entity.getUUID();
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4439fG && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
        if (abstractC0787oFMo2531a == null) {
            return;
        }
        BlockPos pos = rightClickBlock.getPos();
        Block block = level.getBlockState(pos).getBlock();
        if (block instanceof AirBlock) {
            return;
        }
        AbstractC0183c<?> abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        AbstractC0790oI abstractC0790oIM3582b = abstractC0787oFMo2531a.m3582b();
        if (!abstractC0790oIM3582b.mo3823a(abstractC0183cM2528a, level, entity, block, pos) || !abstractC0790oIM3582b.mo3789a(abstractC0183cM2528a, level, entity, uuid, block, pos)) {
            rightClickBlock.setCanceled(true);
        }
    }
}
