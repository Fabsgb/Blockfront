package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.reward.ExpRewardType;
import com.boehmod.bflib.cloud.common.reward.ItemRewardType;
import com.boehmod.bflib.cloud.common.reward.RandomItemRewardType;
import com.boehmod.bflib.cloud.common.reward.RewardType;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jJ.class */
public final class C0527jJ {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final AbstractC0526jI<?> f3160a = new C0522jE();

    /* JADX INFO: renamed from: q */
    @NotNull
    private static final Map<Class<? extends RewardType>, AbstractC0526jI<?>> f3161q = new Object2ObjectOpenHashMap();

    static {
        m2330a(ExpRewardType.class, new C0523jF());
        m2330a(ItemRewardType.class, new C0524jG());
        m2330a(RandomItemRewardType.class, new C0525jH());
    }

    private C0527jJ() {
    }

    /* JADX INFO: renamed from: a */
    public static void m2330a(@NotNull Class<? extends RewardType> cls, @NotNull AbstractC0526jI<? extends RewardType> abstractC0526jI) {
        f3161q.put(cls, abstractC0526jI);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static AbstractC0526jI<?> m2331a(@NotNull RewardType rewardType) {
        return f3161q.getOrDefault(rewardType.getClass(), f3160a);
    }
}
