package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mb.class */
public class C0326mb extends DamageSource {

    @NotNull
    private final ItemStack d;

    public C0326mb(@NotNull Holder<DamageType> holder, @Nullable Entity entity, @NotNull ItemStack itemStack) {
        super(holder, entity);
        this.d = itemStack;
    }

    @NotNull
    public ItemStack a() {
        return this.d;
    }

    public boolean scalesWithDifficulty() {
        return false;
    }
}
