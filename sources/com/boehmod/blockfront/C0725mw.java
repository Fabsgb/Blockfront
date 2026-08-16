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

/* JADX INFO: renamed from: com.boehmod.blockfront.mw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mw.class */
public final class C0725mw extends C0726mx {

    /* JADX INFO: renamed from: H */
    @NotNull
    private final Vec3 f4018H;

    /* JADX INFO: renamed from: eB */
    private final boolean f4019eB;

    public C0725mw(@NotNull Level level, @Nullable Entity entity, @NotNull ItemStack itemStack, @NotNull Vec3 vec3, boolean z) {
        super(level.damageSources().explosion((Explosion) null).typeHolder(), entity, itemStack);
        this.f4018H = vec3;
        this.f4019eB = z;
    }

    /* JADX INFO: renamed from: aD */
    public boolean m3342aD() {
        return this.f4019eB;
    }

    public Vec3 getSourcePosition() {
        return this.f4018H;
    }

    @NotNull
    public Component getLocalizedDeathMessage(@NotNull LivingEntity livingEntity) {
        if (getDirectEntity() == null) {
            return Component.translatable("death.attack.weapon.grenade", new Object[]{livingEntity.getDisplayName(), m3343c().getDisplayName()});
        }
        return Component.translatable("death.attack.weapon.grenade.entity", new Object[]{livingEntity.getDisplayName(), getDirectEntity().getDisplayName(), m3343c().getDisplayName()});
    }
}
