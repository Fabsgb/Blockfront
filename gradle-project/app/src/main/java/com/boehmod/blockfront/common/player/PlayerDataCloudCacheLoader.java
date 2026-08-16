package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.blockfront.AbstractC0531jN;
import com.boehmod.blockfront.C0030a;
import com.boehmod.blockfront.C0551jh;
import com.boehmod.blockfront.C0555jl;
import com.google.common.cache.CacheLoader;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/common/player/PlayerDataCloudCacheLoader.class */
public class PlayerDataCloudCacheLoader extends CacheLoader<UUID, C0555jl> {
    @NotNull
    public C0555jl load(@NotNull UUID uuid) throws Exception {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a != null) {
            C0551jh c0551jhM2472a = abstractC0531jNM179a.m2342b().m2472a();
            c0551jhM2472a.m2492b(RequestType.PLAYER_DATA, uuid);
            c0551jhM2472a.m2492b(RequestType.INVENTORY_MINIMAL, uuid);
        }
        return new C0555jl(uuid);
    }
}
