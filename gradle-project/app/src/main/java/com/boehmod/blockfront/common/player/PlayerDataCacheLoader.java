package com.boehmod.blockfront.common.player;

import com.boehmod.blockfront.common.player.b;
import com.boehmod.blockfront.common.player.c;
import com.google.common.cache.CacheLoader;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/PlayerDataCacheLoader.class */
public abstract class PlayerDataCacheLoader<D extends b<?, ?, ?, ?>, H extends c<D>> extends CacheLoader<UUID, D> {

    @NotNull
    private final H handler;

    public PlayerDataCacheLoader(@NotNull H h) {
        this.handler = h;
    }

    @NotNull
    public D load(@NotNull UUID uuid) throws Exception {
        return (D) this.handler.mo306a(uuid);
    }
}
