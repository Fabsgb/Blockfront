package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iP.class */
public class C0479iP {

    /* JADX INFO: renamed from: ax */
    public static final String f2938ax = "Default";

    @NotNull
    /* JADX INFO: renamed from: a */
    public static MutableComponent m2173a(@NotNull PlayerGroup playerGroup) {
        return playerGroup.getName().equals(f2938ax) ? Component.empty() : Component.literal(playerGroup.getTag()).withColor(playerGroup.getColor());
    }
}
