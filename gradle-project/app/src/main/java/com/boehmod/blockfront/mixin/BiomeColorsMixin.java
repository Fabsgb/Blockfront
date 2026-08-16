package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.C0623l;
import com.boehmod.blockfront.C1096tv;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/BiomeColorsMixin.class */
@Mixin({BiomeColors.class})
public class BiomeColorsMixin {
    @Inject(method = {"getAverageWaterColor(Lnet/minecraft/world/level/BlockAndTintGetter;Lnet/minecraft/core/BlockPos;)I"}, at = {@At("HEAD")}, cancellable = true)
    private static void bf$overrideWaterColor(BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null || (abstractC0863pbM2874a = c0623lM2852b.m2874a()) == null) {
            return;
        }
        C1096tv c1096tvM4089a = abstractC0863pbM2874a.m4089a();
        if (c1096tvM4089a.m6116ci()) {
            callbackInfoReturnable.setReturnValue(Integer.valueOf(c1096tvM4089a.m6117ce()));
        }
    }
}
