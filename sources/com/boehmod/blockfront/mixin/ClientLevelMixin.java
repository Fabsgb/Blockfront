package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.C0622l;
import com.boehmod.blockfront.C1018sY;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/ClientLevelMixin.class */
@Mixin({ClientLevel.class})
public class ClientLevelMixin {
    private static int bf$cachedSkyColorRgb = -1;
    private static double bf$cachedSkyColorR;
    private static double bf$cachedSkyColorG;
    private static double bf$cachedSkyColorB;

    @ModifyExpressionValue(method = {"getSkyColor(Lnet/minecraft/world/phys/Vec3;F)Lnet/minecraft/world/phys/Vec3;"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/util/CubicSampler;gaussianSampleVec3(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/util/CubicSampler$Vec3Fetcher;)Lnet/minecraft/world/phys/Vec3;")})
    private Vec3 bf$overrideSkyColor(Vec3 vec3) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null && (abstractC0787oFM2688a = c0622lM2667b.m2688a()) != null) {
            C1018sY c1018sYM3653a = abstractC0787oFM2688a.m3653a();
            float fM5626aV = c1018sYM3653a.m5626aV();
            if (fM5626aV <= 0.0f) {
                return vec3;
            }
            int iM5625bO = c1018sYM3653a.m5625bO();
            if (iM5625bO != bf$cachedSkyColorRgb) {
                bf$cachedSkyColorR = ((double) ((iM5625bO >> 16) & 255)) / 255.0d;
                bf$cachedSkyColorG = ((double) ((iM5625bO >> 8) & 255)) / 255.0d;
                bf$cachedSkyColorB = ((double) (iM5625bO & 255)) / 255.0d;
                bf$cachedSkyColorRgb = iM5625bO;
            }
            return new Vec3(Mth.lerp(fM5626aV, vec3.x, bf$cachedSkyColorR), Mth.lerp(fM5626aV, vec3.y, bf$cachedSkyColorG), Mth.lerp(fM5626aV, vec3.z, bf$cachedSkyColorB));
        }
        return vec3;
    }
}
