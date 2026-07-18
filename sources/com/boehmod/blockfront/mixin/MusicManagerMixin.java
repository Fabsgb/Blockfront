package com.boehmod.blockfront.mixin;

import net.minecraft.client.sounds.MusicManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/MusicManagerMixin.class */
@Mixin({MusicManager.class})
public abstract class MusicManagerMixin {
    @Inject(method = {"tick"}, at = {@At("HEAD")}, cancellable = true)
    private void bf$skipMusicTick(CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }
}
