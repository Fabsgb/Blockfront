package com.boehmod.blockfront.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationProcessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/AnimationControllerAccessor.class */
@Mixin({AnimationController.class})
public interface AnimationControllerAccessor {
    @Accessor("currentAnimation")
    void setCurrentAnimation(@Nullable AnimationProcessor.QueuedAnimation queuedAnimation);
}
