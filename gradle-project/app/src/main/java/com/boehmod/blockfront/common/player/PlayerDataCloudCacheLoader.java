package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.blockfront.AbstractC0264ju;
import com.boehmod.blockfront.C0002a;
import com.boehmod.blockfront.iO;
import com.boehmod.blockfront.iS;
import com.google.common.cache.CacheLoader;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/PlayerDataCloudCacheLoader.class */
public class PlayerDataCloudCacheLoader extends CacheLoader<UUID, iS> {
    @NotNull
    public iS load(@NotNull UUID uuid) throws Exception {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a != null) {
            iO iOVarM484a = abstractC0264juM166a.m529b().m484a();
            iOVarM484a.b(RequestType.PLAYER_DATA, uuid);
            iOVarM484a.b(RequestType.INVENTORY_MINIMAL, uuid);
        }
        return new iS(uuid);
    }
}
