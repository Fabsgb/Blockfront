package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.wU;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/LivingEntityMixin.class */
@Mixin({LivingEntity.class})
public class LivingEntityMixin {
    @ModifyExpressionValue(method = {"handleDamageEvent"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getHurtSound(Lnet/minecraft/world/damagesource/DamageSource;)Lnet/minecraft/sounds/SoundEvent;")})
    private SoundEvent bf$muteBulletHurtSound(SoundEvent soundEvent, DamageSource damageSource) {
        if (damageSource.is(wU.a)) {
            return null;
        }
        return soundEvent;
    }
}
