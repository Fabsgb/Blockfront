package com.boehmod.blockfront.mixin;

import net.minecraft.client.tutorial.Tutorial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/TutorialMixin.class */
@Mixin({Tutorial.class})
public abstract class TutorialMixin {
    @Inject(method = {"tick"}, at = {@At("HEAD")}, cancellable = true)
    private void bf$skipTutorialTick(CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }
}
