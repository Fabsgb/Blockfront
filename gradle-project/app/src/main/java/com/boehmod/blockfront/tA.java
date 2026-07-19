package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tA.class */
public interface tA {
    @OnlyIn(Dist.CLIENT)
    void a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull fT fTVar, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2);
}
