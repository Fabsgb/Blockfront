package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xd.class */
public interface InterfaceC0625xd {
    @NotNull
    List<jG> a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull AABB aabb, @Nullable LivingEntity livingEntity);

    @Nullable
    jG a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, int i, @Nullable LivingEntity livingEntity);
}
