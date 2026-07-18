package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mb.class */
public class C0703mb extends DamageSource {

    /* JADX INFO: renamed from: d */
    @NotNull
    private final ItemStack f3762d;

    public C0703mb(@NotNull Holder<DamageType> holder, @Nullable Entity entity, @NotNull ItemStack itemStack) {
        super(holder, entity);
        this.f3762d = itemStack;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ItemStack m3150a() {
        return this.f3762d;
    }

    public boolean scalesWithDifficulty() {
        return false;
    }
}
