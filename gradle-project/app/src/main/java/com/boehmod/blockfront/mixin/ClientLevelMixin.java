package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.C0623l;
import com.boehmod.blockfront.C1096tv;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/ClientLevelMixin.class */
@Mixin({ClientLevel.class})
public class ClientLevelMixin {
    private static int bf$cachedSkyColorRgb = -1;
    private static double bf$cachedSkyColorR;
    private static double bf$cachedSkyColorG;
    private static double bf$cachedSkyColorB;

    @ModifyExpressionValue(method = {"getSkyColor(Lnet/minecraft/world/phys/Vec3;F)Lnet/minecraft/world/phys/Vec3;"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/util/CubicSampler;gaussianSampleVec3(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/util/CubicSampler$Vec3Fetcher;)Lnet/minecraft/world/phys/Vec3;")})
    private Vec3 bf$overrideSkyColor(Vec3 vec3) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null && (abstractC0863pbM2874a = c0623lM2852b.m2874a()) != null) {
            C1096tv c1096tvM4089a = abstractC0863pbM2874a.m4089a();
            float fM6114bb = c1096tvM4089a.m6114bb();
            if (fM6114bb <= 0.0f) {
                return vec3;
            }
            int iM6113cd = c1096tvM4089a.m6113cd();
            if (iM6113cd != bf$cachedSkyColorRgb) {
                bf$cachedSkyColorR = ((double) ((iM6113cd >> 16) & 255)) / 255.0d;
                bf$cachedSkyColorG = ((double) ((iM6113cd >> 8) & 255)) / 255.0d;
                bf$cachedSkyColorB = ((double) (iM6113cd & 255)) / 255.0d;
                bf$cachedSkyColorRgb = iM6113cd;
            }
            return new Vec3(Mth.lerp(fM6114bb, vec3.x, bf$cachedSkyColorR), Mth.lerp(fM6114bb, vec3.y, bf$cachedSkyColorG), Mth.lerp(fM6114bb, vec3.z, bf$cachedSkyColorB));
        }
        return vec3;
    }
}
