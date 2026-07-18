package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lZ.class */
public final class C0648lZ extends C0703mb {

    /* JADX INFO: renamed from: ee */
    private final boolean f3540ee;

    /* JADX INFO: renamed from: ef */
    private final boolean f3541ef;

    /* JADX INFO: renamed from: eg */
    private final boolean f3542eg;

    /* JADX INFO: renamed from: eh */
    private final boolean f3543eh;

    public C0648lZ(@NotNull Level level, @NotNull Entity entity, @NotNull ItemStack itemStack, boolean z, boolean z2, boolean z3, boolean z4) {
        super(C1227wU.m7335a(level, C1227wU.f6953a), entity, itemStack);
        this.f3540ee = z;
        this.f3541ef = z2;
        this.f3542eg = z3;
        this.f3543eh = z4;
    }

    /* JADX INFO: renamed from: ap */
    public boolean m2907ap() {
        return this.f3540ee;
    }

    /* JADX INFO: renamed from: aq */
    public boolean m2908aq() {
        return this.f3541ef;
    }

    /* JADX INFO: renamed from: ar */
    public boolean m2909ar() {
        return this.f3543eh;
    }

    /* JADX INFO: renamed from: as */
    public boolean m2910as() {
        return this.f3542eg;
    }

    @NotNull
    public Component getLocalizedDeathMessage(@NotNull LivingEntity livingEntity) {
        ItemStack itemStackA = m3150a();
        Entity entity = getEntity();
        String str = "death.attack.weapon.firearm" + (this.f3541ef ? ".wallbang" : "") + (this.f3540ee ? ".headshot" : "") + (entity != null ? ".entity" : "");
        if (entity != null) {
            return Component.translatable(str, new Object[]{livingEntity.getDisplayName(), entity.getDisplayName(), itemStackA.getDisplayName()});
        }
        return Component.translatable(str, new Object[]{livingEntity.getDisplayName(), itemStackA.getDisplayName()});
    }
}
