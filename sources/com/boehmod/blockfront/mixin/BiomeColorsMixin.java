package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.C0622l;
import com.boehmod.blockfront.C1018sY;
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
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null || (abstractC0787oFM2688a = c0622lM2667b.m2688a()) == null) {
            return;
        }
        C1018sY c1018sYM3653a = abstractC0787oFM2688a.m3653a();
        if (c1018sYM3653a.m5628bY()) {
            callbackInfoReturnable.setReturnValue(Integer.valueOf(c1018sYM3653a.m5629bP()));
        }
    }
}
