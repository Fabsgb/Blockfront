package com.boehmod.blockfront;

import java.util.Iterator;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oA.class */
public final class C0782oA {

    /* JADX INFO: renamed from: mo */
    public static final int f4196mo = 3;

    /* JADX INFO: renamed from: a */
    public static void m3548a(@NotNull Level level, @NotNull Vec3 vec3, double d, @NotNull DataComponentType<Integer> dataComponentType, double d2) {
        Iterator it = level.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(vec3, 1.0d, 1.0d, 1.0d).inflate(d)).iterator();
        while (it.hasNext()) {
            ItemStack mainHandItem = ((LivingEntity) it.next()).getMainHandItem();
            if ((mainHandItem.getItem() instanceof AbstractC1062tO) && level.random.nextDouble() < d2) {
                mainHandItem.set(dataComponentType, Integer.valueOf(Math.min(((Integer) mainHandItem.getOrDefault(dataComponentType, 0)).intValue() + 1, 3)));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3549a(@NotNull ItemStack itemStack, @NotNull DataComponentType<Integer> dataComponentType, int i) {
        if (i <= 0 || !(itemStack.getItem() instanceof AbstractC1062tO)) {
            return;
        }
        itemStack.set(dataComponentType, Integer.valueOf(Math.min(((Integer) itemStack.getOrDefault(dataComponentType, 0)).intValue() + i, 3)));
    }
}
