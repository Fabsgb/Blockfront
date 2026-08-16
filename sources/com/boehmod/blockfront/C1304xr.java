package com.boehmod.blockfront;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xr.class */
public final class C1304xr {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final ResourceKey<DamageType> f7516a = ResourceKey.create(Registries.DAMAGE_TYPE, C0532jO.m2378d("bullet"));

    private C1304xr() {
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Holder<DamageType> m7924a(@NotNull Level level, @NotNull ResourceKey<DamageType> resourceKey) {
        return level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(resourceKey);
    }
}
