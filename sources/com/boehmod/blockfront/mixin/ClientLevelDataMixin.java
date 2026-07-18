package com.boehmod.blockfront.mixin;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.LevelHeightAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/ClientLevelDataMixin.class */
@Mixin({ClientLevel.ClientLevelData.class})
public class ClientLevelDataMixin {
    @Overwrite
    public double getHorizonHeight(LevelHeightAccessor levelHeightAccessor) {
        return levelHeightAccessor.getMinBuildHeight();
    }
}
