package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iP.class */
public class iP {
    public static final String ax = "Default";

    @NotNull
    public static MutableComponent a(@NotNull PlayerGroup playerGroup) {
        return playerGroup.getName().equals(ax) ? Component.empty() : Component.literal(playerGroup.getTag()).withColor(playerGroup.getColor());
    }
}
