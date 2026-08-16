package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xA.class */
public interface InterfaceC1261xA {
    @NotNull
    /* JADX INFO: renamed from: a */
    List<C0543jZ> mo7124a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AABB aabb, @Nullable LivingEntity livingEntity);

    @Nullable
    /* JADX INFO: renamed from: a */
    C0543jZ mo7125a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, int i, @Nullable LivingEntity livingEntity);
}
