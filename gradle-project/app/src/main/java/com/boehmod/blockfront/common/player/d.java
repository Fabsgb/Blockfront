package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.blockfront.AbstractC0264ju;
import com.boehmod.blockfront.C0002a;
import com.google.common.cache.CacheLoader;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/d.class */
public class d extends CacheLoader<UUID, AbstractClanData> {
    static final /* synthetic */ boolean jy;

    static {
        jy = !d.class.desiredAssertionStatus();
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractClanData load(@NotNull UUID uuid) throws Exception {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!jy && abstractC0264juM166a == null) {
            throw new AssertionError("The mod manager is null!");
        }
        abstractC0264juM166a.m529b().m484a().b(RequestType.CLAN_DATA, uuid);
        return new AbstractClanData(uuid, UUID.randomUUID(), "Unknown");
    }
}
