package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.blockfront.AbstractC0563ju;
import com.boehmod.blockfront.C0029a;
import com.boehmod.blockfront.C0478iO;
import com.boehmod.blockfront.C0482iS;
import com.google.common.cache.CacheLoader;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/PlayerDataCloudCacheLoader.class */
public class PlayerDataCloudCacheLoader extends CacheLoader<UUID, C0482iS> {
    @NotNull
    public C0482iS load(@NotNull UUID uuid) throws Exception {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a != null) {
            C0478iO c0478iOM2145a = abstractC0563juM168a.m2520b().m2145a();
            c0478iOM2145a.m2165b(RequestType.PLAYER_DATA, uuid);
            c0478iOM2145a.m2165b(RequestType.INVENTORY_MINIMAL, uuid);
        }
        return new C0482iS(uuid);
    }
}
