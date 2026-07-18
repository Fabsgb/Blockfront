package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.util.Set;
import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sG.class */
public abstract class AbstractC1000sG {

    /* JADX INFO: renamed from: cH */
    private final String f5276cH = "ttt.randomat." + String.valueOf(UUID.randomUUID());

    /* JADX INFO: renamed from: a */
    public abstract void mo5459a(@NotNull C0994sA c0994sA, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: a */
    public abstract void mo5460a(@NotNull C0994sA c0994sA, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: a */
    public abstract void mo5461a(@NotNull C0994sA c0994sA, @NotNull Level level, @NotNull Set<UUID> set);

    @NotNull
    public abstract String getName();

    @NotNull
    /* JADX INFO: renamed from: p */
    public abstract String mo5462p();

    @NotNull
    /* JADX INFO: renamed from: ak */
    public String m5466ak() {
        return this.f5276cH;
    }
}
