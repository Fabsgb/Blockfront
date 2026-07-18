package com.boehmod.blockfront.common.player;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import com.google.common.cache.CacheLoader;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/PlayerDataCacheLoader.class */
public abstract class PlayerDataCacheLoader<D extends AbstractC0182b<?, ?, ?, ?>, H extends AbstractC0183c<D>> extends CacheLoader<UUID, D> {

    @NotNull
    private final H handler;

    public PlayerDataCacheLoader(@NotNull H h) {
        this.handler = h;
    }

    @NotNull
    public D load(@NotNull UUID uuid) throws Exception {
        return (D) this.handler.mo1137a(uuid);
    }
}
