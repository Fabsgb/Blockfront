package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ji */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ji.class */
public class C0552ji {

    /* JADX INFO: renamed from: aD */
    public static final String f3289aD = "Default";

    @NotNull
    /* JADX INFO: renamed from: a */
    public static MutableComponent m2500a(@NotNull PlayerGroup playerGroup) {
        return playerGroup.getName().equals(f3289aD) ? Component.empty() : Component.literal(playerGroup.getTag()).withColor(playerGroup.getColor());
    }
}
