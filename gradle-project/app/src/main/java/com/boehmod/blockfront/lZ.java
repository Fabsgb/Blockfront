package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lZ.class */
public final class lZ extends C0326mb {
    private final boolean ee;
    private final boolean ef;
    private final boolean eg;
    private final boolean eh;

    public lZ(@NotNull Level level, @NotNull Entity entity, @NotNull ItemStack itemStack, boolean z, boolean z2, boolean z3, boolean z4) {
        super(wU.a(level, wU.a), entity, itemStack);
        this.ee = z;
        this.ef = z2;
        this.eg = z3;
        this.eh = z4;
    }

    public boolean ap() {
        return this.ee;
    }

    public boolean aq() {
        return this.ef;
    }

    public boolean ar() {
        return this.eh;
    }

    public boolean as() {
        return this.eg;
    }

    @NotNull
    public Component getLocalizedDeathMessage(@NotNull LivingEntity livingEntity) {
        ItemStack itemStackA = a();
        Entity entity = getEntity();
        String str = "death.attack.weapon.firearm" + (this.ef ? ".wallbang" : "") + (this.ee ? ".headshot" : "") + (entity != null ? ".entity" : "");
        if (entity != null) {
            return Component.translatable(str, new Object[]{livingEntity.getDisplayName(), entity.getDisplayName(), itemStackA.getDisplayName()});
        }
        return Component.translatable(str, new Object[]{livingEntity.getDisplayName(), itemStackA.getDisplayName()});
    }
}
