package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.reward.RewardType;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jl.class */
public class C0255jl extends AbstractC0259jp<RewardType> {
    @Override // com.boehmod.blockfront.AbstractC0259jp
    @NotNull
    public Component a(@NotNull RewardType rewardType) {
        return Component.literal(rewardType.getDescription());
    }
}
