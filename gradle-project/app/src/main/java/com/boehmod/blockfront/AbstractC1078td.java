package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.util.Set;
import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.td */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/td.class */
public abstract class AbstractC1078td {

    /* JADX INFO: renamed from: cR */
    private final String f5840cR = "ttt.randomat." + String.valueOf(UUID.randomUUID());

    /* JADX INFO: renamed from: a */
    public abstract void mo5947a(@NotNull C1018sX c1018sX, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: a */
    public abstract void mo5948a(@NotNull C1018sX c1018sX, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: a */
    public abstract void mo5949a(@NotNull C1018sX c1018sX, @NotNull Level level, @NotNull Set<UUID> set);

    @NotNull
    public abstract String getName();

    @NotNull
    /* JADX INFO: renamed from: t */
    public abstract String mo5950t();

    @NotNull
    /* JADX INFO: renamed from: ar */
    public String m5954ar() {
        return this.f5840cR;
    }
}
