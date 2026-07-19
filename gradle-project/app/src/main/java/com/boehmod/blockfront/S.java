package com.boehmod.blockfront;

import com.boehmod.blockfront.vW;
import java.util.Collection;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/S.class */
public interface S<T extends Entity> {
    @NotNull
    Collection<G> a(@NotNull F f, @NotNull vW.a aVar, @NotNull T t, @NotNull R r);

    @NotNull
    ResourceLocation a(@NotNull T t);
}
