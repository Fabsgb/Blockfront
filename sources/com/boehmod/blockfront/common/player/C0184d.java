package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.blockfront.AbstractC0563ju;
import com.boehmod.blockfront.C0029a;
import com.google.common.cache.CacheLoader;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.common.player.d */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/d.class */
public class C0184d extends CacheLoader<UUID, AbstractClanData> {

    /* JADX INFO: renamed from: jy */
    static final /* synthetic */ boolean f1521jy;

    static {
        f1521jy = !C0184d.class.desiredAssertionStatus();
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractClanData load(@NotNull UUID uuid) throws Exception {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f1521jy && abstractC0563juM168a == null) {
            throw new AssertionError("The mod manager is null!");
        }
        abstractC0563juM168a.m2520b().m2145a().m2165b(RequestType.CLAN_DATA, uuid);
        return new AbstractClanData(uuid, UUID.randomUUID(), "Unknown");
    }
}
