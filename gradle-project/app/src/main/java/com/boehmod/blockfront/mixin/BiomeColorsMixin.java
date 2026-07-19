package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0297l;
import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.sY;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/BiomeColorsMixin.class */
@Mixin({BiomeColors.class})
public class BiomeColorsMixin {
    @Inject(method = {"getAverageWaterColor(Lnet/minecraft/world/level/BlockAndTintGetter;Lnet/minecraft/core/BlockPos;)I"}, at = {@At("HEAD")}, cancellable = true)
    private static void bf$overrideWaterColor(BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        oF<?, ?, ?> oFVarM591a;
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null || (oFVarM591a = c0297lB.m591a()) == null) {
            return;
        }
        sY sYVarM767a = oFVarM591a.m767a();
        if (sYVarM767a.bY()) {
            callbackInfoReturnable.setReturnValue(Integer.valueOf(sYVarM767a.bP()));
        }
    }
}
