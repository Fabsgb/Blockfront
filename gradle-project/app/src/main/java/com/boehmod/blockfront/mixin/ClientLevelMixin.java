package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0297l;
import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.sY;
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
        oF<?, ?, ?> oFVarM591a;
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null && (oFVarM591a = c0297lB.m591a()) != null) {
            sY sYVarM767a = oFVarM591a.m767a();
            float fAV = sYVarM767a.aV();
            if (fAV <= 0.0f) {
                return vec3;
            }
            int iBO = sYVarM767a.bO();
            if (iBO != bf$cachedSkyColorRgb) {
                bf$cachedSkyColorR = ((double) ((iBO >> 16) & 255)) / 255.0d;
                bf$cachedSkyColorG = ((double) ((iBO >> 8) & 255)) / 255.0d;
                bf$cachedSkyColorB = ((double) (iBO & 255)) / 255.0d;
                bf$cachedSkyColorRgb = iBO;
            }
            return new Vec3(Mth.lerp(fAV, vec3.x, bf$cachedSkyColorR), Mth.lerp(fAV, vec3.y, bf$cachedSkyColorG), Mth.lerp(fAV, vec3.z, bf$cachedSkyColorB));
        }
        return vec3;
    }
}
