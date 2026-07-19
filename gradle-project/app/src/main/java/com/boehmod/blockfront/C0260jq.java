package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.reward.ExpRewardType;
import com.boehmod.bflib.cloud.common.reward.ItemRewardType;
import com.boehmod.bflib.cloud.common.reward.RandomItemRewardType;
import com.boehmod.bflib.cloud.common.reward.RewardType;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jq.class */
public final class C0260jq {

    @NotNull
    public static final AbstractC0259jp<?> a = new C0255jl();

    @NotNull
    private static final Map<Class<? extends RewardType>, AbstractC0259jp<?>> q = new Object2ObjectOpenHashMap();

    static {
        a(ExpRewardType.class, new C0256jm());
        a(ItemRewardType.class, new C0257jn());
        a(RandomItemRewardType.class, new C0258jo());
    }

    private C0260jq() {
    }

    public static void a(@NotNull Class<? extends RewardType> cls, @NotNull AbstractC0259jp<? extends RewardType> abstractC0259jp) {
        q.put(cls, abstractC0259jp);
    }

    @NotNull
    public static AbstractC0259jp<?> a(@NotNull RewardType rewardType) {
        return q.getOrDefault(rewardType.getClass(), a);
    }
}
