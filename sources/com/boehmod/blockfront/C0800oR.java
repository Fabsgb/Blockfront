package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oR.class */
public final class C0800oR {
    /* JADX INFO: renamed from: a */
    public static void m3686a(@NotNull ProjectileImpactEvent projectileImpactEvent) {
        Entity entity = projectileImpactEvent.getEntity();
        if (entity instanceof AbstractC0699mW) {
            BlockHitResult rayTraceResult = projectileImpactEvent.getRayTraceResult();
            if (rayTraceResult instanceof BlockHitResult) {
                BlockHitResult blockHitResult = rayTraceResult;
                Level level = entity.level();
                BlockPos blockPos = blockHitResult.getBlockPos();
                BlockState blockState = level.getBlockState(blockPos);
                Block block = blockState.getBlock();
                if ((block instanceof C0644lU) && !((C0644lU) block).m2911d(entity)) {
                    projectileImpactEvent.setCanceled(true);
                }
                if (blockState.getCollisionShape(level, blockPos) == Shapes.empty()) {
                    projectileImpactEvent.setCanceled(true);
                }
            }
        }
    }
}
