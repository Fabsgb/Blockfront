package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.og, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/og.class */
public final class C0385og {
    static final /* synthetic */ boolean fG;

    static {
        fG = !C0385og.class.desiredAssertionStatus();
    }

    public static void a(@NotNull BlockEvent.BreakEvent breakEvent) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fG && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Player player = breakEvent.getPlayer();
        UUID uuid = player.getUUID();
        Block block = breakEvent.getLevel().getBlockState(breakEvent.getPos()).getBlock();
        oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
        if (oFVarMo604a != null && !oFVarMo604a.b().a(player, block)) {
            breakEvent.setCanceled(true);
        }
    }

    public static void a(BlockEvent.EntityPlaceEvent entityPlaceEvent) {
        Player entity = entityPlaceEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!fG && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(player.getUUID());
            if (oFVarMo604a != null && !oFVarMo604a.b().b(player, entityPlaceEvent.getLevel().getBlockState(entityPlaceEvent.getPos()).getBlock())) {
                entityPlaceEvent.setCanceled(true);
            }
        }
    }

    public static void b(PlayerInteractEvent.RightClickBlock rightClickBlock) {
        Player entity = rightClickBlock.getEntity();
        Level level = entity.level();
        UUID uuid = entity.getUUID();
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fG && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
        if (oFVarMo604a == null) {
            return;
        }
        BlockPos pos = rightClickBlock.getPos();
        Block block = level.getBlockState(pos).getBlock();
        if (block instanceof AirBlock) {
            return;
        }
        com.boehmod.blockfront.common.player.c<?> cVarM531a = abstractC0264juM166a.m531a();
        oI oIVarB = oFVarMo604a.b();
        if (!oIVarB.a(cVarM531a, level, entity, block, pos) || !oIVarB.a(cVarM531a, level, entity, uuid, block, pos)) {
            rightClickBlock.setCanceled(true);
        }
    }
}
