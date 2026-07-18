package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ma */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ma.class */
public final class C0702ma extends C0703mb {

    /* JADX INFO: renamed from: G */
    @NotNull
    private final Vec3 f3761G;

    public C0702ma(@NotNull Level level, @Nullable Entity entity, @NotNull ItemStack itemStack, @NotNull Vec3 vec3) {
        super(level.damageSources().explosion((Explosion) null).typeHolder(), entity, itemStack);
        this.f3761G = vec3;
    }

    public Vec3 getSourcePosition() {
        return this.f3761G;
    }

    @NotNull
    public Component getLocalizedDeathMessage(@NotNull LivingEntity livingEntity) {
        if (getDirectEntity() == null) {
            return Component.translatable("death.attack.weapon.grenade", new Object[]{livingEntity.getDisplayName(), m3150a().getDisplayName()});
        }
        return Component.translatable("death.attack.weapon.grenade.entity", new Object[]{livingEntity.getDisplayName(), getDirectEntity().getDisplayName(), m3150a().getDisplayName()});
    }
}
