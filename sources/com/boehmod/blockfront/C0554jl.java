package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.reward.RewardType;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jl.class */
public class C0554jl extends AbstractC0558jp<RewardType> {
    @Override // com.boehmod.blockfront.AbstractC0558jp
    @NotNull
    /* JADX INFO: renamed from: a */
    public Component mo2506a(@NotNull RewardType rewardType) {
        return Component.literal(rewardType.getDescription());
    }
}
