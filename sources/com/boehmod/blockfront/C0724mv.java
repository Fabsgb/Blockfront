package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mv.class */
public final class C0724mv extends C0726mx {

    /* JADX INFO: renamed from: ex */
    private final boolean f4014ex;

    /* JADX INFO: renamed from: ey */
    private final boolean f4015ey;

    /* JADX INFO: renamed from: ez */
    private final boolean f4016ez;

    /* JADX INFO: renamed from: eA */
    private final boolean f4017eA;

    public C0724mv(@NotNull Level level, @NotNull Entity entity, @NotNull ItemStack itemStack, boolean z, boolean z2, boolean z3, boolean z4) {
        super(C1304xr.m7924a(level, C1304xr.f7516a), entity, itemStack);
        this.f4014ex = z;
        this.f4015ey = z2;
        this.f4016ez = z3;
        this.f4017eA = z4;
    }

    /* JADX INFO: renamed from: az */
    public boolean m3338az() {
        return this.f4014ex;
    }

    /* JADX INFO: renamed from: aA */
    public boolean m3339aA() {
        return this.f4015ey;
    }

    /* JADX INFO: renamed from: aB */
    public boolean m3340aB() {
        return this.f4017eA;
    }

    /* JADX INFO: renamed from: aC */
    public boolean m3341aC() {
        return this.f4016ez;
    }

    @NotNull
    public Component getLocalizedDeathMessage(@NotNull LivingEntity livingEntity) {
        ItemStack itemStackC = m3343c();
        Entity entity = getEntity();
        String str = "death.attack.weapon.firearm" + (this.f4015ey ? ".wallbang" : "") + (this.f4014ex ? ".headshot" : "") + (entity != null ? ".entity" : "");
        if (entity != null) {
            return Component.translatable(str, new Object[]{livingEntity.getDisplayName(), entity.getDisplayName(), itemStackC.getDisplayName()});
        }
        return Component.translatable(str, new Object[]{livingEntity.getDisplayName(), itemStackC.getDisplayName()});
    }
}
