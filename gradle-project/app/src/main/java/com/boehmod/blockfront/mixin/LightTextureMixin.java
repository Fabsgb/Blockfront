package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0297l;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.renderer.LightTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/LightTextureMixin.class */
@Mixin({LightTexture.class})
public class LightTextureMixin {
    private static final double BF_MAX_GAMMA = 1.0d;

    @ModifyExpressionValue(method = {"updateLightTexture(F)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/OptionInstance;get()Ljava/lang/Object;")}, slice = {@Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/client/Options;gamma()Lnet/minecraft/client/OptionInstance;"))})
    private Object bf$clampGammaInMatch(Object obj) {
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null && c0297lB.m591a() != null) {
            if ((obj instanceof Double) && ((Double) obj).doubleValue() > 1.0d) {
                return Double.valueOf(1.0d);
            }
            return obj;
        }
        return obj;
    }
}
