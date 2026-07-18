package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.reward.ExpRewardType;
import com.boehmod.bflib.cloud.common.reward.ItemRewardType;
import com.boehmod.bflib.cloud.common.reward.RandomItemRewardType;
import com.boehmod.bflib.cloud.common.reward.RewardType;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jq.class */
public final class C0559jq {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final AbstractC0558jp<?> f3177a = new C0554jl();

    /* JADX INFO: renamed from: q */
    @NotNull
    private static final Map<Class<? extends RewardType>, AbstractC0558jp<?>> f3178q = new Object2ObjectOpenHashMap();

    static {
        m2510a(ExpRewardType.class, new C0555jm());
        m2510a(ItemRewardType.class, new C0556jn());
        m2510a(RandomItemRewardType.class, new C0557jo());
    }

    private C0559jq() {
    }

    /* JADX INFO: renamed from: a */
    public static void m2510a(@NotNull Class<? extends RewardType> cls, @NotNull AbstractC0558jp<? extends RewardType> abstractC0558jp) {
        f3178q.put(cls, abstractC0558jp);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static AbstractC0558jp<?> m2511a(@NotNull RewardType rewardType) {
        return f3178q.getOrDefault(rewardType.getClass(), f3177a);
    }
}
