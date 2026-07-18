package com.boehmod.blockfront;

import com.mojang.serialization.Lifecycle;
import net.minecraft.core.Holder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bS.class */
public class C0101bS<T> extends MappedRegistry<T> {
    public C0101bS(@NotNull ResourceKey<? extends Registry<T>> resourceKey) {
        super(resourceKey, Lifecycle.stable());
    }

    public Holder.Reference<T> getHolderOrThrow(@NotNull ResourceKey<T> resourceKey) {
        return null;
    }
}
