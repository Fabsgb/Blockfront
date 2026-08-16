package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.blockfront.AbstractC0531jN;
import com.boehmod.blockfront.C0030a;
import com.google.common.cache.CacheLoader;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.common.player.d */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/common/player/d.class */
public class C0185d extends CacheLoader<UUID, AbstractClanData> {

    /* JADX INFO: renamed from: jO */
    static final /* synthetic */ boolean f1443jO;

    static {
        f1443jO = !C0185d.class.desiredAssertionStatus();
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractClanData load(@NotNull UUID uuid) throws Exception {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f1443jO && abstractC0531jNM179a == null) {
            throw new AssertionError("The mod manager is null!");
        }
        abstractC0531jNM179a.m2342b().m2472a().m2492b(RequestType.CLAN_DATA, uuid);
        return new AbstractClanData(uuid, UUID.randomUUID(), "Unknown");
    }
}
