package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qP.class */
public interface qP {
    boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull lQ lQVar);

    void a(@NotNull lQ lQVar);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    int mo921a(@NotNull lQ lQVar);
}
