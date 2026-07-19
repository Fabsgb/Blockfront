package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sG.class */
public abstract class sG {
    private final String cH = "ttt.randomat." + String.valueOf(UUID.randomUUID());

    public abstract void a(@NotNull sA sAVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull Set<UUID> set);

    public abstract void a(@NotNull sA sAVar, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set);

    public abstract void a(@NotNull sA sAVar, @NotNull Level level, @NotNull Set<UUID> set);

    @NotNull
    public abstract String getName();

    @NotNull
    public abstract String p();

    @NotNull
    public String ak() {
        return this.cH;
    }
}
