package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.reward.RewardType;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jE.class */
public class C0522jE extends AbstractC0526jI<RewardType> {
    @Override // com.boehmod.blockfront.AbstractC0526jI
    @NotNull
    /* JADX INFO: renamed from: a */
    public Component mo2326a(@NotNull RewardType rewardType) {
        return Component.literal(rewardType.getDescription());
    }
}
