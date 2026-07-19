package com.boehmod.blockfront;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wU.class */
public final class wU {

    @NotNull
    public static final ResourceKey<DamageType> a = ResourceKey.create(Registries.DAMAGE_TYPE, C0265jv.d("bullet"));

    private wU() {
    }

    @NotNull
    public static Holder<DamageType> a(@NotNull Level level, @NotNull ResourceKey<DamageType> resourceKey) {
        return level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(resourceKey);
    }
}
